package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDao extends Dao {
	
//	ANA_COMERCIAL_COMISSAO
//	ANA_COMERCIAL_CONCESSAO_DESC
//	ANA_COMERCIAL_OBS
//	ANA_COMERCIAL_PRAZO
//	BLOQUEIO_ROLO
//	BONUS_COMISSAO
//	CALCULO_COMISSAO
//	CIDADE_CIF
//	CLASSIFICACAO_PEDIDO
//	CLI2RESPTIT
//	CLI4RESPTIT
//	CLI9RESPTIT
//	COD_BANCO
//	COD_CANCELAMENTO
//	COD_CATALOGO
//	COD_FORMA_PAGTO
//	COD_FUNCIONARIO
//	CODIGO_ADMINISTR
//	CODIGO_EMPRESA
//	CODIGO_MOEDA
//	CODIGO_VENDEDOR
//	COD_LOCAL
//	COD_NEGOCIACAO
//	COD_PED_CLIENTE
//	COD_PREPOSTO
//	COD_TIPO_EMBALAGEM
//	COD_VIA_TRANSP
//	COLECAO
//	COLETA_CAIXA_ABERTA
//	COLETA_GERADA
//	COLETOR
//	COM_CRITERIO_EMPENHADO
//	COMISSAO_ADMINISTR
//	CONTROLE
//	CRITERIO_PEDIDO
//	CRITERIO_QUALIDADE
//	DATA_BASE_FATUR
//	DATA_CANC_VENDA
//	DATA_ENTR_INTERNA
//	DATA_ENTR_PLAN
//	DATA_HORA_DISTRIBUICAO
//	DATA_LIBERACAO
//	DATA_LIBER_EXPED
//	DATA_ORIGINAL_ENTREGA
//	DATA_PREV_RECEB
//	DATA_SUGESTAO
//	DESC_COMP_ANTECIPADA
//	DESC_COMP_MIX
//	DESC_CRESC_VENDA
//	DESC_FINANCEIRO
//	DESC_GER_EXTRA
//	DESCONTO_ESPECIAL
//	DESCONTO_EXTRA
//	DESCONTO1
//	DESCONTO2
//	DESCONTO3
//	DESC_PRZ_EXTRA
//	DESC_VOLUME
//	ENCARGOS
//	ESPECIFICAR_REQUISITO
//	EXECUTA_TRIGGER
//	EXIGENCIA_REQUISITO_AMBIENTAL
//	EXPEDIDOR
//	FATURA_COMERCIAL
//	FLAG_MARCADO
//	FRETE_VENDA
//	HORA_LIBER_EXPED
//	ID_PEDIDO_FORCA_VENDAS
//	INCOTERM
//	IND_COLETADO_CEM_PORCENTO
//	LIBERADO_COLETAR
//	LIBERADO_FATURAR
//	LIQUIDA_SALDO_PEDIDO
//	MARCA_LIBERA
//	NATOP_PV_EST_OPER
//	NATOP_PV_NAT_OPER
//	NOME_COLETOR
//	NOME_PREPOSTO
//	NR_AUTORIZACAO_OPERA
//	NR_SOLICITACAO
//	NR_SUGESTAO
//	NUM_COMPRA
//	NUMERO_CARGA
//	NUMERO_CONTROLE
//	NUMERO_SEMANA
//	NUM_PERIODO_PROD
//	OBS_COLETA
//	OBS_LISTA_CONTEUDO_1
//	OBS_LISTA_CONTEUDO_2
//	OBS_LISTA_CONTEUDO_3
//	OBS_NOTA_FISCAL
//	OBS_PRODUCAO
//	ORIGEM_PEDIDO
//	PEDIDO_IMPRESSO
//	PEDIDO_OPERATIVO
//	PEDIDO_ORIGEM_DESDOBR
//	PEDIDO_SUJERIDO
//	PEDIDO_SUPPLIERCARD
//	PERC_COMISSAO_FATU_ADM
//	PERC_COMISSAO_FATU_REPRES
//	PERC_COMIS_VENDA
//	PERC_COMIS_VENDA_EXTRA
//	PERC_COMIS_VENDA_NORMAL
//	PERC_COMIS_VENDEDOR
//	PERC_DESC_DUPLIC
//	PRAZO_EXTRA
//	PRIORIDADE
//	PROMOCAO
//	QTDE_COL_A_100
//	QTDE_DIAS_PRAZO
//	QTDE_DIAS_PRAZO_EXTRA
//	QTDE_DIAS_PRAZO_EXTRA_GER
//	QTDE_PC_SUG_100
//	QTDE_SALDO_PEDI
//	SEQ_END_COBRANCA
//	SEQ_END_ENTREGA
//	SEQ_RECEBIMENTO
//	SIT_ALOC_PEDI
//	SIT_COLETOR
//	SITUACAO_COLETA
//	SOLIC_LIBERA
//	STATUS_COMERCIAL
//	STATUS_EXPEDICAO
//	STATUS_HOMOLOGACAO
//	STATUS_PEDIDO
//	SUGESTAO_IMPRESSA
//	TECIDO_PECA
//	TIPO_COMISSAO
//	TIPO_DESCONTO
//	TIPO_FRETE
//	TIPO_PEDIDO
//	TIPO_PROD_PEDIDO
//	TP_FRETE_REDESP
//	TRANS_PV_FORNE2
//	TRANS_PV_FORNE4
//	TRANS_PV_FORNE9
//	TRANS_RE_FORNE2
//	TRANS_RE_FORNE4
//	TRANS_RE_FORNE9
//	USUARIO_CADASTRO
//	VALOR_DESPESAS_PEDIDO
//	VALOR_FRETE_PEDIDO
//	VALOR_SALDO_PEDI
//	VALOR_SEGURO_PEDIDO
//	ACEITA_ANTECIPACAO
	private Integer aceitaAntecipacao;
//	SITUACAO_VENDA
	private Integer codSituacaoVenda;
	private String situacaoVenda;
//	COD_REP_CLIENTE
	private Integer codRepresentante;
//	COLECAO_TABELA
	private Integer codTabelaColecao;
//	MES_TABELA
	private Integer codTabelaMes;
//	SEQUENCIA_TABELA
	private Integer codTabelaSequencia;
	private TabelaPrecoDao tabelaPreco;
//	COND_PGTO_VENDA
	private Integer codCondPagto;
	private CondPagtoDao condicaoPagto;
//	DATA_DIGIT_VENDA
	private Date dataDigitaçao;
//	DATA_EMIS_VENDA
	private Date dataEmissao;
//	DATA_ENTR_VENDA
	private Date dataEntradaPedido;
//	PEDIDO_VENDA
	private Integer pedidoVenda;
//	PERMITE_PARCIAL
	private Integer aceitaParcial;
//	CLI_PED_CGC_CLI2
	private Integer codCliente2;
//	CLI_PED_CGC_CLI4
	private Integer codCliente4;
//	CLI_PED_CGC_CLI9
	private Integer codCliente9;
//	OBSERVACAO
	private String observacao;
	private Long observacaoLong;
	
//	VALOR_LIQ_ITENS
	private Double valorLiquido;
//	VALOR_TOTAL_PEDI
	private Double valorTotalPedido;
//	QTDE_TOTAL_PEDI
	private Integer quantidadePecas;
	private Integer quantidadeReferencias;
	
//	DESCONTO_ITEM1
	private Double descontoItem1;
//	DESCONTO_ITEM2
	private Double descontoItem2;
//	DESCONTO_ITEM3
	private Double descontoItem3;
	private Double totalDescontoItens;

	public PedidoDao(Integer nrPedido) {
		super();
		try {
			String query = "SELECT " + 
						"    PED.PEDIDO_VENDA, " + 
						"    PED.ACEITA_ANTECIPACAO, " + 
						"    PED.SITUACAO_VENDA, " + 
						"    PED.COD_REP_CLIENTE, " + 
						"    PED.COLECAO_TABELA, " + 
						"    PED.MES_TABELA, " + 
						"    PED.SEQUENCIA_TABELA, " + 
						"    PED.COND_PGTO_VENDA, " + 
						"    PED.DATA_DIGIT_VENDA, " + 
						"    PED.DATA_EMIS_VENDA, " + 
						"    PED.DATA_ENTR_VENDA, " + 
						"    PED.PERMITE_PARCIAL, " + 
						"    PED.CLI_PED_CGC_CLI9, " +
						"    PED.CLI_PED_CGC_CLI4, " + 
						"    PED.CLI_PED_CGC_CLI2, " + 
						"    PED.OBSERVACAO, " + 
						"    PED.DESCONTO_ITEM1, " + 
						"    PED.DESCONTO_ITEM2, " + 
						"    PED.DESCONTO_ITEM3, " + 
						"    PED.VALOR_LIQ_ITENS, " + 
						"    PED.QTDE_TOTAL_PEDI, " + 
						"    PED.VALOR_TOTAL_PEDI, " + 
						"    (SELECT SUM(COUNT(DISTINCT ITEM.CD_IT_PE_GRUPO)) FROM PEDI_110 ITEM WHERE ITEM.PEDIDO_VENDA = PED.PEDIDO_VENDA GROUP BY ITEM.CD_IT_PE_GRUPO) QTDE_TOTAL_REF " + 
						"FROM PEDI_100 PED WHERE PED.PEDIDO_VENDA = ? ";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, nrPedido);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setPedidoVenda(res.getInt("PEDIDO_VENDA"));
				this.setAceitaAntecipacao(res.getInt("ACEITA_ANTECIPACAO"));
				this.setCodSituacaoVenda(res.getInt("SITUACAO_VENDA"));
				this.setCodRepresentante(res.getInt("COD_REP_CLIENTE"));
				this.setCodTabelaColecao(res.getInt("COLECAO_TABELA"));
				this.setCodTabelaMes(res.getInt("MES_TABELA"));
				this.setCodTabelaSequencia(res.getInt("SEQUENCIA_TABELA"));
				this.setCodCondPagto(res.getInt("COND_PGTO_VENDA"));
				this.setDataDigitaçao(res.getDate("DATA_DIGIT_VENDA"));
				this.setDataEmissao(res.getDate("DATA_EMIS_VENDA"));
				this.setDataEntradaPedido(res.getDate("DATA_ENTR_VENDA"));
				this.setAceitaParcial(res.getInt("PERMITE_PARCIAL"));
				this.setCodCliente9(res.getInt("CLI_PED_CGC_CLI9"));
				this.setCodCliente4(res.getInt("CLI_PED_CGC_CLI4"));
				this.setCodCliente2(res.getInt("CLI_PED_CGC_CLI2"));
				this.setObservacao(res.getString("OBSERVACAO"));
				this.setValorLiquido(res.getDouble("VALOR_LIQ_ITENS"));
				this.setDescontoItem1(res.getDouble("DESCONTO_ITEM1"));
				this.setDescontoItem2(res.getDouble("DESCONTO_ITEM2"));
				this.setDescontoItem3(res.getDouble("DESCONTO_ITEM3"));
				this.setValorTotalPedido(res.getDouble("VALOR_TOTAL_PEDI"));
				this.setQuantidadePecas(res.getInt("QTDE_TOTAL_PEDI"));
				this.setQuantidadeReferencias(res.getInt("QTDE_TOTAL_REF"));
				this.setTabelaPreco(new TabelaPrecoDao(this.getCodTabelaColecao(), this.getCodTabelaMes(), this.getCodTabelaSequencia()));
				this.setCondicaoPagto(new CondPagtoDao(this.getCodCondPagto()));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PedidoItemDao> getItens() {
		List<PedidoItemDao> itens = new ArrayList<>();
		try {
			String query = "SELECT IPED.* FROM PEDI_110 IPED " + 
							"    INNER JOIN BASI_220 TAM ON TAM.TAMANHO_REF = IPED.CD_IT_PE_SUBGRUPO " + 
							"WHERE IPED.PEDIDO_VENDA = ? " + 
							"ORDER BY " + 
							"    TAM.ORDEM_TAMANHO, " + 
							"    IPED.CD_IT_PE_ITEM";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, this.getPedidoVenda());
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Integer seqItem = res.getInt("SEQ_ITEM_PEDIDO");
				PedidoItemDao item = new PedidoItemDao(this.getPedidoVenda(), seqItem);
				itens.add(item);
			}
			res.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itens;
	}

	public Integer getAceitaAntecipacao() {
		return aceitaAntecipacao;
	}

	public void setAceitaAntecipacao(Integer aceitaAntecipacao) {
		this.aceitaAntecipacao = aceitaAntecipacao;
	}

	public Integer getCodSituacaoVenda() {
		return codSituacaoVenda;
	}

	public void setCodSituacaoVenda(Integer codSituacaoVenda) {
		this.codSituacaoVenda = codSituacaoVenda;
		this.setSituacaoVenda(codSituacaoVenda);
	}

	public Integer getCodRepresentante() {
		return codRepresentante;
	}

	public void setCodRepresentante(Integer codRepresentante) {
		this.codRepresentante = codRepresentante;
	}

	public Integer getCodTabelaColecao() {
		return codTabelaColecao;
	}

	public void setCodTabelaColecao(Integer codTabelaColecao) {
		this.codTabelaColecao = codTabelaColecao;
	}

	public Integer getCodTabelaMes() {
		return codTabelaMes;
	}

	public void setCodTabelaMes(Integer codTabelaMes) {
		this.codTabelaMes = codTabelaMes;
	}

	public Integer getCodTabelaSequencia() {
		return codTabelaSequencia;
	}

	public void setCodTabelaSequencia(Integer codTabelaSequencia) {
		this.codTabelaSequencia = codTabelaSequencia;
	}

	public Integer getCodCondPagto() {
		return codCondPagto;
	}

	public void setCodCondPagto(Integer codCondPagto) {
		this.codCondPagto = codCondPagto;
	}

	public Date getDataDigitaçao() {
		return dataDigitaçao;
	}

	public void setDataDigitaçao(Date dataDigitaçao) {
		this.dataDigitaçao = dataDigitaçao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Integer getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(Integer pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Integer getAceitaParcial() {
		return aceitaParcial;
	}

	public void setAceitaParcial(Integer aceitaParcial) {
		this.aceitaParcial = aceitaParcial;
	}

	public Integer getCodCliente2() {
		return codCliente2;
	}

	public void setCodCliente2(Integer codCliente2) {
		this.codCliente2 = codCliente2;
	}

	public Integer getCodCliente4() {
		return codCliente4;
	}

	public void setCodCliente4(Integer codCliente4) {
		this.codCliente4 = codCliente4;
	}

	public Integer getCodCliente9() {
		return codCliente9;
	}

	public void setCodCliente9(Integer codCliente9) {
		this.codCliente9 = codCliente9;
	}

	public TabelaPrecoDao getTabelaPreco() {
		return tabelaPreco;
	}

	public void setTabelaPreco(TabelaPrecoDao tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}

	public CondPagtoDao getCondicaoPagto() {
		return condicaoPagto;
	}

	public void setCondicaoPagto(CondPagtoDao condicaoPagto) {
		this.condicaoPagto = condicaoPagto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Integer getQuantidadePecas() {
		return quantidadePecas;
	}

	public void setQuantidadePecas(Integer quantidadePecas) {
		this.quantidadePecas = quantidadePecas;
	}

	@Override
	public String toString() {
		return "PedidoDao [aceitaAntecipacao=" + aceitaAntecipacao + ", codSituacaoVenda=" + codSituacaoVenda
				+ ", codRepresentante=" + codRepresentante + ", codTabelaColecao=" + codTabelaColecao
				+ ", codTabelaMes=" + codTabelaMes + ", codTabelaSequencia=" + codTabelaSequencia + ", tabelaPreco="
				+ tabelaPreco + ", codCondPagto=" + codCondPagto + ", condicaoPagto=" + condicaoPagto
				+ ", dataDigitaçao=" + dataDigitaçao + ", dataEmissao=" + dataEmissao + ", dataEntregaVenda="
				+ dataEntradaPedido + ", pedidoVenda=" + pedidoVenda + ", aceitaParcial=" + aceitaParcial
				+ ", codCliente2=" + codCliente2 + ", codCliente4=" + codCliente4 + ", codCliente9=" + codCliente9
				+ ", observacao=" + observacao + ", valorLiquido=" + valorLiquido + ", quantidadePecas="
				+ quantidadePecas + "]";
	}

	public Long getObservacaoLong() {
		return observacaoLong;
	}

	public void setObservacaoLong(Long observacaoLong) {
		this.observacaoLong = observacaoLong;
	}

	public String getSituacaoVenda() {
		return situacaoVenda;
	}

	public void setSituacaoVenda(String situacaoVenda) {
		this.situacaoVenda = situacaoVenda;
	}
	
	public void setSituacaoVenda(Integer codSituacaoVenda) {
		switch (codSituacaoVenda) {
		case 5:
			this.setSituacaoVenda("5-Pedido Suspenso");
			break;
		case 50:
			this.setSituacaoVenda("50-Pedido incompleto, nao foram digitados os itens.");
			break;
		case 51:
			this.setSituacaoVenda("51-Quantidade Inferior ao Limite Minimo (configuracao) da Empresa.");
			break;
		case 52:
			this.setSituacaoVenda("52-Valor Inferior ao Limite Minimo (configuracao) da Empresa.");
			break;
		case 54:
			this.setSituacaoVenda("54-Quantidade Superior ao Limite Maximo (cadastro cliente) do Cliente.");
			break;
		case 56:
			this.setSituacaoVenda("56-Valor Superior ao Limite Maximo (cadastro cliente) do Cliente.");
			break;
		case 62:
			this.setSituacaoVenda("62-Cliente Inativo");
			break;
		case 64:
			this.setSituacaoVenda("64-Analise de Cotas");
			break;
		case 66:
			this.setSituacaoVenda("66-Analise de Credito");
			break;
		case 87:
			this.setSituacaoVenda("87-Pedido Bloqueado por data de válidade do Suframa Vencida");
			break;
		case 70:
			this.setSituacaoVenda("70-Pedido Bloqueado Manualmente");
			break;
		case 9:
			this.setSituacaoVenda("9-Faturado Parcial");
			break;
		case 10:
			this.setSituacaoVenda("10-Faturado Total");
			break;
		case 15:
			this.setSituacaoVenda("15-Pedido com Nota Fiscal Cancelada");
			break;
		default:
			this.setSituacaoVenda("0-Pedido Liberado");
			break;
		}
	}

	public Integer getQuantidadeReferencias() {
		return quantidadeReferencias;
	}

	public void setQuantidadeReferencias(Integer quantidadeReferencias) {
		this.quantidadeReferencias = quantidadeReferencias;
	}

	public Double getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public Date getDataEntradaPedido() {
		return dataEntradaPedido;
	}

	public void setDataEntradaPedido(Date dataEntradaPedido) {
		this.dataEntradaPedido = dataEntradaPedido;
	}

	public Double getDescontoItem1() {
		return descontoItem1 != null ? descontoItem1 : 0;
	}

	public void setDescontoItem1(Double descontoItem1) {
		this.descontoItem1 = descontoItem1;
		this.setTotalDescontoItens();
	}

	public Double getDescontoItem2() {
		return descontoItem2 != null ? descontoItem2 : 0;
	}

	public void setDescontoItem2(Double descontoItem2) {
		this.descontoItem2 = descontoItem2;
		this.setTotalDescontoItens();
	}

	public Double getDescontoItem3() {
		return descontoItem3 != null ? descontoItem3 : 0;
	}

	public void setDescontoItem3(Double descontoItem3) {
		this.descontoItem3 = descontoItem3;
		this.setTotalDescontoItens();
	}
	
	public void setTotalDescontoItens() {
		Double desconto1 = 0d;
		Double desconto2 = 0d;
		Double desconto3 = 0d;
		if(this.getDescontoItem1() > 0) {
			desconto1 = 100 * (this.descontoItem1 /100);
		}
		if(this.getDescontoItem2() > 0) {
			desconto2 = (100 - desconto1) * (this.descontoItem2 /100);
		}
		if(this.getDescontoItem3() > 0) {
			desconto3 = (100 - desconto1 - desconto2) * (this.descontoItem3 /100);
		}
		this.totalDescontoItens = (100-(((100 - desconto1) - desconto2) - desconto3));
	}
	
	public Double getTotalDescontoItens() {
		return totalDescontoItens;
	}
	
}
