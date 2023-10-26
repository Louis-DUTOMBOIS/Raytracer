package fr.univartois.butinfo.sae301;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a 3D scene with information about image dimensions, camera, lights, and scene objects.
 */
public class Scene {
    private int imageWidth;
    private int imageHeight;
    private String outputFileName;
    private Camera camera;
    private List<Light> lights;
    private List<ISceneObject> sceneObjects;

    public Scene(SceneBuilder sceneBuilder) {
    	this.imageWidth = sceneBuilder.getImageWidth();
    	this.imageHeight = sceneBuilder.getImageHeight();
    	this.outputFileName = sceneBuilder.getOutputFileName();
    	this.camera = sceneBuilder.getCamera();
    	this.lights = sceneBuilder.getLights();
    	this.sceneObjects = sceneBuilder.getSceneObjects();
    }
    
    /**
     * Creates a Scene with specified image dimensions, output file name, camera, lights, and scene objects.
     *
     * @param imageWidth     The width of the image.
     * @param imageHeight    The height of the image.
     * @param outputFileName The name of the output image file.
     * @param camera         The camera used to view the scene.
     * @param lights         A list of lights in the scene.
     * @param sceneObjects   A list of scene objects (e.g., spheres, planes, triangles).
     */
    public Scene(int imageWidth, int imageHeight, String outputFileName, Camera camera, List<Light> lights,
                 List<ISceneObject> sceneObjects) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.outputFileName = outputFileName;
        this.camera = camera;
        this.lights = lights;
        this.sceneObjects = sceneObjects;
    }

    /**
     * Creates a Scene with specified image dimensions and default values for other properties.
     *
     * @param imageWidth  The width of the image.
     * @param imageHeight The height of the image.
     */
    public Scene(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.outputFileName = "output.png";
        this.camera = null;
        this.lights = new ArrayList<>();
        this.sceneObjects = new ArrayList<>();
    }

    /**
     * Creates a default Scene with no specific image dimensions or properties.
     */
    public Scene() {
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.outputFileName = "output.png";
        this.camera = null;
        this.lights = new ArrayList<>();
        this.sceneObjects = new ArrayList<>();
    }

    /**
     * Gets the width of the image.
     *
     * @return The width of the image.
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Sets the width of the image.
     *
     * @param imageWidth The width of the image to set.
     */
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * Gets the height of the image.
     *
     * @return The height of the image.
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Sets the height of the image.
     *
     * @param imageHeight The height of the image to set.
     */
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * Gets the name of the output image file.
     *
     * @return The name of the output image file.
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Sets the name of the output image file.
     *
     * @param outputFileName The name of the output image file to set.
     */
    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    /**
     * Gets the camera used to view the scene.
     *
     * @return The camera object.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Sets the camera used to view the scene.
     *
     * @param camera The camera object to set.
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     * Gets the list of lights in the scene.
     *
     * @return The list of lights in the scene.
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * Sets the list of lights in the scene.
     *
     * @param lights The list of lights to set.
     */
    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    /**
     * Gets the list of scene objects (e.g., spheres, planes, triangles) in the scene.
     *
     * @return The list of scene objects in the scene.
     */
    public List<ISceneObject> getSceneObjects() {
        return sceneObjects;
    }

    /**
     * Sets the list of scene objects in the scene.
     *
     * @param sceneObjects The list of scene objects to set.
     */
    public void setSceneObjects(List<ISceneObject> sceneObjects) {
        this.sceneObjects = sceneObjects;
    }
	
    /**
     * Adds a light to the list of lights in the scene.
     *
     * @param light The light to add.
     */
    public void addLight(Light light) {
        this.lights.add(light);
    }

    /**
     * Adds a scene object to the list of scene objects in the scene.
     *
     * @param sceneObject The scene object to add.
     */
    public void addSceneObject(ISceneObject sceneObject) {
        this.sceneObjects.add(sceneObject);
    }

	@Override
	public String toString() {
		return "Scene [imageWidth=" + imageWidth + ", imageHeight=" + imageHeight + ", outputFileName=" + outputFileName
				+ ", camera=" + camera + ", lights=" + lights + ", sceneObjects=" + sceneObjects + "]";
	}

    
    
}
