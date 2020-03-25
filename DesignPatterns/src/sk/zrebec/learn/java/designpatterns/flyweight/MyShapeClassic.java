package sk.zrebec.learn.java.designpatterns.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class MyShapeClassic {

    private Color color;
    private int x, y;
	private static int shapeConstructorCounter = 0;
	private static int shapeCounter = 0;

	/*
	  Classic constructor returns prepare shape for draw (set color and coordinates)

	  Uncomment classic constructor only if you want to see different between classic method
	  when we creating a instance every single time. Otherwise keep this constructor commented
	  because FlyWeight constructor which using MyShapeFactory class is much faster
	 */


	public MyShapeClassic(Color color, int upperX, int upperY ) {
		shapeConstructorCounter++;
		this.color = color;
		x = upperX;
		y = upperY;
	}


	public void draw(Graphics g) {
		shapeCounter++;
		g.setColor(color);
		int r = getRandShapeSize();
		g.fillOval(x, y, r, r);
	}

    private static int getRandShapeSize() {
        return (int)(Math.random()*50-20);
    }

	public static int getConstructorCounter() {
		return shapeConstructorCounter;
	}

	public static int getCounter() {
		return shapeCounter;
	}

}
