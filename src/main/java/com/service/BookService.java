package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	public List<Book> list();

	public boolean delete(Book book);

	public boolean saveOrUpdate(Book book);

	public boolean update(Book book) throws Exception;

	public boolean save(Book book) throws Exception;
}
