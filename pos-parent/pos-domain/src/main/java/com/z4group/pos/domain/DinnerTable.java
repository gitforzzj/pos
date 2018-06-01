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
	private TableStatus tableStatus;
	private Integer tableNo;
	private Integer seatnum;
	private Date orderTime;
	private Set orders = new HashSet(0);

	
	
	public String getOrderNo() {
		if(tableStatus!=null&&!tableStatus.equals("")) {
			if(tableStatus.getStatusid()==2||tableStatus.getStatusid()==3) {
				 HashMap map = (HashMap) ServletActionContext.getRequest().getSession().getAttribute("map");
				 if(map!=null) {
					 String  orderNo = (String) map.get(orderTime);
					 return orderNo;
				 }
				 
			}
		}
		
		
		return null;
	}
	public String getTableOrderTime() {
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 if(orderTime!=null) {

			 String tableOrderTime = sdf.format(this.orderTime); 
			 return tableOrderTime;
		 }
		 return null;
	}
	
	// Constructors

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
			Set orders) {
		this.id = id;
		this.tableStatus = tableStatus;
		this.tableNo = tableNo;
		this.seatnum = seatnum;
		this.orderTime = orderTime;
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

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}