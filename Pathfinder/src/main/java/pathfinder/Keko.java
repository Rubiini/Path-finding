package pathfinder;

/**
 * Binäärikeko.
 * @author samukaup
 */
public class Keko {
    private Solmu[] keko;
    private int maxKoko;
    private int koko;

    /**
     * Konstruktorissa alustetaan keolle maksimi koko 
     * @param maxKoko Keon maksimi koko
     */
    public Keko(int maxKoko) {
        this.maxKoko = maxKoko;
        keko = new Solmu[maxKoko];
    }

    /**
     * Lisää solmun kekoon.
     * @param u Kekoon lisättävä solmu
     */
    public void lisaa(Solmu u) {
        keko[koko++] = u;
        heapifyYlos(koko - 1);
    }

    /**
     * Poistaa keosta päällimmäisen solmun ja kutsuu jarjestaKeko metodia.
     * @return palauttaa poistetun solmun.
     */
    public Solmu poista() {
        Solmu v = keko[0];
        vaihda(0, koko - 1);
        keko[koko - 1] = null;
        koko--;
        jarjestaKeko(0);
        return v;
    }

    /**
     * Vaihtaa solmujen paikkaa
     * @param index1 solmun 1 indexi
     * @param index2 solmun 2 indexi
     */
    public void vaihda(int index1, int index2) {
        Solmu temp = keko[index1];
        keko[index1] = keko[index2];
        keko[index2] = temp;
    }

    /**
     * Tarkistaa onko keko tyhjä.
     * @return Palauttaa true jos keko on tyhjä.
     */
    public boolean tyhja() {
        return koko == 0;
    }

    /**
     * Etsitään keosta solmu u ja kutsutaan sille heapifyYlos metodia.
     * @param u Solmu jolle tehdään heapify
     */
    public void heapify(Solmu u) {
        for (int i = 0; i < maxKoko; i++) {
            if (u == keko[i]) {
                heapifyYlos(i);
                break;
            }
        }
    }

    /**
     * Siirretään solmu u keon päällimmäiseksi
     * @param uIndex Solmun u indeksi keossa
     */
    public void heapifyYlos(int uIndex) {
        Solmu u = keko[uIndex];
        int vIndex = (uIndex - 1) / 2;
        Solmu v = keko[vIndex];
        while (u.vertaa(v) == -1) {
            vaihda(uIndex, vIndex);
            uIndex = vIndex;
            if (uIndex == 0) {
                break;
            }
            u = keko[uIndex];
            vIndex = (uIndex - 1) / 2;
            v = keko[vIndex];
        }
    }

    /**
     * Järjestetään keko
     * @param uIndex Solmun u indexi keossa
     */
    public void jarjestaKeko(int uIndex) {
        if (koko == 1) return;                   //Palataan, jos keossa vain yksi alkio
        
        Solmu u = keko[uIndex];                  //Luodaan solmu u muuttuja
        int vasLapsenIndexi = 2 * uIndex + 1;    //Solmun u vasen lapsi
        int oikeLapsenIndexi = 2 * uIndex + 2;   //Solmun u oikea lapsi
        int lapsenIndexi;                        //Luodaan apumuuttuja

        if (tarkastaOnkoLapsia(vasLapsenIndexi)) return;
        lapsenIndexi = tarkastaIndexinArvo(oikeLapsenIndexi, vasLapsenIndexi);
        
        while (u.vertaa(keko[lapsenIndexi]) == 1) {   //Käydään läpi kunnes keko on järjestetty
            vaihda(uIndex, lapsenIndexi);
            uIndex = lapsenIndexi;
            u = keko[uIndex];
            vasLapsenIndexi = 2 * uIndex + 1;
            oikeLapsenIndexi = 2 * uIndex + 2;
            if (tarkastaOnkoLapsia(vasLapsenIndexi)) return;
            lapsenIndexi = tarkastaIndexinArvo(oikeLapsenIndexi, vasLapsenIndexi);
        }
    }

    /**
     * Tarkastaa onko solmulla lapsia.
     * @param vasLapsenIndexi Tarkastettavan solmun vasemman lapsen indexi.
     * @return Palauttaa true jos solmulla ei ole lapsia.
     */
    public boolean tarkastaOnkoLapsia(int vasLapsenIndexi) {
        return keko[vasLapsenIndexi] == null; //Palataan, jos u:lla ei ole lapsia
    }

    /**
     * Tarkastaa 
     * @param oikeLapsenIndexi Tarkatettavan solmun oikean lapsen indexi.
     * @param vasLapsenIndexi Tarkastettavan solmun vasemman lapsen indexi.
     * @return 
     */
    public int tarkastaIndexinArvo(int oikeLapsenIndexi, int vasLapsenIndexi) {
        int lapsenIndexi;
        if (keko[oikeLapsenIndexi] == null) {    //Jos u:lla vain yksi lapsi, talletetaan sen arvo apumuuttujaan
            lapsenIndexi = vasLapsenIndexi;
        } else if (keko[oikeLapsenIndexi].vertaa(keko[vasLapsenIndexi]) == -1) {   //Jos oikean lapsen paino pienempi kuin vasemman
            lapsenIndexi = oikeLapsenIndexi;                                       //Niin sen arvo talletetaan apumuuttujaan
        } else {                                 //Muuten apumuuttujaan talletetaan vasemman lapsen arvo 
            lapsenIndexi = vasLapsenIndexi;
        }
        return lapsenIndexi;
    }

    public Solmu[] getKeko() {
        return keko;
    }
}
