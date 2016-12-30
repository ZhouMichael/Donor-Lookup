/*     */ package com.donorlookup;
/*     */ 
/*     */ 
/*     */ public class SearchInformation
/*     */ {
/*     */   public String name;
/*     */   public String gender;
/*     */   public String address;
/*     */   public String city;
/*     */   public String state;
/*     */   public String zip;
/*     */   public String employer;
/*     */   
/*     */   public SearchInformation(String state, String name, String cycle, String APIKey)
/*     */   {
/*  16 */     this.state = state;
/*  17 */     this.name = name;
/*  18 */     this.cycle = cycle;
/*  19 */     this.APIKey = APIKey; }
/*     */   
/*     */   public String occupation;
/*     */   
/*  23 */   public String getAPIKey() { return this.APIKey; }
/*     */   
/*     */   public String recipientName;
/*     */   
/*  27 */   public void setAPIKey(String APIKey) { this.APIKey = APIKey; }
/*     */   
/*     */   public String recipientParty;
/*     */   
/*  31 */   public String getName() { return this.name; }
/*     */   
/*     */   public String district;
/*     */   
/*  35 */   public void setName(String name) { this.name = name; }
/*     */   
/*     */   public String type;
/*     */   
/*  39 */   public String getGender() { return this.gender; }
/*     */   
/*     */   public String transType;
/*     */   
/*  43 */   public void setGender(String gender) { this.gender = gender; }
/*     */   
/*     */   public String cycle;
/*     */   public String APIKey;
/*  47 */   public String getAddress() { return this.address; }
/*     */   
/*     */   public void setAddress(String address)
/*     */   {
/*  51 */     this.address = address;
/*     */   }
/*     */   
/*     */   public String getCity() {
/*  55 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/*  59 */     this.city = city;
/*     */   }
/*     */   
/*     */   public String getState() {
/*  63 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/*  67 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getZip() {
/*  71 */     return this.zip;
/*     */   }
/*     */   
/*     */   public void setZip(String zip) {
/*  75 */     this.zip = zip;
/*     */   }
/*     */   
/*     */   public String getEmployer() {
/*  79 */     return this.employer;
/*     */   }
/*     */   
/*     */   public void setEmployer(String employer) {
/*  83 */     this.employer = employer;
/*     */   }
/*     */   
/*     */   public String getOccupation() {
/*  87 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public void setOccupation(String occupation) {
/*  91 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */   public String getRecipientName() {
/*  95 */     return this.recipientName;
/*     */   }
/*     */   
/*     */   public void setRecipientName(String recipientName) {
/*  99 */     this.recipientName = recipientName;
/*     */   }
/*     */   
/*     */   public String getRecipientParty() {
/* 103 */     return this.recipientParty;
/*     */   }
/*     */   
/*     */   public void setRecipientParty(String recipientParty) {
/* 107 */     this.recipientParty = recipientParty;
/*     */   }
/*     */   
/*     */   public String getDistrict() {
/* 111 */     return this.district;
/*     */   }
/*     */   
/*     */   public void setDistrict(String district) {
/* 115 */     this.district = district;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 119 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 123 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getTransType() {
/* 127 */     return this.transType;
/*     */   }
/*     */   
/*     */   public void setTransType(String transType) {
/* 131 */     this.transType = transType;
/*     */   }
/*     */   
/*     */   public String getCycle() {
/* 135 */     return this.cycle;
/*     */   }
/*     */   
/*     */   public void setCycle(String cycle) {
/* 139 */     this.cycle = cycle;
/*     */   }
/*     */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\SearchInformation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */