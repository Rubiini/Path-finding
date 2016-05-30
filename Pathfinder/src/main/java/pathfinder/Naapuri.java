package pathfinder;

/**
 * Naapurisolmu luokka
 * @author samukaup
 */
public class Naapuri {

    public int index;
    public int paino;
    public Naapuri seuraava;

    /**
     * Naapurisolmu
     * @param index Solmun indexi.
     * @param paino Solmun paino. Vastaava kuin solmujen lisattavaPaino.
     * @param seuraava Naapurisomun naapuri.
     */
    Naapuri(int index, int paino, Naapuri seuraava) {
        this.index = index;
        this.seuraava = seuraava;
        this.paino = paino;
    }
}
