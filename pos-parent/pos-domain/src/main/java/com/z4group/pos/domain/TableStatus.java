package com.z4group.pos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TableStatus entity. @author MyEclipse Persistence Tools
 */

public class TableStatus implements java.io.Serializable {

	// Fields

	private Integer statusid;
	private String statusName;
	private Set dinnerTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public TableStatus() {
	}

	/** minimal constructor */
	public TableStatus(Integer statusid) {
		this.statusid = statusid;
	}

	/** full constructor */
	public TableStatus(Integer statusid, String statusName, Set dinnerTables) {
		this.statusid = statusid;
		this.statusName = statusName;
		this.dinnerTables = dinnerTables;
	}

	// Property accessors

	public Integer getStatusid() {
		return this.statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Set getDinnerTables() {
		return this.dinnerTables;
	}

	public void setDinnerTables(Set dinnerTables) {
		this.dinnerTables = dinnerTables;
	}

}