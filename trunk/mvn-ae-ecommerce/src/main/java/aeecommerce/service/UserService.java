package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.User;


public interface UserService {

	public void insert(User u);
	public void update(User u);
	public void delete(int id);
	public User findByUsername(String username); 
}
