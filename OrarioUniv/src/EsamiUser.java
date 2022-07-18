
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

/** Classe che gestisce il panello del calendario d'esame.
 * permette visualizzare il calendario d'esame del corso e anno prescelti
  **/


public class EsamiUser extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel esamiP = new JPanel();
	JPanel esami = new JPanel();
	
	JLabel titolo;

	
		
	int anno;
	String codiceCorente;
	
	JButton refresh=new JButton();
	
	EsamiUser(){
		
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
	
		
		titolo = new JLabel("Calendario degli Esami: "+codiceCorente+" Anno "+anno);
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(esamiP);
		content.add(Box.createRigidArea(new Dimension(0,270)));
		
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setPreferredSize(new Dimension(300, 80));
		
		
		esamiP.setLayout(new BorderLayout());
		esamiP.setBackground(null);
		esamiP.add(titlep, BorderLayout.NORTH);
		esamiP.add(esami, BorderLayout.CENTER);

		
		esami.setLayout(new BoxLayout(esami, BoxLayout.PAGE_AXIS));

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
	
		
		/**Gestione della lista delgli esami esistenti**/
		
		esami.setBackground(null);
		
		ResultSet rset;
		int count=0;
		int num=0;
		int flag=0;
		
		try{
				//mando una querry per selezionare tutti gli esami con corso e anno specificati
				rset = Database.Query("select e.*, m.nome from esame e, materia m where m.corso='"+codiceCorente+"' and m.anno_corso="+anno+" and m.codice=e.materia order by e.data", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				esami.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 120));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				Random rdg = new Random();
				rd=rdg.nextInt(4);
				flag=1;
				
					if(count < 3){
						count++; //vuol dire che c'e ancora spazio in panel
						
						JPanel esa1 = new JPanel();
						esa1.setLayout(null);
						if(rd==0) esa1.setBackground(new Color(164, 113, 198));
						if(rd==1) esa1.setBackground(new Color(255, 138, 101));
						if(rd==2) esa1.setBackground(new Color(240, 98, 146));
						if(rd==3) esa1.setBackground(new Color(77, 182, 172));
						esa1.setBounds(abb, 0, 282, 120);
						abb=abb+302;
						
						elements.get(num).add(esa1);
						
						JLabel esai = new JLabel();

							if(rd==0) esai=new JLabel( new ImageIcon("image/esame.png"));
							if(rd==1) esai=new JLabel( new ImageIcon("image/esameo.png"));
							if(rd==2) esai=new JLabel( new ImageIcon("image/esamer.png"));
							if(rd==3) esai=new JLabel( new ImageIcon("image/esamev.png"));
							
							esai.setBounds(-20 ,40, 110, 80);
							esa1.add(esai);
							
							JLabel codicemateria = new JLabel(rset.getString("materia"));
							JLabel nomemateria = new JLabel(rset.getString("nome"));
							JLabel data = new JLabel(rset.getString("data"));
							JLabel ora = new JLabel(rset.getString("ora_inizio")+" - "+rset.getString("ora_fine"));
							JLabel aula = new JLabel(rset.getString("aula"));
							
							codicemateria.setFont(new Font("Candara", Font.PLAIN, 25));
							codicemateria.setForeground(new Color(254, 250, 251));
							codicemateria.setBounds(80,10,200,30);
							
							nomemateria.setFont(new Font("Candara", Font.BOLD, 16));
							nomemateria.setForeground(new Color(245, 245, 245));
							nomemateria.setBounds(80,45,250,20);
							
							data.setFont(new Font("Candara", Font.BOLD, 14));
							data.setForeground(new Color(245, 245, 245));
							data.setBounds(80,70,200,20);
							
							ora.setFont(new Font("Candara", Font.BOLD, 14));
							ora.setForeground(new Color(245, 245, 245));
							ora.setBounds(80,95,200,20);
							
							aula.setFont(new Font("Candara", Font.BOLD, 14));
							aula.setForeground(new Color(245, 245, 245));
							aula.setBounds(200,95,200,20);
							
							esa1.add(codicemateria);
							esa1.add(nomemateria);
							esa1.add(data);
							esa1.add(ora);
							esa1.add(aula);
						
					}
					else{
						count=1;
						
						elements.add(new JPanel());
						num++;
						abb=20;
						
						JPanel esa1 = new JPanel();
						esa1.setLayout(null);
						if(rd==0) esa1.setBackground(new Color(164, 113, 198));
						if(rd==1) esa1.setBackground(new Color(255, 138, 101));
						if(rd==2) esa1.setBackground(new Color(240, 98, 146));
						if(rd==3) esa1.setBackground(new Color(77, 182, 172));
						esa1.setBounds(abb, 0, 282, 120);
						abb=abb+302;
						
						esami.add(Box.createRigidArea(new Dimension(0,20)));
						esami.add(elements.get(num));
						elements.get(num).add(esa1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 120));
						
						
						JLabel esai = new JLabel();

							if(rd==0) esai=new JLabel( new ImageIcon("image/esame.png"));
							if(rd==1) esai=new JLabel( new ImageIcon("image/esameo.png"));
							if(rd==2) esai=new JLabel( new ImageIcon("image/esamer.png"));
							if(rd==3) esai=new JLabel( new ImageIcon("image/esamev.png"));
							
							esai.setBounds(-20 ,40, 110, 80);
							esa1.add(esai);
							
							JLabel codicemateria = new JLabel(rset.getString("materia"));
							JLabel nomemateria = new JLabel(rset.getString("nome"));
							JLabel data = new JLabel(rset.getString("data"));
							JLabel ora = new JLabel(rset.getString("ora_inizio")+" - "+rset.getString("ora_fine"));
							JLabel aula = new JLabel(rset.getString("aula"));
							
							codicemateria.setFont(new Font("Candara", Font.PLAIN, 25));
							codicemateria.setForeground(new Color(254, 250, 251));
							codicemateria.setBounds(80,10,200,30);
							
							nomemateria.setFont(new Font("Candara", Font.BOLD, 16));
							nomemateria.setForeground(new Color(245, 245, 245));
							nomemateria.setBounds(80,45,250,20);
							
							data.setFont(new Font("Candara", Font.BOLD, 14));
							data.setForeground(new Color(245, 245, 245));
							data.setBounds(80,70,200,20);
							
							ora.setFont(new Font("Candara", Font.BOLD, 14));
							ora.setForeground(new Color(245, 245, 245));
							ora.setBounds(80,95,200,20);
							
							aula.setFont(new Font("Candara", Font.BOLD, 14));
							aula.setForeground(new Color(245, 245, 245));
							aula.setBounds(200,95,200,20);
							
							esa1.add(codicemateria);
							esa1.add(nomemateria);
							esa1.add(data);
							esa1.add(ora);
							esa1.add(aula);
						
					
					}
				
				
			
				
				
			}
				
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		
		if(flag==0){
			
			JPanel riga= new JPanel();
			riga.setPreferredSize(new Dimension(300, 300));
			riga.setLayout(new BoxLayout(riga, BoxLayout.LINE_AXIS));
			esamiP.add(Box.createRigidArea(new Dimension(0,10)));
			esamiP.add(riga);
			JLabel none=new JLabel("Ancora nesun esame presente per te!");
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
		esami.removeAll();
		
		ResultSet rset;
		int count=0;
		int num=0;

		try{
				//mando una querry per selezionare tutti gli esami con corso e anno specificati
				rset = Database.Query("select e.*, m.nome from esame e, materia m where m.corso='"+codiceCorente+"' and m.anno_corso="+anno+" and m.codice=e.materia order by e.data", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				esami.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 120));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				Random rdg = new Random();
				rd=rdg.nextInt(4);
				
					if(count < 3){
						count++; //vuol dire che c'e ancora spazio in panel
						
						JPanel esa1 = new JPanel();
						esa1.setLayout(null);
						if(rd==0) esa1.setBackground(new Color(164, 113, 198));
						if(rd==1) esa1.setBackground(new Color(255, 138, 101));
						if(rd==2) esa1.setBackground(new Color(240, 98, 146));
						if(rd==3) esa1.setBackground(new Color(77, 182, 172));
						esa1.setBounds(abb, 0, 282, 120);
						abb=abb+302;
						
						elements.get(num).add(esa1);
						
						JLabel esai = new JLabel();

							if(rd==0) esai=new JLabel( new ImageIcon("image/esame.png"));
							if(rd==1) esai=new JLabel( new ImageIcon("image/esameo.png"));
							if(rd==2) esai=new JLabel( new ImageIcon("image/esamer.png"));
							if(rd==3) esai=new JLabel( new ImageIcon("image/esamev.png"));
							
							esai.setBounds(-20 ,40, 110, 80);
							esa1.add(esai);
							
							JLabel codicemateria = new JLabel(rset.getString("materia"));
							JLabel nomemateria = new JLabel(rset.getString("nome"));
							JLabel data = new JLabel(rset.getString("data"));
							JLabel ora = new JLabel(rset.getString("ora_inizio")+" - "+rset.getString("ora_fine"));
							JLabel aula = new JLabel(rset.getString("aula"));
							
							codicemateria.setFont(new Font("Candara", Font.PLAIN, 25));
							codicemateria.setForeground(new Color(254, 250, 251));
							codicemateria.setBounds(80,10,200,30);
							
							nomemateria.setFont(new Font("Candara", Font.BOLD, 16));
							nomemateria.setForeground(new Color(245, 245, 245));
							nomemateria.setBounds(80,45,250,20);
							
							data.setFont(new Font("Candara", Font.BOLD, 14));
							data.setForeground(new Color(245, 245, 245));
							data.setBounds(80,70,200,20);
							
							ora.setFont(new Font("Candara", Font.BOLD, 14));
							ora.setForeground(new Color(245, 245, 245));
							ora.setBounds(80,95,200,20);
							
							aula.setFont(new Font("Candara", Font.BOLD, 14));
							aula.setForeground(new Color(245, 245, 245));
							aula.setBounds(200,95,200,20);
							
							esa1.add(codicemateria);
							esa1.add(nomemateria);
							esa1.add(data);
							esa1.add(ora);
							esa1.add(aula);
						
					}
					else{
						count=1;
						
						elements.add(new JPanel());
						num++;
						abb=20;
						
						JPanel esa1 = new JPanel();
						esa1.setLayout(null);
						if(rd==0) esa1.setBackground(new Color(164, 113, 198));
						if(rd==1) esa1.setBackground(new Color(255, 138, 101));
						if(rd==2) esa1.setBackground(new Color(240, 98, 146));
						if(rd==3) esa1.setBackground(new Color(77, 182, 172));
						esa1.setBounds(abb, 0, 282, 120);
						abb=abb+302;
						
						esami.add(Box.createRigidArea(new Dimension(0,20)));
						esami.add(elements.get(num));
						elements.get(num).add(esa1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 120));
						
						
						JLabel esai = new JLabel();

							if(rd==0) esai=new JLabel( new ImageIcon("image/esame.png"));
							if(rd==1) esai=new JLabel( new ImageIcon("image/esameo.png"));
							if(rd==2) esai=new JLabel( new ImageIcon("image/esamer.png"));
							if(rd==3) esai=new JLabel( new ImageIcon("image/esamev.png"));
							
							esai.setBounds(-20 ,40, 110, 80);
							esa1.add(esai);
							
							JLabel codicemateria = new JLabel(rset.getString("materia"));
							JLabel nomemateria = new JLabel(rset.getString("nome"));
							JLabel data = new JLabel(rset.getString("data"));
							JLabel ora = new JLabel(rset.getString("ora_inizio")+" - "+rset.getString("ora_fine"));
							JLabel aula = new JLabel(rset.getString("aula"));
							
							codicemateria.setFont(new Font("Candara", Font.PLAIN, 25));
							codicemateria.setForeground(new Color(254, 250, 251));
							codicemateria.setBounds(80,10,200,30);
							
							nomemateria.setFont(new Font("Candara", Font.BOLD, 16));
							nomemateria.setForeground(new Color(245, 245, 245));
							nomemateria.setBounds(80,45,250,20);
							
							data.setFont(new Font("Candara", Font.BOLD, 14));
							data.setForeground(new Color(245, 245, 245));
							data.setBounds(80,70,200,20);
							
							ora.setFont(new Font("Candara", Font.BOLD, 14));
							ora.setForeground(new Color(245, 245, 245));
							ora.setBounds(80,95,200,20);
							
							aula.setFont(new Font("Candara", Font.BOLD, 14));
							aula.setForeground(new Color(245, 245, 245));
							aula.setBounds(200,95,200,20);
							
							esa1.add(codicemateria);
							esa1.add(nomemateria);
							esa1.add(data);
							esa1.add(ora);
							esa1.add(aula);
						
					
					}
				
				
			
				
				
			}
				
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}


		esami.updateUI();
	}

}
