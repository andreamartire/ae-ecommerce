package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pojo.User;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(User u) {
		if (jdbcTemplate == null)
			System.out.println("Non inizializzato");
		jdbcTemplate.update("insert into user (id,username,password) values (?, ?, ?)",
				new Object[] { u.getId(), u.getUsername(), u.getPassword() });
		System.out.println("Insert a user");
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

	@Override
	public User findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = (List<User>) jdbcTemplate.query("select * from user", new UserRowMapper());
		return users;
	}

	@Override
	public int userCount() {
		int rowCount = jdbcTemplate.queryForInt("select count(*) from user");
		return rowCount;
	}

}
