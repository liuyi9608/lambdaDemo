package com.liuym.entity;

/**
 * @author LiuYiMing
 * @date 2018/10/18 14:52
 * @describe：
 */
public class Person {
    private String userName;
    private String job;
    private String sex;
    private int age;
    private int salary;

    public Person(String userName, String job, String sex, int age, int salary) {
        this.userName = userName;
        this.job = job;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
