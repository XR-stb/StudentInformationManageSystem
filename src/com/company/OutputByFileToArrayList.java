package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class OutputByFileToArrayList {
    public static void outputFile(ArrayList<Student> list) throws IOException {
        //System.out.println("test");
        File f = new File("src\\com\\company\\Information.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line;
        try {
            while((line = reader.readLine()) != null){
                if(line.equals("")) return ;
                int i = 0, len = line.length();
                String[] obj = new String[5];
                int index = 0;
                int start = 0, end = 0;

                while(i < len){
                    if(i == len-1){
                        obj[index]= line.substring(start);
                    }
                    if(line.charAt(i) == ','){
                        end = i;
                        obj[index]= line.substring(start,end);
                        start = end+1;
                        index++;
                    }
                    i++;
                }

                list.add(new Student(obj[0],obj[1],obj[2],obj[3],obj[4]));
                //System.out.println(obj[0]+obj[1]+obj[2]+obj[3]+obj[4]);//测试没问题
            }
        }catch (IndexOutOfBoundsException e) {
            return ;//如果越界，说明我的Information 文件内没有信息，那么直接返回，不用读取数据了
        }
    }
}
