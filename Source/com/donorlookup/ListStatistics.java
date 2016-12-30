/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class ListStatistics
/*     */ {
/*     */   double median;
/*     */   double lowerQuartile;
/*     */   double upperQuartile;
/*     */   double min;
/*     */   double max;
/*     */   double mean;
/*     */   double IQR;
/*     */   double mode;
/*     */   double sum;
/*     */   double stddev;
/*     */   double range;
/*     */   int n;
/*     */   
/*     */   public ListStatistics(ArrayList<Double> data)
/*     */   {
/*  22 */     if (data.size() > 1)
/*     */     {
/*  24 */       this.median = median(data);
/*  25 */       this.lowerQuartile = lowerQuartile(data);
/*  26 */       this.upperQuartile = upperQuartile(data);
/*  27 */       this.min = min(data);
/*  28 */       this.max = max(data);
/*  29 */       this.mean = mean(data);
/*  30 */       this.IQR = (this.upperQuartile - this.lowerQuartile);
/*  31 */       this.range = (this.max - this.min);
/*  32 */       this.mode = mode(data);
/*  33 */       this.n = n(data);
/*  34 */       this.sum = sum(data);
/*  35 */       this.stddev = stddev(data);
/*  36 */     } else if (data.isEmpty()) {
/*  37 */       this.median = 0.0D;
/*  38 */       this.lowerQuartile = 0.0D;
/*  39 */       this.upperQuartile = 0.0D;
/*  40 */       this.min = 0.0D;
/*  41 */       this.max = 0.0D;
/*  42 */       this.mean = 0.0D;
/*  43 */       this.IQR = 0.0D;
/*  44 */       this.range = 0.0D;
/*  45 */       this.mode = 0.0D;
/*  46 */       this.n = 0;
/*  47 */       this.sum = 0.0D;
/*  48 */       this.stddev = 0.0D;
/*  49 */     } else if (data.size() == 1) {
/*  50 */       this.median = ((Double)data.get(0)).doubleValue();
/*  51 */       this.lowerQuartile = ((Double)data.get(0)).doubleValue();
/*  52 */       this.upperQuartile = ((Double)data.get(0)).doubleValue();
/*  53 */       this.min = ((Double)data.get(0)).doubleValue();
/*  54 */       this.max = ((Double)data.get(0)).doubleValue();
/*  55 */       this.mean = ((Double)data.get(0)).doubleValue();
/*  56 */       this.IQR = 0.0D;
/*  57 */       this.range = 0.0D;
/*  58 */       this.mode = ((Double)data.get(0)).doubleValue();
/*  59 */       this.n = 1;
/*  60 */       this.sum = ((Double)data.get(0)).doubleValue();
/*  61 */       this.stddev = 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static double median(ArrayList<Double> data)
/*     */   {
/*  67 */     double[] rawData = new double[data.size()];
/*  68 */     java.util.Iterator<Double> iterator = data.iterator();
/*  69 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/*  71 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/*  73 */     java.util.Arrays.sort(rawData);
/*  74 */     int len = rawData.length;
/*     */     
/*  76 */     boolean is_even = len % 2 == 0;
/*     */     
/*  78 */     if ((len != 0) && (len != 1))
/*     */     {
/*  80 */       if (!is_even)
/*     */       {
/*  82 */         return rawData[((len - 1) / 2)];
/*     */       }
/*  84 */       return 0.5D * (rawData[(len / 2)] + rawData[(len / 2 - 1)]);
/*     */     }
/*  86 */     if (len == 1) {
/*  87 */       return rawData[0];
/*     */     }
/*  89 */     return 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static double lowerQuartile(ArrayList<Double> data)
/*     */   {
/*  96 */     double[] rawData = new double[data.size()];
/*  97 */     java.util.Iterator<Double> iterator = data.iterator();
/*  98 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/* 100 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/* 102 */     java.util.Arrays.sort(rawData);
/* 103 */     int len = rawData.length;
/*     */     int upperIndex;
/* 105 */     int upperIndex; if (len % 2 == 0)
/*     */     {
/* 107 */       upperIndex = len / 2 - 1;
/*     */     } else {
/* 109 */       upperIndex = (len - 1) / 2 - 1;
/*     */     }
/* 111 */     double[] halfArray = new double[upperIndex + 1];
/* 112 */     for (int i = 0; i <= upperIndex; i++)
/*     */     {
/* 114 */       halfArray[i] = rawData[i];
/*     */     }
/* 116 */     ArrayList<Double> newHalfArray = new ArrayList();
/* 117 */     for (double i : halfArray) {
/* 118 */       newHalfArray.add(Double.valueOf(i));
/*     */     }
/*     */     
/* 121 */     return median(newHalfArray);
/*     */   }
/*     */   
/*     */ 
/*     */   public static double upperQuartile(ArrayList<Double> data)
/*     */   {
/* 127 */     double[] rawData = new double[data.size()];
/* 128 */     java.util.Iterator<Double> iterator = data.iterator();
/* 129 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/* 131 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/* 133 */     java.util.Arrays.sort(rawData);
/* 134 */     int len = rawData.length;
/*     */     int lowerIndex;
/* 136 */     int lowerIndex; if (len % 2 == 0)
/*     */     {
/* 138 */       lowerIndex = len / 2;
/*     */     } else {
/* 140 */       lowerIndex = (len + 1) / 2;
/*     */     }
/* 142 */     double[] halfArray = new double[len - lowerIndex];
/* 143 */     for (int i = 0; i < len - lowerIndex; i++)
/*     */     {
/* 145 */       halfArray[i] = rawData[(lowerIndex + i)];
/*     */     }
/* 147 */     ArrayList<Double> newHalfArray = new ArrayList();
/* 148 */     for (double i : halfArray) {
/* 149 */       newHalfArray.add(Double.valueOf(i));
/*     */     }
/*     */     
/* 152 */     return median(newHalfArray);
/*     */   }
/*     */   
/* 155 */   public static double mean(ArrayList<Double> data) { double sum = 0.0D;
/* 156 */     for (int i = 0; i < data.size(); i++)
/*     */     {
/* 158 */       sum += ((Double)data.get(i)).doubleValue();
/*     */     }
/* 160 */     return sum / data.size();
/*     */   }
/*     */   
/*     */   public static double stddev(ArrayList<Double> data) {
/* 164 */     if (data.isEmpty())
/*     */     {
/* 166 */       return -1.0D;
/*     */     }
/*     */     
/* 169 */     double avg = mean(data);
/* 170 */     double z = 0.0D;
/* 171 */     for (int i = 0; i < data.size(); i++)
/*     */     {
/* 173 */       z += Math.pow(((Double)data.get(i)).doubleValue() - avg, 2.0D);
/*     */     }
/* 175 */     double variance = z / data.size();
/*     */     
/* 177 */     return Math.sqrt(variance);
/*     */   }
/*     */   
/*     */   public static double mode(ArrayList<Double> data) {
/* 181 */     double[] rawData = new double[data.size()];
/* 182 */     java.util.Iterator<Double> iterator = data.iterator();
/* 183 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/* 185 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/* 187 */     java.util.Arrays.sort(rawData);
/* 188 */     int c = 0;
/* 189 */     int z = 0;
/* 190 */     double m = 0.0D;
/* 191 */     for (int i = 0; i < rawData.length - 1; i++)
/*     */     {
/*     */ 
/* 194 */       if (rawData[i] == rawData[(i + 1)])
/*     */       {
/* 196 */         c++;
/*     */       } else {
/* 198 */         c = 0;
/*     */       }
/* 200 */       if (z <= c)
/*     */       {
/* 202 */         m = rawData[(i + 1)];
/* 203 */         z = c;
/*     */       }
/*     */     }
/* 206 */     if (z <= 1)
/*     */     {
/* 208 */       return 0.0D;
/*     */     }
/* 210 */     return m;
/*     */   }
/*     */   
/*     */   public static double sum(ArrayList<Double> data) {
/* 214 */     double sum = 0.0D;
/* 215 */     for (int i = 0; i < data.size(); i++)
/*     */     {
/* 217 */       sum += ((Double)data.get(i)).doubleValue();
/*     */     }
/* 219 */     return sum;
/*     */   }
/*     */   
/* 222 */   public static int n(ArrayList<Double> data) { return data.size(); }
/*     */   
/*     */   public static double max(ArrayList<Double> data) {
/* 225 */     double[] rawData = new double[data.size()];
/* 226 */     java.util.Iterator<Double> iterator = data.iterator();
/* 227 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/* 229 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/* 231 */     java.util.Arrays.sort(rawData);
/* 232 */     return rawData[(rawData.length - 1)];
/*     */   }
/*     */   
/* 235 */   public static double min(ArrayList<Double> data) { double[] rawData = new double[data.size()];
/* 236 */     java.util.Iterator<Double> iterator = data.iterator();
/* 237 */     for (int i = 0; i < rawData.length; i++)
/*     */     {
/* 239 */       rawData[i] = ((Double)iterator.next()).doubleValue();
/*     */     }
/* 241 */     java.util.Arrays.sort(rawData);
/* 242 */     return rawData[0];
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\ListStatistics.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */