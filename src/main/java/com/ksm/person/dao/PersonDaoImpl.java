package com.ksm.person.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksm.person.model.PersonEntity;

@Repository
public class PersonDaoImpl implements PersonDAO {
	
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(PersonEntity person) {
        getCurrentSession().save(person);
    }
    
    @Override
    public void editPerson(PersonEntity person) {
        getCurrentSession().update(person);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<PersonEntity> getAllPersons() {
    	
    	//TODO Refine and adapt
//    	List<PersonEntity> persons = new ArrayList<PersonEntity>();
//		persons = getCurrentSession().createQuery("from PersonEntity").list();
//		if (persons.size() > 0) {
//			return persons;
//		} else {
//			return null;
//		}
		
		return getCurrentSession().createQuery("from PersonEntity").list();
    }

    
    @SuppressWarnings("unchecked")
    @Override
    public PersonEntity getPerson(Integer personId) {
    	List<PersonEntity> persons = new ArrayList<PersonEntity>();
		persons = getCurrentSession().createQuery("from PersonEntity where id=?").setParameter(0, personId).list();
		if (persons.size() > 0) {
			return persons.get(0);
		} else {
			return null;
		}
    }
    
    @Override
    public void deletePerson(Integer personId) {
        PersonEntity person = (PersonEntity) sessionFactory.getCurrentSession().load(
                PersonEntity.class, personId);
        if (null != person) {
            getCurrentSession().delete(person);
        }
    }
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}