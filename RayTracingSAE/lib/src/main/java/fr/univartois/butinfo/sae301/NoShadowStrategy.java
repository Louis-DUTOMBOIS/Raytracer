package fr.univartois.butinfo.sae301;

import java.util.List;

//NoShadowStrategy.java
public class NoShadowStrategy implements IShadowStrategy {
	@Override
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects) {
		return false;
	}
}