package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TicketDao;
import com.model.Ticket;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {
	@Autowired
	SessionFactory session;

	public boolean saveOrUpdate(Ticket ticket) {
		session.getCurrentSession().saveOrUpdate(ticket);
		return true;
	}

	public List<Ticket> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Ticket ticket) {
		session.getCurrentSession().delete(ticket);
		return true;
	}

	public boolean save(Ticket ticket) throws Exception {
		session.getCurrentSession().save(ticket);
		return true;
	}
}
