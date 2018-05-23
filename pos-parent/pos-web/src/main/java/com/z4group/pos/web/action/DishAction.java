package com.z4group.pos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.z4group.pos.domain.Category;
import com.z4group.pos.domain.Dish;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.service.ICategoryService;
import com.z4group.pos.service.IDishService;
import com.z4group.pos.web.action.base.BaseAction;
/*
 *@Controller表名该类为一个Controller
  @Scope("prototype") 表名该类为是prototype的
 */
@Controller
@Scope("prototype")
public class DishAction extends BaseAction<Dish> {
	//Spring 自动装配  可以自动扫遍对应包中对应的类然后注入
	@Autowired
	private IDishService dishService;
	@Autowired
	private ICategoryService categoryServcie;
	/*
	private String dirId;*/
	
	private File dishFile;
	
	private String dishFileFileName;
	
	


	


	public String getDishFileFileName() {
		return dishFileFileName;
	}


	public void setDishFileFileName(String dishFileFileName) {
		this.dishFileFileName = dishFileFileName;
	}

	public String hasOrderItem() {
		/*DetachedCriteria dc = pageBean.getDetachedCriteria();*/
		ArrayList<OrderDetail> list= (ArrayList<OrderDetail>) ServletActionContext.getRequest()
				.getSession().getAttribute("orderDetailList");
		/*if(list!=null&&!list.equals("")) {*/
			/*ArrayList list = new ArrayList();*/
			/*for (OrderDetail orderDetail: list) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setDishes(entry.getKey().getDishes());
				orderDetail.setNum(entry.getKey().getNum());
				orderDetail.setTaste(entry.getKey().getTaste());
				orderDetail.setTotalprice(entry.getKey().getDishes().getPrice()*entry.getKey().getNum());
				list.add(orderDetail);
			}
*/
			/*pageBean.setRows(list);
			pageBean.setTotal(list.size());*/
			
		/*}*/
		this.java2json(list, new String[] {"itemid","order","user","disheses","category"});
		return NONE;
	}
	

	public String importXls() throws IOException, InvalidFormatException {
		List<Dish> dishList = new ArrayList<Dish>();
		Sheet sheet;
		/*if(dishFileFileName.endsWith(".xls")) {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(dishFile));
			 sheet = workbook.getSheetAt(0);
		}else {*/
			Workbook workbook =  WorkbookFactory.create(dishFile);/*new XSSFWorkbook(new FileInputStream(dishFile));*/
			 sheet = workbook.getSheetAt(0);
		/*}*/
		
		String flag = "0";
		try {
			for(Row row:sheet) {
				int rowNum = row.getRowNum();
				if(rowNum==0) {
					continue;
				}
				
				if(row.getCell(0)==null) {
					continue;
				}
				
				String dishid = row.getCell(0).getStringCellValue();
				String dishname = row.getCell(1).getStringCellValue();
				String unit = row.getCell(2).getStringCellValue();
				Double price = row.getCell(3).getNumericCellValue();
				String categoryId = (int)row.getCell(4).getNumericCellValue()+"";
				Category category = new Category();
				category.setId(categoryId);
				Dish dish = new Dish(dishid, category, dishname, unit, price);
				dishList.add(dish);
			}
		}catch(Exception e){
			 flag = "2";
		}
		
		
        try{
        	dishService.saveBatch(dishList);//批处理保存到数据库中，如果抛异常返回标志字符串回前台，做出相应友好提示
        }catch(Exception e){
        	e.printStackTrace();
            flag = "1";
        }
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
		
	}
	

	/*public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}
*/
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}

	/*public String postDirId() throws IOException {
		if(dirId!=null) {
			ActionContext.getContext().getSession().put("dirId", dirId);
		}
		return "dispatcher";
	}*/
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/*
	 * 分页查询，调用service执行业务方法，并将查到的数据转为json对象
	 */
	public String pageQuery() {/*
		String id = (String) ActionContext.getContext().getSession().get("dirId");*/
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		String dishid = model.getDishid();
		if(StringUtils.isNotBlank(dishid)) {
			dc.add(Restrictions.or(Restrictions.like("dishid", "%"+dishid+"%"),Restrictions.like("dishname", "%"+dishid+"%")));
		}
		
		
		dishService.pageQuery(pageBean);/*
		ActionContext.getContext().getSession().put("dirId", null);*/
		//将返回的list集合转为json对象
		this.java2json(pageBean, new String[] {"category"});
		return NONE;
	}
	

	
	public String saveOrUpdate() throws IOException {
		String f = "1";
		try {
		
			Category category = categoryServcie.findLikeId(categoryName);
			model.setCategory(category);
			dishService.saveOrUpdate(model);
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}
	
	public String delete() throws IOException {
		String f = "1";
		try {
			dishService.deleteById(model.getDishid());
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}
	
	public String findById() {
		String id = (String) ActionContext.getContext().getSession().get("dirId");
		List<Dish> list=dishService.findLikeId(model.getDishid());
		this.java2json(list, new String[] {"category"});
		return NONE;
	}
	
	public String findByCategoryId() {
		List<Dish> list=dishService.findByCategoryId(model.getCategory().getId());
		this.java2json(list, new String[] {"category"});
		return NONE;
	}
	
	public File getDishFile() {
		return dishFile;
	}


	public void setDishFile(File dishFile) {
		this.dishFile = dishFile;
	}
	
}
