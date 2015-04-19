package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Curstom;

public class TestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String GET_CURSTOM_BY_ID = "SELECT * FROM curstom WHERE curstom_id = ?";
	private static String GET_ALL_CURSTOMS = "SELECT * FROM curstom";
	
	
	public List<Curstom> getAllCurstoms()
	{
		return jdbcTemplate.query(GET_ALL_CURSTOMS,new RowMapper<Curstom>(){
			@Override
			public Curstom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Curstom cs = new Curstom();
				rs.getInt("curstom_id");
				cs.setName(rs.getString("name"));
				cs.setSex(rs.getString("sex"));
				cs.setAge(rs.getInt("age"));
				return cs;
			}});
	}
	
	public Curstom getCurstomById(int curstomId)
	{
		
		return jdbcTemplate.queryForObject(GET_CURSTOM_BY_ID, new RowMapper<Curstom>(){

			@Override
			public Curstom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Curstom cs = new Curstom();
				rs.getInt("curstom_id");
				cs.setName(rs.getString("name"));
				cs.setSex(rs.getString("sex"));
				cs.setAge(rs.getInt("age"));
				return cs;
			}}, curstomId);
	}
	
}
