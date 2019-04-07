
package com.mycompany.snakegame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.mycompany.snakegame.SecondView;

public class FirstView extends Application {
    
    @Override
    public void start(Stage stage) {
        Button btn = new Button();
        btn.setText("START");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                launch(SecondView.class);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
    }
    
    /*public static void main(String[] args) {
        launch(args);
    }*/
    
}
