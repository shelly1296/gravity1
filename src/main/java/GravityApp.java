import java.util.ArrayList;
import java.util.List;

/**
 * Main App for Gravity calculations.
 *
 */
public class GravityApp {
	private static final Long DAY = 60L * 60L * 24L;
	private static final Long YEAR = DAY * 365L;
	private static final Long ONE_JAVA_DAY = DAY * 1000L;

	List<CelestialBody> celestialBodies = new ArrayList<>();
	List<PlanetDataWriter> writers = new ArrayList<>();

	public GravityApp() {
		for (PlanetData pd : PlanetData.values()) {
			CelestialBody cb = new CelestialBody(pd);
			celestialBodies.add(cb);
		}

		PlanetDataWriter pdw = new TimePeriodPlanetDataWriter(ONE_JAVA_DAY, "./day_tdv.csv");
		writers.add(pdw);
	}

	public void moveCelestialBodiesOneDay() {
		CalculateGravitaionalField cfg = new CalculateGravitaionalField();
		for (CelestialBody cb : celestialBodies) {
			// do maths to move it by one day...
			ThreeDimensionVector positionTdv = cb.getPositionVector();
			ThreeDimensionVector velocityTdv = cb.getVelocityVector();
			ThreeDimensionVector gravity = cfg.calculateGraviation(positionTdv);
			velocityTdv = velocityTdv.increaseBy(gravity.scale(DAY.doubleValue()));
			positionTdv = positionTdv.increaseBy(velocityTdv.scale(DAY.doubleValue()));
			System.out.println(
					"(" + positionTdv.getxAxis() + ", " + positionTdv.getyAxis() + ", " + positionTdv.getzAxis() + ")");
		}
	}

	public void moveCelestialBodiesOneYear() {
		EulerCramer ec = new EulerCramer();
		for (Long i = 0L; i < YEAR; i++) {
			for (CelestialBody cb : celestialBodies) {
				// do maths to move it by one day...
				ec.applyMethodSolarSystem(cb);
			}
		}
	}

	private void printResults(CelestialBody cb) {

		for (PlanetDataWriter pdw : writers) {
			pdw.print(cb);
		}
	}

	/**
	 * Method performs the calculation for the projectile in the earths
	 * gravitaional field
	 */
	private void performCalculate() {
		GravityScanner gs = new GravityScanner();
		ScannerDto scannerDto = gs.getFromScanner(false);
		Projectile projectile = new Projectile(scannerDto);
		projectile.calculate();
	}

	/**
	 * 
	 */
	private void performMethod() {
		EulerCramer eulerCramer = new EulerCramer();
		eulerCramer.applyMethod();
	}

	/**
	 * The main Method for the class and the app
	 * 
	 * @param args
	 *            -- the command line arguments
	 */

	public static void main(String[] args) {
		GravityApp ga = new GravityApp();
		ga.performMethod();
	}
}
