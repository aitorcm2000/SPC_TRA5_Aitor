/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.aes;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
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
    private static final int it_count = 2^16;
    
    public SecretKey keyGen (String pswd, int keySize){            
        SecretKey sk = null;
        
        PBEKeySpec pbeks = new PBEKeySpec(pswd.toCharArray(), salt,
                it_count, keySize);
        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] key = skf.generateSecret(pbeks).getEncoded();
            sk = new SecretKeySpec(key, CIPHER);            
        }catch(NoSuchAlgorithmException ex){
            System.err.println("There is no algorithm "+ex.getMessage());
        }catch(InvalidKeySpecException ex){
            System.err.println("PBEkey bad "+ex.getMessage());
        }
        
        return sk;
    }    
    
    public SecretKey keyGen (byte[] encoded){    
        SecretKey sk = new SecretKeySpec(encoded, CIPHER);
                
        return sk;
    }    
    
    public SecretKey keyGen (String pswd, byte[] encoded){    
        SecretKey sk = null;        
        PBEKeySpec spc = new PBEKeySpec(pswd.toCharArray(), encoded, it_count, 256);
        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");            
            byte[] key = skf.generateSecret(spc).getEncoded();            
            sk = new SecretKeySpec(key, CIPHER);            
        }catch(NoSuchAlgorithmException ex){
            System.err.println("There is no algorithm "+ex.getMessage());
        }catch(InvalidKeySpecException ex){
            System.err.println("PBEkey2 bad "+ex.getLocalizedMessage());
        }
        
        return sk;
    }    
     
}
