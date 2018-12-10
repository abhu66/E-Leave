/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.sendMail;

import eleave.daoImpl.SendMailDaoImpl;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author khoerulAbu
 * https://myaccount.google.com/lesssecureapps
 */
public class SendMail {
    SendMailDaoImpl sendMailDaoImpl = new SendMailDaoImpl();
    private String SMTP_HOST = null;
    private String SMTP_PORT = null;
    private String SMTP_AUTH = null;
    private String SMTP_SENDER = null;
    private String SMTP_PASSWORD = null;
    
    public void semdEmail(String mail, String subject, String content){
        SMTP_HOST = sendMailDaoImpl.getSmtp("MAIL_SMTP_HOST");
        SMTP_PORT = sendMailDaoImpl.getSmtp("MAIL_SMTP_PORT");
        SMTP_AUTH = sendMailDaoImpl.getSmtp("MAIL_SMTP_AUTH");
        SMTP_SENDER = sendMailDaoImpl.getSmtp("MAIL_SMTP_SENDER");
        SMTP_PASSWORD = sendMailDaoImpl.getSmtp("MAIL_SMTP_PASSWORD");
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", SMTP_AUTH);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_SENDER, SMTP_PASSWORD);
            }
        });

        try {
            System.err.println("Try sending email to.."+mail);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTP_SENDER));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            message.setSubject(subject);
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content,"text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource("C:\\Users\\khoerulAbu\\Pictures\\neida.jpg"); // ex : "C:\\test.pdf"
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("neida.jpg"); // ex : "test.pdf"

            multipart.addBodyPart(messageBodyPart);  // add the text part
            multipart.addBodyPart(attachmentBodyPart); // add the attachement part

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } 
    }
}