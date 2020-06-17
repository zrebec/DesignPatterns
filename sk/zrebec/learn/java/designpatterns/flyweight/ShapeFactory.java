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
 * In this case, we have HashMap with shapes by color.
 * If we doesn't have color as a key in HashMap, we create a new
 * instance of shape. Otherwise we get existing shapess
 * from HashMap and return it. Then only a dimensions of shape
 * will be created in draw method.
 * 
 * @author friskyfox
 * @version 1.0
 *
 */

public class ShapeFactory {

	private static final HashMap<Color, Shape> shapeByColor = new HashMap<>();
	private static int shapeConstructorCounter = 0;
	private static int shapeCounter = 0;
	
	public static Shape getShape(Color color) {

		shapeCounter++;
		Shape shape = shapeByColor.get(color);
		
		if (shape == null) {
			shapeConstructorCounter++;
			shape = new Shape(color);
			shapeByColor.put(color, shape);
		}

		return shape;
		
	}

	public static int getConstructorCounter() {
		return shapeConstructorCounter;
	}

	public static int getCounter() {
		return shapeCounter;
	}
	
}