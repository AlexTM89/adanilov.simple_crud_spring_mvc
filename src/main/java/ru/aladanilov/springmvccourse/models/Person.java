package ru.aladanilov.springmvccourse.models;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "name cannot be null")
    @Size(min = 1, max = 30, message = "Name cannot be less than 1 char and more than 30 chars")
    private String name;

    @Min(value = 0, message = "age cannot be less than zero")
    @Max(value = 100, message = "age cannot be more then 100 years")
    private int age;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email format is incorrect!")
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {}

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
