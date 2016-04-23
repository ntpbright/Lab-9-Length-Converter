package lab9;
/**
 * 
 * @author Nuttapatprom CHongamorkulprapa
 * 
 *	object UnitConverter use for convert value from input in GUI 
 */
public class UnitConverter {
	public double convert(double amount , Unit fromUnit , Unit toUnit){
		return (amount*fromUnit.getValue())/toUnit.getValue();
	}
	public Unit[] getUnits(){
		return Length.values();
	}
}
