package fr.univartois.butinfo.sae301;

/**
 * A class representing a three-dimensional triplet (x, y, z) for vector and scalar operations.
 * This class provides methods for vector operations such as addition, subtraction,
 * scalar multiplication, scalar product, vector product, Schur product, length calculation,
 * and normalization.
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**
     * Constructs a Triplet with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate of the triplet.
     * @param y The y-coordinate of the triplet.
     * @param z The z-coordinate of the triplet.
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the x-coordinate of the triplet.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the triplet.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the z-coordinate of the triplet.
     *
     * @return The z-coordinate.
     */
    public double getZ() {
        return z;
    }

    /**
     * Adds another triplet to this triplet, producing a new triplet.
     *
     * @param t The triplet to add to this triplet.
     * @return A new triplet representing the result of the addition.
     */
    public Triplet add(Triplet t) {
        return new Triplet(t.x + x, t.y + y, t.z + z);
    }

    /**
     * Subtracts another triplet from this triplet, producing a new triplet.
     *
     * @param t The triplet to subtract from this triplet.
     * @return A new triplet representing the result of the subtraction.
     */
    public Triplet subtraction(Triplet t) {
        return new Triplet(x - t.x, y - t.y, z - t.z);
    }

    /**
     * Multiplies the triplet by a scalar value, producing a new triplet.
     *
     * @param d The scalar value for multiplication.
     * @return A new triplet representing the result of the scalar multiplication.
     */
    public Triplet multiplicationScailary(double d) {
        return new Triplet(d * x, d * y, d * z);
    }

    /**
     * Calculates the scalar product (dot product) between this triplet and another.
     *
     * @param t The triplet for calculating the scalar product.
     * @return The scalar product between the two triplets.
     */
    public double scalarProduct(Triplet t) {
        return t.x * x + t.y * y + t.z * z;
    }

    /**
     * Calculates the vector product (cross product) between this triplet and another.
     *
     * @param t The triplet for calculating the vector product.
     * @return A new triplet representing the result of the vector product.
     */
    public Triplet vectorProduct(Triplet t) {
        return new Triplet(y * t.z - z * t.y, z * t.x - x * t.z, x * t.y - t.x * y);
    }

    /**
     * Calculates the Schur product (component-wise multiplication) between this triplet and another.
     *
     * @param t The triplet for calculating the Schur product.
     * @return A new triplet representing the result of the Schur product.
     */
    public Triplet schurProduct(Triplet t) {
        return new Triplet(x * t.x, y * t.y, z * t.z);
    }

    /**
     * Calculates the length (magnitude) of the triplet as a vector.
     *
     * @return The length of the triplet.
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Normalizes the triplet to have a unit length, producing a new normalized triplet.
     *
     * @return A new normalized triplet with a unit length.
     */
    public Triplet normalize() {
        double len = 1 / length();
        return new Triplet(len * x, len * y, len * z);
    }

	@Override
	public String toString() {
		return "Triplet [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
    
}
