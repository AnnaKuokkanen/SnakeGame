
package com.mycompany.snakegame;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class ThirdView {
    
    public Scene getScene() {
        Label text = new Label("Game over!");
        Button btn1 = new Button();
        Button btn2 = new Button();
        btn1.setText("Play again");
        btn2.setText("Exit");
                
        FlowPane components = new FlowPane();
        components.getChildren().add(text);
        components.getChildren().add(btn1);
        components.getChildren().add(btn2);
        
        Scene scene = new Scene(components);
        
        return scene;
    }
    
}
