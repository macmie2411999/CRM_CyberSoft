package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.util.List;

public interface AssignmentRepositoryInterface {
    List<Assignment_CRM> getAllAssignmentsByName(String assignmentName);
}
