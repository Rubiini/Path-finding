package pathfinder;

/**
 *
 * @author samukaup
 */
public class ATahti {
    
    private Verkko verkko;
    private int[] reitti;
    private int taulukonIndexi;
    public boolean a;
    
    public ATahti(Verkko verkko) {
        this.verkko = verkko;
        this.reitti = new int[verkko.maxKoko];
        this.taulukonIndexi = 0;
        this.a = false;
    }
    
    public void laskeMatka(Solmu alku) {
        a = true;
        alku.tila = Tila.JONOSSA;                //Siirretään alkusolmu jonoon
        alku.matka = 0;                          //Alustetaan reitin paino
        Keko keko = new Keko(verkko.maxKoko, a);    //Luodaan uusi keko, jolle asetetaan maksimi koko, joka vastaan verkon solmujen lukumäärää.
        keko.lisaa(alku);                        //Lisätään alkusolmu kekoon

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
                if (verkko.solmut[n.index].matka > u.matka + n.etaisyys) {
                    verkko.solmut[n.index].matka = u.matka + n.etaisyys;
                    keko.heapify(verkko.solmut[n.index]);
                }
                n = n.seuraava;                  //Muutetaan n solmu muuttuja nykyisen naapurisolmuksi
            }
        } 
    }
    public void etsiLyhinReitti(int alku, int loppu) {
        laskeMatka(verkko.solmut[alku]);
        System.out.println("Solmusta " + alku + " solmuun " + verkko.solmut[loppu].nro + " on yhteensä " + verkko.solmut[loppu].matka + "solmua");
    }
    
    public void alusta() {
        for (Solmu s : verkko.solmut) {
            s.tila = Tila.UUSI;
        }
    }
    
    public int heuristiikka(Solmu nyt, Solmu loppu) {
        int pituus = nyt.lisattavaPaino + loppu.matka;
        return pituus;
    }
    
    public void ATahtiAlgoritmi(Solmu alku, Solmu loppu) {
        alusta();
        alku.tila = Tila.JONOSSA;
        alku.lisattavaPaino = 0;                 //Alustetaan reitin paino
        Keko keko = new Keko(verkko.maxKoko);    //Luodaan uusi keko, jolle asetetaan maksimi koko, joka vastaan verkon solmujen lukumäärää.
        keko.lisaa(alku);      
        
        while(!keko.tyhja()) {
            Solmu u = keko.poista();
            if (u == loppu) break;
            u.tila = Tila.KAYTY;                 
            Naapuri n = u.naapuri; 
            
            while(n != null) {
                if (verkko.solmut[n.index].tila == Tila.KAYTY) {
                    continue;
                }
                int mahdollinen = u.lisattavaPaino + n.paino;
                if (verkko.solmut[n.index].tila == Tila.UUSI || mahdollinen < verkko.solmut[n.index].lisattavaPaino) { 
                    keko.lisaa(verkko.solmut[n.index]);             //Solmu lisätään kekoon
                    verkko.solmut[n.index].tila = Tila.JONOSSA;     //Ja solmun tilaksi asetetaan -> JONOSSA
                }
                reitti[taulukonIndexi] = u.nro;
            }
        }
    }  
}
