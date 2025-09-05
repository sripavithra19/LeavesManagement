package com.ciberspring.api.leaves_mgmt.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberspring.api.leaves_mgmt.entity.Leaves;


public interface LeaveRepository extends JpaRepository<Leaves, LocalDate>  {

}
