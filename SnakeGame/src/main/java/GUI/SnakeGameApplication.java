
package GUI;

import javafx.stage.Stage;
import javafx.application.Application;
import GUI.FirstView;
import javafx.scene.Scene;

public class SnakeGameApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setScene(FirstView.getScene());
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
