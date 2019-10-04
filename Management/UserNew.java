/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

/**
 *
 * @author USER1
 */
public class UserNew {
  

  private int  R_no;
  private int ID;
   private String  Name;
   private String F_name;
    private String Class;
     private int Day;
     private String month;
  private int year;
          private int MonthlyFee;
            private int AnnualFee;
                  private int OtherCharge; 
                  private int TotalFee;
                  private int Received;
                 
                  private int Balance;
          private int FeeReceipt;
 
 
  
  
  
  public UserNew(int R_no, int ID,String Name,String F_name,String Class,int Day,String month,int year,int MonthlyFee,int AnnualFee,int OtherCharge,int TotalFee,int Received,int Balance,int FeeReceipt){
   this.R_no= R_no;
   this.ID= ID;
   this.year= year;
   this.MonthlyFee= MonthlyFee;
   this.AnnualFee= AnnualFee;
   this.OtherCharge= OtherCharge;
   this.TotalFee= TotalFee;
   this.Received= Received;
   this.Name =Name;
   this.F_name = F_name;
   this.Class= Class;
   this.Day = Day;
   this.Balance = Balance;
   this.FeeReceipt = FeeReceipt;
   this.month= month;
  }
   public int getR_no(){
   return R_no;
   }
   public void setR_no(int R_no){
   this.R_no=R_no;
   }
   public int getID(){
   return ID;
   }
    public void setID(int ID){
   this.ID=ID;
   }
   public int getyear(){
   return year;
   }
   public void setyear(int year){
   this.year=year;
   }
    public int getMonthlyFee(){
   return MonthlyFee;
   }
    public void setMonthlyFee(int MonthlyFee){
   this.MonthlyFee=MonthlyFee;
   }
     public int getAnnualFee(){
   return AnnualFee;
   }
      public void setAnnualFee(int AnnualFee){
   this.AnnualFee=AnnualFee;
   }
      public int getOtherCharge(){
   return OtherCharge;
   }
       public void setOtherCharge(int OtherCharge){
   this.OtherCharge=OtherCharge;
   }
       public int getTotalFee(){
   return TotalFee;
   }
        public void setTotalFee(int TotalFee){
   this.TotalFee=TotalFee;
   }
        public int getReceived(){
   return Received;
   }
         public void setReceived(int Received){
   this.Received=Received;
   }
         public int getDay(){
    
   return Day;
   
   }
          public void setDay(int Day){
   this.Day=Day;
   }
         public String getName(){
   return Name;
   }
          public void setName(String Name){
   this.Name=Name;
   }
          public String getF_name(){
   return F_name;
   }
             public void setF_name(String F_name){
   this.F_name=F_name;
   }
           public String Class(){
   return Class;
   }
              public void setClass(String Class){
   this.Class=Class;
   }
               public int getBalance(){
   return Balance;
   }
                  public void setBalance(int Balance){
   this.Balance=Balance;
   }
   public String getmonth(){
   return month;
   }
      public void setmonth(String month){
   this.month=month;
   }
  
    public int getFeeReceipt(){
   return FeeReceipt;
   }
 
                  public void setFeeReceipt(int FeeReceipt){
   this.FeeReceipt=FeeReceipt;
   }
  
}


