package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;

@Entity
public class Person extends PanacheEntity {
    @NotNull
    public String name;
    @NotNull
    public int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
