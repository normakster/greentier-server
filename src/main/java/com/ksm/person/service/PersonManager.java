package com.ksm.person.service;

import java.util.List;

import com.ksm.person.model.PersonEntity;

public interface PersonManager {
    public void addPerson(PersonEntity person);
	public void editPerson(PersonEntity person);
    public void deletePerson(Integer personId);
    public List<PersonEntity> getAllPersons();
    public PersonEntity getPerson(Integer personId);
}
