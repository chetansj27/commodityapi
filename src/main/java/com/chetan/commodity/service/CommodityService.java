package com.chetan.commodity.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.commodity.exception.NotFoundException;
import com.chetan.commodity.model.Commodity;
import com.chetan.commodity.repository.CommodityRepository;

@Service
public class CommodityService implements ICommodityService {

	@Autowired
	CommodityRepository commodityRepository;

	@Override
	public List<Map<String, Object>> getAll(String date) throws NotFoundException {
		if (date == null)
			date = "1960-01-01";

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		String startDate = "1960-01-01";
		String endDate = "2021-08-01";

		if ((startDate.compareTo(date) > 0 || endDate.compareTo(date) < 0))
			throw new NotFoundException("Date is not correct");

		try {

			date1 = fmt.parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block

		}
		// TODO Auto-generated method stub
		return commodityRepository.getAll(date1);
	}

	@Override
	public List<Map<String, Object>> getOne(String date, String name, String sort) throws NotFoundException {
		if (date == null)
			date = "1960-01-01";
		if (name == null)
			throw new NotFoundException("Name is not entered");
		if(sort!=null && !(sort.equals("asc")||sort.equals("desc")))
			throw new NotFoundException("Sorting is wrong");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		String startDate = "1960-01-01";
		String endDate = "2021-08-01";
		if ((startDate.compareTo(date) > 0 || endDate.compareTo(date) < 0))
			throw new NotFoundException("Date is not correct");

		try {

			date1 = fmt.parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block

		}

		return commodityRepository.getOne(date1, name,sort);
	}
}
