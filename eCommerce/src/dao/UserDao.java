package dao;

import java.util.List;

import pojo.User;

public interface UserDao {

	public void insert(User u);
	public void update(User u);
	public void delete(int id);
	public User findByID(int id); 
	public List<User> findAllUsers();  
	public int userCount();
}
