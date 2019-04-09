
package GUI;

import javafx.stage.Stage;
import javafx.application.Application;
import GUI.FirstView;
import GUI.SecondView;
import GUI.ThirdView;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SnakeGameApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        FirstView first = new FirstView();
        SecondView second = new SecondView();
        ThirdView third = new ThirdView(); 
        
        Scene scene1 = first.getScene();
        Scene scene2 = second.getScene();
        Scene scene3 = third.getScene();
        
        Button btn = first.getButton();
        /*btn.setOnAction((event) -> {
            SecondView second = new SecondView();
            Scene scene = second.getScene();
            stage.setScene(scene);
            stage.show();
        });*/
        stage.setScene(scene1);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
