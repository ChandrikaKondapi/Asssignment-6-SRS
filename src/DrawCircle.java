import java.awt.*;

public class DrawCircle {
    private int x;
    private int y;
    private int diameter;
    private Color color;

    public DrawCircle(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x,y,diameter,diameter);

    }
}
