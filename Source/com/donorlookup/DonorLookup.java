/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ 
/*     */ public class DonorLookup extends javax.swing.JFrame
/*     */ {
/*  23 */   final String SETTINGSLOCATION = "settings.dz2";
/*     */   String fileLocation;
/*  25 */   String destinationLocation; Properties theSettings = new Properties("settings.dz2");
/*  26 */   PointSettings thePointSettings = new PointSettings("settings.dz2");
/*  27 */   private boolean running = false;
/*     */   private JTextField APIKeyField;
/*     */   private JLabel APILabel;
/*     */   private JMenuItem AboutAndLegal;
/*     */   private JPanel CSVPanel;
/*     */   private JProgressBar batchProgressBar;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JCheckBox calculatePointsCheck;
/*     */   private JLabel candidatesLabel;
/*     */   class BatchDonorResearch implements Runnable { BatchDonorResearch() {}
/*  37 */     public void run() { DonorLookup.this.runButton.setText("Stop");
/*  38 */       DonorLookup.this.batchProgressBar.setValue(0);
/*  39 */       DonorLookup.this.batchProgressBar.setStringPainted(true);
/*     */       
/*     */ 
/*  42 */       long startTime = System.nanoTime();
/*     */       
/*     */ 
/*  45 */       ArrayList<Donor> donorList = null;
/*     */       
/*     */       try
/*     */       {
/*  49 */         donorList = CSVHandler.readCSV(DonorLookup.this.fileLocation);
/*     */       }
/*     */       catch (Exception ex) {
/*  52 */         Error.showError(2);
/*  53 */         DonorLookup.this.runButton.setText("Run");
/*  54 */         DonorLookup.this.batchProgressBar.setValue(0);
/*  55 */         DonorLookup.this.batchProgressBar.setStringPainted(false);
/*  56 */         DonorLookup.this.batchProgressBar.setString(null);
/*  57 */         DonorLookup.this.running = false;
/*  58 */         DonorLookup.this.jLabel1.setText("");
/*  59 */         Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*  60 */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  65 */       ArrayList<Long> eta = new ArrayList();
/*  66 */       int size = donorList.size();
/*  67 */       double avg = 0.0D;
/*     */       
/*  69 */       double j = 1.0D;
/*     */       
/*     */ 
/*  72 */       for (Donor i : donorList)
/*     */       {
/*  74 */         if (!DonorLookup.this.running) {
/*  75 */           DonorLookup.this.batchProgressBar.setValue(0);
/*  76 */           DonorLookup.this.batchProgressBar.setString("Donor Research Stopped...");
/*  77 */           DonorLookup.this.running = false;
/*  78 */           DonorLookup.this.jLabel1.setText("");
/*  79 */           DonorLookup.this.runButton.setText("Run");
/*  80 */           return;
/*     */         }
/*  82 */         this.init = System.nanoTime();
/*     */         
/*  84 */         int percent = (int)(100.0D * j / size);
/*     */         
/*     */ 
/*  87 */         i.findDonationHistory(DonorLookup.this.theSettings.getCycle(), DonorLookup.this.theSettings.getFilterZip(), DonorLookup.this.theSettings.getFilterCity(), DonorLookup.this.theSettings.getFilterEmployer(), DonorLookup.this.theSettings.getFilterOccupation(), DonorLookup.this.theSettings.getAPIKey());
/*     */         
/*     */ 
/*  90 */         if (DonorLookup.this.theSettings.calculatePoints.booleanValue()) {
/*  91 */           i.findPointTotal(DonorLookup.this.thePointSettings, DonorLookup.this.theSettings);
/*     */         }
/*     */         
/*     */ 
/*  95 */         i.donationHistory = Processing.sortDonations(i.donationHistory);
/*     */         
/*     */ 
/*  98 */         DonorLookup.this.batchProgressBar.setValue(percent);
/*  99 */         DonorLookup.this.batchProgressBar.setString(Double.toString(percent) + "%");
/* 100 */         j += 1.0D;
/*     */         
/* 102 */         this.fin = System.nanoTime();
/* 103 */         eta.add(Long.valueOf((this.fin - this.init) / 1000000000L));
/* 104 */         long sum = 0L;
/*     */         
/* 106 */         for (int b = 0; b < eta.size(); b++)
/*     */         {
/* 108 */           sum += ((Long)eta.get(b)).longValue();
/* 109 */           avg = sum / eta.size();
/*     */         }
/* 111 */         avg *= (size - j);
/*     */         
/* 113 */         int minutes = (int)(avg / 60.0D);
/* 114 */         avg -= 60 * minutes;
/* 115 */         int seconds = (int)avg;
/*     */         String s;
/* 117 */         String s; if (seconds <= 9) {
/* 118 */           s = "0" + Integer.toString(seconds);
/*     */         } else
/* 120 */           s = Integer.toString(seconds);
/*     */         String m;
/* 122 */         String m; if (minutes <= 9) {
/* 123 */           m = "0" + Integer.toString(minutes);
/*     */         } else {
/* 125 */           m = Integer.toString(minutes);
/*     */         }
/*     */         
/* 128 */         if ((minutes <= 0) && (seconds <= 0)) {
/* 129 */           DonorLookup.this.jLabel1.setText("");
/*     */         } else {
/* 131 */           DonorLookup.this.jLabel1.setText("Estimated Time Remaining: " + m + ":" + s);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 137 */       donorList = Processing.rankDonor(donorList);
/* 138 */       DonorLookup.this.jLabel1.setText("");
/*     */       try {
/* 140 */         CSVHandler.writeCSV(donorList, DonorLookup.this.destinationLocation, DonorLookup.this.theSettings);
/*     */       }
/*     */       catch (IOException ex) {
/* 143 */         Error.showError(3);
/* 144 */         DonorLookup.this.runButton.setText("Run");
/* 145 */         DonorLookup.this.batchProgressBar.setValue(0);
/* 146 */         DonorLookup.this.batchProgressBar.setStringPainted(false);
/* 147 */         DonorLookup.this.batchProgressBar.setString(null);
/* 148 */         DonorLookup.this.jLabel1.setText("");
/* 149 */         DonorLookup.this.running = false;
/* 150 */         Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/* 151 */         return;
/*     */       }
/*     */       
/*     */ 
/* 155 */       long endTime = System.nanoTime();
/* 156 */       long duration = endTime - startTime;
/*     */       
/*     */ 
/* 159 */       int minutes = (int)(duration / 60000000000L);
/* 160 */       duration -= minutes * 60000000000L;
/* 161 */       int seconds = (int)(duration / 1000000000L);
/*     */       String s;
/* 163 */       String s; if (seconds <= 9) {
/* 164 */         s = "0" + Integer.toString(seconds);
/*     */       } else
/* 166 */         s = Integer.toString(seconds);
/*     */       String m;
/* 168 */       String m; if (minutes <= 9) {
/* 169 */         m = "0" + Integer.toString(minutes);
/*     */       } else {
/* 171 */         m = Integer.toString(minutes);
/*     */       }
/* 173 */       DonorLookup.this.batchProgressBar.setString("Execution Time: " + m + ":" + s);
/* 174 */       DonorLookup.this.runButton.setText("Run");
/* 175 */       DonorLookup.this.jLabel1.setText("");
/*     */       
/* 177 */       DonorLookup.this.running = false; }
/*     */     
/*     */     long init;
/*     */     long fin; }
/*     */   
/*     */   private JTextArea candidatesPointsArea;
/*     */   private JButton chooseCSVButton;
/*     */   
/*     */   class ManualDonorResearch implements Runnable { ManualDonorResearch() {}
/* 186 */     public void run() { java.text.DecimalFormat df = new java.text.DecimalFormat("#.###");
/*     */       
/*     */ 
/* 189 */       Donor manualEntry = new Donor(DonorLookup.this.manualName.getText().trim(), null, null, DonorLookup.this.manualCity.getText().trim(), DonorLookup.this.manualState.getText().trim(), DonorLookup.this.manualZip.getText().trim(), null, null);
/*     */       
/*     */ 
/* 192 */       manualEntry.findDonationHistory(DonorLookup.this.theSettings.getCycle(), DonorLookup.this.theSettings.getFilterZip(), DonorLookup.this.theSettings.getFilterCity(), DonorLookup.this.theSettings.getFilterEmployer(), DonorLookup.this.theSettings.getFilterOccupation(), DonorLookup.this.theSettings.getAPIKey());
/*     */       
/*     */ 
/* 195 */       manualEntry.findPointTotal(DonorLookup.this.thePointSettings, DonorLookup.this.theSettings);
/*     */       
/*     */ 
/* 198 */       manualEntry.donationHistory = Processing.sortDonations(manualEntry.donationHistory);
/*     */       
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 204 */         if (manualEntry.getPointTotal() > 0.0D) {
/* 205 */           DonorLookup.this.manualOutput.setText(manualEntry.getName() + " " + df.format(manualEntry.getPointTotal()) + ":\n" + manualEntry.getDonationHistoryAsString() + "\n\n" + DonorLookup.this.manualOutput.getText());
/*     */         } else {
/* 207 */           DonorLookup.this.manualOutput.setText(manualEntry.getName() + ":\n" + manualEntry.getDonationHistoryAsString() + "\n\n" + DonorLookup.this.manualOutput.getText());
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/* 211 */         Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */       
/*     */ 
/* 215 */       DonorLookup.this.manualOutput.setCaretPosition(0); } }
/*     */   
/*     */   private JLabel cityLabel;
/*     */   private javax.swing.JSlider cycleSlider;
/*     */   private JTextField demPointsField;
/*     */   private JLabel democratLabel;
/*     */   private JButton export;
/*     */   private JLabel fileSelectedLabel; private JCheckBox filterCityCheck; private JCheckBox filterEmployerCheck; private JCheckBox filterOccupationCheck; private JCheckBox filterZipCheck; private JLabel fullNameLabel;
/* 223 */   public DonorLookup() { try { setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/res/icon.png")));
/*     */     }
/*     */     catch (IOException e) {
/* 226 */       Error.showError(1);
/*     */     }
/* 228 */     setTitle("DonorLookup");
/* 229 */     initComponents(); }
/*     */   
/*     */   private JMenuItem getAPIKeyMenuButton;
/*     */   private JButton getKeyButton;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel9; private javax.swing.JMenu jMenu2; private javax.swing.JMenuBar jMenuBar1; private javax.swing.JScrollPane jScrollPane1;
/* 236 */   private void initComponents() { this.menuBar1 = new java.awt.MenuBar();
/* 237 */     this.menu1 = new java.awt.Menu();
/* 238 */     this.menu2 = new java.awt.Menu();
/* 239 */     this.menuBar2 = new java.awt.MenuBar();
/* 240 */     this.menu3 = new java.awt.Menu();
/* 241 */     this.menu4 = new java.awt.Menu();
/* 242 */     this.popupMenu1 = new java.awt.PopupMenu();
/* 243 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/* 244 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/* 245 */     this.jTable1 = new javax.swing.JTable();
/* 246 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 247 */     this.CSVPanel = new JPanel();
/* 248 */     this.fileSelectedLabel = new JLabel();
/* 249 */     this.chooseCSVButton = new JButton();
/* 250 */     this.runButton = new JButton();
/* 251 */     this.setDestinationButton = new JButton();
/* 252 */     this.jLabel9 = new JLabel();
/* 253 */     this.jSeparator1 = new javax.swing.JSeparator();
/* 254 */     this.jSeparator2 = new javax.swing.JSeparator();
/* 255 */     this.jSeparator3 = new javax.swing.JSeparator();
/* 256 */     this.batchProgressBar = new JProgressBar();
/* 257 */     this.jLabel1 = new JLabel();
/* 258 */     this.manualDataPanel = new JPanel();
/* 259 */     this.manualName = new JTextField();
/* 260 */     this.fullNameLabel = new JLabel();
/* 261 */     this.stateLabel = new JLabel();
/* 262 */     this.manualState = new JTextField();
/* 263 */     this.manualZip = new JTextField();
/* 264 */     this.zipLabel = new JLabel();
/* 265 */     this.cityLabel = new JLabel();
/* 266 */     this.manualCity = new JTextField();
/* 267 */     this.manualRun = new JButton();
/* 268 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 269 */     this.manualOutput = new JTextArea();
/* 270 */     this.manualClear = new JButton();
/* 271 */     this.export = new JButton();
/* 272 */     this.pointsPanel = new JPanel();
/* 273 */     this.statesLabel = new JLabel();
/* 274 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 275 */     this.statesPointsArea = new JTextArea();
/* 276 */     this.candidatesLabel = new JLabel();
/* 277 */     this.jScrollPane4 = new javax.swing.JScrollPane();
/* 278 */     this.candidatesPointsArea = new JTextArea();
/* 279 */     this.partiesLabel = new JLabel();
/* 280 */     this.demPointsField = new JTextField();
/* 281 */     this.democratLabel = new JLabel();
/* 282 */     this.republicanLabel = new JLabel();
/* 283 */     this.repubPointsField = new JTextField();
/* 284 */     this.savePointSettings = new JButton();
/* 285 */     this.settingsPanel = new JPanel();
/* 286 */     this.filterEmployerCheck = new JCheckBox();
/* 287 */     this.calculatePointsCheck = new JCheckBox();
/* 288 */     this.weightByAmountCheck = new JCheckBox();
/* 289 */     this.filterOccupationCheck = new JCheckBox();
/* 290 */     this.filterCityCheck = new JCheckBox();
/* 291 */     this.filterZipCheck = new JCheckBox();
/* 292 */     this.jLabel4 = new JLabel();
/* 293 */     this.pointsLabel = new JLabel();
/* 294 */     this.minimumCycleLabel = new JLabel();
/* 295 */     this.APIKeyField = new JTextField();
/* 296 */     this.APILabel = new JLabel();
/* 297 */     this.cycleSlider = new javax.swing.JSlider();
/* 298 */     this.setAPIKey = new JButton();
/* 299 */     this.getKeyButton = new JButton();
/* 300 */     this.jMenuBar1 = new javax.swing.JMenuBar();
/* 301 */     this.jMenu2 = new javax.swing.JMenu();
/* 302 */     this.getAPIKeyMenuButton = new JMenuItem();
/* 303 */     this.reportAnIssueMenuButton = new JMenuItem();
/* 304 */     this.AboutAndLegal = new JMenuItem();
/*     */     
/* 306 */     this.menu1.setLabel("File");
/* 307 */     this.menuBar1.add(this.menu1);
/*     */     
/* 309 */     this.menu2.setLabel("Edit");
/* 310 */     this.menuBar1.add(this.menu2);
/*     */     
/* 312 */     this.menu3.setLabel("File");
/* 313 */     this.menuBar2.add(this.menu3);
/*     */     
/* 315 */     this.menu4.setLabel("Edit");
/* 316 */     this.menuBar2.add(this.menu4);
/*     */     
/* 318 */     this.popupMenu1.setLabel("popupMenu1");
/*     */     
/* 320 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/* 331 */     this.jScrollPane3.setViewportView(this.jTable1);
/*     */     
/* 333 */     setDefaultCloseOperation(3);
/* 334 */     setMaximumSize(new java.awt.Dimension(520, 320));
/* 335 */     setResizable(false);
/* 336 */     getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/* 338 */     this.CSVPanel.setBackground(new java.awt.Color(230, 230, 230));
/* 339 */     this.CSVPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/* 341 */     this.fileSelectedLabel.setText("No File Selected");
/* 342 */     this.CSVPanel.add(this.fileSelectedLabel, new AbsoluteConstraints(170, 20, -1, 30));
/*     */     
/* 344 */     this.chooseCSVButton.setText("Choose CSV");
/* 345 */     this.chooseCSVButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 347 */         DonorLookup.this.chooseCSVButtonActionPerformed(evt);
/*     */       }
/* 349 */     });
/* 350 */     this.CSVPanel.add(this.chooseCSVButton, new AbsoluteConstraints(20, 20, 140, 30));
/*     */     
/* 352 */     this.runButton.setText("Run");
/* 353 */     this.runButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 355 */         DonorLookup.this.runButtonActionPerformed(evt);
/*     */       }
/* 357 */     });
/* 358 */     this.CSVPanel.add(this.runButton, new AbsoluteConstraints(20, 140, 140, 30));
/*     */     
/* 360 */     this.setDestinationButton.setText("Set Destination");
/* 361 */     this.setDestinationButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 363 */         DonorLookup.this.setDestinationButtonActionPerformed(evt);
/*     */       }
/* 365 */     });
/* 366 */     this.CSVPanel.add(this.setDestinationButton, new AbsoluteConstraints(20, 80, -1, -1));
/*     */     
/* 368 */     this.jLabel9.setText("No Destination Selected");
/* 369 */     this.CSVPanel.add(this.jLabel9, new AbsoluteConstraints(170, 80, -1, 30));
/* 370 */     this.CSVPanel.add(this.jSeparator1, new AbsoluteConstraints(0, 60, 500, -1));
/* 371 */     this.CSVPanel.add(this.jSeparator2, new AbsoluteConstraints(0, 120, 500, -1));
/* 372 */     this.CSVPanel.add(this.jSeparator3, new AbsoluteConstraints(0, 190, 500, -1));
/* 373 */     this.CSVPanel.add(this.batchProgressBar, new AbsoluteConstraints(170, 140, 280, 30));
/* 374 */     this.CSVPanel.add(this.jLabel1, new AbsoluteConstraints(170, 170, 280, 20));
/*     */     
/* 376 */     this.jTabbedPane1.addTab("CSV", this.CSVPanel);
/*     */     
/* 378 */     this.manualDataPanel.setBackground(new java.awt.Color(230, 230, 230));
/* 379 */     this.manualDataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/* 381 */     this.manualName.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 383 */         DonorLookup.this.manualNameActionPerformed(evt);
/*     */       }
/* 385 */     });
/* 386 */     this.manualDataPanel.add(this.manualName, new AbsoluteConstraints(90, 10, 170, -1));
/*     */     
/* 388 */     this.fullNameLabel.setText("Full Name:");
/* 389 */     this.manualDataPanel.add(this.fullNameLabel, new AbsoluteConstraints(20, 10, -1, 30));
/*     */     
/* 391 */     this.stateLabel.setText("State:");
/* 392 */     this.manualDataPanel.add(this.stateLabel, new AbsoluteConstraints(270, 10, -1, 30));
/* 393 */     this.manualDataPanel.add(this.manualState, new AbsoluteConstraints(310, 10, 42, -1));
/* 394 */     this.manualDataPanel.add(this.manualZip, new AbsoluteConstraints(210, 40, 90, -1));
/*     */     
/* 396 */     this.zipLabel.setText("Zip:");
/* 397 */     this.manualDataPanel.add(this.zipLabel, new AbsoluteConstraints(180, 40, -1, 30));
/*     */     
/* 399 */     this.cityLabel.setText("City:");
/* 400 */     this.manualDataPanel.add(this.cityLabel, new AbsoluteConstraints(20, 40, -1, 30));
/* 401 */     this.manualDataPanel.add(this.manualCity, new AbsoluteConstraints(60, 40, 110, -1));
/*     */     
/* 403 */     this.manualRun.setText("Run");
/* 404 */     this.manualRun.setFocusable(false);
/* 405 */     this.manualRun.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 407 */         DonorLookup.this.manualRunActionPerformed(evt);
/*     */       }
/* 409 */     });
/* 410 */     this.manualDataPanel.add(this.manualRun, new AbsoluteConstraints(375, 10, 110, -1));
/*     */     
/* 412 */     this.manualOutput.setEditable(false);
/* 413 */     this.manualOutput.setBackground(new java.awt.Color(230, 230, 230));
/* 414 */     this.manualOutput.setColumns(15);
/* 415 */     this.manualOutput.setLineWrap(true);
/* 416 */     this.manualOutput.setRows(5);
/* 417 */     this.manualOutput.setWrapStyleWord(true);
/* 418 */     this.manualOutput.setCursor(new java.awt.Cursor(0));
/* 419 */     this.jScrollPane1.setViewportView(this.manualOutput);
/*     */     
/* 421 */     this.manualDataPanel.add(this.jScrollPane1, new AbsoluteConstraints(10, 112, 470, 150));
/*     */     
/* 423 */     this.manualClear.setText("Clear");
/* 424 */     this.manualClear.setFocusable(false);
/* 425 */     this.manualClear.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 427 */         DonorLookup.this.manualClearActionPerformed(evt);
/*     */       }
/* 429 */     });
/* 430 */     this.manualDataPanel.add(this.manualClear, new AbsoluteConstraints(376, 40, 110, -1));
/*     */     
/* 432 */     this.export.setText("Export");
/* 433 */     this.export.setEnabled(false);
/* 434 */     this.export.setFocusable(false);
/* 435 */     this.export.setPreferredSize(new java.awt.Dimension(76, 29));
/* 436 */     this.export.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 438 */         DonorLookup.this.exportActionPerformed(evt);
/*     */       }
/* 440 */     });
/* 441 */     this.manualDataPanel.add(this.export, new AbsoluteConstraints(376, 70, 110, -1));
/*     */     
/* 443 */     this.jTabbedPane1.addTab("Manual Data", this.manualDataPanel);
/*     */     
/* 445 */     this.pointsPanel.setBackground(new java.awt.Color(230, 230, 230));
/* 446 */     this.pointsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/* 448 */     this.statesLabel.setText("States");
/* 449 */     this.pointsPanel.add(this.statesLabel, new AbsoluteConstraints(10, 10, -1, -1));
/*     */     
/* 451 */     this.statesPointsArea.setColumns(4);
/* 452 */     this.statesPointsArea.setRows(5);
/* 453 */     this.statesPointsArea.setText(this.thePointSettings.getStatesString());
/* 454 */     this.jScrollPane2.setViewportView(this.statesPointsArea);
/*     */     
/* 456 */     this.pointsPanel.add(this.jScrollPane2, new AbsoluteConstraints(10, 30, 60, 200));
/*     */     
/* 458 */     this.candidatesLabel.setText("Candidates");
/* 459 */     this.pointsPanel.add(this.candidatesLabel, new AbsoluteConstraints(80, 10, -1, -1));
/*     */     
/* 461 */     this.candidatesPointsArea.setColumns(10);
/* 462 */     this.candidatesPointsArea.setRows(5);
/* 463 */     this.candidatesPointsArea.setText(this.thePointSettings.getCandidatesString());
/* 464 */     this.jScrollPane4.setViewportView(this.candidatesPointsArea);
/*     */     
/* 466 */     this.pointsPanel.add(this.jScrollPane4, new AbsoluteConstraints(80, 30, 240, 200));
/*     */     
/* 468 */     this.partiesLabel.setText("Parties");
/* 469 */     this.pointsPanel.add(this.partiesLabel, new AbsoluteConstraints(340, 10, -1, -1));
/*     */     
/* 471 */     this.demPointsField.setText(Integer.toString(this.thePointSettings.demPoints));
/* 472 */     this.demPointsField.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 474 */         DonorLookup.this.demPointsFieldActionPerformed(evt);
/*     */       }
/* 476 */     });
/* 477 */     this.pointsPanel.add(this.demPointsField, new AbsoluteConstraints(420, 30, 70, -1));
/*     */     
/* 479 */     this.democratLabel.setText("Democrat");
/* 480 */     this.pointsPanel.add(this.democratLabel, new AbsoluteConstraints(340, 30, -1, 30));
/*     */     
/* 482 */     this.republicanLabel.setText("Republican");
/* 483 */     this.pointsPanel.add(this.republicanLabel, new AbsoluteConstraints(340, 66, -1, 20));
/*     */     
/* 485 */     this.repubPointsField.setText(Integer.toString(this.thePointSettings.repubPoints));
/* 486 */     this.repubPointsField.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 488 */         DonorLookup.this.repubPointsFieldActionPerformed(evt);
/*     */       }
/* 490 */     });
/* 491 */     this.pointsPanel.add(this.repubPointsField, new AbsoluteConstraints(420, 60, 70, -1));
/*     */     
/* 493 */     this.savePointSettings.setText("Save");
/* 494 */     this.savePointSettings.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 496 */         DonorLookup.this.savePointSettingsActionPerformed(evt);
/*     */       }
/* 498 */     });
/* 499 */     this.pointsPanel.add(this.savePointSettings, new AbsoluteConstraints(390, 100, 100, -1));
/*     */     
/* 501 */     this.jTabbedPane1.addTab("Points", this.pointsPanel);
/*     */     
/* 503 */     this.settingsPanel.setBackground(new java.awt.Color(230, 230, 230));
/* 504 */     this.settingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
/*     */     
/* 506 */     this.filterEmployerCheck.setSelected(this.theSettings.filterEmployer.booleanValue());
/* 507 */     this.filterEmployerCheck.setText("Employer");
/* 508 */     this.filterEmployerCheck.setEnabled(false);
/* 509 */     this.filterEmployerCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 511 */         DonorLookup.this.filterEmployerCheckActionPerformed(evt);
/*     */       }
/* 513 */     });
/* 514 */     this.settingsPanel.add(this.filterEmployerCheck, new AbsoluteConstraints(310, 100, -1, -1));
/*     */     
/* 516 */     this.calculatePointsCheck.setSelected(this.theSettings.calculatePoints.booleanValue());
/* 517 */     this.calculatePointsCheck.setText("Calculate Points");
/* 518 */     this.calculatePointsCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 520 */         DonorLookup.this.calculatePointsCheckActionPerformed(evt);
/*     */       }
/* 522 */     });
/* 523 */     this.settingsPanel.add(this.calculatePointsCheck, new AbsoluteConstraints(310, 150, -1, -1));
/*     */     
/* 525 */     this.weightByAmountCheck.setSelected(this.theSettings.weighByAmount.booleanValue());
/* 526 */     this.weightByAmountCheck.setText("Weigh by Amount");
/* 527 */     this.weightByAmountCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 529 */         DonorLookup.this.weightByAmountCheckActionPerformed(evt);
/*     */       }
/* 531 */     });
/* 532 */     this.settingsPanel.add(this.weightByAmountCheck, new AbsoluteConstraints(310, 170, -1, -1));
/*     */     
/* 534 */     this.filterOccupationCheck.setSelected(this.theSettings.filterOccupation.booleanValue());
/* 535 */     this.filterOccupationCheck.setText("Occupation");
/* 536 */     this.filterOccupationCheck.setEnabled(false);
/* 537 */     this.filterOccupationCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 539 */         DonorLookup.this.filterOccupationCheckActionPerformed(evt);
/*     */       }
/* 541 */     });
/* 542 */     this.settingsPanel.add(this.filterOccupationCheck, new AbsoluteConstraints(310, 80, -1, -1));
/*     */     
/* 544 */     this.filterCityCheck.setSelected(this.theSettings.filterCity.booleanValue());
/* 545 */     this.filterCityCheck.setText("City");
/* 546 */     this.filterCityCheck.setEnabled(false);
/* 547 */     this.filterCityCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 549 */         DonorLookup.this.filterCityCheckActionPerformed(evt);
/*     */       }
/* 551 */     });
/* 552 */     this.settingsPanel.add(this.filterCityCheck, new AbsoluteConstraints(310, 60, -1, -1));
/*     */     
/* 554 */     this.filterZipCheck.setSelected(this.theSettings.filterZip.booleanValue());
/* 555 */     this.filterZipCheck.setText("Zip");
/* 556 */     this.filterZipCheck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 558 */         DonorLookup.this.filterZipCheckActionPerformed(evt);
/*     */       }
/* 560 */     });
/* 561 */     this.settingsPanel.add(this.filterZipCheck, new AbsoluteConstraints(310, 40, -1, -1));
/*     */     
/* 563 */     this.jLabel4.setText("Filter By:");
/* 564 */     this.settingsPanel.add(this.jLabel4, new AbsoluteConstraints(310, 20, 90, -1));
/*     */     
/* 566 */     this.pointsLabel.setText("Points:");
/* 567 */     this.settingsPanel.add(this.pointsLabel, new AbsoluteConstraints(310, 130, -1, -1));
/*     */     
/* 569 */     this.minimumCycleLabel.setText("Minimum Cycle:");
/* 570 */     this.settingsPanel.add(this.minimumCycleLabel, new AbsoluteConstraints(20, 20, -1, -1));
/*     */     
/* 572 */     this.APIKeyField.setText(this.theSettings.APIKey);
/* 573 */     this.APIKeyField.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 575 */         DonorLookup.this.APIKeyFieldActionPerformed(evt);
/*     */       }
/* 577 */     });
/* 578 */     this.settingsPanel.add(this.APIKeyField, new AbsoluteConstraints(20, 120, 170, -1));
/*     */     
/* 580 */     this.APILabel.setText("API Key:");
/* 581 */     this.settingsPanel.add(this.APILabel, new AbsoluteConstraints(20, 100, -1, -1));
/*     */     
/* 583 */     this.cycleSlider.setMajorTickSpacing(2);
/* 584 */     this.cycleSlider.setMaximum(16);
/* 585 */     this.cycleSlider.setPaintLabels(true);
/* 586 */     this.cycleSlider.setPaintTicks(true);
/* 587 */     this.cycleSlider.setSnapToTicks(true);
/* 588 */     this.cycleSlider.setValue(Integer.parseInt(this.theSettings.cycle.substring(2, 4)));
/* 589 */     this.cycleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 591 */         DonorLookup.this.cycleSliderStateChanged(evt);
/*     */       }
/* 593 */     });
/* 594 */     this.settingsPanel.add(this.cycleSlider, new AbsoluteConstraints(20, 40, 200, -1));
/*     */     
/* 596 */     this.setAPIKey.setText("Set Key");
/* 597 */     this.setAPIKey.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 599 */         DonorLookup.this.setAPIKeyActionPerformed(evt);
/*     */       }
/* 601 */     });
/* 602 */     this.settingsPanel.add(this.setAPIKey, new AbsoluteConstraints(190, 120, -1, -1));
/*     */     
/* 604 */     this.getKeyButton.setText("Get Key");
/* 605 */     this.getKeyButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 607 */         DonorLookup.this.getKeyButtonActionPerformed(evt);
/*     */       }
/* 609 */     });
/* 610 */     this.settingsPanel.add(this.getKeyButton, new AbsoluteConstraints(190, 150, -1, -1));
/*     */     
/* 612 */     this.jTabbedPane1.addTab("Settings", this.settingsPanel);
/*     */     
/* 614 */     getContentPane().add(this.jTabbedPane1, new AbsoluteConstraints(0, 0, 520, 320));
/*     */     
/* 616 */     this.jMenu2.setText("Help");
/*     */     
/* 618 */     this.getAPIKeyMenuButton.setText("Get API Key...");
/* 619 */     this.getAPIKeyMenuButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 621 */         DonorLookup.this.getAPIKeyMenuButtonActionPerformed(evt);
/*     */       }
/* 623 */     });
/* 624 */     this.jMenu2.add(this.getAPIKeyMenuButton);
/*     */     
/* 626 */     this.reportAnIssueMenuButton.setText("Report an Issue...");
/* 627 */     this.reportAnIssueMenuButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 629 */         DonorLookup.this.reportAnIssueMenuButtonActionPerformed(evt);
/*     */       }
/* 631 */     });
/* 632 */     this.jMenu2.add(this.reportAnIssueMenuButton);
/*     */     
/* 634 */     this.AboutAndLegal.setText("About and Legal...");
/* 635 */     this.AboutAndLegal.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 637 */         DonorLookup.this.AboutAndLegalActionPerformed(evt);
/*     */       }
/* 639 */     });
/* 640 */     this.jMenu2.add(this.AboutAndLegal);
/*     */     
/* 642 */     this.jMenuBar1.add(this.jMenu2);
/*     */     
/* 644 */     setJMenuBar(this.jMenuBar1);
/*     */     
/* 646 */     pack(); }
/*     */   
/*     */   private javax.swing.JScrollPane jScrollPane2; private javax.swing.JScrollPane jScrollPane3;
/* 649 */   private void runButtonActionPerformed(ActionEvent evt) { BatchDonorResearch t = new BatchDonorResearch();
/* 650 */     Thread theThread = new Thread(t);
/*     */     
/*     */     try
/*     */     {
/* 654 */       if (this.running) {
/* 655 */         this.running = false;
/*     */       }
/*     */       else {
/* 658 */         this.running = true;
/* 659 */         theThread.start();
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 663 */       Error.showError(0);
/* 664 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex); } }
/*     */   
/*     */   private javax.swing.JScrollPane jScrollPane4;
/*     */   private javax.swing.JSeparator jSeparator1;
/*     */   private javax.swing.JSeparator jSeparator2;
/*     */   
/* 670 */   private void filterZipCheckActionPerformed(ActionEvent evt) { if (this.theSettings.getFilterZip().booleanValue()) {
/* 671 */       this.theSettings.setFilterZip(Boolean.valueOf(false));
/*     */     } else {
/* 673 */       this.theSettings.setFilterZip(Boolean.valueOf(true));
/*     */     }
/*     */     try
/*     */     {
/* 677 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 679 */       Error.showError(4);
/* 680 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex); } }
/*     */   
/*     */   private javax.swing.JSeparator jSeparator3;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   private javax.swing.JTable jTable1;
/*     */   private JTextField manualCity;
/*     */   private JButton manualClear;
/*     */   private JPanel manualDataPanel;
/*     */   private JTextField manualName;
/*     */   private JTextArea manualOutput;
/*     */   private JButton manualRun;
/*     */   private JTextField manualState;
/*     */   private JTextField manualZip;
/*     */   private java.awt.Menu menu1;
/*     */   private java.awt.Menu menu2;
/*     */   
/* 696 */   private void chooseCSVButtonActionPerformed(ActionEvent evt) { JFileChooser fc = new JFileChooser();
/* 697 */     fc.setDialogTitle("Choose a CSV File to Research");
/* 698 */     fc.setFileFilter(new javax.swing.filechooser.FileFilter()
/*     */     {
/*     */       public boolean accept(File f)
/*     */       {
/* 688 */         return ((f.isFile()) && (f.getName().toLowerCase().endsWith(".csv"))) || (f.isDirectory());
/*     */       }
/*     */       
/*     */       public String getDescription()
/*     */       {
/* 693 */         return "*.csv";
/*     */ 
/*     */       }
/*     */       
/*     */ 
/* 698 */     });
/* 699 */     int returnVal = fc.showOpenDialog(null);
/* 700 */     if (returnVal == 0) {
/* 701 */       File file = fc.getSelectedFile();
/* 702 */       this.fileLocation = file.getAbsolutePath();
/* 703 */       this.fileSelectedLabel.setText(file.getName()); } }
/*     */   
/*     */   private void manualNameActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private java.awt.Menu menu3;
/*     */   private java.awt.Menu menu4;
/*     */   
/* 710 */   private void AboutAndLegalActionPerformed(ActionEvent evt) { AboutDialog.main(null); }
/*     */   
/*     */   private java.awt.MenuBar menuBar1;
/*     */   
/* 714 */   private void getAPIKeyMenuButtonActionPerformed(ActionEvent evt) { java.awt.Desktop d = java.awt.Desktop.getDesktop();
/*     */     try
/*     */     {
/* 717 */       d.browse(new java.net.URI("http://sunlightfoundation.com/api/accounts/register/"));
/*     */     } catch (IOException|java.net.URISyntaxException ex) {
/* 719 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } }
/*     */   
/*     */   private java.awt.MenuBar menuBar2;
/*     */   private void reportAnIssueMenuButtonActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void APIKeyFieldActionPerformed(ActionEvent evt) {}
/*     */   
/* 727 */   private void filterOccupationCheckActionPerformed(ActionEvent evt) { if (this.theSettings.getFilterOccupation().booleanValue()) {
/* 728 */       this.theSettings.setFilterOccupation(Boolean.valueOf(false));
/*     */     } else {
/* 730 */       this.theSettings.setFilterOccupation(Boolean.valueOf(true));
/*     */     }
/*     */     try {
/* 733 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 735 */       Error.showError(4);
/* 736 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void filterCityCheckActionPerformed(ActionEvent evt) {
/* 741 */     if (this.theSettings.getFilterCity().booleanValue()) {
/* 742 */       this.theSettings.setFilterCity(Boolean.valueOf(false));
/*     */     } else {
/* 744 */       this.theSettings.setFilterCity(Boolean.valueOf(true));
/*     */     }
/*     */     try {
/* 747 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 749 */       Error.showError(4);
/* 750 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/* 754 */   private void filterEmployerCheckActionPerformed(ActionEvent evt) { if (this.theSettings.getFilterEmployer().booleanValue()) {
/* 755 */       this.theSettings.setFilterEmployer(Boolean.valueOf(false));
/*     */     } else {
/* 757 */       this.theSettings.setFilterEmployer(Boolean.valueOf(true));
/*     */     }
/*     */     try {
/* 760 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 762 */       Error.showError(4);
/* 763 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/* 767 */   private void cycleSliderStateChanged(javax.swing.event.ChangeEvent evt) { int currentValue = this.cycleSlider.getValue();
/* 768 */     String cyclesString = "";
/* 769 */     for (int i = currentValue; i <= 16; i++) {
/* 770 */       if (i != currentValue) {
/* 771 */         cyclesString = cyclesString + "|";
/*     */       }
/* 773 */       if (i / 10 == 0) {
/* 774 */         cyclesString = cyclesString + "200" + i;
/*     */       } else {
/* 776 */         cyclesString = cyclesString + "20" + i;
/*     */       }
/*     */     }
/* 779 */     this.theSettings.setCycle(cyclesString);
/*     */     try {
/* 781 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 783 */       Error.showError(4);
/* 784 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private JLabel minimumCycleLabel;
/*     */   private JLabel partiesLabel;
/*     */   private JLabel pointsLabel;
/*     */   private JPanel pointsPanel;
/*     */   private java.awt.PopupMenu popupMenu1;
/*     */   private JMenuItem reportAnIssueMenuButton;
/*     */   private JTextField repubPointsField;
/*     */   private JLabel republicanLabel;
/*     */   private JButton runButton;
/*     */   
/*     */   private void setDestinationButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 800 */     JFileChooser fc = new JFileChooser();
/* 801 */     fc.setDialogTitle("Save File");
/* 802 */     fc.setFileFilter(new javax.swing.filechooser.FileFilter()
/*     */     {
/*     */       public boolean accept(File f)
/*     */       {
/* 792 */         return ((f.isFile()) && (f.getName().toLowerCase().endsWith(".csv"))) || (f.isDirectory());
/*     */       }
/*     */       
/*     */       public String getDescription()
/*     */       {
/* 797 */         return "*.csv";
/*     */ 
/*     */       }
/*     */       
/*     */ 
/* 802 */     });
/* 803 */     int returnVal = fc.showSaveDialog(null);
/* 804 */     if (returnVal == 0) {
/* 805 */       this.destinationLocation = fc.getSelectedFile().getAbsolutePath();
/* 806 */       if (!this.destinationLocation.endsWith(".csv")) {
/* 807 */         this.destinationLocation += ".csv";
/*     */       }
/* 809 */       this.jLabel9.setText(this.destinationLocation);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setAPIKeyActionPerformed(ActionEvent evt)
/*     */   {
/* 816 */     this.theSettings.setAPIKey(this.APIKeyField.getText().trim());
/*     */     try {
/* 818 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 820 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/* 824 */   private void manualClearActionPerformed(ActionEvent evt) { this.manualOutput.setText(""); }
/*     */   
/*     */ 
/*     */   private void manualRunActionPerformed(ActionEvent evt)
/*     */   {
/* 829 */     ManualDonorResearch t = new ManualDonorResearch();
/* 830 */     Thread theThread = new Thread(t);
/* 831 */     theThread.start();
/*     */   }
/*     */   
/*     */   private void demPointsFieldActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void savePointSettingsActionPerformed(ActionEvent evt)
/*     */   {
/* 838 */     if (!this.demPointsField.getText().trim().isEmpty()) {
/* 839 */       this.thePointSettings.demPoints = Integer.parseInt(this.demPointsField.getText().trim());
/*     */     }
/* 841 */     if (!this.repubPointsField.getText().trim().isEmpty()) {
/* 842 */       this.thePointSettings.repubPoints = Integer.parseInt(this.repubPointsField.getText().trim());
/*     */     }
/* 844 */     this.thePointSettings.areSet = true;
/* 845 */     this.thePointSettings.statesPoints.clear();
/* 846 */     this.thePointSettings.states.clear();
/* 847 */     this.thePointSettings.candidatesPoints.clear();
/* 848 */     this.thePointSettings.candidates.clear();
/* 849 */     if (!this.statesPointsArea.getText().trim().isEmpty()) {
/* 850 */       for (String line : this.statesPointsArea.getText().split("\n")) {
/* 851 */         line = line.trim();
/* 852 */         line = line.replace(" ,", ",");
/* 853 */         this.thePointSettings.statesPoints.add(line);
/* 854 */         String theState = line.substring(0, line.indexOf(",")).trim();
/* 855 */         this.thePointSettings.states.add(theState);
/*     */       }
/*     */     }
/* 858 */     if (!this.candidatesPointsArea.getText().trim().isEmpty()) {
/* 859 */       for (String line : this.candidatesPointsArea.getText().split("\n")) {
/* 860 */         line = line.trim();
/* 861 */         line = line.replace(" ,", ",");
/* 862 */         this.thePointSettings.candidatesPoints.add(line);
/* 863 */         String theCandidate = line.substring(0, line.indexOf(",")).trim();
/* 864 */         this.thePointSettings.candidates.add(theCandidate);
/*     */       }
/*     */     }
/*     */     try {
/* 868 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 870 */       Error.showError(4);
/* 871 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void repubPointsFieldActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void calculatePointsCheckActionPerformed(ActionEvent evt)
/*     */   {
/* 879 */     if (this.theSettings.getCalculatePoints().booleanValue()) {
/* 880 */       this.theSettings.setCalculatePoints(Boolean.valueOf(false));
/*     */     } else {
/* 882 */       this.theSettings.setCalculatePoints(Boolean.valueOf(true));
/*     */     }
/*     */     try {
/* 885 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 887 */       Error.showError(4);
/* 888 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void weightByAmountCheckActionPerformed(ActionEvent evt) {
/* 893 */     if (this.theSettings.getWeighByAmount().booleanValue()) {
/* 894 */       this.theSettings.setWeighByAmount(Boolean.valueOf(false));
/*     */     } else {
/* 896 */       this.theSettings.setWeighByAmount(Boolean.valueOf(true));
/*     */     }
/*     */     try {
/* 899 */       SavedSettings.writeSettings(this.thePointSettings, this.theSettings, "settings.dz2");
/*     */     } catch (IOException ex) {
/* 901 */       Error.showError(4);
/* 902 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void getKeyButtonActionPerformed(ActionEvent evt) {
/* 907 */     java.awt.Desktop d = java.awt.Desktop.getDesktop();
/*     */     
/*     */     try
/*     */     {
/* 911 */       d.browse(new java.net.URI("http://sunlightfoundation.com/api/accounts/register/"));
/*     */     } catch (IOException|java.net.URISyntaxException ex) {
/* 913 */       Error.showError(5);
/* 914 */       Logger.getLogger(DonorLookup.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } }
/*     */   
/*     */   private JButton savePointSettings;
/*     */   private JButton setAPIKey;
/*     */   private JButton setDestinationButton;
/*     */   private JPanel settingsPanel;
/*     */   
/*     */   private void exportActionPerformed(ActionEvent evt) {}
/*     */   
/* 924 */   public static void main(String[] args) { System.setProperty("apple.laf.useScreenMenuBar", "true");
/*     */     
/*     */ 
/* 927 */     java.awt.EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 930 */         new DonorLookup().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private JLabel stateLabel;
/*     */   private JLabel statesLabel;
/*     */   private JTextArea statesPointsArea;
/*     */   private JCheckBox weightByAmountCheck;
/*     */   private JLabel zipLabel;
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\DonorLookup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */