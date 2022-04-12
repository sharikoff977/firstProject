package com.sharikoff977.firstProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testt {

    static class Grade {
        Grade(String s, int v){
            subject = s;
            value = v;
        }
        String subject;
        int value;
    }

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

            List<Integer> values = map.get(grade.subject);
            if (values == null) {
                values = new ArrayList<>();
                map.put(grade.subject, values);
            }
            values.add(grade.value);

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
    }

        // Mathematics [8, 7]
        // Physics [9, 10]
        // Chemistry [11, 12]
    }