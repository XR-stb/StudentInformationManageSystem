package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;


import static com.company.Main.stu_list;
import static com.company.Mainwindow.*;


public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(create_btn)){
            //取文本框内信息 存学生信息
            String id       = stuID_create.getText();
            String name     = stuName_create.getText();
            String phone    = stuTel_create.getText();
            String academic = stuAcad_create.getText();
            String theclass = stuClass_create.getText();
            if(id.equals("") || name.equals("") || phone.equals("") || academic.equals("") || theclass.equals("")){
                JOptionPane.showMessageDialog(read,"输入不完整","提示",JOptionPane.PLAIN_MESSAGE);
                return ;
            }
            if(Operation.isNum(id) && Operation.isNum(phone)){
            }else{
                JOptionPane.showMessageDialog(read,"学号和电话应为数字，请检查输入","警告",2);
                return ;
            }
            stu_list.add(new Student(id,name,phone,academic,theclass));
            Operation.initTableDate();
            ImageIcon img1 = new ImageIcon("src\\image\\logo1.png");
            img1 = Operation.getScaledImage(img1,30,30);
            Operation.initTableDate();
            JOptionPane.showMessageDialog(read,"添加成功","提示",JOptionPane.PLAIN_MESSAGE,img1);

            //然后清空文本框
            stuID_create.setText(""); stuName_create.setText("");stuTel_create.setText("");
            stuAcad_create.setText("");stuClass_create.setText("");
        }else if(e.getSource().equals(delete_btn)){
            //取文本框内信息 删掉学生信息 // 根据id 删除
            //String name = stuName_delete.getText();
            String id   = stuID_delete.getText();
            if(Operation.find(id)){
                if(Operation.remove(id)) {
                    Operation.initTableDate();
                    JOptionPane.showMessageDialog(delete,"删除成功","提示",JOptionPane.PLAIN_MESSAGE);
                    //System.out.println("delete false");
                }
            }else {
                JOptionPane.showMessageDialog(delete,"输入id不存在，请重新检查输入","错误 ",0);
            }
            //然后清空文本框
            stuID_create.setText(""); //stuName_create.setText("");
        }else if(e.getSource().equals(read_btn)){
            //取文本框内信息 查找学生信息
            String id = stuID_read.getText();
            if(Operation.find(id)){
                Student temp = new Student();
                temp = Operation.findsub(id);
                String show = "查询id为:      " + temp.id + "\n对应名字为:  " + temp.name + "\n手机号为:      " + temp.phone
                        + "\n学院为:          " + temp.academy + "\n班级为:          " + temp.TheClass;
                JOptionPane.showMessageDialog(read,show,"查询结果",JOptionPane.PLAIN_MESSAGE);

                //然后清空文本框
                stuID_read.setText("");
            }else{
                JOptionPane.showMessageDialog(update,"输入id不存在，请重新检查输入","错误 ",0);
            }
        }else if(e.getSource().equals(update_btn)){
            String name     = stuName_update.getText();
            String id       = stuID_update.getText();
            String phone    = stuTel_update.getText();
            String academic = stuAcad_update.getText();
            String theclass = stuClass_update.getText();
            if(id.equals("") || name.equals("") || phone.equals("") || academic.equals("") || theclass.equals("")){
                JOptionPane.showMessageDialog(read,"输入不完整","提示",JOptionPane.PLAIN_MESSAGE);
                return ;
            }
            if(Operation.isNum(id) && Operation.isNum(phone)){
            }else{
                JOptionPane.showMessageDialog(read,"学号和电话应为数字，请检查输入","警告",2);
                return ;
            }
            if(Operation.find(id)){
                Operation.update(id,name,phone,academic,theclass);
                Student temp = Operation.findsub(id);
                String show = "\nid: " + id + "\n修改name为: " + temp.name + "\n修改phone为:" + temp.phone
                                       + "\n修改后学院为:" + temp.academy + "\n修改后班级为:" + temp.TheClass;
                Operation.initTableDate();
                JOptionPane.showMessageDialog(update,show,"修改成功",JOptionPane.PLAIN_MESSAGE);

                //清空文本框
                stuID_update.setText("");stuName_update.setText("");stuTel_update.setText("");
                stuAcad_update.setText("");stuClass_update.setText("");
            }else{
                JOptionPane.showMessageDialog(update,"输入id不存在，请检查输入或添加学生","错误 ",0);
            }
        }else if(e.getSource().equals(sure_btn)){
            String id = stuID_update.getText();
            if(Operation.find(id)){
                Student temp = Operation.findsub(id);
                stuName_update.setText(temp.name);
                stuTel_update.setText(temp.phone);
                stuAcad_update.setText(temp.academy);
                stuClass_update.setText(temp.TheClass);
            }else{
                JOptionPane.showMessageDialog(update,"输入id不存在，请检查输入或添加学生","错误 ",0);
            }
        }
    }
}
