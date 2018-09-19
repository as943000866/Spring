package com.lmg.Spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 不推荐使用 JdbcDaoSupport, 而推荐直接使用 JdbcTempale 作为 Dao 类的成员变量
 * @author Administrator
 *
 */
@Repository
public class StudentClassDao extends JdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public StudentClass get(Integer id){
		String sql = "SELECT id,name FROM StudentClass WHERE id = ?";
		
		RowMapper rowMapper = new BeanPropertyRowMapper<>(StudentClass.class);
		StudentClass studentClass = getJdbcTemplate().queryForObject(sql, rowMapper, id);
		return studentClass;
	}
}
