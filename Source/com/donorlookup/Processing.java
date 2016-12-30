/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Processing
/*    */ {
/*    */   public static ArrayList<Donation> getDonationData(SearchInformation query)
/*    */   {
/* 18 */     TransparencyDataApi api = new TransparencyDataApi();
/* 19 */     ArrayList<Donation> output = api.dump(query.getState(), query.getName(), query.getCycle(), query.getAPIKey());
/*    */     
/*    */ 
/* 22 */     if (query.getZip() != null) {
/* 23 */       output = Filters.filterZip(output, query.zip);
/*    */     }
/*    */     
/*    */ 
/* 27 */     if (query.getCity() != null) {
/* 28 */       output = Filters.filterCity(output, query.city);
/*    */     }
/*    */     
/*    */ 
/* 32 */     if (query.getOccupation() != null) {
/* 33 */       output = Filters.filterOccupation(output, query.occupation);
/*    */     }
/*    */     
/*    */ 
/* 37 */     if (query.getEmployer() != null) {
/* 38 */       output = Filters.filterEmployer(output, query.employer);
/*    */     }
/*    */     
/* 41 */     output = Filters.filterStandard(output);
/*    */     
/* 43 */     return output; }
/*    */   
/* 45 */   private static Comparator<Donor> compareDonorsByRank = new Comparator()
/*    */   {
/*    */ 
/*    */     public int compare(Donor d1, Donor d2)
/*    */     {
/* 50 */       if (d1.getPointTotal() > d2.getPointTotal())
/*    */       {
/* 52 */         return -1; }
/* 53 */       if (d1.getPointTotal() == d2.getPointTotal())
/* 54 */         return 0;
/* 55 */       if (d1.getPointTotal() < d2.getPointTotal()) {
/* 56 */         return 1;
/*    */       }
/* 58 */       return -99;
/*    */     }
/*    */   };
/*    */   
/*    */ 
/*    */ 
/* 64 */   private static Comparator<Donation> sortDonationsAlphabetically = new Comparator()
/*    */   {
/*    */ 
/*    */ 
/*    */     public int compare(Donation d1, Donation d2) {
/* 69 */       return d1.getRecipientName().compareToIgnoreCase(d2.getRecipientName()); }
/*    */   };
/*    */   
/*    */   public static ArrayList<Donor> rankDonor(ArrayList<Donor> dummy) {
/* 73 */     Collections.sort(dummy, compareDonorsByRank);
/* 74 */     return dummy;
/*    */   }
/*    */   
/* 77 */   public static ArrayList<Donation> sortDonations(ArrayList<Donation> dummy) { Collections.sort(dummy, sortDonationsAlphabetically);
/* 78 */     return dummy;
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Processing.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */