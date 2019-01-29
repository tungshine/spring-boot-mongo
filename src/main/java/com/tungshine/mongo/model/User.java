package com.tungshine.mongo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: TungShine
 * @Description:
 * @Date: Create in 1:10 2018/7/19
 * @Modified By:
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5754518979671349912L;

    private Integer id;
    private String name;
    private int age;

    public User() {

    }

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", name=" + this.name + ", age=" + age + "]";
    }
}
