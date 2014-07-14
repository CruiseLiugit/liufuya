package com.seaway.liufuya.mvc.crm.ui.dao;

import java.util.List;

import com.seaway.liufuya.mvc.crm.ui.data.Person;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReference;
import com.seaway.liufuya.mvc.crm.ui.data.QueryMetaData;

public interface PersonManager {

    public List<PersonReference> getPersonReferences(QueryMetaData queryMetaData, String... propertyNames);

    public Person getPerson(int id);

    public Person savePerson(Person person);

}
