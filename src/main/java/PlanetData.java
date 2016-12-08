import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public enum PlanetData {

	MERCURY(3.303e+23, 2.4397e6), //
	VENUS(4.869e+24, 6.0518e6), //
	EARTH(5.976e+24, 6.37814e6,  "1996-Dec-12 00:00:00.0000",  2.484222959391532E+07,  1.451747135757675E+08,  8.007169043719769E+02, -2.986102463530906E+01,  4.911290173498462E+00,  5.934816972774648E-05), //
	MARS(6.421e+23, 3.3972e6), //
	JUPITER(1.9e+27, 7.1492e7), //
	SATURN(5.688e+26, 6.0268e7), //
	URANUS(8.686e+25, 2.5559e7), //
	NEPTUNE(1.024e+26, 2.4746e7); //

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
		
		this.xVelocityPerSecond = xVelocity;
		this.yVelocity = yVelocity;
		this.zVelocity = zVelocity;
		
		xVelPerDay = xVelocity * 86400;
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