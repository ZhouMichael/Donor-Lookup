/*      */ package com.donorlookup;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.io.StringReader;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ 
/*      */ public class Donor
/*      */ {
/*      */   public String name;
/*      */   public String gender;
/*      */   public String address;
/*      */   public String city;
/*      */   public String state;
/*      */   public String zip;
/*      */   public String employer;
/*      */   public String occupation;
/*      */   public ArrayList<Donation> donationHistory;
/*   22 */   public double pointTotal = 0.0D;
/*      */   
/*      */   public ListStatistics data;
/*   25 */   public String order2 = "Brad Schneider\nRobert Dold\nDan Seals\nBill Foster\nTammy Duckworth\nJan Schakowsky\nEliot Engel\nTed Deutch\nHoward L. Berman\nHenry Waxman\nDebbie Wasserman Schultz\nBrad Sherman\nJoe Kennedy III\nSteny Hoyer\nLois Frankel\nDavid Cicilline\nShelly Berkley\nJared Polis\nNita Lowey\nJane Harman\nMike Quigley\nEd Royce\nEdwin Royce\nIleana Ros-Lehtinen\nCitizens Organized PAC\nJoint Action Cmte for Political Affairs\nNational Action Cmte\nNorPac\nLeague of Conservation Voters\nSierra Club\nSierra Club Independant Action\nEMILY's List\nDemocratic Congressional Campaign Cmte\nPlanned Parenthood Votes\nBrady Pac\nBrady Campaign\nNARAL Pro-Choice America\nAngus King\nCheri Bustos\nDick Durbin\nMark Kirk\nHOUSE\nBrad Schneider\nRobert Dold\nDan Seals\nBill Foster\nTammy Duckworth\nJan Schakowsky\nElliot Engel\nTed Deutch\nHoward L. Berman\nHenry Waxman\nDebbie Wasserman Shultz\nBrad Sherman\nJoe Kennedy III\nSteny Hoyer\nLois Frankel\nDavid Cicilline\nShelley Berkley\nJared Polis\nNita Lowey\nJane Harman\nMike Quigley\nEd Royce\nEdwin Royce\nIleana Ros-Lehtinen\nCheri Bustos\nBobby Rush\nRobin Kelly\nDaniel Lipinski\nLuis Gutierrez\nDanny K. Davis\nWilliam Enyart\nPeter J. Roskam\nRodney Davis\nRandy Hultgren\nJohn Shimkus\nAdam Kinzinger\nAaron Schock\nAdam Schiff\nAl Green\nAlan Lowenthal\nAlbio Sires\nAlcee Hastings\nAllyson Schwartz\nAmi Bera\nAndré Carson\nAnn McLane Kuster\nAnna Eshoo\nBarbara Lee\nBen R. Luján\nBeto O'Rourke\nBetty McCollum\nBill Keating\nBill Owens\nBill Pascrell\nBobby Scott\nBrian Higgins\nBruce Braley\nCarolyn Maloney\nCarolyn McCarthy\nCedric Richmond\nChaka Fattah\nCharles B. Rangel\nChellie Pingree\nColleen Hanabusa\nCorrine Brown\nDan Kildee\nDave Loebsack\nDavid Scott\nDennis Heck\nDerek Kilmer\nDiana DeGette\nDonald Payne\nDonna Edwards\nDoris Matsui\nEarl Blumenauer\nEd Pastor\nEd Perlmutter\nEdwin Perlmutter\nElizabeth Esty\nEmanuel Cleaver\nEric Swalwell\nFilemon Vela\nFrank Pallone\nFrederica Wilson\nG. K. Butterfield\nGary Peters\nGene Green\nGerry Connolly\nGloria Negrete McLeod\nGrace Meng\nGrace Napolitano\nGregory Meeks\nGwen Moore\nHakeem Jeffries\nHank Johnson\nHenry Cuellar\nJackie Speier\nJames Langevin\nJanice Hahn\nJared Huffman\nJerrold Nadler\nJerry McNerney\nJim Costa\nJim Himes\nJim Matheson\nJim McDermott\nJim McGovern\nJim Moran\nJoaquin Castro\nJoe Courtney\nJoe Crowley\nJoe Garcia\nJohn Barrow\nJohn Carney\nJohn Delaney\nJohn Garamendi\nJohn Larson\nJohn Lewis\nJohn Sarbanes\nJohn Tierney\nJohn Yarmuth\nJosé Serrano\nJoyce Beatty\nJuan Vargas\nJudy Chu\nJulia Brownley\nKaren Bass\nKatherine Clark\nKathy Castor\nKeith Ellison\nKurt Schrader\nKyrsten Sinema\nLloyd Doggett\nLois Capps\nLoretta Sanchez\nLucille Roybal-Allard\nLuis Gutiérrez\nMarc Veasey\nMarcia Fudge\nMarcy Kaptur\nMark Pocan\nMark Takano\nMatt Cartwright\nMichael Quigley\nMichelle Lujan Grisham\nMike Capuano\nMike Doyle\nMike Honda\nMike McIntyre\nMike Thompson\nNiki Tsongas\nPatrick Murphy\nPaul Tonko\nPete Gallego\nPete Visclosky\nPeter Welch\nRaul Ruiz\nRaúl Grijalva\nRichard Neal\nRick Larsen\nRon Barber\nRon Kind\nRosa DeLauro\nRubén Hinojosa\nRush D. Holt\nSam Farr\nSanford Bishop\nScott Peters\nSean Patrick Maloney\nSheila Jackson-Lee\nStephen Lynch\nSteve Cohen\nSteve Horsford\nSteve Israel\nSuzan DelBene\nSuzanne Bonamici\nTerri Sewell\nTim Bishop\nTim Ryan\nTim Walz\nTony Cardenas\nTulsi Gabbard\nWilliam Lacy Clay\nYvette D. Clarke\nZoe Lofgren\nJim Clyburn\nJohn Dingell\nXavier Becerra\nNancy Pelosi\nRick Nolan\nJim Cooper\nDavid Price\nCarol Shea-Porter\nAlan Grayson\nAnn Kirkpatrick\nDan Maffei\nDina Titus\nCollin Peterson\nAdam Smith\nChris Van Hollen\nGeorge Miller\nLinda Sánchez\nMaxine Waters\nBennie Thompson\nRobert Brady\nDutch Ruppersberger\nJohn Conyers\nPeter DeFazio\nElijah Cummings\nLouise Slaughter\nEddie Bernice Johnson\nNydia Velázquez\nNick Rahall\nMike Michaud\nSander Levin\nAdrian Smith\nAlan Nunnelee\nAnder Crenshaw\nAndy Barr\nAndy Harris\nAnn Wagner\nAustin Scott\nBill Cassidy\nBill Flores\nBill Huizenga\nBill Johnson\nBill Posey\nBilly Long\nBlaine Luetkemeyer\nBlake Farenthold\nBob Gibbs\nBob Latta\nBrad Wenstrup\nBradley Byrne\nBrett Guthrie\nCharles Boustany\nCharlie Dent\nChris Collins\nChris Gibson\nChris Stewart\nChristopher Smith\nChuck Fleischmann\nCory Gardner\nCynthia Lummis\nDan Benishek\nDana Rohrabacher\nDaniel Webster\nDave Reichert\nDavid Jolly\nDavid Joyce\nDavid McKinley\nDavid Schweikert\nDavid Valadao\nDennis Ross\nDevin Nunes\nDiane Black\nDon Young\nDoug Collins\nDoug LaMalfa\nDoug Lamborn\nDuncan D. Hunter\nEd Whitfield\nErik Paulsen\nFrank LoBiondo\nFrank Wolf\nGary Miller\nGeorge Holding\nGlenn Thompson\nGreg Walden\nGregg Harper\nGus Bilirakis\nHoward Coble\nJack Kingston\nJackie Walorski\nJaime Herrera Beutler\nJames Lankford\nJames Sensenbrenner\nJason Chaffetz\nJason Smith\nJeff Denham\nJeff Duncan\nJeff Fortenberry\nJim Bridenstine\nJim Gerlach\nJim Jordan\nJim Renacci\nJoe Barton\nJoe Heck\nJoe Pitts\nJoe Wilson\nJohn C. Fleming\nJohn Campbell\nJohn Carter\nJohn Culberson\nJohn Duncan\nJohn Mica\nJon Runyan\nJustin Amash\nKay Granger\nKeith Rothfus\nKen Calvert\nKenny Marchant\nKerry Bentivolio\nKevin Brady\nKevin Cramer\nKevin Yoder\nKristi Noem\nLarry Bucshon\nLee Terry\nLeonard Lance\nLou Barletta\nLouie Gohmer\nLuke Messer\nLynn Jenkins\nLynn Westmoreland\nMac Thornberry\nMario Diaz-Balart\nMark Amodei\nMark Meadows\nMarkwayne Mullin\nMarlin Stutzman\nMarsha Blackburn\nMartha Roby\nMichael Burgess\nMichael Grimm\nMichael Turner\nMichele Bachmann\nMick Mulvaney\nMike Coffman\nMike D. Rogers\nMike Kelly\nMike Pompeo\nMike Simpson\nMo Brooks\nMorgan Griffith\nPat Meehan\nPatrick McHenry\nPatrick Tiberi\nPaul Broun\nPaul Cook\nPaul Gosar\nPete Olson\nPeter King\nPhil Gingrey\nPhil Roe\nRalph Hall\nRandy Forbes\nRandy Neugebauer\nRandy Weber\nRaúl Labrador\nReid Ribble\nRenee Ellmers\nRich Nugent\nRichard Hanna\nRichard Hudson\nRick Crawford\nRob Bishop\nRob Wittman\nRob Woodall\nRobert Aderholt\nRobert Hurt\nRobert Pittenger\nRodney Frelinghuysen\nRoger Williams\nRon DeSantis\nSam Johnson\nScott DesJarlais\nScott Garrett\nScott Perry\nScott Rigell\nScott Tipton\nSean Duffy\nShelley Moore Capito\nSpencer Bachus\nStephen Fincher\nSteve Daines\nSteve King\nSteve Scalise\nSteve Southerland\nSteve Stivers\nSteve Womack\nSteven Palazzo\nSusan Brooks\nTed Poe\nTed Yoho\nThomas Massie\nTim Griffin\nTim Huelskamp\nTim Murphy\nTodd Rokita\nTodd Young\nTom Cole\nTom Cotton\nTom Graves\nTom Latham\nTom Marino\nTom McClintock\nTom Petri\nTom Price\nTom Reed\nTom Rice\nTom Rooney\nTrent Franks\nTrey Gowdy\nVance McAllister\nVern Buchanan\nVicky Hartzler\nVirginia Foxx\nWalter B. Jones\nFrank Lucas\nHal Rogers\nBuck McKeon\nPaul Ryan\nJohn Kline\nFred Upton\nMike Conaway\nJeb Hensarling\nMichael McCaul\nCandice Miller\nMike Rogers\nBob Goodlatte\nDoc Hastings\nDarrell Issa\nPete Sessions\nLamar Smith\nSam Graves\nBill Shuster\nJeff Miller\nDave Camp\nEric Cantor\nKevin McCarthy\nSteve Stockman\nMark Sanford\nMatt Salmon\nSteve Chabot\nSteve Pearce\nMike Fitzpatrick\nTim Walberg\nCathy McMorris Rodgers\nJohn Boehner\nSENATE\nAngus King\nDick Durbin\nMark KirkCharles E. Schumer\nPatrick J. Leahy\nCarl Levin\nTom Harkin\nJay Rockefeller\nBarbara A. Mikulski\nHarry Reid\nDianne Feinstein\nBarbara Boxer\nPatty Murray\nRon Wyden\nTim Johnson\nJack Reed\nMary L. Landrieu\nBill Nelson\nThomas R. Carper\nDebbie Stabenow\nMaria Cantwell\nMark Pryor\nRobert Menendez\nBenjamin L. Cardin\nBernard Sanders\nSherrod Brown\nBob Casey\nClaire McCaskill\nAmy Klobuchar\nSheldon Whitehouse\nJon Tester\nMark Udall\nTom Udall\nJeanne Shaheen\nMark Warner\nKay Hagan\nJeff Merkley\nMark Begich\nMichael Bennet\nKirsten Gillibrand\nAl Franken\nJoe Manchin III\nChris Coons\nRichard Blumenthal\nBrian Schatz\nTammy Baldwin\nJoe Donnelly\nChristopher S. Murphy\nMazie K. Hirono\nMartin Heinrich\nTim Kaine\nElizabeth Warren\nHeidi Heitkamp\nEdward J. Markey\nCory Booker\nJohn Walsh\nTed Cruz\nJeff Flake\nOrrin G. Hatch\nThad Cochran\nDeb Fischer\nTim Scott\nBob Corker\nMike Lee\nKelly Ayotte\nMitch McConnell\nDean Heller\nRichard C. Shelby\nJohn Barrasso\nRoger Wicker\nLisa Murkowski\nSaxby Chambliss\nLindsey Graham\nLamar Alexander\nJohn Cornyn\nJohn McCain\nDan Coats\nRoy Blunt\nJerry Moran\nJim Risch\nRob Portman\nJohn Boozman\nRichard M. Burr\nTom Coburn\nJohn Thune\nJohnny Isakson\nDavid Vitter\nJeff Sessions\nSusan Collins\nMichael B. Enzi\nJames M. Inhofe\nPat Roberts\nMike Johanns\nMichael D. Crapo\nPatrick J. Toomey\nJohn Hoeven\nMarco Rubio\nCharles E. Grassley\nRon Johnson\nRand Paul\nPRESIDENTS\nBarack Obama\nMitt Romney";
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Donor(String name, String gender, String address, String city, String state, String zip, String employer, String occupation)
/*      */   {
/*  614 */     this.name = name;
/*  615 */     this.gender = gender;
/*  616 */     this.address = address;
/*  617 */     this.city = city;
/*  618 */     this.state = state;
/*  619 */     this.zip = zip;
/*  620 */     this.employer = employer;
/*  621 */     this.occupation = occupation;
/*      */   }
/*      */   
/*      */   public ListStatistics getData() {
/*  625 */     return this.data;
/*      */   }
/*      */   
/*      */   public void setData(ListStatistics data) {
/*  629 */     this.data = data;
/*      */   }
/*      */   
/*      */   public double getPointTotal() {
/*  633 */     return this.pointTotal;
/*      */   }
/*      */   
/*      */   public String getName() {
/*  637 */     return this.name;
/*      */   }
/*      */   
/*      */   public String getGender() {
/*  641 */     return this.gender;
/*      */   }
/*      */   
/*      */   public String getAddress() {
/*  645 */     return this.address;
/*      */   }
/*      */   
/*      */   public String getCity() {
/*  649 */     return this.city;
/*      */   }
/*      */   
/*      */   public String getState() {
/*  653 */     return this.state;
/*      */   }
/*      */   
/*      */   public String getZip() {
/*  657 */     return this.zip;
/*      */   }
/*      */   
/*      */   public String getEmployer() {
/*  661 */     return this.employer;
/*      */   }
/*      */   
/*      */   public String getOccupation() {
/*  665 */     return this.occupation;
/*      */   }
/*      */   
/*      */   public ArrayList<Donation> getDonationHistory() {
/*  669 */     return this.donationHistory;
/*      */   }
/*      */   
/*      */   public void setDonationHistory(ArrayList<Donation> donationHistory) {
/*  673 */     this.donationHistory = donationHistory;
/*      */   }
/*      */   
/*      */   public String getDonationHistoryAsString() throws IOException
/*      */   {
/*  678 */     StringReader sr = new StringReader(this.order2);
/*  679 */     BufferedReader br = new BufferedReader(sr);
/*  680 */     int i = 0;
/*  681 */     String row = br.readLine();
/*  682 */     while (row != null)
/*      */     {
/*  684 */       i++;
/*  685 */       row = br.readLine();
/*      */     }
/*  687 */     String[] order = new String[i];
/*  688 */     sr = new StringReader(this.order2);
/*  689 */     br = new BufferedReader(sr);
/*      */     
/*  691 */     i = 0;
/*      */     
/*  693 */     while (i < order.length)
/*      */     {
/*  695 */       order[i] = br.readLine();
/*  696 */       i++;
/*      */     }
/*      */     
/*  699 */     i = 0;
/*  700 */     while (i < this.donationHistory.size())
/*      */     {
/*  702 */       int j = 0;
/*  703 */       boolean go = true;
/*  704 */       while ((j < order.length) && (go))
/*      */       {
/*  706 */         if (((Donation)this.donationHistory.get(i)).getRecipientName().equals(order[j])) {
/*  707 */           go = false;
/*      */         } else {
/*  709 */           j++;
/*      */         }
/*      */       }
/*      */       
/*  713 */       ((Donation)this.donationHistory.get(i)).setOrder(j - 1);
/*  714 */       i++;
/*      */     }
/*      */     
/*  717 */     ArrayList<String> lines = new ArrayList();
/*      */     
/*  719 */     i = -1;
/*  720 */     while (i < order.length)
/*      */     {
/*  722 */       int j = 0;
/*  723 */       while (j < this.donationHistory.size())
/*      */       {
/*  725 */         if ((((Donation)this.donationHistory.get(j)).getName().equals("Barack Obama")) && (((Donation)this.donationHistory.get(j)).getAmount() < 30000)) {
/*  726 */           System.out.println("SKIP BARACK");
/*  727 */         } else if (((Donation)this.donationHistory.get(j)).getOrder() == i)
/*      */         {
/*  729 */           int c = 0;
/*  730 */           ArrayList<Integer> doubles = new ArrayList();
/*  731 */           while (c < this.donationHistory.size())
/*      */           {
/*  733 */             if (((Donation)this.donationHistory.get(j)).getRecipientName().equals(((Donation)this.donationHistory.get(c)).getRecipientName()))
/*      */             {
/*  735 */               doubles.add(Integer.valueOf(c));
/*      */             }
/*  737 */             c++;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  759 */           String line = null;
/*  760 */           int d = 0;
/*  761 */           switch (((Donation)this.donationHistory.get(j)).getRecipientName())
/*      */           {
/*      */           case "Citizens Organized PAC": 
/*  764 */             line = "Citizen's Organized ";
/*  765 */             break;
/*      */           case "Joint Action Cmte for Political Affairs": 
/*  767 */             line = "JACPAC ";
/*  768 */             break;
/*      */           case "National Action Cmte": 
/*  770 */             line = "NACPAC ";
/*  771 */             break;
/*      */           case "NorPac": 
/*  773 */             line = "NORPAC ";
/*  774 */             break;
/*      */           case "League of Conservation Voters": 
/*  776 */             line = "LCV ";
/*  777 */             break;
/*      */           case "Sierra Club": 
/*  779 */             line = "Sierra Club ";
/*  780 */             break;
/*      */           case "Sierra Club Independant Action": 
/*  782 */             line = "Sierra Club ";
/*  783 */             break;
/*      */           case "EMILY's List": 
/*  785 */             line = "Emily's List ";
/*  786 */             break;
/*      */           case "Planned Parenthood Votes": 
/*  788 */             line = "Planned Parenthood ";
/*  789 */             break;
/*      */           case "Brady Pac": 
/*  791 */             line = "Brady Campaign ";
/*  792 */             break;
/*      */           case "Brady Campaign": 
/*  794 */             line = "Brady Campaign ";
/*  795 */             break;
/*      */           case "Joe Kennedy III": 
/*  797 */             line = "Kennedy ";
/*  798 */             break;
/*      */           case "NARAL Pro-Choice America": 
/*  800 */             line = "NARAL ";
/*  801 */             break;
/*      */           case "Democratic Congressional Campaign Cmte": 
/*  803 */             line = "DCCC ";
/*  804 */             break;
/*      */           default: 
/*  806 */             boolean repeat = false;
/*  807 */             int k = 0;
/*  808 */             while (k < order.length)
/*      */             {
/*      */ 
/*  811 */               if ((((Donation)this.donationHistory.get(j)).getRecipientLast().equals(order[k].split(" ")[(order[k].split(" ").length - 1)])) && (!((Donation)this.donationHistory.get(j)).getRecipientName().equals(order[k])))
/*      */               {
/*      */ 
/*  814 */                 repeat = true;
/*      */               }
/*  816 */               k++;
/*      */             }
/*  818 */             if ((repeat) || (((Donation)this.donationHistory.get(j)).getRecipientLast().equalsIgnoreCase("fund")) || (((Donation)this.donationHistory.get(j)).getRecipientLast().equalsIgnoreCase("Cmte")) || (((Donation)this.donationHistory.get(j)).getRecipientLast().equalsIgnoreCase("PAC")) || (((Donation)this.donationHistory.get(j)).getRecipientLast().equalsIgnoreCase("corp"))) {
/*  819 */               line = ((Donation)this.donationHistory.get(j)).getRecipientName() + " ";
/*      */             } else
/*  821 */               line = ((Donation)this.donationHistory.get(j)).getRecipientLast() + " ";
/*      */             break; }
/*  823 */           while (d < doubles.size())
/*      */           {
/*      */ 
/*  826 */             String date = null;
/*      */             try {
/*  828 */               if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2014")) {
/*  829 */                 date = "14";
/*  830 */               } else if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2013")) {
/*  831 */                 date = "13";
/*  832 */               } else if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2012")) {
/*  833 */                 date = "12";
/*  834 */               } else if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2011")) {
/*  835 */                 date = "11";
/*  836 */               } else if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2010")) {
/*  837 */                 date = "10";
/*  838 */               } else if (((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getDate().toString().contains("2009")) {
/*  839 */                 date = "09";
/*      */               }
/*      */             }
/*      */             catch (Exception NullPointerException) {
/*  843 */               date = "N/A";
/*      */             }
/*      */             
/*  846 */             if (d == doubles.size() - 1) {
/*  847 */               line = line + "$" + ((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getAmount() + " '" + date + "; ";
/*      */             } else
/*  849 */               line = line + "$" + ((Donation)this.donationHistory.get(((Integer)doubles.get(d)).intValue())).getAmount() + " '" + date + ", ";
/*  850 */             d++;
/*      */           }
/*      */           
/*  853 */           lines.add(line);
/*      */         }
/*  855 */         j++;
/*      */       }
/*  857 */       i++;
/*      */     }
/*      */     
/*  860 */     i = lines.size() - 1;
/*  861 */     while (i >= 0)
/*      */     {
/*  863 */       boolean repeat = false;
/*  864 */       int j = 0;
/*  865 */       while (j < lines.size())
/*      */       {
/*  867 */         if ((((String)lines.get(i)).equals(lines.get(j))) && (i != j))
/*  868 */           repeat = true;
/*  869 */         j++;
/*      */       }
/*  871 */       if (repeat)
/*  872 */         lines.remove(i);
/*  873 */       i--;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  879 */     String string = "";
/*      */     
/*  881 */     ArrayList<String> lines2 = new ArrayList();
/*      */     
/*  883 */     i = 0;
/*  884 */     while (i < lines.size())
/*      */     {
/*  886 */       String[] split = ((String)lines.get(i)).split(",");
/*  887 */       String[] split2 = split[0].split(" ");
/*  888 */       String name = "";
/*      */       
/*  890 */       if (split2.length > 2) {
/*  891 */         for (int q = 0; q < split2.length - 2; q++)
/*  892 */           name = name + split2[q] + " ";
/*      */       } else {
/*  894 */         name = split[0].substring(0, split[0].indexOf(" "));
/*      */       }
/*  896 */       int a = 0;
/*  897 */       Object year = new ArrayList();
/*  898 */       while (a < split.length)
/*      */       {
/*  900 */         ((ArrayList)year).add(split[a].substring(split[a].indexOf("'")));
/*  901 */         a++;
/*      */       }
/*  903 */       ((ArrayList)year).set(((ArrayList)year).size() - 1, ((String)((ArrayList)year).get(((ArrayList)year).size() - 1)).substring(0, 3));
/*  904 */       ArrayList<Integer> amount = new ArrayList();
/*  905 */       int b = 0;
/*  906 */       while (b < split.length)
/*      */       {
/*  908 */         amount.add(Integer.valueOf(Integer.parseInt(split[b].substring(split[b].indexOf("$") + 1, split[b].indexOf(" ", split[b].indexOf("$"))))));
/*  909 */         b++;
/*      */       }
/*  911 */       int j = 0;
/*  912 */       while (j < amount.size())
/*      */       {
/*  914 */         int z = amount.size() - 1;
/*  915 */         while (z >= 0)
/*      */         {
/*  917 */           if (j >= amount.size())
/*      */             break;
/*  919 */           if ((((String)((ArrayList)year).get(j)).equals(((ArrayList)year).get(z))) && (j != z))
/*      */           {
/*  921 */             amount.set(j, Integer.valueOf(((Integer)amount.get(j)).intValue() + ((Integer)amount.get(z)).intValue()));
/*  922 */             amount.remove(z);
/*  923 */             ((ArrayList)year).remove(z);
/*      */           }
/*      */           
/*  926 */           z--;
/*      */         }
/*  928 */         j++;
/*      */       }
/*  930 */       i++;
/*      */       
/*  932 */       int y = 0;
/*  933 */       String line = " " + name;
/*  934 */       while (y < amount.size())
/*      */       {
/*  936 */         if (y == amount.size() - 1) {
/*  937 */           line = line + " $" + String.valueOf(amount.get(y)) + " " + (String)((ArrayList)year).get(y) + ";";
/*      */         } else
/*  939 */           line = line + " $" + String.valueOf(amount.get(y)) + " " + (String)((ArrayList)year).get(y) + ",";
/*  940 */         y++;
/*      */       }
/*  942 */       lines2.add(line);
/*      */     }
/*      */     
/*      */ 
/*  946 */     i = 0;
/*  947 */     while (i < lines2.size())
/*      */     {
/*      */ 
/*  950 */       string = string + (String)lines2.get(i);
/*  951 */       i++;
/*      */     }
/*  953 */     return string;
/*      */   }
/*      */   
/*      */ 
/*      */   public String getKeyDonationHistory()
/*      */     throws IOException
/*      */   {
/*  960 */     StringReader sr = new StringReader(this.order2);
/*  961 */     BufferedReader br = new BufferedReader(sr);
/*  962 */     int i = 0;
/*  963 */     String row = br.readLine();
/*  964 */     while (row != null)
/*      */     {
/*  966 */       i++;
/*  967 */       row = br.readLine();
/*      */     }
/*  969 */     String[] order = new String[i];
/*  970 */     sr = new StringReader(this.order2);
/*  971 */     br = new BufferedReader(sr);
/*      */     
/*  973 */     i = 0;
/*      */     
/*  975 */     while (i < order.length)
/*      */     {
/*  977 */       order[i] = br.readLine();
/*  978 */       i++;
/*      */     }
/*      */     
/*  981 */     i = 0;
/*  982 */     while (i < order.length)
/*      */     {
/*  984 */       if (order[i].equals("HOUSE")) {
/*      */         break;
/*      */       }
/*      */       
/*  988 */       i++;
/*      */     }
/*  990 */     String[] lines = getDonationHistoryAsString().split(";");
/*  991 */     ArrayList<String> names = new ArrayList();
/*  992 */     int j = 0;
/*  993 */     while (j < this.donationHistory.size())
/*      */     {
/*  995 */       names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       
/*  997 */       j++;
/*      */     }
/*      */     
/* 1000 */     j = 0;
/* 1001 */     while (j < names.size())
/*      */     {
/* 1003 */       int k = names.size() - 1;
/* 1004 */       while ((k >= 0) && (j != k))
/*      */       {
/* 1006 */         if (((String)names.get(j)).equals(names.get(k)))
/* 1007 */           names.remove(k);
/* 1008 */         k--;
/*      */       }
/* 1010 */       j++;
/*      */     }
/*      */     
/* 1013 */     ArrayList<String> names2 = new ArrayList();
/*      */     
/* 1015 */     j = 0;
/* 1016 */     while (j < order.length)
/*      */     {
/* 1018 */       int a = 0;
/* 1019 */       while (a < names.size())
/*      */       {
/* 1021 */         if (((String)names.get(a)).equals(order[j]))
/*      */         {
/* 1023 */           names2.add(names.get(a));
/*      */         }
/* 1025 */         a++;
/*      */       }
/* 1027 */       j++;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1033 */     int last = -1;
/* 1034 */     j = 0;
/* 1035 */     while (j < names2.size())
/*      */     {
/* 1037 */       int a = 0;
/* 1038 */       while (a <= i)
/*      */       {
/* 1040 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 1042 */           last = j;
/*      */         }
/* 1044 */         a++;
/*      */       }
/* 1046 */       j++;
/*      */     }
/* 1048 */     String line = "";
/* 1049 */     j = 0;
/* 1050 */     if (lines.length > 14)
/*      */     {
/* 1052 */       while ((j <= last) || (j < 15))
/*      */       {
/* 1054 */         line = line + lines[j] + "; ";
/* 1055 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 1059 */     while (((j <= last) || (j < lines.length)) && (j < lines.length))
/*      */     {
/* 1061 */       line = line + lines[j] + "; ";
/* 1062 */       j++;
/*      */     }
/* 1064 */     if (line.equals("")) {
/* 1065 */       return "NONE";
/*      */     }
/* 1067 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getHouseDonationHistory()
/*      */     throws IOException
/*      */   {
/* 1158 */     StringReader sr = new StringReader(this.order2);
/* 1159 */     BufferedReader br = new BufferedReader(sr);
/* 1160 */     int i = 0;
/* 1161 */     String row = br.readLine();
/* 1162 */     while (row != null)
/*      */     {
/* 1164 */       i++;
/* 1165 */       row = br.readLine();
/*      */     }
/* 1167 */     String[] order = new String[i];
/* 1168 */     sr = new StringReader(this.order2);
/* 1169 */     br = new BufferedReader(sr);
/*      */     
/* 1171 */     i = 0;
/*      */     
/* 1173 */     while (i < order.length)
/*      */     {
/* 1175 */       order[i] = br.readLine();
/* 1176 */       i++;
/*      */     }
/*      */     
/* 1179 */     i = 0;
/* 1180 */     while (i < order.length)
/*      */     {
/* 1182 */       if (order[i].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1186 */       i++;
/*      */     }
/* 1188 */     int q = 0;
/* 1189 */     while (q < order.length)
/*      */     {
/* 1191 */       if (order[q].equals("HOUSE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1195 */       q++;
/*      */     }
/*      */     
/* 1198 */     String[] lines = getDonationHistoryAsString().split(";");
/* 1199 */     ArrayList<String> names = new ArrayList();
/* 1200 */     int j = 0;
/* 1201 */     while (j < this.donationHistory.size())
/*      */     {
/* 1203 */       names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       
/* 1205 */       j++;
/*      */     }
/*      */     
/* 1208 */     j = 0;
/* 1209 */     while (j < names.size())
/*      */     {
/* 1211 */       int k = names.size() - 1;
/* 1212 */       while ((k >= 0) && (j != k))
/*      */       {
/* 1214 */         if (((String)names.get(j)).equals(names.get(k)))
/* 1215 */           names.remove(k);
/* 1216 */         k--;
/*      */       }
/* 1218 */       j++;
/*      */     }
/*      */     
/* 1221 */     ArrayList<String> names2 = new ArrayList();
/*      */     
/* 1223 */     j = 0;
/* 1224 */     while (j < order.length)
/*      */     {
/* 1226 */       int a = 0;
/* 1227 */       while (a < names.size())
/*      */       {
/* 1229 */         if (((String)names.get(a)).equals(order[j]))
/*      */         {
/* 1231 */           names2.add(names.get(a));
/*      */         }
/* 1233 */         a++;
/*      */       }
/* 1235 */       j++;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1241 */     int last = -1;
/* 1242 */     j = 0;
/* 1243 */     while (j < names2.size())
/*      */     {
/* 1245 */       int a = q;
/* 1246 */       while (a < i)
/*      */       {
/* 1248 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 1250 */           last = j;
/*      */         }
/* 1252 */         a++;
/*      */       }
/* 1254 */       j++;
/*      */     }
/* 1256 */     int first = names2.size() - 1;
/* 1257 */     j = names2.size() - 1;
/* 1258 */     while (j >= 0)
/*      */     {
/* 1260 */       int a = q;
/* 1261 */       while (a < i)
/*      */       {
/* 1263 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 1265 */           first = j;
/*      */         }
/* 1267 */         a++;
/*      */       }
/* 1269 */       j--;
/*      */     }
/* 1271 */     String line = "";
/* 1272 */     j = first;
/* 1273 */     while ((j <= last) && (j >= 0) && (j < lines.length))
/*      */     {
/* 1275 */       line = line + lines[j] + "; ";
/* 1276 */       j++;
/*      */     }
/* 1278 */     if (line.equals("")) {
/* 1279 */       return "NONE";
/*      */     }
/* 1281 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getDHouseDonationHistory()
/*      */     throws IOException
/*      */   {
/* 1372 */     StringReader sr = new StringReader(this.order2);
/* 1373 */     BufferedReader br = new BufferedReader(sr);
/* 1374 */     int i = 0;
/* 1375 */     String row = br.readLine();
/* 1376 */     while (row != null)
/*      */     {
/* 1378 */       i++;
/* 1379 */       row = br.readLine();
/*      */     }
/* 1381 */     String[] order = new String[i];
/* 1382 */     sr = new StringReader(this.order2);
/* 1383 */     br = new BufferedReader(sr);
/*      */     
/* 1385 */     i = 0;
/*      */     
/* 1387 */     while (i < order.length)
/*      */     {
/* 1389 */       order[i] = br.readLine();
/* 1390 */       i++;
/*      */     }
/*      */     
/* 1393 */     i = 0;
/* 1394 */     while (i < order.length)
/*      */     {
/* 1396 */       if (order[i].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1400 */       i++;
/*      */     }
/* 1402 */     int q = 0;
/* 1403 */     while (q < order.length)
/*      */     {
/* 1405 */       if (order[q].equals("HOUSE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1409 */       q++;
/*      */     }
/*      */     
/* 1412 */     String[] lines = getDonationHistoryAsString().split(";");
/* 1413 */     ArrayList<String> names = new ArrayList();
/* 1414 */     int j = 0;
/* 1415 */     while (j < this.donationHistory.size())
/*      */     {
/* 1417 */       if ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("D")) || ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("Democrat")) && (((Donation)this.donationHistory.get(j)).getSeat().contains("house"))))
/*      */       {
/* 1419 */         names.add(((Donation)this.donationHistory.get(j)).getRecipientLast());
/*      */       }
/*      */       
/*      */ 
/* 1423 */       j++;
/*      */     }
/* 1425 */     j = 0;
/* 1426 */     while (j < names.size())
/*      */     {
/* 1428 */       int k = names.size() - 1;
/* 1429 */       while ((k >= 0) && (j != k))
/*      */       {
/* 1431 */         if (((String)names.get(j)).equals(names.get(k)))
/* 1432 */           names.remove(k);
/* 1433 */         k--;
/*      */       }
/* 1435 */       j++;
/*      */     }
/* 1437 */     ArrayList<Integer> nums = new ArrayList();
/* 1438 */     for (int k = 0; k < lines.length; k++) {
/* 1439 */       for (String name2 : names)
/* 1440 */         if (lines[k].contains(name2))
/* 1441 */           nums.add(Integer.valueOf(k));
/*      */     }
/* 1443 */     String line = "";
/* 1444 */     j = 0;
/* 1445 */     while (j < nums.size())
/*      */     {
/* 1447 */       line = line + lines[((Integer)nums.get(j)).intValue()] + "; ";
/* 1448 */       j++;
/*      */     }
/*      */     
/*      */ 
/* 1452 */     if (line.equals("")) {
/* 1453 */       return "NONE";
/*      */     }
/* 1455 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getRHouseDonationHistory()
/*      */     throws IOException
/*      */   {
/* 1621 */     StringReader sr = new StringReader(this.order2);
/* 1622 */     BufferedReader br = new BufferedReader(sr);
/* 1623 */     int i = 0;
/* 1624 */     String row = br.readLine();
/* 1625 */     while (row != null)
/*      */     {
/* 1627 */       i++;
/* 1628 */       row = br.readLine();
/*      */     }
/* 1630 */     String[] order = new String[i];
/* 1631 */     sr = new StringReader(this.order2);
/* 1632 */     br = new BufferedReader(sr);
/*      */     
/* 1634 */     i = 0;
/*      */     
/* 1636 */     while (i < order.length)
/*      */     {
/* 1638 */       order[i] = br.readLine();
/* 1639 */       i++;
/*      */     }
/*      */     
/* 1642 */     i = 0;
/* 1643 */     while (i < order.length)
/*      */     {
/* 1645 */       if (order[i].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1649 */       i++;
/*      */     }
/* 1651 */     int q = 0;
/* 1652 */     while (q < order.length)
/*      */     {
/* 1654 */       if (order[q].equals("HOUSE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1658 */       q++;
/*      */     }
/*      */     
/* 1661 */     String[] lines = getDonationHistoryAsString().split(";");
/* 1662 */     ArrayList<String> names = new ArrayList();
/* 1663 */     int j = 0;
/* 1664 */     while (j < this.donationHistory.size())
/*      */     {
/* 1666 */       if (((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("R")) || (((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("Republican"))) && (((Donation)this.donationHistory.get(j)).getSeat().contains("house")))
/*      */       {
/* 1668 */         names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       }
/*      */       
/*      */ 
/* 1672 */       j++;
/*      */     }
/* 1674 */     j = 0;
/* 1675 */     while (j < names.size())
/*      */     {
/* 1677 */       int k = names.size() - 1;
/* 1678 */       while ((k >= 0) && (j != k))
/*      */       {
/* 1680 */         if (((String)names.get(j)).equals(names.get(k)))
/* 1681 */           names.remove(k);
/* 1682 */         k--;
/*      */       }
/* 1684 */       j++;
/*      */     }
/* 1686 */     ArrayList<Integer> nums = new ArrayList();
/* 1687 */     for (int k = 0; k < lines.length; k++) {
/* 1688 */       for (String name2 : names)
/* 1689 */         if (lines[k].contains(name2))
/* 1690 */           nums.add(Integer.valueOf(k));
/*      */     }
/* 1692 */     String line = "";
/* 1693 */     j = 0;
/* 1694 */     while (j < nums.size())
/*      */     {
/* 1696 */       line = line + lines[((Integer)nums.get(j)).intValue()] + "; ";
/* 1697 */       j++;
/*      */     }
/*      */     
/* 1700 */     if (line.equals("")) {
/* 1701 */       return "NONE";
/*      */     }
/* 1703 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSenateDonationHistory()
/*      */     throws IOException
/*      */   {
/* 1861 */     StringReader sr = new StringReader(this.order2);
/* 1862 */     BufferedReader br = new BufferedReader(sr);
/* 1863 */     int i = 0;
/* 1864 */     String row = br.readLine();
/* 1865 */     while (row != null)
/*      */     {
/* 1867 */       i++;
/* 1868 */       row = br.readLine();
/*      */     }
/* 1870 */     String[] order = new String[i];
/* 1871 */     sr = new StringReader(this.order2);
/* 1872 */     br = new BufferedReader(sr);
/*      */     
/* 1874 */     i = 0;
/*      */     
/* 1876 */     while (i < order.length)
/*      */     {
/* 1878 */       order[i] = br.readLine();
/* 1879 */       i++;
/*      */     }
/*      */     
/* 1882 */     i = 0;
/* 1883 */     while (i < order.length)
/*      */     {
/* 1885 */       if (order[i].equals("PRESIDENTS")) {
/*      */         break;
/*      */       }
/*      */       
/* 1889 */       i++;
/*      */     }
/* 1891 */     int q = 0;
/* 1892 */     while (q < order.length)
/*      */     {
/* 1894 */       if (order[q].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 1898 */       q++;
/*      */     }
/*      */     
/* 1901 */     String[] lines = getDonationHistoryAsString().split(";");
/* 1902 */     ArrayList<String> names = new ArrayList();
/* 1903 */     int j = 0;
/* 1904 */     while (j < this.donationHistory.size())
/*      */     {
/* 1906 */       names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       
/* 1908 */       j++;
/*      */     }
/*      */     
/* 1911 */     j = 0;
/* 1912 */     while (j < names.size())
/*      */     {
/* 1914 */       int k = names.size() - 1;
/* 1915 */       while ((k >= 0) && (j != k))
/*      */       {
/* 1917 */         if (((String)names.get(j)).equals(names.get(k)))
/* 1918 */           names.remove(k);
/* 1919 */         k--;
/*      */       }
/* 1921 */       j++;
/*      */     }
/*      */     
/* 1924 */     ArrayList<String> names2 = new ArrayList();
/*      */     
/* 1926 */     j = 0;
/* 1927 */     while (j < order.length)
/*      */     {
/* 1929 */       int a = 0;
/* 1930 */       while (a < names.size())
/*      */       {
/* 1932 */         if (((String)names.get(a)).equals(order[j]))
/*      */         {
/* 1934 */           names2.add(names.get(a));
/*      */         }
/* 1936 */         a++;
/*      */       }
/* 1938 */       j++;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1944 */     int last = -1;
/* 1945 */     j = 0;
/* 1946 */     while (j < names2.size())
/*      */     {
/* 1948 */       int a = q;
/* 1949 */       while (a < i)
/*      */       {
/* 1951 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 1953 */           last = j;
/*      */         }
/* 1955 */         a++;
/*      */       }
/* 1957 */       j++;
/*      */     }
/* 1959 */     int first = names2.size() - 1;
/* 1960 */     j = names2.size() - 1;
/* 1961 */     while (j >= 0)
/*      */     {
/* 1963 */       int a = q;
/* 1964 */       while (a < i)
/*      */       {
/* 1966 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 1968 */           first = j;
/*      */         }
/* 1970 */         a++;
/*      */       }
/* 1972 */       j--;
/*      */     }
/* 1974 */     String line = "";
/* 1975 */     j = first;
/* 1976 */     while ((j <= last) && (j >= 0) && (j < lines.length))
/*      */     {
/* 1978 */       line = line + lines[j] + "; ";
/* 1979 */       j++;
/*      */     }
/* 1981 */     if (line.equals("")) {
/* 1982 */       return "NONE";
/*      */     }
/* 1984 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getDSenateDonationHistory()
/*      */     throws IOException
/*      */   {
/* 2068 */     StringReader sr = new StringReader(this.order2);
/* 2069 */     BufferedReader br = new BufferedReader(sr);
/* 2070 */     int i = 0;
/* 2071 */     String row = br.readLine();
/* 2072 */     while (row != null)
/*      */     {
/* 2074 */       i++;
/* 2075 */       row = br.readLine();
/*      */     }
/* 2077 */     String[] order = new String[i];
/* 2078 */     sr = new StringReader(this.order2);
/* 2079 */     br = new BufferedReader(sr);
/*      */     
/* 2081 */     i = 0;
/*      */     
/* 2083 */     while (i < order.length)
/*      */     {
/* 2085 */       order[i] = br.readLine();
/* 2086 */       i++;
/*      */     }
/*      */     
/* 2089 */     i = 0;
/* 2090 */     while (i < order.length)
/*      */     {
/* 2092 */       if (order[i].equals("PRESIDENTS")) {
/*      */         break;
/*      */       }
/*      */       
/* 2096 */       i++;
/*      */     }
/* 2098 */     int q = 0;
/* 2099 */     while (q < order.length)
/*      */     {
/* 2101 */       if (order[q].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 2105 */       q++;
/*      */     }
/*      */     
/* 2108 */     String[] lines = getDonationHistoryAsString().split(";");
/* 2109 */     ArrayList<String> names = new ArrayList();
/* 2110 */     int j = 0;
/* 2111 */     while (j < this.donationHistory.size())
/*      */     {
/* 2113 */       if ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("D")) || ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("Democrat")) && (((Donation)this.donationHistory.get(j)).getSeat().contains("senate")))) {
/* 2114 */         names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       }
/* 2116 */       j++;
/*      */     }
/* 2118 */     j = 0;
/* 2119 */     while (j < names.size())
/*      */     {
/* 2121 */       int k = names.size() - 1;
/* 2122 */       while ((k >= 0) && (j != k))
/*      */       {
/* 2124 */         if (((String)names.get(j)).equals(names.get(k)))
/* 2125 */           names.remove(k);
/* 2126 */         k--;
/*      */       }
/* 2128 */       j++;
/*      */     }
/* 2130 */     ArrayList<Integer> nums = new ArrayList();
/* 2131 */     for (int k = 0; k < lines.length; k++) {
/* 2132 */       for (String name2 : names)
/* 2133 */         if (lines[k].contains(name2))
/* 2134 */           nums.add(Integer.valueOf(k));
/*      */     }
/* 2136 */     String line = "";
/* 2137 */     j = 0;
/* 2138 */     while (j < nums.size())
/*      */     {
/* 2140 */       line = line + lines[((Integer)nums.get(j)).intValue()] + "; ";
/* 2141 */       j++;
/*      */     }
/*      */     
/*      */ 
/* 2145 */     if (line.equals("")) {
/* 2146 */       return "NONE";
/*      */     }
/* 2148 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getRSenateDonationHistory()
/*      */     throws IOException
/*      */   {
/* 2307 */     StringReader sr = new StringReader(this.order2);
/* 2308 */     BufferedReader br = new BufferedReader(sr);
/* 2309 */     int i = 0;
/* 2310 */     String row = br.readLine();
/* 2311 */     while (row != null)
/*      */     {
/* 2313 */       i++;
/* 2314 */       row = br.readLine();
/*      */     }
/* 2316 */     String[] order = new String[i];
/* 2317 */     sr = new StringReader(this.order2);
/* 2318 */     br = new BufferedReader(sr);
/*      */     
/* 2320 */     i = 0;
/*      */     
/* 2322 */     while (i < order.length)
/*      */     {
/* 2324 */       order[i] = br.readLine();
/* 2325 */       i++;
/*      */     }
/*      */     
/* 2328 */     i = 0;
/* 2329 */     while (i < order.length)
/*      */     {
/* 2331 */       if (order[i].equals("PRESIDENTS")) {
/*      */         break;
/*      */       }
/*      */       
/* 2335 */       i++;
/*      */     }
/* 2337 */     int q = 0;
/* 2338 */     while (q < order.length)
/*      */     {
/* 2340 */       if (order[q].equals("SENATE")) {
/*      */         break;
/*      */       }
/*      */       
/* 2344 */       q++;
/*      */     }
/*      */     
/* 2347 */     String[] lines = getDonationHistoryAsString().split(";");
/* 2348 */     ArrayList<String> names = new ArrayList();
/* 2349 */     int j = 0;
/* 2350 */     while (j < this.donationHistory.size())
/*      */     {
/* 2352 */       if ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("R")) || ((((Donation)this.donationHistory.get(j)).getRecipientParty().equalsIgnoreCase("Republican")) && (((Donation)this.donationHistory.get(j)).getSeat().contains("senate")))) {
/* 2353 */         names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       }
/* 2355 */       j++;
/*      */     }
/* 2357 */     j = 0;
/* 2358 */     while (j < names.size())
/*      */     {
/* 2360 */       int k = names.size() - 1;
/* 2361 */       while ((k >= 0) && (j != k))
/*      */       {
/* 2363 */         if (((String)names.get(j)).equals(names.get(k)))
/* 2364 */           names.remove(k);
/* 2365 */         k--;
/*      */       }
/* 2367 */       j++;
/*      */     }
/* 2369 */     ArrayList<Integer> nums = new ArrayList();
/* 2370 */     for (int k = 0; k < lines.length; k++) {
/* 2371 */       for (String name2 : names)
/* 2372 */         if (lines[k].contains(name2))
/* 2373 */           nums.add(Integer.valueOf(k));
/*      */     }
/* 2375 */     String line = "";
/* 2376 */     j = 0;
/* 2377 */     while (j < nums.size())
/*      */     {
/* 2379 */       line = line + lines[((Integer)nums.get(j)).intValue()] + "; ";
/* 2380 */       j++;
/*      */     }
/*      */     
/* 2383 */     if (line.equals("")) {
/* 2384 */       return "NONE";
/*      */     }
/* 2386 */     return line;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOtherDonationHistory()
/*      */     throws IOException
/*      */   {
/* 2537 */     StringReader sr = new StringReader(this.order2);
/* 2538 */     BufferedReader br = new BufferedReader(sr);
/* 2539 */     int i = 0;
/* 2540 */     String row = br.readLine();
/* 2541 */     while (row != null)
/*      */     {
/* 2543 */       i++;
/* 2544 */       row = br.readLine();
/*      */     }
/* 2546 */     String[] order = new String[i];
/* 2547 */     sr = new StringReader(this.order2);
/* 2548 */     br = new BufferedReader(sr);
/*      */     
/* 2550 */     i = 0;
/*      */     
/* 2552 */     while (i < order.length)
/*      */     {
/* 2554 */       order[i] = br.readLine();
/* 2555 */       i++;
/*      */     }
/*      */     
/* 2558 */     String[] lines = getDonationHistoryAsString().split(";");
/* 2559 */     ArrayList<String> names = new ArrayList();
/* 2560 */     int j = 0;
/* 2561 */     while (j < this.donationHistory.size())
/*      */     {
/* 2563 */       names.add(((Donation)this.donationHistory.get(j)).getRecipientName());
/*      */       
/* 2565 */       j++;
/*      */     }
/*      */     
/* 2568 */     j = 0;
/* 2569 */     while (j < names.size())
/*      */     {
/* 2571 */       int k = names.size() - 1;
/* 2572 */       while ((k >= 0) && (j != k))
/*      */       {
/* 2574 */         if (((String)names.get(j)).equals(names.get(k)))
/* 2575 */           names.remove(k);
/* 2576 */         k--;
/*      */       }
/* 2578 */       j++;
/*      */     }
/*      */     
/* 2581 */     ArrayList<String> names2 = new ArrayList();
/*      */     
/* 2583 */     j = 0;
/* 2584 */     while (j < names.size())
/*      */     {
/* 2586 */       int a = 0;
/* 2587 */       while (a < order.length)
/*      */       {
/* 2589 */         if (((String)names.get(j)).equals(order[a]))
/*      */         {
/* 2591 */           names2.add(names.get(j));
/*      */         }
/* 2593 */         a++;
/*      */       }
/* 2595 */       j++;
/*      */     }
/*      */     
/* 2598 */     int last = 0;
/* 2599 */     j = 0;
/* 2600 */     while (j < names2.size())
/*      */     {
/* 2602 */       int a = 0;
/* 2603 */       while (a < order.length)
/*      */       {
/* 2605 */         if (((String)names2.get(j)).equals(order[a]))
/*      */         {
/* 2607 */           last = j;
/*      */         }
/* 2609 */         a++;
/*      */       }
/* 2611 */       j++;
/*      */     }
/*      */     
/* 2614 */     last = names2.size() - 1;
/*      */     
/* 2616 */     String line = "";
/* 2617 */     j = lines.length - 1;
/* 2618 */     while (j > last)
/*      */     {
/* 2620 */       line = line + lines[j] + "; ";
/* 2621 */       j--;
/*      */     }
/*      */     
/* 2624 */     if (line.equals("")) {
/* 2625 */       return "NONE";
/*      */     }
/* 2627 */     return line;
/*      */   }
/*      */   
/*      */   public void findDonationHistory(String cycle, Boolean zip, Boolean city, Boolean employer, Boolean occupation, String APIKey) {
/* 2631 */     SearchInformation testSearch = new SearchInformation(getState(), getName(), cycle, APIKey);
/* 2632 */     if (zip.booleanValue())
/* 2633 */       testSearch.setZip(this.zip);
/* 2634 */     if (city.booleanValue())
/* 2635 */       testSearch.setCity(this.city);
/* 2636 */     if (employer.booleanValue())
/* 2637 */       testSearch.setEmployer(this.employer);
/* 2638 */     if (occupation.booleanValue())
/* 2639 */       testSearch.setOccupation(this.occupation);
/* 2640 */     setDonationHistory(Processing.getDonationData(testSearch));
/* 2641 */     if (!this.donationHistory.isEmpty()) {
/* 2642 */       ArrayList<Double> doubleArray = new ArrayList();
/* 2643 */       for (Donation donation : this.donationHistory) {
/* 2644 */         doubleArray.add(Double.valueOf(donation.getAmount()));
/*      */       }
/* 2646 */       this.data = new ListStatistics(doubleArray);
/*      */     }
/*      */   }
/*      */   
/*      */   public void findPointTotal(PointSettings test, Properties theSettings)
/*      */   {
/* 2652 */     int count = 0;
/* 2653 */     for (Donation i : this.donationHistory) {
/* 2654 */       int internalCount = 0;
/* 2655 */       if ((!i.getRecipientState().equals("")) && (test.states.contains(i.getRecipientState()))) {
/* 2656 */         for (String j : test.statesPoints) {
/* 2657 */           if (j.matches(i.getRecipientState() + ",[0-9]{1,}")) {}
/* 2658 */           String[] splitString = j.split(",");
/* 2659 */           internalCount += Integer.parseInt(splitString[1]);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 2664 */       if ((!i.getRecipientName().equals("")) && (test.candidates.contains(i.getRecipientName()))) {
/* 2665 */         for (??? = test.candidatesPoints.iterator(); ???.hasNext();) { ??? = (String)???.next();
/* 2666 */           if (???.matches(i.getRecipientName() + ",[0-9]{1,}")) {}
/* 2667 */           String[] splitString = ???.split(",");
/* 2668 */           internalCount += Integer.parseInt(splitString[1]);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 2673 */       switch (i.getRecipientParty()) {
/*      */       case "D": 
/* 2675 */         internalCount += test.demPoints;
/* 2676 */         break;
/*      */       case "R": 
/* 2678 */         internalCount += test.repubPoints;
/*      */       }
/*      */       
/* 2681 */       if (theSettings.getWeighByAmount().booleanValue())
/* 2682 */         count += internalCount * i.getAmount(); else {
/* 2683 */         count += internalCount;
/*      */       }
/* 2685 */       this.pointTotal *= i.getAmount() / 250.0D;
/*      */     }
/*      */     
/* 2688 */     if (count > 0)
/*      */     {
/* 2690 */       this.pointTotal = Math.log10(count);
/* 2691 */     } else if (count == 0) {
/* 2692 */       this.pointTotal = 0.0D;
/* 2693 */     } else if (count < 0) {
/* 2694 */       this.pointTotal = (Math.log10(Math.abs(count)) * -1.0D);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Micha\Downloads\Build1.4.2\dist\DonorLookup.jar!\com\donorlookup\Donor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */