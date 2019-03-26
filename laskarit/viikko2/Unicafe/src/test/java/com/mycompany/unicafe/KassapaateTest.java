
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti1;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti1 = new Maksukortti(100);
        kortti2 = new Maksukortti(500);
    }
    
    @Test
    public void rahamaaraJaLounaidenMaaraOikea() {
        assertEquals(100000,paate.kassassaRahaa());
        assertEquals(0,paate.maukkaitaLounaitaMyyty());
        assertEquals(0,paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiMaukkaassaKunRahaRiittaa() {
        paate.syoMaukkaasti(400);
        assertEquals(100400,paate.kassassaRahaa());
        assertEquals(1,paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiEdullisessaKunRahaRiittaa() {
        paate.syoEdullisesti(240);
        assertEquals(100240,paate.kassassaRahaa());
        assertEquals(1,paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiMaukkaassaKunRahaEiRiita() {
        paate.syoMaukkaasti(100);
        assertEquals(100000,paate.kassassaRahaa());
        assertEquals(0,paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiEdullisessaKunRahaEiRiita() {
        paate.syoEdullisesti(100);
        assertEquals(100000,paate.kassassaRahaa());
        assertEquals(0,paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoToimiiMaukkaassaKunRahaRiittaa() {
        paate.syoMaukkaasti(kortti2);
        assertEquals(1,paate.maukkaitaLounaitaMyyty());
        assertEquals(100,kortti2.saldo());
        assertEquals(true,paate.syoMaukkaasti(kortti2));
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoToimiiEdullisessaKunRahaRiittaa() {
        paate.syoEdullisesti(kortti2);
        assertEquals(1,paate.edullisiaLounaitaMyyty());
        assertEquals(260,kortti2.saldo());
        assertEquals(true,kortti2.otaRahaa(240));
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoToimiiMaukkaassaKunRahaEiRiita() {
        paate.syoMaukkaasti(kortti1);
        assertEquals(0,paate.maukkaitaLounaitaMyyty());
        assertEquals(100,kortti1.saldo());
        assertEquals(false,kortti1.otaRahaa(400));
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoToimiiEdullisessaKunRahaEiRiita() {
        paate.syoEdullisesti(kortti1);
        assertEquals(0,paate.edullisiaLounaitaMyyty());
        assertEquals(100,kortti1.saldo());
        assertEquals(false,kortti1.otaRahaa(240));
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void ladataanKortille() {
        paate.lataaRahaaKortille(kortti1, 100);
        assertEquals(200,kortti1.saldo());
        assertEquals(99900,paate.kassassaRahaa());
    }
}
