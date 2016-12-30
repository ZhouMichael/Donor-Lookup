/*     */ package com.donorlookup;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Donation
/*     */ {
/*     */   private String name;
/*     */   private String gender;
/*     */   private String address;
/*     */   private String city;
/*     */   private String state;
/*     */   private String zip;
/*     */   private String employer;
/*     */   private String occupation;
/*     */   private String recipientName;
/*     */   private String recipientParty;
/*     */   
/*  21 */   public void setOrder(int order2) { this.order = order2; }
/*     */   
/*     */   private String recipientState;
/*     */   private String district;
/*     */   
/*  26 */   public int getOrder() { return this.order; }
/*     */   
/*     */   private String type;
/*     */   
/*     */   public Donation(String name, String gender, String address, String city, String state, String zip, String employer, String occupation, String recipientName, String recipientParty, String recipientState, String district, String type, String transType, String cycle, int amount, Date date, String donationScope, String seat2) {
/*  31 */     this.name = name;
/*  32 */     this.gender = gender;
/*  33 */     this.address = address;
/*  34 */     this.city = city;
/*  35 */     this.state = state;
/*  36 */     this.zip = zip;
/*  37 */     this.employer = employer;
/*  38 */     this.occupation = occupation;
/*  39 */     this.recipientName = recipientName.replaceAll(" \\(.\\)", "");
/*  40 */     this.recipientParty = recipientParty;
/*  41 */     this.recipientState = recipientState;
/*  42 */     this.district = district;
/*  43 */     this.type = type;
/*  44 */     this.transType = transType;
/*  45 */     this.cycle = cycle;
/*  46 */     this.amount = amount;
/*  47 */     this.date = date;
/*  48 */     this.donationScope = donationScope;
/*  49 */     this.seat = seat2;
/*     */     try {
/*  51 */       if (this.date.toString().contains("2014")) {
/*  52 */         this.year = "14";
/*  53 */       } else if (this.date.toString().contains("2013")) {
/*  54 */         this.year = "13";
/*  55 */       } else if (this.date.toString().contains("2012")) {
/*  56 */         this.year = "12";
/*  57 */       } else if (this.date.toString().contains("2011")) {
/*  58 */         this.year = "11";
/*  59 */       } else if (this.date.toString().contains("2010")) {
/*  60 */         this.year = "10";
/*  61 */       } else if (this.date.toString().contains("2009")) {
/*  62 */         this.year = "09";
/*     */       }
/*     */     }
/*     */     catch (Exception NullPointerException) {
/*  66 */       this.year = "N/A";
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSeat()
/*     */   {
/*  72 */     return this.seat;
/*     */   }
/*     */   
/*     */   public void setAmount(int amount2)
/*     */   {
/*  77 */     this.amount = amount2;
/*     */   }
/*     */   
/*     */   public String getYear() {
/*  81 */     return this.year;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  85 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getGender() {
/*  89 */     return this.gender;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  93 */     return this.address;
/*     */   }
/*     */   
/*     */   public String getCity() {
/*  97 */     return this.city;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 101 */     return this.state;
/*     */   }
/*     */   
/*     */   public String getZip() {
/* 105 */     return this.zip;
/*     */   }
/*     */   
/*     */   public String getEmployer() {
/* 109 */     return this.employer;
/*     */   }
/*     */   
/*     */   public String getOccupation() {
/* 113 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public String getRecipientName() {
/* 117 */     return this.recipientName;
/*     */   }
/*     */   
/*     */   public String getRecipientLast()
/*     */   {
/* 122 */     String[] split = this.recipientName.split(" ");
/* 123 */     return split[(split.length - 1)];
/*     */   }
/*     */   
/*     */   public String getRecipientParty() {
/* 127 */     return this.recipientParty;
/*     */   }
/*     */   
/*     */   public String getRecipientState() {
/* 131 */     return this.recipientState;
/*     */   }
/*     */   
/*     */   public String getDistrict() {
/* 135 */     return this.district;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 139 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getTransType() {
/* 143 */     return this.transType;
/*     */   }
/*     */   
/*     */ 
/* 147 */   public String getCycle() { return this.cycle; }
/*     */   
/*     */   private String transType;
/*     */   private String cycle;
/* 151 */   public int getAmount() { return this.amount; }
/*     */   
/*     */   private String donationScope;
/*     */   
/* 155 */   public Date getDate() { return this.date; }
/*     */   
/*     */   private String seat;
/*     */   private int amount;
/*     */   
/*     */   public String toString() {
/* 161 */     String partyAndLocation = " ";
/* 162 */     if ((!this.donationScope.isEmpty()) && (this.donationScope.length() > 5)) {
/* 163 */       if (this.donationScope.substring(0, 5).equals("state")) {
/* 164 */         partyAndLocation = partyAndLocation + "(" + getRecipientParty() + "-S";
/*     */       } else
/* 166 */         partyAndLocation = partyAndLocation + "(" + getRecipientParty();
/* 167 */       partyAndLocation = partyAndLocation + " " + getRecipientState();
/* 168 */       if (!getDistrict().isEmpty())
/* 169 */         partyAndLocation = partyAndLocation + "-" + getDistrict().replaceAll("..-", "") + ")"; else {
/* 170 */         partyAndLocation = partyAndLocation + ")";
/*     */       }
/*     */     }
/* 173 */     String output = getRecipientName() + partyAndLocation + " $" + getAmount() + " '" + getCycle().substring(2, 4);
/*     */     
/* 175 */     return output;
/*     */   }
/*     */   
/*     */   private Date date;
/*     */   private String year;
/*     */   private int order;
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Donation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */