/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import sun.audio.AudioPlayer;
/*    */ import sun.audio.AudioStream;
/*    */ 
/*    */ public class Sound
/*    */ {
/*    */   public static void play(String gongFile)
/*    */   {
/* 16 */     InputStream in = null;
/*    */     try {
/* 18 */       in = new FileInputStream(gongFile);
/*    */     } catch (FileNotFoundException ex) {
/* 20 */       Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     
/*    */ 
/* 24 */     AudioStream audioStream = null;
/*    */     try {
/* 26 */       audioStream = new AudioStream(in);
/*    */     } catch (IOException ex) {
/* 28 */       Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     
/*    */ 
/* 32 */     AudioPlayer.player.start(audioStream);
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Sound.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */