/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.io.FileWriter;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class CSVHandler
/*     */ {
/*     */   public static ArrayList<Donor> readCSV(String file_name) throws Exception
/*     */   {
/*  10 */     java.io.BufferedReader file = new java.io.BufferedReader(new java.io.FileReader(file_name));Throwable localThrowable2 = null;
/*  11 */     ArrayList<Donor> pickle; try { String row = file.readLine();
/*     */       
/*  13 */       int nameFlag = -1;
/*  14 */       int genderFlag = -1;
/*  15 */       int addressFlag = -1;
/*  16 */       int cityFlag = -1;
/*  17 */       int stateFlag = -1;
/*  18 */       int zipFlag = -1;
/*  19 */       int employerFlag = -1;
/*  20 */       int occupationFlag = -1;
/*     */       
/*  22 */       String[] header = row.split(",");
/*  23 */       for (int i = 0; i < header.length; i++) {
/*  24 */         header[i] = header[i].replaceAll("\\s+", "");
/*  25 */         header[i] = header[i].toUpperCase();
/*     */       }
/*  27 */       for (int i = 0; i < header.length; i++) {
/*  28 */         switch (header[i]) {
/*     */         case "NAME": 
/*  30 */           nameFlag = i;
/*  31 */           break;
/*     */         case "GENDER": 
/*  33 */           genderFlag = i;
/*  34 */           break;
/*     */         case "ADDRESS": 
/*  36 */           addressFlag = i;
/*  37 */           break;
/*     */         case "CITY": 
/*  39 */           cityFlag = i;
/*  40 */           break;
/*     */         case "STATE": 
/*  42 */           stateFlag = i;
/*  43 */           break;
/*     */         case "ZIP": 
/*  45 */           zipFlag = i;
/*  46 */           break;
/*     */         case "EMPLOYER": 
/*  48 */           employerFlag = i;
/*  49 */           break;
/*     */         case "OCCUPATION": 
/*  51 */           genderFlag = i;
/*     */         }
/*     */         
/*     */       }
/*  55 */       pickle = new ArrayList();
/*     */       
/*  57 */       row = file.readLine();
/*  58 */       while (row != null)
/*     */       {
/*  60 */         String[] info = new String[8];
/*  61 */         String[] CSV_data = new String[4];
/*  62 */         String[] split = row.split(",");
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
/*  74 */         int j = 0;
/*  75 */         while (j < CSV_data.length)
/*     */         {
/*     */           try {
/*  78 */             CSV_data[j] = split[j];
/*     */           }
/*     */           catch (Exception NullPointerException)
/*     */           {
/*  82 */             CSV_data[j] = "Null";
/*     */           }
/*  84 */           j++;
/*     */         }
/*     */         
/*  87 */         for (int i = 0; i < CSV_data.length; i++) {
/*     */           try
/*     */           {
/*  90 */             if ((CSV_data[i].equals("")) || (CSV_data[i].equals("N/A")) || (CSV_data[i].equals(null))) {
/*  91 */               CSV_data[i] = "Null";
/*     */             }
/*     */           }
/*     */           catch (Exception NullPointerException) {
/*  95 */             CSV_data[i] = null;
/*     */           }
/*     */         }
/*     */         
/*  99 */         for (int i = 0; i < info.length; i++) {
/*     */           try {
/* 101 */             if (i == nameFlag) {
/* 102 */               info[0] = CSV_data[i];
/* 103 */             } else if (i == genderFlag) {
/* 104 */               info[1] = CSV_data[i];
/* 105 */             } else if (i == addressFlag) {
/* 106 */               info[2] = CSV_data[i];
/* 107 */             } else if (i == cityFlag) {
/* 108 */               info[3] = CSV_data[i];
/* 109 */             } else if (i == stateFlag) {
/* 110 */               info[4] = CSV_data[i];
/* 111 */             } else if (i == zipFlag) {
/* 112 */               info[5] = null;
/* 113 */             } else if (i == employerFlag) {
/* 114 */               info[6] = CSV_data[i];
/* 115 */             } else if (i == occupationFlag) {
/* 116 */               info[7] = CSV_data[i];
/*     */             }
/*     */           }
/*     */           catch (NullPointerException e) {
/* 120 */             info[i] = null;
/*     */           }
/*     */         }
/*     */         
/* 124 */         pickle.add(new Donor(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[1]));
/*     */         
/*     */ 
/* 127 */         row = file.readLine();
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/*  10 */       localThrowable2 = localThrowable1;throw localThrowable1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
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
/*     */ 
/*     */ 
/*     */ 
/* 129 */       if (file != null) if (localThrowable2 != null) try { file.close(); } catch (Throwable x2) { localThrowable2.addSuppressed(x2); } else file.close(); }
/* 130 */     return pickle;
/*     */   }
/*     */   
/*     */   public static void writeCSV(ArrayList<Donor> in, String fileName, Properties theSettings) throws java.io.IOException {
/* 134 */     FileWriter file = new FileWriter(fileName);Throwable localThrowable2 = null;
/* 135 */     try { file.append("\"Name\"");
/* 136 */       file.append(',');
/* 137 */       file.append("\"State\"");
/* 138 */       file.append(',');
/* 139 */       file.append("\"Zip\"");
/* 140 */       file.append(',');
/* 141 */       file.append("\"Occupation\"");
/* 142 */       file.append(',');
/* 143 */       file.append("\"Employer\"");
/* 144 */       file.append(',');
/* 145 */       file.append("\"Key Donations\"");
/* 146 */       file.append(',');
/* 147 */       file.append("\"House Donations\"");
/* 148 */       file.append(',');
/* 149 */       file.append("\"D. House Donations\"");
/* 150 */       file.append(',');
/* 151 */       file.append("\"R. House Donations\"");
/* 152 */       file.append(',');
/* 153 */       file.append("\"Senate Donations\"");
/* 154 */       file.append(',');
/* 155 */       file.append("\"D. Senate Donations\"");
/* 156 */       file.append(',');
/* 157 */       file.append("\"R. Senate Donations\"");
/* 158 */       file.append(',');
/* 159 */       file.append("\"Other Donations\"");
/* 160 */       file.append(',');
/* 161 */       file.append("\"Donation History\"");
/* 162 */       file.append(',');
/* 163 */       file.append("\"Score\"");
/*     */       
/* 165 */       file.append('\n');
/*     */       
/* 167 */       for (int i = 0; i < in.size(); i++)
/*     */       {
/* 169 */         file.append("\"" + ((Donor)in.get(i)).getName() + "\"");
/* 170 */         file.append(',');
/* 171 */         file.append("\"" + ((Donor)in.get(i)).getState() + "\"");
/* 172 */         file.append(',');
/* 173 */         file.append("\"" + ((Donor)in.get(i)).getZip() + "\"");
/* 174 */         file.append(',');
/* 175 */         file.append("\"" + ((Donor)in.get(i)).getOccupation() + "\"");
/* 176 */         file.append(',');
/* 177 */         file.append("\"" + ((Donor)in.get(i)).getEmployer() + "\"");
/* 178 */         file.append(',');
/*     */         
/* 180 */         file.append("\"" + ((Donor)in.get(i)).getKeyDonationHistory() + "\"");
/* 181 */         file.append(',');
/*     */         
/* 183 */         file.append("\"" + ((Donor)in.get(i)).getHouseDonationHistory() + "\"");
/* 184 */         file.append(',');
/*     */         
/* 186 */         file.append("\"" + ((Donor)in.get(i)).getDHouseDonationHistory() + "\"");
/* 187 */         file.append(',');
/*     */         
/* 189 */         file.append("\"" + ((Donor)in.get(i)).getRHouseDonationHistory() + "\"");
/* 190 */         file.append(',');
/*     */         
/* 192 */         file.append("\"" + ((Donor)in.get(i)).getSenateDonationHistory() + "\"");
/* 193 */         file.append(',');
/*     */         
/* 195 */         file.append("\"" + ((Donor)in.get(i)).getDSenateDonationHistory() + "\"");
/* 196 */         file.append(',');
/*     */         
/* 198 */         file.append("\"" + ((Donor)in.get(i)).getRSenateDonationHistory() + "\"");
/* 199 */         file.append(',');
/*     */         
/* 201 */         file.append("\"" + ((Donor)in.get(i)).getOtherDonationHistory() + "\"");
/* 202 */         file.append(',');
/*     */         
/* 204 */         file.append("\"" + ((Donor)in.get(i)).getDonationHistoryAsString() + "\"");
/* 205 */         file.append(",\"");
/* 206 */         if ((((Donor)in.get(i)).getPointTotal() != 0.0D) && (theSettings.calculatePoints.booleanValue())) {
/* 207 */           file.append("" + ((Donor)in.get(i)).getPointTotal());
/*     */         }
/* 209 */         file.append("\"");
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
/* 227 */         file.append('\n');
/*     */       }
/*     */       
/* 230 */       file.flush();
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 134 */       localThrowable2 = localThrowable1;throw localThrowable1;
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
/*     */     }
/*     */     finally
/*     */     {
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
/* 231 */       if (file != null) if (localThrowable2 != null) try { file.close(); } catch (Throwable x2) { localThrowable2.addSuppressed(x2); } else file.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\CSVHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */