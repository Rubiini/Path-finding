##Reitinhaku

* Toteutan Dijkstra sekä A*-haun algoritmit minimikekoa käyttäen.

* Ratkaisen reitinhakuongelman lyhimmän polun löytämisestä alkusolmusta a loppusolmuun b. Valitsin tehtävään Dijkstan, joka on ehkä tunnetuin reitinhaku algoritmi. Valitsin myös A* algoritmin, joka on nykyisin yksi nopeimmista ja käyteyimmistä reitinhaku algoritmeista.

* Ohjelma saa syötteenä seuraavat: 
- tutkittavan verkon 
- lähtösolmun 
- kohdesolmun 
- kaaripainot kertovan funktion.
Tutkittavassa verkossa liikutaan alkusolmusta kohti maalisolmua laskemalla kaaripainoja solmujen välillä siten, että kevyin(lyhin) reitti löydetään.

* Algoritmien aika ja tilavaativuudet: 
- A* aikavaativuus: O(n log n) ja tilavaativuus O(n) 
- Dijksta: O(n²) ja tilavaativuus O(n)

* Lähteet
Tietorakenteet ja algoritmit kurssin 2016 kevään luentokalvot
Wikipedia a*
Wikipedia Dijkstra
