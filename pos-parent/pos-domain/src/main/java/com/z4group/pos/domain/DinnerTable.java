package com.z4group.pos.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

/**
 * DinnerTable entity. @author MyEclipse Persistence Tools
 */

public class DinnerTable implements java.io.Serializable {

	// Fields

	private String id;
	private Integer tableNo;
	private Integer tableStatus;
	private Date orderTime;
	private Integer seatnum;
	private Set orders = new HashSet(0);

	// Constructors

	public String getOrderNo() {
		
		if(tableStatus==2||tableStatus==3) {
			 HashMap map = (HashMap) ServletActionContext.getRequest().getSession().getAttribute("map");
			 if(map!=null) {
				 String  orderNo = (String) map.get(orderTime);
				 return orderNo;
			 }
			 
		}
		
		return null;
	}
	
	/** default constructor */
	public DinnerTable() {
	}

	/** minimal constructor */
	public DinnerTable(String id, Integer tableNo, Integer tableStatus) {
		this.id = id;
		this.tableNo = tableNo;
		this.tableStatus = tableStatus;
	}

	/** full constructor */
	public DinnerTable(String id, Integer tableNo, Integer tableStatus, Date orderTime, Integer seatnum, Set orders) {
		this.id = id;
		this.tableNo = tableNo;
		this.tableStatus = tableStatus;
		this.orderTime = orderTime;
		this.seatnum = seatnum;
		this.orders = orders;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTableNo() {
		return this.tableNo;
	}

	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}

	public Integer getTableStatus() {
		return this.tableStatus;
	}

	public void setTableStatus(Integer tableStatus) {
		
		
		this.tableStatus = tableStatus;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getTableOrderTime() {
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 if(orderTime!=null) {

			 String tableOrderTime = sdf.format(this.orderTime); 
			 return tableOrderTime;
		 }
		 return null;
	}
	
	public Integer getSeatnum() {
		return this.seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}