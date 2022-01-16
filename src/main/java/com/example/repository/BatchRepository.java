package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.entity.SpendingEntity;

@Repository
public class BatchRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
public void insertCsv(SpendingEntity spendingEntity) {
	
	String spending=spendingEntity.getSpending();
	String memo=spendingEntity.getMemo();
	
	String sql
	="insert into spending (spending,memo) values (:spending,:memo) ";
	
	System.out.println("repo spend :"+spendingEntity.getSpending());
	System.out.println("repo memo :"+spendingEntity.getMemo());
	
	SqlParameterSource param
	=new MapSqlParameterSource()
	.addValue("spending", spending)
	.addValue("memo", memo);
	
	template.update(sql, param);
	
}
}
