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
		PlanetObject po = new PlanetObject();
		ThreeDimensionVector tdv = new ThreeDimensionVector(scannerDto);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector();
		while (tdv1.getyAxis() >= ZERO) {
			tdv.vectorSum(tdv, po.getPlanetPosition().scale(scannerDto.getDeltaT()));
			

		}
	}
}
