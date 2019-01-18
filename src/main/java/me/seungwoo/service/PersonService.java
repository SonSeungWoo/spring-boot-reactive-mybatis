package me.seungwoo.service;

import me.seungwoo.domain.Person;

import java.util.List;

public interface PersonService {

    Person select(int id);

    List<Person> selectAll();

    void insert(Person person);

    void update(Person person);

    void delete(Person person);
}
