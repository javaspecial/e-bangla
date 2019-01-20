package com.service;

import java.util.List;

import com.model.User;

public interface UsersService {
	public List<User> list();

	public boolean delete(User users);

	public boolean saveOrUpdate(User users);

	public boolean save(User users) throws Exception;

	public boolean validateUser(String username, String password) throws Exception;

	public boolean existEmail(String string);

}