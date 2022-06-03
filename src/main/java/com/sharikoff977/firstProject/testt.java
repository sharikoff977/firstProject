package com.sharikoff977.firstProject;

import nonapi.io.github.classgraph.json.JSONUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grade {

    private String subject;
    private int value;

    Grade(String s, int v){
        subject = s;
        value = v;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class testt {



    public static void main(String[] args) {
        Grade[] grades = new Grade[]{
                new Grade("Mathematics", 8),
                new Grade("Mathematics", 7),
                new Grade("Physics", 9),
                new Grade("Chemistry", 11),
                new Grade("Physics", 10),
                new Grade("Chemistry", 12)
        };
        //List<Integer> values = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for(Grade grade : grades) {

            List<Integer> values = map.get(grade.getSubject());
            if (values == null) {
                values = new ArrayList<>();
                map.put(grade.getSubject(), values);
            }
            values.add(grade.getValue());

//            if (map.containsKey(grade.subject)){
//                map.get(grade.subject).add(grade.value);
//            }
//            else{
//                List<Integer> list = new ArrayList<>();
//                list.add(grade.value);
//                map.put(grade.subject, list);
//            }
        }
        System.out.println(map);

        Grade grade = new Grade("test", 12);
        System.out.println(grade.getSubject() + " " + grade.getValue());
        Class<?> aClass = grade.getClass();
        try{
            Field field = aClass.getDeclaredField("value");
            field.setAccessible(true);
            field.set(grade, (int) 10);
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        System.out.println(grade.getSubject() + " " + grade.getValue());

        Grade grade1 = null;
        try{
            Class clazz = Class.forName(Grade.class.getName());
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors){
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes){
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            Class[] params = {String.class, int.class};
            grade1 = (Grade) clazz.getDeclaredConstructor(params).newInstance("abc", 9);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(grade1.getSubject() + " " + grade1.getValue());
    }

        // Mathematics [8, 7]
        // Physics [9, 10]
        // Chemistry [11, 12]
    }