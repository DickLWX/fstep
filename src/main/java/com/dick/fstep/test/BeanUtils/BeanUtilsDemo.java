package com.dick.fstep.test.BeanUtils;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;

public class BeanUtilsDemo {



    public static void main(String[] args) {
        People people = new People();
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(people,teacher);


        //这里不会把Integer 的null值转为默认值0  但是转换时要保证people也就是源要是非空的。

        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(people.getClass());
        System.out.println("");
    }




}

class People{

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Teacher{
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
