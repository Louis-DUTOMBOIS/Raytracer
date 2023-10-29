package fr.univartois.butinfo.sae301.shadow;

import java.util.List;

import fr.univartois.butinfo.sae301.lights.Light;
import fr.univartois.butinfo.sae301.objects.ISceneObject;
import fr.univartois.butinfo.sae301.opetriplet.Point;

/**
 * The NoShadowStrategy class implements the IShadowStrategy interface and represents a shadow calculation strategy that always returns no shadow, indicating that a given point is not in shadow.
 *
 * This strategy effectively disables shadow calculations, making objects appear fully illuminated by lights.
 * @author Theo, Louis, Hugo, Alex
 */
public class NoShadowStrategy implements IShadowStrategy {
    /**
     * Determines that a given point is not in shadow, always returning `false`.
     *
     * @param intersection   The point for which shadow is being checked.
     * @param lights         The list of lights in the scene.
     * @param sceneObjects   The list of objects in the scene.
     * @return `false`, indicating that the point is not in shadow.
     */
	@Override
	public boolean isShadowed(Point intersection, List<Light> lights, List<ISceneObject> sceneObjects) {
		return false;
	}
}