
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
public class KekoTest {
    
    private Keko keko;
    
    @Before
    public void setUp() {
        keko = new Keko(3);
    }
    
    @Test
    public void tyhjaMetodiPalauttaaTrueJosKekoOnTyhja() {
        assertTrue(keko.tyhja());
    }
    
    @Test
    public void tyhjaMetodiPalauttaaFalseJosKekoEiOleTyhja() {
        Solmu solmu = new Solmu(1);
        keko.lisaa(solmu);
        assertTrue(!keko.tyhja());
    }
    
    @Test
    public void lisaaMetodiToimii() {
        Solmu solmu = new Solmu(1);
        keko.lisaa(solmu);
        assertTrue(!keko.tyhja());
    }
    
    @Test
    public void poistaMetodiPoistaaSolmunKeosta() {
        Solmu solmu = new Solmu(1);
        keko.lisaa(solmu);
        keko.poista();
        assertTrue(keko.tyhja());
    }
    
    @Test
    public void vaihdaToimiiOikein() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        solmu1.lisattavaPaino = 1;
        solmu2.lisattavaPaino = 2;
        keko.vaihda(0, 1);
        Solmu solmu3 = keko.poista();
        assertTrue(solmu3.lisattavaPaino == 2);
        
    }
}
