package com.macmie.crm_cybersoft.Constants;

public class Constants {
    // Attributes are used to connect to Database in MySQL
    public static final String DRIVER_MYSQL_JDBC = "com.mysql.cj.jdbc.Driver";
    public static final String URL_MYSQL_JDBC = "jdbc:mysql://localhost:3307/CyberSoft_CRM_MacMie";
    public static final String USERNAME_MYSQL_JDBC = "root";
    public static final String PASSWORD_MYSQL_JDBC = "macmie";

    // Paths of files JSP
    public static final String PNF_JSP = "/views/404.jsp";
    public static final String BLANK_JSP = "/views/blank.jsp";
    public static final String PROJECT_JSP = "/views/groupwork.jsp";
    public static final String PROJECT_ADD_JSP = "/views/groupwork-add.jsp";
    public static final String PROJECT_DETAILS_JSP = "/views/groupwork-details.jsp";
    public static final String HOME_JSP = "/views/index.jsp";
    public static final String LOGIN_JSP = "/views/login.jsp";
    public static final String PROFILE_JSP = "/views/profile.jsp";
    public static final String PROFILE_EDIT_JSP = "/views/profile-edit.jsp";
    public static final String ROLE_ADD_JSP = "/views/role-add.jsp";
    public static final String ROLE_TABLE_JSP = "/views/role-table.jsp";
    public static final String ASSIGNMENT_JSP = "/views/task.jsp";
    public static final String ASSIGNMENT_ADD_JSP = "/views/task-add.jsp";
    public static final String USER_ADD_JSP = "/views/user-add.jsp";
    public static final String USER_DETAILS_JSP = "/views/user-details.jsp";
    public static final String USER_TABLE_JSP = "/views/user-table.jsp";


    // Attributes of Tags in files JSP
    public static final String LOGIN_JSP_EMAIL = "email";
    public static final String LOGIN_JSP_PASSWORD = "password";

    // URLPatterns of Controllers
    // LoginController
    public static final String URL_LOGIN = "/login";
    public static final String URL_LOGIN_1 = "/";
    public static final String URL_LOGIN_2 = "";

    // LogoutController
    public static final String URL_LOGOUT = "/logout";

    // HomeController
    public static final String URL_HOME = "/home";
    public static final String URL_TEST = "/test";

    // ErrorController
    public static final String URL_ERROR = "/errorAuth";

    // PageNotFoundController
    public static final String URL_PNG = "/404";

    // BlankController
    public static final String URL_BLANK = "/blank";

    // UserController
    public static final String URL_USER = "/user";
    public static final String URL_USER_ADD = "/user/add";
    public static final String URL_USER_DETAILS = "/user/details";
    public static final String URL_USER_DELETE= "/user/delete";
    /* public static final String URL_USER_EDIT = "/user/table"; */

    // AssignmentController
    public static final String URL_ASSIGNMENT = "/assignment";
    public static final String URL_ASSIGNMENT_ADD = "/assignment/add";
    public static final String URL_ASSIGNMENT_DELETE = "/assignment/delete";

    // ProfileController
    public static final String URL_PROFILE = "/profile";
    public static final String URL_PROFILE_EDIT = "/profile/edit";

    // RoleController
    public static final String URL_ROLE = "/role";
    public static final String URL_ROLE_ADD = "/role/add";
    public static final String URL_ROLE_DELETE = "/role/delete";

    // ProjectController
    public static final String URL_PROJECT = "/project";
    public static final String URL_PROJECT_ADD = "/project/add";
    public static final String URL_PROJECT_DELETE = "/project/delete";
    public static final String URL_PROJECT_DETAILS = "/project/details";

    // Session's static attributes (not final)
    public static final String ID_CURRENT_USER = "ID_User";
    public static final String ID_CURRENT_USER_ROLE = "ID_Role";
    public static final String ID_CURRENT_USER_ASSIGNMENT = "ID_Assignment";
    public static final String ID_CURRENT_USER_PROJECT = "ID_Project";

    // Attributes of tables in Database
    // Table User_CRM
    public static final String USER_CRM = "User_CRM";
    public static final String USER_CRM_ID = "User_ID";
    public static final String USER_CRM_NAME = "User_Name";
    public static final String USER_CRM_EMAIL = "User_Email";
    public static final String USER_CRM_PASSWORD = "User_Password";
    public static final String USER_CRM_ROLE_ID = "User_Role_ID";

    // Table Role_CRM
    public static final String ROLE_CRM = "Role_CRM";
    public static final String ROLE_CRM_ID = "Role_ID";
    public static final String ROLE_CRM_NAME = "Role_Name";
    public static final String ROLE_CRM_DESCRIPTION = "Role_Description";

    public static final String ROLE_ADMIN = "1";
    public static final String ROLE_LEADER = "2";
    public static final String ROLE_MEMBER = "3";

    // Table Project_CRM
    public static final String PROJECT_CRM = "Project_CRM";
    public static final String PROJECT_CRM_ID = "Project_ID";
    public static final String PROJECT_CRM_NAME = "Project_Name";
    public static final String PROJECT_CRM_START_DATE = "Project_Start_Date";
    public static final String PROJECT_CRM_END_DATE = "Project_End_Date";

    // Table Assignment_CRM
    public static final String ASSIGNMENT_CRM = "Assignment_CRM";
    public static final String ASSIGNMENT_CRM_ID = "Assignment_ID";
    public static final String ASSIGNMENT_CRM_NAME = "Assignment_Name";
    public static final String ASSIGNMENT_CRM_START_DATE = "Assignment_Start_Date";
    public static final String ASSIGNMENT_CRM_END_DATE = "Assignment_End_Date";
    public static final String ASSIGNMENT_CRM_STATUS = "Assignment_Status";
    public static final String ASSIGNMENT_CRM_PROJECT_ID = "Assignment_Project_ID";
    public static final String ASSIGNMENT_CRM_USER_ID = "Assignment_User_ID";

    public static final String ASSIGNMENT_COMPLETED = "Hoan Thanh";
    public static final String ASSIGNMENT_PROCESSING = "Dang Xu Ly";
    public static final String ASSIGNMENT_STILL = "Chua Bat Dau";

    // Message
    public static final String ERROR_QUERY_DATA_FROM_MYSQL = "Something Wrong With Query Database: ";
    public static final String SESSION_FAILED_LOGIN = "Email/Password is Invalid!";
    public static final String MESSAGE_LOGIN = "Message";

    // Farrago
    public static final String LIST_ASSIGNMENTS = "Session_List_Assignments";
    public static final String LIST_USERS = "Session_List_Users";
    public static final String LIST_ROLES = "Session_List_Roles";
    public static final String LIST_PROJECTS = "Session_List_Projects";
    public static final String LIST_AUR_DTO = "Session_List_AUR_DTO";
    public static final String LIST_PAU_DTO = "Session_List_PAU_DTO";

    public static final String LOCALHOST = "http://localhost:8080";
    public static final String CONTEXT = "context";
    public static final String BEAN_PAU_DTO_REPOSITORY_INTERFACE = "pau_dto_repositoryInterface";
    public static final String FLAG_UN_DELETABLE = "Un_deletable";
    public static final String JUST_ID = "id";

    public static final String SELECTED_USE = "Selected_User";
    public static final String SELECTED_PROJECT = "Selected_User";
    public static final String LIST_USER_ASSIGNMENTS = "List_User_Assignments";
    public static final String LIST_ASSIGNMENTS_PROJECT = "List_Assignments_Project";
    public static final String LIST_PAU_PROJECT = "List_PAU_Project";
    public static final String LIST_COMPLETED_ASSIGNMENTS = "List_Completed_Assignments";
    public static final String LIST_PROCESSING_ASSIGNMENTS = "List_Processing_Assignments";
    public static final String LIST_STILL_ASSIGNMENTS = "List_Still_Assignments";
}
