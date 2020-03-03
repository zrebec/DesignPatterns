package sk.zrebec.learn.java.designpatterns.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle {

	private Color color;
	//private int x, y, x2, y2;

	/**
     * FlyWeight constructor prepare rectangle much faster
     *
     * @param color Color of rectangle
     */
	public MyRectangle(Color color) { this.color = color; }

	/**
	 * @param g      Graphics
	 * @param upperX Start X coordinate of rectangle
	 * @param upperY Start Y coordinate of rectangle
	 * @param lowerX End X coordinate of rectangle
	 * @param lowerY End Y coordinate of rectangle
	 */

	public void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {
		g.setColor(color);
		g.fillRect(upperX, upperY, lowerX, lowerY);
	}



	/*
	  Classic constructor returns prepare rectangle for draw (set color and coordinates)

	  Uncomment classic constructor only if you want to see different between classic method
	  when we creating a instance every single time. Otherwise keep this constructor commented
	  because FlyWeight constructor which using MyRectFactory class is much faster
	 */

	/*
	public MyRectangle(Color color, int upperX, int upperY, int lowerX, int LowerY) {

		this.color = color;
		this.x = upperX;
		this.y = upperX;
		this.x2 = lowerX;
		this.y2 = lowerX;

	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, x2, y2);
	}
	 */


}
