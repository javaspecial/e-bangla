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
import com.helper.CategoryFunctionImpl;
import com.model.MenuCategory;
import com.resources.Response;

@Repository
@Transactional
public class MenuCategoryDaoImpl extends CategoryFunctionImpl implements MenuCategoryDAO {

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
	public List<MenuCategory> getAllMenuCategories(Response model, String name) {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(MenuCategory.class);
			// if (name != null) {
			// criteria.add(Restrictions.ilike(MenuCategory.MENU_CATEGORY_NAME, name,
			// MatchMode.ANYWHERE));
			// }
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
