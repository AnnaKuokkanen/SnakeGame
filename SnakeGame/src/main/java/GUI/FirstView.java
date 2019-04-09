
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class FirstView {
    
    public Scene getScene() {
        
        Button btn = new Button();
        btn.setText("START");
        
        FlowPane components = new FlowPane();
        components.getChildren().add(btn);
        Scene scene = new Scene(components);
        
        return scene;
    }

}
