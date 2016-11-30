/**
 * 
 */
package org.shelbourne.adam.gravity1;

import static org.shelbourne.adam.gravity1.ThreeDimensionVector.ZERO;

/**
 * @author gamep_000
 *
 */
public class Projectile {

	private static final Double GRAVITATIONAL_FIELD = -9.81;

	private ScannerDto scannerDto;

	public Projectile(ScannerDto scannerDto) {
		this.scannerDto = scannerDto;
	}

	public void calculate() {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		ThreeDimensionVector tdv = new ThreeDimensionVector(scannerDto);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector();
		while (tdv1.getyAxis() >= ZERO) {
			Double yAdjust = cgf.calulateGravitationalField(tdv1.getyAxis(), tdv1.getxAxis()) * scannerDto.getDeltaT(); 
			tdv = tdv.addVertical(yAdjust);
		    ThreeDimensionVector tdv2 = tdv.scale(scannerDto.getDeltaT());
		    System.out.println(tdv2.getxAxis());
			System.out.println(tdv2.getyAxis());
			tdv1 = tdv1.increaseBy(tdv2);
			
		}
		Double xdistance = tdv1.getxAxis();
		System.out.println(xdistance);
	}

}
