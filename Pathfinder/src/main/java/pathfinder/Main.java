package pathfinder;

/**
 *
 * @author samukaup
 */
public class Main {

    public static void main(String[] args) {
        Verkko verkko = new Verkko(5);
        for (int i = 0; i < 5; i++) {
            verkko.lisaaSolmu(i);
        }
        verkko.lisaaKaari(0, 1, 4);
        verkko.lisaaKaari(1, 0, 4);
        verkko.lisaaKaari(1, 2, 8);
        verkko.lisaaKaari(2, 1, 8);
        verkko.lisaaKaari(2, 3, 7);
        verkko.lisaaKaari(3, 2, 7);
        verkko.lisaaKaari(3, 4, 9);
        verkko.lisaaKaari(4, 3, 9);
        Dijkstra dijkstra = new Dijkstra(verkko);
        dijkstra.etsiLyhinReitti(0);
    }
    
}
