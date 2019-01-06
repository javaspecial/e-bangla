package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDao {
	public List<Book> list();

	public boolean delete(Book book);

	public boolean saveOrUpdate(Book book);

	public boolean save(Book book) throws Exception;

	public boolean update(Book book) throws Exception;
}
