package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.util.List;

public interface AUR_DTO_ServiceInterface {
    List<AssignmentUserRole> getAllAssignmentUserRole();
//    List<Assignment_CRM> getAllAssignments();
//    List<Assignment_CRM> getAllRoles();
    List<User_CRM> getAllUsers();
}
