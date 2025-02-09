/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aitor.ra5.main;

import com.aitor.ra5.controller.Controller;
import com.aitor.ra5.tools.HashTool;
import com.aitor.ra5.tools.aes.AESFileEncryption;
import com.aitor.ra5.tools.aes.AESKeyGen;
import com.aitor.ra5.tools.rsa.RSAEncryption;
import com.aitor.ra5.tools.rsa.RSAKeyPairManager;
import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

/**
 *
 * @author aitor
 */
public class AitorCarrenoMarquesTraRA52024 {

    public static void main(String[] args) {
//        pruebasRSA();
        pruebasUI();
    }
    
    private static void pruebas(){
        HashTool ht = new HashTool();
//        List<String> algos = ht.getAlgorithms();
//        for (String a : algos) {
//            System.out.println(a);
//        }
//        System.out.println(ht.getHash("SHA-256", "Este es un mensaje a encriptar"));
//        File f = new File("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE.pdf");
//        System.out.println(ht.getFileHash("SHA-256", f));

//        AESFileEncryption afe = new AESFileEncryption();
//        afe.fileEncryption(f, "contraseña", 256);
        File encf = new File("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE.pdf.enc");
//        afe.fileDeEncryption(encf, "contraseña", 256);
    }
    
    private static void pruebasRSA(){
        RSAKeyPairManager rkpm = new RSAKeyPairManager();
        RSAEncryption rsae = new RSAEncryption();
        rsae.genKeyFileGen("prueba", "");
        PublicKey pk = rsae.publickeyRetreiver("RSAkeys/prueba.pub");
        PrivateKey prk = rsae.privatekeyRetreiver("RSAkeys/prueba.sec");
        File f = new File("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE.pdf");
        System.out.println("Original size "+f.length());
//        rsae.fileEnc("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE.pdf", pk, "");       
        rsae.fileDec("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE.pdf.enc", prk,"");
    }
    
    private static void pruebasAES(){
        AESFileEncryption aes = new AESFileEncryption();
        File file = new File("/home/aitor/Documents/Enlace-a-repo-contactos-aitor.txt");
        File defile = new File("/home/aitor/Documents/Enlace-a-repo-contactos-aitor.txt.enc");
        aes.fileEncryption(file, "", 256);
        aes.fileDecryption(defile, "", 256);
        
    }
    
    private static void pruebasUI(){
        Controller con = new Controller();
        con.init();
    }
}
