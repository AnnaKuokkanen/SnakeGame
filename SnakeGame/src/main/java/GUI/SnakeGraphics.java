
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import com.mycompany.snakegame.Snake;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SnakeGraphics {
   
    private Circle food;
    private Rectangle snake;
    
    public Scene getScene() {
        
        Pane board = new Pane();
        board.setPrefSize(300,200);
        setSnake(30,50);
        setFood(10,10);
        board.getChildren().add(this.snake);
        board.getChildren().add(this.food);
        
        Scene scene = new Scene(board);
        
        return scene; 
    }
    
    public void setSnake(int i, int j) {
        this.snake = new Rectangle(i,j,10,10);
    }
    
    public Rectangle getSnake() {
        return this.snake;
    }
    
    public void setFood(int i, int j) {
        this.food = new Circle(i,j,5);
    }
    
    public Circle getFood() {
        return this.food;
    }
}
