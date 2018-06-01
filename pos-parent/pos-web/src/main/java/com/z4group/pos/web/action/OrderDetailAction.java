package com.z4group.pos.web.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.Dish;
import com.z4group.pos.domain.Order;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.domain.Pay;
import com.z4group.pos.domain.User;
import com.z4group.pos.service.IDishService;
import com.z4group.pos.service.IOrderDetailService;
import com.z4group.pos.service.IOrderService;
import com.z4group.pos.service.IPayService;
import com.z4group.pos.service.ITableManagerService;
import com.z4group.pos.service.ITableStatusService;
import com.z4group.pos.web.action.base.BaseAction;


@Controller
@Scope("prototype")
public class OrderDetailAction extends BaseAction<OrderDetail> {

	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IDishService dishService;
	
	@Autowired
	private IPayService payService;
	
	@Autowired
	private ITableManagerService tableManagerService;
	@Autowired 
	private ITableStatusService tableStatusService;
	
	
	private String orderdishid;
	private String checktaste;
	
	private HashMap map;
	
	private int time=0;

	private double realreceivemoney;
	private double ordertotalprice=0;
	
	public void newOrder() throws IOException{
		String f = "1";
		
		ServletActionContext.getRequest().getSession().setAttribute("orderDetailList", new ArrayList<OrderDetail>());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
	}
	
	public String add() throws IOException {
		
		String f = "1";
		try {
			
			/*model.setOrder(new Order("1",(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser")));*/
			ArrayList<OrderDetail> list = (ArrayList<OrderDetail>) ServletActionContext.getRequest().getSession().getAttribute("orderDetailList");
			if(list!=null) {
				List<Dish> dishes = dishService.findLikeId(model.getDishes().getDishid());
				Dish dish = dishes.get(0);
				model.setItemid(UUID.randomUUID().toString());
				model.setDishes(dish);
				model.setTotalprice(dish.getPrice()*model.getNum());
				list.add(model);
			}else {
				f="-1";
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	public String update() throws IOException {
		String f = "1";
		OrderDetail key = null;
		try {
			
			/*model.setOrder(new Order("1",(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser")));*/
			ArrayList<OrderDetail> list= (ArrayList<OrderDetail>) ServletActionContext.getRequest().getSession().getAttribute("orderDetailList");
			/*orderDetailService.add(model);*/
			for ( OrderDetail orderDetail: list) {
				if(orderDetail.getDishes().getDishid().equals(model.getDishes().getDishid())) {
					if(orderDetail.getTaste().equals(model.getTaste())) {
						key=orderDetail;
					}
				}
			}
			list.remove(key);
			key.setTotalprice(model.getNum()*key.getDishes().getPrice());
			key.setNum( model.getNum());
			list.add(key);
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	

	public String del() throws IOException {
		String f = "1";
		OrderDetail key=null;
		try {
			
			/*model.setOrder(new Order("1",(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser")));*/
			ArrayList<OrderDetail> list= (ArrayList<OrderDetail>) ServletActionContext.getRequest().getSession().getAttribute("orderDetailList");
			/*orderDetailService.add(model);*/
			for (OrderDetail orderDetail: list) {
				if(orderDetail.getDishes().getDishid().equals(model.getDishes().getDishid())) {
					if(orderDetail.getTaste().equals(model.getTaste())) {
						 key = orderDetail;
					}
				}
			}
			list.remove(key);
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	public String editOrder() throws IOException {
		String f = "1";
		OrderDetail key=null;
		try {
			
			/*model.setOrder(new Order("1",(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser")));*/
			ArrayList<OrderDetail> list= (ArrayList<OrderDetail>) ServletActionContext.getRequest().getSession().getAttribute("orderDetailList");
			/*orderDetailService.add(model);*/
			for (OrderDetail orderDetail: list) {
				if(orderDetail.getDishes().getDishid().equals(orderdishid)) {
					if(orderDetail.getTaste().equals(checktaste)) {
						 key = orderDetail;
					}
				}
			}
			list.remove(key);
			key.setTotalprice(model.getNum()*key.getDishes().getPrice());
			key.setNum(model.getNum());
			key.setTaste(model.getTaste());
			list.add(key);
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	
	public Order common() {
		
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();  
        String tableid = (String) session.get("savetableId"); 
        String oid = (String) session.get(tableid); 
        session.put("savetableId", null);
        ArrayList<OrderDetail> list= (ArrayList<OrderDetail>)  ServletActionContext.getRequest()
				.getSession().getAttribute("orderDetailList");
        //计算总单价
        for (OrderDetail orderDetail: list) {
        	ordertotalprice=ordertotalprice+orderDetail.getTotalprice();
        }
        Order order =null;
        if(oid!=null&&!oid.equals("")) {
        	 order = orderService.findById(oid);
        	 order.setOrdertotalprice(ordertotalprice+order.getOrdertotalprice());
        	 order.setUser((User) ServletActionContext.getRequest().getSession().getAttribute("loginUser"));
        	 orderService.update(order);
        }else {
        	order = new Order();
        	order.setOid(UUID.randomUUID().toString());
    		order.setOrdertime(new Timestamp(System.currentTimeMillis()));
    		order.setUser((User) ServletActionContext.getRequest().getSession().getAttribute("loginUser"));
    		
    		order.setOrdertotalprice(ordertotalprice);
    		order.setDinnerTable(tableManagerService.findById(tableid));
    		orderService.add(order);
        }
		
		
		
		
		for (OrderDetail orderDetail: list) {
			orderDetail.setItemid(UUID.randomUUID().toString());
			
			orderDetail.setOrder(order);
			orderDetailService.add(orderDetail);
		}
		 map = (HashMap) ServletActionContext.getRequest().getSession().getAttribute("map");
		if(map==null) {
			 map=new HashMap();
		}
		
		
		
		list=new ArrayList<OrderDetail>();
		  ServletActionContext.getRequest()
				.getSession().setAttribute("orderDetailList",list);
		return order;
		  
	}
	
	public void saveOrder() throws IOException {
		String f = "1";
		Order order = common();
		DinnerTable table = order.getDinnerTable();
		
		//1表示空桌，2表示开桌了但未点菜，3表示开桌且已点菜，4表示结账等待清桌
		table.setTableStatus(tableStatusService.findById(new Integer(3)));;
		tableManagerService.update(table);
		map.put(table.getOrderTime(), order.getOid());
		 ServletActionContext.getRequest().getSession().setAttribute("map",map);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
	}
	
	public void endOrder() throws IOException{
		String f = "1";
		try {
			Order order = common();
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
			//0表示空桌，1表示满桌，2表示等待清桌
			table.setTableStatus(tableStatusService.findById(3));
			tableManagerService.update(table);
			map.put(table.getOrderTime(), order.getOid());
			ServletActionContext.getRequest().getSession().setAttribute("map",map);
		}catch(Exception e) {
			e.printStackTrace();
			f="0";
		}
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(f);
	}
	
	
	
	public String hasOrderItem() {
		/*DetachedCriteria dc = pageBean.getDetachedCriteria();*/
		Map<OrderDetail, Integer> map = (Map<OrderDetail, Integer>) ServletActionContext.getRequest()
				.getSession().getAttribute("orderDetailList");
		ArrayList list = new ArrayList();
		for (Map.Entry<OrderDetail, Integer> entry : map.entrySet()) {
			OrderDetail orderDetail = new OrderDetail();
			
			orderDetail.setDishes(entry.getKey().getDishes());
			orderDetail.setNum(entry.getKey().getNum());
			orderDetail.setTaste(entry.getKey().getTaste());
			orderDetail.setTotalprice(entry.getKey().getDishes().getPrice()*entry.getKey().getNum());
			list.add(orderDetail);
		}
	
		/*orderDetailService.pageQuery(pageBean,list);*/
		
		this.java2json(list, new String[] {});
		return NONE;
	}

	public double getRealreceivemoney() {
		return realreceivemoney;
	}

	public void setRealreceivemoney(double realreceivemoney) {
		this.realreceivemoney = realreceivemoney;
	}

	public double getOrdertotalprice() {
		return ordertotalprice;
	}

	public void setOrdertotalprice(double ordertotalprice) {
		this.ordertotalprice = ordertotalprice;
	}

	public String getOrderdishid() {
		return orderdishid;
	}

	public void setOrderdishid(String orderdishid) {
		this.orderdishid = orderdishid;
	}
	public String getChecktaste() {
		return checktaste;
	}

	public void setChecktaste(String checktaste) {
		this.checktaste = checktaste;
	}


}
