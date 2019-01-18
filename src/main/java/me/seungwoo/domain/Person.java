package me.seungwoo.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = -4133391005111212357L;

    private int id;

    private String name;

    private int age;

    private String country;

}
