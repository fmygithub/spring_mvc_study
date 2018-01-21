package com.fmy.utils;

import com.fmy.domain.Student;
import com.fmy.domain.Teacher;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestSnakeyaml {
    public static void main(String[] args) throws Exception {
//        List<Student> students = new ArrayList<>();
//        Student s = new Student();
//        s.setId(110);
//        s.setName("1110");
//
//        Student ss = new Student();
//        ss.setId(1110);
//        ss.setName("1110");
//
//        students.add(s);
//        students.add(ss);
//
//        Teacher teacher = new Teacher(10, "xx");
//        teacher.setId(new Integer(100));
//        teacher.setAge(10);
//        teacher.setName("24342");
//        teacher.setStudents(students);
//        teacher.setSs(ss);
//
//        teacher.setBig(new BigDecimal(122));
//
//        FileWriter fileWriter = new FileWriter("test_teacher_1.yml");
//        Yaml yaml = new Yaml();
//        yaml.dump(teacher, fileWriter);
//        String result = yaml.dump(teacher);
//        System.out.println(result);

        FileReader reader = new FileReader("test_teacher_1.yml");
        Yaml yaml = new Yaml();
        Teacher teacher = yaml.loadAs(reader, Teacher.class);
        System.out.println(teacher.getStudents());
    }
}
