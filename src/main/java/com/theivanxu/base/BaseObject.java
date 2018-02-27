package com.theivanxu.base;

import com.sun.istack.internal.NotNull;

/**
 * Created by xushaonan on 2018/1/18.
 **/
public class BaseObject {

    private String name;
    private String description;
    private Integer age;

    public BaseObject() {

    }

    public BaseObject(String name, String description, Integer age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public void say(@NotNull String speech) {
        System.out.println(speech);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
