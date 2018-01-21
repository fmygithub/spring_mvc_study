package com.fmy.utils;

import com.fmy.domain.Student;
import com.fmy.domain.Teacher;
import org.ho.yaml.Yaml;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJyaml {
    public static void main(String[] args) throws Exception{

        Teacher teacher = getBean("teacher", Teacher.class);
        System.out.println(teacher);

        System.out.println(teacher.getStudentMap().get("first"));

//            parseToBean();

//        writeFile();
    }

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
        Map<String, T> map = (Map<String, T>) Yaml.load(new File(path));
        return map.get(key);
    }

    private static void parseToBean() throws Exception{
        ClassLoader classLoader = ParseYamlBean.class.getClassLoader();
        String path = classLoader.getResource("factory/teacher_jyaml.yml").getPath();
        Map<String, Teacher> teacherMap = (Map<String, Teacher>) Yaml.load(new File(path));
        Teacher teacher = teacherMap.get("teacher1");
        System.out.println(teacher);
    }

    private static void writeFile() throws Exception{
        Student student = new Student();
        student.setName("xxx");
        student.setId(3424);

        Student student1 = new Student();
        student1.setName("xxx");
        student1.setId(34247676);

        Student student2 = new Student();
        student2.setName("xxfaasdx");
        student2.setId(34247676);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Map<String, Teacher> teacherMap = new HashMap<>();

        Teacher teacher = new Teacher();
        teacher.setBig(new BigDecimal(10));
        teacher.setSs(student);
        teacher.setStudents(students);

        teacherMap.put("xxx", teacher);

        Yaml.dump(teacherMap, new File("test_teacher_3.yml"));
    }
}
