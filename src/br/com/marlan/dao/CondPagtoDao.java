package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CondPagtoDao extends Dao {
	
//	AVISTA
//	BLOQUEIA_PEDIDO
//	CART_COND_PGTO_COBR
//	CONDICAO_SUPPLIERCARD
//	DIVISAO_PRODUTO
//	IND_GERA_BOLETO
//	INFORMA_DATA_VALOR
//	PEDIDOS_VIA_WEB
//	PERC_BONI_DUPLIC
//	PERC_DESC_DUPLIC
//	PERC_DESC_PEDIDO
//	PERC_JURO_DUPLIC
//	PRAZO_MEDIO
//	SIT_CONDICAO
//	TIPO_FATURA
//	VALOR_MINIMO
	
//	DESCR_PG_CLIENTE
	private String descricao;
//	COND_PGT_CLIENTE
	private Integer codigo;
	

	public CondPagtoDao(Integer codCondPagto) {
		super();
		try {
			String query = "SELECT * FROM PEDI_070 COND_PAGTO WHERE COND_PAGTO.COND_PGT_CLIENTE = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, codCondPagto);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setCodigo(res.getInt("COND_PGT_CLIENTE"));
				this.setDescricao(res.getString("DESCR_PG_CLIENTE"));
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


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
