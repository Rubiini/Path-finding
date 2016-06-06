
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
        keko = new Keko(4);
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
    public void vaihdaMetodiToimiiOikein() {
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
    
    @Test
    public void heapifyYlosToimiiOikein() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        Solmu solmu3 = new Solmu(3);
        solmu1.lisattavaPaino = 5;
        solmu2.lisattavaPaino = 4;
        solmu3.lisattavaPaino = 2;
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        keko.lisaa(solmu3);
        Solmu[] lista = keko.getKeko();
        assertEquals(solmu3, lista[0]);
        assertEquals(solmu1, lista[1]);
        assertEquals(solmu2, lista[2]);
        
    }
    
    @Test
    public void jarjestaToimiiOikein() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        Solmu solmu3 = new Solmu(3);
        solmu1.lisattavaPaino = 1;
        solmu2.lisattavaPaino = 2;
        solmu3.lisattavaPaino = 3;
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        keko.lisaa(solmu3);
        Solmu[] lista = keko.getKeko();
        lista[0].lisattavaPaino = 5;
        keko.jarjestaKeko(0);
        assertEquals(solmu2, lista[0]);
        assertEquals(solmu1, lista[1]);
        assertEquals(solmu3, lista[2]);
    }
    
    @Test
    public void tarkastaOnkoLapsiaToimiiOikeinJosEiLapsia() {
        Solmu solmu = new Solmu(1);
        keko.lisaa(solmu);
        assertTrue(keko.tarkastaOnkoLapsia(1));
    }
    
    @Test
    public void tarkastaOnkoLapsiaToimiiOikeinJosOnLapsia() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        assertTrue(!keko.tarkastaOnkoLapsia(1));
    }
    
    @Test
    public void tarkastaIndexinArvoToimiiOikeinJosOikeaaLastaEiOle() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        int luku = keko.tarkastaIndexinArvo(2, 1);
        assertEquals(1, luku);
    }
    
    @Test 
    public void tarkastaIndexinArvoToimiiOikeinJosOikeanPainoPienempi() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        Solmu solmu3 = new Solmu(3);
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        keko.lisaa(solmu3);
        solmu2.lisattavaPaino = 3;
        solmu3.lisattavaPaino = 2;
        int luku = keko.tarkastaIndexinArvo(2, 1);
        assertEquals(2, luku);
    }
    
    @Test 
    public void tarkastaIndexinArvoToimiiOikeinJosVasemmanPainoPienempi() {
        Solmu solmu1 = new Solmu(1);
        Solmu solmu2 = new Solmu(2);
        Solmu solmu3 = new Solmu(3);
        keko.lisaa(solmu1);
        keko.lisaa(solmu2);
        keko.lisaa(solmu3);
        solmu2.lisattavaPaino = 2;
        solmu3.lisattavaPaino = 3;
        int luku = keko.tarkastaIndexinArvo(2, 1);
        assertEquals(1, luku);
    }
}
