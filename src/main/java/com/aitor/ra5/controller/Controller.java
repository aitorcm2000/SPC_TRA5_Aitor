/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.controller;

import com.aitor.ra5.tools.HashTool;
import com.aitor.ra5.tools.aes.AESFileEncryption;
import com.aitor.ra5.tools.rsa.RSAEncryption;
import com.aitor.ra5.vista.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aitor
 */
public class Controller{
   
    private HashTool ht;
    private AESFileEncryption aes;
    private RSAEncryption rsa;  
    private UI_Controller ui;

    public Controller() {        
        this.ht = new HashTool();
        this.aes = new AESFileEncryption();
        this.rsa = new RSAEncryption();   
        this.ui = new UI_Controller();
    }        
    
    public void init(){
        ui.setup_ui();
    }
    
    

}
