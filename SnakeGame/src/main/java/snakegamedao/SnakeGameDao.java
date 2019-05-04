package snakegamedao;

import java.util.Map;

public interface SnakeGameDao {
    
    void create(String name, int score) throws Exception;
    
    int containsName(String name);
    
    void update(String name, int score) throws Exception;
    
    void write(String name, int score) throws Exception; 
    
    Map<String, Integer> getNames();
}
