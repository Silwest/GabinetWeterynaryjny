/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.smtp;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pl.gw.utility.PropertyValues;

/**
 *
 * @author Silwest
 */
@Stateless
@LocalBean
public class EmailSessionBean {

    private int port = 465;
    private String host = "smtp.gmail.com";
    private String from = "Silwestpl@gmail.com";
    private boolean auth = true;
    private String username = "";
    private String password = "";
    private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;
//
//    public EmailSessionBean() throws IOException
//    {
//        PropertyValues pv = new PropertyValues();
//        Map<String, String> properties = pv.getPropValues();
////        username = properties.get("emailUser");
////        password = properties.get("emailPassword");
//        username = "silwestpl@gmail.com";
//        password = "kochamcie";
//    }
//
//    public void sendEmail(String to, String subject, String body) {
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//
//        switch (protocol) {
//            case SMTPS:
////                props.put("mail.smtp.sll.enable", true);
//                props.put("mail.smtp.socketFactory.port", "465");
//                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//                break;
//            case TLS:
//                props.put("mail.smtp.starttls.enable", true);
//                break;
//        }
//
//        Authenticator authenticator = null;
//        if (auth) {
//            props.put("mail.smtop.auth", true);
//            authenticator = new Authenticator() {
//                private PasswordAuthentication pa = new PasswordAuthentication(username, password);
//
//                @Override
//                public PasswordAuthentication getPasswordAuthentication() {
//                    return pa;
//                }
//            };
//        }
//        Session session = Session.getInstance(props, authenticator);
//        session.setDebug(debug);
//
//        MimeMessage message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress(from));
//            InternetAddress[] adresses = {new InternetAddress(to)};
//            message.setRecipients(Message.RecipientType.TO, adresses);
//            message.setSubject(subject);
//            message.setSentDate(new Date());
//            message.setText(body);
//            Transport.send(message);
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
//
//    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

}
