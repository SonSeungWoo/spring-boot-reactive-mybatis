package me.seungwoo.mapper;

import me.seungwoo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface PersonMapper {

    Person select(int id);

    List<Person> selectAll();

    Mono<Void> insert(Person person);

    Mono<Void> update(Person person);

    Mono<Void> delete(Person person);

}
