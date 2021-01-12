package kr.or.kh.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
   PasswordAuthentication passAuth;
    
    public GoogleAuthentication(){
        passAuth = new PasswordAuthentication("15012311a", "crzdkvpcghtbypfa");
    }
 
    public PasswordAuthentication getPasswordAuthentication() {
        return passAuth;
    }
}