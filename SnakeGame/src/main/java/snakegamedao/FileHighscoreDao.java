
package snakegamedao;

import gui.FirstView;
import gui.ThirdView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FileHighscoreDao implements SnakeGameDao {
    
    private Map<String, Integer> names;
    private File file;
    
    public FileHighscoreDao(String fileName) throws Exception {
        this.names = new HashMap<>();
        this.file = new File(fileName);
        //get everything from old file and put them on the names-hashmap
        try {
            Scanner reader = new Scanner(this.file);
            while(reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(":");
                names.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    @Override
    public void create(String name, int score) throws Exception {
        names.put(name, score);
        System.out.println(name + ":" + score);
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
    public void update(String name, int score) throws Exception {
        int oldScore = names.get(name);
        if(oldScore < score) {
            names.remove(name);
            names.put(name, score);
            write(name, score);
        }
    }
    
    public void write(String name, int score) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.file))) {
            for (String n : names.keySet()) {
                bw.write(n + ":" + names.get(n));
                bw.newLine();
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}