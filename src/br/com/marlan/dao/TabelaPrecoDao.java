package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelaPrecoDao extends Dao {
	
//	ANO_CLASSE
//	CASAS_DECIMAIS
//	CD_AGRUPADOR
//	COD_CATALOGO
//	COD_DEPOSITO
//	CODIGO_MOEDA
//	CODIGO_POLITICA
//	DATA_FIM_TABELA
//	DATA_INI_TABELA
//	DESCONTO_APLICADO
//	DESCONTO_MAXIMO
//	DISPONIVEL_B2B
//	DISPONIVEL_DIGISAT
//	DISPONIVEL_NET
//	FATOR_CONVERSAO
//	MES_CLASSE
//	NIVEL_ESTRUTURA
//	OBSERVACAO
//	OBSERVACAO_NOTA
//	PERC_COMIS_MAX
//	SEGMENTO_MERCADO
//	SEQ_CLASSE
//	SITUACAO
//	TIPO_PRECO
//	UNIDADE_MEDIDA_FATUR
//	USUARIO_CADASTRO
//	VLR_MIN_PEDIDO
	
//	DESCRICAO
	private String descricao;
//	COL_TABELA_PRECO
	private Integer codColecao;
//	MES_TABELA_PRECO
	private Integer codMes;
//	SEQ_TABELA_PRECO
	private Integer codSequencia;
	

	public TabelaPrecoDao(Integer codColecao, Integer codMes, Integer codSequencia) {
		super();
		try {
			String query = "SELECT * FROM pedi_090 TAB "
						+ "WHERE TAB.COL_TABELA_PRECO = ? AND TAB.MES_TABELA_PRECO = ? AND TAB.SEQ_TABELA_PRECO = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, codColecao);
			stmt.setInt(2, codMes);
			stmt.setInt(3, codSequencia);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setDescricao(res.getString("DESCRICAO"));
				this.setCodColecao(res.getInt("COL_TABELA_PRECO"));
				this.setCodMes(res.getInt("MES_TABELA_PRECO"));
				this.setCodSequencia(res.getInt("SEQ_TABELA_PRECO"));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getCodColecao() {
		return codColecao;
	}


	public void setCodColecao(Integer codColecao) {
		this.codColecao = codColecao;
	}


	public Integer getCodMes() {
		return codMes;
	}


	public void setCodMes(Integer codMes) {
		this.codMes = codMes;
	}


	public Integer getCodSequencia() {
		return codSequencia;
	}


	public void setCodSequencia(Integer codSequencia) {
		this.codSequencia = codSequencia;
	}


	public String getCodigoTabela() {
		return codColecao+"."+codMes+"."+codSequencia;
	}
	
}
