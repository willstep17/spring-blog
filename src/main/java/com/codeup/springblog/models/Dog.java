package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @Column(columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT")
    private int id;

    @Column(columnDefinition = "tinyint(3) unsigned NOT NULL")
    private byte age;

    @Column(columnDefinition = "varchar(200) NOT NULL")
    private String name;

    @Column(columnDefinition = "char(2) default 'XX'", unique = true)
    private char reside_state;

    public Dog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getReside_state() {
        return reside_state;
    }

    public void setReside_state(char reside_state) {
        this.reside_state = reside_state;
    }
}