
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 This is the first view in the game. It has a text field and a button to start the game.
 */
public class FirstView {
    
    private Button btn;
    private TextField field;
    
    public FirstView() {
        this.btn = new Button("START");
        this.field = new TextField();
    }
    
    public Scene getScene() {
        FlowPane components = new FlowPane();
        components.getChildren().add(btn);
        components.getChildren().add(field);
        Scene scene = new Scene(components);
        
        return scene;
    }
    
    public Button getButton() {
        return this.btn;
    }
    
    public String getText() {
        return field.getText();
    }
    
    /**
     Empties old name from text field.
     */
    public void clearText() {
        this.field.clear();
    }

}
