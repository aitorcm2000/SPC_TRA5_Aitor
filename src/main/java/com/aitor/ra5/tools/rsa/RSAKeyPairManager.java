/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author aitor
 */
public class RSAKeyPairManager extends RSAKeyPairGenerator {

    private final String PATH = "RSAkeys";
    /**
     * Generation of the Key Files for the public and private key
     * @param nombre
     * @param path
     * @return 
     */
    public int genKeyFileGen(String nombre, String path) {
        File DIR = null;
        if (path.isEmpty()) {
            DIR = new File(PATH);
            
            if (!DIR.exists()) {
                System.out.println("Making RSAkey directory");
                DIR.mkdirs();
            } else {
                System.out.println("RSAkey directory already exists");
            }
        } else {
            DIR = new File(path);
        }
        

        File publicKeyFile = new File(DIR, nombre + ".pub");
        File privateKeyFile = new File(DIR, nombre + ".sec");
        int result = 0;

        if (!publicKeyFile.exists() || !privateKeyFile.exists()) {
            KeyPair kp = null;
            try {
                kp = keyPairGen(2048);
                if (kp != null) {
                    PrivateKey priv = kp.getPrivate();
                    PublicKey pub = kp.getPublic();

                    FileOutputStream fos = new FileOutputStream(privateKeyFile);
                    fos.write(priv.getEncoded());
                    fos = new FileOutputStream(publicKeyFile);
                    fos.write(pub.getEncoded());

                    if (publicKeyFile.exists() && privateKeyFile.exists()) {
                        result = 1;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Error RSA key pair gen: " + ex.getMessage());
                result = -1;
            } catch (IOException ex) {
                System.err.println("An error has occurred at key writing: " + ex.getMessage());
                result = -1;
            }

        } else {
            System.out.println("Keys already exist");
        }

        return result;
    }

    /**
     * Recovers a Public Key from a .pub key file
     * @param path
     * @return can return null, if so it couldn't find the public key
     */
    public PublicKey publickeyRetreiver(String path) {
        File pubfile = new File(path);
        PublicKey pk = null;
        try (FileInputStream fis = new FileInputStream(pubfile)) {
            byte[] pubBytes = fis.readAllBytes();
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            EncodedKeySpec encks = new X509EncodedKeySpec(pubBytes);
            pk = keyf.generatePublic(encks);
        } catch (IOException ex) {
            System.err.println("Error finding public key: " + ex.getMessage());
            //TODO show exception on UI            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Couldn't find algorithm in "
                    + "publickeyRetreiver: " + ex.getMessage());
            //TODO show exception on UI
        } catch (InvalidKeySpecException ex) {
            System.err.println("Invalid key spec at "
                    + "publickeyRetreiver: " + ex.getMessage());
            //TODO show exception on UI
        }

        return pk;
    }

    /**
     * Recovers a Private Key from a .sec key file
     * @param path
     * @return can return null, if so it couldn't find the private key
     */
    public PrivateKey privatekeyRetreiver(String path) {
        File privfile = new File(path);
        PrivateKey pk = null;
        try (FileInputStream fis = new FileInputStream(privfile)) {
            byte[] privBytes = fis.readAllBytes();
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            EncodedKeySpec encks = new PKCS8EncodedKeySpec(privBytes);
            pk = keyf.generatePrivate(encks);
        } catch (IOException ex) {
            System.err.println("Error finding private key: " + ex.getMessage());
            //TODO show exception on UI            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Couldn't find algorithm in "
                    + "privatekeyRetreiver: " + ex.getMessage());
            //TODO show exception on UI
        } catch (InvalidKeySpecException ex) {
            System.err.println("Invalid key spec at "
                    + "privatekeyRetreiver: " + ex.getMessage());
            //TODO show exception on UI
        }

        return pk;
    }
}
