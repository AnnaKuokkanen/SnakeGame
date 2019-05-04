package snakegamedao;

import java.util.List;

public interface SnakeGameDao {
    
    void create(String name, int score) throws Exception;
    
    int containsName(String name);
    
    void update(String name, int score) throws Exception;
}
