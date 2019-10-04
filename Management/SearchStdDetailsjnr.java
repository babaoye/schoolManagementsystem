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
public class SearchStdDetailsjnr {
    String Add_Id;
    String Name;
    String F_name;
    String Class;
    String Term;
     int Doa;
      String last_schl;
      int Tel_no;
      int C_fee;
      String Discount;
      String left;
       String P_add;
       String ExamPassed;
   

    public SearchStdDetailsjnr(String Add_Id,
                                String Name,
                                String F_name,
                                String Class,
                                String Term,
                                int Doa,
                                String last_schl,
                                int Tel_no,
                                int C_fee,
                                String Discount,
                                String left,
                                String P_add,
                                String ExamPassed){
    this.Add_Id=Add_Id;
    this.C_fee=C_fee;
    this.Class=Class;
    this.C_fee=C_fee;
    this.Discount=Discount;
    this.Doa=Doa;
    this.ExamPassed=ExamPassed;
    this.F_name=F_name;
    this.Name=Name;
    this.P_add=P_add;
    this.Tel_no=Tel_no;
    this.Term=Term;
    this.last_schl=last_schl;
    this.left=left;
    
    }

    public String getAdd_Id() {
        return Add_Id;
    }

    public int getC_fee() {
        return C_fee;
    }

    public String getDiscount() {
        return Discount;
    }

    public String getLass() {
        return Class;
    }

    public int getDoa() {
        return Doa;
    }

    public String getExamPassed() {
        return ExamPassed;
    }

    public String getF_name() {
        return F_name;
    }

    public String getLast_schl() {
        return last_schl;
    }

    public String getLeft() {
        return left;
    }

    public String getName() {
        return Name;
    }

    public String getP_add() {
        return P_add;
    }

    public int getTel_no() {
        return Tel_no;
    }

    public String getTerm() {
        return Term;
    }
                                
      
}
