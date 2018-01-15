package com.fmy.utils;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.fmy.domain.Teacher;

import java.io.FileReader;
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
        try {
            Teacher teacher = ParseYamlBean.getBean("teacher1", Teacher.class);
            System.out.println(teacher.getStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
