package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.User;


public interface UserDao {

	public void insert(User u);
	public void update(User u);
	public void delete(User u);
	public void delete(int id);
	public User findByID(int id); 
	public User findByUsername(String username);
	public List<User> findAll();  
	public int count();
}
