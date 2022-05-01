import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	private List<DrawCircle> circles = new LinkedList<DrawCircle>();

	public void addCircle(DrawCircle circle) {
		circles.add(circle);
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		for (DrawCircle c : circles) {
			c.draw(g);
		}

	}

	public void save() {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("C:\\Users\\jappaka\\Desktop\\newfile.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			for (DrawCircle c : circles) {
				System.out.println("*********");
				fop.write((c.getX() + "," + c.getY()).getBytes());
				fop.write("\n".getBytes());
			}


			fop.flush();
			fop.close();

			System.out.println(circles);

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

	public void load() {
		FileInputStream fi;

		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				fi = new FileInputStream(new File(selectedFile.getAbsolutePath()));

//ObjectInputStream oi = new ObjectInputStream(fi);
				Scanner sc = new Scanner(fi);
				System.out.println(fi);
				DrawCircle obj = null;
				circles = new LinkedList<DrawCircle>();
				System.out.println(circles);
//while ((obj = fi.read()) != null) {
// obj = (Circle) oi.readObject();
// System.out.println(obj);
// circles.add(obj);
//}

				while (sc.hasNextLine()) {
					String[] point = sc.nextLine().split(",");
					DrawCircle c = new DrawCircle(Integer.parseInt(point[0]), Integer.parseInt(point[1]), 10, Color.black);
					circles.add(c);
				}
				this.repaint();
				System.out.println(circles);
				fi.close();
			}
//this.repaint();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			this.repaint();
		}
	}
}
