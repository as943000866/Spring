package com.lmg.Spring.jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private StudentDao studentDao = null;
	private StudentClassDao studentClassDao = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("beans-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		studentDao = (StudentDao) ctx.getBean("studentDao");
		studentClassDao = (StudentClassDao) ctx.getBean("studentClassDao");
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	/**
	 * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
	 * 1. SQL 语句中的参数名与类的属性一致!
	 * 2. 使用 SqlParmeterSource 的 BeanPropertySqlParameterSource 实现类作为参数.
	 * @throws Exception
	 */
	@Test
	public void testNamedParameterJdbcTemplate2() throws Exception{
		String sql = "INSERT INTO t_student(stu_name,age) VALUES(:name,:age)";
		Student student = new Student("xyz", 10);
		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(student);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	/**
	 * 可以为参数起名字.
	 * 1.好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
	 * 2.缺点: 较为麻烦.
	 * 
	 */
	@Test
	public void testNamedParameterJdbcTemplate() throws Exception{
		String sql = "INSERT INTO t_student(stu_name,age) VALUES(:name,:age)";
		Map<String, Object> paramMap = new  HashMap<String, Object>();
		paramMap.put("name", "xxx");
		paramMap.put("age", 20);
		namedParameterJdbcTemplate.update(sql, paramMap);
		
	}
	
	@Test
	public void testStudentClassDao() throws Exception{
		System.out.println(studentClassDao.get(1));
	}
	
	@Test
	public void testStudentDao() throws Exception{
		System.out.println(studentDao.get(1));
	}
	
	@Test
	public void testJdbc() throws Exception{
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		System.out.println(connection);
	}
	
	/**
	 * 获取单个列的值, 或做统计查询
	 * 使用 queryForObject(String sql, Class<T> requiredType)
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) From t_student";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		
		System.out.println(count);
	}
	/**
	 * 查询实体类的集合
	 * 注意不是调用 queryForList 的方法
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, stu_name name, age FROM t_student WHERE id > ?";
		
		
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
		
		List<Student> students = jdbcTemplate.query(sql, rowMapper, 2);
		System.out.println(students);
	}
	/**
	 * 从数据库中获取一条记录, 实际得到对应的一个对象
	 * 注意不是调用  queryForObject(String sql, Class<T> requiredType, Object... args) 方法!
	 * 而需要调用 queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
	 * 2. 使用 SQL 中列的别名完成列名和类名属性的映射. 列入 stu_name name
	 * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id,stu_name name, age FROM t_student WHERE id = ?";
		
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Student.class);
		
		Student student = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		
		System.out.println(student);
		System.out.println("--------------");
	}
	/**
	 * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
	 * 最后一个参数是  Object[] 的 List 类型: 因为修改一条记录需要一个 Object 的数组, 那么多条不就需要多个 Object 的数组吗
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
		
		List<Object[]> batchArgs = new ArrayList<>();
		
		batchArgs.add(new Object[]{"AA",11});
		batchArgs.add(new Object[]{"BB",12});
		batchArgs.add(new Object[]{"CC",13});
		batchArgs.add(new Object[]{"DD",14});
		batchArgs.add(new Object[]{"EE",15});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	/**
	 * 执行 INSERT, UPDATE, DELETE
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE t_student SET name = ? where id = ?";
		jdbcTemplate.update(sql, "Tom",1);
		
	}
}
