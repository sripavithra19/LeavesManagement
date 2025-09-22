package com.ciberspring.api.leaves_mgmt.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberspring.api.leaves_mgmt.entity.Leaves;

@Repository
public interface LeaveRepository extends JpaRepository<Leaves, LocalDate>  {

}