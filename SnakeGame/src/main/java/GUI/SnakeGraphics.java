
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import com.mycompany.snakegame.Snake;
import javafx.scene.shape.Circle;

public class SnakeGraphics {
   
    private Circle food;
    private Polygon snake;
    
    public Scene getScene() {
        Scene scene = new Scene();
        
        return scene; 
    }
    
    public void setSnake(int i, int j) {
        this.snake = new Polygon(i,j,100, 0, 100, 50, 0, 50);
    }
    
    public Polygon getSnake() {
        return this.snake;
    }
    
    public void setFood(int i, int j) {
        this.food = new Circle(30, 50, 10);
    }
    
    public Circle getFood() {
        return this.food;
    }
}
