package com.example.database_helper.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "PERSON")
public class Person {

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "SEX")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
