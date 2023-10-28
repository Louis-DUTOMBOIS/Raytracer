package fr.univartois.butinfo.sae301.createscene;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.shadow.IShadowStrategy;

/**
 * 
 * @author hugo, louis, théo, alex
 *
 */

/**
 * A builder class for creating Scene objects in a 3D scene.
 * This builder allows for step-by-step construction of Scene objects with various properties.
 */
public class SceneBuilder {

	//existing attributes
	
    private int imageWidth;
    private int imageHeight;
    private String outputFileName;
    private Camera camera;
    private IShadowStrategy shadow;
    private List<Light> lights = new ArrayList<Light>();
    private List<ISceneObject> sceneObjects = new ArrayList<ISceneObject>();

    /**
     * Private constructor to enforce the use of the static factory method `newInstance()`.
     */
    private SceneBuilder() {
        super();
    }

    /**
     * Static factory method to create a new instance of the SceneBuilder.
     *
     * @return A new SceneBuilder instance.
     */
    public static SceneBuilder newInstance() {
        return new SceneBuilder();
    }

    /**
     * Sets the image width for the scene being built.
     *
     * @param imageWidth The width of the image.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    /**
     * Sets the image height for the scene being built.
     *
     * @param imageHeight The height of the image.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    /**
     * Sets the output file name for the scene being built.
     *
     * @param outputFileName The name of the output image file.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
        return this;
    }

    /**
     * Sets the camera for the scene being built.
     *
     * @param camera The Camera object to use for viewing the scene.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    /**
     * Adds a light source to the scene being built.
     *
     * @param light The Light object to add to the scene.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder addLight(Light light) {
        this.lights.add(light);
        return this;
    }

    /**
     * Adds a scene object (e.g., spheres, planes, triangles) to the scene being built.
     *
     * @param sceneObject The SceneObject to add to the scene.
     * @return The SceneBuilder instance for method chaining.
     */
    public SceneBuilder addSceneObject(ISceneObject sceneObject) {
        this.sceneObjects.add(sceneObject);
        return this;
    }

    /**
     * Gets the image width set for the scene.
     *
     * @return The width of the image.
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Gets the image height set for the scene.
     *
     * @return The height of the image.
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Gets the output file name set for the scene.
     *
     * @return The name of the output image file.
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Gets the camera set for the scene.
     *
     * @return The Camera object used to view the scene.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Gets the list of lights added to the scene.
     *
     * @return The list of lights in the scene.
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * Gets the list of scene objects added to the scene.
     *
     * @return The list of scene objects in the scene.
     */
    public List<ISceneObject> getSceneObjects() {
        return sceneObjects;
    }

    public IShadowStrategy getShadow() {
		return shadow;
	}

	public void setShadow(IShadowStrategy shadow) {
		this.shadow = shadow;
	}

	/**
     * Builds and returns a Scene object with the specified properties.
     *
     * @return A Scene object constructed with the settings provided to the builder.
     */
    public Scene build() {
        return new Scene(this);
    }
}