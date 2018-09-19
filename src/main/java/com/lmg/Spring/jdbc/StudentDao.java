package com.lmg.Spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Student get(Integer id){
		String sql = "SELECT id, stu_name name, age FROM t_student WHERE id = ?";
		
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Student.class);
		
		Student student = (Student) jdbcTemplate.queryForObject(sql, rowMapper,id);
		return student;
	}
}
