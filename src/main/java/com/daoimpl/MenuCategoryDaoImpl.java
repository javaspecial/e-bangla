package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuCategoryDAO;
import com.model.MenuCategory;
import com.resources.Response;

@Repository
@Transactional
public class MenuCategoryDaoImpl implements MenuCategoryDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean delete(MenuCategory menuCategory) {
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuCategory menuCategory) {
		return false;
	}

	@Override
	public boolean save(MenuCategory menuCategory) throws Exception {
		session.getCurrentSession().save(menuCategory);
		return true;
	}

	@Override
	public List<MenuCategory> getAllMenuCategories(Response model, int pageIndex, int pageSizeSelected) {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(MenuCategory.class);
			criteria.addOrder(Order.asc(MenuCategory.MENU_CATEGORY_ID));
			criteria.addOrder(Order.asc(MenuCategory.MENU_CATEGORY_SORT_ORDER));
			criteria.setProjection(Projections.rowCount());
			Number uniqueResult = (Number) criteria.uniqueResult();
			model.setTotalCount(uniqueResult.intValue());
			criteria.setProjection(null);
			criteria.setFirstResult(pageIndex);
			criteria.setMaxResults(pageSizeSelected);
			List<MenuCategory> list = criteria.list();
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} finally {
			currentSession.close();
		}
	}
}
