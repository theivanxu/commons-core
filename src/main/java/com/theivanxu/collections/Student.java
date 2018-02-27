package com.theivanxu.collections;

import java.util.Date;

/**
 * Created by xushaonan on 2018/2/7.
 **/
public class Student {

    private long id;
    private String name;
    private String description;
    private String time;
    private Date date;

    public Student(){

    }

    public Student(long id, String name, String description, String time, Date date){
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                '}';
    }
}
