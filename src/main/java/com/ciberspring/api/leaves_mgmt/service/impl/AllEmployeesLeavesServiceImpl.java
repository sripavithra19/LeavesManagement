package com.ciberspring.api.leaves_mgmt.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ciberspring.api.leaves_mgmt.entity.EmployeeLeaveBalances;
import com.ciberspring.api.leaves_mgmt.repository.AllLeaveBalancesRepository;
import com.ciberspring.api.leaves_mgmt.service.AllEmployeesLeavesService;

@Service
public class AllEmployeesLeavesServiceImpl implements AllEmployeesLeavesService {
	private final AllLeaveBalancesRepository allLeaveBalancesRepository;
	
	

	public AllEmployeesLeavesServiceImpl(AllLeaveBalancesRepository allLeaveBalancesRepository) {
		super();
		this.allLeaveBalancesRepository = allLeaveBalancesRepository;
	}

	@Override
	public List<EmployeeLeaveBalances> getAllEmployeesLeavesBalance() {
		return allLeaveBalancesRepository.findAll();
	}

}
