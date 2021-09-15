package com.chetan.commodity.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chetan.commodity.exception.NotFoundException;

@Repository
public class CommodityRepository implements ICommodityRepository {
	private static final String SQL_FIND_ALL = "SELECT * FROM COMMODITY WHERE MONTH >= ?";
	private String SQL_FIND_ONE = "SELECT Month, ? FROM COMMODITY WHERE month >= ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getAll(Date date) throws NotFoundException {
		try {
			List<Map<String, Object>> res = jdbcTemplate.queryForList(SQL_FIND_ALL, date);
			return res;
		} catch (Exception e) {
			throw new NotFoundException("Data not found");
		}

	}

	@Override
	public List<Map<String, Object>> getOne(Date date, String name, String sort) throws NotFoundException {
		String tempSql = SQL_FIND_ONE;
		tempSql = tempSql.replaceFirst("\\?", name);
		if (sort != null)
			tempSql += " order by " + name + " " + sort;
		try {
			List<Map<String, Object>> res = jdbcTemplate.queryForList(tempSql, date);
			return res;
		} catch (Exception e) {
			throw new NotFoundException("Data not found");
		}

	}

}
