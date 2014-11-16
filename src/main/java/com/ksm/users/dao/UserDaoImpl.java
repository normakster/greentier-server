package com.ksm.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksm.users.model.User;
import com.ksm.util.CustomHibernateDaoSupport;

@Repository
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
//		getHibernateTemplate()
		getCurrentSession().save(user);
	}

	public void update(User user) {
//		getHibernateTemplate()
		getCurrentSession().update(user);
	}

	public void delete(User user) {
//		getHibernateTemplate()
		getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = 
				getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();
//				getHibernateTemplate().find("from User where username=?",username);

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}