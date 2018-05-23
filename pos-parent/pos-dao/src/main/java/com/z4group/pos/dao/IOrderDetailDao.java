package com.z4group.pos.dao;

import java.util.ArrayList;

import com.z4group.pos.dao.base.IBaseDao;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.utils.PageBean;

public interface IOrderDetailDao extends IBaseDao<OrderDetail>{

	void pageQuery(PageBean pageBean, ArrayList list);

}
