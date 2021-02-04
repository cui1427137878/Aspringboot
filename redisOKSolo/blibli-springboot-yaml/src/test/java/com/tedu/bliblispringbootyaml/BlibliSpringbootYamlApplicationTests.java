package com.tedu.bliblispringbootyaml;

import com.tedu.bliblispringbootyaml.pojo.Dog;
import com.tedu.bliblispringbootyaml.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlibliSpringbootYamlApplicationTests {
@Autowired
Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
