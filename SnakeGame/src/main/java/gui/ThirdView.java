
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 This represents last view in the game from which is possible to continue playing or exit.
 */
public class ThirdView {
    
    private Button btn1;
    private Button btn2;
    private Label text;
    private Label text2;
    private Label best1;
    
    public ThirdView() {
        this.text = new Label("Game over!");
        this.text2 = new Label();
        this.btn1 = new Button("Play again");
        this.btn2 = new Button("Exit");
        this.best1 = new Label();
    }
    
    public Scene getScene() {
        GridPane components = new GridPane();
        components.add(text, 3, 0);
        components.add(text2, 3, 1);
        components.add(best1, 3, 3);
        components.add(btn1, 1, 8);
        components.add(btn2, 5, 8);
        
        Scene scene = new Scene(components);
        
        return scene;
    }
    public Button getFirstButton() {
        return btn1;
    }
    
    public Button getSecondButton() {
        return btn2;
    }
    
    public void setScoreText(int score) {
        this.text2.setText("Your score: " + score);
    }
}
