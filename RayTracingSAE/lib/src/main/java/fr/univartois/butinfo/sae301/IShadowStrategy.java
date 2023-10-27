package fr.univartois.butinfo.sae301;

import java.util.List;

//IShadowStrategy.java
public interface IShadowStrategy {
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects);
}