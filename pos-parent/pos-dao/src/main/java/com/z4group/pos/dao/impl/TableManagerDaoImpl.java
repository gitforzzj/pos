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
	public List<DinnerTable> findNoSeat() {
			String hql = "from DinnerTable where tableStatus!=0";
			return  (List<DinnerTable>) this.getHibernateTemplate().find(hql);
	}

}
