package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

import java.lang.Math;

public class Triple implements ActionListener {
    private TransformGroup carTransformGroup = new TransformGroup();
    private Transform3D carTransform3D = new Transform3D();
    private Timer timer;
    private float angle= 0;

    public static void main(String[] args) {
        new Triple();
    }

    private Triple() {
        timer = new Timer(50, this);
        timer.start();
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse();
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);
    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        carTransformGroup = new TransformGroup();
        carTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        buildCastleSkeleton();
        objRoot.addChild(carTransformGroup);

        Background background = new Background(new Color3f(0.0f, 0.0f, 0.0f));
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        objRoot.addChild(background);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 0.5f, 0.4f);
        Vector3f light1Direction = new Vector3f(.8f, .8f, .0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void buildCastleSkeleton() {
		Cylinder body1 = TripleBody.getBase();
		Transform3D body1T = new Transform3D();
		body1T.setTranslation(new Vector3f(.0f, -0.3f, .0f));
		TransformGroup body1TG = new TransformGroup();
		body1TG.setTransform(body1T);
		body1TG.addChild(body1);
		carTransformGroup.addChild(body1TG);
		
		createBorderX(0.35f, 0.f, -0.3f, 0.51f);
		createBorderX(0.35f, 0.f, -0.3f, -0.51f);
		
		createBorderY(0.35f, 0.f, 0.2f, 0.f);
		createBorderY(0.35f, 0.f, -0.8f, 0.f);
		
		Cylinder body2 = TripleBody.getBase();
		Transform3D body2T = new Transform3D();
		body2T.rotX(Math.PI/2);
		body2T.setTranslation(new Vector3f(.0f, -0.3f, .0f));
		TransformGroup body2TG = new TransformGroup();
		body2TG.setTransform(body2T);
		body2TG.addChild(body2);
		carTransformGroup.addChild(body2TG);
    	
        createHole(.17f, -0.3f, .51f);
        createHole(-.17f, -0.3f, .51f);
        createHole(.17f, -0.3f, -.51f);
        createHole(-.17f, -0.3f, -.51f);
        
        createStick(.17f, 0.4f, .0f);
        createStick(-.17f, 0.4f, .0f);
    }

    private void createHole(float x, float y, float z) {
        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        transform.rotX(Math.PI/2);
        Cylinder hole = TripleBody.getHole();
        Vector3f vector = new Vector3f(x, y, z);
        transform.setTranslation(vector);
        tg.setTransform(transform);
        tg.addChild(hole);
        carTransformGroup.addChild(tg);
    }
    
    private void createStick(float x, float y, float z) {
        TransformGroup tg = new TransformGroup();
        Transform3D transform = new Transform3D();
        Cylinder stick = TripleBody.getStick();
        Vector3f vector = new Vector3f(x, y, z);
        transform.setTranslation(vector);
        tg.setTransform(transform);
        tg.addChild(stick);
        carTransformGroup.addChild(tg);
    }
    
    private void createBorderX(float radius, float x, float y, float z) {
    	for(int i = 0; i < 360; i += 5) {
    		TransformGroup tg = new TransformGroup();
            Transform3D transform = new Transform3D();
            transform.rotX(Math.PI/2);
            Cylinder bc = TripleBody.getBorderCylinder();
            float xC = (float) (x + radius*Math.cos(Math.toRadians(i)));
            float yC = (float) (y + radius*Math.sin(Math.toRadians(i)));
            Vector3f vector = new Vector3f(xC, yC, z);
            transform.setTranslation(vector);
            tg.setTransform(transform);
            tg.addChild(bc);
            carTransformGroup.addChild(tg);
    	}
    }
    
    private void createBorderY(float radius, float x, float y, float z) {
    	for(int i = 0; i < 360; i += 5) {
    		TransformGroup tg = new TransformGroup();
            Transform3D transform = new Transform3D();
            Cylinder bc = TripleBody.getBorderCylinder();
            float xC = (float) (x + radius*Math.cos(Math.toRadians(i)));
            float zC = (float) (z + radius*Math.sin(Math.toRadians(i)));
            Vector3f vector = new Vector3f(xC, y, zC);
            transform.setTranslation(vector);
            tg.setTransform(transform);
            tg.addChild(bc);
            carTransformGroup.addChild(tg);
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carTransform3D.rotY(angle);
        carTransformGroup.setTransform(carTransform3D);
        angle += 0.05;
    }
}
