package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuCategoryDAO;
import com.helper.CategoryFunctionImpl;
import com.model.MenuCategory;
import com.resources.Response;

@Repository
@Transactional
public class MenuCategoryDaoImpl extends CategoryFunctionImpl implements MenuCategoryDAO {
	private static final Logger LOGGER = Logger.getLogger(MenuCategoryDaoImpl.class.getName());
	@Autowired
	SessionFactory session;

	@Override
	public boolean delete(MenuCategory menuCategory) {
		return false;
	}

	@Override
	public boolean update(MenuCategory menuCategory) {
		Session currentSession = session.openSession();
		try {
			session.getCurrentSession().update(menuCategory);
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Exception occur:", e);
			return false;
		} finally {
			currentSession.close();
		}
	}

	@Override
	public boolean save(MenuCategory menuCategory) throws Exception {
		Session currentSession = session.openSession();
		try {
			session.getCurrentSession().save(menuCategory);
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Exception occur:", e);
			return false;
		} finally {
			currentSession.close();
		}

	}

	@Override
	public List<MenuCategory> getAllMenuCategories(Response model, String name) {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(MenuCategory.class);
			if (!name.equals("undefined")) {
				criteria.add(Restrictions.ilike(MenuCategory.MENU_CATEGORY_NAME, name, MatchMode.ANYWHERE));
			}
			criteria.addOrder(Order.asc(MenuCategory.MENU_CATEGORY_ID));
			criteria.addOrder(Order.asc(MenuCategory.MENU_CATEGORY_SORT_ORDER));
			rowCount(criteria, model);
			criteria.setFirstResult(model.getCurrentRowIndex());
			criteria.setMaxResults(model.getPageSize());
			List<MenuCategory> list = criteria.list();
			model.setRows(list);
			updatePagination(model);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} finally {
			currentSession.close();
		}
	}
}
