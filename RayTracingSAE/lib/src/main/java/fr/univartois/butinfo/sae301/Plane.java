package fr.univartois.butinfo.sae301;

/**
 * Represents a plane object in a 3D scene, which is a subclass of SceneObject.
 * A Plane is defined by its position, color, width, and height.
 */
public class Plane extends SceneObject {
    private int width;
    private int height;

    /**
     * Constructs a Plane object with the specified position, color, width, and height.
     *
     * @param pos    The position vector of the plane.
     * @param color  The color of the plane.
     * @param width  The width of the plane.
     * @param height The height of the plane.
     */
    public Plane(Vector pos, Color color, int width, int height) {
        super(pos, color);
        this.width = width;
        this.height = height;
    }
}