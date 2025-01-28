/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aitor.ra5.main;

import com.aitor.ra5.tools.HashTool;
import com.aitor.ra5.tools.aes.AESFileEncryption;
import com.aitor.ra5.tools.aes.AESKeyGen;
import java.io.File;
import java.util.List;

/**
 *
 * @author aitor
 */
public class AitorCarrenoMarquesTraRA52024 {

    public static void main(String[] args) {
        pruebas();
    }
    
    private static void pruebas(){
        HashTool ht = new HashTool();
        List<String> algos = ht.getAlgorithms();
//        for (String a : algos) {
//            System.out.println(a);
//        }
//        System.out.println(ht.getHash("SHA-256", "Este es un mensaje a encriptar"));
        File f = new File("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE .pdf");
//        System.out.println(ht.getFileHash("SHA-256", f));

        AESFileEncryption afe = new AESFileEncryption();
//        afe.fileEncryption(f, "contraseña", 256);
        File encf = new File("/home/aitor/Documents/UD5-Secure-Programing-Java-PRACTICE .pdf.enc");
        afe.fileDeEncryption(encf, "contraseña", 256);
    }
}
