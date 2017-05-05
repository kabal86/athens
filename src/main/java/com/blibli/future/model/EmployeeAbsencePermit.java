package com.blibli.future.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EmployeeAbsencePermit {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String nik;
	private String idAbsencePermit;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String status;
	
	public EmployeeAbsencePermit(String nik, String idAbsencePermit, 
			LocalDate startDate, LocalDate endDate, String reason){
		this.nik = nik;
		this.idAbsencePermit = idAbsencePermit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = "Waiting";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getIdAbsencePermit() {
		return idAbsencePermit;
	}

	public void setIdAbsencePermit(String idAbsencePermit) {
		this.idAbsencePermit = idAbsencePermit;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
