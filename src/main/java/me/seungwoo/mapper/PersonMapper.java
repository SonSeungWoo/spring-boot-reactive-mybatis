package me.seungwoo.mapper;

import me.seungwoo.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    Person select(int id);

    List<Person> selectAll();

    void insert(Person person);

    void update(Person person);

    void delete(Person person);

}
