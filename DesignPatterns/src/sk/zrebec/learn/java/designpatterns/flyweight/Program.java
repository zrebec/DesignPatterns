package sk.zrebec.learn.java.designpatterns.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Program extends JFrame {
	
	
	/**
	 * Variable declarations
	 */
	JButton startDrawing;
	int windowWidth = 1750;
	int windowHeight = 900;
	Color[] shapeColor = { Color.ORANGE, Color.BLACK, Color.CYAN, Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.PINK, Color.BLUE };
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}
	
	public static void main(String[] args) {
		
		
		new Program();

	}
	
	/**
	 * Constructor creates a 100000 of rectangles
	 */
	public Program() {
		
		this.setSize(windowWidth, windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FlyWeight Test");

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		final JPanel drawingPanel = new JPanel();

		startDrawing = new JButton("Draw rectangles");

		contentPane.add(drawingPanel, BorderLayout.CENTER);
		contentPane.add(startDrawing, BorderLayout.SOUTH);

		startDrawing.addActionListener(e -> {


			Graphics g = drawingPanel.getGraphics();

			//Start measuring time
			long startTime = System.currentTimeMillis();

			for (int i = 0; i < 4000000; i++) {
					
					/*
					  This is classic method when we create a new instance of MyRectangle class
					  every single time.

					  Please, keep this 2 lines and classic
					  constructor commented in MyRectangle class and you will see that FlyWeight should
					  be faster around 200 to 300% on average.

					 */
				//MyRectangle rect = new MyRectangle(getRandomColor(), getRandX(), getRandY(), getRandX(), getRandY());
				//rect.draw(g);
					
					/*
					  This is FlyWeight method when we create a new instance of rectangle only if
					  color is changed. Otherwise just coordinates will be generated. Look at class
					  FlyWeightFactory for look how it works.
					 */
				MyRectangle rect = RectFactory.getRect(getRandomColor());
				rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());


			}

			//Calculate memory consumption
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();

			long memory = runtime.totalMemory() - runtime.freeMemory();
			System.out.println("Used memory in byes: " + memory);
			System.out.println("Used memory in megabyes: " + bytesToMegabytes(memory));

			//End time measuring and return result to output
			System.out.println("This took " + (System.currentTimeMillis() - startTime) + " milliseconds");

		});
		
		this.add(contentPane);
		this.setVisible(true);
	}
	
	/**
	 * This method returns color or rectangle
	 * @return Color of rectangle
	 */
	private Color getRandomColor()  {
		Random rn = new Random();
		return shapeColor[rn.nextInt(shapeColor.length - 1)];
	}
	
	/**
	 * Method returns random X position
	 * @return Integer of X
	 */
	private int getRandX() {return (int)(Math.random()*windowWidth);}
	
	/**
	 * Method returns random Y position
	 * @return Integer of Y
	 */
	private int getRandY() {return (int)(Math.random()*windowHeight);}

}
