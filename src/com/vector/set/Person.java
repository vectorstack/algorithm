package com.vector.set;

/**
 * Created by 12345 on 2018-6-14.
 */
public class Person implements Comparable{

    private int age;
    private String name;

    public Person(){

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person)o;
        if(this.age > person.age){
            return 1;
        }

        if(this.age < person.age){
            return -1;
        }
        return this.name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
