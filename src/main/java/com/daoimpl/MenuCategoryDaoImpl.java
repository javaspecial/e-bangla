package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuCategoryDAO;
import com.model.MenuCategory;

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
	public List<MenuCategory> getAllMenuCategories(int pageIndex, int pageSizeSelected) {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(MenuCategory.class);
			criteria.addOrder(Order.asc(MenuCategory.MENU_CATEGORY_SORT_ORDER));
			criteria.setFirstResult(pageIndex);
			criteria.setMaxResults(pageSizeSelected);
			List<MenuCategory> list = criteria.list();
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}
	}
}
