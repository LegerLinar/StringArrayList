package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringArrayList stringList = new StringArrayList("Test");

        stringList.add("test1");
        stringList.add(1, "test3");
//        System.out.println(stringList.size());
        stringList.set(0, "test1");
//        System.out.println(stringList.indexOf("test3"));
//        stringList.remove(1);
        System.out.println(stringList.isEmpty());
        String[] newArray = stringList.toArray();
        System.out.println(Arrays.toString(newArray));
        for(int i = 0; i < stringList.size(); i++){
            System.out.println(stringList.get(i));
        }
    }
}