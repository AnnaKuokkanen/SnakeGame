## Sovelluksen tarkoitus
Tarkoituksena luoda matopeli, jossa käyttäjä ohjaa nuolinäppäimillä matoa siten, että se ei törmää itseensä. 
Samalla näytölle ilmestyy ruokapaloja joita syömällä madon pituus kasvaa. Peli päättyy silloin kun mato törmää johonkin. 
Pelin lopuksi näytetään käyttäjän high score-lista.

## Käyttäjät
Peli ei vaadi sisäänkirjautumista, mutta kysyy alussa käyttäjältä nimimerkkiä. Jos käyttäjän pisteet yltävät high score-listalle, 
tulos asetetaan siihen nimimerkillä.

## Käyttöliittymä
Sovelluksessa on kolme eri näkymää: alussa on tekstikenttä, johon syötetään nimimerkki ja Start-nappi. Toisessa näkymässä on 
itse peli. Kolmannessa näkymässä on High score-lista ja kaksi nappia: Exit ja Play again.
![Kuva](~/ot-harjoitustyo/dokumentaatio/liittyma.jpg)

## Perusversion tarjoama toiminnallisuus
- käyttäjä voi syöttää nimimerkin, kirjautumista ei tarvita
- painamalla Play-nappia peli alkaa
- käyttäjä ohjaa matoa nuolinäppäimillä
- peli päättyy kun mato törmää itseensä
- kun peli päättyy siirrytään Game over-näkymään, jossa nähdään top 3 high scoret ja ne tehneet nimimerkit sekä jossa on 
Play again- ja Exit-napit (play again siirtää takaisin pelinäkymään ja exit siirtää ensimmäiseen näkymään) 

Jatkokehitysideoita
- eri tasoja (seinät, mato liikkuu nopeammin)
- kirjautuminen
- alussa käyttäjä voi katsoa high score-listaa
- pelissä pisteet näytetään reaaliaikaisesti
