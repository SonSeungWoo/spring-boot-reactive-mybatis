package me.seungwoo.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("person")
public class Person {

    private int id;

    private String name;

    private int age;

    private String country;

}
