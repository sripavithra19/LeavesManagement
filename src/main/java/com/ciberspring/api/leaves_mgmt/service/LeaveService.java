package com.ciberspring.api.leaves_mgmt.service;

import java.util.List;

import com.ciberspring.api.leaves_mgmt.entity.Leaves;

public interface LeaveService {
	List<Leaves> getLeaveList();
}
