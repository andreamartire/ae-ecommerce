package dao;

import pojo.User;

public interface UserDAO {
	
	public void saveUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);

}
