package org.acme.service;

import io.smallrye.common.constraint.NotNull;
import org.acme.domain.Person;
import org.acme.model.PersonModel;

import java.util.List;

public class PersonService {

    public static List<Person> getPersons() {
        return Person.findAll().list();
    }

    public static Person createPerson(@NotNull PersonModel model) {
        Person person = new Person(model.name, model.age);
        person.persist();
        return person;
    }
}
