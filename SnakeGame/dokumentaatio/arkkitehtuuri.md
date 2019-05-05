## Rakenne:

![Kuva arkkitehtuurista](SnakeGameArchitecture.jpg) 

# Käyttöliittymä

Käyttöliittymä sisältää kolme erilaista näkymää: 
- nimimerkin syöttäminen
- pelinäkymä
- loppunäkymä

Jokainen näkymä on oma luokkansa, jossa on metodi, joka palauttaa Scene-olion. 
Lisäksi ohjelmassa on erillinen luokka (SnakeGameApplication), joka näkee nämä kolme luokkaa ja vastaa 
eri näkymien vaihtamisesta. 

## Pelin aloittaminen

![Sekvenssikaavio](ots.jpg)

Sekvenssikaavio esittää pelin alkua ja pisteiden tallennusta. Peli alkaa kun käyttäjä syöttää kenttään nimimerkin ja painaa START-nappia. Tämä vaihtaa näkymän pelinäkymään ja tallentaa käyttäjänimen tietokantaan, jos se ei ole vielä tietokannassa. 
Kun pelaaja on hävinnyt pelin, tietokantaan tallennetaan hänen pisteensä. 

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä 

Käyttöliittymässä animaatiota toteuttavaa metodia kutsutaan toisesta luokasta,
mikä aiheuttaa sen, että näkymää ei saada vaihdettua automaattisesti, kun animaatio 
on pysähtynyt, vaan tarvitaan nappi. Lisäksi animaatio vaikuttaa ensimmäisellä 
pelikerralla alkavan jo nimen syöttämisen aikana, joten jos nimen syöttäminen
kestää liian pitkään, peli saataa olla jo päättynyt, kun seuraavaan näkymään päästään.
Tämä ratkeaa painamalla Play again. 
