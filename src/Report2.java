import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Report2 {
    public void sendMail() {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shanureddy78@gmail.com", "s81nur544y");
            }
        });
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            String to = Travel.s1;
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject("Room booking Confirmation : " + timeStamp);
            msg.setSentDate(new Date());
            String infor="Room number:   "+resiconfirm.tkt2.getText()+"\n"+"Place:   "+Residencydata.fi6+"\t\t\t\t"+"Room Type:   "+Residencydata.fi2+"\n"+"Date:   "+Slct.y+" to "+Slct.z +"\t\t"+"Residency:  "+Residencydata.fi1+"\n"+"Amount:   "+paymentResi.l9.getText()+"\t\t\t\t"+"          Average room rating:   "+Residencydata.fi4;
            msg.setText(infor);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }

    public static void main(String[] args) {
        Report2 rep=new Report2();
        rep.sendMail();
    }
}