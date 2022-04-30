
import java.awt.*;
import java.util.Scanner;


public class Randomdots {
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private CirclePanel panel;

    public int r;

    public Randomdots(int x, int y, int diameter, Color color,CirclePanel panel) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
        this.panel=panel;
    }



    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Graphics g){
        g.setColor(color.black);

        Scanner sc=new Scanner(System.in);
        System.out.println("Number of random dots to be displayed?");
        r=sc.nextInt();
        for (int i=0;i<r;i++){
            int a=(int) Math.ceil(Math.random()*10);
            int b=(int) Math.ceil(Math.random()*10);
            panel.addCircle(new DrawCircle(i+a,i+b,diameter,         color));
            //g.fillOval(i+a,i+b,3,3);
        }


    }
}
