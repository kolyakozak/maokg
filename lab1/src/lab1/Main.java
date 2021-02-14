package lab1;
 
import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.*;

public class Main extends Application {
	public double centerX = 150;
	public double centerY = 150;
	public double radius = 40;
       
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("maokg-lab1");
        
        Group root = new Group();
        Scene scene = new Scene(root, 600, 300); 
        scene.setFill(Color.rgb(255, 215, 0));
        
        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(new Double[] {
        	centerX - 100.0, centerY - 125.0,
        	centerX - 50.0, centerY,
        	centerX - 100.0, centerY + 125.0,
        	centerX + 100.0, centerY
        });
        polygon1.setFill(Color.BLUE);
        root.getChildren().add(polygon1);   
        
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.RED);
        root.getChildren().add(circle);
        
        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(new Double[] {
    		centerX + 380.0, centerY + 50.0,
        	centerX + 310.0, centerY,
        	centerX + 380.0, centerY - 50.0,
        	centerX + 350.0, centerY,
        });  
        polygon2.setFill(Color.BLUE);
        root.getChildren().add(polygon2); 
        
        for(int i = 0; i < 7; i++) {
        	Line l = new Line(centerX - 20, centerY - 18 + i*6, centerX + 340, centerY - 18 + i*6);
        	root.getChildren().add(l);
        }
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}