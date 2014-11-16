package com.ksm.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksm.person.dao.PersonDAO;
import com.ksm.person.model.PersonEntity;

@Service
public class PersonManagerImpl implements PersonManager 
{
    @Autowired
    private PersonDAO personDAO;
    @Override
    @Transactional
    public void addPerson(PersonEntity person) {
        personDAO.addPerson(person);
    }
    @Override
    @Transactional
    public List<PersonEntity> getAllPersons() {
        return personDAO.getAllPersons();
    }
    @Override
    @Transactional
    public void editPerson(PersonEntity person) {
        personDAO.editPerson(person);
    }
    @Override
    @Transactional
    public void deletePerson(Integer personId) {
        personDAO.deletePerson(personId);
    }
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @Override
    @Transactional
    public PersonEntity getPerson(Integer personId) {
    	return personDAO.getPerson(personId);
    }
}
