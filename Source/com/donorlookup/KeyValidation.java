/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.NetworkInterface;
/*    */ import java.net.SocketException;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.net.UnknownHostException;
/*    */ import java.util.Enumeration;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyValidation
/*    */ {
/*    */   public static Boolean validateKey(String theKey)
/*    */   {
/* 34 */     Boolean result = Boolean.valueOf(false);
/*    */     try {
/* 36 */       String addr = "http://gator4097.hostgator.com/~dlteam/keys/checkKey.php?key=" + theKey + "&mac=" + getMACAddress();
/*    */       
/* 38 */       URL page = new URL(addr);
/* 39 */       URLConnection cc = page.openConnection();
/* 40 */       BufferedReader get = new BufferedReader(new InputStreamReader(cc.getInputStream()));
/* 41 */       String theAnswer = get.readLine();
/* 42 */       if (theAnswer.equals("expired")) {
/* 43 */         result = Boolean.valueOf(false);
/* 44 */         JOptionPane.showMessageDialog(null, "Your license key has expired.", "Expired", 0);
/*    */       } else {
/* 46 */         result = Boolean.valueOf(Boolean.parseBoolean(theAnswer));
/*    */       }
/* 48 */     } catch (MalformedURLException ex) { Logger.getLogger(KeyValidation.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IOException ex) {
/* 50 */       Logger.getLogger(KeyValidation.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/* 52 */     return result;
/*    */   }
/*    */   
/*    */   public static String getMACAddress() throws UnknownHostException, SocketException
/*    */   {
/* 57 */     Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
/* 58 */     while (networks.hasMoreElements()) {
/* 59 */       NetworkInterface network = (NetworkInterface)networks.nextElement();
/* 60 */       byte[] mac = network.getHardwareAddress();
/* 61 */       if (mac != null) {
/* 62 */         StringBuilder sb = new StringBuilder();
/* 63 */         for (int i = 0; i < mac.length; i++) {
/* 64 */           sb.append(String.format("%02X%s", new Object[] { Byte.valueOf(mac[i]), i < mac.length - 1 ? "-" : "" }));
/*    */         }
/* 66 */         return sb.toString();
/*    */       }
/*    */     }
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\KeyValidation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */