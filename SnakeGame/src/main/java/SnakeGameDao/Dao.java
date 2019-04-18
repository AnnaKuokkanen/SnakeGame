
package SnakeGameDao;

import java.sql.*;
import java.util.*;

public interface Dao<O,K> {
    void create(O object) throws SQLException;
    O read(K key) throws SQLException;
    O update(O object) throws SQLException;
    void delete(K key) throws SQLException;
    List<O> list() throws SQLException;
}
