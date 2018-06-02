package com.z4group.pos.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IOrderDetailDao;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.service.IOrderDetailService;
import com.z4group.pos.utils.PageBean;

@Service
@Transactional
public class OrderDetailServiceImpl implements IOrderDetailService{
	@Autowired
	private IOrderDetailDao orderDetailDao;
	
	
	@Override
	public void add(OrderDetail model) {
		// TODO Auto-generated method stub
		orderDetailDao.save(model);
	}


	@Override
	public void pageQuery(PageBean pageBean, ArrayList list) {
		orderDetailDao.pageQuery(pageBean,list);
	}


	@Override
	public OrderDetail findById(String itemid) {
		// TODO Auto-generated method stub
		return orderDetailDao.findById(itemid);
	}


	@Override
	public void update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.update(orderDetail);
		
	}


	@Override
	public void deleteById(String itemid) {
		// TODO Auto-generated method stub
		orderDetailDao.deleteById(itemid);
	}
	
}
