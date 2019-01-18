package me.seungwoo.service;

import me.seungwoo.domain.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {

    Person select(int id);

    List<Person> selectAll();

    Mono<Void> insert(Person person);

    Mono<Void> update(Person person);

    Mono<Void> delete(Person person);
}
