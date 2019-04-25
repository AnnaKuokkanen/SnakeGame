
package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ThirdView {
    
    private Button btn1;
    private Button btn2;
    private Label text;
    private Label text2;
    
    public ThirdView() {
        this.text = new Label("Game over!");
        this.text2 = new Label();
    }
    
    public Scene getScene() {
        this.btn1 = new Button();
        this.btn2 = new Button();
        btn1.setText("Play again");
        btn2.setText("Exit");
                
        GridPane components = new GridPane();
        components.add(text, 3, 0);
        components.add(text2, 3, 1);
        components.add(btn1, 1, 2);
        components.add(btn2, 5, 2);
        
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
