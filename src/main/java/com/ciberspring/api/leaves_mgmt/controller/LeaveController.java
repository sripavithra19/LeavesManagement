package com.ciberspring.api.leaves_mgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberspring.api.leaves_mgmt.entity.Leaves;
import com.ciberspring.api.leaves_mgmt.service.LeaveService;

@RestController
@RequestMapping("/localholidaylist")
public class LeaveController {

	private final LeaveService leaveService;
	
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;	
		
	}
	@GetMapping
	public List<Leaves> getAllLeaves() {
		return leaveService.getLeaveList();
	}



	
}