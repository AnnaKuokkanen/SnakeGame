
package gui;

import javafx.scene.Scene;
import snakegamelogic.Snake;
import snakegamelogic.Score;
import snakegamelogic.Food;
import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SnakeGraphics {
   
    private Circle food;
    private List<Rectangle> snake;
    private Snake snakeLogic;
    private Score score;
    private Food foodLogic;
    private Map<KeyCode, Boolean> pressedButtons;
    private Pane board;
    private Rectangle wall1;
    private Rectangle wall2;
    private Rectangle wall3;
    private Rectangle wall4;
    private Button btn;
    
    public SnakeGraphics() {
        this.pressedButtons = new HashMap<>();
        this.score = new Score();
        this.snake = new ArrayList<>();
        this.board = new Pane();
        board.setPrefSize(900, 600);
        this.btn = new Button("STOP");
        setSnake(30, 50);
        setFood(100, 100);
        setWall(board);
    }
    
    public Scene getScene() {
        board.getChildren().add(this.food);
        for (int i = 0; i < snake.size(); i++) {
            board.getChildren().add(this.snake.get(i));
        }
        
        Scene scene = new Scene(board);
        
        scene.setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            int direction = 0;
            public void move(int i) {
                //0 = down; 1 = left; 2 = up; 3 = right
                //in commentaries other approach (snake moves very fast and animation doesn't stop as supposed to)
                
                
                /*double x = snake.get(0).getX();
                double y = snake.get(0).getY();
                board.getChildren().remove(snake.get(0));
                snake.remove(0);*/
                
                if (i == 0) {
                    snakeLogic.moveDown();
                    for (int j = 0; j < snake.size(); j++) {
                        snake.get(j).setTranslateX(snakeLogic.getX().get(j));
                        snake.get(j).setTranslateY(snakeLogic.getY().get(j) + 1);
                    }
                    //snake.add(0, new Rectangle(x, y+10, 10, 10));
                }
                if (i == 1) {
                    snakeLogic.moveLeft();
                    for (int j = 0; j < snake.size(); j++) {
                        snake.get(j).setTranslateX(snakeLogic.getX().get(j) - 1);
                        snake.get(j).setTranslateY(snakeLogic.getY().get(j));
                    }
                    //snake.add(0, new Rectangle(x-10, y, 10, 10));
                }
                if (i == 2) {
                    snakeLogic.moveUp();
                    for (int j = 0; j < snake.size(); j++) {
                        snake.get(j).setTranslateX(snakeLogic.getX().get(j));
                        snake.get(j).setTranslateY(snakeLogic.getY().get(j) - 1);
                    }
                    //snake.add(0, new Rectangle(x, y-10, 10, 10));
                }
                if (i == 3) {
                    snakeLogic.moveRight();
                    for (int j = 0; j < snake.size(); j++) {
                        snake.get(j).setTranslateX(snakeLogic.getX().get(j) + 1);
                        snake.get(j).setTranslateY(snakeLogic.getY().get(j));
                    }
                    //snake.add(0, new Rectangle(x+10, y, 10, 10));
                }
                //board.getChildren().add(snake.get(snake.size()-1));
            }
            @Override 
            public void handle(long now) {
                if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                    direction = 1;
                }
                if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                    direction = 3;
                }
                if (pressedButtons.getOrDefault(KeyCode.UP, false)) {
                    direction = 2;
                }
                if (pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
                    direction = 0;
                }
                if (collisionFood()) {
                    score.addScore();
                    moveFood(board);
                    grow();
                }
                if (collisionWall()) {
                    board.getChildren().add(btn);
                    stop();
                }
                move(direction);
            }
        }.start();
        return scene; 
    }
    
    public Button getButton() {
        return this.btn;
    }
    
    public void setWall(Pane pane) {
        this.wall1 = new Rectangle(0, 0, 900, 10);
        this.wall2 = new Rectangle(0, 0, 10, 600);
        this.wall3 = new Rectangle(890, 0, 10, 600);
        this.wall4 = new Rectangle(0, 590, 900, 10);
        pane.getChildren().add(wall1);
        pane.getChildren().add(wall2);
        pane.getChildren().add(wall3);
        pane.getChildren().add(wall4);
    }
    
    public void setSnake(int i, int j) {
        this.snake.add(new Rectangle(i, j, 10, 10));
        this.snakeLogic = new Snake(i, j);
    }
    
    public List<Rectangle> getSnake() {
        return this.snake;
    }
    
    public void setFood(int i, int j) {
        this.food = new Circle(i, j, 5);
        this.foodLogic = new Food(i, j);
    }
    
    public Circle getFood() {
        return this.food;
    }
    
    public int getScore() {
        return this.score.getScore();
    }
    
    public void moveFood(Pane pane) {
        Random rand = new Random();
        int x = rand.nextInt(870) - 20;
        int y = rand.nextInt(570) - 40;
        pane.getChildren().remove(this.food);
        setFood(x, y);
        pane.getChildren().add(food);
        foodLogic.setX(x);
        foodLogic.setY(y);
    }
    
    public boolean collisionFood() {
        Shape intersection = Shape.intersect(this.snake.get(0), this.food);
        return intersection.getBoundsInLocal().getWidth() != -1;
    }
    
    public boolean collisionWall() {
        if (snakeLogic.getX().get(0) < -20 || snakeLogic.getY().get(0) < -40 || snakeLogic.getX().get(0) > 850 || snakeLogic.getY().get(0) > 530) {
            return true;
        }
        return false;
    }
    
    public void grow() {
        this.snakeLogic.grow();
        
        double x = snake.get(snake.size() - 1).getX();
        double y = snake.get(snake.size() - 1).getY();
        
        snake.add(new Rectangle(x + 10, y, 10, 10));
        board.getChildren().add(snake.get(snake.size() - 1));
    }
    
    public void setup() {
        board.getChildren().remove(btn);
        this.pressedButtons = new HashMap<>();
        this.score = new Score();
        this.snake = new ArrayList<>();
        this.board = new Pane();
        board.setPrefSize(900, 600);
        setSnake(30, 50);
        setFood(100, 100);
        setWall(board);
    }
}