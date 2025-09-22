package com.ciberspring.api.leaves_mgmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.service.MyLeaveBalancesService;

@RestController
@RequestMapping("/myLeaves")
public class MyLeavesController {

    private final MyLeaveBalancesService myBalancesService;
    
    public MyLeavesController(MyLeaveBalancesService myBalancesService) {
        this.myBalancesService = myBalancesService;
    }
    @GetMapping("/by-email")
    public ResponseEntity<EmployeeLeaveBalances> getLeavesByEmail(@RequestParam String email) {
        try {
            EmployeeLeaveBalances leaves = myBalancesService.getLeavesByEmail(email);
            return ResponseEntity.ok(leaves);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeaveBalances> getLeavesById(@PathVariable Long id) {
        try {
            EmployeeLeaveBalances leaves = myBalancesService.getLeavesById(id);
            return ResponseEntity.ok(leaves);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeLeaveBalances> getLeavesByEmployeeId(@PathVariable Long employeeId) {
        try {
            EmployeeLeaveBalances leaves = myBalancesService.getLeavesByEmployeeId(employeeId);
            return ResponseEntity.ok(leaves);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}