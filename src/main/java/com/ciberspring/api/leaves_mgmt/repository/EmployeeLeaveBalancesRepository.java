package com.ciberspring.api.leaves_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;

public interface EmployeeLeaveBalancesRepository extends JpaRepository<EmployeeLeaveBalances, Long> {
    // This simple interface will automatically have methods like findById, save, findAll, etc.
    // We can find by employeeId directly because it's the primary key (ID).
    // So findById(employeeId) will work.
}
