package com.ciberspring.api.leaves_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.entity.Leaves;
import com.ciberspring.api.leaves_mgmt.service.EmployeeLeaveBalancesService;
import com.ciberspring.api.leaves_mgmt.service.LeaveService;
import com.ciberspring.api.leaves_mgmt.service.impl.EmployeeLeaveBalancesServiceimpl;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	private final LeaveService leaveService;
	@Autowired
	public LeaveController(LeaveService leaveService, EmployeeLeaveBalancesServiceimpl balancesService) {
		this.leaveService = leaveService;
	}


	@GetMapping
	public List<Leaves> getAllLeaves() {
		return leaveService.getLeaveList();
	}

	
}
