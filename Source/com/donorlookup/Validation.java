/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ 
/*     */ public class Validation extends javax.swing.JFrame
/*     */ {
/*  24 */   final String KEYLOCATION = "DonorLookup.dz2";
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   
/*     */   public Validation() {
/*  30 */     initComponents();
/*     */   }
/*     */   
/*     */   private JButton jButton4;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel5;
/*     */   private JSeparator jSeparator1;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  42 */     this.jSeparator2 = new JSeparator();
/*  43 */     this.jSeparator4 = new JSeparator();
/*  44 */     this.jSeparator5 = new JSeparator();
/*  45 */     this.keyField = new JTextField();
/*  46 */     this.jLabel1 = new JLabel();
/*  47 */     this.jLabel2 = new JLabel();
/*  48 */     this.jLabel3 = new JLabel();
/*  49 */     this.termsAgreement = new JCheckBox();
/*  50 */     this.jButton1 = new JButton();
/*  51 */     this.jButton2 = new JButton();
/*  52 */     this.jButton3 = new JButton();
/*  53 */     this.jButton4 = new JButton();
/*  54 */     this.jSeparator1 = new JSeparator();
/*  55 */     this.jSeparator3 = new JSeparator();
/*  56 */     this.jLabel5 = new JLabel();
/*     */     
/*  58 */     setDefaultCloseOperation(3);
/*  59 */     setTitle("Donor Lookup");
/*  60 */     setPreferredSize(new Dimension(520, 290));
/*  61 */     setResizable(false);
/*  62 */     setSize(new Dimension(520, 290));
/*  63 */     getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/*  65 */     this.keyField.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  67 */         Validation.this.keyFieldActionPerformed(evt);
/*     */       }
/*  69 */     });
/*  70 */     getContentPane().add(this.keyField, new AbsoluteConstraints(90, 170, 350, 30));
/*     */     
/*  72 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logo.png")));
/*  73 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(10, 10, -1, -1));
/*     */     
/*  75 */     this.jLabel2.setText("BETA 1.0B");
/*  76 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(10, 80, -1, -1));
/*     */     
/*  78 */     this.jLabel3.setText("Copyright 2013. All Rights Reserved.");
/*  79 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(270, 80, -1, -1));
/*     */     
/*  81 */     this.termsAgreement.setText("I have read and agree to the terms and conditions");
/*  82 */     this.termsAgreement.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  84 */         Validation.this.termsAgreementActionPerformed(evt);
/*     */       }
/*  86 */     });
/*  87 */     getContentPane().add(this.termsAgreement, new AbsoluteConstraints(90, 120, -1, 30));
/*     */     
/*  89 */     this.jButton1.setText("Read");
/*  90 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  92 */         Validation.this.jButton1ActionPerformed(evt);
/*     */       }
/*  94 */     });
/*  95 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(10, 120, -1, -1));
/*     */     
/*  97 */     this.jButton2.setText("Continue");
/*  98 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 100 */         Validation.this.jButton2ActionPerformed(evt);
/*     */       }
/* 102 */     });
/* 103 */     getContentPane().add(this.jButton2, new AbsoluteConstraints(410, 220, -1, -1));
/*     */     
/* 105 */     this.jButton3.setText("Buy a Key");
/* 106 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 108 */         Validation.this.jButton3ActionPerformed(evt);
/*     */       }
/* 110 */     });
/* 111 */     getContentPane().add(this.jButton3, new AbsoluteConstraints(310, 220, -1, -1));
/*     */     
/* 113 */     this.jButton4.setText("Quit");
/* 114 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 116 */         Validation.this.jButton4ActionPerformed(evt);
/*     */       }
/* 118 */     });
/* 119 */     getContentPane().add(this.jButton4, new AbsoluteConstraints(240, 220, -1, -1));
/* 120 */     getContentPane().add(this.jSeparator1, new AbsoluteConstraints(0, 150, 520, -1));
/* 121 */     getContentPane().add(this.jSeparator3, new AbsoluteConstraints(0, 110, 540, -1));
/*     */     
/* 123 */     this.jLabel5.setText("Serial Key:");
/* 124 */     getContentPane().add(this.jLabel5, new AbsoluteConstraints(20, 160, -1, 50));
/*     */     
/* 126 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 130 */     AboutDialog.main(null);
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 134 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 138 */     Boolean resultOfValidation = KeyValidation.validateKey(this.keyField.getText());
/* 139 */     if ((this.termsAgreement.getSelectedObjects() != null) && (resultOfValidation.booleanValue()))
/*     */     {
/*     */       try {
/* 142 */         FileWriter file = new FileWriter("DonorLookup.dz2");
/* 143 */         file.append(this.keyField.getText());
/* 144 */         file.append("\n");
/* 145 */         file.append(new Date().toString());
/* 146 */         file.flush();
/*     */       } catch (IOException ex) {
/* 148 */         Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */       
/* 151 */       setVisible(false);
/* 152 */       dispose();
/* 153 */       DonorLookup.main(null);
/* 154 */     } else if ((this.termsAgreement.getSelectedObjects() == null) && (resultOfValidation.booleanValue())) {
/* 155 */       JOptionPane.showMessageDialog(null, "You forgot to read the terms and conditions.", "Try Again!", 0);
/* 156 */     } else if (!resultOfValidation.booleanValue()) {
/* 157 */       JOptionPane.showMessageDialog(null, "Your key was invalid, try entering it again.", "Try Again!", 0);
/*     */     } else {
/* 159 */       JOptionPane.showMessageDialog(null, "You must enter a valid key and agree to the terms and conditions.", "Try Again!", 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 165 */     JOptionPane.showMessageDialog(null, "The website is not yet functioning.", "Coming Soon", 0);
/*     */   }
/*     */   
/*     */   private JSeparator jSeparator2;
/*     */   private JSeparator jSeparator3;
/*     */   private JSeparator jSeparator4;
/*     */   private JSeparator jSeparator5;
/*     */   private JTextField keyField;
/*     */   private JCheckBox termsAgreement;
/*     */   private void termsAgreementActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void keyFieldActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 180 */     String KEYLOCATION = "DonorLookup.dz2";
/* 181 */     Boolean shouldLoad = Boolean.valueOf(true);
/*     */     
/* 183 */     File f = new File("DonorLookup.dz2");
/* 184 */     if (f.isFile()) {
/*     */       try {
/* 186 */         BufferedReader file = new BufferedReader(new java.io.FileReader("DonorLookup.dz2"));
/* 187 */         String key = file.readLine();
/* 188 */         if (KeyValidation.validateKey(key).booleanValue()) {
/* 189 */           DonorLookup.main(null);
/* 190 */           shouldLoad = Boolean.valueOf(false);
/*     */         }
/*     */       }
/*     */       catch (java.io.FileNotFoundException ex) {
/* 194 */         Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
/*     */       } catch (IOException ex) {
/* 196 */         Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/* 199 */     if (shouldLoad.booleanValue())
/*     */     {
/* 201 */       java.awt.EventQueue.invokeLater(new Runnable() {
/*     */         public void run() {
/* 203 */           new Validation().setVisible(true);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Validation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */