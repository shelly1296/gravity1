/**
 * Main App for Gravity calculations.
 *
 */
public class GravityApp {

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
