package com.ciberspring.api.leaves_mgmt.service;

import java.util.List;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;

public interface EmployeeLeaveBalancesService {
	List<EmployeeLeaveBalances> getAllBalances();
	EmployeeLeaveBalances getBalancesByEmployeeId(Long employeeId);
}
