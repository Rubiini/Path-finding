
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
public class SolmuTest {
    
    private Solmu solmu;
            
    @Before
    public void setUp() {
        solmu = new Solmu(1);
        solmu.lisattavaPaino = 2;
    }
    
    @Test
    public void vertaaPalauttaOikeinJosSolmunPainoPienempiKuinVerrattavan() {
        Solmu s = new Solmu(2);
        s.lisattavaPaino = 3;
        int luku = solmu.vertaa(s);
        assertEquals(-1, luku);
    }
    
    @Test
    public void vertaaPalauttaOikeinJosSolmunPainoYhtasuuriKuinVerrattavan() {
        Solmu s = new Solmu(2);
        s.lisattavaPaino = 2;
        int luku = solmu.vertaa(s);
        assertEquals(0, luku);
    }
    
    @Test
    public void vertaaPalauttaOikeinJosSolmunPainoSuurempiKuinVerrattavan() {
        Solmu s = new Solmu(2);
        s.lisattavaPaino = 1;
        int luku = solmu.vertaa(s);
        assertEquals(1, luku);
    }
    
}
