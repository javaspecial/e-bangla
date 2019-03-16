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

import com.dao.MenuGroupDAO;
import com.helper.GroupFunctionImpl;
import com.helper.PosLog;
import com.model.MenuCategory;
import com.model.MenuGroup;
import com.resources.Response;

@Repository
@Transactional
public class MenuGroupDaoImpl extends GroupFunctionImpl implements MenuGroupDAO {
	@Autowired
	SessionFactory session;

	@Override
	public List<MenuGroup> menuCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(MenuGroup menuGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuGroup menuGroup) {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.saveOrUpdate(menuGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean save(MenuGroup menuGroup) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(menuGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public List<MenuGroup> getAllMenuGroups(Response model, MenuCategory category, String name) {
		Session currentSession = session.openSession();
		try {
			Criteria criteria = currentSession.createCriteria(MenuGroup.class);
			if (name != null && !name.equals("undefined")) {
				criteria.add(Restrictions.ilike(MenuGroup.MENU_GROUP_NAME, name, MatchMode.ANYWHERE));
			}
			if (category != null) {
				criteria.add(Restrictions.ilike(MenuGroup.MENU_GROUP_CATEGORY, category.getName(), MatchMode.ANYWHERE));
			}
			criteria.addOrder(Order.asc(MenuGroup.MENU_GROUP_SORT_ORDER));
			rowCount(criteria, model);
			criteria.setFirstResult(model.getCurrentRowIndex());
			criteria.setMaxResults(model.getPageSize());
			List<MenuGroup> list = criteria.list();
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
