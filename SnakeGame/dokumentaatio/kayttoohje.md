# Käyttöohje

Lataa tiedosto [SnakeGameJar.jar](https://github.com/AnnaKuokkanen/SnakeGame/releases/tag/loppupalautus)

## Ohjelman käynnistäminen 

Ohjelma käynnistetään komennolla 
java -jar SnakeGameJar.jar

## Nimimerkin määrittäminen

Sovellus avaa näkymän, jossa on tekstikenttä ja nappi, jota painamalla peli alkaa.
Tässä voi antaa nimimerkin, jolla tietokantaan tallennetaan pisteet. Jos antaa saman nimimerkin, 
jolla on joskus pelannut, jäävät nimimerkille talteen paremmat pisteet. Jos nimimerkkiä ei anna, pisteet eivät tallennu.

## Pelaaminen

Mato liikkuu nuolinäppäimillä. Peli on hävitty, kun se on törmännyt itseensä tai seinään.
Tämän jälkeen näkymään ilmestyy STOP-nappi, jota painamalla päästään viimeiseen näkymään.

## Pelin päättäminen

Viimeisessä näkymässä näkee pisteet, joita kerrytti pelikierroksen aikana. Lisäksi 
voi päättää, haluaako pelata uudestaan samalla nimimerkillä (jolloin valitaan Play again) 
vai päättää pelin, joilloin peli siirtyy ensimmäiseen näkymään, jossa voi valita uuden nimimerkin.  

## Vaadittava tiedosto

Ohjelma tarvitsee toimiakseen oikein projektin juureen highscore.txt-nimisen tiedoston. 
Jos tiedostoa ei ohjelmaa käynnistettäessä ole, sellainen luodaan. Jo olemassaolevaa 
tiedostoa voi muokata käsin (lisätä ja poistaa nimimerkkejä, muuttaa pisteitä jne.) 
silloin, kun ohjelma ei ole suorituksessa. Kun ohjelma on aloitettu, tiedostolle ei saa tehdä mitään. 
