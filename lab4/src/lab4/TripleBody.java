package lab4;

import java.awt.Container;
import javax.media.j3d.*; // for transform
import javax.vecmath.Color3f;
import java.awt.Color;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*; // for Vector3f
import com.sun.j3d.utils.image.TextureLoader;

public class TripleBody {

    public static Cylinder getBase() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.4f, 1.0f, primflags, getBaseAppearence());
    }
    
    public static Cylinder getHole() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.07f, 0.000001f, primflags, getHoleAppearence());
    }
    
    public static Cylinder getStick() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.07f, 0.8f, primflags, getStickAppearence());
    }
    
    public static Cylinder getBorderCylinder() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.05f, 0.3f, primflags, getBaseAppearence());
    }

    
    private static Appearance getBaseAppearence() {
    	TextureLoader loader = new TextureLoader("source_folder\\base.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(200,200, 200));
        Color3f diffuse = new Color3f();
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
    
    private static Appearance getHoleAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\hole.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(0,0, 00));
        Color3f diffuse = new Color3f();
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
    
    private static Appearance getStickAppearence() {
        TextureLoader loader = new TextureLoader("source_folder\\stick.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(100, 100, 100));
        Color3f diffuse = new Color3f(Color.white);
        Color3f specular = new Color3f(new Color(0,0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }
}