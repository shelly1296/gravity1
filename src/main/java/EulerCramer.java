/**
 * 
 */

/**
 * @author gamep_000
 *
 */
public class EulerCramer {

	private static final Double ZERO = Double.valueOf("0.0");
	private static final Double AU = 1.49597870700E12;
	private static final Double OrbitalSpeed = 2.978589E4;


	public EulerCramer() {
		
	}

	public void applyMethod() {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		ThreeDimensionVector tdv = new ThreeDimensionVector();
		tdv.setyAxis(AU);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector();
		tdv1.setxAxis(OrbitalSpeed);
		for (int i = 0; i < 10000000; i++) {
			tdv1 = tdv1.increaseBy(cgf.calculateGraviation(tdv).scale(0.01));
			tdv = tdv.increaseBy(tdv1.scale(0.01));
			
		}
	}
}
