package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepresentanteDao extends Dao {
	
//	BAIRRO
//	BAIRRO_PESSOAL
//	CD_CARGO_REP
//	CEP_PESSOAL
//	COD_BANCO_REPR
//	COD_CIDADE
//	COD_CIDADE_PESSOAL
//	COD_EMPRESA
//	CODIGO_AGENCIA
//	CODIGO_CONTABIL
//	COMPLEMENTO_PESSOAL
//	CONSIDERA_PLANO_COMISSAO
//	CONTA_BANCO_REP
//	CONTA_CONTABIL
//	CORE
//	CPF_PESSOAL_2
//	CPF_PESSOAL_9
//	CXPO_REP_CLIENTE
//	DATA_FECHAMENTO
//	DATA_NASCIMENTO
//	EMAIL_PESSOAL
//	ENDERECO_PESSOAL
//	END_REP_CLIENTE
//	ENVIA_EMAIL
//	ENVIA_MALA
//	FANTASIA_REPRES
//	FONE_REP_CLIENTE
//	IDENTIDADE_PESSOAL
//	IMAGEM_PESSOAL
//	INES_REP_CLIENTE
//	LOJA_FV
//	MARGEM_COTAS
//	NOME_CONJUGE
//	NOME_PESSOAL
//	NUMERO_CELULAR
//	NUMERO_FAX
//	NUMERO_PESSOAL
//	OBSERVACOES
//	PERC_COMIS_ADMINISTRADOR
//	PERC_COMIS_CREC
//	PERC_COMIS_FATU
//	PERC_COMIS_VENDA
//	CEP_REP_CLIENTE
//	COD_REP_CLIENTE
	private Integer codRepCliente;
//	CGC_2
	private Integer cgc2;
//	CGC_4
	private Integer cgc4;
//	CGC_9
	private Integer cgc9;
//	NOME_REP_CLIENTE
	private String nomeRepresentante;
//	CODIGO_ADMINISTR
	private Integer codAdministrador;
//	E_MAIL
	private String email;

	public RepresentanteDao(Integer codRepresentante) {
		try {
			String query = "SELECT * FROM PEDI_020 REP WHERE REP.COD_REP_CLIENTE = ? ";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, codRepresentante);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setCodRepCliente(res.getInt("COD_REP_CLIENTE"));
				this.setCgc2(res.getInt("CGC_2"));
				this.setCgc4(res.getInt("CGC_4"));
				this.setCgc9(res.getInt("CGC_9"));
				this.setCodAdministrador(res.getInt("CODIGO_ADMINISTR"));
				this.setNomeRepresentante(res.getString("NOME_REP_CLIENTE"));
				this.setEmail(res.getString("E_MAIL"));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Integer getCodRepCliente() {
		return codRepCliente;
	}

	public void setCodRepCliente(Integer codRepCliente) {
		this.codRepCliente = codRepCliente;
	}

	public Integer getCgc2() {
		return cgc2;
	}

	public void setCgc2(Integer cgc2) {
		this.cgc2 = cgc2;
	}

	public Integer getCgc4() {
		return cgc4;
	}

	public void setCgc4(Integer cgc4) {
		this.cgc4 = cgc4;
	}

	public Integer getCgc9() {
		return cgc9;
	}

	public void setCgc9(Integer cgc9) {
		this.cgc9 = cgc9;
	}

	public String getNomeRepresentante() {
		return nomeRepresentante;
	}

	public void setNomeRepresentante(String nomeRepresentante) {
		this.nomeRepresentante = nomeRepresentante;
	}

	public Integer getCodAdministrador() {
		return codAdministrador;
	}

	public void setCodAdministrador(Integer codAdministrador) {
		this.codAdministrador = codAdministrador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RepresentanteDao [codRepCliente=" + codRepCliente + ", cgc2=" + cgc2 + ", cgc4=" + cgc4 + ", cgc9="
				+ cgc9 + ", nomeRepresentante=" + nomeRepresentante + ", codAdministrador=" + codAdministrador
				+ ", email=" + email + "]";
	}
	
}
