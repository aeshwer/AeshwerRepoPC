package AbstractFactoryPattern;

public class AbstractFactoryPatternDemo {

	 public static void main(String[] args) {

	      //get shape factory
	      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

	      //get an object of Shape Circle
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call draw method of Shape Circle
	      shape1.draw();

	      //get an object of Shape Rectangle
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //call draw method of Shape Rectangle
	      shape2.draw();
	      
	      //get an object of Shape Square 
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      //call draw method of Shape Square
	      shape3.draw();

	      //get color factory
	      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

	      //get an object of Color Red
	      Colour color1 = colorFactory.getColour("RED");

	      //call fill method of Red
	      color1.fill();

	      //get an object of Color Green
	      Colour color2 = colorFactory.getColour("Green");

	      //call fill method of Green
	      color2.fill();

	      //get an object of Color Blue
	      Colour color3 = colorFactory.getColour("BLUE");

	      //call fill method of Color Blue
	      color3.fill();
	   }
}
