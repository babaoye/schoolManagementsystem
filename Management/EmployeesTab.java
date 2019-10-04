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
public class EmployeesTab {
 private  int EmployeeId;
  private   String EmployeeName;
   private  String Dept;
   private  String Designation;
    private String Qualification;
    private String Address;
    private int Salary;
    private int ContactNo;
    private String Course;
    private String Gender;
    private String DateOfBirth;
    private String DateJoining;
    private String Left;
    private String DateOfLeaving;
    
    public EmployeesTab( 
          int EmployeeId,
    String EmployeeName,
    String Dept,
    String Designation,
    String Qualification,
    String Address,
    int Salary,
    int ContactNo,
    String Course,
    String Gender,
    String DateOfBirth,
    String DateJoining,
    String Left,
    String DateOfLeaving){
    
        this.EmployeeId=EmployeeId;
        this.Address=Address;
        this.ContactNo=ContactNo;
        this.Course=Course;
        this.DateJoining=DateJoining;
        this.DateOfBirth=DateOfBirth;
        this.DateOfLeaving=DateOfLeaving;
        this.Dept=Dept;
        this.Designation=Designation;
        this.EmployeeName=EmployeeName;
        this.EmployeeId=EmployeeId;
        this.Gender=Gender;
        this.Left=Left;
        this.Qualification=Qualification;
        this.Salary=Salary;
        
    }

    public String getAddress() {
        return Address;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public String getCourse() {
        return Course;
    }

    public String getDateJoining() {
        return DateJoining;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getDateOfLeaving() {
        return DateOfLeaving;
    }

    public String getDept() {
        return Dept;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public String getGender() {
        return Gender;
    }

    public String getLeft() {
        return Left;
    }

    public String getQualification() {
        return Qualification;
    }

    public int getSalary() {
        return Salary;
    }

   
    
    
}
