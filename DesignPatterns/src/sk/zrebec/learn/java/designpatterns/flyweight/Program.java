package sk.zrebec.learn.java.designpatterns.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@SuppressWarnings("serial")
public class Program extends JFrame {
	
	
	/**
	 * Variable declarations
	 */
	JButton startDrawingFlyWeight;
	JButton startDrawingClassic;
	int windowWidth = 800;
	int windowHeight = 600;
	Color[] shapeColor = { Color.ORANGE, Color.WHITE, Color.CYAN, Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.PINK, Color.BLUE };
	private static final long MEGABYTE = 1024L * 1024L;
	private static final int shapeCount = 4_000_000;

	public static double bytesToMegabytes(long bytes) {
		return (double) bytes / MEGABYTE;
	}
	
	public static void main(String[] args) {

		new Program();

	}
	
	/**
	 * Constructor creates a 100000 of shapes
	 */
	Program() {
		
		this.setSize(windowWidth, windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FlyWeight Test");

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		final JPanel drawingPanel = new JPanel();
		final JPanel buttonPanel = new JPanel();
		drawingPanel.setBackground(Color.BLACK);

		startDrawingFlyWeight = new JButton("Draw Shapes FlyWeight");
		startDrawingClassic = new JButton("Draw Shapes Classic");

		buttonPanel.add(startDrawingFlyWeight, BorderLayout.WEST);
		buttonPanel.add(startDrawingClassic, BorderLayout.NORTH);

		contentPane.add(drawingPanel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		startDrawingFlyWeight.addActionListener(e -> {
			System.out.println("Creating shapes with ShapeFactory");
			drawingPanel.removeAll();
			drawingPanel.revalidate();
			drawingPanel.repaint();
			Graphics g = drawingPanel.getGraphics();

			new Thread (() -> {

				//Start measuring time
				long startTime = System.currentTimeMillis();

				// Define the shape
				MyShapeFlyWeight shape;
				for (int i = 0; i < shapeCount; i++) {

					/*
					  This is FlyWeight method when we create a new instance of shape only if
					  color is changed. Otherwise just coordinates will be generated. Look at class
					  FlyWeightFactory for look how it works.
					 */
					shape = ShapeFactory.getShape(getRandomColor());
					shape.draw(g, getRandX(), getRandY());

				}

				//Calculate memory consumption
				Runtime runtime = Runtime.getRuntime();
				runtime.gc();

				long memory = runtime.totalMemory() - runtime.freeMemory();
				System.out.printf("Used memory: %d (%.02fMB) \n", memory, bytesToMegabytes(memory));
				System.out.println("Total constructors: " + ShapeFactory.getConstructorCounter());
				System.out.println("Total count: " + ShapeFactory.getCounter());
				//End time measuring and return result to output
				System.out.println("This took " + (System.currentTimeMillis() - startTime) + " milliseconds");

			}).start();

		});

		startDrawingClassic.addActionListener(e -> {
			System.out.println("Creating shapes by classic method");
			drawingPanel.removeAll();
			drawingPanel.revalidate();
			drawingPanel.repaint();
			Graphics g = drawingPanel.getGraphics();

			new Thread (() -> {

				//Start measuring time
				long startTime = System.currentTimeMillis();

				// Define the shape
				MyShapeClassic shape;
				for (int i = 0; i < shapeCount; i++) {

					/*
					  This is classic method when we create a new instance of MyShape class
					  every single time.

					  Please, keep this 2 lines and classic
					  constructor commented in MyShape class and you will see that FlyWeight should
					  be faster around 200 to 300% on average.

					 */
					shape = new MyShapeClassic(getRandomColor(), getRandX(), getRandY());
					shape.draw(g);

				}

				//Calculate memory consumption
				Runtime runtime = Runtime.getRuntime();
				runtime.gc();

				long memory = runtime.totalMemory() - runtime.freeMemory();
				System.out.printf("Used memory: %d (%.02fMB) \n", memory, bytesToMegabytes(memory));
				System.out.println("Total constructors: " + MyShapeClassic.getConstructorCounter());
				System.out.println("Total count: " + MyShapeClassic.getCounter());
				//End time measuring and return result to output
				System.out.println("This took " + (System.currentTimeMillis() - startTime) + " milliseconds");

			}).start();

		});

		this.add(contentPane);
		this.setVisible(true);
	}
	
	/**
	 * This method returns color or shape
	 * @return Color of shape
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
