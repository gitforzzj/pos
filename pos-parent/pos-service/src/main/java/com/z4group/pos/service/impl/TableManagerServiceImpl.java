package com.z4group.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IDishDao;
import com.z4group.pos.dao.ITableManagerDao;
import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.service.ITableManagerService;
import com.z4group.pos.utils.PageBean;

@Service
@Transactional
public class TableManagerServiceImpl implements ITableManagerService{
	@Autowired
	private ITableManagerDao tableManagerDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		tableManagerDao.pageQuery(pageBean);
	}

	

	@Override
	public List<DinnerTable> findAll() {
		// TODO Auto-generated method stub
		return tableManagerDao.findAll();
	}

	@Override
	public DinnerTable findById(String tableid) {
		return tableManagerDao.findById(tableid);
	}

	@Override
	public List<DinnerTable> findNoSeat() {
		// TODO Auto-generated method stub
		return tableManagerDao.findNoSeat();
	}

	@Override
	public void update(DinnerTable table) {
		// TODO Auto-generated method stub
		tableManagerDao.update(table);
	}

}