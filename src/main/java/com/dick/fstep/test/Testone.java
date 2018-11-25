package com.dick.fstep.test;



//默认无参构造，当父类没有无参构造，子类必须调用父类的有参构造才能不报错
public class Testone {
    public Testone(int i){
        System.out.println(i);
    }
}
class TestTwo extends Testone{
    public TestTwo(){
        super(1);
    }
}
