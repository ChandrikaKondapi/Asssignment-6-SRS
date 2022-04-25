import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleClick extends MouseAdapter{
    private CirclePanel panel;

    public CircleClick(CirclePanel panel) {
        super();
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(e.getX()+","+e.getY());
        panel.addCircle(new DrawCircle(e.getX(),e.getY(),10, Color.black));
    }
}
