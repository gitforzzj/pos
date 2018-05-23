package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.utils.PageBean;

public interface ITableManagerService {

	void pageQuery(PageBean pageBean);

	void openTable(String id);

	List<DinnerTable> findAll();

	DinnerTable findById(String tableid);

	List<DinnerTable> findNoSeat();

	void update(DinnerTable table);

	void cleanTable(String id);

}
