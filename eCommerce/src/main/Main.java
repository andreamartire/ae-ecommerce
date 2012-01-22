package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;

public class Main {

	public static void main(String[] args) {
		UserDao userDAO = new UserJdbcDao();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		userDAO.insert(user);
	}

}
