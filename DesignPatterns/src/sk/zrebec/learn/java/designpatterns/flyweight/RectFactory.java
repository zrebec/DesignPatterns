package sk.zrebec.learn.java.designpatterns.flyweight;

import java.util.HashMap;
import java.awt.Color;

/**
 * This class is a sample of FlyWeight implementation.
 * 
 * FlyWeight Factory is a class which is useful if we
 * have many objects with similar properties. Primary 
 * goal minimize memory usage if object already exists 
 * recycle it and we just create a new one if similar object
 * doesn't exists yet in pool.
 * 
 * We have Intrinsic properties: Which are same for Object
 * and Extrinsic which are different for Object.
 * 
 * This can also speed up the application but this not primary
 * goal of FlyWeight design pattern.
 * 
 * In this case, we have HashMap with rectangles by color.
 * If we doesn't have color as a key in HashMap, we create a new
 * instance of rectangle. Otherwise we get existing rectangle 
 * from HashMap and return it. Then only a dimensions of rectangle
 * will be created in draw method.
 * 
 * @author friskyfox
 * @version 1.0
 *
 */


public class RectFactory {

	private static final HashMap<Color, MyRectangle> rectsByColor = new HashMap<>();
	private static int rectConstructorCounter = 0;
	private static int rectCounter = 0;
	
	public static MyRectangle getRect(Color color) {

		rectCounter++;
		MyRectangle rect = rectsByColor.get(color);
		
		if (rect == null) { 
			rectConstructorCounter++;
			rect = new MyRectangle(color);
			rectsByColor.put(color, rect);
		}

		return rect;
		
	}

	public static int getRectangleConstructorCounter() {
		return rectConstructorCounter;
	}

	public static int getRectangleCounter() {
		return rectCounter;
	}
	
}

