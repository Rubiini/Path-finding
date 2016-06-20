package pathfinder;

/**
 *
 * @author samukaup
 */
public class Verkko {
    public Solmu[] solmut;
    public int maxKoko;
    public int koko;

    /**
     * Verkko jota sovellus käyttää reitinhaussa.
     * @param maxKoko Verkon koko.
     */
    public Verkko(int maxKoko) {
        this.maxKoko = maxKoko;
        solmut = new Solmu[maxKoko];
    }

    /**
     * Lisää solmun verkkoon.
     * @param numero Solmun numero.
     */
    public void lisaaSolmu(int numero) {
        solmut[koko++] = new Solmu(numero);
    }
    
    public void lisaaSolmuKartalle(int numero, int x, int y) {
        solmut[koko++] = new Solmu(numero, x, y);
    }

    /**
     * Lisää kaaren verkossa olevien kahden solmun välille ja luo naapurisuhteet.
     * @param alku Sen solmun indexi, josta kaari lähtee.
     * @param loppu Sen solmun indexi, johon kaari päättyy.
     * @param paino Kaaren paino.
     */
    public void lisaaKaari(int alku, int loppu, int paino) {
        solmut[alku].naapuri = new Naapuri(loppu, paino, solmut[alku].naapuri);
        solmut[loppu].maara++;
    }
}
