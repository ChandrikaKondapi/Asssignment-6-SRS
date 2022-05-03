import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.*;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.Math;
import java.util.List;

public class CirclePanel extends JPanel {
	private List<DrawCircle> circles = new LinkedList<DrawCircle>();
	int visited[] = new int[100];
	int a[] = new int[100];

	int v=0;
	int m=0;
	boolean isdrawCircle = true;

	public void addCircle(DrawCircle circle) {
		circles.add(circle);
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		if(isdrawCircle) {
			for (DrawCircle c : circles) {
				c.draw(g);
			}

			System.out.println("called paint function");

		}

	}

	public void run() {
		System.out.println("run called");
		int count = 0;
		//lineDB = new ArrayList<>();


		try {
			File coordinates = new File("newfile.txt");
			Scanner scanner = new Scanner(coordinates);
			List x= new ArrayList();
			List y = new ArrayList();
			int i = 0;
			String s1 = "";
			while (scanner.hasNext()) {

				s1 = scanner.nextLine();
				String s3 = s1.substring(0, s1.indexOf(","));
				x.add(Integer.parseInt(s3));
				String s2 = s1.substring(s1.indexOf(",") + 1);
				y.add(Integer.parseInt(s2));
				a[i]=i;
				System.out.println();
				i++;
				count++;

			}

			int rNum=1;
			Random rand = new Random();
			System.out.println("Array elements>>>>>>>>>\n\n");
			for (int j = 0; j < count; j++) {
				System.out.println( x.get(j) + "  " + y.get(j));
			}
		//	Arrays.sort(unvisited);
		//	int cond1 = Arrays.binarySearch(unvisited, 0);

			for(int f=0;f<count;f++) {
				Arrays.sort(visited);
				Arrays.sort(a);
				rNum = rand.nextInt(count);
				System.out.println("\n\n---Enter your distance parameter: ");
				Scanner sc = new Scanner(System.in);
				float distParam = sc.nextFloat();
				double dist;

				for (int u = 0; u < count; u++) {
					Arrays.sort(visited);
					int cond = Arrays.binarySearch(visited, rNum);

					if (cond < 0 && (rNum == u)) {

						visit(rNum);
						continue;
					} else {
						dist = Math.hypot((int) x.get(rNum) - (int) x.get(u), (int) y.get(rNum) - (int) y.get(u));
						System.out.println(dist);
						if (dist <= distParam) {
							isdrawCircle = false;
							paint(this.getGraphics());
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
							repaint();


							visit(u);
							System.out.println("Visited array:" + Arrays.toString(visited));
						}
						//else{
					//		unvisit(u);
					//		System.out.println("Visited array:" + Arrays.toString(visited));
						//}
					}
				}
				isdrawCircle = true;
				if(Arrays.equals(visited,a))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void visit(int a)
	{


		visited[v]=a;
		v++;
	}
	/*
	public void unvisit(int a)
	{


		unvisited[m]=a;
		m++;
	}

	 */
	public void save() {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("newfile.txt");
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

				Scanner sc = new Scanner(fi);
				System.out.println(fi);
				DrawCircle obj = null;
				circles = new LinkedList<DrawCircle>();
				System.out.println(circles);


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
