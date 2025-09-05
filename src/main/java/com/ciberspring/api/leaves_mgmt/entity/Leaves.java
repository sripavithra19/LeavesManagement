package com.ciberspring.api.leaves_mgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "LOCALHOLIDAYS")
public class Leaves {
	@Id
	@Column(name = "HOLIDAY_DATE", nullable = false)
	private LocalDate holidayDate;

	@Column(name = "DAY_NAME", nullable = false, length = 15)
	private String dayName;

	@Column(name = "HOLIDAY_TYPE", nullable = false, length = 20)
	private String holidayType;

	@Column(name = "DESCRIPTIONS", nullable = false, length = 255)
	private String descriptions;

	public LocalDate getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(LocalDate holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
