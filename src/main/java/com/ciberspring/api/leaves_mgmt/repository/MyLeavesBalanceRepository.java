package com.ciberspring.api.leaves_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;

@Repository
public interface MyLeavesBalanceRepository extends JpaRepository<EmployeeLeaveBalances, Long> {
    
	EmployeeLeaveBalances findByEmployeeId(Long employeeId);
    EmployeeLeaveBalances findByEmail(String email); 
}