
package pathfinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samukaup
 */
public class VerkkoTest {
    
    private Verkko verkko;
    
    @Before
    public void setUp() {
        verkko = new Verkko(2);
        verkko.koko = 0;
    }
    
    @Test
    public void lisaaSolmuLisaaSolmunVerkkoon() {
        verkko.lisaaSolmu(0);
        assertTrue(verkko.solmut[0] != null);
        assertNull(verkko.solmut[1]);
    }
    
    @Test
    public void lisaaSolmuKasvattaaKokoMuuttujaa() {
        verkko.lisaaSolmu(0);
        assertEquals(1, verkko.koko);
    }
    
}
