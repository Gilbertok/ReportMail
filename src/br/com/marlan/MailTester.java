package br.com.marlan;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import br.com.marlan.model.MailJava;
import br.com.marlan.util.MailJavaSender;

public class MailTester {

	public static void main(String[] args) {
		MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("10.100.1.133");
        mj.setSmtpPortMail("25");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setUserMail("informatica03@marlan.com.br");
        mj.setFromNameMail("Giba");
        mj.setPassMail("boinas2609");
        mj.setCharsetMail("ISO-8859-1");
        mj.setSubjectMail("JavaMail");
        mj.setBodyMail(htmlMessage());
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        //sete quantos destinatarios desejar
        Map<String, String> map = new HashMap<String, String>();
        map.put("informatica03@marlan.com.br", "email bol");
//        map.put("destinatario2@msn.com", "email msn");
//        map.put("destinatario3@ig.com.br", "email ig");

        mj.setToMailsUsers(map);

        //seta quatos anexos desejar
        List<String> files = new ArrayList<String>();
        files.add("resources/logo.png");
//        files.add("C:\images\hover_next.png");
//        files.add("C:\images\hover_prev.png");

        mj.setFileMails(files);

        try {
            new MailJavaSender().senderMail(mj);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	private static String textMessage() {
		return "Leia o novo tutorial JavaMail do Programando com Java.n"
				+ "Saiba como enviar emails com anexo, em formato texto e html.n"
				+ "Envie seu email para mais de um destinatario.";
	}

	private static String htmlMessage() {
		return "<html> " + "<head>" + "<title>Email no formato HTML com Javamail!</title> " + "</head> " + "<body> "
				+ "<div style='background-color:orange; width:28%; height:100px;'>" + "<ul>  "
				+ "<li>Leia o novo tutorial JavaMail do Programando com Java.</li> "
				+ "<li>Aprenda como enviar emails com anexos.</li>"
				+ " <li>Aprenda como enviar emails em formato texto simples ou html.</li> "
				+ "<li>Aprenda como enviar seu email para mais de um destinatario.</li>" + "</ul> "
				+ "<p>Visite o blog " + "<a href='http://mballem.wordpress.com/' target='new'>Programando com Java</a>"
				+ "</p>" + "</div>" + "<div style='background-color:FFFFF; width:28%; height:50px;' align='center'>"
				+ "Download do JavaMail<br/>"
				+ "<a href='http://www.oracle.com/technetwork/java/javaee/index-138643.html'>"
				+ "<img src='http://www.oracleimg.com/admin/images/ocom/hp/oralogo_small.gif'/>" + "</a> " + "</div>"
				+ "</body> " + "</html>";
	}

}
