
package snakegamedaotest;

import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import snakegamedao.FileHighscoreDao;
import snakegamedao.SnakeGameDao;

public class FileHighscoreDaoTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File hsFile;
    SnakeGameDao dao;
    
    @Before
    public void setUp() throws Exception {
        hsFile = testFolder.newFile("testfile_highscore.txt");
        dao = new FileHighscoreDao(hsFile.getAbsolutePath());
        
        try {
            dao.create("anna", 2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @Test
    public void playerIsCreated() {
        assertEquals(true, dao.getNames().keySet().contains("anna"));
        assertEquals(2, (int) dao.getNames().get("anna"));
    }
    
    @Test
    public void scoreIsUpdatedIfBigger() throws Exception {
        dao.update("anna", 3);
        assertEquals(3, (int) dao.getNames().get("anna"));
    }
    
    @Test
    public void scoreIsNotUpdatedIfNotBigger() throws Exception {
        dao.update("anna", 1);
        assertEquals(2, (int) dao.getNames().get("anna"));
    }
    
    @Test
    public void containsNameIsWorking() {
        assertEquals(-1, (int) dao.containsName("user99"));
        assertEquals(2, (int) dao.containsName("anna"));
    }
    
    @After
    public void tearDown() {
        hsFile.delete();
    }

}
