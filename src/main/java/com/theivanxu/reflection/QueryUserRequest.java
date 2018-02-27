package com.theivanxu.reflection;


import com.theivanxu.annotation.NotNull;

/**
 * Created by xushaonan on 2018/1/10.
 **/
public class QueryUserRequest extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    private Boolean gender;

    public QueryUserRequest() {

    }

    public QueryUserRequest(String name, Integer age, Boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String receiveInfo(@NotNull String topic){
        return topic + ":" + name + ":" + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
