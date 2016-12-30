/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ public class Properties
/*     */ {
/*     */   Boolean filterZip;
/*     */   Boolean filterCity;
/*     */   Boolean filterEmployer;
/*     */   Boolean filterOccupation;
/*     */   Boolean calculatePoints;
/*     */   Boolean weighByAmount;
/*     */   String cycle;
/*     */   String APIKey;
/*     */   
/*     */   public Properties(String loc)
/*     */   {
/*  19 */     File f = new File(loc);
/*  20 */     if (f.isFile())
/*     */     {
/*  22 */       String[] dummy = SavedSettings.readSettings(loc, 0);
/*  23 */       switch (dummy[0]) {
/*     */       case "true": 
/*  25 */         this.filterZip = Boolean.valueOf(true);
/*  26 */         break;
/*     */       case "false": 
/*  28 */         this.filterZip = Boolean.valueOf(false);
/*     */       }
/*     */       
/*  31 */       ??? = dummy[1];??? = -1; switch (???.hashCode()) {case 3569038:  if (???.equals("true")) ??? = 0; break; case 97196323:  if (???.equals("false")) ??? = 1; break; } switch (???) {
/*     */       case 0: 
/*  33 */         this.filterCity = Boolean.valueOf(true);
/*  34 */         break;
/*     */       case 1: 
/*  36 */         this.filterCity = Boolean.valueOf(false);
/*     */       }
/*     */       
/*  39 */       switch (dummy[2]) {
/*     */       case "true": 
/*  41 */         this.filterEmployer = Boolean.valueOf(true);
/*  42 */         break;
/*     */       case "false": 
/*  44 */         this.filterEmployer = Boolean.valueOf(false);
/*     */       }
/*     */       
/*  47 */       ??? = dummy[3];??? = -1; switch (???.hashCode()) {case 3569038:  if (???.equals("true")) ??? = 0; break; case 97196323:  if (???.equals("false")) ??? = 1; break; } switch (???) {
/*     */       case 0: 
/*  49 */         this.filterOccupation = Boolean.valueOf(true);
/*  50 */         break;
/*     */       case 1: 
/*  52 */         this.filterOccupation = Boolean.valueOf(false);
/*     */       }
/*     */       
/*  55 */       switch (dummy[4]) {
/*     */       case "true": 
/*  57 */         this.calculatePoints = Boolean.valueOf(true);
/*  58 */         break;
/*     */       case "false": 
/*  60 */         this.calculatePoints = Boolean.valueOf(false);
/*     */       }
/*     */       
/*  63 */       ??? = dummy[5];??? = -1; switch (???.hashCode()) {case 3569038:  if (???.equals("true")) ??? = 0; break; case 97196323:  if (???.equals("false")) ??? = 1; break; } switch (???) {
/*     */       case 0: 
/*  65 */         this.weighByAmount = Boolean.valueOf(true);
/*  66 */         break;
/*     */       case 1: 
/*  68 */         this.weighByAmount = Boolean.valueOf(false);
/*     */       }
/*     */       
/*     */       
/*  72 */       this.cycle = dummy[6];
/*  73 */       this.APIKey = dummy[7];
/*     */     }
/*     */     else {
/*  76 */       this.filterZip = Boolean.valueOf(false);
/*  77 */       this.filterCity = Boolean.valueOf(false);
/*  78 */       this.filterEmployer = Boolean.valueOf(false);
/*  79 */       this.filterOccupation = Boolean.valueOf(false);
/*  80 */       this.calculatePoints = Boolean.valueOf(false);
/*  81 */       this.weighByAmount = Boolean.valueOf(false);
/*  82 */       this.cycle = "2008|2010|2012|2014|2016";
/*  83 */       this.APIKey = "insert your API key";
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCalculatePoints()
/*     */   {
/*  89 */     return this.calculatePoints;
/*     */   }
/*     */   
/*     */   public void setCalculatePoints(Boolean calculatePoints) {
/*  93 */     this.calculatePoints = calculatePoints;
/*     */   }
/*     */   
/*     */   public Boolean getWeighByAmount() {
/*  97 */     return this.weighByAmount;
/*     */   }
/*     */   
/*     */   public void setWeighByAmount(Boolean weighByAmount) {
/* 101 */     this.weighByAmount = weighByAmount;
/*     */   }
/*     */   
/*     */   public String getCycle() {
/* 105 */     return this.cycle;
/*     */   }
/*     */   
/*     */   public void setCycle(String cycle) {
/* 109 */     this.cycle = cycle;
/*     */   }
/*     */   
/*     */   public String getAPIKey() {
/* 113 */     return this.APIKey;
/*     */   }
/*     */   
/*     */   public void setAPIKey(String APIKey) {
/* 117 */     this.APIKey = APIKey;
/*     */   }
/*     */   
/*     */   public Boolean getFilterZip() {
/* 121 */     return this.filterZip;
/*     */   }
/*     */   
/*     */   public void setFilterZip(Boolean filterZip) {
/* 125 */     this.filterZip = filterZip;
/*     */   }
/*     */   
/*     */   public Boolean getFilterCity() {
/* 129 */     return this.filterCity;
/*     */   }
/*     */   
/*     */   public void setFilterCity(Boolean filterCity) {
/* 133 */     this.filterCity = filterCity;
/*     */   }
/*     */   
/*     */   public Boolean getFilterEmployer() {
/* 137 */     return this.filterEmployer;
/*     */   }
/*     */   
/*     */   public void setFilterEmployer(Boolean filterEmployer) {
/* 141 */     this.filterEmployer = filterEmployer;
/*     */   }
/*     */   
/*     */   public Boolean getFilterOccupation() {
/* 145 */     return this.filterOccupation;
/*     */   }
/*     */   
/*     */   public void setFilterOccupation(Boolean filterOccupation) {
/* 149 */     this.filterOccupation = filterOccupation;
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Properties.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */