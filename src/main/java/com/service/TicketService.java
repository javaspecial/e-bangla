package com.service;

import java.util.List;

import com.model.Ticket;

public interface TicketService {
	public List<Ticket> list();

	public boolean delete(Ticket ticket);

	public boolean saveOrUpdate(Ticket ticket);

	public boolean save(Ticket ticket) throws Exception;

}
