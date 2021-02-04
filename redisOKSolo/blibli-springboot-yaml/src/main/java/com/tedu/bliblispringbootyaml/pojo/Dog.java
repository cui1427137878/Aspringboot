package com.tedu.bliblispringbootyaml.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:Dog
 * Package:com.tedu.bliblispringbootyaml.pojo
 * Description:
 *
 * @Data:2020/11/9 11:32
 * Author:崔建新
 */
@Component
public class Dog {

    private String name;

    private String age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Dog() {
    }

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
