# Matopeli

Sovellus on klassinen matopeli.

## Dokumentaatio

[Käyttöohje](https://github.com/AnnaKuokkanen/ot-harjoitustyo/blob/master/SnakeGame/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/AnnaKuokkanen/ot-harjoitustyo/blob/master/SnakeGame/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)

[Arkkitehtuurikuvaus](https://github.com/AnnaKuokkanen/ot-harjoitustyo/blob/master/SnakeGame/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/AnnaKuokkanen/ot-harjoitustyo/blob/master/SnakeGame/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/AnnaKuokkanen/ot-harjoitustyo/blob/master/SnakeGame/dokumentaatio/tyotunnit.md)

## Releaset
[Viikko 5](https://github.com/AnnaKuokkanen/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

Tässä esitellään komentorivin komennot, joilla seuraavat toimenpiteet suoritetaan

### Testaus

`mvn test (suorittaa testit)`

`mvn jacoco:report (luo testikattavuusraportin)`

### Ohjelman suorittavan jarin generointi

`mvn package (luo jar-tiedoston hakemistoon target)`

### JavaDoc

`mvn javadoc:javadoc (generoi javaDocin)`

### Checkstyle

`mvn jxr:jxr checkstyle:checkstyle (suorittaa tiedostoon checkstyle.xml määrittelemät tarkistukset)`
