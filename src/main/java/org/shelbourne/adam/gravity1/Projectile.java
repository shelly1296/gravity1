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
	
	public Projectile (ScannerDto scannerDto) {
		this.scannerDto = scannerDto;
	}
	
	public void calculate(){
		ThreeDimensionVector tdv = new ThreeDimensionVector(scannerDto);
		Double velocityY = ZERO;
		ThreeDimensionVector displacementY;
		Double yAdjust = GRAVITATIONAL_FIELD * scannerDto.getDeltaT();
		while (tdv.getyAxis() > ZERO) {
			tdv = tdv.addVertical(yAdjust);
			tdv = tdv.increaseBy(scannerDto.getDeltaT());
		}
	}
	

}
