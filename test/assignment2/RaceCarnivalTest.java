/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oriengoulding
 */
public class RaceCarnivalTest {
    
    public RaceCarnivalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCategories method, of class RaceCarnival.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        RaceCarnival instance = null;
        String[] expResult = null;
        String[] result = instance.getCategories();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRaceContestant method, of class RaceCarnival.
     */
    @Test
    public void testAddRaceContestant() {
        System.out.println("addRaceContestant");
        RaceContestant contestant = null;
        RaceCarnival instance = null;
        boolean expResult = false;
        boolean result = instance.addRaceContestant(contestant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaceContestant method, of class RaceCarnival.
     */
    @Test
    public void testGetRaceContestant() {
        System.out.println("getRaceContestant");
        int id = 0;
        RaceCarnival instance = null;
        RaceContestant expResult = null;
        RaceContestant result = instance.getRaceContestant(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyContestant method, of class RaceCarnival.
     */
    @Test
    public void testModifyContestant() {
        System.out.println("modifyContestant");
        RaceContestant contestant = null;
        RaceCarnival instance = null;
        RaceContestant expResult = null;
        RaceContestant result = instance.modifyContestant(contestant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContestant method, of class RaceCarnival.
     */
    @Test
    public void testDeleteContestant() {
        System.out.println("deleteContestant");
        int id = 0;
        RaceCarnival instance = null;
        RaceContestant expResult = null;
        RaceContestant result = instance.deleteContestant(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartTime method, of class RaceCarnival.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        int id = 0;
        RaceCarnival instance = null;
        boolean expResult = false;
        boolean result = instance.setStartTime(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinishTime method, of class RaceCarnival.
     */
    @Test
    public void testSetFinishTime() {
        System.out.println("setFinishTime");
        int id = 0;
        RaceCarnival instance = null;
        boolean expResult = false;
        boolean result = instance.setFinishTime(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeTaken method, of class RaceCarnival.
     */
    @Test
    public void testGetTimeTaken() {
        System.out.println("getTimeTaken");
        int id = 0;
        RaceCarnival instance = null;
        double expResult = 0.0;
        double result = instance.getTimeTaken(id);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RaceCarnival.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RaceCarnival instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByTimeTaken method, of class RaceCarnival.
     */
    @Test
    public void testSortByTimeTaken() {
        System.out.println("sortByTimeTaken");
        RaceCarnival instance = null;
        RaceContestant[] expResult = null;
        RaceContestant[] result = instance.sortByTimeTaken();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of winner method, of class RaceCarnival.
     */
    @Test
    public void testWinner() {
        System.out.println("winner");
        RaceCarnival instance = null;
        RaceContestant expResult = null;
        RaceContestant result = instance.winner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFile method, of class RaceCarnival.
     */
    @Test
    public void testLoadFile() {
        System.out.println("loadFile");
        String inFileName = "";
        RaceCarnival instance = null;
        boolean expResult = false;
        boolean result = instance.loadFile(inFileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidInt method, of class RaceCarnival.
     */
    @Test
    public void testIsValidInt() {
        System.out.println("isValidInt");
        String query = "";
        boolean expResult = false;
        boolean result = RaceCarnival.isValidInt(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDate method, of class RaceCarnival.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        String query = "";
        boolean expResult = false;
        boolean result = RaceCarnival.isValidDate(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidTime method, of class RaceCarnival.
     */
    @Test
    public void testIsValidTime() {
        System.out.println("isValidTime");
        String query = "";
        boolean expResult = false;
        boolean result = RaceCarnival.isValidTime(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFile method, of class RaceCarnival.
     */
    @Test
    public void testSaveFile() {
        System.out.println("saveFile");
        String outFileName = "";
        RaceCarnival instance = null;
        boolean expResult = false;
        boolean result = instance.saveFile(outFileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nameSearch method, of class RaceCarnival.
     */
    @Test
    public void testNameSearch() {
        System.out.println("nameSearch");
        String key = "";
        RaceCarnival instance = null;
        RaceContestant[] expResult = null;
        RaceContestant[] result = instance.nameSearch(key);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}