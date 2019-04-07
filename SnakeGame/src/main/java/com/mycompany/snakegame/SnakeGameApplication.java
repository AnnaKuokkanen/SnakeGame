
package com.mycompany.snakegame;

import javafx.stage.Stage;
import javafx.application.Application;
import com.mycompany.snakegame.FirstView;
import com.mycompany.snakegame.SecondView;
import com.mycompany.snakegame.ThirdView;

public class SnakeGameApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        launch(FirstView.class);
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
