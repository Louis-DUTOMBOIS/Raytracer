package fr.univartois.butinfo.sae301;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateImage {
	private int imgWidth;
	private int imgHeight;
	private Point lookAt;
	private Point lookFrom;
	private double fov;
	public CreateImage(int imgWidth, int imgHeight, Point lookAt, Point lookFrom, double fov, double fovr,
			double pixelHeight, double pixelWidth) {
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.lookAt = lookAt;
		this.lookFrom = lookFrom;
		this.fov = fov;
		this.fovr = fovr;
		this.pixelHeight = pixelHeight;
		this.pixelWidth = pixelWidth;
	}

	double fovr = fov * Math.PI/180;
	double pixelHeight = Math.tan(fovr/2);
	double pixelWidth = pixelHeight*(imgWidth/imgHeight);
	
	public void littleA(int i) {
		double a = (-imgHeight/2)+(i+0.5)*pixelHeight;
	}
	
	public void littleB(int j) {
		double b = (-imgHeight/2)+(j+0.5)*pixelWidth;
	}
	
	
	public void calcule(int i, int j, Vector up) {	
		Vector w = lookFrom.subtraction(lookAt);
		Vector normW = w.normalize();
		Vector u = up.scalarProduct(w);
		Vector normU = u.normalize();
		Vector v = w.scalarProduct(w);
		Vector norm = u.normalize();
		
		Vector d =  u.scalarProduct(a) + u.vectorProduct(b) - w;
		Vector normD = d.normalize();
				
	}
	
	public BufferedImage getMyImage() {
		
	}
	
	try {
		BufferedImage image = getMyImage();
		File outputfile = new File("img1.png");
		ImageIO.write(image,"png", outputfile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	public void testColor(Point p) {
		if(p != null) {
			//calculer couleur
		}
		else {
			Color c = new Color(0,0,0);
		}
	}
}


/*
-charger la scene 
-pour chaque pixel(i,j) de l'image a generer
	-calculer le vecteur unitaire d qui represente un rayon allant de l'oeil lookForm au centre du pixel(i,j)
	-rechercher le point p=lookForm+d*t d'intersection le plus proche (t minimal) avec un objet de la scene 
	-si p existe alors calculer sa couleur 
	-sinon utiliser du noir
	- peindre le pixel(i,j) avec la couleur adéquate
-sauvegarder l'image
*/

