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

    @Override
    public Person select(int id) {
        return personMapper.select(id);
    }

    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }

    @Override
    public Mono<Void> insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Mono<Void> update(Person person) {
        return personMapper.update(person);
    }

    @Override
    public Mono<Void> delete(Person person) {
        return personMapper.delete(person);
    }

}
