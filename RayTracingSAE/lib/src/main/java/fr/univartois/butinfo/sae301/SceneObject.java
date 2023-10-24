package fr.univartois.butinfo.sae301;

/**
 * An abstract base class representing a scene object in a 3D environment.
 * Scene objects have properties such as position and color and can be translated.
 */
public abstract class SceneObject {
    protected Vector pos;
    protected Color color;

    /**
     * Constructs a SceneObject with the specified position and color.
     *
     * @param pos   The position vector of the scene object.
     * @param color The color of the scene object.
     */
    public SceneObject(Vector pos, Color color) {
        this.pos = pos;
        this.color = color;
    }

    /**
     * Translates (moves) the scene object by a given translation vector.
     *
     * @param translation The translation vector to apply to the scene object's position.
     */
    public void translate(Vector translation) {
        pos.add(translation);
    }
}