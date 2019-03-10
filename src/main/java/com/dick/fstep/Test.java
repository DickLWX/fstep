package com.dick.fstep;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*SimpleDateFormat dateformat = new SimpleDateFormat( "yyyy年MM月dd日 HH点mm分ss秒");
        dateformat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        String time = dateformat.format(date);
        System.out.println(time);*/

        String str = "abc";
        char[] cha = {'a','b','c'};
        swap(str, cha);
        System.out.println(str);
        System.out.println(cha);
    }

    public static void swap(String str, char[] cha){
        str = "aaa";
        cha[0] = 'b';
    }

    public static void Test1(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 0;
        for ( int i = 1 ; i <= num; i++){
            result += i*i;
        }
        System.out.println(result);
    }

    public static void Test2(){
        String[] str = {"a","b","c","d","e","f","g","h"};
        for (int i = 0; i < str.length; i++){
            for (int k = i + 1; k < str.length; k++){
                System.out.println(str[i] + str[k]);
            }
        }
    }

    public static void Test3(int a[], int len){
        int sum;
        int here;
        sum = here = a[0];
        for (int i = 1; i < len; i++){
            if (here <= 0){
                here = a[i];
            }
            else {
                here += a[i];
            }
            if (here > sum){
                sum = here;
            }
        }
        System.out.println(sum);
    }

    public static void Test4(int list[], int len, int d){
        //sort(list)
        int begin = 0;

        for (int i = len - 1; i == 0; i--) {
                if (i < begin)
                    break;
                long sub = list[i] - list[i];

                if (sub == d) {
                    System.out.println(list[begin] + " " + list[i]);
                } else {
                    if (sub < d)
                        break;
                    else
                        begin++;
                }
        }

    }

 /*   public static ArrayList<List<Integer>> binaryTreePaths(TreeNode root){
        ArrayList<List<Integer>> result = new ArrayList<String>();
        if (root == null)
            return result;
        List<Integer> path = new ArrayList<>();
        Paths(root, result, path);
        return result;
    }

    public void Paths(TreeNode root, ArrayList<Integer> result, List<Integer> path){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            path.add(root.value);
            result.add(path);
            return;
        }
        else
            path.add(root.value);
        Paths(root.left,result,path);
        Paths(root.right,result,path);
    }*/
}
