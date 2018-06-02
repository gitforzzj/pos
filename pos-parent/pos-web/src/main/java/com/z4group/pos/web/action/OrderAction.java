package com.z4group.pos.web.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.Order;
import com.z4group.pos.domain.Pay;
import com.z4group.pos.service.IOrderService;
import com.z4group.pos.service.IPayService;
import com.z4group.pos.service.ITableManagerService;
import com.z4group.pos.service.ITableStatusService;
import com.z4group.pos.web.action.base.BaseAction;


@Controller
@Scope("prototype")
public class OrderAction extends BaseAction<Order>{
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IPayService payService;
	@Autowired
	private ITableManagerService  tableManagerService;
	@Autowired
	private ITableStatusService  tableStatusService;
	
	private double realreceivemoney;
	
	private String tableid;
	
	private String firsttime;
	private String secondtime;
	private Integer payStatus;
	
	public String NoPayOrderItem() {
		if(model!=null&&model.getOid()!=null) {
			
			Order order = orderService.findById(model.getOid());
			List list =  (List) new ArrayList(order.getOrderDetails());
			/*list.add(order);*/
			this.java2json(list, new String[] {"orderDetails","category","dinnerTable","pay","user","ordertime"});
		}else {

		}
		return NONE;
	}
	
	public String pageQuery() {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		//string->timestamp
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());  
		Timestamp ts2 = new Timestamp(System.currentTimeMillis()); 
		if(firsttime!=null&&secondtime!=null) {
			if(!firsttime.equals("")&&!secondtime.equals("")) {
				 ts1 = Timestamp.valueOf(firsttime);  
				 ts2 = Timestamp.valueOf(secondtime);  
				dc.add(Restrictions.between("ordertime", ts1, ts2));
			}else if(firsttime.equals("")&&!secondtime.equals("")) {
				ts2 = Timestamp.valueOf(secondtime);  
				dc.add(Restrictions.lt("ordertime",ts2));
			}else if(!firsttime.equals("")&&secondtime.equals("")) {
				ts1 = Timestamp.valueOf(firsttime); 
				dc.add(Restrictions.gt("ordertime", ts1));
			}
		}

		if(payStatus!=null) {
			if(payStatus==0) {
				
				dc.add(Restrictions.isNull("pay"));
			}else  if(payStatus==1) {
				dc.createAlias("pay", "p");   
				dc.add(Restrictions.eq("p.paystatus", payStatus));
			}
			
		}
		 
		
		dc.addOrder(org.hibernate.criterion.Order.desc("ordertime"));
		orderService.pageQuery(pageBean);/*
		ActionContext.getContext().getSession().put("dirId", null);*/
		//将返回的list集合转为json对象
		this.java2json(pageBean, new String[] {"orderDetails","orders","roles","tableStatus"});
		return NONE;
	}
	
	
	public void endOrder() throws IOException{
		String f = "1";
		Order order = orderService.findById(model.getOid()) ;
		Pay pay = new Pay();
		pay.setId(UUID.randomUUID().toString());
		//1代表现金支付，先只支持现金支付
		pay.setPaymethod(1);
		//1代表已支付
		pay.setPaystatus(1);
		pay.setPaytime(new Timestamp(System.currentTimeMillis()));
		pay.setRealreceivemoney(realreceivemoney);
		pay.setPaychange(realreceivemoney-order.getOrdertotalprice());
		payService.save(pay);
		order.setPay(pay);
		orderService.update(order);
		DinnerTable table = order.getDinnerTable();
		//1表示空桌，2表示开桌了但未点菜，3表示开桌且已点菜，4表示结账等待清桌
		table.setTableStatus(tableStatusService.findById(4));
		tableManagerService.update(table);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
	}

	public double getRealreceivemoney() {
		return realreceivemoney;
	}

	public void setRealreceivemoney(double realreceivemoney) {
		this.realreceivemoney = realreceivemoney;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getFirsttime() {
		return firsttime;
	}

	public String getSecondtime() {
		return secondtime;
	}

	public void setFirsttime(String firsttime) {
		this.firsttime = firsttime;
	}

	public void setSecondtime(String secondtime) {
		this.secondtime = secondtime;
	}


	
}
