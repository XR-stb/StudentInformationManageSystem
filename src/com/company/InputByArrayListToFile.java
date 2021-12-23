package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class InputByArrayListToFile {
    //public static String fileName = "src\\com\\company\\Information.txt";
    public static void inputFile(ArrayList<Student> list){
        String fileName = "src\\com\\company\\Information.txt";
        Iterator<Student> it = list.iterator();
        //System.out.println("list size = " + list.size());
        String inFile = new String();
        while(it.hasNext()){
            Student temp = it.next();
            String s = new String(temp.id+","+temp.name+","+temp.phone+","+temp.academy+","+temp.TheClass);
            inFile += s + "\n";
            //append(fileName,s);
            //System.out.println(s);
        }
        append(fileName,inFile);
        //System.out.println("写入成功！");
    }
    public static void append(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件,如果为 true，则将字节写入文件末尾处，而不是写入文件开始
            //这里我们选择全部重写，因为我们之前全存在Arraylsit里面了，所以数据应该更新（比如删掉的数据）
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
