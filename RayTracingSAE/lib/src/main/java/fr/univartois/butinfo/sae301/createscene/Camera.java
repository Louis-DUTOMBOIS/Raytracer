package fr.univartois.butinfo.sae301.createscene;

import fr.univartois.butinfo.sae301.opetriplet.Point;
import fr.univartois.butinfo.sae301.opetriplet.Vector;

/**
 * 
 * Represents a camera in a 3D scene. The camera defines the viewpoint and orientation for rendering the scene.
 * 
 * @author Theo, Louis, Hugo, Alex
 * 
 */
public class Camera {
    private Point lookFrom; // The camera's position (x, y, z)
    private Point lookAt; // The point the camera is aimed at (x, y, z)
    private Vector up; // The up vector indicating the camera's orientation (x, y, z)
    private int fov; // The field of view angle in degrees

    /**
     * Constructs a Camera with the specified parameters.
     *
     * @param lookFrom The position of the camera.
     * @param lookAt   The point the camera is aimed at.
     * @param up       The up vector indicating the camera's orientation.
     * @param fov      The field of view angle in degrees.
     */
    public Camera(Point lookFrom, Point lookAt, Vector up, int fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Get the camera's position.
     *
     * @return The position of the camera.
     */
    public Point getLookFrom() {
        return lookFrom;
    }

    /**
     * Set the camera's position.
     *
     * @param lookFrom The new position for the camera.
     */
    public void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
    }

    /**
     * Get the point the camera is aimed at.
     *
     * @return The point the camera is aimed at.
     */
    public Point getLookAt() {
        return lookAt;
    }

    /**
     * Set the point the camera is aimed at.
     *
     * @param lookAt The new point the camera should aim at.
     */
    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    /**
     * Get the up vector indicating the camera's orientation.
     *
     * @return The up vector of the camera.
     */
    public Vector getUp() {
        return up;
    }

    /**
     * Set the up vector indicating the camera's orientation.
     *
     * @param up The new up vector for the camera's orientation.
     */
    public void setUp(Vector up) {
        this.up = up;
    }

    /**
     * Get the field of view angle in degrees.
     *
     * @return The field of view angle.
     */
    public int getFov() {
        return fov;
    }

    /**
     * Set the field of view angle in degrees.
     *
     * @param fov The new field of view angle for the camera.
     */
    public void setFov(int fov) {
        this.fov = fov;
    }
}

