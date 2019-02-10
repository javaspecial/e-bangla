package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TicketDao;
import com.model.Ticket;
import com.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDao ticketDao;

	public boolean save(Ticket ticket) throws Exception {
		return ticketDao.save(ticket);
	}

	public boolean saveOrUpdate(Ticket ticket) {
		return ticketDao.saveOrUpdate(ticket);
	}

	@Transactional
	public List<Ticket> list() {
		return ticketDao.list();
	}

	public boolean delete(Ticket ticket) {
		return ticketDao.delete(ticket);
	}

}
