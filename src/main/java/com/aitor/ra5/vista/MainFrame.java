/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aitor.ra5.vista;

/**
 *
 * @author aitor
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_aes = new javax.swing.JPanel();
        tf_aes_file_finder = new javax.swing.JTextField();
        ptf_aes_pswd = new javax.swing.JPasswordField();
        rbut_aes_enc = new javax.swing.JRadioButton();
        rbut_aes_dec = new javax.swing.JRadioButton();
        but_aes_file = new javax.swing.JButton();
        checkb_pswd = new javax.swing.JCheckBox();
        but_aes_execute = new javax.swing.JButton();
        checkb_aes_keysize = new javax.swing.JCheckBox();
        combob_aes_keysize = new javax.swing.JComboBox<>();
        pan_hash = new javax.swing.JPanel();
        hash_rbut_text = new javax.swing.JRadioButton();
        hash_rbut_file = new javax.swing.JRadioButton();
        hash_tf_file = new javax.swing.JTextField();
        hash_but_file = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hash_tp_msg = new javax.swing.JTextPane();
        hash_but_execute = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pan_tools = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_tools = new javax.swing.JMenu();
        menu_hash = new javax.swing.JMenuItem();
        menu_aes = new javax.swing.JMenuItem();
        menu_rsa = new javax.swing.JMenuItem();

        pan_aes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pan_aes.add(tf_aes_file_finder, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 260, -1));
        pan_aes.add(ptf_aes_pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 260, -1));

        rbut_aes_enc.setSelected(true);
        rbut_aes_enc.setText("Encryption");
        pan_aes.add(rbut_aes_enc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        rbut_aes_dec.setText("Decryption");
        pan_aes.add(rbut_aes_dec, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        but_aes_file.setText("Choose file");
        pan_aes.add(but_aes_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        checkb_pswd.setSelected(true);
        checkb_pswd.setText("Password");
        pan_aes.add(checkb_pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        but_aes_execute.setText("Execute");
        pan_aes.add(but_aes_execute, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        checkb_aes_keysize.setText("Key Size");
        pan_aes.add(checkb_aes_keysize, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        combob_aes_keysize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "128", "192", "256" }));
        combob_aes_keysize.setEnabled(false);
        pan_aes.add(combob_aes_keysize, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        pan_hash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hash_rbut_text.setText("Text");
        hash_rbut_text.setActionCommand("hash_rbut_text");
        pan_hash.add(hash_rbut_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        hash_rbut_file.setText("File");
        hash_rbut_file.setActionCommand("hash_rbut_file");
        pan_hash.add(hash_rbut_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));
        pan_hash.add(hash_tf_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 240, -1));

        hash_but_file.setText("Choose from Files");
        hash_but_file.setActionCommand("hash_but_file");
        pan_hash.add(hash_but_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 130, -1));

        jScrollPane2.setViewportView(hash_tp_msg);

        pan_hash.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 420, 180));

        hash_but_execute.setText("Execute");
        hash_but_execute.setActionCommand("hash_but_execute");
        pan_hash.add(hash_but_execute, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Esto es un texto de prueba\n");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 630, 190));

        pan_tools.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pan_toolsLayout = new javax.swing.GroupLayout(pan_tools);
        pan_tools.setLayout(pan_toolsLayout);
        pan_toolsLayout.setHorizontalGroup(
            pan_toolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        pan_toolsLayout.setVerticalGroup(
            pan_toolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jPanel1.add(pan_tools, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 630, 380));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Resultado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        menu_tools.setText("Tools");
        menu_tools.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        menu_hash.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_hash.setText("Hash");
        menu_hash.setActionCommand("menu_hash");
        menu_tools.add(menu_hash);

        menu_aes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_aes.setText("AES");
        menu_aes.setActionCommand("menu_aes");
        menu_tools.add(menu_aes);

        menu_rsa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_rsa.setText("RSA");
        menu_rsa.setActionCommand("menu_rsa");
        menu_tools.add(menu_rsa);

        jMenuBar1.add(menu_tools);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton but_aes_execute;
    public javax.swing.JButton but_aes_file;
    public javax.swing.JCheckBox checkb_aes_keysize;
    public javax.swing.JCheckBox checkb_pswd;
    public javax.swing.JComboBox<String> combob_aes_keysize;
    public javax.swing.JButton hash_but_execute;
    public javax.swing.JButton hash_but_file;
    public javax.swing.JRadioButton hash_rbut_file;
    public javax.swing.JRadioButton hash_rbut_text;
    public javax.swing.JTextField hash_tf_file;
    public javax.swing.JTextPane hash_tp_msg;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JMenuItem menu_aes;
    public javax.swing.JMenuItem menu_hash;
    public javax.swing.JMenuItem menu_rsa;
    public javax.swing.JMenu menu_tools;
    public javax.swing.JPanel pan_aes;
    public javax.swing.JPanel pan_hash;
    public javax.swing.JPanel pan_tools;
    public javax.swing.JPasswordField ptf_aes_pswd;
    public javax.swing.JRadioButton rbut_aes_dec;
    public javax.swing.JRadioButton rbut_aes_enc;
    public javax.swing.JTextField tf_aes_file_finder;
    // End of variables declaration//GEN-END:variables
}
