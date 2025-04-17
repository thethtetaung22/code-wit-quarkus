package org.acme.service;

import io.smallrye.common.constraint.NotNull;
import jakarta.ws.rs.WebApplicationException;
import org.acme.domain.Person;
import org.acme.model.PersonModel;

import java.util.List;

public class PersonService {

    public static List<Person> getPersons() {
        return Person.findAll().list();
    }

    public static Person getPersonById(Long id) {
        return Person.findById(id);
    }

    public static Person createPerson(@NotNull PersonModel model) {
        Person person = new Person(model.name, model.age);
        person.persist();
        return person;
    }

    public static Person updatePerson(Long id, @NotNull PersonModel model) {
        Person person = Person.findById(id);

        if (person == null) {
            throw new WebApplicationException("Person with this id does not exist!", 404);
        }
        person.name = model.name;
        person.age = model.age;
        person.persist();
        return person;
    }

    public static String deletePersonById(Long id) {
        Person person = Person.findById(id);

        if (person == null) {
            throw new WebApplicationException("Person with this id does not exist!", 404);
        }

        person.delete();
        return "Person with this ID deleted successful!";
    }
}
