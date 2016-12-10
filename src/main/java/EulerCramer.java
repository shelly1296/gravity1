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
	private static final Double ORBITAL_SPEED = 2.978589E4;
	private static final Double HOUR = 60.0 * 60.0;

	public EulerCramer() {

	}

	public void applyMethod() {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		ThreeDimensionVector tdv = new ThreeDimensionVector();
		tdv.setyAxis(AU);
		ThreeDimensionVector tdv1 = new ThreeDimensionVector();
		tdv1.setxAxis(ORBITAL_SPEED);
		for (int i = 0; i < 10000000; i++) {
			tdv1 = tdv1.increaseBy(cgf.calculateGraviation(tdv).scale(1.0));
			tdv = tdv.increaseBy(tdv1.scale(1.0));

		}
	}

	public void applyMethodSolarSystem(ThreeDimensionVector tdv, ThreeDimensionVector tdv1, Double x) {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		for (int i = 0; i < x; i++) {
			tdv1 = tdv1.increaseBy(cgf.calculateGraviation(tdv).scale(HOUR));
			tdv = tdv.increaseBy(tdv1.scale(HOUR));

		}
	}
}
