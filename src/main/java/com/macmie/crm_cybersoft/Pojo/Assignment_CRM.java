package com.macmie.crm_cybersoft.Pojo;

public class Assignment_CRM {
    private int Assignment_ID;
    private String Assignment_Name;
    private String Assignment_Start_Date;
    private String Assignment_End_Date;
    private String Assignment_Status;
    private int Assignment_Project_ID;
    private int Assignment_User_ID;

    public Assignment_CRM() {
    }

    public Assignment_CRM(int assignment_ID, String assignment_Name,
                          String assignment_Start_Date, String assignment_End_Date,
                          String assignment_Status, int assignment_Project_ID, int assignment_User_ID) {
        Assignment_ID = assignment_ID;
        Assignment_Name = assignment_Name;
        Assignment_Start_Date = assignment_Start_Date;
        Assignment_End_Date = assignment_End_Date;
        Assignment_Status = assignment_Status;
        Assignment_Project_ID = assignment_Project_ID;
        Assignment_User_ID = assignment_User_ID;
    }

    public int getAssignment_ID() {
        return Assignment_ID;
    }

    public void setAssignment_ID(int assignment_ID) {
        Assignment_ID = assignment_ID;
    }

    public String getAssignment_Name() {
        return Assignment_Name;
    }

    public void setAssignment_Name(String assignment_Name) {
        Assignment_Name = assignment_Name;
    }

    public String getAssignment_Start_Date() {
        return Assignment_Start_Date;
    }

    public void setAssignment_Start_Date(String assignment_Start_Date) {
        Assignment_Start_Date = assignment_Start_Date;
    }

    public String getAssignment_End_Date() {
        return Assignment_End_Date;
    }

    public void setAssignment_End_Date(String assignment_End_Date) {
        Assignment_End_Date = assignment_End_Date;
    }

    public String getAssignment_Status() {
        return Assignment_Status;
    }

    public void setAssignment_Status(String assignment_Status) {
        Assignment_Status = assignment_Status;
    }

    public int getAssignment_Project_ID() {
        return Assignment_Project_ID;
    }

    public void setAssignment_Project_ID(int assignment_Project_ID) {
        Assignment_Project_ID = assignment_Project_ID;
    }

    public int getAssignment_User_ID() {
        return Assignment_User_ID;
    }

    public void setAssignment_User_ID(int assignment_User_ID) {
        Assignment_User_ID = assignment_User_ID;
    }
}
