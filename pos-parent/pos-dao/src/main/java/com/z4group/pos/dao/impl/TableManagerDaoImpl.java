package com.z4group.pos.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.z4group.pos.dao.ITableManagerDao;
import com.z4group.pos.dao.base.impl.BaseDaoImpl;
import com.z4group.pos.domain.DinnerTable;
@Repository
public class TableManagerDaoImpl  extends BaseDaoImpl<DinnerTable> implements ITableManagerDao {

	@Override
	public void openTable(String id) {
		DinnerTable table = findById(id);
		table.setOrderTime(new Timestamp(System.currentTimeMillis()));
		table.setTableStatus(1);
		update(table);
	}
	
	@Override
	public void cleanTable(String id) {
		DinnerTable table = findById(id);
		table.setOrderTime(null);
		table.setTableStatus(0);
		table.setOrders(null);
		update(table);
	}


	@Override
	public List<DinnerTable> findNoSeat() {
			String hql = "from DinnerTable where tableStatus!=0";
			return  (List<DinnerTable>) this.getHibernateTemplate().find(hql);
	}

}
