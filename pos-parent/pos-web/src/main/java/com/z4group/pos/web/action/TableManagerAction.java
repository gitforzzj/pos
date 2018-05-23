package com.z4group.pos.web.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.Category;
import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.Dish;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.service.ITableManagerService;
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
	
	/*
	 * 分页查询，调用service执行业务方法，并将查到的数据转为json对象
	 */
	public String pageQuery() {/*
		String id = (String) ActionContext.getContext().getSession().get("dirId");*/
		/*DetachedCriteria dc = pageBean.getDetachedCriteria();
		String dishid = model.getDishid();
		if(StringUtils.isNotBlank(dishid)) {
			dc.add(Restrictions.or(Restrictions.like("dishid", "%"+dishid+"%"),Restrictions.like("dishname", "%"+dishid+"%")));
		}
		*/
		
		tableManagerService.pageQuery(pageBean);/*
		ActionContext.getContext().getSession().put("dirId", null);*/
		//将返回的list集合转为json对象
		this.java2json(pageBean, new String[] {"orders","orderTime"});
		return NONE;
	}
	
	public String findAll() {
		List<DinnerTable> list = tableManagerService.findAll();
		this.java2json(list, new String[] {"orders"});
		return NONE;
	}
	
	public String findNoSeat() {
		List<DinnerTable> list = tableManagerService.findNoSeat();
		this.java2json(list, new String[] {"orders"});
		return NONE;
	}
	
	public String add() throws IOException {
			String f = "1";
			try {
			
				 tableManagerService.openTable(model.getId());
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
		
			 tableManagerService.cleanTable(model.getId());
		}catch(Exception e){
			e.printStackTrace();
			f="-1";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}

	
		
}
