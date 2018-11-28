package com.dick.fstep.test;

public class StringTest {
    public static void main(String[] args) {
       // test1();
       // test2();
        //test3();
        //test4();
        //test5();
       // test6();
       // test7();
      //  test8();
    }

    public static void test1(){
        String two = new String("test");
        String one = "test";
        System.out.println(System.identityHashCode(two.intern()));
        System.out.println(System.identityHashCode(one));
        System.out.println(System.identityHashCode(two));
    }

    public static void test2(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s.intern()));
    }
    public static void test3(){ //所有的 intern都一样，和直接定义的string也一样
        String s = new String("test");
        String s1 = new String("test");
        String s2 = "test";
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s.intern()));
        System.out.println(System.identityHashCode(s1.intern()));
    }
    public static void test4(){
        String s = new String("1") + new String("1");
        System.out.println(System.identityHashCode(s));
        s.intern();
        String s1 = "11";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s.intern()));
    }
    //对于加的特殊情况现暂时理解为  当字符串相加是，没有将相加的值存在字符串常量池中，执行intern后，会直接把堆中的地址放到字符串常量池中
    //而对于直接New 的，在New的同时 ，将堆和字符串常量池中都有，但是不一样，字符串常量池应该是保存堆中地址。
    public static void test5(){
        String s = new String("1") + new String("1");
        System.out.println(System.identityHashCode(s));
        String s1 = "11";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s.intern()));
    }
    public static void test6(){
        String s =  new String("11");
        System.out.println(System.identityHashCode(s));
        s.intern();
        String s1 = "11";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s.intern()));
    }
    public static void test7(){
        String s = "1" + "1";
        System.out.println(System.identityHashCode(s));
        String s1 = "11";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s.intern()));
    }

    public static void test8(){
        String s = "test";
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s.intern()));
    }
    /*
    对于这个问题终于有一个很好的理解了，
    String s1= new String("Hello");
    这句执行完，堆上有两个String对象。第一个是.class文件里的字面量"Hello"对应的，被驻留到字符串常量池里，比如地址0xfff。
    第二个是new出来的，被赋值给变量s1，比如地址0xeee。
    如果执行 String s2 = s1.intern(); 那s2被赋于字符串常量池里的那个引用0xfff。所以s1 != s2
    这个问题 test8返回true说明，当没有new对象时，这两个是相等的。

    对于字面量加载进入常量池的时机问题：
    class NewTest1{
    public static String s1="static";  // 第一句
    public static void main(String[] args) {
        String s1=new String("he")+new String("llo"); //第二句
        s1.intern();   //将 堆中新建的对象"hello" 存入字符串常量池
        String s2="hello";  //第三句
        System.out.println(s1==s2);//输出是true。
    }
}
就HotSpot VM的实现来说，加载类的时候，那些字符串字面量会进入到当前类的运行时常量池，不会进入全局的字符串常量池（即在StringTable中并没有相应的引用，在堆中也没有对应的对象产生）
ldc字节码在这里的执行语义是：到当前类的运行时常量池（runtime constant pool，HotSpot VM里是ConstantPool + ConstantPoolCache）去查找该index对应的项，如果该项尚未resolve则resolve之，并返回resolve后的内容。
在遇到String类型常量时，resolve的过程如果发现StringTable已经有了内容匹配的java.lang.String的引用，则直接返回这个引用，反之，如果StringTable里尚未有内容匹配的String实例的引用，则会在Java堆里创建一个对应内容的String对象，然后在StringTable记录下这个引用，并返回这个引用出去。
可见，ldc指令是否需要创建新的String实例，全看在第一次执行这一条ldc指令时，StringTable是否已经记录了一个对应内容的String的引用。

"static" "he" "llo" "hello"都会进入Class的常量池， 按照上面说的，类加载阶段由于resolve 阶段是lazy的，
所以是不会创建实例，更不会驻留字符串常量池了。但是要注意这个“static”和其他三个不一样，它是静态的，在类加载阶段中的初始化阶段，会为静态变量指定初始值，也就是要把“static”赋值给s1（main方法里面怎么还有个s1，这里说的是外面那个静态的），
这个赋值操作要怎么搞啊，先ldc指令把它放到栈顶，然后用putstatic指令完成赋值。注意，ldc指令，根据上面说的，会创建"static"字符串对象，并且会保存一个指向它的引用到字符串常量池。
额，我好像把第一句已经说了。运行main方法后，首先是第二句，一样的，要先用ldc把"he"和"llo"送到栈顶，换句话说，会创建他俩的对象，并且会保存引用到字符串常量池中；
然后有个＋号对吧，内部是创建了一个StringBuilder对象，一路append，最后调用StringBuilder对象的toString方法得到一个String对象（内容是hello，注意这个toString方法会new一个String对象），并把它赋值给s1。
注意啊，没有把hello的引用放入字符串常量池。然后是第三句，intern方法一看，字符串常量池里面没有，它会把上面的这个hello对象的引用保存到字符串常量池，然后返回这个引用，但是这个返回值我们并没有使用变量去接收，
所以没用。第四句，字符串常量池里面已经有了，直接用嘛第五句，已经很明显了。
参考资料   https://www.zhihu.com/question/55994121
           https://www.zhihu.com/question/29884421

     */
}
