package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import dao.UserDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDAO = (UserDao) context.getBean("userDao");
		User user = (User) context.getBean("user");
		System.out.println(user);
		userDAO.insert(user);
	}
}
