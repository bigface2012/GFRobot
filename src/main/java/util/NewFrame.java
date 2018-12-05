package util;

import act.A02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame extends JFrame {

    public final void  NewFrame() {
        final NewFrame frame = new NewFrame();
        frame.setLayout(null);
        frame.setTitle("luanma");
        frame.setSize(400, 170);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加按钮
        JButton btn1 = new JButton("0-2");
        JButton btn2 = new JButton("5-6");
        btn1.setBounds(80, 70, 60, 25);
        btn2.setBounds(240, 70, 60, 25);
        btn1.setVisible(true);
        btn2.setVisible(true);
        frame.add(btn1);
        frame.add(btn2);
        frame.setVisible(true);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    A02.doA02(frame);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void addInfo(final String string) {
        final JFrame f = new JFrame("提示");
        f.setLayout(null);
        f.setBounds(40, 40, 300, 100);
        f.setVisible(true);
        final JLabel label = new JLabel(string);
        label.setBounds(30, 20, 250, 20);
        final Font f1 = new Font("宋体", Font.BOLD, 12);
        label.setFont(f1);
        f.add(label);

    }

}
