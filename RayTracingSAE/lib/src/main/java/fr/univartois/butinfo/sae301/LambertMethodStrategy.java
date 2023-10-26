package fr.univartois.butinfo.sae301;
import java.awt.Color;

public class LambertMethodStrategy implements IColorStrategy {	
	@Override
	public Color calculateColor(Vector normal, Light[] light, Point intersectionPoint, ISceneObject object) {
		Vector n = intersectionPoint.subtraction(cc);// centre de la sphere
		Vector normN = n.normalize();
		
		//formule de lambert
		double res1 = normN.scalarProduct(ldir);// ldir direction de la lumiere
		double res2 = Math.max(res1, 0.0);
		Color res3 = res2.schurProduct(lightColor); // couleur de la lumiere
		Color x = res3.scalarProduct(cDiff); // couleur diffuse d'un objet
		
		// formule de la couleur finale
		double col = null;
	}
}