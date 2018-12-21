package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDao extends Dao {
	
//	COD_CIDADE_IBGE
//	COD_CIDADE_ZONA_FRANCA
//	CODIGO_FISCAL
//	CODIGO_PAIS
//	COD_REG_MER_EX
//	COD_SUB_REGIAO
//	DDD
//	POPULACAO
//	SUFRAMA
//	CIDADE
	private String cidade;
//	COD_CIDADE
	private Integer codCidade;
//	ESTADO
	private String estado;
//	NUMERO_CEP
	private String CEP;

	public CidadeDao(Integer codCidade) {
		try {
			String query = "SELECT * FROM BASI_160 CID WHERE CID.COD_CIDADE = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, codCidade);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setCodCidade(res.getInt("COD_CIDADE"));
				this.setCidade(res.getString("CIDADE"));
				this.setEstado(res.getString("ESTADO"));
				this.setCEP(res.getString("NUMERO_CEP"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Integer codCidade) {
		this.codCidade = codCidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
}
