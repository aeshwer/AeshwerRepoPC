package AbstractFactoryPattern;

public abstract class AbstractFactory {
	 
	   abstract Colour getColour(String color);
	   abstract Shape getShape(String shape) ;
}
