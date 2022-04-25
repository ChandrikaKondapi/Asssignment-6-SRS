import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class GUInterface {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ViewFrame frame = new ViewFrame();
            }
        });
    }
}
class ViewFrame extends JFrame{
    public ViewFrame (){
        this.setTitle("Distance");
        JPanel panel=new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        this.add(panel, BorderLayout.CENTER);
        this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        panel.setBackground(Color.BLACK);
        JLabel label =new JLabel("Welcome");
        label.setForeground(Color.white);
        panel.add(label);
        JButton button=new JButton("RUN");
        button.setBounds(1000, 10000, 100, 100);
        panel.add(button);
        JButton button2=new JButton("Save");
        panel.add(button2);
        JButton button3=new JButton("Load");
        panel.add(button3);
        JButton button4=new JButton("Clear");
        panel.add(button4);
        JButton button5=new JButton("Random dots");
        panel.add(button5);


    }
}





