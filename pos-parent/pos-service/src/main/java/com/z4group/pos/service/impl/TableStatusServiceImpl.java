package com.z4group.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.ITableStatusDao;
import com.z4group.pos.domain.TableStatus;
import com.z4group.pos.service.ITableStatusService;

@Service
@Transactional
public class TableStatusServiceImpl implements ITableStatusService{
	@Autowired
	private ITableStatusDao tableStatusDao;
	
	@Override
	public TableStatus findById(Integer i) {
		// TODO Auto-generated method stub
		return tableStatusDao.findById(i);
	}

	@Override
	public List<TableStatus> findAll() {
		// TODO Auto-generated method stub
		return tableStatusDao.findAll();
	}

}
