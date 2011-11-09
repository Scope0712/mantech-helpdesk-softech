/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class JavaMail extends Authenticator {

    private String emailId, password;

    public JavaMail(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailId, password);
    }
}