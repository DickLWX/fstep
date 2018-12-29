package com.dick.fstep.test.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TestDataStream {

    public static void main(String args[]){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //在调用构造方法时，首先会在内存里面创建一个ByteArray字节数组
        DataOutputStream dos = new DataOutputStream(baos);
        //在输出流的外面套上一层数据流，用来处理int，double类型的数
        try{
            dos.writeDouble(Math.random());//把产生的随机数直接写入到字节数组ByteArray中
            dos.writeBoolean(true);//布尔类型的数据在内存中就只占一个字节
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readDouble());//先写进去的就先读出来，调用readDouble()方法读取出写入的随机数
            System.out.println(dis.readBoolean());//后写进去的就后读出来，这里面的读取顺序不能更改位置，否则会打印出不正确的结果
            dos.close();
            bais.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 通过bais这个流往外读取数据的时候，是一个字节一个字节地往外读取的，因此读出来的数据无法判断是字符串还是bool类型的值，因此要在它的外面再套一个流，通过dataInputStream把读出来的数据转换就可以判断了。注意了：读取数据的时候是先写进去的就先读出来，因此读ByteArray字节数组数据的顺序应该是先把占8个字节的double类型的数读出来，然后再读那个只占一个字节的boolean类型的数，因为double类型的数是先写进数组里面的，读的时候也要先读它。这就是所谓的先写的要先读。如果先读Boolean类型的那个数，那么读出来的情况可能就是把double类型数的8个字节里面的一个字节读了出来。
     */
}
