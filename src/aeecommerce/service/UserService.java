package aeecommerce.service;

import aeecommerce.pojo.User;


public interface UserService {

	public void insert(User u);
	public void update(User u);
	public void delete(int id);
	public User findByUsername(String username);
	public User findById(int id);
	public boolean isPrivato(String username);
	public boolean isAzienda(String username);
}
