
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.sql.ResultSet;
import java.sql.SQLException;


@SuppressWarnings("serial")

/** Classe che gestisce L'AdminPanel.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del logout da parte dell'amministratore.
 */	
public class AdminPanel extends JPanel  implements ActionListener {
	
	JLabel background;
	
	JPanel success = new JPanel();
	JPanel editAPanel = new JPanel();
	
	JLabel nome = new JLabel("Nome:");
	JLabel cognome = new JLabel("cognome:");
	JLabel pwd = new JLabel("Password:");
	
	JTextField nomeF = new JTextField();
	JTextField cognomeF = new JTextField();
	JTextField pwdF = new JTextField();
	
	JButton ok = new JButton();
	
	JLabel agg = new JLabel("Modificare");
	JLabel agg1 = new JLabel("Modifica dei dati dell'amministratore");
	
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
	public AdminPanel() {

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
		
		content.add(new Home());
		
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
		
		
		/*panel invisibile di edit admin*/
		editAPanel.setLayout(null);
		editAPanel.setBackground(new Color(255, 255, 255));
		//editAPanel.setPreferredSize(new Dimension(400,400));
		
		agg.setBounds(15,15, 110, 30);
		agg1.setBounds(118,20, 300, 25);
		agg.setFont(new Font("Candara", Font.PLAIN, 20));
		agg.setForeground(new Color( 51, 51, 51, 190));
		agg1.setFont(new Font("Candara", Font.PLAIN, 13));
		agg1.setForeground(new Color(153,153,153));
		
		nome.setFont(new Font("Candara", Font.PLAIN, 16));
		nome.setForeground(new Color( 51, 51, 51));
		nome.setBounds(30, 100, 100, 30);
		
		cognome.setFont(new Font("Candara", Font.PLAIN, 16));
		cognome.setForeground(new Color( 51, 51, 51));
		cognome.setBounds(30, 140, 130, 30);
		
		pwd.setFont(new Font("Candara", Font.PLAIN, 16));
		pwd.setForeground(new Color( 51, 51, 51));
		pwd.setBounds(30, 180, 130, 30);
		
		nomeF.setBounds(145, 100, 250, 30);
		nomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		nomeF.setFont(new Font("Candara", Font.BOLD, 14));
		
		cognomeF.setBounds(145, 140, 250, 30);
		cognomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		cognomeF.setFont(new Font("Candara", Font.BOLD, 14));
		
		pwdF.setBounds(145, 180, 250, 30);
		pwdF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		pwdF.setFont(new Font("Candara", Font.BOLD, 14));
		
		ok.setBounds(345,220,50,30);
		ok.setBackground(new Color(70, 73, 96));
		ok.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ok.setLayout(null);
		JLabel im;

			im=new JLabel( new ImageIcon("image/editw.png"));
			im.setBounds(16,5,20,20);
			ok.add(im);


				editAPanel.add(agg);
				editAPanel.add(agg1);
				editAPanel.add(nome);
				editAPanel.add(cognome);
				editAPanel.add(pwd);
				editAPanel.add(nomeF);
				editAPanel.add(cognomeF);
				editAPanel.add(pwdF);
				editAPanel.add(ok);
				
			ok.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					editTruly();
				}
				
			});
	
	/**Design del JPanel left in generale**/
		
		left.setLayout(null);
		Color borderleft=new Color(164,113,198);
		
		/*Gestione USER*/
		JPanel user=new JPanel();
		user.setBackground( new Color(64, 66, 87) );
		user.setBounds(0,0,250,100);
		user.setLayout(null);
		JLabel p;
		JLabel t;
		
			p=new JLabel( new ImageIcon("image/user.png"));
			p.setBounds(20,13,50,50);
			
			t=new JLabel( new ImageIcon("image/edit.png"));
			t.setBounds(180,50,20,20);
			
			user.add(p);
			user.add(t);
			
			t.addMouseListener(new MouseAdapter() {

	            @Override
	            public void mouseEntered(MouseEvent me) {

	            	t.setIcon(new ImageIcon("image/editw.png"));

	            }
	            
	            @Override
	            public void mouseClicked(MouseEvent me) {
	            	
		            	editadmin();

	            }
	            
	            @Override
	            public void mouseExited(MouseEvent me) {
	            	
		            	t.setIcon(new ImageIcon("image/edit.png"));

	            }
	        });
			

		

		
		ResultSet rs;
		
		try{
			
			rs = Database.Query("select nome, cognome from amministratore", Database.getConn(), true);
			if(rs.next()){
				nomeA.setText(rs.getString("nome"));
				cognomeA.setText(rs.getString("cognome"));
			}
			
		}catch(SQLException e){
			
		}
		
		statut=new JLabel("Amministratore");
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
		
		
		/*Gestione STUDENTI*/

		studenti.setBounds(0,195,250,30);
		studenti.setBackground(null);
		studenti.setLayout(null);
		JLabel s;
		JLabel f1;

		s=new JLabel( new ImageIcon("image/s.png"));
		s.setBounds(20,2,20,20);
		f1=new JLabel( new ImageIcon("image/f.png"));
		f1.setBounds(210,2,20,20);
		studenti.add(s);
		studenti.add(f1);

		JLabel s1=new JLabel("Studenti");
		s1.setFont(new Font("Candara", Font.BOLD, 14));
		s1.setForeground(new Color(255,255,255,150));
		s1.setBounds(60,0,150,30);
		studenti.add(s1);
		left.add(studenti);
		
		mousehover(studenti, s1, "image/sw.png", "image/s.png");
		
		/*Gestione LEZIONI*/

		lezioni.setBounds(0,235,250,30);
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

		esami.setBounds(0,275,250,30);
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

		materie.setBounds(0,315,250,30);
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
		
		/*Gestione CORSI*/

		corsi.setBounds(0,355,250,30);
		corsi.setBackground(null);
		corsi.setLayout(null);
		JLabel c;
		JLabel f5;

		c=new JLabel( new ImageIcon("image/c.png"));
		c.setBounds(20,2,20,20);
		f5=new JLabel( new ImageIcon("image/f.png"));
		f5.setBounds(210,2,20,20);
		corsi.add(c);
		corsi.add(f5);

		JLabel c1=new JLabel("Corsi");
		c1.setFont(new Font("Candara", Font.BOLD, 14));
		c1.setForeground(new Color(255,255,255,150));
		c1.setBounds(60,0,150,30);
		corsi.add(c1);
		left.add(corsi);
		
		mousehover(corsi, c1, "image/cw.png", "image/c.png");;
		
		/*Gestione LIBRETI*/

		libreti.setBounds(0,395,250,30);
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

		JLabel li1=new JLabel("Libretti");
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
		onclick(home, studenti, lezioni, esami, materie, corsi, libreti, 1, content, this);
		onclick(studenti, home, lezioni, esami, materie, corsi, libreti, 2, content, this);
		onclick(lezioni, home, studenti, esami, materie, corsi, libreti, 3, content, this);
		onclick(esami, home, studenti, lezioni, materie, corsi, libreti, 4, content, this);
		onclick(materie, home, studenti, lezioni, esami, corsi, libreti, 5, content, this);
		onclick(corsi, home, studenti, lezioni, esami, materie, libreti, 6, content, this);
		onclick(libreti, home, studenti, lezioni, esami, materie, corsi, 7, content, this);
		
		
		/**definizione di success**/
		success.setBounds(100, 220, 230, 30);
		success.setLayout(null);
		success.setBackground(null);
		JLabel ima=new JLabel();

			ima=new JLabel( new ImageIcon("image/success.png"));
			ima.setBounds(0,5,20,20);
			success.add(ima);

		JLabel t1= new JLabel("Operazione eseguita con successo");
		t1.setFont(new Font("Candara", Font.BOLD, 14));
		t1.setForeground(new Color(129, 199, 132));
		t1.setBounds(22,10,230,20);
		success.add(t1);
		editAPanel.add(success);
		success.setVisible(false);

	}


	public void actionPerformed(ActionEvent e) {

	}
	
	void editadmin(){
		
		home.setBorder(null);
		studenti.setBorder(null);
    	lezioni.setBorder(null);
    	esami.setBorder(null);
    	materie.setBorder(null);
    	corsi.setBorder(null);
    	libreti.setBorder(null);
    	content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		
		JPanel pan= new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS));
		content.removeAll();
		pan.add(Box.createRigidArea(new Dimension(250,0)));
		pan.add(editAPanel);
		pan.add(Box.createRigidArea(new Dimension(250,0)));
		pan.setBackground(null);
		content.add(Box.createRigidArea(new Dimension(0,70)));
		content.add(pan);
		content.add(Box.createRigidArea(new Dimension(0,200)));
		content.updateUI();
	}
	
	void editTruly(){
		
		if( nomeF.getText().isEmpty()){
					
					nomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					cognomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					pwdF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		}
		else{
			if(cognomeF.getText().isEmpty()){
					cognomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					nomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					pwdF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			}
			else{
				if(pwdF.getText().isEmpty()){
					pwdF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					nomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					cognomeF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				}
				else{
				
						 
							Database.Query("UPDATE amministratore SET nome='"+nomeF.getText()+"', cognome='"+cognomeF.getText()+"', pwd='"+pwdF.getText()+"'", Database.getConn(), true);
							
							success.setVisible(true);
							nomeF.setText(null);
							cognomeF.setText(null);
							pwdF.setText(null);
							
							ResultSet rs;
							
							try{
								
								rs = Database.Query("select nome, cognome from amministratore", Database.getConn(), true);
								if(rs.next()){
									nomeA.setText(rs.getString("nome"));
									cognomeA.setText(rs.getString("cognome"));
								}
								
							}catch(SQLException e){}
								
							
							left.updateUI();
							
					}
					
				}
			}
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
	public void onclick(JPanel p, JPanel a1, JPanel a2, JPanel a3, JPanel a4, JPanel a5, JPanel a6, int x, JPanel content, JPanel adminpanel){
		
		Color borderleft=new Color(164,113,198);
		p.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent event) {
            	p.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, borderleft));
            	a1.setBorder(null);
            	a2.setBorder(null);
            	a3.setBorder(null);
            	a4.setBorder(null);
            	a5.setBorder(null);
            	a6.setBorder(null);
            	
            	content.setLayout(null);
            	
            	
            	if(x==1){
            		content.removeAll();
            		content.add(new Home());
            		content.updateUI();
            	}
            	if(x==2){
            		content.removeAll();
            		content.add(new Studenti());
            		content.updateUI();
            	}
            	if(x==3){
            		content.removeAll();
            		content.add(new Lezioni());
            		content.updateUI();
            	}
            	if(x==4){
            		content.removeAll();
            		content.add(new Esami());
            		content.updateUI();
            		
            	}
            	if(x==5){
            		content.removeAll();
            		content.add(new Materie());
            		content.updateUI();
            	}
            	if(x==6){
            		
            		content.removeAll();
            		
            		JScrollPane cor= new Corsi();
            		//cor.setBounds(0,0,943,572);
            		cor.setBackground(null);
            		content.add(cor);
    
            		adminpanel.updateUI();
            	}
            	if(x==7){
            		content.removeAll();
            		content.add(new Libretti());
            		content.updateUI();
            	}
            }
            
		});
		
	}

}
