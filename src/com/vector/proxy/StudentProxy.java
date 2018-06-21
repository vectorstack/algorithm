package com.vector.proxy;

/**
 * Created by DCITS-cs on 2018/6/22.
 */
public class StudentProxy implements Person{

    Student student;

    public StudentProxy(Person stu){
        if(stu.getClass() == Student.class){
            student = (Student) stu;
        }
    }

    @Override
    public void giveMoney() {
        student.giveMoney();
    }
}
