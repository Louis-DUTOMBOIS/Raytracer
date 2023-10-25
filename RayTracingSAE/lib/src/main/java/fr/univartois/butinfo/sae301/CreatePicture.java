package fr.univartois.butinfo.sae301;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class CreatePicture {
	private int imgWidth;
	private int imgHeight;
	private Point lookAt;
	private Point lookFrom;
	private double fov;
	private Vector up;
	private List<ISceneObject> sceneObjects = new ArrayList<ISceneObject>();
	
	private double fovr;
	private double realHeight;
	private double pixelHeight;
	private double realWidth;
	private double pixelWidth;
	
	public CreatePicture(Scene scene) {
		this.imgWidth = scene.getImageWidth();
		this.imgHeight = scene.getImageHeight();
		this.lookAt = scene.getCamera().getLookAt();
		this.lookFrom = scene.getCamera().getLookFrom();
		this.fov = scene.getCamera().getFov();
		this.up = scene.getCamera().getUp();
		this.sceneObjects = scene.getSceneObjects();
		fovr = (fov * Math.PI) / 180.0;
		realHeight = 2.0 * Math.tan(fovr / 2);
		pixelHeight = realHeight / imgHeight;
		realWidth = imgWidth * pixelHeight;
		pixelWidth = realWidth / imgWidth;
	}
	


	public double littleA(int i) {
		double a = (-(imgWidth / 2)) + (i + 0.5) * pixelWidth;
		return a;
	}

	public double littleB(int j) {
		double b = (imgHeight / 2) - (j + 0.5) * pixelHeight;
		return b;
	}

	public Vector calcul(int i, int j, Vector up) {
		
		Vector w = lookFrom.subtraction(lookAt);
		Vector normW = w.normalize();

		Vector u = up.vectorProduct(w.getTrip());
		Vector normU = u.normalize();

		Vector v = w.vectorProduct(u.getTrip());
		Vector norm = v.normalize();

		Vector d = u.multiplicationScailary(littleA(i)).add(u.multiplicationScailary(littleB(j))).subtraction(w);
		Vector normD = d.normalize();
		return normD;

	}

	public BufferedImage getMyImage() {

		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < imgWidth; i++) {
			for (int j = 0; j < imgHeight; j++) {

				Vector d = calcul(i, j, up);
				double t = 0;

				Point intersection = null;
				if (sceneObjects != null) {
					ISceneObject s = sceneObjects.get(0);
					t = s.intersect(lookFrom, d);
					if (t != -1) {
						System.out.println("hey");
						intersection = d.add(lookFrom).multiplicationScailary(t);
					}
				}

				if (intersection != null) {
					image.setRGB(i, j, 26845312);
				}

				else {
					image.setRGB(i, j, 0);
				}
			}
		}

		try {
			File outputImage = new File("output.png");
			ImageIO.write(image, "png", outputImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;

	}
}
