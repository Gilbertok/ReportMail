package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao extends Dao {
	
//	ACEITA_DESP_COBR
//	ACUMULADO_VENDAS
//	ACUMULO_ATRASO
//	ALTERNATIVA_CLIENTE
//	ALVO_BEBE
//	ALVO_DESCR_OUTROS
//	ALVO_FEMININO
//	ALVO_INFANTIL
//	ALVO_JUVENIL
//	ALVO_MASCULINO
//	ALVO_OUTROS
//	ALVO_SENHORA
//	ANO_CAPITAL_ATUA
//	ANO_FATURAMENTO
//	ATIV_ATAC_CONF
//	ATIV_ATAC_TECI
//	ATIV_CONFECCAO
//	ATIV_DESCR_OUTROS
//	ATIV_OUTROS
//	ATIV_VAR_CONF
//	ATIV_VAR_TECI
//	ATRASO_MEDIO
//	AUDITAR_VOLUME
//	BAIRRO_E_COMMERCE
//	CADASTRO_DDA
//	CALL_FREE_CLIENTE
//	CAPITAL_ATUAL
//	CAPITAL_INTERIOR
//	CDREPRES_CLIENTE
//	CELULAR_CLIENTE
//	CEP_CLIENTE
//	CLIENTE_INTEGRACAO
//	CLIENTE_ISENTO
//	CLIENTE_PECA
//	CLI_QUEBRA_FIOS
//	CLI_QUEBRA_PANO
//	CLI_QUEBRA_PECA
//	CLI_QUEBRA_TECI
//	COD_ATIVIDADE_ECONOMICA
//	COD_CIDADE_ZONA_FRANCA
//	COD_CLIENTE
//	COD_CLIENTE_INTEGRACAO
//	CODIGO_CLIENTE
//	CODIGO_CONTABIL
//	CODIGO_EMPRESA
//	COD_RAMO_ATIV
//	COD_RELACION_SPED_CTB
//	COD_SIT_COBRANCA
//	COD_SIT_COMERCIAL
//	COD_SIT_CREDITO
//	COMPLEMENTO_E_COMMERCE
//	CONCEITO_CLIENTE
//	CONTA_CONTABIL
//	CONTROLE_CLIENTE
//	CREDIARIO_PROPRI
//	CREDITO_TROCA
//	CRITERIO_ATENDIMENTO
//	CXPOSTAL_CLIENTE
//	DATA_ATUALIZACAO
//	DATA_CAD_CLIENTE
//	DATA_COMPL_CADASTRO
//	DATA_EXC_CLIENTE
//	DATA_FUNDACAO
//	DATA_IMPORTACAO
//	DATA_LIMITE_VENDA_TIT_ATRASO
//	DATA_MAIOR_ATR
//	DATA_MAIOR_ATR_ANT
//	DATA_MAIOR_FATUR
//	DATA_MAIOR_FATUR_ANT
//	DATA_MAIOR_TIT
//	DATA_MAIOR_TIT_ANT
//	DATA_PROX_COBRANCA
//	DATA_REATIVACAO
//	DATA_SIT_COBRANCA
//	DATA_SIT_COMERCIAL
//	DATA_ULT_ATU_MERC
//	DATA_ULT_COMPRA
//	DATA_ULT_COMPRA_ANT
//	DATA_ULT_FATUR
//	DATA_ULT_FATUR_ANT
//	DATA_ULT_TITULO
//	DATA_ULT_TITULO_ANT
//	DATA_VALID_SUFRAMA
//	DATA_VENCTO
//	DDD_CELULAR_E_COMMERCE
//	DDD_FIXO_E_COMMERCE
//	DES_ABREVIATURA
//	DIAS_INSTR_1
//	DIAS_INSTR_2
//	DIG_CLIENTE
//	DIGITACAO_PEDIDO
//	DIST_ATAC_MULTI
//	DIST_ATAC_PROPRIO
//	DIST_DESCR_OUTROS
//	DIST_FRANQUIAS
//	DIST_LOJAS_PROPRIAS
//	DIST_MULTIMARCAS
//	DIST_OUTROS
//	DIST_TERCEIRIZADO
//	DT_ALT_LIM_CREDITO
//	DT_CARTELA
//	DT_MAIOR_ACUMULO
//	DT_MAIOR_ACUMULO_ANT
//	DT_MAIOR_PEDIDO
//	DT_MAIOR_PEDIDO_ANT
//	DT_ULT_CONSULTA_SINTEGRA
//	E_MAIL
//	EMPENHO_AUTOMATICO
//	ENVIA_MALA
//	ESP_CALCA
//	ESP_CAMISARIA
//	ESP_DESCR_OUTROS
//	ESP_MOSTRUARIO
//	ESP_OUTROS
//	ESP_SAIA
//	ESP_TUNICA
//	EXIGE_AGRUP_GRADE
//	FAIXA_ETARIA
//	FASHION
//	FATURAMENTO_ANO
//	FAX_CLIENTE
//	FISICA_JURIDICA
//	FLAG_EXPORTACAO_LOJA
//	FLAG_INTEGRACAO_CLI
//	FORMA_PAGAMENTO
//	FORNE_PROD
//	GRUPO_ECONOMICO
//	IND_BLOQ_QTDE_PACK_DIF
//	IND_DESC_ICMS_IPI
//	IND_DESC_PIS_COFINS
//	IND_DESC_PIS_COFINS_SUFRAMA
//	IND_ENVIA_INFOTINT
//	INSC_EST_CLIENTE
//	INSTRUCAO_INT
//	INSTRUCAO_INT_2
//	ISENTO_SCI
//	ISENTO_SERASA
//	LANCA_COLECAO
//	LIMITE_MAX_PED1
//	LIMITE_MAX_PED2
//	LIMITE_MAX_PED4
//	LIMITE_MAX_PED7
//	LOCAL_COMPRA
//	MAIOR_ACUMULO
//	MAIOR_ACUMULO_ANT
//	MAIOR_ATRASO
//	MAIOR_ATRASO_ANT
//	MAIOR_TITULO
//	MAIOR_TITULO_ANT
//	MARCAS_PROPRIAS
//	MENSAGEM_COBR
//	MES_INIC_INVERNO
//	MES_INIC_VERAO
//	MES_LANC_INVERNO
//	MES_LANC_VERAO
//	MICRO_EMPREENDEDOR_INDIV
//	MOT_EXC_CLIENTE
//	NR_SUFRAMA_CLI
//	NUMERO_FILIAIS
//	NUMERO_IMOVEL
//	NUMERO_REG_JUNTA
//	OBS_CARTELA
//	OBS_COMERCIAL
//	OBSERVACAO
//	OBS_MALA_DIRETA
//	OBS_ZONEAMENTO
//	PARTICIP_EMPRESA
//	PERC_DESC_DUPLIC
//	PERC_ENCARGOS
//	PERC_INSTR_1
//	PERC_MAX_TROCA
//	PERC_VENDA_VISTA
//	PERC_VERBA_PROP
//	PESQ_BUREAUS
//	PESQ_DESCR_OUTROS
//	PESQ_OUTROS
//	PESQ_REVISTAS
//	PESQ_VIAGENS
//	PESQ_VIDEOS
//	PORTADOR_CLIENTE
//	PORTE_CLIENTE
//	POSSUI_ROMANEIO
//	PRAZO_MEDIO
//	PREDIO_PROPRIO
//	PRIORIDADE_SUGESTAO
//	QTDE_PECAS_MES
//	SEG_ACTIVEWEAR
//	SEG_CASUALWEAR
//	SEG_DESCR_OUTROS
//	SEG_INTIMA
//	SEGMENTO_MERCADO
//	SEG_OUTROS
//	SEG_PRAIA
//	SEG_SPORTWEAR
//	SEG_STREETWEAR
//	SEG_SURFWEAR
//	SENHA_WEB
//	SIT_CARTELA
//	SITUACAO_CADASTRO
//	SITUACAO_CLIENTE
//	SIT_ZONEAMENTO
//	SOLICITACAO_EMERGENCIAL
//	STATUS_SUPPLIERCARD
//	SUB_REGIAO
//	SUG_LIMITE_MAX_PED1
//	SUG_LIMITE_MAX_PED2
//	SUG_LIMITE_MAX_PED4
//	SUG_LIMITE_MAX_PED7
//	TELEFONE_CLIENTE
//	TELEX_CLIENTE
//	TIPO_CLIENTE
//	TIPO_CLI_EXTERIOR
//	TIPO_DESCR_OUTROS
//	TIPO_DESENV_ESTAMPA
//	TIPO_DESENV_TECIDO
//	TIPO_EMPRESA
//	TIPO_FRETE
//	TIPO_OUTROS
//	TIPO_PRODUTO
//	TIPO_PRODUTO1
//	TIPO_PRODUTO2
//	TIPO_PRODUTO3
//	TIPO_TECI_ESTAMPA
//	TIPO_TECI_LISO
//	TITULOS_CARTORIO
//	TRAN_CLI_FORNE2
//	TRAN_CLI_FORNE4
//	TRAN_CLI_FORNE9
//	UNIDADE_LIM_PED
//	VAL_LIM_CREDITO
//	VAL_LIMITE_SUPP
//	VAL_MAIOR_FATUR
//	VAL_MAIOR_FATUR_ANT
//	VALOR_COMPRAS_MENSAL
//	VALOR_FATURAMENTO_ANUAL
//	VALOR_ULT_COMPRA
//	VALOR_ULT_COMPRA_ANT
//	VALOR_ULT_FATUR
//	VALOR_ULT_FATUR_ANT
//	VALOR_ULT_TITULO
//	VALOR_ULT_TITULO_ANT
//	VIP
//	VL_MAIOR_PEDIDO
//	VL_MAIOR_PEDIDO_ANT
//	CGC_2
	private Integer codCliente2;
//	CGC_4
	private Integer codCliente4;
//	CGC_9
	private Integer codCliente9;
	private String cpfCNPJ;
//	NOME_CLIENTE
	private String razaoSocial;
//	FANTASIA_CLIENTE
	private String fantasia;
//	NFE_E_MAIL
	private String emailNFE;
//	TELEFONE_CLIENTE
	private String telefone;
//	BAIRRO
	private String bairro;
//	COD_CIDADE
	private Integer codCidade;
	private CidadeDao cidade;
//	ENDERECO_CLIENTE
	private String logradouro;
//	COMPLEMENTO
	private String complemento;
	
	public ClienteDao(Integer codCliente9, Integer codCliente4, Integer codCliente2) {
		super();
		try {
			String query = "SELECT " + 
						"    MARL_FN_FORMATA_CPF_CNPJ(CLI.CGC_9, CLI.CGC_4, CLI.CGC_2, CLI.FISICA_JURIDICA) CNPJ, " + 
						"    CLI.* " + 
						"FROM PEDI_010 CLI " + 
						"WHERE CLI.CGC_9 = ? " + 
						"    AND CLI.CGC_4 = ? " + 
						"    AND CLI.CGC_2 = ? ";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, codCliente9);
			stmt.setInt(2, codCliente4);
			stmt.setInt(3, codCliente2);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setCodCliente9(res.getInt("CGC_9"));
				this.setCodCliente4(res.getInt("CGC_4"));
				this.setCodCliente2(res.getInt("CGC_2"));
				this.setCpfCNPJ(res.getString("CNPJ"));
				this.setRazaoSocial(res.getString("NOME_CLIENTE"));
				this.setFantasia(res.getString("FANTASIA_CLIENTE"));
				this.setEmailNFE(res.getString("NFE_E_MAIL"));
				this.setTelefone(res.getString("TELEFONE_CLIENTE"));
				this.setBairro(res.getString("BAIRRO"));
				this.setCodCidade(res.getInt("COD_CIDADE"));
				this.setCidade(new CidadeDao(this.getCodCidade()));
				this.setLogradouro(res.getString("ENDERECO_CLIENTE"));
				this.setComplemento(res.getString("COMPLEMENTO"));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public Integer getCodCliente9() {
		return codCliente9;
	}


	public void setCodCliente9(Integer codCliente9) {
		this.codCliente9 = codCliente9;
	}


	public Integer getCodCliente4() {
		return codCliente4;
	}


	public void setCodCliente4(Integer codCliente4) {
		this.codCliente4 = codCliente4;
	}


	public Integer getCodCliente2() {
		return codCliente2;
	}


	public void setCodCliente2(Integer codCliente2) {
		this.codCliente2 = codCliente2;
	}


	public String getCpfCNPJ() {
		return cpfCNPJ;
	}


	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getFantasia() {
		return fantasia != null ? fantasia : razaoSocial;
	}


	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}


	public String getEmailNFE() {
		return emailNFE;
	}


	public void setEmailNFE(String emailNFE) {
		this.emailNFE = emailNFE;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public Integer getCodCidade() {
		return codCidade;
	}


	public void setCodCidade(Integer codCidade) {
		this.codCidade = codCidade;
	}


	public CidadeDao getCidade() {
		return cidade;
	}


	public void setCidade(CidadeDao cidade) {
		this.cidade = cidade;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getComplemento() {
		return complemento != null ? complemento : "";
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
