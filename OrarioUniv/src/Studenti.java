
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce i studenti del sistema.
 * permette ricercare studenti nel sistema
  **/


public class Studenti extends JScrollPane{
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel studentiP = new JPanel();
	JPanel studenti = new JPanel();
	JPanel edit = new JPanel();
	JPanel aggPanel = new JPanel();
	JPanel modifPanel = new JPanel();
	JPanel success = new JPanel();
	JPanel error = new JPanel();
	JPanel errorInt = new JPanel();
	JPanel success1 = new JPanel();
	JPanel errorAtt = new JPanel();
	JPanel error1 = new JPanel();
	JPanel errorInt1 = new JPanel();
	JPanel errorVuoto1 = new JPanel();
	JPanel errorVuotoC = new JPanel();
	JPanel errorVuotoC2 = new JPanel();
	JPanel errorVuoto2 = new JPanel();
	
	JPanel searchp = new JPanel();
	JButton searchb = new JButton();
	JTextField search = new JTextField();
	JPanel stui=new JPanel();
	
	JLabel titolo = new JLabel("Studenti");
	JLabel titolo1 = new JLabel("Trovare studenti tramite nome, cognome o matricola, scrivere [all] per tutti gli studenti");
	JLabel agg = new JLabel("Aggiungere");
	JLabel agg1 = new JLabel("Aggiungi un nuovo studente");
	JLabel modif = new JLabel("Modificare/Cancellare");
	JLabel modif1 = new JLabel("Modifica o cancella uno studente");
	
	JLabel nomeAdd = new JLabel("Nome:");
	JLabel cognomeAdd = new JLabel("Cognome:");
	JLabel pwdAdd = new JLabel("Password:");
	JLabel corsoAdd = new JLabel("Corso:");
	JLabel annoAdd = new JLabel("Anno:");
	
	
	JLabel matricolaModif = new JLabel("Matricola:");
	JLabel nomeModif = new JLabel("Nome:");
	JLabel cognomeModif = new JLabel("Cognome:");
	JLabel pwdModif = new JLabel("Password:");
	JLabel corsoModif = new JLabel("Corso:");
	JLabel annoModif = new JLabel("Anno:");
	
	JTextField nomeFAdd = new JTextField();
	JTextField cognomeFAdd = new JTextField();
	JTextField pwdFAdd = new JTextField();
	@SuppressWarnings("rawtypes")
	JComboBox corsoFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox annoFAdd = new JComboBox();
	
	JTextField matricolaFModif = new JTextField();
	JTextField nomeFModif = new JTextField();
	JTextField cognomeFModif = new JTextField();
	JTextField pwdFModif = new JTextField();
	@SuppressWarnings("rawtypes")
	JComboBox corsoFModif = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox annoFModif = new JComboBox();
	
	JButton okAdd = new JButton();
	
	JButton okModif = new JButton();
	JButton okCancel = new JButton();
	
	ArrayList<String> codici = new ArrayList<>();
	
	
	@SuppressWarnings("unchecked")
	Studenti(){
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(studentiP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(edit);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		studentiP.setLayout(new BorderLayout());
		studentiP.setBackground(null);
		studentiP.add(title, BorderLayout.NORTH);
		studentiP.add(studenti, BorderLayout.CENTER);

		
		studenti.setLayout(new BoxLayout(studenti, BoxLayout.PAGE_AXIS));

		
		edit.setLayout(new BoxLayout(edit, BoxLayout.LINE_AXIS));
		edit.setBackground(null);
		edit.setPreferredSize(new Dimension(426, 400));

		title.setLayout(null);
		titolo.setBounds(20,25, 100, 30);
		titolo1.setBounds(105,30, 600, 25);
		titolo.setFont(new Font("Candara", Font.PLAIN, 23));
		titolo.setForeground(new Color( 51, 51, 51));
		titolo1.setFont(new Font("Candara", Font.PLAIN, 15));
		titolo1.setForeground(new Color(153,153,153));
		
		title.add(titolo);
		title.add(titolo1);
		title.setPreferredSize(new Dimension(300, 60));
		
		title.setBackground(null);

		
		this.setViewportView(content);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setBounds(0,0,945,572);
        this.setBorder(BorderFactory.createEmptyBorder());
	
		aggPanel.setLayout(null);
		aggPanel.setBackground(new Color(255,255,255));
		aggPanel.setPreferredSize(new Dimension(100, 50));

		modifPanel.setLayout(null);
		modifPanel.setBackground(new Color(255,255,255));
		modifPanel.setPreferredSize(new Dimension(100, 100));

		
		agg.setBounds(15,15, 110, 30);
		agg1.setBounds(118,20, 200, 25);
		agg.setFont(new Font("Candara", Font.PLAIN, 20));
		agg.setForeground(new Color( 51, 51, 51, 190));
		agg1.setFont(new Font("Candara", Font.PLAIN, 13));
		agg1.setForeground(new Color(153,153,153));
		
		nomeAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		nomeAdd.setForeground(new Color( 51, 51, 51));
		nomeAdd.setBounds(30, 100, 100, 30);
		
		cognomeAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		cognomeAdd.setForeground(new Color( 51, 51, 51));
		cognomeAdd.setBounds(30, 140, 130, 30);
		
		pwdAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		pwdAdd.setForeground(new Color( 51, 51, 51));
		pwdAdd.setBounds(30, 180, 130, 30);
		
		corsoAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		corsoAdd.setForeground(new Color( 51, 51, 51));
		corsoAdd.setBounds(30, 220, 130, 30);
		
		annoAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		annoAdd.setForeground(new Color( 51, 51, 51));
		annoAdd.setBounds(30, 260, 130, 30);
		
		nomeFAdd.setBounds(145, 100, 250, 30);
		nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		nomeFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		cognomeFAdd.setBounds(145, 140, 250, 30);
		cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		cognomeFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		pwdFAdd.setBounds(145, 180, 250, 30);
		pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		pwdFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		corsoFAdd.setBounds(145, 220, 250, 30);
		corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		corsoFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		annoFAdd.setBounds(145, 260, 250, 30);
		annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		annoFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		okAdd.setBounds(345,300,50,30);
		okAdd.setBackground(new Color(70, 73, 96));
		okAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okAdd.setLayout(null);
		JLabel se;

			se=new JLabel( new ImageIcon("image/+.png"));
			se.setBounds(16,5,20,20);
			okAdd.add(se);

		
		modif.setBounds(15,15, 200, 30);
		modif1.setBounds(202,20, 200, 25);
		modif.setFont(new Font("Candara", Font.PLAIN, 20));
		modif.setForeground(new Color( 51, 51, 51, 190));
		modif1.setFont(new Font("Candara", Font.PLAIN, 13));
		modif1.setForeground(new Color(153,153,153));
		
		matricolaModif.setFont(new Font("Candara", Font.PLAIN, 16));
		matricolaModif.setForeground(new Color( 51, 51, 51));
		matricolaModif.setBounds(30, 70, 130, 30);
		
		nomeModif.setFont(new Font("Candara", Font.PLAIN, 16));
		nomeModif.setForeground(new Color( 51, 51, 51));
		nomeModif.setBounds(30, 150, 50, 30);
		
		cognomeModif.setFont(new Font("Candara", Font.PLAIN, 16));
		cognomeModif.setForeground(new Color( 51, 51, 51));
		cognomeModif.setBounds(30, 190, 130, 30);
		
		pwdModif.setFont(new Font("Candara", Font.PLAIN, 16));
		pwdModif.setForeground(new Color( 51, 51, 51));
		pwdModif.setBounds(30, 230, 130, 30);
		
		corsoModif.setFont(new Font("Candara", Font.PLAIN, 16));
		corsoModif.setForeground(new Color( 51, 51, 51));
		corsoModif.setBounds(30, 270, 130, 30);
		
		annoModif.setFont(new Font("Candara", Font.PLAIN, 16));
		annoModif.setForeground(new Color( 51, 51, 51));
		annoModif.setBounds(30, 310, 130, 30);
		
		matricolaFModif.setBounds(145, 70, 250, 30);
		matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		matricolaFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		nomeFModif.setBounds(145, 150, 250, 30);
		nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		nomeFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		cognomeFModif.setBounds(145, 190, 250, 30);
		cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		cognomeFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		pwdFModif.setBounds(145, 230, 250, 30);
		pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		pwdFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		corsoFModif.setBounds(145, 270, 250, 30);
		corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		corsoFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		annoFModif.setBounds(145, 310, 250, 30);
		annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		annoFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		okModif.setBounds(345,350,50,30);
		okModif.setBackground(new Color(70, 73, 96));
		okModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okModif.setLayout(null);
		JLabel se1;

			se1=new JLabel( new ImageIcon("image/editw.png"));
			se1.setBounds(16,5,20,20);
			okModif.add(se1);

		
		okCancel.setBounds(345,110,50,30);
		okCancel.setBackground(new Color(70, 73, 96));
		okCancel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okCancel.setLayout(null);
		JLabel se2;

			se2=new JLabel(new ImageIcon("image/cancelw.png"));
			se2.setBounds(16,5,20,20);
			okCancel.add(se2);

		
		aggPanel.add(agg);
		aggPanel.add(agg1);
		aggPanel.add(nomeAdd);
		aggPanel.add(cognomeAdd);
		aggPanel.add(pwdAdd);
		aggPanel.add(corsoAdd);
		aggPanel.add(annoAdd);
		aggPanel.add(nomeFAdd);
		aggPanel.add(cognomeFAdd);
		aggPanel.add(pwdFAdd);
		aggPanel.add(corsoFAdd);
		aggPanel.add(annoFAdd);
		aggPanel.add(okAdd);
		

		
		modifPanel.add(modif);
		modifPanel.add(modif1);
		modifPanel.add(matricolaModif);
		modifPanel.add(nomeModif);
		modifPanel.add(cognomeModif);
		modifPanel.add(pwdModif);
		modifPanel.add(corsoModif);
		modifPanel.add(annoModif);
		modifPanel.add(matricolaFModif);
		modifPanel.add(okCancel);
		modifPanel.add(nomeFModif);
		modifPanel.add(cognomeFModif);
		modifPanel.add(pwdFModif);
		modifPanel.add(corsoFModif);
		modifPanel.add(annoFModif);
		modifPanel.add(okModif);


		
		edit.setBackground(null);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		edit.add(aggPanel);
		edit.add(Box.createRigidArea(new Dimension(50,0)));
		edit.add(modifPanel);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		
		/**contenuto dei JComboBox corso**/
		
		ResultSet rs;
		
		try{
			rs = Database.Query("SELECT * FROM corso", Database.getConn(), true);
			
				while(rs.next()){
					corsoFAdd.addItem(rs.getString("nome"));
					corsoFModif.addItem(rs.getString("nome"));
					codici.add(rs.getString("codice"));
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		/**contenuto dei JComboBox anno**/
		
		int num_anni=0;
		ResultSet reset;
		
		try{
			reset = Database.Query("SELECT * FROM corso "
					+ "where codice = '"+codici.get(corsoFAdd.getSelectedIndex())+"'", Database.getConn(), true);
			
				if(reset.next()){
					num_anni=reset.getInt("num_anni");
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		int x=1;
		while(x<=num_anni){
			annoFAdd.addItem(Integer.toString(x));
			x++;
		}
		
		
		try{
			reset = Database.Query("SELECT * FROM corso "
					+ "where codice = '"+codici.get(corsoFModif.getSelectedIndex())+"'", Database.getConn(), true);
			
				if(reset.next()){
					num_anni=reset.getInt("num_anni");
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		

		x=1;
		while(x<=num_anni){
			annoFModif.addItem(Integer.toString(x));
			x++;
		}
		/****/
		
		corsoFAdd.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent arg0) {
		         stateChanged();
		    }
		});
		
		corsoFModif.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent arg0) {
		         stateChanged2();
		    }
		});
	
		
		/**definizione di success**/
		success.setBounds(110, 300, 230, 30);
		success.setLayout(null);
		success.setBackground(null);
		JLabel s1=new JLabel(); 

			s1=new JLabel( new ImageIcon("image/success.png"));
			s1.setBounds(0,5,20,20);
			success.add(s1);

		JLabel t1= new JLabel("Operazione eseguita con successo");
		t1.setFont(new Font("Candara", Font.BOLD, 14));
		t1.setForeground(new Color(129, 199, 132));
		t1.setBounds(22,10,230,20);
		success.add(t1);
		aggPanel.add(success);
		success.setVisible(false);
		
		
		/**definizione di errorVuoto1**/
		errorVuoto1.setBounds(135, 300, 300, 30);
		errorVuoto1.setLayout(null);
		errorVuoto1.setBackground(null);
		JLabel s3=new JLabel(); 

			s3=new JLabel( new ImageIcon("image/warning.png"));
			s3.setBounds(0,5,20,20);
			errorVuoto1.add(s3);

		JLabel t3= new JLabel("Il campo non deve essere vuoto");
		t3.setFont(new Font("Candara", Font.BOLD, 14));
		t3.setForeground(new Color(216, 150, 54));
		t3.setBounds(22,11,290,20);
		errorVuoto1.add(t3);
		aggPanel.add(errorVuoto1);
		errorVuoto1.setVisible(false);
		
		/**definizione di errorVuotoC**/
		errorVuotoC.setBounds(87, 300, 300, 30);
		errorVuotoC.setLayout(null);
		errorVuotoC.setBackground(null);
		JLabel sc=new JLabel(); 

			sc=new JLabel( new ImageIcon("image/warning.png"));
			sc.setBounds(0,5,20,20);
			errorVuotoC.add(sc);

		JLabel tc= new JLabel("Nessun elemento presente nel sistema");
		tc.setFont(new Font("Candara", Font.BOLD, 14));
		tc.setForeground(new Color(216, 150, 54));
		tc.setBounds(22,11,290,20);
		errorVuotoC.add(tc);
		aggPanel.add(errorVuotoC);
		errorVuotoC.setVisible(false);
		
		/**definizione di errorVuotoC2**/
		errorVuotoC2.setBounds(85, 350, 300, 30);
		errorVuotoC2.setLayout(null);
		errorVuotoC2.setBackground(null);
		JLabel sc1=new JLabel(); 

			sc1=new JLabel( new ImageIcon("image/warning.png"));
			sc1.setBounds(0,5,20,20);
			errorVuotoC2.add(sc1);

		JLabel tc1= new JLabel("Nessun elemento presente nel sistema");
		tc1.setFont(new Font("Candara", Font.BOLD, 14));
		tc1.setForeground(new Color(216, 150, 54));
		tc1.setBounds(22,11,290,20);
		errorVuotoC2.add(tc1);
		modifPanel.add(errorVuotoC2);
		errorVuotoC2.setVisible(false);		
		
		/**definizione di errorAtt**/
		errorAtt.setBounds(195, 350, 145, 30);
		errorAtt.setLayout(null);
		errorAtt.setBackground(null);
		JLabel i1=new JLabel(); 

			i1=new JLabel( new ImageIcon("image/error.png"));
			i1.setBounds(0,5,20,20);
			errorAtt.add(i1);

		JLabel te1= new JLabel("Codice non esistente");
		te1.setFont(new Font("Candara", Font.BOLD, 14));
		te1.setForeground(new Color(240, 98, 146));
		te1.setBounds(22,10,130,20);
		errorAtt.add(te1);
		modifPanel.add(errorAtt);
		errorAtt.setVisible(false);

		
		/**definizione di success1**/
		success1.setBounds(115, 350, 230, 30);
		success1.setLayout(null);
		success1.setBackground(null);
		JLabel i2=new JLabel(); 

			i2=new JLabel( new ImageIcon("image/success.png"));
			i2.setBounds(0,5,20,20);
			success1.add(i2);

		JLabel te2= new JLabel("Operazione eseguita con successo");
		te2.setFont(new Font("Candara", Font.BOLD, 14));
		te2.setForeground(new Color(129, 199, 132));
		te2.setBounds(22,10,230,20);
		success1.add(te2);
		modifPanel.add(success1);
		success1.setVisible(false);
		
		/**definizione di errorInt**/
		errorInt1.setBounds(160, 350, 300, 30);
		errorInt1.setLayout(null);
		errorInt1.setBackground(null);
		JLabel i3=new JLabel(); 

			i3=new JLabel( new ImageIcon("image/warning.png"));
			i3.setBounds(0,5,20,20);
			errorInt1.add(i3);

		JLabel te3= new JLabel("Digitare un numero intero");
		te3.setFont(new Font("Candara", Font.BOLD, 14));
		te3.setForeground(new Color(216, 150, 54));
		te3.setBounds(22,11,290,20);
		errorInt1.add(te3);
		modifPanel.add(errorInt1);
		errorInt1.setVisible(false);
		
		/**definizione di errorVuoto2**/
		errorVuoto2.setBounds(125, 350, 300, 30);
		errorVuoto2.setLayout(null);
		errorVuoto2.setBackground(null);
		JLabel i4=new JLabel(); 

			i4=new JLabel( new ImageIcon("image/warning.png"));
			i4.setBounds(0,5,20,20);
			errorVuoto2.add(i4);

		JLabel t4= new JLabel("Il campo non deve essere vuoto");
		t4.setFont(new Font("Candara", Font.BOLD, 14));
		t4.setForeground(new Color(216, 150, 54));
		t4.setBounds(22,11,290,20);
		errorVuoto2.add(t4);
		modifPanel.add(errorVuoto2);
		errorVuoto2.setVisible(false);
		
		
		/**Gestione aggiungimento Studente**/
		
		okAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addStudent();
			}
			
			
		});
		
		/**Gestione modifica corso**/
		
		okModif.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editStudent();
			}
			
			
		});
		
		/**Gestione cancellazione corso**/
		
		okCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteStudent();
			}
			
			
		});
		
		/**Gestione della ricerca di studenti**/
		
		studenti.setBackground(null);

		studenti.add(stui);
		UIManager.put("Button.select", new Color(0, 0, 0, 64));
		stui.setLayout(null);
		stui.setPreferredSize(new Dimension(300, 130));
		


		searchp.setLayout(null);
		searchp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		searchp.setBounds(260,50,350,45);
		searchp.setBackground(new Color(255, 255, 255));

		search.setBounds(10,9,330,30);
		search.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		search.setFont(new Font("Candara", Font.BOLD, 14));
		
		search.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	cerca();
		    }
		});;
		
		searchp.add(search);
		stui.add(searchp);

		searchb.setBounds(610,50,55,45);
		searchb.setBackground(new Color(255, 255, 255));
		searchb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(0, 0, 0, 64)));
		searchb.setLayout(null);
		JLabel ser;

			ser=new JLabel( new ImageIcon("image/search.png"));
			ser.setBounds(16,12,25,25);
			searchb.add(ser);

		stui.add(searchb);
		
		searchb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerca();
			}
			
			
		});
	
	/**Design del SCrollBar**/
	this.getVerticalScrollBar().setOpaque(false);
	
	this.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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
	
	this.getVerticalScrollBar().setUnitIncrement(16);

	}
	
	@SuppressWarnings("unchecked")
	void stateChanged(){
		
		int num_anni=0;
		ResultSet rs;
		
		try{
			rs = Database.Query("SELECT * FROM corso "
					+ "where codice = '"+codici.get(corsoFAdd.getSelectedIndex())+"'", Database.getConn(), true);
			
				if(rs.next()){
					num_anni=rs.getInt("num_anni");
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		annoFAdd.removeAllItems();
		
		int x=1;
		while(x<=num_anni){
			annoFAdd.addItem(Integer.toString(x));
			x++;
		}
		
		aggPanel.updateUI();
		
	}
	
	@SuppressWarnings("unchecked")
	void stateChanged2(){
		
		int num_anni=0;
		ResultSet rs;
		
		try{
			rs = Database.Query("SELECT * FROM corso "
					+ "where codice = '"+codici.get(corsoFModif.getSelectedIndex())+"'", Database.getConn(), true);
			
				if(rs.next()){
					num_anni=rs.getInt("num_anni");
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		annoFModif.removeAllItems();
		
		int x=1;
		while(x<=num_anni){
			annoFModif.addItem(Integer.toString(x));
			x++;
		}
		
		modifPanel.updateUI();
	}

	void cerca(){
		
		if(search.getText().isEmpty()){
			searchp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
		}
		else{
			studenti.removeAll();
			searchp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			searchp.setBounds(20,15,350,45);
			searchb.setBounds(370,15,55,45);
			stui.setPreferredSize(new Dimension(300, 60));
			studenti.add(stui);
			
			//eseguo una query sql che mi faccia la ricerca
			ResultSet rset;
			int num=0;
			int flag=0;
			
			try{
				
				if(search.getText().compareTo("[all]")==0 || search.getText().compareTo("[All]")==0 || search.getText().compareTo("[ALL]")==0){
					//mando una querry per selezionare tutti i corsi di studio presenti nel sistema 	
					rset = Database.Query("select * from studente", Database.getConn(), true);
				}
				else{
				//mando una querry per selezionare tutti i corsi di studio presenti nel sistema rispettando il criterio
				rset = Database.Query("select * from studente s "
						+ "where s.matricola like '"+search.getText()+"%' "
						+ "or s.nome_studente like '"+search.getText()+"%' "
						+ "or s.cognome_studente like '"+search.getText()+"%'; ", Database.getConn(), true);
				}
				while(rset.next()){
					flag=1;
					
					if(num==0){
							JPanel rigat= new JPanel();
							rigat.setPreferredSize(new Dimension(300, 60));
							rigat.setLayout(new BoxLayout(rigat, BoxLayout.LINE_AXIS));
							studenti.add(Box.createRigidArea(new Dimension(0,10)));
							studenti.add(rigat);
							
							JPanel col0=new JPanel();
							JPanel col1=new JPanel();
							JPanel col2=new JPanel();
							JPanel col3=new JPanel();
							JPanel col4=new JPanel();
							JPanel col5=new JPanel();
							
							rigat.add(Box.createRigidArea(new Dimension(20,0)));
							rigat.add(col0);
							rigat.add(col1);
							rigat.add(col2);
							rigat.add(col3);
							rigat.add(col4);
							rigat.add(col5);
							rigat.add(Box.createRigidArea(new Dimension(20,0)));
							
							col0.setBackground(new Color(221, 221, 221));
							col0.setPreferredSize(new Dimension(20, 50));
							col0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col0.setLayout(null);
							JLabel l0=new JLabel("Matricola");
							l0.setBounds(10, 15, 80, 30);
							l0.setFont(new Font("Candara", Font.BOLD, 14));
							l0.setForeground(new Color(0, 0, 0));
							col0.add(l0);
							
							col1.setBackground(new Color(221, 221, 221));
							col1.setPreferredSize(new Dimension(100, 50));
							col1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col1.setLayout(null);
							JLabel l1=new JLabel("Nome");
							l1.setBounds(0, 15, 50, 30);
							l1.setFont(new Font("Candara", Font.BOLD, 14));
							l1.setForeground(new Color(0, 0, 0));
							col1.add(l1);
							
							col2.setBackground(new Color(221, 221, 221));
							col2.setPreferredSize(new Dimension(100, 50));
							col2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col2.setLayout(null);
							JLabel l2=new JLabel("Cognome");
							l2.setBounds(0, 15, 90, 30);
							l2.setFont(new Font("Candara", Font.BOLD, 14));
							l2.setForeground(new Color(0, 0, 0));
							col2.add(l2);
							
							
							col3.setBackground(new Color(221, 221, 221));
							col3.setPreferredSize(new Dimension(100, 50));
							col3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col3.setLayout(null);
							JLabel l3=new JLabel("Password");
							l3.setBounds(0, 15, 60, 30);
							l3.setFont(new Font("Candara", Font.BOLD, 14));
							l3.setForeground(new Color(0, 0, 0));
							col3.add(l3);
							
							col4.setBackground(new Color(221, 221, 221));
							col4.setPreferredSize(new Dimension(100, 50));
							col4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col4.setLayout(null);
							JLabel l4=new JLabel("Corso");
							l4.setBounds(0, 15, 50, 30);
							l4.setFont(new Font("Candara", Font.BOLD, 14));
							l4.setForeground(new Color(0, 0, 0));
							col4.add(l4);
							
							col5.setBackground(new Color(221, 221, 221));
							col5.setPreferredSize(new Dimension(40, 50));
							col5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
							col5.setLayout(null);
							JLabel l5=new JLabel("Anno");
							l5.setBounds(0, 15, 35, 30);
							l5.setFont(new Font("Candara", Font.BOLD, 14));
							l5.setForeground(new Color(0, 0, 0));
							col5.add(l5);
							
							num=1;
					}
					
					JPanel riga= new JPanel();
					riga.setPreferredSize(new Dimension(300, 60));
					riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
					studenti.add(Box.createRigidArea(new Dimension(0,3)));
					studenti.add(riga);
					
					JPanel colr0=new JPanel();
					JPanel colr1=new JPanel();
					JPanel colr2=new JPanel();
					JPanel colr3=new JPanel();
					JPanel colr4=new JPanel();
					JPanel colr5=new JPanel();
					
					riga.add(Box.createRigidArea(new Dimension(20,0)));
					riga.add(colr0);
					riga.add(colr1);
					riga.add(colr2);
					riga.add(colr3);
					riga.add(colr4);
					riga.add(colr5);
					riga.add(Box.createRigidArea(new Dimension(20,0)));
					
					colr0.setBackground(new Color(255, 255, 255));
					colr0.setPreferredSize(new Dimension(20, 50));
					colr0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr0.setLayout(null);
					JLabel lab0=new JLabel(Integer.toString(rset.getInt("matricola")));
					lab0.setBounds(10, 15, 80, 30);
					lab0.setFont(new Font("Candara", Font.BOLD, 14));
					lab0.setForeground(new Color(0, 0, 0));
					colr0.add(lab0);
					
					colr1.setBackground(new Color(255, 255, 255));
					colr1.setPreferredSize(new Dimension(100, 50));
					colr1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr1.setLayout(null);
					JLabel lab1=new JLabel(rset.getString("nome_studente"));
					lab1.setBounds(0, 15, 100, 30);
					lab1.setFont(new Font("Candara", Font.BOLD, 14));
					lab1.setForeground(new Color(0, 0, 0));
					colr1.add(lab1);
					
					colr2.setBackground(new Color(255, 255, 255));
					colr2.setPreferredSize(new Dimension(100, 50));
					colr2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr2.setLayout(null);
					JLabel lab2=new JLabel(rset.getString("cognome_studente"));
					lab2.setBounds(0, 15, 100, 30);
					lab2.setFont(new Font("Candara", Font.BOLD, 14));
					lab2.setForeground(new Color(0, 0, 0));
					colr2.add(lab2);
					
					
					colr3.setBackground(new Color(255, 255, 255));
					colr3.setPreferredSize(new Dimension(100, 50));
					colr3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr3.setLayout(null);
					JLabel lab3=new JLabel(rset.getString("pwd"));
					lab3.setBounds(0, 15, 100, 30);
					lab3.setFont(new Font("Candara", Font.BOLD, 14));
					lab3.setForeground(new Color(0, 0, 0));
					colr3.add(lab3);
					
					colr4.setBackground(new Color(255, 255, 255));
					colr4.setPreferredSize(new Dimension(100, 50));
					colr4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr4.setLayout(null);
					JLabel lab4=new JLabel(rset.getString("corso"));
					lab4.setBounds(0, 15, 150, 30);
					lab4.setFont(new Font("Candara", Font.BOLD, 14));
					lab4.setForeground(new Color(0, 0, 0));
					colr4.add(lab4);
					
					colr5.setBackground(new Color(255, 255, 255));
					colr5.setPreferredSize(new Dimension(40, 50));
					colr5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					colr5.setLayout(null);
					JLabel lab5=new JLabel(Integer.toString(rset.getInt("anno_corso")));
					lab5.setBounds(0, 15, 35, 30);
					lab5.setFont(new Font("Candara", Font.BOLD, 14));
					lab5.setForeground(new Color(0, 0, 0));
					colr5.add(lab5);
					
				}
				

			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			if(flag==0){
				JPanel riga= new JPanel();
				riga.setPreferredSize(new Dimension(300, 60));
				riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
				studenti.add(Box.createRigidArea(new Dimension(0,10)));
				studenti.add(riga);
				JLabel none=new JLabel("Nessun studente trovato!");
				none.setBounds(20, 10, 400, 40);
				none.setFont(new Font("Candara", Font.BOLD, 20));
				none.setForeground(new Color(240, 98, 146));
				JPanel noneP = new JPanel();
				noneP.add(none);
				noneP.setLayout(null);
				noneP.setBackground(new Color(255, 255, 255));
				
				riga.add(Box.createRigidArea(new Dimension(20,0)));
				riga.add(noneP);
				riga.add(Box.createRigidArea(new Dimension(20,0)));
			}
			

			
		studenti.updateUI();
		}
	}
	
	void addStudent(){
		
		if( nomeFAdd.getText().isEmpty()){
			
			success.setVisible(false);
			errorVuotoC.setVisible(false);
			errorVuoto1.setVisible(true);
			nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
		}
		else{
			
			if(cognomeFAdd.getText().isEmpty()){
				
				cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				success.setVisible(false);
				errorVuotoC.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{
				if(pwdFAdd.getText().isEmpty()){
					pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					success.setVisible(false);
					errorVuotoC.setVisible(false);
					errorVuoto1.setVisible(true);
				}
				else{
					if(corsoFAdd.getItemCount() == 0){
						corsoFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
						cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(false);
						errorVuotoC.setVisible(true);
						errorVuoto1.setVisible(false);
					}
					else{
						if(annoFAdd.getItemCount()==0){
							annoFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
							cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							success.setVisible(false);
							errorVuotoC.setVisible(true);
							errorVuoto1.setVisible(false);
						}
						else{

							int x=-1;
							try {  
								Database.Query("INSERT INTO studente(nome_studente, cognome_studente, pwd, corso, anno_corso) "
										+ "VALUES ('"+nomeFAdd.getText()+"', '"+cognomeFAdd.getText()+"', '"+pwdFAdd.getText()+"', '"+codici.get(corsoFAdd.getSelectedIndex())+"', "+annoFAdd.getSelectedItem()+")", Database.getConn(), true);
								x = 1;
							}
								catch (Exception e) {
								}

					if(x == 1){
						corsoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						cognomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						pwdFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						annoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(true);
						errorVuotoC.setVisible(false);
						errorVuoto1.setVisible(false);
						nomeFAdd.setText("");
						cognomeFAdd.setText("");
						pwdFAdd.setText("");
						aggPanel.updateUI();
					}
					
				}
			}
				}
			}
		}
		

	}
	
	void editStudent(){
		
		if( matricolaFModif.getText().isEmpty()){
			
			matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorVuoto2.setVisible(true);
			errorVuotoC2.setVisible(false);
			errorAtt.setVisible(false);
		}
		else{
			
			if(nomeFModif.getText().isEmpty()){
				
				nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorInt1.setVisible(false);
				errorVuoto2.setVisible(true);
				errorVuotoC2.setVisible(false);
				errorAtt.setVisible(false);
			}
			else{
				if(cognomeFModif.getText().isEmpty()){
					cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					
					success1.setVisible(false);
					errorInt1.setVisible(false);
					errorVuoto2.setVisible(true);
					errorVuotoC2.setVisible(false);
					errorAtt.setVisible(false);
				}
				else{
					if(pwdFModif.getText().isEmpty()){
						pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
						matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						
						success1.setVisible(false);
						errorInt1.setVisible(false);
						errorVuoto2.setVisible(true);
						errorVuotoC2.setVisible(false);
						errorAtt.setVisible(false);
					}
					else{
						
						if(corsoFModif.getItemCount() == 0){
							corsoFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
							matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							success1.setVisible(false);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(true);
							errorVuotoC2.setVisible(false);
							errorAtt.setVisible(false);						
							}
						else{
							if(annoFModif.getItemCount()==0){
								annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
								matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								
								success1.setVisible(false);
								errorInt1.setVisible(false);
								errorVuoto2.setVisible(true);
								errorVuotoC2.setVisible(false);
								errorAtt.setVisible(false);
							}

					else{
						
						int x=-1;
						int flag=1;
						
						ResultSet rs;
						try {
							
							try{
								Integer.parseInt(matricolaFModif.getText());
								}catch(Exception e){
									matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
									nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									
									success1.setVisible(false);
									errorInt1.setVisible(true);
									errorVuoto2.setVisible(false);
									errorVuotoC2.setVisible(false);
									errorAtt.setVisible(false);	
									
									flag=0;
								}
							
						if(flag!=0){
						
							/* Eseguo una query specificando il codice attuale */
							rs = Database.Query("SELECT s.* FROM studente s WHERE s.matricola= "+Integer.parseInt(matricolaFModif.getText())+"", Database.getConn(), true);
							
							if(!rs.next()){//se nessun risultato	
								x = 0;					
							}
							else{ //se risultato
								 
									Database.Query("UPDATE studente SET nome_studente='"+nomeFModif.getText()+"', cognome_studente='"+cognomeFModif.getText()+"', pwd='"+pwdFModif.getText()+"', corso='"+codici.get(corsoFModif.getSelectedIndex())+"', anno_corso="+(annoFModif.getSelectedIndex()+1)+" WHERE matricola="+Integer.parseInt(matricolaFModif.getText())+"", Database.getConn(), true);
									x = 1;
									
								}
									
							}
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
						if(x == 0){
							matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
							annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							success1.setVisible(false);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorVuotoC2.setVisible(false);
							errorAtt.setVisible(true);
						}
						if(x == 1){
							matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							matricolaFModif.setText(null);
							nomeFModif.setText(null);
							cognomeFModif.setText(null);
							pwdFModif.setText(null);
							
							success1.setVisible(true);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorVuotoC2.setVisible(false);
							errorAtt.setVisible(false);
							modifPanel.updateUI();

						}

					}

					}
					}
		

				}
			}
		}
}
	
	void deleteStudent(){
		
		int flag=1;
		
		if( matricolaFModif.getText().isEmpty()){
			
			matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorVuoto2.setVisible(true);
			errorVuotoC2.setVisible(false);
			errorAtt.setVisible(false);
		}
		else{;
			int x=-1;
			
			ResultSet rs;
			try {
				try{
				Integer.parseInt(matricolaFModif.getText());
				}catch(Exception e){
					matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					
					success1.setVisible(false);
					errorInt1.setVisible(true);
					errorVuoto2.setVisible(false);
					errorVuotoC2.setVisible(false);
					errorAtt.setVisible(false);	
					
					flag=0;
				}
				
				if(flag!=0){
				/* Eseguo una query specificando la matricola dello studente da cancellare*/
				rs = Database.Query("SELECT s.* FROM studente s WHERE s.matricola= "+Integer.parseInt(matricolaFModif.getText())+"", Database.getConn(), true);
				
				if(!rs.next()){//se nessun risultato	
					x = 0;					
				}
				else{ //se risultato
					Database.Query("delete from studente "
							+ "where studente.matricola="+Integer.parseInt(matricolaFModif.getText())+"", Database.getConn(), true);
					
					matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					
					matricolaFModif.setText("");
					
					success1.setVisible(true);
					errorInt1.setVisible(false);
					errorVuoto2.setVisible(false);
					errorVuotoC2.setVisible(false);
					errorAtt.setVisible(false);
					modifPanel.updateUI();
					
				}
				
				}
				
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
			if(x==0){
				matricolaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
				nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				cognomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				pwdFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				corsoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				annoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorInt1.setVisible(false);
				errorVuoto2.setVisible(false);
				errorVuotoC2.setVisible(false);
				errorAtt.setVisible(true);
	
			}
		
	}
}
	
}
