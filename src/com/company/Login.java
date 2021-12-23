package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    public static JTextField username;
    public static JPasswordField password;
    public static Button cancel;
    public static Button login;

    static {
        username = new JTextField();
        username.setPreferredSize(new Dimension(300, 30));
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(300, 30));

        login = new Button("login");
        cancel  = new Button("cancel");
    }

    Login(){
        setVisible(true);
        setBounds(600,300,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());//窗口布局
        //setBackground(new Color(90, 36, 162));

        //添加组件
        add(new JLabel("         user:")); add(username);
        add(new JLabel("password:")); add(password);
        add(login);  add(cancel);

        login.addActionListener(this);
        cancel.addActionListener(this);

        ImageIcon img = new ImageIcon("src\\image\\login.png");
        setIconImage( Operation.getScaledImg(img,30,30));
        //setBackground(new Color(90, 36, 162));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果单击【退出】按钮则程序退出
        if (e.getSource().equals(cancel)) {
            System.exit(0);
        }
        // 如果单击【登录】按钮则检查用户名和密码是否匹配
        else if (e.getSource().equals(login)) {
            // 如果用户名和密码匹配，则打开具体操作面板
            if (username.getText().equals("admin") && String.valueOf(password.getPassword()).equals("123")) {
                this.setVisible(false);
                new Mainwindow();
            }
            // 如果用户名和密码不匹配，则弹出提示对话框
            else {
                JOptionPane.showOptionDialog(this, "用户名或密码错误", "登陆失败",
                        JOptionPane.CLOSED_OPTION,
                        JOptionPane.ERROR_MESSAGE, null, null, null);
            }
        }
    }
}
