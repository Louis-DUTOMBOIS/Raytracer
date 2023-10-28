package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;

//IShadowStrategy.java
public interface IShadowStrategy {
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects);
}