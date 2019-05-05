
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 This represents the second view in the game and has access to graphics of the actual game.
 */
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
    
    /**
     Allows access to method setup from SnakeGraphics.
     */
    public void setup() {
        sg.setup();
    }
    
    public int getScore() {
        return sg.getScore();
    }
}
