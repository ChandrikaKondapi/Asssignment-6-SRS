import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

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
  public void save(){
    FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("https://replit.com/@gayathri-raj/Project-J#/newfile.txt");
			fop = new FileOutputStream(file);
      
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
      for(DrawCircle c :circles) {
          System.out.println("*********");
          fop.write((c.getX()+","+ c.getY()).getBytes());
        }


			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
}
