
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce L'AdminPanel.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del logout da parte dell'amministratore.
 */


public class LibrettoUser extends JScrollPane{
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel librettoP = new JPanel();
	JPanel libretto = new JPanel();
	
	JLabel titolo = new JLabel("Libretto");
	JLabel titolo1 = new JLabel("Libretto dello studente");
	
	int anno;
	String codiceCorente;
	JButton refresh= new JButton();
	
	LibrettoUser(){
		
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
	
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(librettoP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setPreferredSize(new Dimension(300, 80));
		
		librettoP.setLayout(new BorderLayout());
		librettoP.setBackground(null);
		librettoP.add(titlep, BorderLayout.NORTH);
		librettoP.add(libretto, BorderLayout.CENTER);

		
		libretto.setLayout(new BoxLayout(libretto, BoxLayout.PAGE_AXIS));

		
		titolo.setBounds(20,25, 100, 30);
		titolo1.setBounds(100,30, 400, 25);
		titolo.setFont(new Font("Candara", Font.PLAIN, 23));
		titolo.setForeground(new Color( 51, 51, 51));
		titolo1.setFont(new Font("Candara", Font.PLAIN, 15));
		titolo1.setForeground(new Color(153,153,153));
		
		titlep.add(titolo);
		titlep.add(titolo1);

		
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
	
	/**Gestione del libretto**/
		
		libretto.setBackground(null);

		UIManager.put("Button.select", new Color(0, 0, 0, 64));
		
		ResultSet rset;
		int num=0;
		int flag=0;
		String materia="";
		int crediti=0;
		int numC=0;
		Double tot=0.0;
		
		try{
			
			//mando una querry per selezionare tutti i voti di studio presenti nel sistema rispettando il criterio
			rset = Database.Query("select * from voto v "
					+ "where v.studente = "+Integer.valueOf(LoginPanel.logged.getMatricolaUtente())+" ", Database.getConn(), true);
			
			while(rset.next()){
				flag=1;
				
				if(num==0){
						JPanel rigat= new JPanel();
						rigat.setPreferredSize(new Dimension(300, 60));
						rigat.setLayout(new BoxLayout(rigat, BoxLayout.LINE_AXIS));
						libretto.add(Box.createRigidArea(new Dimension(0,10)));
						libretto.add(rigat);
						
						JPanel col0=new JPanel();
						JPanel col1=new JPanel();
						JPanel col2=new JPanel();

						
						rigat.add(Box.createRigidArea(new Dimension(20,0)));
						rigat.add(col0);
						rigat.add(col1);
						rigat.add(col2);
						rigat.add(Box.createRigidArea(new Dimension(20,0)));
						
						col0.setBackground(new Color(221, 221, 221));
						//col0.setPreferredSize(new Dimension(20, 50));
						col0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col0.setLayout(null);
						JLabel l0=new JLabel("Materia");
						l0.setBounds(10, 15, 80, 30);
						l0.setFont(new Font("Candara", Font.BOLD, 14));
						l0.setForeground(new Color(0, 0, 0));
						col0.add(l0);
						
						col1.setBackground(new Color(221, 221, 221));
						//col1.setPreferredSize(new Dimension(100, 50));
						col1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col1.setLayout(null);
						JLabel l1=new JLabel("Numero di crediti");
						l1.setBounds(0, 15, 150, 30);
						l1.setFont(new Font("Candara", Font.BOLD, 14));
						l1.setForeground(new Color(0, 0, 0));
						col1.add(l1);
						
						col2.setBackground(new Color(221, 221, 221));
						//col2.setPreferredSize(new Dimension(100, 50));
						col2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col2.setLayout(null);
						JLabel l2=new JLabel("Voto");
						l2.setBounds(0, 15, 90, 30);
						l2.setFont(new Font("Candara", Font.BOLD, 14));
						l2.setForeground(new Color(0, 0, 0));
						col2.add(l2);
						
								
						num=1;
				}
				
				JPanel riga= new JPanel();
				riga.setPreferredSize(new Dimension(300, 60));
				riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
				libretto.add(Box.createRigidArea(new Dimension(0,3)));
				libretto.add(riga);
				
				JPanel colr0=new JPanel();
				JPanel colr1=new JPanel();
				JPanel colr2=new JPanel();
				
				riga.add(Box.createRigidArea(new Dimension(20,0)));
				riga.add(colr0);
				riga.add(colr1);
				riga.add(colr2);
				riga.add(Box.createRigidArea(new Dimension(20,0)));
				
				colr0.setBackground(new Color(255, 255, 255));
				//colr0.setPreferredSize(new Dimension(20, 50));
				colr0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr0.setLayout(null);
				
				ResultSet r2;
				try{
					
					r2 = Database.Query("select m.nome from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"' ", Database.getConn(), true);
					if(r2.next()){
						materia = r2.getString("nome");
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				JLabel lab0=new JLabel(materia);
				lab0.setBounds(10, 15, 200, 30);
				lab0.setFont(new Font("Candara", Font.BOLD, 14));
				lab0.setForeground(new Color(0, 0, 0));
				colr0.add(lab0);
				
				colr1.setBackground(new Color(255, 255, 255));
				//colr1.setPreferredSize(new Dimension(100, 50));
				colr1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr1.setLayout(null);
				
				try{
					
					r = Database.Query("select m.crediti from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"'	", Database.getConn(), true);
					if(r.next()){
						crediti = r.getInt("crediti");
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				numC=numC+crediti;
				
				JLabel lab1=new JLabel(Integer.toString(crediti));
				lab1.setBounds(0, 15, 100, 30);
				lab1.setFont(new Font("Candara", Font.PLAIN, 20));
				lab1.setForeground(new Color(0, 0, 0));
				colr1.add(lab1);
				
				colr2.setBackground(new Color(255, 255, 255));
				//colr2.setPreferredSize(new Dimension(100, 50));
				colr2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr2.setLayout(null);
				JLabel lab2=new JLabel(rset.getString("voto"));
				lab2.setBounds(0, 15, 100, 30);
				lab2.setFont(new Font("Candara", Font.PLAIN, 20));
				lab2.setForeground(new Color(0, 0, 0));
				colr2.add(lab2);
				
				tot= tot + (Double.parseDouble(rset.getString("voto"))*crediti);
								
			}
			

		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		if(flag==0){
			JPanel riga= new JPanel();
			riga.setPreferredSize(new Dimension(300, 60));
			riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
			libretto.add(Box.createRigidArea(new Dimension(0,10)));
			libretto.add(riga);
			JLabel none=new JLabel("Libretto ancora vuoto!");
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
		
		if(flag!=0){
				JPanel rigat= new JPanel();
				rigat.setPreferredSize(new Dimension(300, 60));
				rigat.setLayout(new BoxLayout(rigat, BoxLayout.LINE_AXIS));
				libretto.add(Box.createRigidArea(new Dimension(0,3)));
				libretto.add(rigat);
				
				JPanel col0=new JPanel();
				JPanel col1=new JPanel();
				JPanel col2=new JPanel();
		
				
				rigat.add(Box.createRigidArea(new Dimension(20,0)));
				rigat.add(col0);
				rigat.add(col1);
				rigat.add(col2);
				rigat.add(Box.createRigidArea(new Dimension(20,0)));
				
				col0.setBackground(new Color(221, 221, 221));
				//col0.setPreferredSize(new Dimension(20, 50));
				col0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				col0.setLayout(null);
				JLabel l0=new JLabel("Crediti totali e media");
				l0.setBounds(10, 15, 250, 30);
				l0.setFont(new Font("Candara", Font.BOLD, 14));
				l0.setForeground(new Color(0, 0, 0));
				col0.add(l0);
				
				col1.setBackground(new Color(221, 221, 221));
				//col1.setPreferredSize(new Dimension(100, 50));
				col1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				col1.setLayout(null);
				JLabel l1=new JLabel(Integer.toString(numC));
				l1.setBounds(0, 15, 150, 30);
				l1.setFont(new Font("Candara", Font.BOLD, 20));
				l1.setForeground(new Color(0, 0, 0));
				col1.add(l1);
				
				col2.setBackground(new Color(221, 221, 221));
				//col2.setPreferredSize(new Dimension(100, 50));
				col2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				col2.setLayout(null);
				JLabel l2=new JLabel(Double.toString(tot/numC));
				l2.setBounds(0, 15, 90, 30);
				l2.setFont(new Font("Candara", Font.BOLD, 20));
				l2.setForeground(new Color(0, 0, 0));
				col2.add(l2);
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
	
		libretto.removeAll();
		ResultSet rset;
		int num=0;
		int flag=0;
		String materia="";
		int crediti=0;
		int numC=0;
		Double tot=0.0;
		
		try{
			
			//mando una querry per selezionare tutti i voti di studio presenti nel sistema rispettando il criterio
			rset = Database.Query("select * from voto v "
					+ "where v.studente = "+Integer.valueOf(LoginPanel.logged.getMatricolaUtente())+" ", Database.getConn(), true);
			
			while(rset.next()){
				flag=1;
				
				if(num==0){
						JPanel rigat= new JPanel();
						rigat.setPreferredSize(new Dimension(300, 60));
						rigat.setLayout(new BoxLayout(rigat, BoxLayout.LINE_AXIS));
						libretto.add(Box.createRigidArea(new Dimension(0,10)));
						libretto.add(rigat);
						
						JPanel col0=new JPanel();
						JPanel col1=new JPanel();
						JPanel col2=new JPanel();

						
						rigat.add(Box.createRigidArea(new Dimension(20,0)));
						rigat.add(col0);
						rigat.add(col1);
						rigat.add(col2);
						rigat.add(Box.createRigidArea(new Dimension(20,0)));
						
						col0.setBackground(new Color(221, 221, 221));
						//col0.setPreferredSize(new Dimension(20, 50));
						col0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col0.setLayout(null);
						JLabel l0=new JLabel("Materia");
						l0.setBounds(10, 15, 80, 30);
						l0.setFont(new Font("Candara", Font.BOLD, 14));
						l0.setForeground(new Color(0, 0, 0));
						col0.add(l0);
						
						col1.setBackground(new Color(221, 221, 221));
						//col1.setPreferredSize(new Dimension(100, 50));
						col1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col1.setLayout(null);
						JLabel l1=new JLabel("Numero di crediti");
						l1.setBounds(0, 15, 150, 30);
						l1.setFont(new Font("Candara", Font.BOLD, 14));
						l1.setForeground(new Color(0, 0, 0));
						col1.add(l1);
						
						col2.setBackground(new Color(221, 221, 221));
						//col2.setPreferredSize(new Dimension(100, 50));
						col2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
						col2.setLayout(null);
						JLabel l2=new JLabel("Voto");
						l2.setBounds(0, 15, 90, 30);
						l2.setFont(new Font("Candara", Font.BOLD, 14));
						l2.setForeground(new Color(0, 0, 0));
						col2.add(l2);
						
								
						num=1;
				}
				
				JPanel riga= new JPanel();
				riga.setPreferredSize(new Dimension(300, 60));
				riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
				libretto.add(Box.createRigidArea(new Dimension(0,3)));
				libretto.add(riga);
				
				JPanel colr0=new JPanel();
				JPanel colr1=new JPanel();
				JPanel colr2=new JPanel();
				
				riga.add(Box.createRigidArea(new Dimension(20,0)));
				riga.add(colr0);
				riga.add(colr1);
				riga.add(colr2);
				riga.add(Box.createRigidArea(new Dimension(20,0)));
				
				colr0.setBackground(new Color(255, 255, 255));
				//colr0.setPreferredSize(new Dimension(20, 50));
				colr0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr0.setLayout(null);
				
				ResultSet r2, r;
				try{
					
					r2 = Database.Query("select m.nome from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"' ", Database.getConn(), true);
					if(r2.next()){
						materia = r2.getString("nome");
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				JLabel lab0=new JLabel(materia);
				lab0.setBounds(10, 15, 200, 30);
				lab0.setFont(new Font("Candara", Font.BOLD, 14));
				lab0.setForeground(new Color(0, 0, 0));
				colr0.add(lab0);
				
				colr1.setBackground(new Color(255, 255, 255));
				//colr1.setPreferredSize(new Dimension(100, 50));
				colr1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr1.setLayout(null);
				
				try{
					
					r = Database.Query("select m.crediti from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"'	", Database.getConn(), true);
					if(r.next()){
						crediti = r.getInt("crediti");
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				numC=numC+crediti;
				
				JLabel lab1=new JLabel(Integer.toString(crediti));
				lab1.setBounds(0, 15, 100, 30);
				lab1.setFont(new Font("Candara", Font.PLAIN, 20));
				lab1.setForeground(new Color(0, 0, 0));
				colr1.add(lab1);
				
				colr2.setBackground(new Color(255, 255, 255));
				//colr2.setPreferredSize(new Dimension(100, 50));
				colr2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
				colr2.setLayout(null);
				JLabel lab2=new JLabel(rset.getString("voto"));
				lab2.setBounds(0, 15, 100, 30);
				lab2.setFont(new Font("Candara", Font.PLAIN, 20));
				lab2.setForeground(new Color(0, 0, 0));
				colr2.add(lab2);
				
				tot= tot + (Double.parseDouble(rset.getString("voto"))*crediti);
								
			}
			

		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		if(flag==0){
			JPanel riga= new JPanel();
			riga.setPreferredSize(new Dimension(300, 300));
			riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
			libretto.add(Box.createRigidArea(new Dimension(0,10)));
			librettoP.add(riga);
			JLabel none=new JLabel("Libretto ancora vuoto!");
			none.setBounds(20, 10, 500, 40);
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
		
		
		if(flag!=0){
			JPanel rigat= new JPanel();
			rigat.setPreferredSize(new Dimension(300, 60));
			rigat.setLayout(new BoxLayout(rigat, BoxLayout.LINE_AXIS));
			libretto.add(Box.createRigidArea(new Dimension(0,3)));
			libretto.add(rigat);
			
			JPanel col0=new JPanel();
			JPanel col1=new JPanel();
			JPanel col2=new JPanel();
	
			
			rigat.add(Box.createRigidArea(new Dimension(20,0)));
			rigat.add(col0);
			rigat.add(col1);
			rigat.add(col2);
			rigat.add(Box.createRigidArea(new Dimension(20,0)));
			
			col0.setBackground(new Color(221, 221, 221));
			//col0.setPreferredSize(new Dimension(20, 50));
			col0.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
			col0.setLayout(null);
			JLabel l0=new JLabel("Crediti totali e media");
			l0.setBounds(10, 15, 250, 30);
			l0.setFont(new Font("Candara", Font.BOLD, 14));
			l0.setForeground(new Color(0, 0, 0));
			col0.add(l0);
			
			col1.setBackground(new Color(221, 221, 221));
			//col1.setPreferredSize(new Dimension(100, 50));
			col1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
			col1.setLayout(null);
			JLabel l1=new JLabel(Integer.toString(numC));
			l1.setBounds(0, 15, 150, 30);
			l1.setFont(new Font("Candara", Font.BOLD, 20));
			l1.setForeground(new Color(0, 0, 0));
			col1.add(l1);
			
			col2.setBackground(new Color(221, 221, 221));
			//col2.setPreferredSize(new Dimension(100, 50));
			col2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 77, 77)));
			col2.setLayout(null);
			JLabel l2=new JLabel(Double.toString(tot/numC));
			l2.setBounds(0, 15, 90, 30);
			l2.setFont(new Font("Candara", Font.BOLD, 20));
			l2.setForeground(new Color(0, 0, 0));
			col2.add(l2);
	}

		libretto.updateUI();
	}


}
