import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CelestialBody {
	private PlanetData planetData;

	private double currentXPosition;
	private double currentYPosition;
	private double currentZPosition;

	private double currentXVelocity;
	private double currentYVelocity;
	private double currentZVelocity;
	
	private final Calendar epoch;

	public CelestialBody(PlanetData planetData) {
		this.planetData = planetData;

		setCurrentXPosition(planetData.getxPosition());
		setCurrentYPosition(planetData.getyPosition());
		setCurrentZPosition(planetData.getzPosition());
		
		setCurrentXVelocity(planetData.getxVelocityPerSecond());
		setCurrentYVelocity(planetData.getyVelocityPerSecond());
		setCurrentZVelocity(planetData.getzVelocityPerSecond());
				
		this.epoch = planetData.getEpoch();

	}

	public PlanetData getPlanetData() {
		return planetData;
	}

	public void setPlanetData(PlanetData planetData) {
		this.planetData = planetData;
	}

	public double getCurrentXPosition() {
		return currentXPosition;
	}

	public void setCurrentXPosition(double currentXPosition) {
		this.currentXPosition = currentXPosition;
	}

	public double getCurrentYPosition() {
		return currentYPosition;
	}

	public void setCurrentYPosition(double currentYPosition) {
		this.currentYPosition = currentYPosition;
	}

	public double getCurrentZPosition() {
		return currentZPosition;
	}

	public void setCurrentZPosition(double currentZPosition) {
		this.currentZPosition = currentZPosition;
	}

	public double getCurrentXVelocity() {
		return currentXVelocity;
	}

	public void setCurrentXVelocity(double currentXVelocity) {
		this.currentXVelocity = currentXVelocity;
	}

	public double getCurrentYVelocity() {
		return currentYVelocity;
	}

	public void setCurrentYVelocity(double currentYVelocity) {
		this.currentYVelocity = currentYVelocity;
	}

	public double getCurrentZVelocity() {
		return currentZVelocity;
	}

	public void setCurrentZVelocity(double currentZVelocity) {
		this.currentZVelocity = currentZVelocity;
	}
	
	public ThreeDimensionVector getPositionVector() {
		ThreeDimensionVector positionTdv = new ThreeDimensionVector(getCurrentXPosition(), getCurrentYPosition(), getCurrentZPosition());
		return positionTdv;
	}
	
	public ThreeDimensionVector getVelocityVector() {
		ThreeDimensionVector velocityTdv = new ThreeDimensionVector(getCurrentXVelocity(), getCurrentYVelocity(), getCurrentZVelocity());
		return velocityTdv;
	}
	
	public void setPositionVector(ThreeDimensionVector tdv) {
		setCurrentXPosition(tdv.getxAxis());
		setCurrentYPosition(tdv.getyAxis());
		setCurrentZPosition(tdv.getzAxis());
	}
	
	public void setVelocityVector(ThreeDimensionVector tdv) {
		setCurrentXVelocity(tdv.getxAxis());
		setCurrentYVelocity(tdv.getyAxis());
		setCurrentZVelocity(tdv.getzAxis());
	}

}
