package com.dao;

import com.model.Tax;

public interface TaxDAO {

	public boolean delete(Tax tax);

	public boolean saveOrUpdate(Tax tax);

	public boolean save(Tax tax) throws Exception;
}