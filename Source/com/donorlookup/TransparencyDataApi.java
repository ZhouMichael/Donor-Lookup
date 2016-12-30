/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ public class TransparencyDataApi
/*     */ {
/*     */   private String addr;
/*     */   
/*     */   public ArrayList<Donation> dump(String theState, String theDonor, String theCycle, String APIKey)
/*     */   {
/*     */     try
/*     */     {
/*  23 */       theDonor = theDonor.replace(" ", "%20").replace("&", " ");
/*     */       
/*     */ 
/*  26 */       this.addr = "http://transparencydata.com/api/1.0/contributions.json?";
/*  27 */       this.addr = (this.addr + "apikey=" + APIKey);
/*  28 */       this.addr = (this.addr + "&contributor_state=" + theState);
/*  29 */       this.addr = (this.addr + "&contributor_ft=" + theDonor);
/*  30 */       this.addr = (this.addr + "&cycle=" + theCycle);
/*     */       
/*     */ 
/*  33 */       URL page = new URL(this.addr);
/*  34 */       URLConnection cc = page.openConnection();
/*  35 */       BufferedReader get = new BufferedReader(new InputStreamReader(cc.getInputStream()));
/*     */       
/*  37 */       String data = "";
/*  38 */       String input; while ((input = get.readLine()) != null)
/*     */       {
/*  40 */         data = data + input;
/*     */       }
/*  42 */       get.close();
/*  43 */       JSONArray jsonTest = new JSONArray(data);
/*     */       
/*  45 */       ArrayList<String> list = new ArrayList();
/*     */       
/*  47 */       int len = jsonTest.length();
/*  48 */       for (int i = 0; i < len; i++) {
/*  49 */         list.add(jsonTest.get(i).toString());
/*     */       }
/*     */       
/*     */ 
/*  53 */       ArrayList<Donation> dummy = new ArrayList();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */       for (int i = 0; i < list.size(); i++)
/*     */       {
/*  63 */         String result = (String)list.get(i);
/*  64 */         JSONObject jsonObject = new JSONObject(result);
/*     */         
/*  66 */         String name = jsonObject.get("contributor_name").toString();
/*  67 */         String gender = jsonObject.get("contributor_gender").toString();
/*  68 */         String address = jsonObject.get("contributor_address").toString();
/*  69 */         String city = jsonObject.get("contributor_city").toString();
/*  70 */         String state = jsonObject.get("contributor_state").toString();
/*  71 */         String zip = jsonObject.get("contributor_zipcode").toString();
/*  72 */         String employer = jsonObject.get("contributor_employer").toString();
/*  73 */         String occupation = jsonObject.get("contributor_occupation").toString();
/*  74 */         String recipientName = jsonObject.get("recipient_name").toString().replace(',', ' ');
/*  75 */         String recipientParty = jsonObject.get("recipient_party").toString();
/*  76 */         String recipientState = jsonObject.get("recipient_state").toString();
/*  77 */         String district = jsonObject.get("district").toString();
/*  78 */         String type = jsonObject.get("contributor_type").toString();
/*  79 */         String transType = jsonObject.get("transaction_type").toString();
/*  80 */         String cycle = jsonObject.get("cycle").toString();
/*  81 */         int amount = (int)Double.parseDouble(jsonObject.get("amount").toString());
/*  82 */         String donationScope = jsonObject.get("seat").toString();
/*  83 */         String seat = jsonObject.get("seat").toString();
/*  84 */         Date date; Date date; if ((jsonObject.get("date") == null) || (jsonObject.get("date").equals("null"))) {
/*  85 */           date = null; } else { Date date;
/*  86 */           if (jsonObject.get("date").toString().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]"))
/*  87 */             date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(jsonObject.get("date").toString()); else {
/*  88 */             date = null;
/*     */           }
/*     */         }
/*  91 */         if (seat.contains("federal")) {
/*  92 */           Donation test = new Donation(name, gender, address, city, state, zip, employer, occupation, recipientName, recipientParty, recipientState, district, type, transType, cycle, amount, date, donationScope, seat);
/*  93 */           dummy.add(test);
/*     */         }
/*     */       }
/*     */       
/*  97 */       return dummy;
/*     */     }
/*     */     catch (Exception ex) {
/* 100 */       ex.printStackTrace(); }
/* 101 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\TransparencyDataApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */