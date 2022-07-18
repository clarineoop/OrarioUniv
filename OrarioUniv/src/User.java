

/** Classe per la gestione degli utenti **/
public class User {
	
	
	int matricola, anno_corso;
	String nome, cognome, corso, pwd;
	
	/** Costruttore vuoto **/
	public User() { }
	
	/** Costruttore dato la sola matricola **/
	public User(int matricola) {		
		this.matricola=matricola;
	}

	/** Costruzione di un oggetto utente dato la matricola e la password **/		
	public User(int matricola,String pwd) {
		this.matricola=matricola;
		this.pwd=pwd;
	}

	/* Seguono setters e getters */
	
	/** Ritorna il nome_utente **/
	public String getNomeUtente() {
		return nome;
	}
	
	/** Ritorna il cognome_utente **/
	public String getCognomeUtente() {
		return cognome;
	}
	
	/** Ritorna il corso dell'utente **/
	public String getCorsoUtente() {
		return corso;
	}
	
	/** Ritorna l'anno di corso dell'utente **/
	public int getAnnoCorsoUtente() {
		return anno_corso;
	}
	
	/** Ritorna la matricola dell'utente **/
	public int getMatricolaUtente() {
		return matricola;
	}
	

	/** Ritorna la password **/
	public String getPwd() {
		return pwd;
	}

	
	/** setta il nome_utente **/
	public void setNomeUtente(String nome) {
		this.nome=nome;
	}
	
	/** setta il cognome_utente **/
	public void setCognomeUtente(String cognome) {
		this.cognome=cognome;
	}
	
	/** setta il corso dell'utente **/
	public void setCorsoUtente(String corso) {
		this.corso=corso;
	}
	
	/** setta l'anno di corso dell'utente **/
	public void setAnnoCorsoUtente(int anno_corso) {
		this.anno_corso=anno_corso;
	}
	
	/** setta la matricola dell'utente **/
	public void setMatricolaUtente(int matricola) {
		this.matricola=matricola;
	}


	/** Setta la password **/
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
