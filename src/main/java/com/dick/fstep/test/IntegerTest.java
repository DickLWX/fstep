package com.dick.fstep.test;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        Integer c = 1000;
        Integer d = 1000;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a == 10);
        System.out.println(c == 10000);
        System.out.println(a.equals(10));
        System.out.println(c.equals(1000));

        /*
        Integer 在-128-127有缓存区间，在调用valueof方法时，如果在该区间下，则返回一个一存在的缓存地址，此时不用New Integer对象
        对于Integer等包装类的==，必须要用equal方法，大坑 ！！！！！！
         */
    }

}
