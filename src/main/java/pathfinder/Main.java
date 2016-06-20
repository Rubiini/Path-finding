package pathfinder;

/**
 *
 * @author samukaup
 */
public class Main {

    public static void main(String[] args) {
        Verkko verkko = new Verkko(7);
        /*for (int i = 0; i < 7; i++) {
            verkko.lisaaSolmu(i);
        }*/
        verkko.lisaaSolmuKartalle(0, 0, 2);
        verkko.lisaaSolmuKartalle(1, 1, 0);
        verkko.lisaaSolmuKartalle(2, 4, 2);
        verkko.lisaaSolmuKartalle(3, 1, 6);
        verkko.lisaaSolmuKartalle(4, 3, 5);
        verkko.lisaaSolmuKartalle(5, 2, 8);
        verkko.lisaaSolmuKartalle(6, 10, 7);
        
        
        verkko.lisaaKaari(0, 4, 2);
        verkko.lisaaKaari(4, 0, 2);
        verkko.lisaaKaari(0, 3, 3);
        verkko.lisaaKaari(3, 0, 3);
        verkko.lisaaKaari(0, 1, 7);
        verkko.lisaaKaari(1, 0, 7);
        verkko.lisaaKaari(1, 2, 3);
        verkko.lisaaKaari(2, 1, 3);
        verkko.lisaaKaari(2, 4, 1);
        verkko.lisaaKaari(4, 2, 1);
        verkko.lisaaKaari(3, 4, 2);
        verkko.lisaaKaari(4, 3, 2);
        verkko.lisaaKaari(3, 5, 1);
        verkko.lisaaKaari(5, 3, 1);
        verkko.lisaaKaari(5, 6, 1);
        verkko.lisaaKaari(6, 5, 1);
        ATahti a = new ATahti(verkko);
        a.etsiLyhinReitti(2, 5);
        Dijkstra d = new Dijkstra(verkko);
        d.etsiLyhinReitti(2);
    }
    
}
