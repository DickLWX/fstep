package com.dick.fstep.test.collectiondemo;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

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

    public static void main(String[] args) {
        demo1();
    }
}
