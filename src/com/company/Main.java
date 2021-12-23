package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.company.Mainwindow;
public class Main {
    public static ArrayList<Student> stu_list;
    static {
        stu_list = new ArrayList<Student>();//构造函数 new 不及时
    }
    Main(){
        new Login();
        //new Mainwindow();//
    }
    public static void main(String[] args) throws IOException {
        //ArrayList<Student> stu_list = new ArrayList<Student>();

        OutputByFileToArrayList.outputFile(stu_list);//每次启动将文件中的数据存入ArrayList

        ///测试区————————————测试区
//        Iterator<Student> it = stu_list.iterator();
//        while(it.hasNext()){
//            Student temp = it.next();
//            System.out.println(temp.name + "  " + temp.id);//没问题
//        }

        new Main();

        //已经改成窗口关闭监听，防止重复写入， 因为java的生命周期真的琢磨不透 ┭┮﹏┭┮
        //InputByArrayListToFile.inputFile(stu_list);//程序结束的时候将ArrayList写入 File 保存数据，下次也可以读取
    }

}
