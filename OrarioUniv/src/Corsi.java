
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce il panello dei diversi corsi di studio.
 * mostra l'elenco dei corsi disponibili e permette l'aggiunta la supressione e la modifica
  **/


public class Corsi extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel corsiP = new JPanel();
	JPanel corsi = new JPanel();
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
	JPanel errorVuoto2 = new JPanel();
	
	JLabel titolo = new JLabel("Corsi");
	JLabel titolo1 = new JLabel("Corsi di studio");
	JLabel agg = new JLabel("Aggiungere");
	JLabel agg1 = new JLabel("Aggiungi un nuovo corso");
	JLabel modif = new JLabel("Modificare/Cancellare");
	JLabel modif1 = new JLabel("Modifica o cancella un corso");
	
	JLabel codiceAdd = new JLabel("Codice:");
	JLabel nomeAdd = new JLabel("Nome:");
	JLabel anniAdd = new JLabel("Numero di anni:");
	
	JLabel codiceModif1 = new JLabel("Codice attuale:");
	JLabel codiceModif2 = new JLabel("Codice:");
	JLabel nomeModif = new JLabel("Nome:");
	JLabel anniModif = new JLabel("numero di anni:");
	
	JTextField codiceFAdd = new JTextField();
	JTextField nomeFAdd = new JTextField();
	JTextField anniFAdd = new JTextField();
	
	JTextField codiceFModif1 = new JTextField();
	JTextField codiceFModif2 = new JTextField();
	JTextField nomeFModif = new JTextField();
	JTextField anniFModif = new JTextField();
	
	JButton okAdd = new JButton();
	
	JButton okModif = new JButton();
	JButton okCancel = new JButton();
	
	
	Corsi(){
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(corsiP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(edit);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		corsiP.setLayout(new BorderLayout());
		corsiP.setBackground(null);
		corsiP.add(title, BorderLayout.NORTH);
		corsiP.add(corsi, BorderLayout.CENTER);

		
		corsi.setLayout(new BoxLayout(corsi, BoxLayout.PAGE_AXIS));

		
		edit.setLayout(new BoxLayout(edit, BoxLayout.LINE_AXIS));
		edit.setBackground(null);
		edit.setPreferredSize(new Dimension(426, 300));

		title.setLayout(null);
		titolo.setBounds(20,25, 56, 30);
		titolo1.setBounds(74,30, 100, 25);
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
		
		codiceAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		codiceAdd.setForeground(new Color( 51, 51, 51));
		codiceAdd.setBounds(30, 100, 100, 30);
		
		nomeAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		nomeAdd.setForeground(new Color( 51, 51, 51));
		nomeAdd.setBounds(30, 140, 130, 30);
		
		anniAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		anniAdd.setForeground(new Color( 51, 51, 51));
		anniAdd.setBounds(30, 180, 130, 30);
		
		codiceFAdd.setBounds(145, 100, 250, 30);
		codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		codiceFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		nomeFAdd.setBounds(145, 140, 250, 30);
		nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		nomeFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		anniFAdd.setBounds(145, 180, 250, 30);
		anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		anniFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		okAdd.setBounds(345,220,50,30);
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
		
		codiceModif1.setFont(new Font("Candara", Font.PLAIN, 16));
		codiceModif1.setForeground(new Color( 51, 51, 51));
		codiceModif1.setBounds(30, 70, 130, 30);
		
		codiceModif2.setFont(new Font("Candara", Font.PLAIN, 16));
		codiceModif2.setForeground(new Color( 51, 51, 51));
		codiceModif2.setBounds(30, 110, 50, 30);
		
		nomeModif.setFont(new Font("Candara", Font.PLAIN, 16));
		nomeModif.setForeground(new Color( 51, 51, 51));
		nomeModif.setBounds(30, 150, 130, 30);
		
		anniModif.setFont(new Font("Candara", Font.PLAIN, 16));
		anniModif.setForeground(new Color( 51, 51, 51));
		anniModif.setBounds(30, 190, 130, 30);
		
		codiceFModif1.setBounds(145, 70, 250, 30);
		codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		codiceFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		codiceFModif2.setBounds(145, 110, 250, 30);
		codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		codiceFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		nomeFModif.setBounds(145, 150, 250, 30);
		nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		nomeFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		anniFModif.setBounds(145, 190, 250, 30);
		anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		anniFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		okModif.setBounds(345,230,50,30);
		okModif.setBackground(new Color(70, 73, 96));
		okModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okModif.setLayout(null);
		JLabel se1;

			se1=new JLabel( new ImageIcon("image/editw.png"));
			se1.setBounds(16,5,20,20);
			okModif.add(se1);

		
		okCancel.setBounds(290,230,50,30);
		okCancel.setBackground(new Color(70, 73, 96));
		okCancel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okCancel.setLayout(null);
		JLabel se2;

			se2=new JLabel(new ImageIcon("image/cancelw.png"));
			se2.setBounds(16,5,20,20);
			okCancel.add(se2);

		
		aggPanel.add(agg);
		aggPanel.add(agg1);
		aggPanel.add(codiceAdd);
		aggPanel.add(nomeAdd);
		aggPanel.add(anniAdd);
		aggPanel.add(codiceFAdd);
		aggPanel.add(nomeFAdd);
		aggPanel.add(anniFAdd);
		aggPanel.add(okAdd);
		

		
		modifPanel.add(modif);
		modifPanel.add(modif1);
		modifPanel.add(codiceModif1);
		modifPanel.add(codiceModif2);
		modifPanel.add(nomeModif);
		modifPanel.add(anniModif);
		modifPanel.add(codiceFModif1);
		modifPanel.add(codiceFModif2);
		modifPanel.add(nomeFModif);
		modifPanel.add(anniFModif);
		modifPanel.add(okModif);
		modifPanel.add(okCancel);

		
		edit.setBackground(null);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		edit.add(aggPanel);
		edit.add(Box.createRigidArea(new Dimension(50,0)));
		edit.add(modifPanel);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		
		/**definizione di error**/
		error.setBounds(198, 220, 145, 30);
		error.setLayout(null);
		error.setBackground(null);
		JLabel s=new JLabel(); 

			s=new JLabel( new ImageIcon("image/error.png"));
			s.setBounds(0,5,20,20);
			error.add(s);

		JLabel t= new JLabel("Codice già esistente");
		t.setFont(new Font("Candara", Font.BOLD, 14));
		t.setForeground(new Color(240, 98, 146));
		t.setBounds(22,10,130,20);
		error.add(t);
		aggPanel.add(error);
		error.setVisible(false);
		
		/**definizione di success**/
		success.setBounds(110, 220, 230, 30);
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
		
		/**definizione di errorInt**/
		errorInt.setBounds(160, 220, 300, 30);
		errorInt.setLayout(null);
		errorInt.setBackground(null);
		JLabel s2=new JLabel(); 

			s2=new JLabel( new ImageIcon("image/warning.png"));
			s2.setBounds(0,5,20,20);
			errorInt.add(s2);

		JLabel t2= new JLabel("Digitare un numero intero");
		t2.setFont(new Font("Candara", Font.BOLD, 14));
		t2.setForeground(new Color(216, 150, 54));
		t2.setBounds(22,11,290,20);
		errorInt.add(t2);
		aggPanel.add(errorInt);
		errorInt.setVisible(false);
		
		/**definizione di errorVuoto1**/
		errorVuoto1.setBounds(128, 220, 300, 30);
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
		
		
		
		/**definizione di errorAtt**/
		errorAtt.setBounds(135, 233, 145, 30);
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
		
		/**definizione di error1**/
		error1.setBounds(143, 233, 145, 30);
		error1.setLayout(null);
		error1.setBackground(null);
		JLabel i=new JLabel(); 

			i=new JLabel( new ImageIcon("image/error.png"));
			i.setBounds(0,5,20,20);
			error1.add(i);

		JLabel te= new JLabel("Codice già esistente");
		te.setFont(new Font("Candara", Font.BOLD, 14));
		te.setForeground(new Color(240, 98, 146));
		te.setBounds(22,10,130,20);
		error1.add(te);
		modifPanel.add(error1);
		error1.setVisible(false);
		
		/**definizione di success1**/
		success1.setBounds(55, 233, 230, 30);
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
		errorInt1.setBounds(105, 233, 300, 30);
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
		errorVuoto2.setBounds(71, 233, 300, 30);
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
		
		
		/**Gestione aggiungimento corso**/
		
		okAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addCourse();
			}
			
			
		});
		
		/**Gestione modifica corso**/
		
		okModif.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editCourse();
			}
			
			
		});
		
		/**Gestione cancellazione corso**/
		
		okCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelCourse();
			}
			
			
		});
		
		/**Gestione della lista dei corsi esistenti**/
		
		corsi.setBackground(null);
		
		ResultSet rset;
		int count=0;
		int num=0;

		try{
				//mando una querry per selezionare tutti i corsi di studio presenti nel sistema 
				rset = Database.Query("SELECT * FROM corso", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				corsi.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 100));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				Random rdg = new Random();
				rd=rdg.nextInt(4);
				
					if(count < 3){
						count++; //vuol dire che c'e ancora spazio in panel
						
						JPanel cor1 = new JPanel();
						cor1.setLayout(null);
						if(rd==0) cor1.setBackground(new Color(164, 113, 198));
						if(rd==1) cor1.setBackground(new Color(255, 138, 101));
						if(rd==2) cor1.setBackground(new Color(240, 98, 146));
						if(rd==3) cor1.setBackground(new Color(77, 182, 172));
						cor1.setBounds(abb, 0, 282, 100);
						abb=abb+302;
						
						elements.get(num).add(cor1);
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numAnni = new JLabel(Integer.toString(rset.getInt("num_anni"))+" anni");
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numAnni.setFont(new Font("Candara", Font.BOLD, 14));
							numAnni.setForeground(new Color(245, 245, 245));
							numAnni.setBounds(80,70,100,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numAnni);
						
					}
					else{
						count=1;
						
						elements.add(new JPanel());
						num++;
						abb=20;
						
						JPanel cor1 = new JPanel();
						cor1.setLayout(null);
						if(rd==0) cor1.setBackground(new Color(164, 113, 198));
						if(rd==1) cor1.setBackground(new Color(255, 138, 101));
						if(rd==2) cor1.setBackground(new Color(240, 98, 146));
						if(rd==3) cor1.setBackground(new Color(77, 182, 172));
						cor1.setBounds(abb, 0, 282, 100);
						abb=abb+302;
						
						corsi.add(Box.createRigidArea(new Dimension(0,20)));
						corsi.add(elements.get(num));
						elements.get(num).add(cor1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 100));
						
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numAnni = new JLabel(Integer.toString(rset.getInt("num_anni"))+" anni");
							
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numAnni.setFont(new Font("Candara", Font.BOLD, 14));
							numAnni.setForeground(new Color(245, 245, 245));
							numAnni.setBounds(80,70,100,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numAnni);
							

					}
				
				
			
				
				
			}
				
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		
	
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

	
	void addCourse(){
		
		if( codiceFAdd.getText().isEmpty()){
			
			success.setVisible(false);
			errorInt.setVisible(false);
			error.setVisible(false);
			errorVuoto1.setVisible(true);
			codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
		}
		else{
			
			if(nomeFAdd.getText().isEmpty()){
				
				codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				success.setVisible(false);
				errorInt.setVisible(false);
				error.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{
				if(anniFAdd.getText().isEmpty()){
					nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					success.setVisible(false);
					errorInt.setVisible(false);
					error.setVisible(false);
					errorVuoto1.setVisible(true);
				}
				else{
					
					String cod = codiceFAdd.getText();
					String anni = anniFAdd.getText();
					int x=-1;
					
					ResultSet rs;
					try {
						/* Eseguo una query specificando il codice */
						rs = Database.Query("SELECT c.* FROM corso c WHERE c.codice= '"+cod+"'", Database.getConn(), true);
						
						if(!rs.next()){//se nessun risultato
							
							try { 
								Integer.parseInt(anni); 
								Database.Query("INSERT INTO  corso VALUES ('"+cod+"', '"+nomeFAdd.getText()+"', "+anniFAdd.getText()+")", Database.getConn(), true);
								x = 1;
							}
								catch (Exception e) {
								anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
								codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								nomeFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
								error.setVisible(false);
								success.setVisible(false);
								errorVuoto1.setVisible(false);
								errorInt.setVisible(true);
								}
								
								
						}
						else{ //se risultato
							x = 0;
						}
						
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					
					if(x == 0){
						codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
						anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(false);
						errorInt.setVisible(false);
						errorVuoto1.setVisible(false);
						error.setVisible(true);
					}
					if(x == 1){
						codiceFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						error.setVisible(false);
						errorInt.setVisible(false);
						errorVuoto1.setVisible(false);
						codiceFAdd.setText(null);
						nomeFAdd.setText(null);
						anniFAdd.setText(null);
						success.setVisible(true);
						update();
						
					}
					
				}
			}
		}
		

	}
	
	void editCourse(){
		
		if( codiceFModif1.getText().isEmpty()){
			
			codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorAtt.setVisible(false);
			error1.setVisible(false);
			errorVuoto2.setVisible(true);
		}
		else{
			
			if(codiceFModif2.getText().isEmpty()){
				
				codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				success1.setVisible(false);
				errorInt1.setVisible(false);
				errorAtt.setVisible(false);
				error1.setVisible(false);
				errorVuoto2.setVisible(true);
			}
			else{
				if(nomeFModif.getText().isEmpty()){
					codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					success1.setVisible(false);
					errorInt1.setVisible(false);
					errorAtt.setVisible(false);
					error1.setVisible(false);
					errorVuoto2.setVisible(true);
				}
				else{
					if(anniFModif.getText().isEmpty()){
						nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
						codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success1.setVisible(false);
						errorInt1.setVisible(false);
						errorAtt.setVisible(false);
						error1.setVisible(false);
						errorVuoto2.setVisible(true);
					}
					else{
						
						String codAtt = codiceFModif1.getText();
						String cod = codiceFModif2.getText();
						String anni = anniFModif.getText();
						int x=-1;
						
						ResultSet rs;
						ResultSet rs1;
						try {
							/* Eseguo una query specificando il codice attuale */
							rs = Database.Query("SELECT c.* FROM corso c WHERE c.codice= '"+codAtt+"'", Database.getConn(), true);
							
							if(!rs.next()){//se nessun risultato	
								x = 0;					
							}
							else{ //se risultato
								
								int comp = codAtt.compareTo(cod);
								if(comp != 0){
									try{
										rs1 = Database.Query("SELECT c.* FROM corso c WHERE c.codice= '"+cod+"'", Database.getConn(), true);
										
										if(!rs1.next()){//se nessun risultato
											
											try { 
												Integer.parseInt(anni); 
												Database.Query("UPDATE corso SET codice='"+cod+"', nome='"+nomeFModif.getText()+"', num_anni='"+anni+"' WHERE codice='"+codAtt+"'", Database.getConn(), true);
												x = 1;
											} 
												catch (Exception e) { 
												anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
												codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
												codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
												
												error1.setVisible(false);
												errorAtt.setVisible(false);
												success1.setVisible(false);
												errorVuoto2.setVisible(false);
												errorInt1.setVisible(true);
												}
											}
										else{//se risultato
											x = 2;
										}
									}catch (SQLException ex) {
										// TODO Auto-generated catch block
										ex.printStackTrace();
									}
									
								}
								else{
									try { 
										Integer.parseInt(anni); 
										Database.Query("UPDATE corso SET nome='"+nomeFModif.getText()+"', num_anni='"+anni+"' WHERE codice='"+codAtt+"'", Database.getConn(), true);
										x = 1;
									} 
										catch (Exception e) { 
										anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
										codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
										codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
										
										error1.setVisible(false);
										errorAtt.setVisible(false);
										success1.setVisible(false);
										errorVuoto2.setVisible(false);
										errorInt1.setVisible(true);
										}
								}
								
							}
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
						if(x == 0){
							codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
							codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							success1.setVisible(false);
							errorInt1.setVisible(false);
							error1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorAtt.setVisible(true);
						}
						if(x == 1){
							codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							error1.setVisible(false);
							errorAtt.setVisible(false);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							codiceFModif1.setText(null);
							codiceFModif2.setText(null);
							nomeFModif.setText(null);
							anniFModif.setText(null);
							success1.setVisible(true);
							update();
							

						}
						if(x == 2){
							codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
							codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							success1.setVisible(false);
							errorInt1.setVisible(false);
							errorAtt.setVisible(false);
							errorVuoto2.setVisible(false);
							error1.setVisible(true);
						}
					}

					}
				}
		

 }
}

	void update(){
		
		corsi.removeAll();
		
		ResultSet rset;
		int count=0;
		int num=0;

		try{
				//mando una querry per selezionare tutti i corsi di studio presenti nel sistema 
				rset = Database.Query("SELECT * FROM corso", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				corsi.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 100));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				Random rdg = new Random();
				rd=rdg.nextInt(4);
				
					if(count < 3){
						count++; //vuol dire che c'e ancora spazio in panel
						
						JPanel cor1 = new JPanel();
						cor1.setLayout(null);
						if(rd==0) cor1.setBackground(new Color(164, 113, 198));
						if(rd==1) cor1.setBackground(new Color(255, 138, 101));
						if(rd==2) cor1.setBackground(new Color(240, 98, 146));
						if(rd==3) cor1.setBackground(new Color(77, 182, 172));
						cor1.setBounds(abb, 0, 282, 100);
						abb=abb+302;
						
						elements.get(num).add(cor1);
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numAnni = new JLabel(Integer.toString(rset.getInt("num_anni"))+" anni");
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numAnni.setFont(new Font("Candara", Font.BOLD, 14));
							numAnni.setForeground(new Color(245, 245, 245));
							numAnni.setBounds(80,70,100,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numAnni);
						
					}
					else{
						count=1;
						
						elements.add(new JPanel());
						num++;
						abb=20;
						
						JPanel cor1 = new JPanel();
						cor1.setLayout(null);
						if(rd==0) cor1.setBackground(new Color(164, 113, 198));
						if(rd==1) cor1.setBackground(new Color(255, 138, 101));
						if(rd==2) cor1.setBackground(new Color(240, 98, 146));
						if(rd==3) cor1.setBackground(new Color(77, 182, 172));
						cor1.setBounds(abb, 0, 282, 100);
						abb=abb+302;
						
						corsi.add(Box.createRigidArea(new Dimension(0,20)));
						corsi.add(elements.get(num));
						elements.get(num).add(cor1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 100));
						
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numAnni = new JLabel(Integer.toString(rset.getInt("num_anni"))+" anni");
							
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numAnni.setFont(new Font("Candara", Font.BOLD, 14));
							numAnni.setForeground(new Color(245, 245, 245));
							numAnni.setBounds(80,70,100,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numAnni);
							

					}
				
				
			
				
				
			}
				
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		
		corsi.updateUI();
	}
	
	void cancelCourse(){
		
		if( codiceFModif1.getText().isEmpty()){
			
			codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			nomeFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorAtt.setVisible(false);
			error1.setVisible(false);
			errorVuoto2.setVisible(true);
		}
		else{
			String cod = codiceFModif1.getText();
			int x=-1;
			
			ResultSet rs;
			@SuppressWarnings("unused")
			ResultSet rs1;
			try {
				/* Eseguo una query specificando il codice del corso da cancellare*/
				rs = Database.Query("SELECT c.* FROM corso c WHERE c.codice= '"+cod+"'", Database.getConn(), true);
				
				if(!rs.next()){//se nessun risultato	
					x = 0;					
				}
				else{ //se risultato
					Database.Query("delete from corso where corso.codice='"+codiceFModif1.getText()+"'", Database.getConn(), true);
					
					codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					anniFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					error1.setVisible(false);
					errorAtt.setVisible(false);
					errorInt1.setVisible(false);
					errorVuoto2.setVisible(false);
					codiceFModif1.setText(null);
					codiceFModif2.setText(null);
					nomeFModif.setText(null);
					anniFModif.setText(null);
					success1.setVisible(true);
					update();
					
				}
				
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
			if(x==0){
				codiceFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(240, 98, 146)));
				codiceFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				anniFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				success1.setVisible(false);
				errorInt1.setVisible(false);
				error1.setVisible(false);
				errorVuoto2.setVisible(false);
				errorAtt.setVisible(true);
			}
		
	}
}
	
}
