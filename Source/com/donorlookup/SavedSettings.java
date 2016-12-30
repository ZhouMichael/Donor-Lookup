/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SavedSettings
/*    */ {
/*    */   public static void writeSettings(PointSettings tPS, Properties tP, String fileName)
/*    */     throws IOException
/*    */   {
/* 19 */     FileWriter file = new FileWriter(fileName);
/* 20 */     file.append(tP.filterZip.toString());
/* 21 */     file.append("ff@");
/* 22 */     file.append(tP.filterCity.toString());
/* 23 */     file.append("ff@");
/* 24 */     file.append(tP.filterEmployer.toString());
/* 25 */     file.append("ff@");
/* 26 */     file.append(tP.filterOccupation.toString());
/* 27 */     file.append("ff@");
/* 28 */     file.append(tP.calculatePoints.toString());
/* 29 */     file.append("ff@");
/* 30 */     file.append(tP.weighByAmount.toString());
/* 31 */     file.append("ff@");
/* 32 */     file.append(tP.cycle);
/* 33 */     file.append("ff@");
/* 34 */     file.append(tP.APIKey);
/* 35 */     file.append("\n");
/* 36 */     for (int i = 0; i < tPS.statesPoints.size(); i++)
/*    */     {
/* 38 */       file.append((CharSequence)tPS.statesPoints.get(i));
/* 39 */       if (i < tPS.statesPoints.size() - 1) {
/* 40 */         file.append("%V2#");
/*    */       }
/*    */     }
/* 43 */     file.append("ff@");
/* 44 */     for (int i = 0; i < tPS.candidatesPoints.size(); i++)
/*    */     {
/* 46 */       file.append((CharSequence)tPS.candidatesPoints.get(i));
/* 47 */       if (i < tPS.candidatesPoints.size() - 1) {
/* 48 */         file.append("%V2#");
/*    */       }
/*    */     }
/* 51 */     file.append("ff@");
/* 52 */     file.append(Integer.toString(tPS.demPoints));
/* 53 */     file.append("ff@");
/* 54 */     file.append(Integer.toString(tPS.repubPoints));
/* 55 */     file.flush();
/*    */   }
/*    */   
/*    */   public static String[] readSettings(String file_name, int signal)
/*    */   {
/*    */     try {
/* 61 */       BufferedReader file = new BufferedReader(new FileReader(file_name));
/* 62 */       if (signal == 1)
/*    */         try {
/* 64 */           file.readLine();
/*    */         } catch (IOException ex) {
/* 66 */           Logger.getLogger(SavedSettings.class.getName()).log(Level.SEVERE, null, ex);
/*    */         }
/* 68 */       String raw_data = null;
/*    */       try {
/* 70 */         raw_data = file.readLine();
/*    */       } catch (IOException ex) {
/* 72 */         Logger.getLogger(SavedSettings.class.getName()).log(Level.SEVERE, null, ex);
/*    */       }
/* 74 */       return raw_data.split("ff@");
/*    */     }
/*    */     catch (FileNotFoundException ex)
/*    */     {
/* 78 */       Logger.getLogger(SavedSettings.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/* 80 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\SavedSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */