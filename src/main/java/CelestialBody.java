
public class CelestialBody {
	private PlanetData planetData;

	private double currentXPosition;
	private double currentYPosition;
	private double currentZPosition;

	private double currentXVelocity;
	private double currentYVelocity;
	private double currentZVelocity;

	public CelestialBody(PlanetData planetData) {
		this.planetData = planetData;

		setCurrentXPosition(planetData.getxPosition());
		setCurrentYPosition(planetData.getyPosition());
		setCurrentZPosition(planetData.getzPosition());
		setCurrentXVelocity(planetData.getxVelocity());
		setCurrentYVelocity(planetData.getyVelocity());
		setCurrentZVelocity(planetData.getzVelocity());

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

}
