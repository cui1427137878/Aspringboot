package com.tedu.bliblispringbootyaml.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName:Person
 * Package:com.tedu.bliblispringbootyaml.pojo
 * Description:
 *
 * @Data:2020/11/9 11:34
 * Author:崔建新
 */
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String name;
    private String age;
    private Date date;
    private Map<String,Object> maps;
    private Dog dog;
    private List<Object> list;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", date=" + date +
                ", maps=" + maps +
                ", dog=" + dog +
                ", list=" + list +
                '}';
    }
}
