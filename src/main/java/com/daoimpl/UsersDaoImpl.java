package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UsersDao;
import com.model.User;
import com.resources.AESencryption;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

	@Autowired
	SessionFactory session;

	public boolean saveOrUpdate(User users) {
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	public List<User> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(User users) {
		session.getCurrentSession().delete(users);
		return true;
	}

	public boolean save(User users) throws Exception {
		users.setPassword(AESencryption.getInstance().encrypt(users.getPassword()));
		session.getCurrentSession().save(users);
		return true;
	}

	public boolean validateUser(String username, String password) throws Exception {
		Session curentSession = null;
		try {
			curentSession = session.openSession();
			curentSession.beginTransaction();
			Criteria criteria = curentSession.createCriteria(User.class);
			criteria.add(Restrictions.eq(User.USER_EMAIL, username));
			criteria.add(Restrictions.eq(User.USER_PASSWORD, AESencryption.getInstance().encrypt(password)));
			curentSession.getTransaction();
			List<User> users = criteria.list();
			if (!users.isEmpty()) {
				return true;
			}
		} finally {
			closeSession(curentSession);
		}
		return false;
	}

	public boolean existEmail(String users) {
		Session openSession = null;
		try {
			openSession = session.openSession();
			openSession.beginTransaction();
			Criteria criteria = openSession.createCriteria(User.class);
			criteria.add(Restrictions.eq(User.USER_EMAIL, users));
			openSession.getTransaction();
			List<User> list = criteria.list();
			if (!list.isEmpty()) {
				return true;
			}
		} finally {
			closeSession(openSession);
		}
		return false;
	}

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}