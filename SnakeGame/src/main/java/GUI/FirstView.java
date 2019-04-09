
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class FirstView {
    
    public Scene getScene() {
        TextField field = new TextField();
        Button btn = new Button();
        btn.setText("START");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(btn);
        components.getChildren().add(field);
        Scene scene = new Scene(components);
        
        return scene;
    }

}
