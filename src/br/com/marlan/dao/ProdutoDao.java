package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDao extends Dao {
	
	private Integer nivel;
	private String referencia;
	private String tamanho;
	private String cor;
	private String descricao;
	private Basi010Dao basi010;
	private Basi030Dao basi030;

	public ProdutoDao(Integer nivel, String referencia, String tamanho, String cor) {
		super();
		this.setNivel(nivel);
		this.setReferencia(referencia);
		this.setTamanho(tamanho);
		this.setCor(cor);
		this.setBasi010(new Basi010Dao(nivel, referencia, tamanho, cor));
		this.setBasi030(new Basi030Dao(nivel, referencia));
		this.setDescricao(this.getBasi030().getDescricao());
	}

	public String getDescricaoTamanho() {
		String tamanhoDescricao = new String();
		try {
			String query = "SELECT * FROM BASI_220 TAM WHERE TAM.TAMANHO_REF = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setString(1, this.getTamanho());
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				tamanhoDescricao = res.getString("DESCR_TAMANHO");
			}
			res.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tamanhoDescricao;
	}

	public String getDescricaoCor() {
		String corDescricao = new String();
		try {
			String query = "SELECT * FROM BASI_100 COR WHERE COR.COR_SORTIMENTO = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setString(1, this.getCor());
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				corDescricao = res.getString("DESCRICAO");
			}
			res.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return corDescricao;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public Basi010Dao getBasi010() {
		return basi010;
	}

	public void setBasi010(Basi010Dao basi010) {
		this.basi010 = basi010;
	}

	public Basi030Dao getBasi030() {
		return basi030;
	}

	public void setBasi030(Basi030Dao basi030) {
		this.basi030 = basi030;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
