package fr.univartois.butinfo.sae301;

import java.util.List;

public class SceneBuilder {

	private int imageWidth;
	private int imageHeight;
	private String outputFileName;
	private Camera camera;
	private List<Light> lights;
	private List<SceneObject> sceneObjects;

	private SceneBuilder() {
		super();
	}

	public static SceneBuilder newInstance() {
		return new SceneBuilder();
	}

	public SceneBuilder setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public SceneBuilder setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    public SceneBuilder setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
        return this;
    }

    public SceneBuilder setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }
	
    public SceneBuilder addLight(Light light) {
        this.lights.add(light);
        return this;
    }

    public SceneBuilder addSceneObject(SceneObject sceneObject) {
        this.sceneObjects.add(sceneObject);
        return this;
    }

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public Camera getCamera() {
		return camera;
	}

	public List<Light> getLights() {
		return lights;
	}

	public List<SceneObject> getSceneObjects() {
		return sceneObjects;
	}

	public Scene build() {
        return new Scene(this);
    } 
}
