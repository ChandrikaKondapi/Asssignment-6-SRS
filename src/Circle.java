import javax.swing.*;
import java.awt.*;

public class Circle {

    public static void main (String[] args){
        JFrame window=new JFrame("Circles");
        CirclePanel panel=new CirclePanel();
        window.setContentPane(panel);
        panel.addMouseListener(new CircleClick(panel));
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
        JLabel label =new JLabel("Welcome");
        label.setForeground(Color.black);
        //label.add(panel, BorderLayout.CENTER);
        panel.add(label);
        JButton button=new JButton("RUN");
        //button.setBounds(1000, 10000, 100, 100);
        panel.add(button);
        JButton button2=new JButton("Save");
        panel.setVisible(true);
        panel.add(button2);
        JButton button3=new JButton("Load");
        panel.add(button3);
        JButton button4=new JButton("Clear");
        panel.add(button4);
        JButton button5=new JButton("Random dots");
        panel.add(button5);
    }
}

