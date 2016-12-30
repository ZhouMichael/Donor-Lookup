/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.InputMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class AboutDialog extends JDialog
/*     */ {
/*     */   public static final int RET_CANCEL = 0;
/*     */   public static final int RET_OK = 1;
/*     */   private JButton cancelButton;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextArea jTextArea1;
/*     */   private JButton okButton;
/*     */   
/*     */   public AboutDialog(Frame parent, boolean modal)
/*     */   {
/*  34 */     super(parent, modal);
/*  35 */     initComponents();
/*     */     
/*     */ 
/*  38 */     String cancelName = "cancel";
/*  39 */     InputMap inputMap = getRootPane().getInputMap(1);
/*  40 */     inputMap.put(javax.swing.KeyStroke.getKeyStroke(27, 0), cancelName);
/*  41 */     ActionMap actionMap = getRootPane().getActionMap();
/*  42 */     actionMap.put(cancelName, new javax.swing.AbstractAction() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  44 */         AboutDialog.this.doClose(0);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getReturnStatus()
/*     */   {
/*  53 */     return this.returnStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  65 */     this.okButton = new JButton();
/*  66 */     this.cancelButton = new JButton();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jLabel2 = new JLabel();
/*  69 */     this.jScrollPane1 = new JScrollPane();
/*  70 */     this.jTextArea1 = new JTextArea();
/*     */     
/*  72 */     addWindowListener(new WindowAdapter() {
/*     */       public void windowClosing(WindowEvent evt) {
/*  74 */         AboutDialog.this.closeDialog(evt);
/*     */       }
/*     */       
/*  77 */     });
/*  78 */     this.okButton.setText("OK");
/*  79 */     this.okButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  81 */         AboutDialog.this.okButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  84 */     });
/*  85 */     this.cancelButton.setText("Cancel");
/*  86 */     this.cancelButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  88 */         AboutDialog.this.cancelButtonActionPerformed(evt);
/*     */       }
/*     */       
/*  91 */     });
/*  92 */     this.jLabel1.setText("Created by Daniel Nussbaum and Julian Goldstein");
/*     */     
/*  94 */     this.jLabel2.setText("Copyright 2013. All Right Reserved.");
/*     */     
/*  96 */     this.jTextArea1.setEditable(false);
/*  97 */     this.jTextArea1.setColumns(20);
/*  98 */     this.jTextArea1.setLineWrap(true);
/*  99 */     this.jTextArea1.setRows(5);
/* 100 */     this.jTextArea1.setText("Data returned by this program is subject to the use restrictions set by the Federal Election Commission. By accessing this data, you understand that you are using the data subject to all applicable local, state and federal law, including FEC restrictions.\n\nAll donation data returned via. the Sunlight Foundation Transparency Data API is under the Creative Commons BY-NC-SA license. By downloading data and accessing the API you are agreeing to the terms of the license.\n\nFederal campaign contribution and lobbying records must be attributed to OpenSecrets.org.\n\nState campaign contribution records must be attributed to FollowTheMoney.org.");
/* 101 */     this.jTextArea1.setWrapStyleWord(true);
/* 102 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/* 104 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 105 */     getContentPane().setLayout(layout);
/* 106 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jScrollPane1).add(2, layout.createSequentialGroup().add(0, 0, 32767).add(this.okButton, -2, 67, -2).addPreferredGap(0).add(this.cancelButton)).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jLabel1).add(this.jLabel2)).add(0, 0, 32767))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     layout.linkSize(new java.awt.Component[] { this.cancelButton, this.okButton }, 1);
/*     */     
/* 127 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jLabel2).addPreferredGap(0).add(this.jScrollPane1, -1, 210, 32767).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.cancelButton).add(this.okButton)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */     getRootPane().setDefaultButton(this.okButton);
/*     */     
/* 145 */     pack();
/*     */   }
/*     */   
/*     */   private void okButtonActionPerformed(ActionEvent evt) {
/* 149 */     doClose(1);
/*     */   }
/*     */   
/*     */   private void cancelButtonActionPerformed(ActionEvent evt) {
/* 153 */     doClose(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void closeDialog(WindowEvent evt)
/*     */   {
/* 160 */     doClose(0);
/*     */   }
/*     */   
/*     */   private void doClose(int retStatus) {
/* 164 */     this.returnStatus = retStatus;
/* 165 */     setVisible(false);
/* 166 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 176 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 178 */         AboutDialog dialog = new AboutDialog(new javax.swing.JFrame(), true);
/* 179 */         dialog.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 182 */             System.exit(0);
/*     */           }
/* 184 */         });
/* 185 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 197 */   private int returnStatus = 0;
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\AboutDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */