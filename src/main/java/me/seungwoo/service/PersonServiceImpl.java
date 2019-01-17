package me.seungwoo.service;

import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonMapper personMapper;

    //함수형 방식
    @Override
    public Mono<Person> findbyId(int id) {
        return null;
    }

    @Override
    public Flux<Person> findAll() {
        return null;
    }

    @Override
    public Mono<Person> save(Person person) {
        return null;
    }

    @Override
    public Mono<Person> modify(Person person) {
        return null;
    }

    @Override
    public Mono<Boolean> personDelete(Person person) {
        return null;
    }

    //기존 방식
    @Override
    public Person select(int id) {
        return personMapper.select(id);
    }

    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }

    @Override
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public Mono<Person> saveTest(Person person) {
        return personMapper.saveTest(person);
    }
}
