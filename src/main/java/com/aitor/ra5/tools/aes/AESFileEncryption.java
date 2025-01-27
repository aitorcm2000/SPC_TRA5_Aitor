/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.aes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author aitor
 */
public class AESFileEncryption extends AESKeyGen{
    
    private final String ALGORITHM ="AES/CTR/NoPadding";
    private Cipher CIPHER;

    public AESFileEncryption(Cipher CIPHER) {
        try{
            this.CIPHER = Cipher.getInstance(ALGORITHM);
        }catch (NoSuchAlgorithmException ex){
            System.err.println("Algorithm not valid : "+ex.getMessage());
        }catch (NoSuchPaddingException ex){
            System.err.println("Padding not valid : "+ex.getMessage());
        }        
    }
    
        
    public void fileEncryption(File ogFile , String password, int keySize){
        File resFile = new File(ogFile.getAbsolutePath()+".enc");
        SecretKey key = keyGen(password, keySize);
        try{
            CIPHER.init(Cipher.ENCRYPT_MODE,key,CIPHER.getParameters());
            try(
                FileInputStream fis = new FileInputStream(ogFile);
                FileOutputStream fos = new FileOutputStream(resFile))
            {
                byte[] buffer = new byte[64];
                int bytesReaded = 0;
                
                while (fis.read(buffer) != -1){
                    fis.
                }
            }catch (IOException ex){
                
            }
        }catch(InvalidAlgorithmParameterException ex){
            
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid algorith error in file encryption");
            sb.append("\n\tAlgorithm used: "+ALGORITHM);
            sb.append("\nException msg: ");
            sb.append(ex.getMessage());
            System.err.println(sb.toString());
            
        }catch(InvalidKeyException ex){
            
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid key in file encryption");            
            sb.append("\nException msg: ");
            sb.append(ex.getMessage());
            System.err.println(sb.toString());
            
        }
    }
}
