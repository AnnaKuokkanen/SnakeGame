
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import SnakeGameLogic.Snake;
import SnakeGameLogic.Score;
import SnakeGameLogic.Food;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SnakeGraphics {
   
    private Circle food;
    private Rectangle snake;
    private Snake snakeLogic;
    private Score score;
    private Food foodLogic;
    private Map<KeyCode, Boolean> pressedButtons;
    
    public SnakeGraphics() {
        this.pressedButtons = new HashMap<>();
        this.score = new Score();
    }
    
    public Scene getScene() {
        
        Pane board = new Pane();
        board.setPrefSize(900,600);
        setSnake(30,50);
        setFood(10,10);
        board.getChildren().add(this.snake);
        board.getChildren().add(this.food);
        
        Scene scene = new Scene(board);
        
        scene.setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            @Override 
            public void handle(long now) {
                if(pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                    snake.setTranslateX(snakeLogic.getX().get(0)-1);
                    snake.setTranslateY(snakeLogic.getY().get(0));
                    snakeLogic.moveLeft();
                }
                if(pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                    snake.setTranslateX(snakeLogic.getX().get(0)+1);
                    snake.setTranslateY(snakeLogic.getY().get(0));
                    snakeLogic.moveRight();
                }
                if(pressedButtons.getOrDefault(KeyCode.UP, false)) {
                    snake.setTranslateX(snakeLogic.getX().get(0));
                    snake.setTranslateY(snakeLogic.getY().get(0)-1);
                    snakeLogic.moveUp();
                }
                if(pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
                    snake.setTranslateX(snakeLogic.getX().get(0));
                    snake.setTranslateY(snakeLogic.getY().get(0)+1);
                    snakeLogic.moveDown();
                }
                if(collisionFood()) {
                    score.addScore();
                    moveFood();
                }
                if(collision()) {
                    stop();
                }
            }
        }.start();
        
        return scene; 
    }
    
    public void setSnake(int i, int j) {
        this.snake = new Rectangle(i,j,10,10);
        this.snake.setTranslateX(i);
        this.snake.setTranslateY(j);
        this.snakeLogic = new Snake(i,j);
    }
    
    public Rectangle getSnake() {
        return this.snake;
    }
    
    public void setFood(int i, int j) {
        this.food = new Circle(i,j,5);
        this.foodLogic = new Food(i,j);
    }
    
    public Circle getFood() {
        return this.food;
    }
    
    public void moveFood() {
        Random rand = new Random();
        int x = rand.nextInt(850);
        int y = rand.nextInt(550);
        
        setFood(x,y);
    }
    
    public boolean collisionFood() {
        if(snakeLogic.collision2(foodLogic.getX(),foodLogic.getY())) {
            return true;
        }
        return false;
    }
    
    public boolean collision() {
        if(snakeLogic.getX().get(0)<0 || snakeLogic.getY().get(0)<0 || snakeLogic.getX().get(0)>900 || snakeLogic.getY().get(0)>600) {
            return true;
        }
        return false;
    }
    
}