
package gui;

import javafx.stage.Stage;
import javafx.application.Application;
import gui.FirstView;
import gui.SecondView;
import gui.ThirdView;
import snakegamedao.FileHighscoreDao;
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
    
    private int run;
    private int score;
    private String name;
    
    private FileHighscoreDao dao;
    
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
        
        this.run = 0;
        
        try {
            this.dao = new FileHighscoreDao("highscore.txt");
        } catch (Exception e) {
            System.out.println("Error: " +  e.getMessage());
        }
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Snake Game");
        
        stage.setScene(scene1);  
        
        
        btn1.setOnAction((event) -> {
            this.name = first.getText().trim();
            run++;
            if (run == 1) {
                stage.setScene(scene2);
            } else {
                second.setup();
                Scene newScene = second.getScene();
                stage.setScene(newScene);
            } 
       });
        btn4.setOnAction((event) -> {
            this.score = second.getScore();
            third.setScoreText(score);
            stage.setScene(scene3);
            
            try {
                if (dao.containsName(name) == -1 && !this.name.equals("")) {
                    dao.create(name, score);
                } 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
        
        btn2.setOnAction((event) -> {
            second.setup();
            Scene newScene = second.getScene();
            stage.setScene(newScene);
        });
        
        btn3.setOnAction((event) -> {
            first.clearText();
            Scene newScene = first.getScene();
            stage.setScene(newScene);
        });    
        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(SnakeGameApplication.class);
    }
}
