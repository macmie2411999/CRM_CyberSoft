package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;

import java.util.List;

public class AssignmentService implements AssignmentServiceInterface {
    AssignmentRepositoryInterface assignmentRepositoryInterface;

    // Constructor
    public AssignmentService(AssignmentRepositoryInterface assignmentRepositoryInterface) {
        this.assignmentRepositoryInterface = assignmentRepositoryInterface;
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByName(String assignmentName) {
        return assignmentRepositoryInterface.getAllAssignmentsByName(assignmentName);
    }
}
