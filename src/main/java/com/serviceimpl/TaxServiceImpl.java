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

}
