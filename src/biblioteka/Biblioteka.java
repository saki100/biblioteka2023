package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

/**
 * Ova klasa implementira interfejs BibliotekaInterfejs i predstavlja implementaciju preko liste
 * 
 * @author Sara
 *
 */

public class Biblioteka implements BibliotekaInterfejs {

	/**
	 * Lista sa svim knjigama u biblioteci.
	 */
	private LinkedList<Knjiga> knjige=new LinkedList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {

		if(knjiga==null)
			throw new NullPointerException("knjiga ne sme biti null.");
		if(knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji.");

         knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne sme biti null i mora postojati u biblioteci.");
          knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		//ova metoda ne treba da ima nikakvu log kontrolu, to je samo obican getter
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String Izdavac) {

       if(autor==null && isbn==null && naslov==null && Izdavac==null)
    	  throw new RuntimeException("Morate uneti barem 1 kriterijum pretrage");

		LinkedList<Knjiga> rezultat=new LinkedList<>();
		for(Knjiga knjiga:knjige)
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
       return rezultat;
	}

}
