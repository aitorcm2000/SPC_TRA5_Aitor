/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.controller;

import com.aitor.ra5.vista.MainFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 *
 * @author aitor
 */
public class UI_Controller implements ActionListener{        
    protected MainFrame mf;

    public UI_Controller() {
        this.mf = new MainFrame();                
    }
    
    protected void setup_ui(){
        mf.setVisible(true);
        mf.setLocationRelativeTo(null);
        mf.setTitle("RA5 assigment Aitor");
        mf.pan_tools.add(mf.pan_hash);
        mf.pan_tools.add(mf.pan_aes);
        mf.pan_hash.setSize(mf.pan_tools.getSize());
        setup_hash_panel();
        addListeners();
    }
    
    private void setup_hash_panel(){
        mf.hash_rbut_file.setSelected(false);
        mf.hash_rbut_text.setSelected(true);
        
        mf.hash_but_file.setEnabled(false);
        mf.hash_tf_file.setEnabled(false);
        mf.hash_tp_msg.setEnabled(true);
    }
    
    protected void addListeners(){
        mf.menu_hash.addActionListener(this);
        mf.menu_aes.addActionListener(this);
        mf.menu_rsa.addActionListener(this);
        mf.hash_but_execute.addActionListener(this);
        
        mf.hash_rbut_file.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                System.out.println("Is file selected : "+mf.hash_rbut_file.isSelected());
                System.out.println("Is text selected : "+mf.hash_rbut_text.isSelected());
                mf.hash_rbut_text.setSelected(false);
//                if(!mf.hash_rbut_file.isSelected()){
//                    mf.hash_rbut_file.setSelected(true);
//                }
            }
        });
        
//        mf.hash_rbut_file.addItemListener((ItemEvent ie) -> {      
            
            
//            if(!mf.hash_rbut_file.isSelected()){ 
//                System.out.println("File");
                
//                mf.hash_tp_msg.setEnabled(false);
//                
//                mf.hash_tf_file.setEnabled(true);
//                mf.hash_but_file.setEnabled(true);                
//            }
            
//        });
        
        mf.hash_rbut_text.addItemListener((ItemEvent ie) -> {
            System.out.println("Is file selected : "+mf.hash_rbut_file.isSelected());
            System.out.println("Is text selected : "+mf.hash_rbut_text.isSelected());
            mf.hash_rbut_file.setSelected(false);               
//            if(!mf.hash_rbut_text.isSelected()){
//                mf.hash_rbut_text.setSelected(true);  
//            }
//            if(!mf.hash_rbut_text.isSelected()){
//                System.out.println("Text");                

//                
//                mf.hash_tp_msg.setEnabled(true);
//                mf.hash_tf_file.setEnabled(false);
//                mf.hash_but_file.setEnabled(false);
//                
//                
//            }
        });
        
//        mf.hash_rbut_text.addChangeListener((ChangeEvent ce) -> {
//            System.out.println("Text");
//

//        });
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {        
        System.out.println(ae.getActionCommand());
        Component[] comp = mf.pan_tools.getComponents();
        switch (ae.getActionCommand()) {
            case "menu_hash":
                System.out.println("Hash");
                mf.pan_aes.setSize(0, 0);
                mf.pan_hash.setSize(mf.pan_tools.getSize());                
                break;
            case "menu_aes":
                System.out.println("AES");                                            
                mf.pan_hash.setSize(0, 0);
                mf.pan_aes.setSize(mf.pan_tools.getSize());                
                break;
            case "menu_rsa":
                System.out.println("RSA");
                break;
            case "hash_but_execute":                
                System.out.println("Execute");
                break;                            
            default:
                throw new AssertionError();
        }
        


    }
    
    
}
