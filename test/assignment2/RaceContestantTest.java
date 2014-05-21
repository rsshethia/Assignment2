package assignment2;

import java.util.GregorianCalendar;
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
public class RaceContestantTest {
    
    public RaceContestantTest() {
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
     * Test of setStartTime method, of class RaceContestant.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        RaceContestant instance = null;//
        boolean expResult = false;
        boolean result = instance.setStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTime method, of class RaceContestant.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        RaceContestant instance = null;
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinishTime method, of class RaceContestant.
     */
    @Test
    public void testSetFinishTime() {
        System.out.println("setFinishTime");
        RaceContestant instance = null;
        boolean expResult = false;
        boolean result = instance.setFinishTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFinishTime method, of class RaceContestant.
     */
    @Test
    public void testGetFinishTime() {
        System.out.println("getFinishTime");
        RaceContestant instance = null;
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getFinishTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeTaken method, of class RaceContestant.
     */
    @Test
    public void testGetTimeTaken() {
        System.out.println("getTimeTaken");
        RaceContestant instance = null;
        double expResult = 0.0;
        double result = instance.getTimeTaken();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaceStatus method, of class RaceContestant.
     */
    @Test
    public void testGetRaceStatus() {
        System.out.println("getRaceStatus");
        RaceContestant instance = null;
        RaceStatus expResult = null;
        RaceStatus result = instance.getRaceStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class RaceContestant.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        RaceContestant instance = null;
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategory method, of class RaceContestant.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        RaceContestant instance = null;
        boolean expResult = false;
        boolean result = instance.setCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaceCarnival method, of class RaceContestant.
     */
    @Test
    public void testGetRaceCarnival() {
        System.out.println("getRaceCarnival");
        RaceContestant instance = null;
        RaceCarnival expResult = null;
        RaceCarnival result = instance.getRaceCarnival();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RaceContestant.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RaceContestant instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class RaceContestant.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj2 = null;
        RaceContestant instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}