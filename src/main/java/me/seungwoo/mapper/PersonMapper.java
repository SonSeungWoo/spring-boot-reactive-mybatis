package me.seungwoo.mapper;

import me.seungwoo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface PersonMapper {

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
