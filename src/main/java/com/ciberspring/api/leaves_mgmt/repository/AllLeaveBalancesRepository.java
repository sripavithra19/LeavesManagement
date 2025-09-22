package com.ciberspring.api.leaves_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;

@Repository
public interface AllLeaveBalancesRepository extends JpaRepository<EmployeeLeaveBalances, Long> {

}
