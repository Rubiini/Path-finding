package pathfinder;

/**
 * Solmu on yksi verkossa olevista solmuista.
 * @author samukaup
 */
public class Solmu {
    public int lisattavaPaino;
    public int maara;
    public int nro;
    public Naapuri naapuri;
    public Tila tila;

    /**
     * Konstruktori alustaa solmun numeron, 
     * lähimmän solmun painon maksimiin ja solmun tilan, tilaan UUSI
     * @param nro Solmuun numero tai "nimi".
     */
    public Solmu(int nro) {
        this.nro = nro;
        lisattavaPaino = Integer.MAX_VALUE;
        tila = Tila.UUSI;
    }

    /**
     * Vertailee solmujen kaaripainoja.
     * @param verrattava Solmu johon tätä solmua verrataan.
     * @return Palauttaa 0 jos lisättävä paino on yhtäsuuri, 
     * -1 jos paino on pienempi ja 1 jos paino suurempi, 
     * kuin "etäisyys" verrattavaan solmuun.
     */
    public int vertaa(Solmu verrattava) {
        if (this.lisattavaPaino == verrattava.lisattavaPaino) {
            return 0;
        }
        if (this.lisattavaPaino < verrattava.lisattavaPaino) {
            return -1;
        }
        return 1;
    }
}
