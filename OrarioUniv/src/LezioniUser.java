
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce il panello dell'orario universitario.
 * permette visualizzare l'orario del corso e anno prescelti
  **/


public class LezioniUser extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel lezioniP = new JPanel();
	JPanel lezioni = new JPanel();
	
	JLabel titolo;

	
	
	int anno;
	String codiceCorente;
	
	JButton refresh= new JButton();
	
	LezioniUser(){
		
		ResultSet r;
		anno=0;
		codiceCorente="";
		
		
		try{
			r=Database.Query("select * from studente "
					+ "where matricola = "+LoginPanel.logged.getMatricolaUtente()+"", Database.getConn(), true);
			if(r.next()){
				anno = r.getInt("anno_corso");
				codiceCorente = r.getString("corso");
			}
			
		}catch(SQLException e){
			
		}
		
		titolo = new JLabel("Orario delle Lezioni: "+codiceCorente+" Anno "+anno);
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(lezioniP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setPreferredSize(new Dimension(300, 80));
		
		
		lezioniP.setLayout(new BorderLayout());
		lezioniP.setBackground(null);
		lezioniP.add(titlep, BorderLayout.NORTH);
		lezioniP.add(lezioni, BorderLayout.CENTER);

		
		lezioni.setLayout(new BoxLayout(lezioni, BoxLayout.PAGE_AXIS));



		titolo.setBounds(20,25, 600, 30);
		
		titolo.setFont(new Font("Candara", Font.PLAIN, 23));
		titolo.setForeground(new Color( 51, 51, 51));

		
		titlep.add(titolo);


		
		refresh.setBounds(857,25,50,35);
		refresh.setBackground(new Color(255, 255, 255));
		refresh.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		refresh.setLayout(null);
		JLabel ser;

			ser=new JLabel( new ImageIcon("image/refresh.png"));
			ser.setBounds(13,5,25,25);
			refresh.add(ser);
		titlep.add(refresh);
		
		refresh.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
			
			
		});



		
		this.setViewportView(content);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setBounds(0,0,945,572);
        this.setBorder(BorderFactory.createEmptyBorder());
	
		
		/**Gestione del'orario delle lezioni**/
		
		lezioni.setBackground(null);
		
		ResultSet rset;


		
		int count=-1;
		int num=0;
		Random rdg = new Random();
		int rd;
		
		ArrayList<JPanel> elements = new ArrayList<>();
		
		
	while(count<24){
		
		elements.add(new JPanel());
		lezioni.add(elements.get(num));
		elements.get(num).setLayout(new BoxLayout(elements.get(num), BoxLayout.LINE_AXIS));
		
		
		if(count == -1){
			//sono sulla prima riga
			
			elements.get(num).setPreferredSize(new Dimension(300, 60));
			
			JPanel lez0=new JPanel();
			JPanel lez1=new JPanel();
			JPanel lez2=new JPanel();
			JPanel lez3=new JPanel();
			JPanel lez4=new JPanel();
			JPanel lez5=new JPanel();
			
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			elements.get(num).add(lez0);
			elements.get(num).add(lez1);
			elements.get(num).add(lez2);
			elements.get(num).add(lez3);
			elements.get(num).add(lez4);
			elements.get(num).add(lez5);
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			
			lez0.setBackground(new Color(255, 255, 255));
			lez0.setPreferredSize(new Dimension(100, 100));
			lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
			
			lez1.setBackground(new Color(221, 221, 221));
			lez1.setPreferredSize(new Dimension(100, 100));
			lez1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez1.setLayout(null);
			JLabel l1=new JLabel("lunedì");
			l1.setBounds(53, 15, 50, 30);
			l1.setFont(new Font("Candara", Font.BOLD, 14));
			l1.setForeground(new Color(0, 0, 0));
			lez1.add(l1);
			
			lez2.setBackground(new Color(221, 221, 221));
			lez2.setPreferredSize(new Dimension(100, 100));
			lez2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez2.setLayout(null);
			JLabel l2=new JLabel("martedì");
			l2.setBounds(53, 15, 50, 30);
			l2.setFont(new Font("Candara", Font.BOLD, 14));
			l2.setForeground(new Color(0, 0, 0));
			lez2.add(l2);
			
			
			lez3.setBackground(new Color(221, 221, 221));
			lez3.setPreferredSize(new Dimension(100, 100));
			lez3.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez3.setLayout(null);
			JLabel l3=new JLabel("mercoledì");
			l3.setBounds(43, 15, 60, 30);
			l3.setFont(new Font("Candara", Font.BOLD, 14));
			l3.setForeground(new Color(0, 0, 0));
			lez3.add(l3);
			
			lez4.setBackground(new Color(221, 221, 221));
			lez4.setPreferredSize(new Dimension(100, 100));
			lez4.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez4.setLayout(null);
			JLabel l4=new JLabel("giovedì");
			l4.setBounds(53, 15, 50, 30);
			l4.setFont(new Font("Candara", Font.BOLD, 14));
			l4.setForeground(new Color(0, 0, 0));
			lez4.add(l4);
			
			lez5.setBackground(new Color(221, 221, 221));
			lez5.setPreferredSize(new Dimension(100, 100));
			lez5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(77, 77, 77)));
			lez5.setLayout(null);
			JLabel l5=new JLabel("venerdì");
			l5.setBounds(53, 15, 50, 30);
			l5.setFont(new Font("Candara", Font.BOLD, 14));
			l5.setForeground(new Color(0, 0, 0));
			lez5.add(l5);
		}
		else{
			//altre righe
			elements.get(num).setPreferredSize(new Dimension(300, 100));
			
			JPanel lez0=new JPanel();
			JPanel lez1=new JPanel();
			JPanel lez2=new JPanel();
			JPanel lez3=new JPanel();
			JPanel lez4=new JPanel();
			JPanel lez5=new JPanel();
			
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			elements.get(num).add(lez0);
			elements.get(num).add(lez1);
			elements.get(num).add(lez2);
			elements.get(num).add(lez3);
			elements.get(num).add(lez4);
			elements.get(num).add(lez5);
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			
			String h= new String();
			int x=0;
			
			if(count<10){
				if(count==9){
					lez0.setBackground(new Color(221, 221, 221));
					lez0.setPreferredSize(new Dimension(100, 100));
					lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					lez0.setLayout(null);
					JLabel l0=new JLabel("09:00-10:00");
					h= new String("09:00");
					l0.setBounds(33, 30, 100, 40);
					l0.setFont(new Font("Candara", Font.BOLD, 15));
					l0.setForeground(new Color(0, 0, 0));
					lez0.add(l0);
				}
				else{
					lez0.setBackground(new Color(221, 221, 221));
					lez0.setPreferredSize(new Dimension(100, 100));
					lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					lez0.setLayout(null);
					JLabel l0=new JLabel("0"+count+":00-0"+(count+1)+":00");
					h= new String("0"+count+":00");
					l0.setBounds(33, 30, 100, 40);
					l0.setFont(new Font("Candara", Font.BOLD, 14));
					l0.setForeground(new Color(0, 0, 0));
					lez0.add(l0);	
				}
			}
			else{
				lez0.setBackground(new Color(221, 221, 221));
				lez0.setPreferredSize(new Dimension(100, 100));
				lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				lez0.setLayout(null);
				JLabel l0=new JLabel(count+":00-"+(count+1)+":00");
				h= new String(count+":00");
				l0.setBounds(33, 30, 100, 40);
				l0.setFont(new Font("Candara", Font.BOLD, 14));
				l0.setForeground(new Color(0, 0, 0));
				lez0.add(l0);
			}
			
			lez1.setBackground(new Color(255, 255, 255));
			lez1.setPreferredSize(new Dimension(100, 100));
			lez1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez1.setLayout(null);
			JLabel l11=new JLabel();
			l11.setBounds(10, 10, 100, 20);
			l11.setFont(new Font("Candara", Font.BOLD, 14));
			l11.setForeground(new Color(254, 250, 251));
			JLabel l12=new JLabel();
			l12.setBounds(10, 30, 130, 20);
			l12.setFont(new Font("Candara", Font.BOLD, 12));
			l12.setForeground(new Color(254, 250, 251));
			JLabel l13=new JLabel();
			l13.setBounds(80, 55, 100, 30);
			l13.setFont(new Font("Candara", Font.BOLD, 14));
			l13.setForeground(new Color(254, 250, 251));
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=1 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l11.setText(rset.getString("materia"));
					l12.setText(rset.getString("nome"));
					l13.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez1.setBackground(new Color(164, 113, 198));
				if(rd==1) lez1.setBackground(new Color(255, 138, 101));
				if(rd==2) lez1.setBackground(new Color(240, 98, 146));
				if(rd==3) lez1.setBackground(new Color(77, 182, 172));
				lez1.add(l11);
				lez1.add(l12);
				lez1.add(l13);
				
			}
			else{
				;
			}
			
			
			lez2.setBackground(new Color(255, 255, 255));
			lez2.setPreferredSize(new Dimension(100, 100));
			lez2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez2.setLayout(null);
			JLabel l21=new JLabel();
			l21.setBounds(10, 10, 100, 20);
			l21.setFont(new Font("Candara", Font.BOLD, 14));
			l21.setForeground(new Color(254, 250, 251));
			JLabel l22=new JLabel();
			l22.setBounds(10, 30, 130, 20);
			l22.setFont(new Font("Candara", Font.BOLD, 12));
			l22.setForeground(new Color(254, 250, 251));
			JLabel l23=new JLabel();
			l23.setBounds(80, 55, 100, 30);
			l23.setFont(new Font("Candara", Font.BOLD, 14));
			l23.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=2 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l21.setText(rset.getString("materia"));
					l22.setText(rset.getString("nome"));
					l23.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez2.setBackground(new Color(164, 113, 198));
				if(rd==1) lez2.setBackground(new Color(255, 138, 101));
				if(rd==2) lez2.setBackground(new Color(240, 98, 146));
				if(rd==3) lez2.setBackground(new Color(77, 182, 172));
				lez2.add(l21);
				lez2.add(l22);
				lez2.add(l23);
				
			}
			else{
				;
			}
			
			
			
			
			lez3.setBackground(new Color(255, 255, 255));
			lez3.setPreferredSize(new Dimension(100, 100));
			lez3.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez3.setLayout(null);
			JLabel l31=new JLabel();
			l31.setBounds(10, 10, 100, 20);
			l31.setFont(new Font("Candara", Font.BOLD, 14));
			l31.setForeground(new Color(254, 250, 251));
			JLabel l32=new JLabel();
			l32.setBounds(10, 30, 130, 20);
			l32.setFont(new Font("Candara", Font.BOLD, 12));
			l32.setForeground(new Color(254, 250, 251));
			JLabel l33=new JLabel();
			l33.setBounds(80, 55, 100, 30);
			l33.setFont(new Font("Candara", Font.BOLD, 14));
			l33.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=3 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l31.setText(rset.getString("materia"));
					l32.setText(rset.getString("nome"));
					l33.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez3.setBackground(new Color(164, 113, 198));
				if(rd==1) lez3.setBackground(new Color(255, 138, 101));
				if(rd==2) lez3.setBackground(new Color(240, 98, 146));
				if(rd==3) lez3.setBackground(new Color(77, 182, 172));
				lez3.add(l31);
				lez3.add(l32);
				lez3.add(l33);
				
			}
			else{
				;
			}
			
			
			
			lez4.setBackground(new Color(255, 255, 255));
			lez4.setPreferredSize(new Dimension(100, 100));
			lez4.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez4.setLayout(null);
			JLabel l41=new JLabel();
			l41.setBounds(10, 10, 100, 20);
			l41.setFont(new Font("Candara", Font.BOLD, 14));
			l41.setForeground(new Color(254, 250, 251));
			JLabel l42=new JLabel();
			l42.setBounds(10, 30, 130, 20);
			l42.setFont(new Font("Candara", Font.BOLD, 12));
			l42.setForeground(new Color(254, 250, 251));
			JLabel l43=new JLabel();
			l43.setBounds(80, 55, 100, 30);
			l43.setFont(new Font("Candara", Font.BOLD, 14));
			l43.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=4 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l41.setText(rset.getString("materia"));
					l42.setText(rset.getString("nome"));
					l43.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez4.setBackground(new Color(164, 113, 198));
				if(rd==1) lez4.setBackground(new Color(255, 138, 101));
				if(rd==2) lez4.setBackground(new Color(240, 98, 146));
				if(rd==3) lez4.setBackground(new Color(77, 182, 172));
				lez4.add(l41);
				lez4.add(l42);
				lez4.add(l43);
				
			}
			else{
				;
			}
			
			
			
			
			
			lez5.setBackground(new Color(255, 255, 255));
			lez5.setPreferredSize(new Dimension(100, 100));
			lez5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(77, 77, 77)));
			lez5.setLayout(null);
			JLabel l51=new JLabel();
			l51.setBounds(10, 10, 100, 20);
			l51.setFont(new Font("Candara", Font.BOLD, 14));
			l51.setForeground(new Color(254, 250, 251));
			JLabel l52=new JLabel();
			l52.setBounds(10, 30, 130, 20);
			l52.setFont(new Font("Candara", Font.BOLD, 12));
			l52.setForeground(new Color(254, 250, 251));
			JLabel l53=new JLabel();
			l53.setBounds(80, 55, 100, 30);
			l53.setFont(new Font("Candara", Font.BOLD, 14));
			l53.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=5 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l51.setText(rset.getString("materia"));
					l52.setText(rset.getString("nome"));
					l53.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez5.setBackground(new Color(164, 113, 198));
				if(rd==1) lez5.setBackground(new Color(255, 138, 101));
				if(rd==2) lez5.setBackground(new Color(240, 98, 146));
				if(rd==3) lez5.setBackground(new Color(77, 182, 172));
				lez5.add(l51);
				lez5.add(l52);
				lez5.add(l53);
				
			}
			else{
				;
			}
			
			
			
		}
	
		count++;
		num++;
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
	
	void update(){
		lezioni.removeAll();
		
		ResultSet rset;


		
		int count=-1;
		int num=0;
		Random rdg = new Random();
		int rd;
		
		ArrayList<JPanel> elements = new ArrayList<>();
		
		
	while(count<24){
		
		elements.add(new JPanel());
		lezioni.add(elements.get(num));
		elements.get(num).setLayout(new BoxLayout(elements.get(num), BoxLayout.LINE_AXIS));
		
		
		if(count == -1){
			//sono sulla prima riga
			
			elements.get(num).setPreferredSize(new Dimension(300, 60));
			
			JPanel lez0=new JPanel();
			JPanel lez1=new JPanel();
			JPanel lez2=new JPanel();
			JPanel lez3=new JPanel();
			JPanel lez4=new JPanel();
			JPanel lez5=new JPanel();
			
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			elements.get(num).add(lez0);
			elements.get(num).add(lez1);
			elements.get(num).add(lez2);
			elements.get(num).add(lez3);
			elements.get(num).add(lez4);
			elements.get(num).add(lez5);
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			
			lez0.setBackground(new Color(255, 255, 255));
			lez0.setPreferredSize(new Dimension(100, 100));
			lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
			
			lez1.setBackground(new Color(221, 221, 221));
			lez1.setPreferredSize(new Dimension(100, 100));
			lez1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez1.setLayout(null);
			JLabel l1=new JLabel("lunedì");
			l1.setBounds(53, 15, 50, 30);
			l1.setFont(new Font("Candara", Font.BOLD, 14));
			l1.setForeground(new Color(0, 0, 0));
			lez1.add(l1);
			
			lez2.setBackground(new Color(221, 221, 221));
			lez2.setPreferredSize(new Dimension(100, 100));
			lez2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez2.setLayout(null);
			JLabel l2=new JLabel("martedì");
			l2.setBounds(53, 15, 50, 30);
			l2.setFont(new Font("Candara", Font.BOLD, 14));
			l2.setForeground(new Color(0, 0, 0));
			lez2.add(l2);
			
			
			lez3.setBackground(new Color(221, 221, 221));
			lez3.setPreferredSize(new Dimension(100, 100));
			lez3.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez3.setLayout(null);
			JLabel l3=new JLabel("mercoledì");
			l3.setBounds(43, 15, 60, 30);
			l3.setFont(new Font("Candara", Font.BOLD, 14));
			l3.setForeground(new Color(0, 0, 0));
			lez3.add(l3);
			
			lez4.setBackground(new Color(221, 221, 221));
			lez4.setPreferredSize(new Dimension(100, 100));
			lez4.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez4.setLayout(null);
			JLabel l4=new JLabel("giovedì");
			l4.setBounds(53, 15, 50, 30);
			l4.setFont(new Font("Candara", Font.BOLD, 14));
			l4.setForeground(new Color(0, 0, 0));
			lez4.add(l4);
			
			lez5.setBackground(new Color(221, 221, 221));
			lez5.setPreferredSize(new Dimension(100, 100));
			lez5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(77, 77, 77)));
			lez5.setLayout(null);
			JLabel l5=new JLabel("venerdì");
			l5.setBounds(53, 15, 50, 30);
			l5.setFont(new Font("Candara", Font.BOLD, 14));
			l5.setForeground(new Color(0, 0, 0));
			lez5.add(l5);
		}
		else{
			//altre righe
			elements.get(num).setPreferredSize(new Dimension(300, 100));
			
			JPanel lez0=new JPanel();
			JPanel lez1=new JPanel();
			JPanel lez2=new JPanel();
			JPanel lez3=new JPanel();
			JPanel lez4=new JPanel();
			JPanel lez5=new JPanel();
			
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			elements.get(num).add(lez0);
			elements.get(num).add(lez1);
			elements.get(num).add(lez2);
			elements.get(num).add(lez3);
			elements.get(num).add(lez4);
			elements.get(num).add(lez5);
			elements.get(num).add(Box.createRigidArea(new Dimension(20,0)));
			
			String h= new String();
			int x=0;
			
			if(count<10){
				if(count==9){
					lez0.setBackground(new Color(221, 221, 221));
					lez0.setPreferredSize(new Dimension(100, 100));
					lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					lez0.setLayout(null);
					JLabel l0=new JLabel("09:00-10:00");
					h= new String("09:00");
					l0.setBounds(33, 30, 100, 40);
					l0.setFont(new Font("Candara", Font.BOLD, 15));
					l0.setForeground(new Color(0, 0, 0));
					lez0.add(l0);
				}
				else{
					lez0.setBackground(new Color(221, 221, 221));
					lez0.setPreferredSize(new Dimension(100, 100));
					lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
					lez0.setLayout(null);
					JLabel l0=new JLabel("0"+count+":00-0"+(count+1)+":00");
					h= new String("0"+count+":00");
					l0.setBounds(33, 30, 100, 40);
					l0.setFont(new Font("Candara", Font.BOLD, 14));
					l0.setForeground(new Color(0, 0, 0));
					lez0.add(l0);	
				}
			}
			else{
				lez0.setBackground(new Color(221, 221, 221));
				lez0.setPreferredSize(new Dimension(100, 100));
				lez0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				lez0.setLayout(null);
				JLabel l0=new JLabel(count+":00-"+(count+1)+":00");
				h= new String(count+":00");
				l0.setBounds(33, 30, 100, 40);
				l0.setFont(new Font("Candara", Font.BOLD, 14));
				l0.setForeground(new Color(0, 0, 0));
				lez0.add(l0);
			}
			
			lez1.setBackground(new Color(255, 255, 255));
			lez1.setPreferredSize(new Dimension(100, 100));
			lez1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez1.setLayout(null);
			JLabel l11=new JLabel();
			l11.setBounds(10, 10, 100, 20);
			l11.setFont(new Font("Candara", Font.BOLD, 14));
			l11.setForeground(new Color(254, 250, 251));
			JLabel l12=new JLabel();
			l12.setBounds(10, 30, 130, 20);
			l12.setFont(new Font("Candara", Font.BOLD, 12));
			l12.setForeground(new Color(254, 250, 251));
			JLabel l13=new JLabel();
			l13.setBounds(80, 55, 100, 30);
			l13.setFont(new Font("Candara", Font.BOLD, 14));
			l13.setForeground(new Color(254, 250, 251));
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=1 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l11.setText(rset.getString("materia"));
					l12.setText(rset.getString("nome"));
					l13.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez1.setBackground(new Color(164, 113, 198));
				if(rd==1) lez1.setBackground(new Color(255, 138, 101));
				if(rd==2) lez1.setBackground(new Color(240, 98, 146));
				if(rd==3) lez1.setBackground(new Color(77, 182, 172));
				lez1.add(l11);
				lez1.add(l12);
				lez1.add(l13);
				
			}
			else{
				;
			}
			
			
			lez2.setBackground(new Color(255, 255, 255));
			lez2.setPreferredSize(new Dimension(100, 100));
			lez2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez2.setLayout(null);
			JLabel l21=new JLabel();
			l21.setBounds(10, 10, 100, 20);
			l21.setFont(new Font("Candara", Font.BOLD, 14));
			l21.setForeground(new Color(254, 250, 251));
			JLabel l22=new JLabel();
			l22.setBounds(10, 30, 130, 20);
			l22.setFont(new Font("Candara", Font.BOLD, 12));
			l22.setForeground(new Color(254, 250, 251));
			JLabel l23=new JLabel();
			l23.setBounds(80, 55, 100, 30);
			l23.setFont(new Font("Candara", Font.BOLD, 14));
			l23.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=2 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l21.setText(rset.getString("materia"));
					l22.setText(rset.getString("nome"));
					l23.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez2.setBackground(new Color(164, 113, 198));
				if(rd==1) lez2.setBackground(new Color(255, 138, 101));
				if(rd==2) lez2.setBackground(new Color(240, 98, 146));
				if(rd==3) lez2.setBackground(new Color(77, 182, 172));
				lez2.add(l21);
				lez2.add(l22);
				lez2.add(l23);
				
			}
			else{
				;
			}
			
			
			
			
			lez3.setBackground(new Color(255, 255, 255));
			lez3.setPreferredSize(new Dimension(100, 100));
			lez3.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez3.setLayout(null);
			JLabel l31=new JLabel();
			l31.setBounds(10, 10, 100, 20);
			l31.setFont(new Font("Candara", Font.BOLD, 14));
			l31.setForeground(new Color(254, 250, 251));
			JLabel l32=new JLabel();
			l32.setBounds(10, 30, 130, 20);
			l32.setFont(new Font("Candara", Font.BOLD, 12));
			l32.setForeground(new Color(254, 250, 251));
			JLabel l33=new JLabel();
			l33.setBounds(80, 55, 100, 30);
			l33.setFont(new Font("Candara", Font.BOLD, 14));
			l33.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=3 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l31.setText(rset.getString("materia"));
					l32.setText(rset.getString("nome"));
					l33.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez3.setBackground(new Color(164, 113, 198));
				if(rd==1) lez3.setBackground(new Color(255, 138, 101));
				if(rd==2) lez3.setBackground(new Color(240, 98, 146));
				if(rd==3) lez3.setBackground(new Color(77, 182, 172));
				lez3.add(l31);
				lez3.add(l32);
				lez3.add(l33);
				
			}
			else{
				;
			}
			
			
			
			lez4.setBackground(new Color(255, 255, 255));
			lez4.setPreferredSize(new Dimension(100, 100));
			lez4.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(77, 77, 77)));
			lez4.setLayout(null);
			JLabel l41=new JLabel();
			l41.setBounds(10, 10, 100, 20);
			l41.setFont(new Font("Candara", Font.BOLD, 14));
			l41.setForeground(new Color(254, 250, 251));
			JLabel l42=new JLabel();
			l42.setBounds(10, 30, 130, 20);
			l42.setFont(new Font("Candara", Font.BOLD, 12));
			l42.setForeground(new Color(254, 250, 251));
			JLabel l43=new JLabel();
			l43.setBounds(80, 55, 100, 30);
			l43.setFont(new Font("Candara", Font.BOLD, 14));
			l43.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=4 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l41.setText(rset.getString("materia"));
					l42.setText(rset.getString("nome"));
					l43.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez4.setBackground(new Color(164, 113, 198));
				if(rd==1) lez4.setBackground(new Color(255, 138, 101));
				if(rd==2) lez4.setBackground(new Color(240, 98, 146));
				if(rd==3) lez4.setBackground(new Color(77, 182, 172));
				lez4.add(l41);
				lez4.add(l42);
				lez4.add(l43);
				
			}
			else{
				;
			}
			
			
			
			
			
			lez5.setBackground(new Color(255, 255, 255));
			lez5.setPreferredSize(new Dimension(100, 100));
			lez5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(77, 77, 77)));
			lez5.setLayout(null);
			JLabel l51=new JLabel();
			l51.setBounds(10, 10, 100, 20);
			l51.setFont(new Font("Candara", Font.BOLD, 14));
			l51.setForeground(new Color(254, 250, 251));
			JLabel l52=new JLabel();
			l52.setBounds(10, 30, 130, 20);
			l52.setFont(new Font("Candara", Font.BOLD, 12));
			l52.setForeground(new Color(254, 250, 251));
			JLabel l53=new JLabel();
			l53.setBounds(80, 55, 100, 30);
			l53.setFont(new Font("Candara", Font.BOLD, 14));
			l53.setForeground(new Color(254, 250, 251));
			x=0;
			
			try{
			//mando una querry per selezionare la lezione lez1
			rset = Database.Query("select l.materia, l.aula, m.nome "
					+ "from lezione l, materia m "
					+ "where l.giorno=5 "
					+ "and l.ora_inizio<='"+h+"' "
					+ "and l.ora_fine>'"+h+"' "
					+ "and m.codice=l.materia "
					+ "and l.corso='"+codiceCorente+"' "
					+ "and l.anno_corso="+anno+"", Database.getConn(), true);
			
				if(rset.next()){
					l51.setText(rset.getString("materia"));
					l52.setText(rset.getString("nome"));
					l53.setText(rset.getString("aula"));
					x=1;
				}
				else{
					;
				}
			
			}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			}
			if(x==1){
				rd=rdg.nextInt(4);
				if(rd==0) lez5.setBackground(new Color(164, 113, 198));
				if(rd==1) lez5.setBackground(new Color(255, 138, 101));
				if(rd==2) lez5.setBackground(new Color(240, 98, 146));
				if(rd==3) lez5.setBackground(new Color(77, 182, 172));
				lez5.add(l51);
				lez5.add(l52);
				lez5.add(l53);
				
			}
			else{
				;
			}
			
			
			
		}
	
		count++;
		num++;
	}


		lezioni.updateUI();
	}
	
}
	

