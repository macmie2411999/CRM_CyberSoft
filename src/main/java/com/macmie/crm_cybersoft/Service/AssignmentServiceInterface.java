package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.util.List;

public interface AssignmentServiceInterface {
    List<Assignment_CRM> getAllAssignmentsByName(String assignmentName);
}
