package com.z4group.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IOrderDao;
import com.z4group.pos.domain.Order;
import com.z4group.pos.service.IOrderService;

@Service
@Transactional
public class OrderServiceImpl  implements IOrderService{
	@Autowired
	private IOrderDao orderDao;
	
	
	@Override
	public void add(Order model) {
		// TODO Auto-generated method stub
		orderDao.save(model);
	}


	@Override
	public void update(Order order) {
		orderDao.update(order);
		
	}


	@Override
	public Order findById(String oid) {
		// TODO Auto-generated method stub
		return orderDao.findById(oid);
	}
}
