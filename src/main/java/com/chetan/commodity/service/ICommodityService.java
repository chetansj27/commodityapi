package com.chetan.commodity.service;

import java.util.List;
import java.util.Map;

import com.chetan.commodity.exception.NotFoundException;

public interface ICommodityService {

	List<Map<String,Object>> getAll(String date)throws NotFoundException;

	List<Map<String,Object>> getOne(String date, String name,String sort) throws NotFoundException;

}
