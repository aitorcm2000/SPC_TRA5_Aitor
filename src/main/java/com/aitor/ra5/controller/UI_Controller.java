/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.controller;

import com.aitor.ra5.tools.HashTool;
import com.aitor.ra5.tools.PasswordValidator;
import com.aitor.ra5.tools.aes.AESFileEncryption;
import com.aitor.ra5.tools.rsa.RSAEncryption;
import com.aitor.ra5.vista.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author aitor
 */
public class UI_Controller implements ActionListener {

    protected MainFrame mf;
    private final HashTool ht;
    private final AESFileEncryption aes;
    private final RSAEncryption rsa;

    public UI_Controller() {
        this.mf = new MainFrame();
        this.ht = new HashTool();
        this.aes = new AESFileEncryption();
        this.rsa = new RSAEncryption();
    }

    protected void setup_ui() {
        mf.setVisible(true);
        mf.setLocationRelativeTo(null);
        mf.setTitle("RA5 assigment Aitor");
        mf.pan_tools.add(mf.pan_hash);
        mf.pan_tools.add(mf.pan_aes);
        mf.pan_tools.add(mf.pan_rsa);
        mf.pan_tools.add(mf.pan_key);
        mf.pan_hash.setSize(mf.pan_tools.getSize());
        setup_hash_panel();
        setup_aes_panel();
        setup_rsa_panel();
        setup_key_panel();
        addListeners();

    }

    private void setup_hash_panel() {
        ButtonGroup bg_hash = new ButtonGroup();
        bg_hash.add(mf.hash_rbut_file);
        bg_hash.add(mf.hash_rbut_text);
        mf.hash_rbut_text.setSelected(true);
        List<String> hash_algs = ht.getAlgorithms();
        for (String a : hash_algs) {
            mf.hash_combob_alg.addItem(a);
        }

        mf.hash_but_file.setEnabled(false);
        mf.hash_tf_file.setEnabled(false);
        mf.hash_tp_msg.setEnabled(true);
    }

    private void setup_aes_panel() {
        ButtonGroup bg_aes = new ButtonGroup();
        bg_aes.add(mf.aes_rbut_enc);
        bg_aes.add(mf.aes_rbut_dec);
        mf.aes_rbut_enc.setSelected(true);
    }

    private void setup_rsa_panel() {
        ButtonGroup bg_rsa = new ButtonGroup();
        bg_rsa.add(mf.rsa_rbut_enc);
        bg_rsa.add(mf.rsa_rbut_dec);
        mf.rsa_rbut_enc.setSelected(true);
    }
    
    private void setup_key_panel() {
        mf.key_checkb_dir.setSelected(false);
        mf.key_tf_file.setEnabled(false);
        mf.key_but_dir.setEnabled(false);
    }

    protected void addListeners() {
        mf.menu_hash.addActionListener(this);
        mf.menu_aes.addActionListener(this);
        mf.menu_rsa.addActionListener(this);
        mf.menu_keys.addActionListener(this);
        mf.hash_but_execute.addActionListener(this);
        mf.hash_but_file.addActionListener(this);

        mf.hash_rbut_file.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.hash_but_file.setEnabled(true);
                mf.hash_tf_file.setEnabled(true);
                mf.hash_tp_msg.setEnabled(false);
            }
        });

        mf.hash_rbut_text.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.hash_but_file.setEnabled(false);
                mf.hash_tf_file.setEnabled(false);
                mf.hash_tp_msg.setEnabled(true);
            }
        });

        mf.aes_but_file.addActionListener(this);
        mf.aes_but_execute.addActionListener(this);

        mf.aes_checkb_keysize.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.aes_combob_keysize.setEnabled(true);
            } else {
                mf.aes_combob_keysize.setEnabled(false);
            }
        });

        mf.aes_checkb_pswd.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.aes_ptf_pswd.setEnabled(true);
            } else {
                mf.aes_ptf_pswd.setEnabled(false);
            }
        });

        mf.rsa_but_file.addActionListener(this);
        mf.rsa_but_key.addActionListener(this);
        mf.rsa_but_execute.addActionListener(this);
        
        mf.rsa_rbut_enc.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.rsa_key_type.setText("Public Key");
            }
        });
        mf.rsa_rbut_dec.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.rsa_key_type.setText("Private Key");
            }
        });

        mf.rsa_checkb_pswd.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.rsa_ptf_pswd.setEnabled(true);
            } else {
                mf.rsa_ptf_pswd.setEnabled(false);
            }
        });
        
        mf.key_but_dir.addActionListener(this);
        mf.key_but_execute.addActionListener(this);

        mf.key_checkb_dir.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                mf.key_tf_file.setEnabled(true);
                mf.key_but_dir.setEnabled(true);
            } else {
                mf.key_tf_file.setEnabled(false);
                mf.key_but_dir.setEnabled(false);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
        JFileChooser fc = new JFileChooser();

        switch (ae.getActionCommand()) {
            case "menu_hash":
                mf.pan_aes.setSize(0, 0);
                mf.pan_rsa.setSize(0, 0);
                mf.pan_key.setSize(0, 0);
                mf.pan_hash.setSize(mf.pan_tools.getSize());
                break;
            case "menu_aes":
                mf.pan_hash.setSize(0, 0);
                mf.pan_rsa.setSize(0, 0);
                mf.pan_key.setSize(0, 0);
                mf.pan_aes.setSize(mf.pan_tools.getSize());
                break;
            case "menu_rsa":
                mf.pan_hash.setSize(0, 0);
                mf.pan_aes.setSize(0, 0);
                mf.pan_key.setSize(0, 0);
                mf.pan_rsa.setSize(mf.pan_tools.getSize());
                break;
            case "menu_keys":               
                mf.pan_hash.setSize(0, 0);
                mf.pan_aes.setSize(0, 0);
                mf.pan_rsa.setSize(0, 0);
                mf.pan_key.setSize(mf.pan_tools.getSize());                
                break;
        }

        //Switch case for HashTools
        switch (ae.getActionCommand()) {
            case "hash_but_execute":
                operationHash();
                break;
            case "hash_but_file":
                fc.showDialog(fc, "Choose the file");
                File f = fc.getSelectedFile();
                mf.hash_tf_file.setText(f.getAbsolutePath());

                break;
            default:

        }

        //Switch case for AESTools
        switch (ae.getActionCommand()) {
            case "aes_but_file":
                fc.showDialog(fc, "Choose the file");
                File f = fc.getSelectedFile();
                mf.aes_tf_file.setText(f.getAbsolutePath());
                break;
            case "aes_but_execute":
                operationAES();
                break;
        }

        //Switch case for AESTools
        switch (ae.getActionCommand()) {

            case "rsa_but_file":
                fc.showDialog(fc, "Choose the file");
                File f = fc.getSelectedFile();
                mf.rsa_tf_file.setText(f.getAbsolutePath());
                break;
            case "rsa_but_key":
                fc.showDialog(fc, "Choose the file");
                File key = fc.getSelectedFile();
                mf.rsa_tf_key.setText(key.getAbsolutePath());
                break;
            case "rsa_but_execute":
                operationRSA();
                break;
            case "key_but_execute":
                operationKEY();
                break;
            case "key_but_dir":                
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int i = fc.showDialog(fc, "Choose the directory");
                File dir = fc.getSelectedFile();
                mf.key_tf_file.setText(dir.getAbsolutePath());
                break;
        }

    }

    private void operationHash() {
        if (mf.hash_rbut_text.isSelected()) {

            if (!mf.hash_tp_msg.getText().isEmpty()) {
                String result = ht.getHash(mf.hash_combob_alg.
                        getSelectedItem().toString(), mf.hash_tp_msg.getText());

                if (!result.isEmpty()) {
                    mf.ta_info.setText(result);
                }
            } else {
                JOptionPane.showMessageDialog(mf, "Please input text");
            }
        } else if (mf.hash_rbut_file.isSelected()) {

            if (!mf.hash_tf_file.getText().isEmpty()) {
                File file = new File(mf.hash_tf_file.getText());
                String result = ht.getFileHash(mf.hash_combob_alg.
                        getSelectedItem().toString(), file);
                if (!result.isEmpty()) {
                    mf.ta_info.setText(result);
                }
            } else {
                JOptionPane.showMessageDialog(mf, "Please input text");
            }
        }
    }

    private void operationAES() {
        int keySize = 256;
        String pswd = "";

        if (mf.aes_checkb_keysize.isSelected()) {
            keySize = Integer.parseInt((String) mf.aes_combob_keysize.getSelectedItem());
        }

        if (mf.aes_checkb_pswd.isSelected()) {
            pswd = mf.aes_ptf_pswd.getText();
            if (PasswordValidator.pswdVal(pswd) == 1) {
                if (!mf.aes_tf_file.getText().isEmpty()) {
                    File f = new File(mf.aes_tf_file.getText());
                    if (mf.aes_rbut_enc.isSelected()) {
                        aes.fileEncryption(f, pswd, keySize);
                    } else {
                        aes.fileDecryption(f, pswd, keySize);
                    }
                } else {
                    JOptionPane.showMessageDialog(mf, "Please select a file");
                }

            } else {
                JOptionPane.showMessageDialog(mf, """
                                                  This is not a valid password
                                                  Please enter a password with at least the following:
                                                  1 Uppercase
                                                  1 Number
                                                  1 Special Character
                                                  8 Characters""");
            }
        } else {

            if (!mf.aes_tf_file.getText().isEmpty()) {
                File f = new File(mf.aes_tf_file.getText());
                if (mf.aes_rbut_enc.isSelected()) {
                    aes.fileEncryption(f, pswd, keySize);
                } else {
                    aes.fileDecryption(f, pswd, keySize);
                }
            } else {
                JOptionPane.showMessageDialog(mf, "Please select a file");
            }
        }

    }

    private void operationRSA() {
        String pswd = "";
        PublicKey pub = null;
        PrivateKey priv = null;
        String keyPath = mf.rsa_tf_key.getText();
        if (!keyPath.isEmpty()) {

            if (mf.rsa_rbut_enc.isSelected()) {
                pub = rsa.publickeyRetreiver(keyPath);
            } else {
                priv = rsa.privatekeyRetreiver(keyPath);
            }

            if (mf.rsa_checkb_pswd.isSelected()) {
                pswd = mf.rsa_ptf_pswd.getText();
                if (PasswordValidator.pswdVal(pswd) == 1) {
                    if (!mf.rsa_tf_file.getText().isEmpty()) {
                        if (mf.rsa_rbut_enc.isSelected() && pub!=null) {
                            
                            rsa.fileEnc(mf.rsa_tf_file.getText(), pub, pswd);
                            
                        } else if (mf.rsa_rbut_dec.isSelected() && priv!=null) {
                            
                            rsa.fileDec(mf.rsa_tf_file.getText(), priv, pswd);
                            
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(mf, "Please select a file");
                    }

                } else {
                    JOptionPane.showMessageDialog(mf, """
                                                      This is not a valid password
                                                      Please enter a password with at least the following:
                                                      1 Uppercase
                                                      1 Number
                                                      1 Special Character
                                                      8 Characters""");
                }
            } else {

                if (!mf.rsa_tf_file.getText().isEmpty()) {                    
                    if (mf.rsa_rbut_enc.isSelected()) {
                        rsa.fileEnc(mf.rsa_tf_file.getText(), pub, pswd);
                    } else {
                        rsa.fileDec(mf.rsa_tf_file.getText(), priv, pswd);
                    }
                } else {
                    JOptionPane.showMessageDialog(mf, "Please select a file");
                }
            }
        } else {
            int option = JOptionPane.showConfirmDialog(mf, """
                                              You have to present a key
                                              Do you want to create a pair of new keys?""");
            if(option == JOptionPane.OK_OPTION){
                mf.pan_hash.setSize(0, 0);
                mf.pan_aes.setSize(0, 0);
                mf.pan_rsa.setSize(0, 0);
                mf.pan_key.setSize(mf.pan_tools.getSize());   
            }
        }

    }
    
    private void operationKEY(){
        String name = mf.key_tf_name.getText();
        String dir = mf.key_tf_file.getText();
        if(!name.isEmpty()){
            if(mf.key_checkb_dir.isSelected()){
                if(!dir.isEmpty()){
                    rsa.genKeyFileGen(name, dir);
                } else {
                    JOptionPane.showMessageDialog(mf, "Please enter a directory");
                }
            } else {
                rsa.genKeyFileGen(name, dir);
            }
        } else {
            JOptionPane.showMessageDialog(mf, "You must give name to the key");
        }
    }

}
