package com.macmie.crm_cybersoft.Pojo;

public class Project_CRM {
    private int Project_ID;
    private String Project_Name;
    private String Project_Start_Date;
    private String Project_End_Date;

    public Project_CRM() {
    }

    public Project_CRM(int project_ID, String project_Name,
                       String project_Start_Date, String project_End_Date) {
        Project_ID = project_ID;
        Project_Name = project_Name;
        Project_Start_Date = project_Start_Date;
        Project_End_Date = project_End_Date;
    }

    public int getProject_ID() {
        return Project_ID;
    }

    public void setProject_ID(int project_ID) {
        Project_ID = project_ID;
    }

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String project_Name) {
        Project_Name = project_Name;
    }

    public String getProject_Start_Date() {
        return Project_Start_Date;
    }

    public void setProject_Start_Date(String project_Start_Date) {
        Project_Start_Date = project_Start_Date;
    }

    public String getProject_End_Date() {
        return Project_End_Date;
    }

    public void setProject_End_Date(String project_End_Date) {
        Project_End_Date = project_End_Date;
    }
}
