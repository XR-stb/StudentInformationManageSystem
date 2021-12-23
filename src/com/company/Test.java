package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Test extends JPanel {
    Test(){
        super(new GridLayout(1,1));
        JTabbedPane tabbedPane=new JTabbedPane();
        ImageIcon icon=createImageIcon("tab.jp1g");
        JComponent panel1=makeTextPanel("计算机名");
        tabbedPane.addTab("增",icon, panel1,"Does nothing");
        tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);
        JComponent panel2=makeTextPanel("硬件");
        tabbedPane.addTab("删",icon,panel2,"Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        JComponent panel3=makeTextPanel("高级");
        tabbedPane.addTab("查",icon,panel3,"Still does nothing");
        tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);
        JComponent panel4=makeTextPanel("123451");
        panel4.setPreferredSize(new Dimension(410,50));
        tabbedPane.addTab("改",icon,panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3,KeyEvent.VK_4);
        add(tabbedPane);
    }
    protected JComponent makeTextPanel(String text)
    {
        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }
    protected static ImageIcon createImageIcon(String path)
    {
        java.net.URL imgURL=Test.class.getResource(path);
        if(imgURL!=null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("Couldn't find file: "+path);
            return null;
        }
    }


    public static void main(String[] args) {
        ArrayList<A> list = new ArrayList<>();
        //fun(list);
        //list.remove(list.get(0));
        String s = new String("456");
        fun(s);
        System.out.println(s);
    }
    public static void fun(String s){
        s = "123";
    }
//        list.add(new A("a","aa"));
//        list.add(new A("b","bb"));
//    }
    static class A{
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A person = (A) o;

            if (!id.equals(person.id)) return false;
            return true;
        }
        public A(String name,String id) {
            this.name = name;
            this.id  = id;
        }

        public A() {
        }

        String name;
        String id;
    }
}
