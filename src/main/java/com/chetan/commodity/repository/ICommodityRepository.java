package com.chetan.commodity.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chetan.commodity.exception.NotFoundException;
import com.chetan.commodity.model.Commodity;

public interface ICommodityRepository {
	List<Map<String,Object>> getAll(Date date) throws NotFoundException;

	List<Map<String,Object>> getOne(Date date, String name,String sort) throws NotFoundException;

}
