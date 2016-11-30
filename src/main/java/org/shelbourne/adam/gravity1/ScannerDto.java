/**
 * 
 */
package org.shelbourne.adam.gravity1;
import static org.shelbourne.adam.gravity1.ThreeDimensionVector.ZERO;

/**
 * @author gamep_000
 *
 */
public class ScannerDto {
	Double xComponent = ZERO;
	Double yComponent = ZERO;
	Double zComponent = ZERO;
	Double deltaT = ZERO;

	/**
	 * @return the xComponent
	 */
	public Double getxComponent() {
		return xComponent;
	}

	/**
	 * @param xComponent
	 *            the xComponent to set
	 */
	public void setxComponent(Double xComponent) {
		this.xComponent = xComponent;
	}

	/**
	 * @return the yComponent
	 */
	public Double getyComponent() {
		return yComponent;
	}

	/**
	 * @param yComponent
	 *            the yComponent to set
	 */
	public void setyComponent(Double yComponent) {
		this.yComponent = yComponent;
	}

	/**
	 * @return the zComponent
	 */
	public Double getzComponent() {
		return zComponent;
	}

	/**
	 * @param zComponent
	 *            the zComponent to set
	 */
	public void setzComponent(Double zComponent) {
		this.zComponent = zComponent;
	}

	/**
	 * @return the deltaT
	 */
	public Double getDeltaT() {
		return deltaT;
	}

	/**
	 * @param deltaT
	 *            the deltaT to set
	 */
	public void setDeltaT(Double deltaT) {
		this.deltaT = deltaT;
	}

}
