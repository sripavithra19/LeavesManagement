package com.ciberspring.api.leaves_mgmt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ciberspring.api.leaves_mgmt.entity.Leaves;
import com.ciberspring.api.leaves_mgmt.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	private final LeaveService leaveService;

	@Autowired
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	@GetMapping
	public List<Leaves> getAllLeaves() {
		return leaveService.getLeaveList();
	}
}
