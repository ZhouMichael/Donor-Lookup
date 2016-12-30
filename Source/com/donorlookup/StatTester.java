/*    */ package com.donorlookup;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class StatTester
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 22 */     ArrayList<Double> stats = new ArrayList();
/* 23 */     stats.add(Double.valueOf(1.0D));
/* 24 */     stats.add(Double.valueOf(1.0D));
/* 25 */     stats.add(Double.valueOf(3.0D));
/* 26 */     stats.add(Double.valueOf(3.0D));
/* 27 */     stats.add(Double.valueOf(0.0D));
/* 28 */     stats.add(Double.valueOf(0.0D));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */     System.out.println(ListStatistics.lowerQuartile(stats));
/* 35 */     System.out.println(ListStatistics.upperQuartile(stats));
/* 36 */     System.out.println(ListStatistics.min(stats));
/*    */     
/* 38 */     System.out.println(ListStatistics.max(stats));
/*    */   }
/*    */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\StatTester.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */