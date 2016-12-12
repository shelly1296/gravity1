import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

public class EulerCramerTest {

	List<CelestialBody> celestialBodies = new ArrayList<>();
	EulerCramer eulerCramer;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		for (PlanetData pd : PlanetData.values()) {
			CelestialBody cb = new CelestialBody(pd);
			celestialBodies.add(cb);
		}
		
		eulerCramer = new EulerCramer();
		
		for (CelestialBody cb : celestialBodies) {
			// do maths to move it by one day...
			eulerCramer.applyMethodSolarSystem(cb);
			// 850435200000 is 1996-Dec-13 00:00:00.0000
			assertThat(cb.getCurrentTime().getTimeInMillis(), is(850435200000L));
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link EulerCramer#applyMethodSolarSystem(CelestialBody)}.
	 */
	@Test
	public void testEarth() throws Exception {
		CelestialBody earth = getBody(PlanetData.EARTH);
		// From NASA:
		// 1996-Dec-13 00:00:00.0000,  
		// Position:  2.225854864756040E+07,  1.455763843989554E+08,  8.176146177351475E+02, 
		// Velocity: -2.994473211680935E+01,  4.386408497201519E+00,  3.298770990365352E-04,
		assertThat(earth.getCurrentXPosition(), is(2.225854864756040E+07d));
		assertThat(earth.getCurrentYPosition(), is(1.455763843989554E+08d));
		assertThat(earth.getCurrentZPosition(), is(8.176146177351475E+02d));
		
		assertThat(earth.getCurrentXVelocity(), is(-2.994473211680935E+01d));
		assertThat(earth.getCurrentYVelocity(), is(4.386408497201519E+00d));
		assertThat(earth.getCurrentZVelocity(), is(3.298770990365352E-04d));		
	}
	
	
	/**
	 * Test method for {@link EulerCramer#applyMethodSolarSystem(CelestialBody)}.
	 */
	@Test
	public void testJupiter() throws Exception {
		CelestialBody earth = getBody(PlanetData.JUPITER);
		// From NASA:
		// 1996-Dec-13 00:00:00.0000,   
		// Position:  3.417225617688955E+08, -6.895118749138814E+08, -4.799047117535859E+06,   
		// Velocity: -1.154375779044662E+01,  6.417491366761777E+00, -2.851338391775564E-01,
		
		assertThat(earth.getCurrentXPosition(), is(3.417225617688955E+08d));
		assertThat(earth.getCurrentYPosition(), is(-6.895118749138814E+08d));
		assertThat(earth.getCurrentZPosition(), is(-4.799047117535859E+06d));
		
		assertThat(earth.getCurrentXVelocity(), is(-1.154375779044662E+01d));
		assertThat(earth.getCurrentYVelocity(), is(6.417491366761777E+00d));
		assertThat(earth.getCurrentZVelocity(), is(-2.851338391775564E-01d));		
	}
	
	
	private CelestialBody getBody(PlanetData planet) {
		CelestialBody retBody = null;
		for (CelestialBody cb : celestialBodies) {
			if (cb.getPlanetData() == planet) {
				retBody = cb;
				break;
			}
		}
		return retBody;
	}

}
