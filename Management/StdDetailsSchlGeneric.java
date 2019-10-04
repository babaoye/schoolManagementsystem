/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

/**
 *
 * @author Babaoye Ayomide
 */
public class StdDetailsSchlGeneric {
   
  private int Std_No;
  private String Class;
  private String Name;
  private String DOB;
  private String Sex;
  private String HomeAdd;
  private int HomeTelNo;
  private int Emergency;
  private  String FathersName;
  private int MobileTelNo;
  private  String DateOfAdmission;
  private int   AdmissionFee;
  private String StudyStatus;
  private String LeavingDate;
                          
                         
   public StdDetailsSchlGeneric(int Std_No,  
                                    String Name,
                                    String FathersName,
                                    String Class,
                                     String DOB,
                                     String DateOfAdmission,
                                     String LeavingDate,
                                     int MobileTelNo,
                                     int Emergency,
                                     int  AdmissionFee,
                                     String StudyStatus,
                                     String HomeAdd,
                                     String Sex,
                                    int HomeTelNo){
       this.AdmissionFee=AdmissionFee;
       this.Class=Class;
       this.DOB=DOB;
       this.DateOfAdmission=DateOfAdmission;
       this.Emergency=Emergency;
       this.FathersName=FathersName;
       this.HomeAdd=HomeAdd;
       this.HomeTelNo=HomeTelNo;
       this.LeavingDate=LeavingDate;
       this.MobileTelNo=MobileTelNo;
       this.Name=Name;
       this.Sex=Sex;
       this.Std_No=Std_No;
       this.StudyStatus=StudyStatus;
   
   }

    public int getAdmissionFee() {
        return AdmissionFee;
    }

    public String getDOB() {
        return DOB;
    }

    public String getclass() {
        return Class;
    }

    public String getDateOfAdmission() {
        return DateOfAdmission;
    }

    public int getEmergency() {
        return Emergency;
    }

    public String getFathersName() {
        return FathersName;
    }

    public String getHomeAdd() {
        return HomeAdd;
    }

    public int getHomeTelNo() {
        return HomeTelNo;
    }

    public String getLeavingDate() {
        return LeavingDate;
    }

    public int getMobileTelNo() {
        return MobileTelNo;
    }

    public String getName() {
        return Name;
    }

    public String getSex() {
        return Sex;
    }

    public int getStd_No() {
        return Std_No;
    }

    public String getStudyStatus() {
        return StudyStatus;
    }
     
   
}
