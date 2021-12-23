package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import static com.company.Main.stu_list;
import static com.company.Mainwindow.tableDate;

public class Operation {
    public static boolean isNum(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray ()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void update(String id,String name, String phone, String academy, String TheClass){
        for(int i = 0; i < stu_list.size(); i++){
            if(stu_list.get(i).id.equals(id)){
                stu_list.get(i).name = name;        stu_list.get(i).phone = phone;
                stu_list.get(i).academy = academy;  stu_list.get(i).TheClass = TheClass;
                break;
            }
        }
    }
    public static boolean find(String id){
        for(int i = 0; i < stu_list.size(); i++){
            if(stu_list.get(i).id.equals(id)){
                return true;
            }
        }
        return false;
    }
    public static Student findsub(String id){
        for(int i = 0; i < stu_list.size(); i++){
            if(stu_list.get(i).id.equals(id)){
                return stu_list.get(i);
            }
        }
        return null;
    }
    public static boolean remove(String id) {
        for (int i = 0; i < stu_list.size(); i++) {
            if (stu_list.get(i).id.equals(id)) {
                stu_list.remove(stu_list.get(i));
                //System.out.println(stu_list.size());
                return true;
            }
        }
        return false;
    }
    public static  ImageIcon getScaledImage(ImageIcon img, int w, int h){
        Image srcImg = img.getImage(); // transform it
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        ImageIcon imageIcon = new ImageIcon(resizedImg);  // transform it back
        return imageIcon;
    }
    public static  Image getScaledImg(ImageIcon img, int w, int h){
        Image srcImg = img.getImage(); // transform it
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        //ImageIcon imageIcon = new ImageIcon(resizedImg);  // transform it back
        return resizedImg;
    }
    public static void initTableDate(){
        int row = stu_list.size();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < 5; j++) {
                switch (j){
                    case 0:{
                        tableDate[i][j] = stu_list.get(i).id;
                        break;
                    }
                    case 1:{
                        tableDate[i][j] = stu_list.get(i).name;
                        break;
                    }
                    case 2:{
                        tableDate[i][j] = stu_list.get(i).phone;
                        break;
                    }
                    case 3:{
                        tableDate[i][j] = stu_list.get(i).academy;
                        break;
                    }
                    case 4:{
                        tableDate[i][j] = stu_list.get(i).TheClass;
                        break;
                    }
                }
            }
        }
    }
}
