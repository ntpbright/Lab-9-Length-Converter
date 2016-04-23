package lab9;
/**
 * 
 * @author Nuttapatprom CHongamorkulprapa
 * 
 *	object enum Length implements from Interface Unit
 */
public enum Length implements Unit{
	METER("Meter",1.0),
	KILOMETER("Kilometer",1000.0),
	CENTIMETER("Centimeter",0.01),
	NANOMETER("Nanometer",0.000001),
	MILE("Mile",0.000621),
	FOOT("Foot",0.3048),
	INCH("Inch",0.0254),
	WA("Wa",2);
	public final String name;
	public final double value;
	private Length(String name , double value){
		this.name = name;
		this.value = value;
	}
	@Override
	public double getValue(){
		return value;
	}
	@Override
	public String toString(){
		return name;
	}
}
