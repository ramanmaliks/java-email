package com.javaemail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String message="Hello, Dear this message is for security check";
        String subject="RAMAN MALIK : CONFIRMATION";
        String to = "ramanmaliks@gmail.com";
        String from=" raman77957@gmail.com";
        
        // senEmail to send simple text message
        // sendEmail(message,subject,to,from);
        
        //sendAttach Method to send an attachement with textmessage
        sendAttach(message,subject,to,from);
        
    }
    // this method for send attachement with message
    private static void sendAttach(String message, String subject, String to, String from) {
    	// variable for gmail host
    	String host ="smtp.gmail.com";
    	
    	//get the system properties
    	Properties properties = System.getProperties();
    	System.out.println("PROPERTIES" + properties);
    	
    	// setting important information to properties object
    	
    	// host set
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
    	properties.put("mail.smtp.ssl.enable","true");
    	properties.put("mail.smtp.auth", "true");
    	
    	//Step 1. to get the session object....
    	Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("raman77957@gmail.com","**********");
			}
    		
		});
    	session.setDebug(true);
    	
    	//Step 2: Compose the message "text, mm, image,"
       	MimeMessage m = new MimeMessage(session);
        
       	try {
       		
       	
       	//from email;
       	m.setFrom(from);
    	
       	//add recipent to message
       	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
       	
       	//adding subject to message
       	m.setSubject(subject);
       	
       	//attachement..
       	//file path 
       	String path="E:\\banner.jpg";
       	MimeMultipart mimeMultipart = new MimeMultipart();
       	
       	MimeBodyPart textMime = new MimeBodyPart();
       	MimeBodyPart fileMime = new MimeBodyPart();
       	try {
       		textMime.setText(message);
       		File file = new File(path);
       		fileMime.attachFile(file);
       		
       		mimeMultipart.addBodyPart(textMime);
       		mimeMultipart.addBodyPart(fileMime);
       		
       	}catch(Exception e) {
       		e.printStackTrace();
       	}
       	
       	m.setContent(mimeMultipart);
       	

    	
       	//send process
       	
       	// Step 3 : send the Message using Transport class
       	Transport.send(m);
       	
       	System.out.println("Message sent successfully.............");
       	}catch (Exception e){
       		
       	e.printStackTrace();
       	}
    	
    }	
    

    private static void sendEmail(String message, String subject, String to, String from) {
    	// variable for gmail host
    	String host ="smtp.gmail.com";
    	
    	//get the system properties
    	Properties properties = System.getProperties();
    	System.out.println("PROPERTIES" + properties);
    	
    	// setting important information to properties object
    	
    	// host set
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port","465");
    	properties.put("mail.smtp.ssl.enable","true");
    	properties.put("mail.smtp.auth", "true");
    	
    	//Step 1. to get the session object....
    	Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("raman77957@gmail.com","**********");
			}
    		
		});
    	session.setDebug(true);
    	
    	//Step 2: Compose the message "text, mm, image,"
       	MimeMessage m = new MimeMessage(session);
        
       	try {
       		
       	
       	//from email;
       	m.setFrom(from);
    	
       	//add recipent to message
       	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
       	
       	//adding subject to message
       	m.setSubject(subject);
       	
       	//adding text to message
       	m.setText(message);
    	
       	//send process
       	
       	// Step 3 : send the Message using Transport class
       	Transport.send(m);
       	
       	System.out.println("Message sent successfully.............");
       	}catch (Exception e){
       		
       	e.printStackTrace();
       	}
    	
    }
}
