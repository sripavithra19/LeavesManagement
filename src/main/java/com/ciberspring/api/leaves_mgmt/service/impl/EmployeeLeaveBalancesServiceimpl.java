package com.ciberspring.api.leaves_mgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.repository.EmployeeLeaveBalancesRepository;
import com.ciberspring.api.leaves_mgmt.service.EmployeeLeaveBalancesService;

@Service
public class EmployeeLeaveBalancesServiceimpl implements EmployeeLeaveBalancesService {

	@Autowired
	private EmployeeLeaveBalancesRepository balancesRepository;

	@Override
	public List<EmployeeLeaveBalances> getAllBalances() {
		return balancesRepository.findAll();
	}


	@Override
	public EmployeeLeaveBalances getBalancesByEmployeeId(Long employeeId) {
	    Optional<EmployeeLeaveBalances> optionalBalances = balancesRepository.findById(employeeId);
	    
	    if (optionalBalances.isPresent()) {
	        EmployeeLeaveBalances balances = optionalBalances.get();
	        
	        // Fetch actual employee name from Employees service
	        String employeeName = fetchEmployeeNameFromEmployeesService(employeeId);
	        if (employeeName != null) {
	            balances.setEmployeeName(employeeName);
	        }
	        
	        return balances;
	    } else {
	        // Return default with actual name if possible
	        EmployeeLeaveBalances defaultBalances = new EmployeeLeaveBalances();
	        defaultBalances.setEmployeeId(employeeId);
	        
	        // Try to get real name
	        String employeeName = fetchEmployeeNameFromEmployeesService(employeeId);
	        defaultBalances.setEmployeeName(employeeName != null ? employeeName : "Employee " + employeeId);
	        
	        defaultBalances.setTotalGeneralLeaves(12);
            defaultBalances.setTotalPrivilegeLeaves(12);
            defaultBalances.setTotalRestrictedHolidays(2);
            defaultBalances.setGeneralLeavesAvailed(0);
            defaultBalances.setPrivilegeLeavesAvailed(0);
            defaultBalances.setRestrictedHolidaysAvailed(0);
	        return defaultBalances;
	    }
	}

	 private String fetchEmployeeNameFromEmployeesService(Long employeeId) {
	        try {
	            Optional<EmployeeLeaveBalances> employeeOptional = balancesRepository.findById(employeeId);
	            
	            if (employeeOptional.isPresent()) {
	                EmployeeLeaveBalances employee = employeeOptional.get();
	                return employee.getEmployeeName();
	                
	            }
	            return null;
	        } catch (Exception e) {
	            return null;
	        }
	    }
	}