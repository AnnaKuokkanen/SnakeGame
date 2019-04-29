
package snakegamelogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database {
    private Highscore highscore;
    private String[] bestPlayers;
    private int[] bestScores;
    
    public Database(String name, int score) {
        this.highscore = new Highscore(name, score);
        this.bestPlayers = new String[3];
        this.bestScores = new int[3];
    }
    
    public void write(String name, int score) throws Exception {
        FileWriter writer = new FileWriter("highscore.txt");
        try {
            if (read(name) == -1) {
                writer.write(name + ":" + score);
            } else {
                if (score > read(name)) {
                    writer.write(name + ":" + score);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
   
    public int read(String name) throws Exception {
        //if this returns >=0, the name is already in the file
        Scanner reader = new Scanner("highscore.txt");
        try {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(":");
                if (data[0].equals(name)) {
                    int hs = Integer.parseInt(data[1]);
                    return hs;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }
    
    public int[] getBestScores() {
        return bestScores;
    }
    
    public String[] getBestPlayers() {
        return bestPlayers;
    }
    
    public void bestScores() {
        Scanner reader = new Scanner("highscore.txt");
    }
    
    public void bestPlayers() {
       
    }
}
