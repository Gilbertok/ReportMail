package br.com.marlan.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.marlan.dao.PedidoDao;
import br.com.marlan.dao.PedidoItemDao;
import br.com.marlan.dao.PedidoMailDao;
import br.com.marlan.model.MailPedidoItem;

public class MailUtil {

	private HtmlEmail email = null;

	public MailUtil(PedidoMailDao pedido) throws Exception {
		email = new HtmlEmail();
		email.setHostName("10.100.1.133");
		email.addTo("informatica03@marlan.com.br", pedido.getCliente().getFantasia());
		email.setFrom(pedido.getRepresentante().getEmail(), pedido.getRepresentante().getNomeRepresentante());
		email.setSubject("Pedido Grupo Marlan: "+ pedido.getNrPedido());
		String templateHtml = this.getTemplateHtml();
		templateHtml = this.preencheDadosPedido(templateHtml, pedido);
		email.setHtmlMsg(templateHtml);
	}

	private String addItens(PedidoMailDao pedido) {
		Map<String, MailPedidoItem> itens = this.getMailItens(pedido.getItens());
		
		StringBuilder templateItens = new StringBuilder();
		templateItens.append("<style> table td { border: 1px groove; border-color: #d0d0d0; border-collapse: collapse; font-size: 10px; } </style>");
		templateItens.append("<style> table th { border: 1px groove; border-color: #d0d0d0; border-collapse: collapse; font-size: 10px; } </style>");
		templateItens.append("<tr>");
		templateItens.append("<table border='0' style='width: 100%;'>");
		templateItens.append("<tr>");
		templateItens.append("<th>Referência</th>");
		templateItens.append("<th>Descrição</th>");
		templateItens.append("<th>Peças</th>");
		templateItens.append("</tr>");
		
		for (String chave : itens.keySet()) {
			MailPedidoItem item = itens.get(chave);
			String templateItem = new String();
			templateItem = "<tr>"
						+"<td>"+item.getReferencia()+"</td>"
						+"<td>"+item.getDescricao()+"</td>"
						+"<td>"+this.getTemplateTamanhoCor(item)+"</td>"
						+"</tr>";
			templateItens.append(templateItem);
		}
		
		templateItens.append("</table></tr>");
		return templateItens.toString();
	}

	private String getTemplateTamanhoCor(MailPedidoItem item) {
		StringBuilder templateTamanhoCor = new StringBuilder();
		Map<String, String> templateQtdeTamanho = new HashMap<String, String>();
		templateTamanhoCor.append("<table border='0' style='width: 100%;'>");
		templateTamanhoCor.append("<tr>");
		templateTamanhoCor.append("<th>Cor/Tamanho</th>");
		for(String chaveTamanho : item.getTamanhos().keySet()) {
			templateTamanhoCor.append("<th>"+item.getTamanhos().get(chaveTamanho)+"</th>");
			for(String chaveCor : item.getCores().keySet()) {
				templateQtdeTamanho.put(this.getChaveTamanhoCor(chaveTamanho, chaveCor),"<td>"+this.getQtdeChaveQtde(item.getQtdeTamanhosCores(), chaveTamanho, chaveCor)+"</td>");
			}
		}
		templateTamanhoCor.append("<th>Total</th>");
		templateTamanhoCor.append("</tr>");
		for(String chaveCor : item.getCores().keySet()) {
			templateTamanhoCor.append("<tr>");
			templateTamanhoCor.append("<td>"+item.getCores().get(chaveCor)+"</td>");
			for(String chaveTamanho : item.getTamanhos().keySet()) {
				templateTamanhoCor.append(templateQtdeTamanho.get(this.getChaveTamanhoCor(chaveTamanho, chaveCor)));
			}
			templateTamanhoCor.append("<td>"+item.getQtdeCores().get(chaveCor)+"</td>");
			templateTamanhoCor.append("</tr>");
		}
//		valor total
		templateTamanhoCor.append("<tr>");
		templateTamanhoCor.append("<td>Valor Totais.</td>");
		Double valorTotalPedido = new Double(0);
		for(String chaveTamanho : item.getTamanhos().keySet()) {
			Double valorTamanho = item.getQtdeTamanhos().get(chaveTamanho) * item.getValorTamanhos().get(chaveTamanho);
			templateTamanhoCor.append("<td>"+ this.moeda(valorTamanho) +"</td>");
			valorTotalPedido = valorTotalPedido + valorTamanho;
		}
		templateTamanhoCor.append("<td>"+ this.moeda(valorTotalPedido) +"</td>");
		templateTamanhoCor.append("</tr>");
//		valor unitario
		templateTamanhoCor.append("<tr>");
		templateTamanhoCor.append("<td>Valor Unit.</td>");
		for(String chaveTamanho : item.getTamanhos().keySet()) {
			templateTamanhoCor.append("<td>"+item.getValorTamanhos().get(chaveTamanho)+"</td>");
		}
		templateTamanhoCor.append("</tr>");
		
		templateTamanhoCor.append("</table>");
		return templateTamanhoCor.toString();
	}

	private Integer getQtdeChaveQtde(Map<String, Integer> qtdeTamanhosCores, String chaveTamanho, String chaveCor) {
		if(qtdeTamanhosCores.containsKey(this.getChaveTamanhoCor(chaveTamanho, chaveCor))) {
			return qtdeTamanhosCores.get(this.getChaveTamanhoCor(chaveTamanho, chaveCor));
		}
		return 0;
	}
	
	private Map<String, MailPedidoItem> getMailItens(List<PedidoItemDao> itens) {
		Map<String, MailPedidoItem> mailItens = new HashMap<String, MailPedidoItem>();
		for (PedidoItemDao item : itens) {
			Map<String, String> cores = new TreeMap<String, String>();
			Map<String, String> tamanhos = new TreeMap<String, String>();
			Map<String, Integer> qtdeTamanhosCores = new TreeMap<String, Integer>();
			Map<String, Integer> qtdeCores = new TreeMap<String, Integer>();
			Map<String, Integer> qtdeTamanhos = new TreeMap<String, Integer>();
			Map<String, Double> valorTamanhos = new TreeMap<String, Double>();
			MailPedidoItem mail = new MailPedidoItem();
			
			if (mailItens.containsKey(item.getReferencia())) {
				mail = mailItens.get(item.getReferencia());
				cores = mail.getCores();
				tamanhos = mail.getTamanhos();
				qtdeTamanhosCores = mail.getQtdeTamanhosCores();
				valorTamanhos = mail.getValorTamanhos();
				qtdeCores = mail.getQtdeCores();
				qtdeTamanhos = mail.getQtdeTamanhos();
				
				if (!mail.getQtdeTamanhosCores().containsKey(this.getChaveTamanhoCor(item))) {
					qtdeTamanhosCores.put(this.getChaveTamanhoCor(item), item.getQuantidade());
				} 
				if (!mail.getTamanhos().containsKey(item.getTamanho())) {
					String chave = item.getTamanho();
					tamanhos.put(chave, item.getTamanhoNome());
					valorTamanhos.put(chave, item.getValorUnitario());
					qtdeTamanhos.put(chave, item.getQuantidade());
				} else {
					qtdeTamanhos.put(item.getTamanho(), qtdeTamanhos.get(item.getTamanho()) + item.getQuantidade());
				}
				if (!mail.getCores().containsKey(item.getCor())) {
					String chave = item.getCor();
					cores.put(chave, item.getCor()+"-"+item.getCorNome());
					qtdeCores.put(chave, item.getQuantidade());
				} else {
					qtdeCores.put(item.getCor(), qtdeCores.get(item.getCor()) + item.getQuantidade());
				}
				mail.setValorTotal(mail.getValorTotal() + (item.getValorUnitario()*item.getQuantidade()));
			} else {
				cores.put(item.getCor(), item.getCor()+"-"+item.getCorNome());
				tamanhos.put(item.getTamanho(), item.getTamanhoNome());
				qtdeCores.put(item.getCor(), item.getQuantidade());
				qtdeTamanhos.put(item.getTamanho(), item.getQuantidade());
				qtdeTamanhosCores.put(this.getChaveTamanhoCor(item), item.getQuantidade());
				valorTamanhos.put(item.getTamanho(), item.getValorUnitario());
				
				mail.setReferencia(item.getReferencia());
				mail.setDescricao(item.getDescricao());
				mail.setValorTotal(item.getValorUnitario()*item.getQuantidade());
			}
			mail.setCores(cores);
			mail.setTamanhos(tamanhos);
			mail.setValorTamanhos(valorTamanhos);
			mail.setQtdeCores(qtdeCores);
			mail.setQtdeTamanhos(qtdeTamanhos);;
			mail.setQtdeTamanhosCores(qtdeTamanhosCores);
			mailItens.put(item.getReferencia(), mail);
		}
		return mailItens;
	}

	private String preencheDadosPedido(String templateHtml, PedidoMailDao pedido) {
		templateHtml = templateHtml.replaceAll("#NUMERO_PEDIDO", pedido.getNrPedido().toString())
				.replaceAll("#SITUACAO_PEDIDO", pedido.getPedido().getSituacaoVenda())
				.replaceAll("#DATA_EMISSAO", this.data(pedido.getPedido().getDataEmissao()))
				.replaceAll("#TABELA_PRECO", pedido.getPedido().getTabelaPreco().getCodigoTabela()+"-"+pedido.getPedido().getTabelaPreco().getDescricao())
				.replaceAll("#REPRESENTANTE", pedido.getRepresentante().getNomeRepresentante())
				.replaceAll("#ACEITA_ANTECIPACAO", this.getSimNao(pedido.getPedido().getAceitaAntecipacao()))
				.replaceAll("#CONDICAO_PAGAMENTO", pedido.getPedido().getCodCondPagto()+"."+pedido.getPedido().getCondicaoPagto().getDescricao())
				.replaceAll("#ACEITA_PED_PARCIAL", this.getSimNao(pedido.getPedido().getAceitaParcial()))
				.replaceAll("#DATA_ENTR_VENDA", this.data(pedido.getPedido().getDataEntradaPedido()))
				.replaceAll("#CNPJ", pedido.getCliente().getCpfCNPJ())
				.replaceAll("#RAZAO_SOCIAL", pedido.getCliente().getRazaoSocial())
				.replaceAll("#FANTASIA", pedido.getCliente().getFantasia())
				.replaceAll("#BAIRRO", pedido.getCliente().getBairro())
				.replaceAll("#CIDADE", pedido.getCliente().getCidade().getCidade())
				.replaceAll("#RUA", pedido.getCliente().getLogradouro())
				.replaceAll("#COMPLEMENTO", pedido.getCliente().getComplemento())
				.replaceAll("#TELEFONE", pedido.getCliente().getTelefone())
				.replaceAll("#EMAIL", pedido.getCliente().getEmailNFE())
				.replaceAll("#QTDE_REF", pedido.getPedido().getQuantidadeReferencias().toString())
				.replaceAll("#VLR_BRUTO", this.moeda(pedido.getPedido().getValorTotalPedido()))
				.replaceAll("#VLR_LIQUIDO", this.moeda(pedido.getPedido().getValorLiquido()))
				.replaceAll("#TOTAL_DESCONTO", this.getDesconto(pedido.getPedido()))
				.replaceAll("#QTDE_PECAS", pedido.getPedido().getQuantidadePecas().toString())
				.replaceAll("#ITENS", this.addItens(pedido));
		return templateHtml;
	}
	
	private String getDesconto(PedidoDao pedido) {
		StringBuilder descDesconto = new StringBuilder();
		if (pedido.getDescontoItem1() > 0) {
			descDesconto.append(this.perc(pedido.getDescontoItem1())).append("% - ");
		} else {
			descDesconto.append("0% - ");
		}
		if (pedido.getDescontoItem2() > 0) {
			descDesconto.append(this.perc(pedido.getDescontoItem2())).append("% - ");
		} else {
			descDesconto.append("0% - ");
		}
		if (pedido.getDescontoItem3() > 0) {
			descDesconto.append(this.perc(pedido.getDescontoItem3())).append("%");
		} else {
			descDesconto.append(" 0%");
		}
		descDesconto.append("  (").append(this.perc(pedido.getTotalDescontoItens())).append("%)");
		return descDesconto.toString();
	}

	private String getSimNao(Integer condicao) {
		if(condicao.equals(1)) {
			return "Sim";
		} else {
			return "Não";
		}
	}
	
	private String moeda(Double valor) {
		NumberFormat nf = new DecimalFormat("###,##0.00");
		return nf.format(valor);
	}
	
	private String perc(Double valor) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(0);
		return decimalFormat.format(valor);
	}
	
	private String data(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(data);
	}
	
	
	private String getChaveTamanhoCor(PedidoItemDao item) {
		return getChaveTamanhoCor(item.getTamanho(), item.getCor());
	}
	
	private String getChaveTamanhoCor(String tamanho, String cor) {
		return tamanho+"."+cor;
	}

	public void enviar() throws EmailException {
		email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
		email.send();
	}

	private String getTemplateHtml() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("resources/email_pedidos.html"));
		StringBuilder builder = new StringBuilder();
		String line = "";
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		reader.close();
		return builder.toString();
	}

}
