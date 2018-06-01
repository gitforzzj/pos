package com.z4group.pos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.TableStatus;
import com.z4group.pos.service.ITableStatusService;
import com.z4group.pos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class TableStatusAction extends BaseAction<TableStatus> {
	
	@Autowired 
	private ITableStatusService tableStatusService;
	
	public String findAll() {
		List<TableStatus> list = tableStatusService.findAll();
		this.java2json(list, new String[] {"dinnerTables"});
		return NONE;
	}
	
}
