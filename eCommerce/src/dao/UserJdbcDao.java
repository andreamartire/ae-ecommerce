package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
		String id = String.valueOf(this.userMaxIndex() + 1);
		jdbcTemplate.update("insert into user (id,username,password) values (?, ?, ?)",
				new Object[] { id, u.getUsername(), u.getPassword() });
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
	public User findByID(int id) {
		User user = (User) jdbcTemplate.queryForObject("select * from user where id = ?",
				new Object[] { id },
				new UserRowMapper());   
		return user;
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

	@Override
	public int userMaxIndex() {
		int max = jdbcTemplate.queryForInt("select max(id) from user");
		return max;
	}

}
