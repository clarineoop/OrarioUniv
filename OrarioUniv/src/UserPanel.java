
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.sql.ResultSet;
import java.sql.SQLException;


@SuppressWarnings("serial")

/** Classe che gestisce L'UserPanel.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del logout da parte dell'utente.
 */	

public class UserPanel extends JPanel  implements ActionListener {
	
	JLabel background;
	
	
	JPanel content = new JPanel(); //creazione di un JPanel content che verra' posto in centro del JPanel principale
	JPanel left=new JPanel();
	
	JLabel nomeA = new JLabel(), cognomeA = new JLabel(), statut = new JLabel();
	
	JPanel home=new JPanel();
	JPanel studenti=new JPanel();
	JPanel lezioni=new JPanel();
	JPanel esami=new JPanel();
	JPanel materie=new JPanel();
	JPanel corsi=new JPanel();
	JPanel libreti=new JPanel();
	
	
	/** Costruttore che costruisce l'AdminPanel**/ 
	public UserPanel() {

		super(); //chiamo il contruttore della superclasse JPanel che la classe corrente estende

		this.setLayout(null); //settaggio del tipo di Layout a BorderLayout
												 //che divide il JPanel in 5 parte(NORTH, SOUTH, EAST, WEST)

		
	/**Design della pagina in generale**/	
	
	
		
		this.setBackground(new Color(245, 245, 245)); //settaggio del colore di backgroung del JPanel principale(this)

		background = new JLabel( new ImageIcon("image/fondo1.jpg"));
		background.setBounds(0,0,1200,730);
		//this.add(background);

		this.setLayout(null);
		
		JPanel top=new JPanel(); 
		top.setBounds(250,0,950,50);
		this.add(top); //aggiungo top al JPanel principale
		top.setBackground( new Color(255, 255, 255) );
	    top.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 25)));

		content.setBackground(new Color(245, 245, 245));
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(250,50,943,572);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
		this.add(scrollPane);
		
		content.add(new HomeUser());
		
		/**Design del SCrollBar**/
		scrollPane.getVerticalScrollBar().setOpaque(false);
		
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		      private final Dimension d = new Dimension();
		      @Override protected JButton createDecreaseButton(int orientation) {
		        return new JButton() {
		          @Override public Dimension getPreferredSize() {
		            return d;
		          }
		        };
		      }
		      @Override protected JButton createIncreaseButton(int orientation) {
		        return new JButton() {
		          @Override public Dimension getPreferredSize() {
		            return d;
		          }
		        };
		      }
		      @Override
		      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
		      @Override
		      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		        Graphics2D g2 = (Graphics2D)g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		                            RenderingHints.VALUE_ANTIALIAS_ON);
		        Color color = null;
		        JScrollBar sb = (JScrollBar)c;
		        if(!sb.isEnabled() || r.width>r.height) {
		          return;
		        }else if(isDragging) {
		          color = new Color(70,73,96,60);
		        }else if(isThumbRollover()) {
		          color = new Color(70,73,96,60);
		        }else {
		          color = new Color(70,73,96,60);
		        }
		        g2.setPaint(color);
		        g2.fillRoundRect(r.x,r.y,r.width,r.height,18,18);
		        g2.setPaint(Color.WHITE);
		        g2.drawRoundRect(r.x,r.y,r.width,r.height,18,18);
		        g2.dispose();
		      }
		      @Override
		      protected void setThumbBounds(int x, int y, int width, int height) {
		        super.setThumbBounds(x, y, width, height);
		        scrollbar.repaint();
		      }
		    });
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	
		

		left.setBounds(0,0,250,650);
		left.setBackground( new Color(70, 73, 96) );
		this.add(left);
		
		/*JPanel bottom=new JPanel();
		JLabel copy=new JLabel("<html><center>© Copyright 2016</center></html>",JLabel.CENTER);
		copy.setForeground(new Color(255,255,255));
		bottom.add(copy);
		bottom.setBounds(200,600,800,50);
		bottom.setBackground( new Color(164, 113, 198) );
		this.add(bottom);*/
		
		
	/**Design del JPanel left in generale**/
		
		left.setLayout(null);
		Color borderleft=new Color(164,113,198);
		
		/*Gestione USER*/
		JPanel user=new JPanel();
		user.setBackground( new Color(64, 66, 87) );
		user.setBounds(0,0,250,100);
		user.setLayout(null);
		JLabel p;
		
			p=new JLabel( new ImageIcon("image/user.png"));
			p.setBounds(20,13,50,50);
			
			user.add(p);

		
		ResultSet rs;
		
		try{
			
			rs = Database.Query("select nome_studente, cognome_studente from studente "
					+ "where matricola = "+LoginPanel.logged.getMatricolaUtente()+"", Database.getConn(), true);
			if(rs.next()){
				nomeA.setText(rs.getString("nome_studente"));
				cognomeA.setText(rs.getString("cognome_studente"));
			}
			
		}catch(SQLException e){
			
		}
		
		statut=new JLabel("Studente");
		nomeA.setFont(new Font("Candara", Font.BOLD, 14));
		nomeA.setForeground(new Color(255,255,255));
		nomeA.setBounds(80,23,100,15);
		cognomeA.setFont(new Font("Candara", Font.BOLD, 14));
		cognomeA.setForeground(new Color(255,255,255));
		cognomeA.setBounds(80,41,100,15);
		statut.setFont(new Font("Candara", Font.BOLD, 14));
		statut.setForeground(new Color(255,255,255,150));
		statut.setBounds(80,59,100,15);
		user.add(nomeA);
		user.add(cognomeA);
		user.add(statut);
		left.add(user);
	
		
		JLabel rub=new JLabel("RUBRICHE");
		rub.setForeground(new Color(255,255,255,150));
		rub.setBounds(20,120,230,30);
		rub.setFont(new Font("Candara", Font.BOLD, 14));
		left.add(rub);
	
		/*Gestione HOME*/

		home.setBounds(0,155,250,30);
		home.setBackground(null);
		home.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, borderleft));
		home.setLayout(null);
		JLabel h;
		JLabel f;

		h=new JLabel( new ImageIcon("image/h.png"));
		h.setBounds(20,2,20,20);
		
		f=new JLabel( new ImageIcon("image/f.png"));
		f.setBounds(210,2,20,20);
		
		home.add(h);
		home.add(f);
		
		JLabel h1=new JLabel("Home");
		h1.setFont(new Font("Candara", Font.BOLD, 14));
		h1.setForeground(new Color(255,255,255,150));
		h1.setBounds(60,0,150,30);
		home.add(h1);
		left.add(home);
		
		mousehover(home, h1, "image/hw.png", "image/h.png");
		
		
		/*Gestione LEZIONI*/

		lezioni.setBounds(0,195,250,30);
		lezioni.setBackground(null);
		lezioni.setLayout(null);
		JLabel l;
		JLabel f2;

		l=new JLabel( new ImageIcon("image/l.png"));
		l.setBounds(20,2,20,20);
		f2=new JLabel( new ImageIcon("image/f.png"));
		f2.setBounds(210,2,20,20);
		lezioni.add(l);
		lezioni.add(f2);

		JLabel l1=new JLabel("Lezioni");
		l1.setFont(new Font("Candara", Font.BOLD, 14));
		l1.setForeground(new Color(255,255,255,150));
		l1.setBounds(60,0,150,30);
		lezioni.add(l1);
		left.add(lezioni);
		
		mousehover(lezioni, l1, "image/lw.png", "image/l.png");
		
		/*Gestione ESAMI*/

		esami.setBounds(0,235,250,30);
		esami.setBackground(null);
		esami.setLayout(null);
		JLabel e;
		JLabel f3;

		e=new JLabel( new ImageIcon("image/e.png"));
		e.setBounds(20,2,20,20);
		f3=new JLabel( new ImageIcon("image/f.png"));
		f3.setBounds(210,2,20,20);
		esami.add(e);
		esami.add(f3);

		JLabel e1=new JLabel("Esami");
		e1.setFont(new Font("Candara", Font.BOLD, 14));
		e1.setForeground(new Color(255,255,255,150));
		e1.setBounds(60,0,150,30);
		esami.add(e1);
		left.add(esami);
		
		mousehover(esami, e1, "image/ew.png", "image/e.png");
		
		/*Gestione MATERIE*/

		materie.setBounds(0,275,250,30);
		materie.setBackground(null);
		materie.setLayout(null);
		JLabel m;
		JLabel f4;

		m=new JLabel( new ImageIcon("image/m.png"));
		m.setBounds(20,2,20,20);
		f4=new JLabel( new ImageIcon("image/f.png"));
		f4.setBounds(210,2,20,20);
		materie.add(m);
		materie.add(f4);

		JLabel m1=new JLabel("Materie");
		m1.setFont(new Font("Candara", Font.BOLD, 14));
		m1.setForeground(new Color(255,255,255,150));
		m1.setBounds(60,0,150,30);
		materie.add(m1);
		left.add(materie);
		
		mousehover(materie, m1, "image/mw.png", "image/m.png");
				
		/*Gestione LIBRETI*/

		libreti.setBounds(0,315,250,30);
		libreti.setBackground(null);
		libreti.setLayout(null);
		JLabel li;
		JLabel f6;

		li=new JLabel( new ImageIcon("image/li.png"));
		li.setBounds(20,2,20,20);
		f6=new JLabel( new ImageIcon("image/f.png"));
		f6.setBounds(210,2,20,20);
		libreti.add(li);
		libreti.add(f6);

		JLabel li1=new JLabel("Libretto");
		li1.setFont(new Font("Candara", Font.BOLD, 14));
		li1.setForeground(new Color(255,255,255,150));
		li1.setBounds(60,0,150,30);
		libreti.add(li1);
		left.add(libreti);
		
		mousehover(libreti, li1, "image/liw.png", "image/li.png");
		
		
		/**Design del JPanel top in generale**/
		
		
		top.setLayout(null);
		UIManager.put("Button.select", new Color(0, 0, 0, 64));
		JPanel Logop = new JPanel();
		Logop.setLayout(null);
		Logop.setBorder(null);
		Logop.setBounds(-30,-3,400,50);
		Logop.setBackground(null);
		
		JLabel se;

			se=new JLabel( new ImageIcon("image/logo.png"));
			se.setBounds(0,0,200,50);
		Logop.add(se);
		top.add(Logop);

		JButton logout = new JButton();
		logout.setBounds(810,7,100,35);
		logout.setBorder(null);
		logout.setBackground(new Color(70, 73, 96));
		logout.setLayout(null);
		JLabel lo=new JLabel("Sign Out");
		lo.setFont(new Font("Candara", Font.BOLD, 14));
		lo.setForeground(new Color(255,255,255));
		lo.setBounds(25,6,60,25);
		logout.add(lo);
		top.add(logout);
		
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
						null,
						"Sicuro di voler scolegarti?",
						"Scolegarti?",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

				if(n == JOptionPane.YES_OPTION) {
					
					Window.logOut();
					
				}

			}
			
		});
		
			
		/**1- Geszione del click sulle voci di left**/
		onclick(home,lezioni, esami, materie, libreti, 1, content, this);
		onclick(lezioni, home, esami, materie, libreti, 2, content, this);
		onclick(esami, home, lezioni, materie, libreti, 3, content, this);
		onclick(materie, home, lezioni, esami, libreti, 4, content, this);
		onclick(libreti, home, lezioni, esami, materie, 5, content, this);
		
	}


	public void actionPerformed(ActionEvent e) {

	}
		
	/**metodo per gestire il passaggio del mouse sulle diverse voci del JPanel left**/
	public void mousehover(JPanel panel, JLabel l, String s, String s1){
		
		panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
            	panel.setBackground(new Color(64, 66, 87));
            	panel.removeAll();
            	l.setForeground(new Color(255,255,255));
            	panel.add(l);
            	JLabel la2,la3;
            	
            		la2=new JLabel( new ImageIcon(s));
            		la2.setBounds(20,2,20,20);
            		la3=new JLabel( new ImageIcon("image/fw.png"));
            		la3.setBounds(210,2,20,20);
            		panel.add(la2);
            		panel.add(la3);
 
            }
            
            @Override
            public void mouseExited(MouseEvent me) {
            	panel.setBackground(null);
            	panel.removeAll();
            	l.setForeground(new Color(255,255,255,150));
            	panel.add(l);
            	JLabel la2,la3;

            		la2=new JLabel( new ImageIcon(s1));
            		la2.setBounds(20,2,20,20);
            		la3=new JLabel( new ImageIcon("image/f.png"));
            		la3.setBounds(210,2,20,20);
            		panel.add(la2);
            		panel.add(la3);

            }
        });
		
	}
	
	/**metodo per gestire il click sulle diverse voci del JPanel left**/
	public void onclick(JPanel p, JPanel a1, JPanel a2, JPanel a3, JPanel a4, int x, JPanel content, JPanel adminpanel){
		
		Color borderleft=new Color(164,113,198);
		p.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {
            	p.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, borderleft));
            	a1.setBorder(null);
            	a2.setBorder(null);
            	a3.setBorder(null);
            	a4.setBorder(null);
            	
            	content.setLayout(null);
            	
            	
            	if(x==1){
            		content.removeAll();
            		content.add(new HomeUser());
            		content.updateUI();
            	}
            	
            	if(x==2){
            	
            		content.removeAll();
            		JScrollPane cor= new LezioniUser();
            		cor.setBackground(null);
            		content.add(cor);
            		content.updateUI();
            	}
            	if(x==3){
            		content.removeAll();
            		JScrollPane cor= new EsamiUser();
            		cor.setBackground(null);
            		content.add(cor);
            		content.updateUI();
            		
            	}
            	if(x==4){
            		content.removeAll();
            		JScrollPane cor= new MaterieUser();
            		cor.setBackground(null);
            		content.add(cor);
            		content.updateUI();
            	}
            	if(x==5){
            		content.removeAll();
            		JScrollPane cor= new LibrettoUser();
            		cor.setBackground(null);
            		content.add(cor);
            		content.updateUI();
            	}
            }
            
		});
		
	}

}
