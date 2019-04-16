
package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import GUI.SnakeGraphics;
import SnakeGameLogic.Snake;
import GUI.SnakeGraphics;

public class SecondView {

    public Scene getScene() {
        SnakeGraphics sg = new SnakeGraphics();
        return sg.getScene();
    }
}
