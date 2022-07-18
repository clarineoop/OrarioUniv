
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


@SuppressWarnings("serial")

/** Classe che gestisce il pannello per il login degli utenti.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del login avvenuto.
 *  Se non vengono inseriti correttamente i dati lancia un messaggio di errore.
 */
public class LoginPanel extends JPanel  implements ActionListener {


	private JTextField matricola; //campo di testo per la matricola 
	private JPasswordField pwd; //campo di testo per la password dell'utente
	private JButton btnLogin; //buttone di login
	private JButton btnAdmin; //buttone di creazione di un nuovo account
	private JLabel txtMatr,txtPwd; //Label dei campi Utente e Password

	static User logged = new User(); //user che si collegera'

	/** Costruttore che costruisce il pannello di login **/ 
	public LoginPanel() {

		super(); //chiamo il contruttore della superclasse JPanel che la classe corrente estende

		this.setLayout(new BorderLayout(10,50)); //settaggio del tipo di Layout della classe window che e una estenzione di JFrame a BorderLayout
												 //che divide loschermo il JPanel in 5 parte(NORTH, SOUTH, EAST, WEST)
		
		
		this.setBackground(new Color(64, 66, 87)); //settaggio del colore di backgroung del JPanel principale(this)

		JLabel title=new JLabel("<html><br>Inserisci le tue credenziali</html>",JLabel.CENTER);
		title.setFont(new Font("Candara", Font.BOLD, 25));
		title.setForeground(new Color( 51, 51, 51));
		
		title.setForeground(new Color(255,255,255)); //settaggio del colore del testo del JLabel title 
		
		this.add(title,BorderLayout.NORTH); //aggiungo title al JPanel principale in posizione NORTH

		JPanel grid = new JPanel(); //creazione di un JPanel grid che verra' posto in centro del JPanel principale
		grid.setLayout(null); //setto il tipo di Layout a BoxLayout.PAGE_AXIS che significa disporre i componenti in modo verticale
		

		txtMatr = new JLabel("Matricola:  ");// creo istanza di JLabel come label del campo Matricola
		txtMatr.setFont(new Font("Candara", Font.PLAIN, 16));
		txtMatr.setForeground(new Color( 51, 51, 51));
		txtMatr.setBounds(300, 50, 100, 35);
		
		matricola = new JTextField(17);
		matricola.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		matricola.setFont(new Font("Candara", Font.BOLD, 14));
		matricola.setBounds(375, 50, 200, 30);
		
		txtPwd  = new JLabel("Password:");
		txtPwd.setFont(new Font("Candara", Font.PLAIN, 16));
		txtPwd.setForeground(new Color( 51, 51, 51));
		txtPwd.setBounds(300, 90, 200, 35);
		
		pwd= new JPasswordField(17);
		pwd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		pwd.setFont(new Font("Candara", Font.BOLD, 14));
		pwd.setBounds(375, 90, 200, 30);

		btnLogin = new JButton();
		btnLogin.setBounds(525 ,130,50,30);
		btnLogin.setBackground(new Color(70, 73, 96));
		btnLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		btnLogin.setLayout(null);
		JLabel se;

			se=new JLabel( new ImageIcon("image/next.png"));
			se.setBounds(16,5,20,20);
			btnLogin.add(se);
		
		btnAdmin = new JButton()
				;
		btnLogin.addActionListener(this); //Definizione listener del buttone di login come Classe corrente
										  //il suo listener e' un metodo di questa classe
		pwd.setActionCommand("set");
		pwd.addActionListener(this); // Login con invio, Definizione del listener del tasto invio
									 // il suo listener e' un metodo di qesta classe
		
		btnAdmin.addActionListener(this);//Definizione listener del buttone di creazione account come Classe corrente
										  //il suo listener e' un metodo di questa classe
		btnAdmin.setBorder(null);
		btnAdmin.setBounds(375 ,170,200,35);
		btnAdmin.setBackground(new Color(70, 73, 96));
		btnAdmin.setLayout(null);
		JLabel lo=new JLabel("Accedere come amministratore");
		lo.setFont(new Font("Candara", Font.BOLD, 14));
		lo.setForeground(new Color(255,255,255));
		lo.setBounds(5,6,300,25);
		btnAdmin.add(lo);
		

		grid.add(txtMatr);
		grid.add(matricola);                     
		
		grid.add(txtPwd);
		grid.add(pwd);					  
		
		grid.add(btnLogin);
		grid.add(btnAdmin);
		
	
		
		JLabel descr = new JLabel("<html> <center>------------------------------------------------------------</center> " +
				"<center>Benvenuto, Questo Sistema ti permette di gestire il tuo orario universitario.<br />"
				+ "Per effettuare l'accesso devi inserire la tua matricola e la tua password</center>" +
				"<center>Se non disponi ancora delle credenziali di accesso, "
				+ "devi contattare l'amministratore del sistema per fartegli dare.</center>"
				+ "<center>------------------------------------------------------------</center></html>");
		
		descr.setFont(new Font("Candara", Font.BOLD, 16));
		descr.setForeground(new Color( 51, 51, 51));
		descr.setBounds(75,200, 800, 200);
		
		grid.add(descr);					 
		
		grid.setBackground(new Color(255, 255, 255));

		this.add(grid,BorderLayout.CENTER); //aggiunta del JPanel grid al JPanel principale(this) in posizione CENTRO

		JPanel foot = new JPanel();
		foot.setLayout(null);
		foot.setBackground(new Color(64, 66, 87));

		this.add(foot,BorderLayout.SOUTH); //aggiunta di foot al JPanel principale(this) in posizione SUD

	}

	/** Funzione per segnalare gli eventuali errori **/
	private void updatePanel(Boolean succes) {

		JLabel msg= new JLabel("Login errato");
		if(!succes) {
			JOptionPane.showMessageDialog(null,msg,"Login",JOptionPane.ERROR_MESSAGE); 
			//matricola.setText("");
			pwd.setText("");
		}
	}

	/** Metodo per abilitare il login premendo invio una volta nel campo password **/
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
			login();
		}
	}

	/** Gestisce l'azione del pulsante che invia il login e del pulsante di login come admin**/
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		if (e.getSource() == btnLogin || cmd.equals("set")) {
			login();

		}
		else{
			
			if(e.getSource() == btnAdmin){
				loginAdmin();
			}
			
		}
		
	}

	@SuppressWarnings("deprecation")
	/** Metodo che effettua il login **/
	private void login() {

		ResultSet rs;
		try {
			/* Eseguo una query specificando matricola e password */
			rs = Database.Query("SELECT s.* FROM studente s WHERE s.matricola = '"+matricola.getText()+"' AND s.pwd = '"+pwd.getText()+"'", Database.getConn(), true);
			//rs riceve il risultato dell'interogazione seguente:Selezionare dalla database tutti gli studente avendo come matricola il contenuto 
			//del campo matricola e come password il contenuto del campo pwd
			
			if(!rs.next()) updatePanel(false);
			else{
				/* Creo utente */
				logged.setMatricolaUtente(rs.getInt("matricola"));
				
				Window.openUserPanel();
				matricola.setText("");
				pwd.setText("");
				updatePanel(true);
				
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	/** Metodo che ritorna l'utente che ha fatto il login **/
	public static User getUser() {
		return logged;  //ritorno l'utente che ha fatto il login
	}
	
	/** Metodo che effetua il login come Admin **/
	private void loginAdmin(){

		
		JPasswordField pf = new JPasswordField();
		
		int ok = JOptionPane.showConfirmDialog(null, pf, "Inserire la password : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (ok == JOptionPane.OK_OPTION) {
			
		  String pass = new String(pf.getPassword());
		  
		  ResultSet rs;
			
			try {
				/* Eseguo una query specificando la password dell'admin */
				rs = Database.Query("SELECT a.* FROM amministratore a WHERE a.pwd = '"+pass+"'", Database.getConn(), true);
				
				if(!rs.next()) updatePanel(false);
				else{
					
					Window.openAdminPanel();
					updatePanel(true);
					
				}
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}
		
		}
		
		
}
