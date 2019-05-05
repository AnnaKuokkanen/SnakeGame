
package snakegamedao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class has methods for storing data into a text file. 
 * It implements an interface called SnakeGameDao. 
 */
public class FileHighscoreDao implements SnakeGameDao {
    
    private Map<String, Integer> names;
    private File file;
    
    /**
     * This constructor has a task of reading previously stored names and scores from given file and add them to names.
     * 
     * @param fileName is a given file where we store data. 
     * @throws Exception
     */
    public FileHighscoreDao(String fileName) throws Exception {
        this.names = new HashMap<>();
        this.file = new File(fileName);
        try {
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(":");
                names.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * This method creates a new user with a unique username.
     * User and score are added to names and are also written into file. 
     * 
     * @param name is username
     * @param score is user's score
     * @throws Exception
     */
    @Override
    public void create(String name, int score) throws Exception {
        names.put(name, score);
        System.out.println(name + ":" + score);
        write();
    }
    
    /**
     * This method checks is username exists. 
     * It returns user's score if username exists and -1 if it does not exist. 
     * 
     * @param name username we are checking.
     * @return either score or -1.
     */
    @Override
    public int containsName(String name) {
        for (String n : names.keySet()) {
            if (n.equals(name)) {
                return names.get(name);
            }
        }
        return -1;
    }
    
    /**
     * Updates existing user's score if new score is better than the old score. 
     * Also calls write-method to make changes to file.
     * 
     * @param name username
     * @param score user's score
     * 
     * @throws Exception
     */
    @Override 
    public void update(String name, int score) throws Exception {
        int oldScore = names.get(name);
        if (oldScore < score) {
            names.remove(name);
            names.put(name, score);
            write();
        }
    }
    
    /**
     * Writes the contents of HashMap names into file given as parameter in the constructor. 
     * 
     * @throws Exception
     */
    @Override
    public void write() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.file))) {
            for (String n : names.keySet()) {
                bw.write(n + ":" + names.get(n));
                bw.newLine();
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @Override
    public Map<String, Integer> getNames() {
        return this.names;
    }
}