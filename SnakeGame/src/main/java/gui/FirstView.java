
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class FirstView {
    
    private Button btn;
    private String name;
    
    public Scene getScene() {
        TextField field = new TextField();
        this.name = field.getText();
        this.btn = new Button();
        btn.setText("START");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(btn);
        components.getChildren().add(field);
        Scene scene = new Scene(components);
        
        return scene;
    }
    
    public void setup() {
    
    }
    
    public Button getButton() {
        return this.btn;
    }
    
    public String getText() {
        return this.name;
    }

}
