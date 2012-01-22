package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import dao.UserDAO;
import dao.UserHibernateDAO;

public class Main {

	public static void main(String[] args) {
		UserDAO userDAO = new UserHibernateDAO();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		userDAO.insert(user);
	}

}
