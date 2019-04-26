
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class FirstView {
    
    private Button btn;
    private String name;
    private TextField field;
    
    public FirstView() {
        this.btn = new Button("START");
        this.field = new TextField();
    }
    
    public Scene getScene() {
        this.name = field.getText();
        
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
        return this.name;
    }

}
