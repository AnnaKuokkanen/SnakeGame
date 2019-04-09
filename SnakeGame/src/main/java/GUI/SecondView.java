
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import com.mycompany.snakegame.Snake;
import com.mycompany.snakegame.Snake;

public class SecondView {

    public Scene getScene() {
        
        Pane board = new Pane();
        board.setPrefSize(300,200);
        board.getChildren().add(new Snake(30,50));
        
        Scene scene = new Scene();
        return scene;
    }
    
}
