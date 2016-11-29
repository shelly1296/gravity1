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
		ThreeDimensionVector tdv = new ThreeDimensionVector(scannerDto);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector(scannerDto);
		Double yAdjust = GRAVITATIONAL_FIELD * scannerDto.getDeltaT();
		while (tdv1.getyAxis() >= ZERO) {
			tdv = tdv.addVertical(yAdjust);
			tdv = tdv.scale(scannerDto.getDeltaT());
			tdv1 = tdv1.increaseBy(tdv);
		}
		Double xdistance = 2 * tdv1.getxAxis();
		System.out.println(xdistance);
	}

}
