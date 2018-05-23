package com.z4group.pos.dao.impl;

import org.springframework.stereotype.Repository;

import com.z4group.pos.dao.IOrderDao;
import com.z4group.pos.dao.base.impl.BaseDaoImpl;
import com.z4group.pos.domain.Order;

@Repository
public class OrderDaoImpl  extends BaseDaoImpl<Order> implements IOrderDao{

}
