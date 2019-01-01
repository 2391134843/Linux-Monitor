package gui;

import utils.UtilsClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    public  static JTextArea textField;
    int count;

    public MyActionListener(JTextArea textField) {
        super();
        this.textField = textField;
    }

    ////每按一次按钮，此方法都会自动调用一次

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        count++;
//        textField.setText("你点击了按钮  "+ count + " 次");
//        textField.setText(UtilsClass.useLinuxCommond());   可注释掉
        UtilsClass.useLinuxCommond();
        System.out.println("你点击了按钮  "+ count + " 次");
    }

}
