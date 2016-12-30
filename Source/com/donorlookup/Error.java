/*    */ package com.donorlookup;
/*    */ 
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Error
/*    */ {
/*    */   public static void showError(int errorCode)
/*    */   {
/* 18 */     String errorString = "";
/* 19 */     String ErrorSoundFile = "/System/Library/Sounds/Funk.aiff";
/* 20 */     Boolean showPopup = Boolean.valueOf(false);
/* 21 */     switch (errorCode) {
/*    */     case 0: 
/* 23 */       errorString = "Unknown Error";
/*    */       
/* 25 */       showPopup = Boolean.valueOf(true);
/* 26 */       break;
/*    */     case 1: 
/* 28 */       errorString = "Unable to set dock icon";
/* 29 */       showPopup = Boolean.valueOf(false);
/* 30 */       break;
/*    */     case 2: 
/* 32 */       errorString = "Unable to read selected file";
/*    */       
/*    */ 
/* 35 */       showPopup = Boolean.valueOf(true);
/* 36 */       break;
/*    */     case 3: 
/* 38 */       errorString = "Unable to write selected file";
/*    */       
/* 40 */       showPopup = Boolean.valueOf(true);
/* 41 */       break;
/*    */     case 4: 
/* 43 */       errorString = "Unable to save settings";
/* 44 */       Sound.play(ErrorSoundFile);
/* 45 */       showPopup = Boolean.valueOf(true);
/* 46 */       break;
/*    */     case 5: 
/* 48 */       errorString = "Unable to open URL. You can try opening it yourself at http://sunlightfoundation.com/api/accounts/register/";
/* 49 */       showPopup = Boolean.valueOf(false);
/*    */     }
/*    */     
/* 52 */     if (showPopup.booleanValue()) {
/* 53 */       JOptionPane.showMessageDialog(null, errorString, "Error #" + errorCode, 0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Error.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */