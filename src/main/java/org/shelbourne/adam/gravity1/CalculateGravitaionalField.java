/**
 * 
 */
package org.shelbourne.adam.gravity1;

/**
 * @author gamep_000
 *
 */
public class CalculateGravitaionalField {

	private static final Double GRAVITATIONAL_CONSTANT = 6.67408E-11;
	private static final Double EARTH_MASS = 5.974E24;
	private static final Double EARTH_Radius = 6380E3;

	public CalculateGravitaionalField() {

	}

	public Double calulateGravitationalField(Double x, Double y) {

		Double radius2 = Math.pow(EARTH_Radius + y, 2) + Math.pow(x, 2);
		Double radius = Math.pow(radius2, 0.5);
		Double g = -(GRAVITATIONAL_CONSTANT * EARTH_MASS) / Math.pow(radius, 2);

		return g;
	}

}
