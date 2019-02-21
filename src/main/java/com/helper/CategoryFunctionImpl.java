package com.helper;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import com.resources.Response;

public class CategoryFunctionImpl {
	public void updatePagination(Response model) {
		int startNumber = model.getCurrentRowIndex() + 1;
		int endNumber = model.getNextPage();
		int totalNumber = model.getNumRows();
		if (endNumber > totalNumber) {
			endNumber = totalNumber;
		}
		if (totalNumber < startNumber) {
			startNumber = 1;
		}
		model.setStartNumber(startNumber);
		model.setEndNumber(endNumber);
		model.setTotalNumber(totalNumber);
		model.setHasNext((model.getCurrentRowIndex() + model.getPageSize()) < model.getNumRows());
		model.setHasPrevious(model.getCurrentRowIndex() > 0);
	}

	public Criteria rowCount(Criteria criteria, Response model) {
		criteria.setProjection(Projections.rowCount());
		Number uniqueResult = (Number) criteria.uniqueResult();
		model.setNumRows(uniqueResult.intValue());
		criteria.setProjection(null);
		return criteria;
	}
}
