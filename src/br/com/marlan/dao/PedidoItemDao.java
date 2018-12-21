package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoItemDao extends Dao {
	
//	ACRESCIMO
//	AGRUPADOR_PRODUCAO
//	ANO_GERADO
//	AREA_PED_OB
//	BOX
//	CAIXA_PEDI_OB
//	CAIXA_PED_OB
//	CARACT
//	CARACT_ESP
//	CARACT_ING
//	CGC2CLI
//	CGC4CLI
//	CGC9CLI
//	COD_CANCELAMENTO
//	CODIGO_ACOMP
//	CODIGO_DEPOSITO
//	CODIGO_EMBALAGEM
//	COD_NAT_OP
//	COD_PED_CLIENTE
//	COR_FORMULARIO_FAL
//	CORREDOR
//	DATA_EMPENHO
//	DATA_ENT_PROG
//	DATA_LEITURA_COLETOR
//	DATA_SOLICITACAO
//	DATA_SUGESTAO
//	DEPOSITO_SUB
//	DESTINO_PROJETO
//	DT_CANCELAMENTO
//	DT_INCLUSAO
//	EMPENHO_AUTOMATICO
//	EST_NAT_OP
//	EXECUTA_TRIGGER
//	EXPEDIDOR
//	FLAGETIQPRECO
//	GRADE_ITEM
//	GRAMATURA
//	GRU_ORIGINAL_TROCAX
//	GRUPO_MAQUINA
//	ITEM_ATIVO
//	ITE_ORIGINAL_TROCAX
//	JA_ATUALIZADO
//	KANBAN_PEDI_OB
//	KANBAN_PED_OB
//	LARGURA
//	LIQUIDA_SALDO_APROGRAMAR
//	LOTE_EMPENHADO
//	LOTE_SUB
//	MES_GERADO
//	MODULAR
//	MONTADOR_PED_OB
//	MOTIVO_REPROCESSO
//	MOTIVO_TROCA
//	NIV_ORIGINAL_TROCAX
//	NR_ALTERNATIVA
//	NR_PEDIDO_SUB
//	NR_ROTEIRO
//	NR_SOLICITACAO
//	NR_SUGESTAO
//	NUMERO_MAQUINA
//	NUMERO_RESERVA
//	NUM_MATERIAL
//	OBSERVACAO1
//	OBSERVACAO2
//	PERC_COMISSAO
//	PERCENTUAL_DESC
//	PERC_MAO_OBRA
//	PERMITE_ATU_WMS
//	PROD_GRADE_INTEGRACAO
//	PRODUTO_INTEGRACAO
//	QTDE_AFATURAR
//	QTDE_DISTRIBUIDA
//	QTDE_FATURADA
//	QTDE_ORIGINAL
//	QTDE_ORIGINAL_PEDIDA
//	QTDE_PECAS_ATEND
//	QTDE_PEDIDA_LOJA
//	QTDE_ROLOS
//	QTDE_SUGERIDA
//	QTDE_VOLUMES
//	SEQ_GERADO
//	SEQ_ITEM_RESERVA
//	SEQ_ITEM_SUB
//	SEQ_ORIGINAL
//	SEQ_PED_COMPRA
//	SEQ_PED_SERVICO
//	SEQ_PRINCIPAL
//	SITUACAO_FATU_IT
//	SUBGRUPO_MAQUINA
//	SUB_ORIGINAL_TROCAX
//	TESTE_UPDATE_DEFAULT
//	TESTE_UPDATE_DEFAULT2
//	TIPO_SERVICO
//	UM_FATURAMENTO_QTDE
//	UM_FATURAMENTO_UM
//	UM_FATURAMENTO_VALOR
//	VALOR_UNITARIO
	private Double valorUnitario;
//	VALOR_UNITARIO_INSUMO
//	CD_IT_PE_GRUPO
	private String referencia;
//	CD_IT_PE_ITEM
	private String cor;
	private String corNome;
//	CD_IT_PE_NIVEL99
	private Integer nivel;
//	CD_IT_PE_SUBGRUPO
	private String tamanho;
	private String tamanhoNome;
//	ORDEM_TAMANHO
	private Integer ordemTamanho;
	private String descricao;
//	SEQ_ITEM_PEDIDO
	private Integer seqItemPedido;
//	PEDIDO_VENDA
	private Integer pedidoVenda;
//	QTDE_PEDIDA
	private Integer quantidade;

	public PedidoItemDao(Integer pedidoVenda, Integer seqItem) {
		try {
			String query = "SELECT * FROM PEDI_110 IPED " + 
							"    INNER JOIN BASI_220 TAM ON TAM.TAMANHO_REF = IPED.CD_IT_PE_SUBGRUPO " + 
							"WHERE IPED.PEDIDO_VENDA = ? " + 
							"    AND IPED.SEQ_ITEM_PEDIDO = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, pedidoVenda);
			stmt.setInt(2, seqItem);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setPedidoVenda(res.getInt("PEDIDO_VENDA"));
				this.setNivel(res.getInt("CD_IT_PE_NIVEL99"));
				this.setReferencia(res.getString("CD_IT_PE_GRUPO"));
				this.setTamanho(res.getString("CD_IT_PE_SUBGRUPO"));
				this.setCor(res.getString("CD_IT_PE_ITEM"));
				this.setValorUnitario(res.getDouble("VALOR_UNITARIO"));
				this.setQuantidade(res.getInt("QTDE_PEDIDA"));
				this.setOrdemTamanho(res.getInt("ORDEM_TAMANHO"));
				ProdutoDao produto = new ProdutoDao(this.getNivel(), this.getReferencia(), this.getTamanho(), this.getCor());
				if(produto != null) {
					this.setDescricao(produto.getDescricao());
					this.setTamanhoNome(produto.getDescricaoTamanho());
					this.setCorNome(produto.getDescricaoCor());
				}
			}
			res.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getSeqItemPedido() {
		return seqItemPedido;
	}

	public void setSeqItemPedido(Integer seqItemPedido) {
		this.seqItemPedido = seqItemPedido;
	}

	public Integer getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(Integer pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade != null ? quantidade : 0;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCorNome() {
		return corNome;
	}

	public void setCorNome(String corNome) {
		this.corNome = corNome;
	}

	public String getTamanhoNome() {
		return tamanhoNome;
	}

	public void setTamanhoNome(String tamanhoNome) {
		this.tamanhoNome = tamanhoNome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "PedidoItemDao [valorUnitario=" + valorUnitario + ", referencia=" + referencia + ", cor=" + cor
				+ ", corNome=" + corNome + ", nivel=" + nivel + ", tamanho=" + tamanho + ", tamanhoNome=" + tamanhoNome
				+ ", descricao=" + descricao + ", seqItemPedido=" + seqItemPedido + ", pedidoVenda=" + pedidoVenda
				+ ", quantidade=" + quantidade + "]";
	}

	public Integer getOrdemTamanho() {
		return ordemTamanho;
	}

	public void setOrdemTamanho(Integer ordemTamanho) {
		this.ordemTamanho = ordemTamanho;
	}
	
}
