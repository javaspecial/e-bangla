package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TaxDAO;
import com.model.Tax;
import com.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {

	@Autowired
	TaxDAO taxDao;

	@Override
	public boolean save(Tax tax) throws Exception {
		return taxDao.save(tax);
	}

	@Override
	public boolean saveOrUpdate(Tax tax) throws Exception {
		return taxDao.saveOrUpdate(tax);
	}

	@Override
	public boolean delete(Tax tax) throws Exception {
		return taxDao.delete(tax);
	}

}
