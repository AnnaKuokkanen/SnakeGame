
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import GUI.SnakeGraphics;
import com.mycompany.snakegame.Snake;

public class SecondView {

    public Scene getScene() {
        
        Pane board = new Pane();
        board.setPrefSize(300,200);
        board.getChildren().add(new SnakeGraphics(new Snake(30, 50)));
        
        Scene scene = new Scene();
        return scene;
    }
    
}
