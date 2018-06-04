package com.z4group.pos.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.utils.PageBean;

public interface IOrderDetailService {

	void add(OrderDetail model);

	void pageQuery(PageBean pageBean, ArrayList list);

	OrderDetail findById(String itemid);

	void update(OrderDetail orderDetail);

	void deleteById(String itemid);

	List<Object> countSaleNum(Timestamp ts1, Timestamp ts2);

}
