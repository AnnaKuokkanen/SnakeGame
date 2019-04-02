
package com.mycompany.snakegame;

import javafx.stage.Stage;
import javafx.application.Application;

public class SnakeGameApplication extends Application {
    
     @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Snake game");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
