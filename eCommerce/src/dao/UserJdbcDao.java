package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pojo.User;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(User u) {
		jdbcTemplate.update("insert into user (id,username,password) values (?, ?, ?)",
				new Object[] { u.getId(), u.getUsername(), u.getPassword() });
	}

	@Override
	public void update(User u) {
		jdbcTemplate.update("update user set username = ?, password = ? where id = ?",
				new Object[] { u.getUsername(), u.getPassword(), u.getId() });
	}

	@Override
	public void delete(User u) {
		jdbcTemplate.update("delete from user where id = ?", new Object[] { u.getId() });
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByID(int id) {
		return jdbcTemplate.queryForObject("select * from user where id = ?",
				new Object[] { id }, new UserRowMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		return (List<User>) jdbcTemplate.query("select * from user", new UserRowMapper());
	}

	@Override
	public int userCount() {
		return findAllUsers().size();
	}
}
