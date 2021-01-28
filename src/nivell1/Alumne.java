package nivell1;

public class Alumne {
	
	// Atributs de classe
	private String nom;
	private int edat;
	private String curs;
	private int nota;
	
	// Constructor
	public Alumne(String nom, int edat, String curs, int nota) {
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}

	public String getNom() {
		return nom;
	}

	public int getEdat() {
		return edat;
	}

	public String getCurs() {
		return curs;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Alumne [nom=" + nom + ", edat=" + edat + ", curs=" + curs + ", nota=" + nota + "]";
	}
}
