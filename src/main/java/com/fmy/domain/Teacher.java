package com.fmy.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private List<Student> students;

    private Student ss;

    private BigDecimal big;

    private Map<String, Student> studentMap;

    public Teacher() {

    }

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public BigDecimal getBig() {
        return big;
    }

    public void setBig(BigDecimal big) {
        this.big = big;
    }

    public Student getSs() {
        return ss;
    }

    public void setSs(Student ss) {
        this.ss = ss;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}
