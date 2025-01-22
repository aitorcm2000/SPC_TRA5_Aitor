/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * CURRENT TODO:
 *      -Place error messages on GUI for the exceptions
 *      -Javadoc of getFileHash
 */


/**
 *
 * @author aitor
 */
public class HashTool {
    /**
     * Calcular la función resumen de un fichero
     */
    
    private String hash_type = MessageDigest.class.getSimpleName();
    
    private Provider[] algorithms = null;

    public HashTool() {
        this.algorithms = Security.getProviders();
    }
    
    /**
     * This function picks up the algorithms based on the providers
     * gathered on the constructor, every provider has a set of services,
     * we store those on cryptoAlg and then compare each and every entry 
     * with the name that var "hash_type" got and stores the result in a
     * list and returns it;
     * 
     * @return List of Algorithms for Cryptography
     */
    public List<String> getAlgorithms(){                
        List<String> algos = new ArrayList<>();
        
        for (Provider a : algorithms) {
            Set<Service> cryptoAlg = a.getServices();
            
            for (Service s : cryptoAlg) {
                if (s.getType().equals(hash_type)){
                    algos.add(s.getAlgorithm());
                }
            }            
        }
        
        return algos;
    }        
    
    /**
     * Takes the algorithm, creates an instance of MessageDigest with it if it's
     * possible, then we input the text into the MessageDigest variable 
     * converting the message into an array of byte utilizing standard charsets
     * 
     * The message is digested and then converted to hexadecimal 
     * @param alg
     * @param text
     * @return 
     */
    public String getHash (String alg, String text){
        
        StringBuilder encrypted_msg = new StringBuilder();        
        
        try{
            MessageDigest mes_dig = MessageDigest.getInstance(alg);
            mes_dig.update(text.getBytes(StandardCharsets.UTF_8));
        
            /**
             * When the message is digested returns it converted to
             * an array of bytes, it is necessary to convert the array
             * to a hexadecimal format. 
             */
            
            byte[] dig_byte = mes_dig.digest();
            
            for (byte b : dig_byte) {
                
                /**
                 * We make a Bitwise AND in order to get a clean the result of 
                 * b, the result if we don't do this will result in ffffffxx
                 */
                
                String tohex = Integer.toHexString(b);
                if (tohex.length() == 1){
                    encrypted_msg.append("0");
                }
                encrypted_msg.append(tohex);
            }
            
        }catch(NoSuchAlgorithmException ex){
            System.err.println("Algorithm not found");
            //TODO (THROWING AN ERROR MESSAGE IN GUI)
        }
                
        return encrypted_msg.toString();
    }
    
    /**
     * 
     * @param alg
     * @param f
     * @return 
     */
    public String getFileHash (String alg, File f){
        
        StringBuilder sb = new StringBuilder();

        try{
            MessageDigest alg_dig = MessageDigest.getInstance(alg);
            
            try(FileInputStream fis = new FileInputStream(f);
                DigestInputStream dgis = new DigestInputStream(fis, alg_dig);){
                
                //Clean Digest
                if (dgis.read() != -1);
                
                /**
                 * Digest FileData through DigestInputStream 
                 * Then write the data with a format of 2 integers, 
                 * this includes hex values
                 */
                byte [] dig = alg_dig.digest();
                for (byte b : dig) {
                    sb.append(String.format("%02x", b));
                }                           

            }catch (IOException ex){
                System.err.println("File not found");
                //TODO (THROWING AN ERROR MESSAGE IN GUI)
            }
        } catch (NoSuchAlgorithmException ex){
            System.err.println("Algorithm not found");
            //TODO (THROWING AN ERROR MESSAGE IN GUI)
        }

        
        return sb.toString();
    }
    
}
