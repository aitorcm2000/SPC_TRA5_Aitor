/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.aes;

import java.security.Provider;
import java.security.SecureRandom;
import java.util.List;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * TODO:
 *      - User's password is analyzed to ensure that is secure enough
 *      - https://www.baeldung.com/java-secure-aes-key
 */


/**
 * This is supposed to be the Class for Symmetrical and Asymmetrical
 * AES encryption   
 * 
 * @author aitor
 */
public class AESKeyGen implements Salt{
    
    private static final String CIPHER = "AES";    
    
    public String keyGen (String pswd, int keySize){    
        int it_count = roundSelector(keySize);
        
        PBEKeySpec pbeks = new PBEKeySpec(pswd.toCharArray(), salt,
                it_count, keySize);
        SecretKey sk = SecretKeyFactory.getInstance(CIPHER).generateSecret(pbeks);
        SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), CIPHER);
    }
    
    private int roundSelector(int keySize){
        int rounds;
        switch (keySize) {
            case 128:
                rounds = 10;
                break;
            case 192:
                rounds = 12;
                break;
            case 256:
                rounds = 14;
                break;
            default:
                rounds = 10;
        }
        return rounds;
    }
    
    
    
//    public List<String> possibleAlgorithms (){
//        Cipher c = Cipher.getInstance(CIPHER);
//        Provider p = c.getProvider();
//        Set<Provider.Service> services = p.getServices();
//        for (Provider.Service service : services) {
//            
//        }
//    }
}
