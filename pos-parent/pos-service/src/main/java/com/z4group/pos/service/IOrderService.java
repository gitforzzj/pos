package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.DinnerTable;
import com.z4group.pos.domain.Order;

public interface IOrderService {

	void add(Order order);

	void update(Order order);

	Order findById(String oid);

}
