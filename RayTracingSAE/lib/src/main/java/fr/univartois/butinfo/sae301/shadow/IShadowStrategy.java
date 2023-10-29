package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;

/**
 * The IShadowStrategy interface defines a contract for shadow calculation strategies in a 3D rendering application.
 * @author Theo, Louis, Hugo, Alex
 */
public interface IShadowStrategy {
	/**
     * Determines whether a given point is in shadow based on the provided lights and scene objects.
     *
     * @param intersection   The point for which shadow is being checked.
     * @param lights         The list of lights in the scene.
     * @param sceneObjects   The list of objects in the scene.
     * @return `true` if the point is in shadow, `false` otherwise.
     */
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects);
}