package AbstractFactoryPattern;
/*
 * Create a Factory to generate object of concrete class based on given information.
 */
public class ColourFactory extends AbstractFactory{
	   //use getShape method to get object of type shape 
	   public Colour getColour(String ColourType){
	      if(ColourType == null){
	         return null;
	      }		
	      if(ColourType.equalsIgnoreCase("RED")){
	         return new RedColour();
	         
	      } else if(ColourType.equalsIgnoreCase("BLUE")){
	         return new BlueColour();
	         
	      } else if(ColourType.equalsIgnoreCase("GREEN")){
	         return new GreenColour();
	      }
	      
	      return null;
	   }

	@Override
	Shape getShape(String shape) {
		return null;
	}
}