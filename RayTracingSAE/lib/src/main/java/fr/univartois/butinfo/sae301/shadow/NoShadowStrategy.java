package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;

//NoShadowStrategy.java
public class NoShadowStrategy implements IShadowStrategy {
	@Override
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects) {
		return false;
	}
}