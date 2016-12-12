public class ThreeDimensionVector {

	private static final Double ZERO = Double.valueOf("0.0");

	private Double xAxis = ZERO;
	private Double yAxis = ZERO;
	private Double zAxis = ZERO;

	public ThreeDimensionVector() {

	}

	public ThreeDimensionVector(ScannerDto scannerDto) {
		setxAxis(scannerDto.getxComponent());
		setyAxis(scannerDto.getyComponent());
		setzAxis(scannerDto.getzComponent());
	}

	public ThreeDimensionVector(Double x, Double y, Double z) {
		setxAxis(x);
		setyAxis(y);
		setzAxis(z);
	}

	/**
	 * @return the xAxis
	 */
	public Double getxAxis() {
		return xAxis;
	}

	/**
	 * @param xAxis
	 *            the xAxis to set
	 */
	public void setxAxis(Double xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * @return the yAxis
	 */
	public Double getyAxis() {
		return yAxis;
	}

	/**
	 * @param yAxis
	 *            the yAxis to set
	 */
	public void setyAxis(Double yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * @return the zAxis
	 */
	public Double getzAxis() {
		return zAxis;
	}

	/**
	 * @param zAxis
	 *            the zAxis to set
	 */
	private void setzAxis(Double zAxis) {
		this.zAxis = zAxis;
	}

	/**
	 * Add a vector <b>v</b> to <code>this</code> vector. Normal vector addition
	 * is carried out. I.e. the x-components are added and the y components are
	 * added, etc.
	 *
	 * @param v
	 *            vector to be added to original vector.
	 * @return ThreeDimensionVector (tdv) -- this instance of tdv that has been
	 *         increased
	 **/
	public ThreeDimensionVector increaseBy(ThreeDimensionVector v) {

		setxAxis(getxAxis() + v.getxAxis());
		setyAxis(getyAxis() + v.getyAxis());
		setzAxis(getzAxis() + v.getzAxis());

		return this;
	}

	/**
	 * Subtract a vector <b>v</b> from the original vector. Normal vector
	 * subtraction is carried out. I.e. the x-components are subtracted and the
	 * y components are subtracted, etc.
	 *
	 * @param v
	 *            vector to be subtracted from the original vector.
	 * @return ThreeDimensionVector (tdv) -- this instance of tdv that has been
	 *         decreased
	 **/
	public ThreeDimensionVector decreaseBy(ThreeDimensionVector v) {
		setxAxis(getxAxis() - v.getxAxis());
		setyAxis(getyAxis() - v.getyAxis());
		setzAxis(getzAxis() - v.getzAxis());

		return this;
	}

	/**
	 * returns the magnitude of the vector. If the vector is given by x<b>i</b>
	 * +y<b>j</b> +z<b>k</b> then the magnitude is sqrt(x^2 + y^2+ z^2).
	 *
	 * @return a scalar with the magnitude of the original vector.
	 **/
	public Double magnitude() {
		Double mag = dot(this, this);
		mag = Math.sqrt(mag);
		return mag;
	}

	/**
	 * Standard vector scalar product. If x<b>i</b>+y<b>j</b>+z<b>k</b> and
	 * r<b>i</b>+s<b>j</b>+t<b>k</b> then the dot product returns xr+ys+zt
	 *
	 * @param u
	 *            first vector in product
	 * @param v
	 *            second vector in product
	 * @return the scalar product between u and v
	 **/
	public static Double dot(ThreeDimensionVector u, ThreeDimensionVector v) {
		Double product = ZERO;

		product += u.getxAxis() * v.getxAxis();
		product += u.getyAxis() * v.getyAxis();
		product += u.getzAxis() * v.getzAxis();

		return product;
	}

	/**
	 * Scale the components of the vector by a scalar. I.e. If the scalar is s
	 * and the vector is x<b>i</b>+y<b>j</b>+z<b>k</b> then the vector
	 * transforms to xs<b>i</b>+ys<b>j</b>+zs<b>k</b>
	 *
	 * @param x
	 *            the factor to scale the vector by.
	 * @return ThreeDimensionVector (tdv) -- a new instance of tdv that has had
	 *         the scale applied.
	 **/
	public ThreeDimensionVector scale(Double x) {
		setxAxis(getxAxis() * x);
		setyAxis(getyAxis() * x);
		setzAxis(getzAxis() * x);

		return this;
	}

	/**
	 * Returns a vector with a magnitude of 1 and the original direction of
	 * <code>this</code> vector. I.e. scale the vector by 1/magnitude. If the
	 * vector is a zero vector then it returns the zero length vector.
	 *
	 * @return unit vector with the same direction of the original vector
	 **/
	public ThreeDimensionVector getUnitVector() {
		ThreeDimensionVector unit;
		Double magnitude = magnitude();
		unit = new ThreeDimensionVector();

		if (Math.abs(magnitude) > 1.e-34) {
			Double oom = (1 / magnitude);
			unit.setxAxis(getxAxis() * oom);
			unit.setyAxis(getyAxis() * oom);
			unit.setzAxis(getzAxis() * oom);
			
		} else {
			unit = new ThreeDimensionVector();
		}
		return unit;
	}

	/**
	 * Standard vector (cross) product between two 3D vectors: <b>u</b> and
	 * <b>v</b>. The result is a vector which is perpendicular to the original
	 * vectors with a magnitude equal to |u||v|Sin(t) where 't' is the angle
	 * between the vectors.
	 *
	 * @param u
	 *            first vector
	 * @param v
	 *            second vector
	 * @return the vector product of u and v
	 **/
	public static ThreeDimensionVector vectorProduct(ThreeDimensionVector u, ThreeDimensionVector v) {
		ThreeDimensionVector product = new ThreeDimensionVector();

		product.setxAxis(u.getyAxis() * v.getzAxis() - u.getzAxis() * v.getyAxis());
		product.setyAxis(u.getzAxis() * v.getxAxis() - u.getxAxis() * v.getzAxis());
		product.setzAxis(u.getxAxis() * v.getyAxis() - u.getyAxis() * v.getxAxis());

		return product;
	}

	public ThreeDimensionVector addVertical(Double yAdjust) {
		ThreeDimensionVector tdv = new ThreeDimensionVector();
		tdv.setyAxis(getyAxis() + yAdjust);
		tdv.setxAxis(getxAxis());
		tdv.setzAxis(getzAxis());

		return tdv;
	}

	public ThreeDimensionVector vectorSum(ThreeDimensionVector v, ThreeDimensionVector u) {
		ThreeDimensionVector tdv = new ThreeDimensionVector();
		tdv.setxAxis(v.getxAxis() + u.getxAxis());
		tdv.setyAxis(v.getyAxis() + u.getyAxis());
		tdv.setzAxis(v.getzAxis() + u.getzAxis());

		return tdv;
	}
	
	public ThreeDimensionVector setVector(ThreeDimensionVector v) {
		ThreeDimensionVector tdv = new ThreeDimensionVector();
		
		tdv.setxAxis(v.getxAxis());
		tdv.setyAxis(v.getyAxis());
		tdv.setzAxis(v.getzAxis());
		
		return tdv;
	}

}
