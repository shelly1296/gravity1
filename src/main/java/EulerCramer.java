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
	private static final Integer ONE_JAVA_DAY = 1000 * 60 * 60 * 24;

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

	public void applyMethodSolarSystem(CelestialBody cb) {
		CalculateGravitaionalField cgf = new CalculateGravitaionalField();
		ThreeDimensionVector positionTdv = cb.getPositionVector();
		ThreeDimensionVector velocityTdv = cb.getVelocityVector();

		velocityTdv.increaseBy(cgf.calculateGraviation(positionTdv).scale(1.0));
		positionTdv.increaseBy(velocityTdv.scale(1.0));
		cb.setPositionVector(positionTdv);
		cb.setVelocityVector(velocityTdv);
		cb.increaseCurrentTime(ONE_JAVA_DAY);
	}
}
