package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.company.Main.stu_list;

public class Mainwindow extends JFrame implements WindowListener {
    public static int row_size = 100;
    //选项卡
    public static String[][] tableDate;
    public static JTabbedPane TabPane;
    public static JPanel create,delete,read,update;//Tab
    public static JTable jTable;
    public static JScrollPane jScrollPane;
    public static JTextField stuID_create,stuID_delete,stuID_read,stuID_update;
    public static JTextField stuName_create,stuName_delete,stuName_read,stuName_update;
    public static JTextField stuTel_create,stuTel_delete,stuTel_read,stuTel_update;
    public static JTextField stuAcad_create,stuAcad_delete,stuAcad_read,stuAcad_update;
    public static JTextField stuClass_create,stuClass_delete,stuClass_read,stuClass_update;

    public static String[] jtableName={"学号","姓名","电话","学院","班级"};
    public static JButton create_btn, delete_btn,read_btn,update_btn,sure_btn;//每个界面下的确定按钮
    static {
        tableDate=new String[row_size][5];
        Operation.initTableDate();

        jTable = new JTable(tableDate,jtableName);
        jScrollPane = new JScrollPane(jTable);

        create_btn = new JButton("create"); //create_btn.setHorizontalAlignment(SwingConstants.CENTER);
        delete_btn = new JButton("delete"); //delete_btn.setHorizontalAlignment(SwingConstants.CENTER);
        read_btn   = new JButton("search"); //read_btn.setHorizontalAlignment(SwingConstants.CENTER);
        update_btn = new JButton("update"); //update_btn.setHorizontalAlignment(SwingConstants.CENTER);
        sure_btn   = new JButton("点击确定");

        //设置各文本框的长度
        stuID_create   = new JTextField(); stuID_create.setPreferredSize(new Dimension(250, 30));
        stuName_create = new JTextField(); stuName_create.setPreferredSize(new Dimension(250,30));
        stuTel_create  = new JTextField(); stuTel_create.setPreferredSize(new Dimension(250, 30));
        stuAcad_create = new JTextField(); stuAcad_create.setPreferredSize(new Dimension(250,30));
        stuClass_create= new JTextField(); stuClass_create.setPreferredSize(new Dimension(250, 30));


        stuID_delete   = new JTextField(); stuID_delete.setPreferredSize(new Dimension(250, 30));
        stuName_delete = new JTextField(); stuName_delete.setPreferredSize(new Dimension(250,30));
        stuTel_delete  = new JTextField(); stuTel_delete.setPreferredSize(new Dimension(250, 30));
        stuAcad_delete = new JTextField(); stuAcad_delete.setPreferredSize(new Dimension(250,30));
        stuClass_delete= new JTextField(); stuClass_delete.setPreferredSize(new Dimension(250, 30));

        stuID_read     = new JTextField(); stuID_read.setPreferredSize(new Dimension(250, 30));
        stuName_read   = new JTextField(); stuName_read.setPreferredSize(new Dimension(250,30));
        stuTel_read    = new JTextField(); stuTel_read .setPreferredSize(new Dimension(250, 30));
        stuAcad_read   = new JTextField(); stuAcad_read .setPreferredSize(new Dimension(250,30));
        stuClass_read  = new JTextField(); stuClass_read .setPreferredSize(new Dimension(250, 30));

        stuID_update   = new JTextField(); stuID_update.setPreferredSize(new Dimension(250, 30));
        stuName_update = new JTextField(); stuName_update.setPreferredSize(new Dimension(250,30));
        stuTel_update  = new JTextField(); stuTel_update .setPreferredSize(new Dimension(250, 30));
        stuAcad_update = new JTextField(); stuAcad_update .setPreferredSize(new Dimension(250,30));
        stuClass_update= new JTextField(); stuClass_update .setPreferredSize(new Dimension(250, 30));



        //在每一个面板里面加入元素，再把每个面板panel加入到Tab里面__________________________________
        //从上往下为 增删查改
        create = new JPanel(new FlowLayout(FlowLayout.CENTER));
        create.add(new Label(" Student_Id:            "));  create.add(stuID_create);
        create.add(new Label("                                 "));
        create.add(new Label("Student_Name:      "));   create.add(stuName_create);
        create.add(new Label("                                 "));
        create.add(new Label("Student_phone:      "));   create.add(stuTel_create);
        create.add(new Label("                                 "));
        create.add(new Label("Student_academy: "));   create.add(stuAcad_create);
        create.add(new Label("                                 "));
        create.add(new Label("     Student_TheClass:"));  create.add(stuClass_create);
        create.add(new Label("                                      "));
        create.add(create_btn);

        delete = new JPanel(new FlowLayout());
        delete.add(new Label("   Student_Id:   ")); delete.add(stuID_delete);
        delete.add(new Label("input Student id to delete                                         "));
        delete.add(delete_btn);//delete.add(stuName_delete);


        read = new JPanel();
        read.add(new Label("   Student_Id:   "));   read.add(stuID_read);
//        read.add(new Label("Student_Name:"));       read.add(stuName_read);
//        read.add(new Label("Student_phone:    "));  read.add(stuTel_create);
//        read.add(new Label("Student_academy:"));    read.add(stuAcad_create);
//        read.add(new Label("Student_TheClass:"));   read.add(stuClass_create);
        read.add(read_btn);

        update = new JPanel(new FlowLayout(FlowLayout.CENTER));
        update.add(new Label(" Student_Id:            "));  update.add(stuID_update); update.add(sure_btn);
        update.add(new Label("      "));
        update.add(new Label("Student_Name:      "));   update.add(stuName_update);
        update.add(new Label("                                 "));
        update.add(new Label("Student_phone:      "));   update.add(stuTel_update);
        update.add(new Label("                                 "));
        update.add(new Label("Student_academy: "));   update.add(stuAcad_update);
        update.add(new Label("                                 "));
        update.add(new Label("     Student_TheClass:"));  update.add(stuClass_update);
        update.add(new Label("                                      "));
        update.add(update_btn);



        //设置panle 颜色
        Color color = new Color(225, 245, 254);
        create.setBackground( color );
        delete.setBackground( color );
        read.setBackground( color );
        update.setBackground( color );
        //选项卡
        TabPane = new JTabbedPane();
        TabPane.addTab("添加",null,create,"nothing");
        TabPane.addTab("删除",null,delete,"nothing");
        TabPane.addTab("查找",null,read,"nothing");
        TabPane.addTab("修改",null,update,"nothing");
        TabPane.addTab("全班信息",null,jScrollPane,"nothing");
        //________________________________________________________________________________

        //添加按钮监听事件
        create_btn.addActionListener(new MyActionListener());
        delete_btn.addActionListener(new MyActionListener());
        read_btn.addActionListener(new MyActionListener());
        update_btn.addActionListener(new MyActionListener());
        sure_btn.addActionListener(new MyActionListener());
    }
    Mainwindow(){
        super("Student Manager System");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon("src\\image\\logo.jpg");
        setIconImage( Operation.getScaledImg(img,50,50));
        setBackground(new Color(253, 216, 53));
        setBounds(550,300,600,300);
        setVisible(true);
        add(TabPane);
        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "确定退出系统?", "提示",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION)
        {
            if (e.getWindow() == this) {
                this.dispose();
                InputByArrayListToFile.inputFile(stu_list);//程序结束的时候将ArrayList写入 File 保存数据，下次也可以读取
                System.exit(0);
            } else {
                return;
            }
        }
        else if(option == JOptionPane.NO_OPTION){
            if (e.getWindow() == this) {
                return;
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
