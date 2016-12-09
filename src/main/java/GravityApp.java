import java.util.ArrayList;
import java.util.List;

/**
 * Main App for Gravity calculations.
 *
 */
public class GravityApp {
	private static final Double day = 60.0*60.0*24.0*365.0;

	List<CelestialBody> celestialBodies = new ArrayList<CelestialBody>();
	
	public GravityApp() {
		for(PlanetData pd : PlanetData.values() ) {
			CelestialBody cb = new CelestialBody(pd);
			celestialBodies.add(cb);
		}
	}
	

	public void moveCelestialBodiesOneDay() {
		CalculateGravitaionalField cfg = new CalculateGravitaionalField();
		for( CelestialBody cb : celestialBodies) {
			// do maths to move it by one day...
			ThreeDimensionVector tdv = cb.setPositionVector();
			ThreeDimensionVector tdv1 = cb.setVelocityVector();
			ThreeDimensionVector gravity = cfg.calculateGraviation(tdv);
			tdv1 = tdv1.increaseBy(gravity.scale(day));
			tdv = tdv.increaseBy(tdv1.scale(day));
			System.out.println("(" + tdv.getxAxis() + ", " + tdv.getyAxis() + ", " + tdv.getzAxis() + ")");
		}
	}
	/**
	 * Method performs the calculation for the projectile in the earths gravitaional
	 * field
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
	 * @param args -- the command line arguments
	 */

	public static void main(String[] args) {
		GravityApp ga = new GravityApp();
		ga.performMethod();
	}
}
