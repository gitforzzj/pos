package com.z4group.pos.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DinnerTable entity. @author MyEclipse Persistence Tools
 */

public class DinnerTable implements java.io.Serializable {

	// Fields

	private String id;
	private TableStatus tableStatus;
	private Integer tableNo;
	private Integer seatnum;
	private Date orderTime;
	private String orderNo;
	private Set orders = new HashSet(0);

	// Constructors

	public String getTableOrderTime() {
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 if(orderTime!=null) {

			 String tableOrderTime = sdf.format(this.orderTime); 
			 return tableOrderTime;
		 }
		 return null;
	}
	
	/** default constructor */
	public DinnerTable() {
	}

	/** minimal constructor */
	public DinnerTable(String id, Integer tableNo) {
		this.id = id;
		this.tableNo = tableNo;
	}

	/** full constructor */
	public DinnerTable(String id, TableStatus tableStatus, Integer tableNo, Integer seatnum, Date orderTime,
			String orderNo, Set orders) {
		this.id = id;
		this.tableStatus = tableStatus;
		this.tableNo = tableNo;
		this.seatnum = seatnum;
		this.orderTime = orderTime;
		this.orderNo = orderNo;
		this.orders = orders;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TableStatus getTableStatus() {
		return this.tableStatus;
	}

	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}

	public Integer getTableNo() {
		return this.tableNo;
	}

	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}

	public Integer getSeatnum() {
		return this.seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}