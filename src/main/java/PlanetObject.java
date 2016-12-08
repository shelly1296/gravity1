/**
 * 
 */

/**
 * @author gamep_000
 *
 */
public class PlanetObject {

	public ThreeDimensionVector planetPosition = new ThreeDimensionVector();
	public ThreeDimensionVector planetVelocity = new ThreeDimensionVector();
	public Double mass;
	

	/**
	 * @return the planetVelocity
	 */
	public ThreeDimensionVector getPlanetVelocity() {
		return planetVelocity;
	}
	/**
	 * @param planetVelocity the planetVelocity to set
	 */
	public void setPlanetVelocity(ThreeDimensionVector planetVelocity) {
		this.planetVelocity = planetVelocity;
	}
	/**
	 * @return the xAxis
	 */
	public Double getxAxisP() {
		Double xAxis = planetPosition.getxAxis();
		return xAxis;
	}
	/**
	 * @return the xAxis
	 */
	public Double getyAxisP() {
		Double yAxis = planetPosition.getyAxis();
		return yAxis;
	}
	/**
	 * @return the xAxis
	 */
	public Double getzAxisP() {
		Double zAxis = planetPosition.getzAxis();
		return zAxis;
	}

	
	/**
	 * @return the planetPosition
	 */
	public ThreeDimensionVector getPlanetPosition() {
		return planetPosition;
	}
	/**
	 * @param planetPosition the planetPosition to set
	 */
	public void setPlanetPosition(ThreeDimensionVector planetPosition) {
		this.planetPosition = planetPosition;
	}
	/**
	 * @return the mass
	 */
	public Double getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(Double mass) {
		this.mass = mass;
	}
}
