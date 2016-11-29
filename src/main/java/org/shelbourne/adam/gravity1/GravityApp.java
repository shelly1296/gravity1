package org.shelbourne.adam.gravity1;

/**
 * Main App for Gravity calculations.
 *
 */
public class GravityApp {

	private void performCalculate() {
		GravityScanner gs = new GravityScanner();
		ScannerDto scannerDto = gs.getFromScanner(false);
		Projectile projectile = new Projectile(scannerDto);
		projectile.calculate();
	}

	public static void main(String[] args) {
		GravityApp ga = new GravityApp();
		ga.performCalculate();
	}
}
