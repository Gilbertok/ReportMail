package br.com.marlan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoMailDao extends Dao {
	
	private Integer nrPedido;
	private PedidoDao pedido;
	private ClienteDao cliente;
	private EnderecoDao endereco;
	private RepresentanteDao representante;
	private List<PedidoItemDao> itens;
	private String emailAnalista;
	
	public PedidoMailDao() {
	}

	public Integer getNrPedido() {
		return nrPedido;
	}

	public void setNrPedido(Integer nrPedido) {
		this.nrPedido = nrPedido;
	}
	
	public PedidoDao getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDao pedido) {
		this.pedido = pedido;
	}

	public ClienteDao getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDao cliente) {
		this.cliente = cliente;
	}

	public EnderecoDao getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDao endereco) {
		this.endereco = endereco;
	}

	public RepresentanteDao getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteDao representante) {
		this.representante = representante;
	}

	public List<PedidoItemDao> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItemDao> itens) {
		this.itens = itens;
	}

	public String getEmailAnalista() {
		return emailAnalista;
	}

	public void setEmailAnalista(String emailAnalista) {
		this.emailAnalista = emailAnalista;
	}
	
	@Override
	public String toString() {
		return "PedidoMailDao [nrPedido=" + nrPedido + ", pedido=" + pedido + ", cliente=" + cliente + ", endereco="
				+ endereco + ", representante=" + representante + ", itens=" + itens + ", emailAnalista="
				+ emailAnalista + "]";
	}

	public List<PedidoMailDao> getPedidos() throws SQLException {
		List<PedidoMailDao> pedidos = new ArrayList<>();
//		String query = "SELECT PEDIDO_VENDA FROM MARL_MAIL_PEDIDO WHERE DATA_ENVIO IS NULL AND ROWNUM <= 1";
		String query = "SELECT PEDIDO_VENDA FROM MARL_MAIL_PEDIDO WHERE DATA_ENVIO IS NULL";
		PreparedStatement stmt = this.getConn().prepareStatement(query);
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			PedidoMailDao dao = new PedidoMailDao();
			dao.setNrPedido(res.getInt("PEDIDO_VENDA"));
			PedidoDao pedido = new PedidoDao(dao.getNrPedido());
			if (pedido.getPedidoVenda() != null) {
				dao.setPedido(pedido);
				dao.setCliente(new ClienteDao(pedido.getCodCliente9(), pedido.getCodCliente4(), pedido.getCodCliente2()));
				RepresentanteDao rep = new RepresentanteDao(pedido.getCodRepresentante());
				dao.setRepresentante(rep);
				dao.setEmailAnalista(new RepresentanteDao(rep.getCodAdministrador()).getEmail());
				dao.setItens(pedido.getItens());
				pedidos.add(dao);
			}
		}
		res.close();
		stmt.close();
		return pedidos;
	}
	
}
