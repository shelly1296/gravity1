/**
 * @author gamep_000
 *
 */
public class CalculateGravitaionalField {

	private static final Double GRAVITATIONAL_CONSTANT = 6.67408E-11;
	private static final Double EARTH_MASS = 5.974E24;
	private static final Double EARTH_RADIUS = 6380E3;
	private static final Double SUN_MASS = 1.988544E30;

	public CalculateGravitaionalField() {

	}

	public Double calulateGravitationalField(Double x, Double y) {

		Double radius2 = Math.pow(EARTH_RADIUS + y, 2) + Math.pow(x, 2);
		Double radius = Math.pow(radius2, 0.5);
		Double g = -(GRAVITATIONAL_CONSTANT * EARTH_MASS) / Math.pow(radius, 2);

		return g;
	}

	public ThreeDimensionVector calculateGraviation(ThreeDimensionVector tdv) {

		double gravityAcceleration = (SUN_MASS * GRAVITATIONAL_CONSTANT / Math.pow(tdv.magnitude(), 2));
		
		ThreeDimensionVector tdv2 
		= tdv.getUnitVector(); 
		ThreeDimensionVector tdv3 = tdv2.scale(gravityAcceleration);
		// System.out.println("(" + tdv3.getxAxis() + "," + tdv3.getyAxis() +
		// ")");
		return tdv3;
	}

}
