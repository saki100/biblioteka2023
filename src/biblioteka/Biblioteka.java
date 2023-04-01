package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige=new LinkedList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null || knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne sme biti null i ne sme biti duplikat.");
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
      if(autor==null && isbn==null && naslov==null && izdavac==null)
    	  throw new RuntimeException("Morate uneti barem 1 kriterijum pretrage");
		LinkedList<Knjiga> rezultat=new LinkedList<>();
		for(Knjiga knjiga:knjige)
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
       return rezultat;
	}

}