package com.ciberspring.api.leaves_mgmt.service;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;

public interface MyLeaveBalancesService {
    EmployeeLeaveBalances getLeavesById(Long id);
    EmployeeLeaveBalances getLeavesByEmployeeId(Long employeeId);
    EmployeeLeaveBalances getLeavesByEmail(String email); 
}