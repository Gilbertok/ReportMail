package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Basi010Dao extends Dao {
	
//	AGRUPADOR_LINHA
//	ALTERNATIVA_ACABADO
//	ALTERNATIVA_CUSTOS
//	ARTIGO_COTAS
//	CALC_DISPONIBILIDADE
//	CEST
//	CGC_CLIENTE_2
//	CGC_CLIENTE_4
//	CGC_CLIENTE_9
//	CLASSIFICACAO_IBAMA
//	CLASSIFICACAO_NALADI
//	CLASSIFICACAO_NCM
//	CLASSIFIC_FISCAL
//	CODIGO_BARRAS
//	CODIGO_CLIENTE
//	CODIGO_CONTABIL
//	CODIGO_VELHO
//	COD_PRODUTO_INTEGRACAO
//	COD_SERVICO_LST
//	COD_TIPO_VOLUME
//	COLUNAS
//	COMBINACAO_PROJETO
//	COMPLEMENTO
//	CONCENTRACAO
//	CONSUMO_MEDIO
//	CURSOS
//	DATA_CADASTRO
//	DATA_DESATIVACAO
//	DATA_FIM_DISP
//	DATA_LANCAMENTO
//	DATA_ULT_COMPRA
//	DATA_ULT_ENTRADA
//	DATA_ULT_SAIDA
//	DESCRICAO_15
//	DESTINO_PROJETO
//	DISTRIBUICAO_COR
//	ESTACAO_DOSAGEM_ORGATEX
//	ESTOQUE_MAXIMO
//	ESTOQUE_MINIMO
//	FATOR_CORRECAO
//	FATOR_UMED_TRIB
//	FLAG_EXPORTACAO_LOJA
//	FLAG_INTEGRACAO_PROD
//	GRADE_DISTRIBUICAO
//	GRAMATURA
//	GRAMATURA_PROJ
//	GRAU_SOLIDEZ
//	GRUPO_ANTIGO
//	GRUPO_ESTRUTURA
//	IMPRIME_FICHA
//	IND_ENVIA_INFOTINT
//	INTEGRADO_DECISOR
//	ITEM_AGRUPADOR
//	ITEM_ANTIGO
//	ITEM_ATIVO
//	ITEM_ESTRUTURA
//	LARGURA
//	LARGURA_PROJ
//	LFA_1
//	LFA_2
//	LFA_3
//	LFA_4
//	LOTE_MULTIPLO
//	MOTIVO_USO
//	NARRATIVA
//	NARRATIVA_ESPANHOL
//	NARRATIVA_INGLES
//	NARRATIVA2
//	NATUR_OPERACAO
//	NE_TITULO
//	NE_TITULO_2
//	NE_TITULO_3
//	NE_TITULO_4
//	NIVEL_ANTIGO
//	NIVEL_ESTRUTURA
//	NOME_USUARIO
//	NR_FIOS_FITA
//	NUM_AGULHAS
//	NUMERO_ALTERNATI
//	NUMERO_GRAFICO
//	NUMERO_ROTEIRO
//	ORIGEM_PROD
//	PERC_ALT_DIM_COMP
//	PERC_ALT_DIM_LARG
//	PERC_COR
//	PERC_DETRACCION
//	PERC_PERDAS
//	PESO_UNITARIO
//	PONTO_REPOSICAO
//	PRECO_CONTRATIPO
//	PRECO_CUSTO
//	PRECO_CUSTO_INFO
//	PRECO_MEDIO
//	PRECO_MEDIO_ANT
//	PRECO_ULT_COMPRA
//	PRIORIDADE_DISTRIBUICAO
//	PRODUTO_INTEGRACAO
//	QTDE_ELABORACAO
//	QTDE_MIN_ENVIO
//	QTDE_MINIMA
//	QTDE_MIN_VENDA
//	QTDE_MIN_VENDA_MIN
//	QTDE_UPS
//	ROTEIRO_CUSTOS
//	SEQUENCIA_TAMANHO
//	SUBGRU_ESTRUTURA
//	SUBGRUPO_ANTIGO
//	SUGERE_ITEM
//	TAM_PONTO_1
//	TAM_PONTO_2
//	TAM_PONTO_3
//	TAM_PONTO_4
//	TEAR_DIAMETRO
//	TEAR_FINURA
//	TEMPO_REPOSICAO
//	TIPO_COR
//	TIPO_MAT_PRIMA
//	TIPO_MOVIMENTACAO
//	TIPO_PROD_QUIMICO
//	TONALIDADE
	
//	NIVEL_ESTRUTURA
	private Integer nivel;
//	GRUPO_ESTRUTURA
	private String grupo;
//	SUBGRU_ESTRUTURA
	private String subGrupo;
//	ITEM_ESTRUTURA
	private String item;
	
	public Basi010Dao(Integer nivel, String grupo, String subGrupo, String item) {
		super();
		try {
			String query = "SELECT * FROM BASI_010 PROD "
							+ "WHERE PROD.NIVEL_ESTRUTURA = ? "
							+ "	AND PROD.GRUPO_ESTRUTURA = ? AND PROD.SUBGRU_ESTRUTURA = ? AND PROD.ITEM_ESTRUTURA = ?";
			PreparedStatement stmt = this.getConn().prepareStatement(query);
			stmt.setInt(1, nivel);
			stmt.setString(2, grupo);
			stmt.setString(3, subGrupo);
			stmt.setString(4, item);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				this.setNivel(res.getInt("NIVEL_ESTRUTURA"));
				this.setGrupo(res.getString("GRUPO_ESTRUTURA"));
				this.setSubGrupo(res.getString("SUBGRU_ESTRUTURA"));
				this.setItem(res.getString("ITEM_ESTRUTURA"));
			}
			res.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
