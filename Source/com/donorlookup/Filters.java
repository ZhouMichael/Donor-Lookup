/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Filters
/*    */ {
/*    */   public static ArrayList<Donation> filterZip(ArrayList<Donation> arg, String zip)
/*    */   {
/* 15 */     ArrayList<Donation> newList = new ArrayList();
/* 16 */     for (Donation i : arg) {
/* 17 */       if (i.getZip().equalsIgnoreCase(zip)) {
/* 18 */         newList.add(i);
/*    */       }
/*    */     }
/* 21 */     return newList;
/*    */   }
/*    */   
/*    */   public static ArrayList<Donation> filterCity(ArrayList<Donation> arg, String city) {
/* 25 */     ArrayList<Donation> newList = new ArrayList();
/* 26 */     for (Donation i : arg) {
/* 27 */       if (i.getCity().equalsIgnoreCase(city)) {
/* 28 */         newList.add(i);
/*    */       }
/*    */     }
/* 31 */     return newList;
/*    */   }
/*    */   
/*    */   public static ArrayList<Donation> filterOccupation(ArrayList<Donation> arg, String occupation) {
/* 35 */     ArrayList<Donation> newList = new ArrayList();
/* 36 */     for (Donation i : arg) {
/* 37 */       if (i.getOccupation().equalsIgnoreCase(occupation)) {
/* 38 */         newList.add(i);
/*    */       }
/*    */     }
/* 41 */     return newList;
/*    */   }
/*    */   
/*    */   public static ArrayList<Donation> filterEmployer(ArrayList<Donation> arg, String employer) {
/* 45 */     ArrayList<Donation> newList = new ArrayList();
/* 46 */     for (Donation i : arg) {
/* 47 */       if (i.getEmployer().equalsIgnoreCase(employer)) {
/* 48 */         newList.add(i);
/*    */       }
/*    */     }
/* 51 */     return newList;
/*    */   }
/*    */   
/*    */   public static ArrayList<Donation> filterStandard(ArrayList<Donation> arg)
/*    */   {
/* 56 */     ArrayList<Donation> newList = new ArrayList();
/* 57 */     for (Donation i : arg) {
/* 58 */       if ((i.getAmount() > 0) && (!i.getRecipientName().equalsIgnoreCase("actblue"))) {
/* 59 */         newList.add(i);
/*    */       }
/*    */     }
/* 62 */     return newList;
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Filters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */