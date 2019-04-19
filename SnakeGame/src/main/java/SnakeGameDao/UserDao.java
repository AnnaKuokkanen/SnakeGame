
package SnakeGameDao;

import java.sql.*;
import java.util.*;

public class UserDao implements Dao<Integer, String>{
    @Override
    public void create(Integer i) throws SQLException {
    
    }
    
    @Override
    public Integer read(String s) throws SQLException {
        return 0;
    }
    
    @Override
    public Integer update(Integer i) throws SQLException {
        return 0;
    }
    
    @Override
    public void delete(String s) throws SQLException {
    
    }
    @Override
    public List<Integer> list() throws SQLException{
        return new ArrayList<Integer>();
    }
}
