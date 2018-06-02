package com.z4group.pos.web.action;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.z4group.pos.domain.Category;
import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.domain.TableStatus;
import com.z4group.pos.service.ITableManagerService;
import com.z4group.pos.service.ITableStatusService;
import com.z4group.pos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class TableManagerAction extends BaseAction<DinnerTable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ITableManagerService tableManagerService;
	@Autowired
	private ITableStatusService tableStatusService;
	
	private String oid;
	private Integer statusid;
	/*
	 * 分页查询，调用service执行业务方法，并将查到的数据转为json对象
	 */
	public String pageQuery() {/*
		String id = (String) ActionContext.getContext().getSession().get("dirId");*/
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		if(model.getSeatnum()!=null) {
			Integer seatnum = model.getSeatnum();
			dc.add(Restrictions.or(Restrictions.gt("seatnum", seatnum),Restrictions.eq("seatnum", seatnum)));
		}
		
		TableStatus tableStatus=null;
		if(statusid!=null&&statusid==-1) {
			statusid=null;
		}

		if(statusid!=null) {
			tableStatus = tableStatusService.findById(statusid);
		}
		 
		if(tableStatus!=null) {
			dc.add(Restrictions.or(Restrictions.eq("tableStatus", tableStatus)));
			/*if(StringUtils.isNotBlank(dishid)) 
			}*/
		}
		
		tableManagerService.pageQuery(pageBean);/*
		ActionContext.getContext().getSession().put("dirId", null);*/
		//将返回的list集合转为json对象
		this.java2json(pageBean, new String[] {"orders","orderTime","dinnerTables"});
		return NONE;
	}
	
	public String findAll() {
		List<DinnerTable> list = tableManagerService.findAll();
		this.java2json(list, new String[] {"orders","dinnerTables"});
		return NONE;
	}
	

	public String findNoSeat() {
		List<DinnerTable> list = tableManagerService.findNoSeat();
		this.java2json(list, new String[] {"orders","dinnerTables"});
		return NONE;
	}
	
	public String saveTableId() throws IOException {
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();  
        session.put("savetableId", model.getId());
        
        session.put(model.getId(), oid);
        /*ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(model.getId());*/
		return NONE;
	}
	
	public String add() throws IOException {
			String f = "1";
			try {
			
				 DinnerTable table = tableManagerService.findById(model.getId());
					table.setOrderTime(new Timestamp(System.currentTimeMillis()));
					//2入座未点菜
					table.setTableStatus(tableStatusService.findById(2));;
					tableManagerService.update(table);
				 
				 //创建一个新单
				 ServletActionContext.getRequest().getSession().setAttribute("orderDetailList", new ArrayList<OrderDetail>());
			}catch(Exception e){
				e.printStackTrace();
				f="-1";
			}
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().print(f);
			
			return NONE;
	}
	
	
	public String cleanTable() throws IOException {
		String f = "1";
		try {
		
			DinnerTable table = tableManagerService.findById(model.getId());
			table.setOrders(null);
				table.setOrderTime(null);
				table.setTableStatus(tableStatusService.findById(1));;
				tableManagerService.update(table);
		}catch(Exception e){
			e.printStackTrace();
			f="-1";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}



	
		
}
