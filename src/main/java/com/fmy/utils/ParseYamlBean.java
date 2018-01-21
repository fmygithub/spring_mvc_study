package com.fmy.utils;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fmy.domain.Student;
import com.fmy.domain.Teacher;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseYamlBean {

    // 获取bean对象
    public static <T> T getBean(String key, Class clazz) throws Exception{
        // 获取配置文件地址
        String className = clazz.getSimpleName();
        StringBuilder fileName = new StringBuilder("factory/");
        fileName.append(className.substring(0, 1).toLowerCase());
        fileName.append(className.substring(1, className.length()));
        fileName.append(".yml");

        ClassLoader classLoader = ParseYamlBean.class.getClassLoader();
        String path = classLoader.getResource(fileName.toString()).getPath();
        YamlReader yamlReader = new YamlReader(new FileReader(path));
        Map<String, T> map = yamlReader.read(Map.class);
        return map.get(key);
    }

    public static void main(String[] args) {
//        try {
//            Teacher teacher = ParseYamlBean.getBean("teacher1", Teacher.class);
//            System.out.println(teacher.getStudents());
//            List<Student> students = new ArrayList<>();
//            Student s = new Student();
//            s.setId(110);
//            s.setName("1110");
//
//            Student ss = new Student();
//            ss.setId(1110);
//            ss.setName("1110");
//
//            students.add(s);
//            students.add(ss);
//
//            Teacher teacher = new Teacher(10, "xx");
//            teacher.setId(new Integer(100));
//            teacher.setAge(10);
//            teacher.setName("24342");
//            teacher.setStudents(students);
//            teacher.setSs(ss);
//
//            teacher.setBig(new BigDecimal(122));
//
////            ClassLoader classLoader = ParseYamlBean.class.getClassLoader();
////            String path = classLoader.getResource(fileName.toString()).getPath();
//            FileWriter fileWriter = new FileWriter("test_teacher.yml");
//            YamlWriter writer = new YamlWriter(fileWriter);
//            writer.write(teacher);
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }
}
