package fr.univartois.butinfo.sae301;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import javax.imageio.ImageIO;

public class CreatePicture {
    private int imgWidth;
    private int imgHeight;
    private Point lookAt;
    private Point lookFrom;
    private double fov;
    private Vector up;
    private List<ISceneObject> sceneObjects = new ArrayList<>();
    private String name;
    private List<Light> lights;
    private IShadowStrategy shadowStrategy;

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
        this.name = scene.getOutputFileName();
        this.lights = scene.getLights();
        this.shadowStrategy = scene.getShadow(); // Set the shadow strategy
        fovr = (fov * Math.PI) / 180.0;
        realHeight = 2.0 * Math.tan(fovr / 2);
        pixelHeight = realHeight / imgHeight;
        realWidth = imgWidth * pixelHeight;
        pixelWidth = realWidth / imgWidth;
    }

    public double littleA(int i) {
        return (-realWidth / 2) + (i + 0.5) * pixelWidth;
    }

    public double littleB(int j) {
        return (realHeight / 2) - (j + 0.5) * pixelHeight;
    }

    public Vector calcul(int i, int j, Vector up) {
        Vector w = lookFrom.subtraction(lookAt);
        Vector normW = w.normalize();

        Vector u = up.vectorProduct(normW.getTrip());
        Vector normU = u.normalize();

        Vector v = normW.vectorProduct(normU.getTrip());
        Vector norm = v.normalize();

        Vector d = ((normU.multiplicationScailary(littleA(i))).add(norm.multiplicationScailary(littleB(j))))
                .subtraction(normW);
        return d.normalize();
    }

    public BufferedImage getMyImage() {
    	int shadow = 0;
    	int noShadow = 0;
    	int reste = 0;
        BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                Vector d = calcul(i, j, up);
                Point intersection = null;
                ISceneObject closestObject = null;
                double closestT = Double.MAX_VALUE;

                if (sceneObjects != null) {
                    for (ISceneObject s : sceneObjects) {
                        double t = s.intersect(lookFrom, d);
                        if (t > 0 && t < closestT) {
                            closestT = t;
                            closestObject = s;
                            intersection = d.add(lookFrom).multiplicationScailary(t);
                        }
                    }
                }

                if (closestObject != null) {
                    if (lights.isEmpty()) {
                        fr.univartois.butinfo.sae301.Color color = BasicStrategy.calculateColor(d, lights, intersection, closestObject);
                        float r = (float) color.getTrip().getX();
                        float g = (float) color.getTrip().getY();
                        float b = (float) color.getTrip().getZ();
                        Color color1 = new Color(r, g, b);
                        image.setRGB(i, j, color1.getRGB());
                    } else {
                        if (closestObject instanceof Sphere) {
                            if (shadowStrategy.isShadowed(intersection, lights, sceneObjects)) {
                                Color color1 = new Color(0, 1, 1); // Point in shadow
                                image.setRGB(i, j, color1.getRGB());
                            } else {
                                Point p = d.multiplicationScailary(closestT).add(lookFrom);
                                Vector n = (p.subtraction(((Sphere) closestObject).getOrigin())).normalize();
                                Color color = LambertMethodStrategy.calculateColor(n, lights, intersection, closestObject);
                                image.setRGB(i, j, color.getRGB());
                            }
                        }
                    }
                } else {
                    image.setRGB(i, j, 0); // No intersection
                }
            }
        }

        try {
            File outputImage = new File(name);
            ImageIO.write(image, "png", outputImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }


				Point intersection;
				if (sceneObjects != null) {
					for (int element = 0; element < sceneObjects.size(); element++) {
						ISceneObject s = sceneObjects.get(element);
						t = s.intersect(lookFrom, d);
						if (t != -1) {
							intersection = d.add(lookFrom).multiplicationScailary(t);
							if (lights.isEmpty()) {
								fr.univartois.butinfo.sae301.Color color = BasicStrategy.calculateColor(d, lights, intersection, s);
								
								float r = (float) color.getTrip().getX();
								float g = (float) color.getTrip().getY();
								float b = (float) color.getTrip().getZ();

								Color color1 = new Color(r, g, b);
								image.setRGB(i, j, color1.getRGB());
							} else {
								if (s instanceof Sphere) {
									
									Point p = d.multiplicationScailary(t).add(lookFrom);
									Vector n = (p.subtraction(s.getOrigin())).normalize();
									Color color = LambertMethodStrategy.calculateColor(n, lights, p, s);
									
									image.setRGB(i, j, color.getRGB());
								}
				
							}

						}
						}
					}else {
							image.setRGB(i, j, 0);

				}
			}
		}

		try {
			File outputImage = new File(name);
			ImageIO.write(image, "png", outputImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;

	}
}
