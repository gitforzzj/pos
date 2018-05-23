package com.z4group.pos.web.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.Order;
import com.z4group.pos.domain.Pay;
import com.z4group.pos.service.IOrderService;
import com.z4group.pos.service.IPayService;
import com.z4group.pos.service.ITableManagerService;
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
	
	private double realreceivemoney;
	
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
		//0表示空桌，1表示开桌了但未点菜，2表示开桌且已点菜，3表示结账等待清桌
		table.setTableStatus(3);
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


	
}
