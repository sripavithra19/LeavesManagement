package com.ciberspring.api.leaves_mgmt.service.impl;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.repository.MyLeavesBalanceRepository;
import com.ciberspring.api.leaves_mgmt.service.MyLeaveBalancesService;

@Service
public class MyLeaveBalancesServiceImpl implements MyLeaveBalancesService {

	private final MyLeavesBalanceRepository myLeavesBalanceRepository;

	@Autowired
	public MyLeaveBalancesServiceImpl(MyLeavesBalanceRepository myLeavesBalanceRepository) {
		this.myLeavesBalanceRepository = myLeavesBalanceRepository;
	}

	@Override
	public EmployeeLeaveBalances getLeavesByEmail(String email) {
	    System.out.println("=== LEAVES SERVICE DEBUG ===");
	    System.out.println("Received email: '" + email + "'");
	    
	    try {
	        // URL decode the email in case it comes encoded
	        String decodedEmail = URLDecoder.decode(email, StandardCharsets.UTF_8.toString());
	        System.out.println("Decoded email: '" + decodedEmail + "'");
	        
	        EmployeeLeaveBalances leaves = myLeavesBalanceRepository.findByEmail(decodedEmail);
	        
	        if (leaves == null) {
	            // Also try with the original email
	            leaves = myLeavesBalanceRepository.findByEmail(email);
	        }
	        
	        if (leaves == null) {
	            throw new RuntimeException("Leave balances not found for email: " + email);
	        }
	        
	        System.out.println("Found leaves: " + leaves);
	        return leaves;
	    } catch (Exception e) {
	        throw new RuntimeException("Error processing email: " + e.getMessage());
	    }
	}

	@Override
	public EmployeeLeaveBalances getLeavesById(Long id) {
		return myLeavesBalanceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee Leaves not found for id: " + id));
	}

	@Override
	public EmployeeLeaveBalances getLeavesByEmployeeId(Long employeeId) {
		return myLeavesBalanceRepository.findByEmployeeId(employeeId);
	}
}