package com.dick.fstep.test.collectiondemo;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListDemo {

    public static void demo1(){
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++){
            list.add(Convert.toStr(i));
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("");
    }

    public static void demo2(){
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);

        stringList.set(0,"oneList");

        System.out.println(stringArray[0]);

        // 3个方法都会报错 asList这里返回的对象是Arrays中的内部类，这个内部类只有set方法，而且数组是由final修饰,不可变
        /*stringList.add("four");
        stringList.remove(2);
        stringList.clear();*/

        // 在这种情况下是要
        List<String> stringList1 = new java.util.ArrayList<>(Arrays.asList(stringArray));
        stringList1.add("four");
        stringList1.remove(2);
        stringList1.clear();
    }

    public static void demo3(){
        List<String> list = Lists.newArrayList("1","2","3");
        String[] array = new String[2];
        list.toArray(array);
        String[] array2 = new String[3];
        array2 = list.toArray(array);  //数组长度不够会放弃当前数组  另外返回一个新的数组
        System.out.println(Arrays.asList(array));
        System.out.println(Arrays.asList(array2));
    }

    public static void main(String[] args) {
        //demo1();
       // demo2();
        demo3();
    }
}
