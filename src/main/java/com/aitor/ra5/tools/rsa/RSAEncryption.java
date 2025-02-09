/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.rsa;

import com.aitor.ra5.tools.aes.AESFileEncryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 *
 * @author aitor
 */
public class RSAEncryption extends RSAKeyPairManager {
    private AESFileEncryption aes;

    public RSAEncryption() {
        this.aes = new AESFileEncryption();
    }
    
    /**
     * A method to encrypt large files using a combination of RSA encryption and
     * AES encryption.
     * RSA encrypts the AES key
     * Key is stored in a file alongside the encrypted file
     * AES encrypts the file using the RSA encrypted key
     * @param path
     * @param pk
     * @param pswd
     * @return 
     */
    public int fileEnc(String path,PublicKey pk, String pswd){
        int result = 0;
        File ogFile = new File(path);        
        try{
            //Cifrado de Clave AES con RSA
            Cipher cip = Cipher.getInstance("RSA");
            cip.init(Cipher.ENCRYPT_MODE,pk);
            
            SecretKey sk = aes.keyGen(pswd, 256);
            byte[] key = sk.getEncoded();
            byte[] enckey = cip.doFinal(key);   
            
            //
            
            File f = new File(ogFile.getParent()+File.separator
                    +ogFile.getName().subSequence(0, 5)+".key");
            
            try(FileOutputStream fos = new FileOutputStream(f)){
                fos.write(enckey);
            } catch (IOException ex){
                System.out.println("Error writing encrypted RSA/AES key: "
                        +ex.getMessage());
            }
                                                
            aes.fileEncryption(ogFile, sk);
            result = 1;
            
        } catch (InvalidKeyException ex){
            System.err.println(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
        } catch (NoSuchPaddingException ex ){
            System.err.println(ex.getMessage());
        } catch (BadPaddingException ex) {
            System.err.println(ex.getMessage());
        } catch (IllegalBlockSizeException ex) {
            System.err.println(ex.getMessage());
        }
        
        return result;
    }
    
    /**
     * A method to decrypt large files using a combination of RSA encryption and
     * AES decryption.
     * Encrypted key is retrieved from the file
     * RSA decrypts the AES key
     * AES decrypts the file using the RSA decrypted key
     * @param path
     * @param pk
     * @param pswd
     * @return 
     */
    public int fileDec(String path, PrivateKey pk, String pswd){
        int result = 0;
        File encFile = new File(path);
        try{
            Cipher cip = Cipher.getInstance("RSA");
            cip.init(Cipher.DECRYPT_MODE, pk);            
            
            File f = new File(encFile.getParent()+File.separator
                    +encFile.getName().subSequence(0, 5)+".key");
            System.out.println("File name : "+f.getName());
            
            
            byte[] encKey = new byte[(int)f.length()];
            
            try(FileInputStream fis = new FileInputStream(f)){
                fis.read(encKey);
            } catch (IOException ex){
                System.out.println("Error reading encrypted RSA/AES key: "
                        +ex.getMessage());
            }
            
            if(encKey!=null){
                byte[] decKey = cip.doFinal(encKey);                                       
                SecretKey decSecKey = aes.keyGen(decKey);
                aes.fileDecryption(encFile, decSecKey);
            }            
            
        } catch (InvalidKeyException ex){
            System.err.println(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
        } catch (NoSuchPaddingException ex ){
            System.err.println(ex.getMessage());
        } catch (BadPaddingException ex) {
            System.err.println(ex.getMessage());
        } catch (IllegalBlockSizeException ex) {
            System.err.println(ex.getMessage());
        }
        
        return result;
    }    
}
