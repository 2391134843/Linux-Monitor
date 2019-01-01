package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionListenerDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame("CPU性能工具");//创建一个带标题的窗口对象frame
        frame.setVisible(true);//显示窗口
        frame.setSize(1500, 850);//设置窗口大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(3);//点击X关闭程序  3为结束程序
        frame.setLayout(null);//清空布局


        JTextArea jTextArea = new JTextArea();
        //文本框：
//        TextField textField = new TextField();
        jTextArea.setBounds(20, 20, 600, 450);
//        textField.setBackground(Color.red);
        MyActionListener myActionListener = new MyActionListener(jTextArea);//创建一个按钮监听事件对象
        MyActionListener2 myActionListener2 = new MyActionListener2(jTextArea);//第二个按钮的监听事件
        MyActionListener3 myActionListener3 = new MyActionListener3(jTextArea);//第二个按钮的监听事件
        MyActionListener_Monitor myActionListener_monitor = new MyActionListener_Monitor(jTextArea);//监听第四个按钮
        frame.add(jTextArea);
        /**
         * Button1 显示CPU的性能参数 1
         */
        Button button = new Button("CPUInfo");
        button.setBounds(50,700,100,60);
//      button.setBackground(Color.orange);
        //添加颜色，属性不然在Linux中界面有些问题
        button .setFont(new  java.awt.Font("华文行楷",  1,  15));
        /**
         * 此处不能用蓝色红色等等...文本框会显示不出来,测试多次，只有绿色才可以正常显示text文本框
         */
        // button.setBackground(Color.red);
        //button.setBackground(Color.blue);
        button.addActionListener(myActionListener);//添加myActionListener监听事件
        frame.add(button);

        /**
         * Button2  利用 vm 显示CPU的性能 2
         */
        Button button2 = new Button("CPUInfo2");
        button2.setBounds(200,700,100,60);
        button2.setFont(new  java.awt.Font("华文行楷",  1,  15));
        button2.addActionListener(myActionListener2);//添加myActionListener监听事件
        frame.add(button2);

        /**
         * Button3 实现一键优化CPU性能
         */
        Button button3 = new Button("CPU-Opt");
        button3.setBounds(350,700,100,60);
        button3.setFont(new  java.awt.Font("华文行楷",  1,  15));
        button3.addActionListener(myActionListener3);//添加myActionListener监听事件
        frame.add(button3);

        /**
         * Button4 实现打开温度频率等CPU信息的监控
         */
        Button button4 = new Button("CPU-Monitor");
        button4.setBounds(500,700,100,60);
        button4.setFont(new  java.awt.Font("华文行楷",  1,  15));
        button4.addActionListener(myActionListener_monitor);//添加myActionListener监听事件
        frame.add(button4);
    }

}
