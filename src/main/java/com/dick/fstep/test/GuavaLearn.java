package com.dick.fstep.test;

import com.google.common.base.*;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.List;

public class GuavaLearn {

    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple"); //不可变集合

     static void thingamajig(Collection<String> collection) {
        ImmutableList<String> defensiveCopy = ImmutableList.copyOf(collection);
        defensiveCopy.add("String");
    }
    public static void main(String[] args) {
        //Objects.equal("a","a"); 非常好用的判相等方法,可以用来比较 int 和 Integer之间
        //System.out.println(Objects.equal(new Integer(1), new Integer(1)));

        /*ImmutableSet<String> foobar = ImmutableSet.of("foo", "bar", "baz");
        thingamajig(foobar);*/ //不可变集合copyof copy后的集合也为不可变

        /*
            新的集合类型  multiset
         */
        /*HashMultiset<String> set = HashMultiset.create();
        set.add("aa");
        set.add("22");
        set.add("aa");
        for (String key : set.elementSet()){
            System.out.println(key + "count : " + set.count(key));
        }*/  //可以用于字符计数 set.elementSet 返回不同元素数量   set.size返回数量包括重复元素

          /*
            新的集合  multimap bimap用于map键值对的反转，需要保证键值的唯一性
           */
          /*BiMap<String, Integer> map = HashBiMap.create();
          map.put("1",2);
          System.out.println(map.inverse().get(2));*/

          /*
            连接器
           */
        /*Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
        Joiner.on(",").join(Arrays.asList(1, 5, 7));*/

        /*
            拆分器
         */
      /*  Iterable<String> split = Splitter.on(',').split("1,2,3,4");
        List<String> list = Lists.newArrayList(Splitter.on(',').split("1,2,3,4"));
        for (String k : split){
            System.out.println(k);
        }*/

    }
}
