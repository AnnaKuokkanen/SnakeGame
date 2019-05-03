
package snakegamedao;

import gui.FirstView;
import gui.ThirdView;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FileHighscoreDao implements SnakeGameDao {
    
    private Map<String, Integer> names;
    private String file;
    private Scanner reader;
    private FileWriter writer;
    
    public FileHighscoreDao(String file) throws Exception {
        this.names = new HashMap<>();
        this.file = file;
        
        /*try {
            Scanner reader = new Scanner(this.file);
            while(reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(":");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }*/
    }
    
    @Override
    public void create(String name, int score) throws Exception {
        names.put(name, score);
        write(name, score);
    }
    
    @Override
    public int containsName(String name) {
        for (String n : names.keySet()) {
            if(n.equals(name)) {
                return names.get(name);
            }
        }
        return -1;
    }
    
    @Override 
    public void update(String name, int score) {
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(":");
                if (parts[0].equals(name)) {
                    int newScore = Integer.parseInt(parts[1]);
                    names.put(parts[0], newScore);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void write(String name, int score) throws Exception {
        try (FileWriter fw = new FileWriter(this.file)) {
            fw.write(name + ":" + score + "\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
