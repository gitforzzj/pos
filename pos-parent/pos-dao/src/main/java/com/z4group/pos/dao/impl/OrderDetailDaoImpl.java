package com.z4group.pos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.z4group.pos.dao.IOrderDetailDao;
import com.z4group.pos.dao.base.impl.BaseDaoImpl;
import com.z4group.pos.domain.OrderDetail;
import com.z4group.pos.utils.PageBean;
@Repository
public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail> implements IOrderDetailDao{

	@Override
	public void pageQuery(PageBean pageBean, ArrayList list) {
		// TODO Auto-generated method stub
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachCriteria = pageBean.getDetachedCriteria();
		detachCriteria.setProjection(Projections.rowCount());
		
		Long count = (Long) list.get(0);
		pageBean.setTotal(count.intValue());
		
		detachCriteria.setProjection(null);
		detachCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		int firstResult = (currentPage-1)*pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachCriteria,firstResult,maxResults);
		pageBean.setRows(list);
	}

}
