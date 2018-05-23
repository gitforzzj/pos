package com.z4group.pos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pay entity. @author MyEclipse Persistence Tools
 */

public class Pay implements java.io.Serializable {

	// Fields

	private String id;
	private Date paytime;
	private Integer paystatus;
	private Integer paymethod;
	private double realreceivemoney;
	private double paychange;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pay() {
	}

	/** minimal constructor */
	public Pay(String id) {
		this.id = id;
	}

	/** full constructor */
	public Pay(String id, Date paytime, Integer paystatus, Integer paymethod, double realreceivemoney, double paychange,
			Set orders) {
		this.id = id;
		this.paytime = paytime;
		this.paystatus = paystatus;
		this.paymethod = paymethod;
		this.realreceivemoney = realreceivemoney;
		this.paychange = paychange;
		this.orders = orders;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public Integer getPaystatus() {
		return this.paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	public Integer getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(Integer paymethod) {
		this.paymethod = paymethod;
	}

	public double getRealreceivemoney() {
		return this.realreceivemoney;
	}

	public void setRealreceivemoney(double realreceivemoney) {
		this.realreceivemoney = realreceivemoney;
	}

	public double getPaychange() {
		return this.paychange;
	}

	public void setPaychange(double paychange) {
		this.paychange = paychange;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}