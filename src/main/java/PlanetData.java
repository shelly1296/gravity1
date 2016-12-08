import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public enum PlanetData {

	MERCURY(3.303e+23, 2.4397e6, "1996-Dec-12 00:00:00.0000", 5.367081486624404E+07, -1.556546436467528E+07,
			-6.198076444660183E+06, 4.108430581073576E+00, 4.897964821746606E+01, 3.623724287384519E+00), //
	VENUS(4.869e+24, 6.0518e6, "1996-Dec-12 00:00:00.0000", -1.037933462870967E+08, -2.886998653443300E+07,
			5.597270103141149E+06, 9.153653017768322E+00, -3.389937767822175E+01, -9.913512651086069E-01), //
	EARTH(5.976e+24, 6.37814e6, "1996-Dec-12 00:00:00.0000", 2.484222959391532E+07, 1.451747135757675E+08,
			8.007169043719769E+02, -2.986102463530906E+01, 4.911290173498462E+00, 5.934816972774648E-05), //
	MARS(6.421e+23, 3.3972e6, "1996-Dec-12 00:00:00.0000", -1.749217418475782E+08, 1.749343477565961E+08,
			7.964590466426358E+06, -1.621848101050158E+01, -1.507029284075368E+01, 8.305844987801336E-02), //
	JUPITER(1.9e+27, 7.1492e7, "1996-Dec-12 00:00:00.0000", 3.407248693288624E+08, -6.900656923250402E+08,
			-4.774408960171789E+06, 1.155234040366976E+01, 6.402608993539165E+00, -2.851640454458955E-01), //
	SATURN(5.688e+26, 6.0268e7, "1996-Dec-12 00:00:00.0000", 1.407129226898553E+09, 1.624877126269689E+08,
			-5.877751909460077E+07, -1.618470654971855E+00, 9.585825885810593E+00, -1.030002050317527E-01), //
	URANUS(8.686e+25, 2.5559e7, "1996-Dec-12 00:00:00.0000", 1.664088867064735E+09, -2.449245142377790E+09,
			-3.066628011213934E+07, 5.593812593754338E+00, 3.519375380281258E+00, -5.961204692882416E-02), //
	NEPTUNE(1.024e+26, 2.4746e7, "1996-Dec-12 00:00:00.0000", 2.067610130974990E+09, -4.009503023417560E+09,
			3.489846864965463E+07, 4.805993711054371E+00, 2.530645002086889E+00, -1.622101285443508E-01); //

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @return the epoch
	 */
	public Calendar getEpoch() {
		return epoch;
	}

	/**
	 * @return the xPosition
	 */
	public double getxPosition() {
		return xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public double getyPosition() {
		return yPosition;
	}

	/**
	 * @return the zPosition
	 */
	public double getzPosition() {
		return zPosition;
	}

	/**
	 * @return the xVelocity
	 */
	public double getxVelocity() {
		return xVelocity;
	}

	/**
	 * @return the yVelocity
	 */
	public double getyVelocity() {
		return yVelocity;
	}

	/**
	 * @return the zVelocity
	 */
	public double getzVelocity() {
		return zVelocity;
	}

	/**
	 * @return the g
	 */
	public static double getG() {
		return G;
	}

	private final double mass; // in kilograms
	private final double radius; // in meters
	private final Calendar epoch; // The date and time of the planetary data.
	private final double xPosition; // in kilograms
	private final double yPosition; // in meters

	private final double zPosition; // in kilograms
	private final double xVelocity; // in meters

	private final double yVelocity; // in kilograms
	private final double zVelocity; // in meters

	PlanetData(double mass, double radius, String epochDateTime, //
			double xPos, double yPos, double zPos, //
			double xVelocity, double yVelocity, double zVelocity) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.SSSS");

		this.mass = mass;
		this.radius = radius;
		this.epoch = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		this.epoch.setTime(sdf.parse(epochDateTime));

		this.xPosition = xPos;
		this.yPosition = yPos;
		this.zPosition = zPos;

		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.zVelocity = zVelocity;
	}

	private double mass() {
		return mass;
	}

	private double radius() {
		return radius;
	}

	// universal gravitational constant (m3 kg-1 s-2)
	public static final double G = 6.67300E-11;

	double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java Planet <earth_weight>");
			System.exit(-1);
		}
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
	}
}