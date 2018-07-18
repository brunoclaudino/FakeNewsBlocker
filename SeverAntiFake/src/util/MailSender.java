/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 
 */
public class MailSender {

    /**
     * Método para fazer o envio de um email contendo a fatura máxima de um
     * cliente ou para alertá-lo que o consumo máximo foi atingido
     *
     * @param newsTitle
     * @throws javax.mail.MessagingException
     */
    public void sendEmail(String newsTitle) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        MimeBodyPart mbp = new MimeBodyPart();
        try {
            msg.setFrom(new InternetAddress("testepbl.redes@gmail.com"));
            Address[] toUser = InternetAddress.parse("stanley@uefs.br");
            msg.setRecipients(Message.RecipientType.TO, toUser);
            msg.setSentDate(new Date());
            msg.setSubject("Alerta de Fake News: Notícia \" " + newsTitle + " \" ");
            msg.setText("Verificou-se a possibilidade da notícia \"" + newsTitle + "\" ser falsa."
                    + "\nFavor tomar as providências necessárias");
            // enviando mensagem
            Transport.send(msg);
        } catch (AddressException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enviado com sucesso!");
    }

    private static Properties getProps() {
        Properties p = new Properties();
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.auth", "true");
        return p;
    }

    class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("testepbl.redes@gmail.com", "senhaemail");
        }
    }
}
