
package gui;

import javafx.stage.Stage;
import javafx.application.Application;
import gui.FirstView;
import gui.SecondView;
import gui.ThirdView;
import gui.SnakeGraphics;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SnakeGameApplication extends Application {
    
    private FirstView first;
    private SecondView second;
    private ThirdView third;
    
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    
    public SnakeGameApplication() {
        
        this.first = new FirstView();
        this.second = new SecondView(); 
        this.third = new ThirdView();
        
        this.scene1 = first.getScene();
        this.scene2 = second.getScene();
        this.scene3 = third.getScene();
        
        this.btn1 = first.getButton(); //from first to second
        this.btn4 = second.getButton(); //from second to third
        this.btn2 = third.getFirstButton(); //from third to second
        this.btn3 = third.getSecondButton(); //from third to first
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Snake Game");

        stage.setScene(scene1);
        
        btn1.setOnAction((event) -> {
            //second.setup();
            stage.setScene(scene2);
        });
        
        btn4.setOnAction((event) -> {
            int score = second.getScore();
            third.setScoreText(score);
            stage.setScene(scene3);
        });
        
        btn2.setOnAction((event) -> {
            second.setup();
            stage.setScene(second.getScene());
        });
        
        btn3.setOnAction((event) -> {
            stage.setScene(first.getScene());
        });
            
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
    
}
