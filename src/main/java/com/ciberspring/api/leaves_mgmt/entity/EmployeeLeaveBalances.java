package com.ciberspring.api.leaves_mgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_leave_balances")
public class EmployeeLeaveBalances {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    // NEW FIELD ADDED
    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "total_general_leaves")
    private Integer totalGeneralLeaves = 12;

    @Column(name = "total_privilege_leaves")
    private Integer totalPrivilegeLeaves = 12;

    @Column(name = "total_restricted_holidays")
    private Integer totalRestrictedHolidays = 2;

    @Column(name = "general_leaves_availed")
    private Integer generalLeavesAvailed = 0;

    @Column(name = "privilege_leaves_availed")
    private Integer privilegeLeavesAvailed = 0;

    @Column(name = "restricted_holidays_availed")
    private Integer restrictedHolidaysAvailed = 0;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getTotalGeneralLeaves() {
		return totalGeneralLeaves;
	}

	public void setTotalGeneralLeaves(Integer totalGeneralLeaves) {
		this.totalGeneralLeaves = totalGeneralLeaves;
	}

	public Integer getTotalPrivilegeLeaves() {
		return totalPrivilegeLeaves;
	}

	public void setTotalPrivilegeLeaves(Integer totalPrivilegeLeaves) {
		this.totalPrivilegeLeaves = totalPrivilegeLeaves;
	}

	public Integer getTotalRestrictedHolidays() {
		return totalRestrictedHolidays;
	}

	public void setTotalRestrictedHolidays(Integer totalRestrictedHolidays) {
		this.totalRestrictedHolidays = totalRestrictedHolidays;
	}

	public Integer getGeneralLeavesAvailed() {
		return generalLeavesAvailed;
	}

	public void setGeneralLeavesAvailed(Integer generalLeavesAvailed) {
		this.generalLeavesAvailed = generalLeavesAvailed;
	}

	public Integer getPrivilegeLeavesAvailed() {
		return privilegeLeavesAvailed;
	}

	public void setPrivilegeLeavesAvailed(Integer privilegeLeavesAvailed) {
		this.privilegeLeavesAvailed = privilegeLeavesAvailed;
	}

	public Integer getRestrictedHolidaysAvailed() {
		return restrictedHolidaysAvailed;
	}

	public void setRestrictedHolidaysAvailed(Integer restrictedHolidaysAvailed) {
		this.restrictedHolidaysAvailed = restrictedHolidaysAvailed;
	}

   
    
}
