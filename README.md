@startuml

package fr.univartois.butinfo.sae301.shadow{
class NoShadowStrategy {
  +isShadowed(Point, List<Light>, List<ISceneObject>): boolean
}
}

package fr.univartois.butinfo.sae301.createscene{
class Parser {
    - width: int
    - height: int
    - maxverts: int
    - pictureFileName: String
    - camera: Camera
    - ambientColors: Color
    - diffuseColors: Color
    - specularColors: Color
    - shininessValues: int
    - lights: List<Light>
    - pointsLight: List<PointLight>
    - points: List<Point>
    - triangles: List<Triangle>
    - spheres: List<Sphere>
    - planes: List<Plane>
    - shadow: IShadowStrategy
    + getWidth(): int
    + getHeight(): int
    + getMaxverts(): int
    + getPictureFileName(): String
    + getCamera(): Camera
    + getAmbientColors(): Color
    + getDiffuseColors(): Color
    + getSpecularColors(): Color
    + getShininessValues(): int
    + getLights(): List<Light>
    + getPointsLight(): List<PointLight>
    + getPoints(): List<Point>
    + getTriangles(): List<Triangle>
    + getSpheres(): List<Sphere>
    + getPlanes(): List<Plane>
    + read(File): void
    + constructScene(): Scene
}
}

package fr.univartois.butinfo.sae301.objects{
class Plane {
    - pos: Point
    - normal: Vector
    - color: Color
    + Plane(Point, Vector, Color)
    + getOrigin(): Point
    + getPos(): Point
    + setPos(Point): void
    + getNormal(): Vector
    + setNormal(Vector): void
    + intersect(Point, Vector): double
    + getColor(): Color
}
}

package fr.univartois.butinfo.sae301.opetriplet{
class Point {
    - trip: Triplet
    - color: Color
    + Point(double, double, double, Color)
    + getTrip(): Triplet
    + subtraction(Point): Vector
    + multiplicationScailary(double): Point
    + subtractionVec(Vector): Point
    + getColor(): Color
}
}

package fr.univartois.butinfo.sae301.lights{
class PointLight {
    - position: Point
    + PointLight(Point, Color)
    + getType(): LightType
    + getPosition(): Point
}
}

package fr.univartois.butinfo.sae301.createscene{
class Scene {
    - imageWidth: int
    - imageHeight: int
    - outputFileName: String
    - camera: Camera
    - shadow: IShadowStrategy
    - lights: List<Light>
    - sceneObjects: List<ISceneObject>
    + Scene(SceneBuilder)
    + Scene(int, int, String, Camera, List<Light>, List<ISceneObject>)
    + Scene(int, int)
    + Scene()
    + getImageWidth(): int
    + setImageWidth(int): void
    + getImageHeight(): int
    + setImageHeight(int): void
    + getOutputFileName(): String
    + setOutputFileName(String): void
    + getCamera(): Camera
    + setCamera(Camera): void
    + getLights(): List<Light>
    + setLights(List<Light>): void
    + getSceneObjects(): List<ISceneObject>
    + setSceneObjects(List<ISceneObject>): void
    + addLight(Light): void
    + addSceneObject(ISceneObject): void
    + toString(): String
    + getShadow(): IShadowStrategy
    + setShadow(IShadowStrategy): void
}
}

package fr.univartois.butinfo.sae301.createscene{
class SceneBuilder {
    - imageWidth: int
    - imageHeight: int
    - outputFileName: String
    - camera: Camera
    - shadow: IShadowStrategy
    - lights: List<Light>
    - sceneObjects: List<ISceneObject>
    + newInstance(): SceneBuilder
    + setImageWidth(int): SceneBuilder
    + setImageHeight(int): SceneBuilder
    + setOutputFileName(String): SceneBuilder
    + setCamera(Camera): SceneBuilder
    + addLight(Light): SceneBuilder
    + addSceneObject(ISceneObject): SceneBuilder
    + getImageWidth(): int
    + getImageHeight(): int
    + getOutputFileName(): String
    + getCamera(): Camera
    + getLights(): List<Light>
    + getSceneObjects(): List<ISceneObject>
    + getShadow(): IShadowStrategy
    + setShadow(IShadowStrategy): void
    + build(): Scene
}
}

package fr.univartois.butinfo.sae301.shadow{
class ShadowStrategy {
    + isShadowed(Point, List<Light>, List<ISceneObject>): boolean
}
}

package fr.univartois.butinfo.sae301.objects{
class Sphere {
    - pos: Point
    - radius: double
    - color: Color
    + Sphere(Point, Color, double)
    + getOrigin(): Point
    + getPos(): Point
    + setPos(Point): void
    + getRadius(): double
    + setRadius(double): void
    + getColor(): Color
    + setColor(Color): void
    + intersect(Point, Vector): double
    + toString(): String
}
}

package fr.univartois.butinfo.sae301.objects{
class Triangle {
    - point1: Point
    - point2: Point
    - point3: Point
    - color: Color
    + Triangle(Color, Point, Point, Point)
    + getOrigin(): Point
    + getPoint1(): Point
    + setPoint1(Point): void
    + getPoint2(): Point
    + setPoint2(Point): void
    + getPoint3(): Point
    + setPoint3(Point): void
    + getColor(): Color
    + setColor(Color): void
    + intersect(Point, Vector): double
}
}

package fr.univartois.butinfo.sae301.opetriplet{
class Vector {
    - trip: Triplet
    + Vector(double, double, double)
    + getTrip(): Triplet
    + add(Vector): Vector
    + add(Point): Point
    + subtraction(Vector): Vector
    + multiplicationScailary(double): Vector
    + scalarProduct(Vector): double
    + vectorProduct(Triplet): Vector
    + length(): double
    + normalize(): Vector
}
}

package fr.univartois.butinfo.sae301.opetriplet{
class Triplet{
 - double x
 - double y
 - double z
 + Triplet(double x, double y, double z)
 + getX() : double
 + getY() : double
 + getZ() : double
 + add(Triplet t): Triplet
 + subtraction(Triplet t): Triplet
 + multiplicationScalary(double d) : Triplet
 + scalarProduct(Triplet t): double
 + vectorProduct(Triplet t): Triplet
 + shurProduct(Triplet t): Triplet
 + length(): double
 + normalize(): Triplet
 + toString() : String
}
}

package fr.univartois.butinfo.sae301.opetriplet{
class Color {
  - red: double
  - green: double
  - blue: double
  - alpha: double
  + Color(red: double, green: double, blue: double, alpha: double)
  + getRed(): double
  + getGreen(): double
  + getBlue(): double
  + getAlpha(): double
  + setRed(red: double)
  + setGreen(green: double)
  + setBlue(blue: double)
  + setAlpha(alpha: double)
  + toString(): String
}
}

package fr.univartois.butinfo.sae301.creationpicture{
class BasicStrategy {
  - BasicStrategy()
  + calculateColor(normal: Vector, light: List<Light>, intersectionPoint: Point, object: ISceneObject): Color
}
}

package fr.univartois.butinfo.sae301.createscene{
class Camera {
  - lookFrom: Point
  - lookAt: Point
  - up: Vector
  - fov: int
  + Camera(lookFrom: Point, lookAt: Point, up: Vector, fov: int)
  + getLookFrom(): Point
  + setLookFrom(lookFrom: Point): void
  + getLookAt(): Point
  + setLookAt(lookAt: Point): void
  + getUp(): Vector
  + setUp(up: Vector): void
  + getFov(): int
  + setFov(fov: int): void
}
}

package fr.univartois.butinfo.sae301.lights{
class DirectionalLight {
  - direction: Vector
  + DirectionalLight(direction: Vector, color: Color)
  + getType(): LightType
  + getDirection(): Vector
}
}

package fr.univartois.butinfo.sae301.creationpicture{
interface IColorStrategy {
  + calculateColor(normal: Vector, light: List<Light>, intersectionPoint: Point, object: ISceneObject): java.awt.Color
}
}

package fr.univartois.butinfo.sae301.objects{
interface ISceneObject {
  + getOrigin(): Point
  + intersect(p: Point, d: Vector): double
  + getColor(): Color
}
}

package fr.univartois.butinfo.sae301.shadow{
interface IShadowStrategy {
  + isShadowed(intersection: Point, lights: List<Light>, sceneObjects: List<ISceneObject>): boolean
}
}

package fr.univartois.butinfo.sae301.creationpicture{
class LambertMethodStrategy {
  +CalculateLd(normal: Vector, lights: List<Light>, intersectionPoint: Point): Color
  +calculateColor(normal: Vector, lights: List<Light>, intersectionPoint: Point, object: ISceneObject): Color
}
}

package fr.univartois.butinfo.sae301.lights{
abstract class Light {
  - direction: Vector
  - color: Color
  + getColor() : Color
  + Light(color: Color)
  + abstract getType() : LightType
  + getColorFromLight() : Color
}
}

package fr.univartois.butinfo.sae301.lights{
enum LightType {
  DIRECTIONAL
  POINT
}
}

package fr.univartois.butinfo.sae301.main{
class Main {
  + main(args: String[]): void
}
}

package fr.univartois.butinfo.sae301.creationpicture{
class CreatePicture {
  - imgWidth: int
  - imgHeight: int
  - lookAt: Point
  - lookFrom: Point
  - fov: double
  - up: Vector
  - sceneObjects: List<ISceneObject>
  - name: String
  - lights: List<Light>
  - shadowStrategy: IShadowStrategy
  - fovr: double
  - realHeight: double
  - pixelHeight: double
  - realWidth: double
  - pixelWidth: double
  + CreatePicture(scene: Scene)
  + littleA(i: int): double
  + littleB(j: int): double
  + calcul(i: int, j: int, up: Vector): Vector
  + getMyImage(): BufferedImage
}
}

IColorStrategy <|.. BasicStrategy

Color --> Triplet: trip

CreatePicture --> Point: lookAt
CreatePicture --> Point: lookFrom
CreatePicture --> Vector: up
CreatePicture --> ISceneObject: sceneObjects
CreatePicture --> Light: lights
CreatePicture --> IShadowStrategy: shadowStrategy

DirectionalLight --|> Light: extends
DirectionalLight --> Vector: direction
DirectionalLight --> Color: color
Light --> Vector: direction
Light --> Color: color

IColorStrategy ..> Vector: normal
IColorStrategy ..> Point: intersectionPoint
IColorStrategy ..> ISceneObject: object

DirectionalLight --|> Light: extends
PointLight --|> Light: extends
java.awt.Color --|> Color: extends
Color --|> Color: extends

Light --> Vector: direction
Light --> Color: color
LightType --|> Enum: extends

DirectionalLight --|> Light: extends
PointLight --|> Light: extends

Main --> Parser: creates
Main --> CreatePicture: creates

Parser --> File: reads

NoShadowStrategy --|> IShadowStrategy

Parser --|> Camera
Parser --> Scene: Creates

Plane --|> ISceneObject: Implements

SceneBuilder --|> Scene: Builds
SceneBuilder --|> Scene: Builds

ShadowStrategy --|> IShadowStrategy
DirectionalLight --|> Light: Extends
PointLight --|> Light: Extends

Sphere --|> ISceneObject

Triangle --|> ISceneObject

PointLight --> Point : position
@enduml
