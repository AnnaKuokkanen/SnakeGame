
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import gui.SnakeGraphics;
import snakegamelogic.Snake;
import gui.SnakeGraphics;

public class SecondView {
    
    private SnakeGraphics sg;
    
    public SecondView() {
        this.sg = new SnakeGraphics();
    }

    public Scene getScene() {
        return sg.getScene();
    }
    public Button getButton() {
        return sg.getButton();
    }
    public void setup() {
        sg.setup();
    }
    public int getScore() {
        return sg.getScore();
    }
}
