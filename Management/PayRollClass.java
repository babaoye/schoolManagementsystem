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
public class PayRollClass {
   int EmpId;
   String Name;
  String   Department;
 String   Designation;
  int Day;
  String  Month;
 int  Year;
 int  Bsalary;
 int  Psalary;
  int salary;
 int  deduction;
 int  NetSalary;
 int  SNo;
  
    public PayRollClass(
            int EmpId,
   String Name,
  String   Department,
 String   Designation,
  int Day,
  String  Month,
 int  Year,
 int  Bsalary,
 int  Psalary,
  int salary,
 int  deduction,
 int  NetSalary,
 int  SNo){
    this.EmpId=EmpId;
    this.Name=Name;
    this.Department=Department;
    this.Designation=Designation;
    this.Day=Day;
    this.Month=Month;
    this.Year=Year;
    this.Bsalary=Bsalary;
    this.Psalary=Psalary;
    this.salary=salary;
    this.deduction=deduction;
    this.NetSalary=NetSalary;
    this.SNo=SNo;
    }

    public int getBsalary() {
        return Bsalary;
    }

    public int getDay() {
        return Day;
    }

    public int getDeduction() {
        return deduction;
    }

    public String getDepartment() {
        return Department;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getEmpId() {
        return EmpId;
    }

    public String getMonth() {
        return Month;
    }

    public String getName() {
        return Name;
    }

    public int getNetSalary() {
        return NetSalary;
    }

    public int getPsalary() {
        return Psalary;
    }

    public int getSNo() {
        return SNo;
    }

    public int getSalary() {
        return salary;
    }

    public int getYear() {
        return Year;
    }
    
    
}
