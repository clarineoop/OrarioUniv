
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")

/**
Classe "principale" del programma, si occupa di gestire le varie finestre
*  invocate via via dai metodi delle altre classi.
*  Si occupa in primo luogo di istanziare la classe per l'apertura del pannello di login.
*  Se il login ha successo, si occupa di aprire la finestra corispondente alla home del programma.
*  NON si occupa della gestione dei pannelli che viene effettuata dalle singole classi, istanzia solo i JFrame.
*  Crea la connessione al database e la passa ai vari pannelli
*/

public class Window extends JFrame{

	private static Database db = new Database();
	private static LoginPanel loginPanel = new LoginPanel();
	
	private static UserPanel userPanel;
	private static AdminPanel adminPanel;
	
	private static Window loginFrame= new Window();
	private static Window userFrame;
	public static Window adminPanelFrame;
	
	/** Costruttore di default, apre la prima finestra (login) **/
	
	public Window() {
		super("Login Panel - Orario Universitario");		
		setBounds(100,100,900,600);
		getContentPane().add(loginPanel);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("image/icon.png");
		setIconImage(img);
		
		/* Listener per la chiusura della finestra -> chiude il programma e la connessione al db */
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {	

				int n = JOptionPane.showConfirmDialog(
						null,
						"Sicuro di voler uscire?",
						"Uscire?",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

				if(n == JOptionPane.YES_OPTION) {
					System.exit(0);
					db.Close();
				}
			}	
		});
		
		
	}
	
	/** Costruttore dati parametri come dimensioni, nome JFrame, usato per tutte le finestre
	 *  eccetto quella di login.
	 */
	
	public Window(int x,int y, int w,int h, String panelName, JScrollPane panel,Boolean exit) {

		super(panelName);
		setBounds(x,y,w, h);
		/* Non posso uscire da queste finestre, mi devo ricondurre alla finestra di login */
		
		getContentPane().add(panel);

		if(exit) {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {	
					
					int n = JOptionPane.showConfirmDialog(
							null,
							"Sicuro di voler scolegarti?",
							"Scolegarti?",
							JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

					if(n == JOptionPane.YES_OPTION) {
						
						if(userFrame != null) userFrame.dispose();
						if(adminPanelFrame != null) adminPanelFrame.dispose();
						loginFrame.setVisible(true);
						
					}

				}
			});
		}
		
	}

	public static void main(String[] args) {
		
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		loginFrame.setLocationRelativeTo(null);
	}
	
	/** Metodo per l'apertura del pannello degli utenti **/
	public static void openUserPanel() {	
		
		userPanel = new UserPanel();
		JScrollPane scroll = new JScrollPane(userPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // aggiungiamo un scrollbar a userPanel
		scroll.setBorder(BorderFactory.createEmptyBorder());
		userFrame = new Window(100,100,1200,650,"User Panel - Orario Universitario",scroll,true);
		loginFrame.dispose();
		userFrame.setVisible(true);
		userFrame.setResizable(false);
		userFrame.setLocationRelativeTo(null); // mettere al centro dello schermo
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("image/icon.png");
		userFrame.setIconImage(img);
	}
	
	/** Metodo per l'apertura del pannello dell'amministratore **/
	public static void openAdminPanel() {	
		
		adminPanel = new AdminPanel();
		JScrollPane scroll = new JScrollPane(adminPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // aggiungiamo un scrollbar a userPanel
		scroll.setBorder(BorderFactory.createEmptyBorder());
		adminPanelFrame = new Window(100,100,1200,650,"Admin Panel - Orario Universitario",scroll,true);
		loginFrame.dispose();
		adminPanelFrame.setVisible(true);
		adminPanelFrame.setResizable(false);
		adminPanelFrame.setLocationRelativeTo(null); // mettere al centro dello schermo
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("image/icon.png");
		adminPanelFrame.setIconImage(img);

	}
	
	
	/** Metodo per efetuare il logout**/
	public static void logOut() {	
		if(userFrame != null) userFrame.dispose();
		if(adminPanelFrame != null) adminPanelFrame.dispose();
		loginFrame.setVisible(true);
	}
	
} 
