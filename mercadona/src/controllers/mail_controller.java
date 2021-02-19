package controllers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail_controller {
	
	public void mailcontroller() {
		
	}
	/**
	 * envia un correo electrornico
	 * @param destinatario
	 * @param asunto
	 * @param cuerpo
	 */
	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "tic3agg@gmail.com";  //Para la dirección nomcuenta@gmail.com
        String clave="Passswrd";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
          });


        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(destinatario));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);
            

            System.out.println("Correo "+asunto +" enviado a "+destinatario);
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }

}
