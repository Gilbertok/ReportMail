package br.com.marlan.model;

import java.util.Map;

public class MailPedidoItem {
	
	private String referencia;
	private Map<String, String> tamanhos;
	private Map<String, String> cores;
	private Map<String, Integer> qtdeTamanhosCores;
	private Map<String, Double> valorTamanhos;
	private Map<String, Integer> qtdeCores;
	private Map<String, Integer> qtdeTamanhos;
	private String descricao;
	private Double valorTotal;
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Map<String, Integer> getQtdeTamanhosCores() {
		return qtdeTamanhosCores;
	}
	public void setQtdeTamanhosCores(Map<String, Integer> qtdeTamanhosCores) {
		this.qtdeTamanhosCores = qtdeTamanhosCores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Map<String, String> getTamanhos() {
		return tamanhos;
	}
	public void setTamanhos(Map<String, String> tamanhos) {
		this.tamanhos = tamanhos;
	}
	public Map<String, String> getCores() {
		return cores;
	}
	public void setCores(Map<String, String> cores) {
		this.cores = cores;
	}
	
	@Override
	public String toString() {
		return "MailPedidoItem [referencia=" + referencia + ", tamanhos=" + tamanhos + ", cores=" + cores
				+ ", qtdeTamanhosCores=" + qtdeTamanhosCores + ", valorTamanhosCores=" + valorTamanhos
				+ ", descricao=" + descricao + ", valorTotal=" + valorTotal + ", qtdeCores=" + qtdeCores 
				+ ", qtdeTamanhos=" + qtdeTamanhos + "]";
	}
	public Map<String, Double> getValorTamanhos() {
		return valorTamanhos;
	}
	public void setValorTamanhos(Map<String, Double> valorTamanhos) {
		this.valorTamanhos = valorTamanhos;
	}
	public Map<String, Integer> getQtdeCores() {
		return qtdeCores;
	}
	public void setQtdeCores(Map<String, Integer> qtdeCores) {
		this.qtdeCores = qtdeCores;
	}
	public Map<String, Integer> getQtdeTamanhos() {
		return qtdeTamanhos;
	}
	public void setQtdeTamanhos(Map<String, Integer> qtdeTamanhos) {
		this.qtdeTamanhos = qtdeTamanhos;
	}
}
