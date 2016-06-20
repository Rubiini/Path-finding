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
    
    public void vahitenSolmujaDijkstra(Solmu alku) {
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
                    reitti[taulukonIndexi++] = u.nro;
                }
                n = n.seuraava;                  //Muutetaan n solmu muuttuja nykyisen naapurisolmuksi
            }
        } 
    }
    public void etsiLyhinReitti(int alku, int loppu) {
        ATahtiAlgoritmi(verkko.solmut[alku], verkko.solmut[loppu]);
        System.out.println("Solmusta " + alku + " solmuun " + verkko.solmut[loppu].nro + " on vähintään " + verkko.solmut[loppu].lisattavaPaino + " solmua");
        for (int i = 0; i < 10; i++) {
            
        }
        for (int i = 0; i < reitti.length; i++) {
            if (i != 0) {
                if (reitti[i] != reitti[i - 1]) {
                    System.out.print(reitti[i] + "->");
                }
            } else {
                System.out.print(reitti[0] + "->");
            }
            
            
        }
    }
    
    public void alusta() {
        for (Solmu s : verkko.solmut) {
            s.tila = Tila.UUSI;
        }
    }
    
    public int heuristiikka(int tutkittava, int loppu) {
        int heuristiikkaX = Math.abs(verkko.solmut[tutkittava].getX() - verkko.solmut[loppu].getX());
        int heuristiikkaY = Math.abs(verkko.solmut[tutkittava].getY() - verkko.solmut[loppu].getY());
        return  verkko.solmut[tutkittava].lisattavaPaino + heuristiikkaY + heuristiikkaX;
    }
    
    public void ATahtiAlgoritmi(Solmu alku, Solmu loppu) {
        alusta();
        alku.tila = Tila.JONOSSA;
        alku.lisattavaPaino = 0;                 //Alustetaan reitin paino
        Keko keko = new Keko(verkko.maxKoko);    //Luodaan uusi keko, jolle asetetaan maksimi koko, joka vastaa verkon solmujen lukumäärää.
        keko.lisaa(alku);      
        
        while(!keko.tyhja()) {
            Solmu u = keko.poista();
            if (u == loppu) break;
            u.tila = Tila.KAYTY;                 
            Naapuri n = u.naapuri; 
            
            while(n != null) {
                int mahdollinen = u.lisattavaPaino + n.paino;
                if (verkko.solmut[n.index].tila == Tila.UUSI) { 
                    keko.lisaa(verkko.solmut[n.index]);             //Solmu lisätään kekoon
                    verkko.solmut[n.index].tila = Tila.JONOSSA;     //Ja solmun tilaksi asetetaan -> JONOSSA
                }
             
                if (heuristiikka(verkko.solmut[n.index].nro, verkko.solmut[loppu.nro].nro) > heuristiikka(verkko.solmut[u.nro].nro, verkko.solmut[loppu.nro].nro) + n.paino) {
                    verkko.solmut[n.index].lisattavaPaino = u.lisattavaPaino + n.paino;
                    keko.heapify(verkko.solmut[n.index]);
                    reitti[taulukonIndexi++] = u.nro;
                }
                
                
                n = n.seuraava;   
            }
        }
    }  
}
