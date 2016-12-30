/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointSettings
/*    */ {
/* 15 */   ArrayList<String> states = new ArrayList();
/* 16 */   ArrayList<String> candidates = new ArrayList();
/* 17 */   ArrayList<String> statesPoints = new ArrayList();
/* 18 */   ArrayList<String> candidatesPoints = new ArrayList();
/*    */   int demPoints;
/* 20 */   int repubPoints; boolean areSet = false;
/*    */   
/*    */   public PointSettings(String loc) {
/* 23 */     File f = new File(loc);
/*    */     
/* 25 */     if (!f.isFile()) {
/* 26 */       this.areSet = false;
/*    */     } else {
/* 28 */       String[] dummy = SavedSettings.readSettings(loc, 1);
/* 29 */       this.demPoints = Integer.parseInt(dummy[2]);
/* 30 */       this.repubPoints = Integer.parseInt(dummy[3]);
/* 31 */       if (dummy[0].length() > 0) {
/* 32 */         for (String i : dummy[0].split("%V2#")) {
/* 33 */           this.statesPoints.add(i);
/* 34 */           String theState = i.substring(0, i.indexOf(","));
/* 35 */           this.states.add(theState);
/*    */         }
/*    */       }
/* 38 */       if (dummy[1].length() > 0) {
/* 39 */         for (String i : dummy[1].split("%V2#")) {
/* 40 */           this.candidatesPoints.add(i);
/* 41 */           String theCandidate = i.substring(0, i.indexOf(","));
/* 42 */           this.states.add(theCandidate);
/*    */         }
/*    */       }
/* 45 */       this.areSet = true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getStatesString()
/*    */   {
/* 53 */     String theString = "";
/* 54 */     for (String i : this.statesPoints) {
/* 55 */       theString = theString + i;
/* 56 */       theString = theString + "\n";
/*    */     }
/* 58 */     theString = theString.trim();
/* 59 */     return theString;
/*    */   }
/*    */   
/*    */   public String getCandidatesString() {
/* 63 */     String theString = "";
/* 64 */     for (String i : this.candidatesPoints) {
/* 65 */       theString = theString + i;
/* 66 */       theString = theString + "\n";
/*    */     }
/* 68 */     theString = theString.trim();
/* 69 */     return theString;
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\PointSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */