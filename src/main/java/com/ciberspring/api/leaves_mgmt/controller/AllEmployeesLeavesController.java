package com.ciberspring.api.leaves_mgmt.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.service.AllEmployeesLeavesService;

@RestController
@RequestMapping("/AllLeaveBalance")
public class AllEmployeesLeavesController {
	private final AllEmployeesLeavesService allEmployeesLeavesService;

	public AllEmployeesLeavesController(AllEmployeesLeavesService allEmployeesLeavesService) {
		super();
		this.allEmployeesLeavesService = allEmployeesLeavesService;
	}

	@GetMapping
	public ResponseEntity<List<EmployeeLeaveBalances>> getAllEmployees(@AuthenticationPrincipal Jwt jwt) {
		// DEBUG: Print all claims in the token
		System.out.println("=== JWT TOKEN DEBUG ===");
		jwt.getClaims().forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});

		// Check specifically for groups
		List<String> groups = jwt.getClaimAsStringList("groups");
		System.out.println("Groups: " + groups);
		System.out.println("Has HR_EMPLOYEES_ACCESS: " + (groups != null && groups.contains("HR_EMPLOYEES_ACCESS")));
		System.out.println("=========================");

		return ResponseEntity.ok(allEmployeesLeavesService.getAllEmployeesLeavesBalance());
	}

}
