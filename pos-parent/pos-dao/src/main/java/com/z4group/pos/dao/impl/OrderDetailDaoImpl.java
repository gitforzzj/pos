package com.z4group.pos.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

	@Override
	public List<Object> countSaleNum(Timestamp ts1, Timestamp ts2) { 
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "SELECT r.dishname, count(*),count(num) FROM OrderDetail o  LEFT OUTER JOIN o.dishes r LEFT OUTER JOIN o.order ord  "
				+ " where ord.ordertime between ? and ? GROUP BY r.dishname";
	    Query query = session.createQuery(hql);   
		query.setFirstResult(0);
		query.setMaxResults(10);
		query.setTimestamp(0, ts1);
		query.setTimestamp(1, ts2);
		return (List<Object>) query.list();
	}

}

