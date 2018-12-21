package br.com.marlan;

import java.sql.SQLException;
import java.util.List;

import br.com.marlan.dao.PedidoMailDao;
import br.com.marlan.db.DBConnectERP;
import br.com.marlan.util.MailUtil;

public class EnviarEmail {
	
	public static void main(String[] args) {
		try {
			PedidoMailDao pedidoMail = new PedidoMailDao();
			List<PedidoMailDao> pedidos = pedidoMail.getPedidos();
			for (PedidoMailDao pedido : pedidos) {
				MailUtil mail = new MailUtil(pedido);
				mail.enviar();
				System.out.println(pedido.getNrPedido());
			}
			System.out.println("E-mail enviado!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnectERP.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
