
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
public class DijkstraTest {
    
    private Dijkstra dijkstra;
    private Verkko verkko;
    
    @Before
    public void setUp() {
        verkko = new Verkko(5);
        for (int i = 0; i < 5; i++) {
            verkko.lisaaSolmu(i);
        }
        verkko.lisaaKaari(0, 1, 3);
        verkko.lisaaKaari(1, 0, 3);
        verkko.lisaaKaari(1, 2, 1);
        verkko.lisaaKaari(2, 1, 1);
        verkko.lisaaKaari(2, 3, 3);
        verkko.lisaaKaari(3, 2, 3);
        verkko.lisaaKaari(3, 4, 1);
        verkko.lisaaKaari(4, 3, 1);
        verkko.lisaaKaari(0, 3, 2);
        verkko.lisaaKaari(3, 0, 2);
        dijkstra = new Dijkstra(verkko);
    }
    
    @Test
    public void dijkstraAlgoToimiiOikeinTestiYksi() {
        dijkstra.etsiLyhinReitti(0, 4);
        assertEquals(3, verkko.solmut[4].lisattavaPaino);
    }
    
    @Test
    public void dijkstraAlgoToimiiOikeinTestiKaksi() {
        dijkstra.etsiLyhinReitti(3);
        assertEquals(2, verkko.solmut[0].lisattavaPaino);
        assertEquals(4, verkko.solmut[1].lisattavaPaino);
        assertEquals(3, verkko.solmut[2].lisattavaPaino);
        assertEquals(0, verkko.solmut[3].lisattavaPaino);
        assertEquals(1, verkko.solmut[4].lisattavaPaino);
    }
    
}
