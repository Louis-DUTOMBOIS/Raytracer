package fr.univartois.butinfo.sae301;

/**
 * The ISceneObject interface represents an object in a scene that can be intersected by rays.
 *
 * @author Theo, Louis, Hugo, Alex
 */
public interface ISceneObject {

    /**
     * Returns the origin point of the scene object.
     *
     * @return The origin point of the scene object.
     */
    Point getOrigin();

    /**
     * Determines if a ray, defined by a point and a direction vector, intersects with the scene object.
     *
     * @param p The point through which the ray passes.
     * @param d The direction vector of the ray.
     * @return The parameter along the ray at which the intersection occurs, or a negative value if no intersection exists.
     */
    double intersect(Point p, Vector d);

    /**
     * Returns the color of the scene object.
     *
     * @return The color of the scene object.
     */
    Color getColor();
}
