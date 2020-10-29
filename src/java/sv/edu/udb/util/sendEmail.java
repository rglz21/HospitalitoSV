package sv.edu.udb.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

	public class sendEmail {
		 public String enviar ( String correo){

		        final String username = "hospitalitosv@gmail.com";
		        final String password = "Hospitalito12";
		        
		         
		        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		         StringBuilder sb = new StringBuilder(8);
		         Random random = new Random();
		         for (int i = 0; i < 8; i++) {
		                char c = chars[random.nextInt(chars.length-1)];
		                sb.append(c);
		         }
		         String output = sb.toString();
		         System.out.println(output);
		         
		         
		        Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
		        prop.put("mail.smtp.port", "587");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS

		        Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(username, password);
		                    }
		                });

		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(username));
		            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(correo));
		            message.setSubject("Codigo de Confirmacion de HospitalitoSV");
		            message.setContent(  "Usted puede ingresar por medio de este codigo" + "<br>" + "<a>"+output+"<a>","text/html");
		            Transport.send(message);
		            
		            return output;

		        } catch (MessagingException e) {
		            e.printStackTrace();
		            return "";
		        }
		    }

     }
