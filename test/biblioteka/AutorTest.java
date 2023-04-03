package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	Autor a;
	
	@BeforeEach  //desava se pre svakog testa
	void setUp() throws Exception {
		a=new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null; //nismo morali ovo al ajde kao da ne bude prazno
	}

	@Test
	void testAutor() { // za bezparametarski konstruktor
		a=new Autor();
		assertNotNull(a);
	}

	@Test
	void testAutorStringString() {
    a=new Autor("Mika", "Mikic");
    
    assertNotNull(a);
    assertEquals("Mika", a.getIme());
    assertEquals("Mikic", a.getPrezime());
	}

	@Test
	void testSetIme() {
		//i sta sad radimo, pa napravimo novi obj klase Autor, probamo da unesemo ime Pera i vidimo da li atribut ime ima zaista vr Pera
      a.setIme("Pera");
      assertEquals("Pera", a.getIme());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto imena")
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class,  //izuzetak koji se ocekuje
				()-> a.setIme(null));  // kod koji treba pozvati sa ocekivanjem da ce baciti ovaj gore izuzetak
	}
	@Test
	void testSetImeKratakString() {
		assertThrows(java.lang.RuntimeException.class,  //izuzetak koji se ocekuje
				()-> a.setIme("P"));  // kod koji treba pozvati sa ocekivanjem da ce baciti ovaj gore izuzetak
	}

	@Test
	void testSetPrezime() {
    a.setPrezime("Peric");
    assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,  
				()-> a.setPrezime(null));
	}
	@Test
	void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class, 
				()-> a.setIme("T"));  
	}
	@Test
	void testToString() {
           a.setIme("Zika");
           a.setPrezime("Zikic");
           
           String s=a.toString();
           assertTrue(s.contains("Zika"));
           assertTrue(s.contains("Zikic"));
	}

	@ParameterizedTest
	@CsvSource({ //CsvSource koristimo kada imamo vise vr koje zelimo da testiramo, a kada imam samo jednu onda ValueSource
		"Pera, Peric, Pera, Peric, true",
		"Pera, Zikic, Pera, Peric, false",
		"Mika, Peric, Pera, Peric, false",
		"Pera, Peric, Mika, Mikic, false"
	})
	void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
     a.setIme(ime1); 
     a.setPrezime(prezime1);
     
     Autor b=new Autor();
     b.setIme(ime2);
     b.setPrezime(prezime2);
     assertEquals(eq, a.equals(b));
	}

}
