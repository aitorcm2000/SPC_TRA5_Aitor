/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author aitor
 */
public class RSAEncryption extends RSAKeyPairManager {
    
    public int rsaFileEnc (String filepath, PublicKey pk){
        int resultado = 0;
        File ogFile = new File(filepath);
        File encFile = new File(filepath+".enc");
        try{
            Cipher cip = Cipher.getInstance("RSA");
            cip.init(Cipher.ENCRYPT_MODE, pk);
            try(FileInputStream fis = new FileInputStream(ogFile);
                FileOutputStream fos = new FileOutputStream(encFile))
            {

                byte[] buffer = new byte[64];
                byte[] encBuffer;
                int bytesReaded;

                while ((bytesReaded = fis.read(buffer)) != -1){                    
                    encBuffer = cip.update(buffer, 0, bytesReaded);
                    if(encBuffer!=null){
                        fos.write(encBuffer);
                    }
                }

                byte[] encDataResult = cip.doFinal();

                if (encDataResult != null){
                    fos.write(encDataResult);
                }

            } catch (IOException ex) {
                System.err.println("RSA file encryption file management "
                    + "failed: "+ex.getMessage());
                //TODO show exception on UI
            }
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Cipher algorithm error at rsaFileEnc: "+ex.getMessage());
            //TODO show exception on UI
        } catch (NoSuchPaddingException ex) {
            System.err.println("Cipher padding error at rsaFileEnc: "+ex.getMessage());
            //TODO show exception on UI
        } catch (InvalidKeyException ex){
            System.err.println("There is an invalid key "
                    + "at rsaFileEnc: "+ex.getMessage());
            //TODO show exception on UI
        } catch (IllegalBlockSizeException ex){
            System.err.println("Illegal block size rsaFileEnc: "+ex.getMessage());
            //TODO show exception on UI
        } catch (BadPaddingException ex) {
            System.err.println("Bad padding rsaFileEnc: "+ex.getMessage());
        }
        
        
        return resultado;
    }
}
