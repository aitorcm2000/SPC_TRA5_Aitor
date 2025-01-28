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
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author aitor
 */
public class AESFileEncryption extends AESKeyGen{
    
    private final String ALGORITHM ="AES/CTR/NoPadding";
    private Cipher cipher;

    public AESFileEncryption() {
        try{
            this.cipher = Cipher.getInstance(ALGORITHM);
        }catch (NoSuchAlgorithmException ex){
            System.err.println("Algorithm not valid : "+ex.getMessage());
        }catch (NoSuchPaddingException ex){
            System.err.println("Padding not valid : "+ex.getMessage());
        }        
    }
    
        
    public void fileEncryption(File ogFile , String pswd, int keySize){
        File encFile = new File(ogFile.getAbsolutePath()+".enc");
        SecretKey key = keyGen(pswd, keySize);
        try{
            cipher.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(salt));
            try(
                FileInputStream fis = new FileInputStream(ogFile);
                FileOutputStream fos = new FileOutputStream(encFile))
            {
                byte[] buffer = new byte[64];
                byte[] encBuffer;
                int bytesReaded;
                
                while ((bytesReaded = fis.read(buffer)) != -1){                    
                    encBuffer = cipher.update(buffer, 0, bytesReaded);
                    if(encBuffer!=null){
                        fos.write(encBuffer);
                    }
                }
                
                byte[] encDataResult = cipher.doFinal();
                
                if (encDataResult != null){
                    fos.write(encDataResult);
                }
                
                
            }catch (IOException ex){
                StringBuilder sb = new StringBuilder();
                sb.append("File stream error in ");
                sb.append(ALGORITHM);
                sb.append(" file encryption :\n");
                sb.append(ex.getMessage());
                                
                System.err.println(sb.toString());
            }catch (IllegalBlockSizeException ex){
                StringBuilder sb = new StringBuilder();
                sb.append("Cuacale no se que error es esto ");
                sb.append(ex.getMessage());
                System.err.println(sb.toString());
            }catch (BadPaddingException ex){
                System.out.println("Cuacale no se que error es este "
                        +ex.getMessage());
            }   
        }catch(InvalidKeyException ex){
            
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid key in file encryption");            
            sb.append("\nException msg: ");
            sb.append(ex.getMessage());
            System.err.println(sb.toString());
            
        }catch (InvalidAlgorithmParameterException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void fileDeEncryption (File encFile, String pswd, int keySize){
        File ogFile = new File(encFile.getAbsolutePath().replace(".enc", ""));
        SecretKey key = keyGen(pswd, keySize);
        try{
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(salt));
            try(
                FileInputStream fis = new FileInputStream(encFile);
                FileOutputStream fos = new FileOutputStream(ogFile))
            {
                byte[] buffer = new byte[64];
                byte[] dencBuffer;
                int bytesReaded;
                while ((bytesReaded = fis.read(buffer)) != -1){
                    dencBuffer = cipher.update(buffer, 0, bytesReaded);
                    if(dencBuffer!=null){
                        fos.write(dencBuffer);
                    }
                }
                
                byte[] dencDataResult = cipher.doFinal();
                
                if (dencDataResult != null){
                    fos.write(dencDataResult);
                }
            }catch (IOException ex){
                System.err.println("a "+ex.getMessage());
            }catch (BadPaddingException ex){
                System.err.println("b "+ex.getMessage());
            }catch (IllegalBlockSizeException ex){
                System.err.println(ex.getMessage());
            }           
            
        }catch (InvalidKeyException ex){
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid key in file dencryption");            
            sb.append("\nException msg: ");
            sb.append(ex.getMessage());
            System.err.println(sb.toString());
        }catch (InvalidAlgorithmParameterException ex){
            System.err.println(ex.getMessage());
        }
    }
}
