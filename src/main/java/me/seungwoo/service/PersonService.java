package me.seungwoo.service;

import me.seungwoo.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {

    Mono<Person> findbyId(int id);

    Flux<Person> findAll();

    Mono<Person> save(Person person);

    Mono<Person> modify(Person person);

    Mono<Boolean> personDelete(Person person);

    Person select(int id);

    List<Person> selectAll();

    void insert(Person person);

    void update(Person person);

    void delete(Person person);

    Mono<Person> saveTest(Person person);
}
