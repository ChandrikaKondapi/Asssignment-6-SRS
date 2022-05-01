

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Main {

  public static void main(String[] args) {

    GUI test = new GUI();
    test.init();

  }
}

class GUI extends JFrame implements ActionListener {
  JFrame window = new JFrame("Circles");
  public void init() {
    JFrame window = new JFrame("Circles");
    CirclePanel panel = new CirclePanel();
    window.setContentPane(panel);
    panel.addMouseListener(new CircleClick(panel));
    window.setSize(500, 500);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    JLabel label = new JLabel("Welcome");
    label.setForeground(Color.black);
    //label.add(panel, BorderLayout.CENTER);
    panel.add(label);

    JButton button = new JButton("RUN");
    //button.setBounds(1000, 10000, 100, 100);
    panel.add(button);
    JButton button2 = new JButton("Save");
    panel.setVisible(true);
    panel.add(button2);
    button2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        panel.save();
      }
    });
    JButton button3 = new JButton("Load");
    panel.add(button3);
    button3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        panel.load();
      }
    });
    JButton button4 = new JButton("Clear");
    panel.add(button4);
    button4.addActionListener(this);
    // button4. getContentPane(). invalidate();
    JButton button5 = new JButton("Random dots");
    panel.add(button5);
    button5.addActionListener(this);

  }

  public void clear() {
    GUI t = new GUI();
    t.init();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Clear") {
      super.getContentPane().removeAll();
      clear();
    }
    else if (e.getActionCommand() == "Random dots"){
      System.out.println("random dots clicked");
      //Graphics g=super.getContentPane().getGraphics();
      JButton btn=(JButton) e.getSource();
      CirclePanel c=(CirclePanel) btn.getParent();
      Randomdots random= new Randomdots(1,1,10,Color.red,c);
      random.draw();
    }
  }
}