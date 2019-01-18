package me.seungwoo.service;

import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

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
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    public void update(Person person) {
        personMapper.update(person);
    }

    @Override
    public void delete(Person person) {
        personMapper.delete(person);
    }

}
