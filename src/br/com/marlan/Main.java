package br.com.marlan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Main extends JDialog implements ActionListener {
	
	JTextField field = new JTextField();
	JButton bt = new JButton("Enviar");
	
	public Main() {
		setLayout(new BorderLayout());
		add(field,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
		bt.addActionListener(this);
		setSize(new Dimension(500,100));
		setTitle("Envia email");
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()==bt){
			SimpleEmail mail = new SimpleEmail();
			try {
				mail.setFrom("xxxxx@gmail.com");
				mail.setSubject("E-mail exemplo");
				mail.setMsg("E-mail de exemplo");
				mail.setSSLOnConnect(true);
				mail.setAuthentication("xxxx@gmail.com", "xxxx");
				mail.setHostName("smtp.gmail.com");
				mail.setSmtpPort(465);
				mail.addTo("xxxx@gmail.com");
				mail.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
	}

}
