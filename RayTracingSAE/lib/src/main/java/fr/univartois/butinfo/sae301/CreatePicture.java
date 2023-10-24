package fr.univartois.butinfo.sae301;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

public class CreatePicture {
	private int imgWidth;
	private int imgHeight;
	private Point lookAt;
	private Point lookFrom;
	private double fov;
	private Vector up;
	private List<ISceneObject> sceneObjects;

	public CreatePicture(Scene scene) {
		this.imgWidth = scene.getImageWidth();
		this.imgHeight = scene.getImageHeight();
		this.lookAt = scene.getCamera().getLookAt();
		this.lookFrom = scene.getCamera().getLookFrom();
		this.fov = scene.getCamera().getFov();
		this.up = scene.getCamera().getUp();
		this.sceneObjects = scene.getSceneObjects();
	}

	double fovr = fov * Math.PI / 180;
	double pixelHeight = Math.tan(fovr / 2);
	double pixelWidth = pixelHeight * ((double) imgWidth / (double) imgHeight);

	public double littleA(int i) {
		double a = (-(imgHeight / 2)) + (i + 0.5) * pixelWidth;
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

		Vector v = w.vectorProduct(w.getTrip());
		Vector norm = u.normalize();

		Vector d = u.multiplicationScailary(littleA(i)).add(u.multiplicationScailary(littleB(j))).subtraction(w);
		Vector normD = d.normalize();
		return normD;

	}

	public BufferedImage getMyImage() {

		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < imgWidth; i++) {
			for (int j = 0; j < imgHeight; j++) {

				Vector d = calcul(j, j, up);
				double t = 0;

				Point intersection = null;
				if (sceneObjects != null) {
					Vector oc = lookFrom.subtraction(sceneObjects.get(i).getOrigin());
					double a = d.scalarProduct(d);
					double b = 2.0 * oc.scalarProduct(d);
					double c = oc.scalarProduct(oc)
							- ((Sphere) sceneObjects.get(i)).getRadius() * ((Sphere) sceneObjects.get(i)).getRadius();
					double discriminant = b * b - 4.0 * a * c;

					if (discriminant < 0) {
						t = -1.0;
					} else {
						double t1 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
						double t2 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
						if (t1 >= 0) {
				            t = t1; // Intersection at t1 (closest intersection)
				        } else if (t2 >= 0) {
				            t = t2; // Intersection at t2
				        } else {
				            t = -1; // No intersection
				        }
						if (t != -1) {
							intersection = d.add(lookFrom).multiplicationScailary(t);
						}
					}

					if (intersection != null) {
						image.setRGB(i, j, 7989);
					} else {
						image.setRGB(i, j, 0);
					}
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
