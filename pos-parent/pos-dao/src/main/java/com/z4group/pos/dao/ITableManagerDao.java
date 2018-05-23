package com.z4group.pos.dao;

import java.util.List;

import com.z4group.pos.dao.base.IBaseDao;
import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.utils.PageBean;

public interface ITableManagerDao extends IBaseDao<DinnerTable>{

	void openTable(String id);

	List<DinnerTable> findNoSeat();

	void cleanTable(String id);


}
