package sk.zrebec.learn.java.designpatterns.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {

	final private Color color;

	/**
     * FlyWeight constructor prepare shape much faster
     *
     * @param color Color of shape
     */
	public Shape(Color color) { this.color = color; }

	/**
	 * @param g      Graphics
	 * @param upperX Start X coordinate of shape
	 * @param upperY Start Y coordinate of shape
	 */

	public void draw(Graphics g, int upperX, int upperY) {
		g.setColor(color);
		int r = getRandShapeSize();
		g.fillOval(upperX, upperY, r, r);
	}

	/*
	  Classic constructor returns prepare shape for draw (set color and coordinates)

	  Uncomment classic constructor only if you want to see different between classic method
	  when we creating a instance every single time. Otherwise keep this constructor commented
	  because FlyWeight constructor which using MyShapeFactory class is much faster
	 */

	/*
	public MyShape(Color color, int upperX, int upperY ) {

		this.color = color;
		this.x = upperX;
		this.y = upperY;
	}


	public void draw(Graphics g) {
		g.setColor(color);
		int r = getRandShapeSize();
		g.fillOval(x, y, r, r);
	}
	*/

	private static int getRandShapeSize() {
		return (int)(Math.random()*50-20);
	}

}
