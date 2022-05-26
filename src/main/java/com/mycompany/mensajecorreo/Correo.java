
package com.mycompany.mensajecorreo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author keidy
 */
public class Correo {
    
    public Correo(){

    }

    
    public void ejecutarCorreo(String codigo,String correo){
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "proyectofinalprogramacion804@gmail.com";
            String passwordRemitente = "ProyectoFinal2022*";
            String correoReceptor = correo;
            String asunto = "CÓDIGO DE AUTENTICACIÓN";

            String mensaje = "";
            for (int i = 0; i <=5; i++) {
                mensaje += Integer.toString((int)(Math.random()*9+1));
                System.out.println("");
                
            }           

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (Exception ex) {
            System.out.println("Error"+ ex);
        }
    }

    
}
