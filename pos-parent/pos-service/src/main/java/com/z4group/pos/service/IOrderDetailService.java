package com.z4group.pos.service;

import java.util.ArrayList;

import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.utils.PageBean;

public interface IOrderDetailService {

	void add(OrderDetail model);

	void pageQuery(PageBean pageBean, ArrayList list);

}
