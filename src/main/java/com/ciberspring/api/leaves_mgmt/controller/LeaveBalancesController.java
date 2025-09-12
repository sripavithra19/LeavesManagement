package com.ciberspring.api.leaves_mgmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.service.EmployeeLeaveBalancesService;
import com.ciberspring.api.leaves_mgmt.service.impl.EmployeeLeaveBalancesServiceimpl;

@RestController
@RequestMapping("/leaves")
public class LeaveBalancesController {

    private final EmployeeLeaveBalancesService balancesService;
    
    public LeaveBalancesController(EmployeeLeaveBalancesService balancesService) {
        this.balancesService = balancesService;
    }

    @GetMapping("/leaveDetails/{employeeId}")
    public EmployeeLeaveBalances getLeaveDetailsByEmployeeId(@PathVariable Long employeeId) {
        return balancesService.getBalancesByEmployeeId(employeeId);
    }

    @GetMapping("/allLeaveDetails")
    public List<EmployeeLeaveBalances> getAllLeaveDetails() {
        return balancesService.getAllBalances();
    }
}