import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** Classe che si occupa della connessione e disconnessione al db,
 *  include funzioni per il recupero delle informazioni,
 *  funzione per eseguimento di una Query
 */

public class Database {

	/* Variabile della connessione */
	private static Connection conn = null;
	
	/** Costruttore della classe Database**/
	public Database() {
		
		Connect(); //chiamata alla funzione che si occupa della connessione al database
		
	}

	/** Funzione che si connette al database, dati i dati di connessione **/
	public Connection Connect() {

		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //verifico se esiste la classe com.mysql.jdbc.Driver, se si, la carico dinamicamente
		
		
		try {
			// PARAMETRI DI CONNESSIONE
			conn = DriverManager.getConnection("jdbc:mysql://localhost/orariouniv?user=root&password=root"); 

			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	//eseguo la connessione al data base di nome orariouniv
		
		
		
		return conn; //ritorno la variabile di connessione al database

	}
	
	/** Metodo che ritorna la connessione alle classi esterne **/
	public static Connection getConn() {
		return conn;
	}
	
	/** Metodo per l'inoltro delle query al database, richiede stringa della query e variabile di connessione
	 *  richiede inoltre parametro booleano silent (inviare messaggi di successo/errore o meno)
	 **/
	public static ResultSet Query(String query,Connection conn,Boolean silent) {

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			if (stmt.execute(query)) rs = stmt.getResultSet(); // eseguo la query
			
			JLabel msg= new JLabel("Richiesta eseguita correttamente");
			JLabel msgEmpty= new JLabel("Nessun risultato trovato!");
			
			/* Elaborazione messaggio da fornire */
			if(!silent) {
				if(query.contains("INSERT") || query.contains("UPDATE") || query.contains("DELETE")) JOptionPane.showMessageDialog(null,msg,"Messaggio",JOptionPane.PLAIN_MESSAGE);
				else if(isEmpty(rs))  JOptionPane.showMessageDialog(null,msgEmpty,"Attenzione", JOptionPane.WARNING_MESSAGE);
			}
     
		}
		catch (SQLException ex){
			// gestisco gli errori con l'error handler
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ErrorHandler(ex.getErrorCode());
		}

		return rs; //ritorno il risultato della Query
	}

	/** Metodo per la chiusura della connessione al database **/
	public void Close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	/** Metodo per fornire diversi messaggi di errore in base agli errori SQL generati **/
	private static void ErrorHandler(int ex) {

		JLabel msg = null;
		if( ex == 1062) msg= new JLabel("Errore inserimento: entry doppia!", JLabel.CENTER);
		else msg= new JLabel("Errore generico");
		JOptionPane.showMessageDialog(null,msg,"Errore SQL",JOptionPane.ERROR_MESSAGE); 
	}
	
	/** Metodo per controllare se il resultSet e' vuoto o meno **/
	public static boolean isEmpty(ResultSet rs) throws SQLException {
		if (!rs.next()) return true; 
		rs.previous();
		return false;
	}

}