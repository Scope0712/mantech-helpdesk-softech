/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author THANH
 */
public class MD5 {
    public  String getMd5Digest(String input)
        {
            try
            {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(input.getBytes());
                BigInteger number = new BigInteger(1,messageDigest);
                return number.toString(16);
            }
            catch(NoSuchAlgorithmException e)
            {
                throw new RuntimeException(e);
            }
        }

}
