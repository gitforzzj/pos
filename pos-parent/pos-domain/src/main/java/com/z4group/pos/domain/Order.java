package com.z4group.pos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private String oid;
	private DinnerTable dinnerTable;
	private Pay pay;
	private User user;
	private Date ordertime;
	private double ordertotalprice;
	private Set orderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String oid, User user) {
		this.oid = oid;
		this.user = user;
	}

	/** full constructor */
	public Order(String oid, DinnerTable dinnerTable, Pay pay, User user, Date ordertime, double ordertotalprice,
			Set orderDetails) {
		this.oid = oid;
		this.dinnerTable = dinnerTable;
		this.pay = pay;
		this.user = user;
		this.ordertime = ordertime;
		this.ordertotalprice = ordertotalprice;
		this.orderDetails = orderDetails;
	}

	// Property accessors

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public DinnerTable getDinnerTable() {
		return this.dinnerTable;
	}

	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}

	public Pay getPay() {
		return this.pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getOrdertotalprice() {
		return this.ordertotalprice;
	}

	public void setOrdertotalprice(double ordertotalprice) {
		this.ordertotalprice = ordertotalprice;
	}

	public Set getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set orderDetails) {
		this.orderDetails = orderDetails;
	}

}