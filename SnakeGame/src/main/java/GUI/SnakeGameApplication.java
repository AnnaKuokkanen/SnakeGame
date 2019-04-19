
package GUI;

import javafx.stage.Stage;
import javafx.application.Application;
import GUI.FirstView;
import GUI.SecondView;
import GUI.ThirdView;
import GUI.SnakeGraphics;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SnakeGameApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Snake Game");
        FirstView first = new FirstView();
        SecondView second = new SecondView();
        ThirdView third = new ThirdView(); 
        SnakeGraphics sg = new SnakeGraphics();
        //boolean stopped = sg.collisionWall();
        
        Scene scene1 = first.getScene();
        Scene scene2 = second.getScene();
        Scene scene3 = third.getScene();
        
        Button btn1 = first.getButton();
        Button btn2 = third.getFirstButton();
        Button btn3 = third.getSecondButton();

        stage.setScene(scene1);
        
        btn1.setOnAction((event) -> {
            stage.setScene(scene2);
        });
        
        /*if(stopped) {
            stage.setScene(scene3);
        }*/
        
        btn2.setOnAction((event) -> {
            stage.setScene(scene2);
        });
        btn3.setOnAction((event) -> {
            stage.setScene(scene1);
        });
            
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
