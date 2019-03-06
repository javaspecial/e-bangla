package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuCategoryDAO;
import com.helper.CategoryFunctionImpl;
import com.helper.PosLog;
import com.model.MenuCategory;
import com.resources.Response;

@Repository
@Transactional
public class MenuCategoryDaoImpl extends CategoryFunctionImpl implements MenuCategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean delete(MenuCategory menuCategory) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.delete(menuCategory);
			transaction.commit();
			return true;
		} catch (Exception e) {
			PosLog.error(MenuCategoryDaoImpl.class, e.getMessage());
			transaction.rollback();
			return false;
		}
	}

	@Override
	public boolean update(MenuCategory menuCategory) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.update(menuCategory);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuCategoryDaoImpl.class, e.getMessage());
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean save(MenuCategory menuCategory) throws Exception {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(menuCategory);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuCategoryDaoImpl.class, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<MenuCategory> getAllMenuCategories(Response model, String name) {
		Session currentSession = sessionFactory.openSession();
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
		} catch (Exception e) {
			PosLog.error(MenuCategoryDaoImpl.class, e.getMessage());
		} finally {
			currentSession.close();
		}
		return null;
	}
}
