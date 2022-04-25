import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CirclePanel extends JPanel {
    private List<DrawCircle> circles=new LinkedList<DrawCircle>();

    public void addCircle(DrawCircle circle){
        circles.add(circle);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        for(DrawCircle c :circles) {
            c.draw(g);
        }

    }
}
