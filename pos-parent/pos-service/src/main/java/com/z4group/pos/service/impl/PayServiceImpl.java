package com.z4group.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IPayDao;
import com.z4group.pos.domain.Pay;
import com.z4group.pos.service.IPayService;

@Service
@Transactional
public class PayServiceImpl implements IPayService{

	@Autowired
	private IPayDao payDao;
	
	@Override
	public void save(Pay pay) {
		// TODO Auto-generated method stub
		payDao.save(pay);
	}

}
