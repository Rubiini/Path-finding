package pathfinder;

/**
 * Dijkstra algoritmin toteutus.
 *
 * @author samukaup
 */
public class Dijkstra {

    private Verkko verkko;

    /**
     * Alustetaan verkko paikalliseen muuttujaan.
     *
     * @param verkko Algoritmille annetaan syötteenä verkko
     */
    public Dijkstra(Verkko verkko) {
        this.verkko = verkko;
    }

    /**
     * Dijkstra algoritmi. 
     * Tarkempi selostus kommentteina rivien lopussa.
     * @param solmu Alkusolmu, josta haku alkaa
     */
    public void dijkstraAlgoritmi(Solmu solmu) {
        
        solmu.tila = Tila.JONOSSA;               //Siirretään alkusolmu jonoon
        solmu.lisattavaPaino = 0;                //Alustetaan reitin paino
        Keko keko = new Keko(verkko.maxKoko);    //Luodaan uusi keko, jolle asetetaan maksimi koko, joka vastaan verkon solmujen lukumäärää.
        keko.lisaa(solmu);                       //Lisätään alkusolmu kekoon

        while (!keko.tyhja()) {                  //Käydään kaikki keon alkiot läpi
            Solmu u = keko.poista();             //Poistetaan keon päällimmäinen ja annetaan se arvona muuttujalle u
            u.tila = Tila.KAYTY;                 //Merkataan solmu u läpikäydyksi
            Naapuri n = u.naapuri;               //Luodaan solmun u naapurisolmu muuttuja n   
            while (n != null) {                  //Käydään läpi, kunnes kaikki naapurit käyty läpi -> kts rivi46
                if (verkko.solmut[n.index].tila == Tila.UUSI) {     //Jos solmussa ei ole vielä käyty
                    keko.lisaa(verkko.solmut[n.index]);             //Solmu lisätään kekoon
                    verkko.solmut[n.index].tila = Tila.JONOSSA;     //Ja solmun tilaksi asetetaan -> JONOSSA
                }
                //"Relax"
                if (verkko.solmut[n.index].lisattavaPaino > u.lisattavaPaino + n.paino) {
                    verkko.solmut[n.index].lisattavaPaino = u.lisattavaPaino + n.paino;
                    keko.heapify(verkko.solmut[n.index]);
                }
                n = n.seuraava;                  //Muutetaan n solmu muuttuja nykyisen naapurisolmuksi
            }
        }
    }

    /**
     * Etsii lyhimmän reitin alkusolmusta verkon kaikkiin muihin solmuihin
     * ja printtaa polkujen pituudet.
     * 
     * @param alku Solmu josta lähdetään liikkeelle.
     */
    public void etsiLyhinReitti(int alku) {
        dijkstraAlgoritmi(verkko.solmut[alku]);
        for (int i = 0; i < verkko.maxKoko; i++) {
            System.out.println("Solmusta " + alku + " solmuun " + verkko.solmut[i].nro + " kevyin reitti on: " + verkko.solmut[i].lisattavaPaino);
        }
    }
    
    
    /**
     * Etsii lyhimmän reitin alkusolmusta loppusolmuun.
     * @param alku Solmu josta lähdetään liikkeelle.
     * @param loppu Solmu johon reitinhaussa päädytään.
     */
    public void etsiLyhinReitti(int alku, int loppu) {
        dijkstraAlgoritmi(verkko.solmut[alku]);
        System.out.println("Solmusta " + alku + " solmuun " + verkko.solmut[loppu].nro + " kevyin reitti on: " + verkko.solmut[loppu].lisattavaPaino);
    }
}
