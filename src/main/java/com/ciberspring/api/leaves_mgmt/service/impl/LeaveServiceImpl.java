package com.ciberspring.api.leaves_mgmt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberspring.api.leaves_mgmt.entity.Leaves;
import com.ciberspring.api.leaves_mgmt.repository.LeaveRepository;
import com.ciberspring.api.leaves_mgmt.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService {

	private final LeaveRepository leaveRepository;

	public LeaveServiceImpl(LeaveRepository leaveRepository) {
		this.leaveRepository = leaveRepository;
	}

	@Override
	public List<Leaves> getLeaveList() {

		return leaveRepository.findAll();
	}

}
