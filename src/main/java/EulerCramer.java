/**
 * 
 */

/**
 * @author gamep_000
 *
 */
public class EulerCramer {

	private static final Double ZERO = Double.valueOf("0.0");

	private ScannerDto scannerDto;

	public EulerCramer(ScannerDto scannerDto) {
		this.scannerDto = scannerDto;
	}

	public void applyMethod() {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		ThreeDimensionVector tdv = new ThreeDimensionVector(scannerDto);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector();
		while (tdv1.getyAxis() >= ZERO) {
			Double yAdjust = cgf.calulateGravitationalField(tdv1.getyAxis(), tdv1.getxAxis()) * scannerDto.getDeltaT();
			tdv = tdv.addVertical(yAdjust);
			ThreeDimensionVector tdv2 = tdv.scale(scannerDto.getDeltaT());
			tdv1 = tdv1.increaseBy(tdv2);

		}
	}
}
