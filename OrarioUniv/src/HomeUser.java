
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce il panello home.
 * permette di visualizzare corsi numero studenti e di materie
  **/


public class HomeUser extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel corsiP = new JPanel();
	JPanel corsi = new JPanel();
	
	JLabel titolo = new JLabel("Home");
	JLabel titolo1 = new JLabel("Home page, corsi con numero di studenti e di materie");
	
	JButton refresh= new JButton();
	
	HomeUser(){
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(corsiP);
		content.add(Box.createRigidArea(new Dimension(0,250)));
		
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setPreferredSize(new Dimension(300, 80));
		
		corsiP.setLayout(new BorderLayout());
		corsiP.setBackground(null);
		corsiP.add(titlep, BorderLayout.NORTH);
		corsiP.add(corsi, BorderLayout.CENTER);

		
		corsi.setLayout(new BoxLayout(corsi, BoxLayout.PAGE_AXIS));



		titolo.setBounds(20,25, 100, 30);
		titolo1.setBounds(82,30, 400, 25);
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
			
		/**Gestione della lista dei corsi esistenti con numero di studenti e di materie**/
		
		corsi.setBackground(null);
		
		ResultSet rset, rs;
		int count=0;
		int num=0;
		int stu=0, mat=0;
		int flag=0;

		try{
				//mando una querry per selezionare tutti i corsi di studio presenti nel sistema 
				rset = Database.Query("SELECT * FROM corso", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				corsi.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 130));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				flag = 1;
				/*mando una query per selezionare il numero di studenti del corso*/
				try{
					rs = Database.Query("select count(*) as num "
							+ "from studente "
							+ "where corso='"+rset.getString("codice")+"' ", Database.getConn(), true);
					if(rs.next()){
						stu = rs.getInt("num");
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				
				/*mando una query per selezionare il numero di materie del corso*/
				try{
					rs = Database.Query("select count(*) as num "
							+ "from materia "
							+ "where corso='"+rset.getString("codice")+"' ", Database.getConn(), true);
					
					if(rs.next()){
					mat = rs.getInt("num");
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				
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
						cor1.setBounds(abb, 0, 282, 130);
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
							JLabel numStudenti = new JLabel("Numero di studenti: "+Integer.toString(stu));
							JLabel numMaterie = new JLabel("Numero di materie: "+Integer.toString(mat));

							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numStudenti.setFont(new Font("Candara", Font.BOLD, 14));
							numStudenti.setForeground(new Color(245, 245, 245));
							numStudenti.setBounds(80,70,250,20);
							
							numMaterie.setFont(new Font("Candara", Font.BOLD, 14));
							numMaterie.setForeground(new Color(245, 245, 245));
							numMaterie.setBounds(80,95,250,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numStudenti);
							cor1.add(numMaterie);
						
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
						cor1.setBounds(abb, 0, 282, 130);
						abb=abb+302;
						
						corsi.add(Box.createRigidArea(new Dimension(0,20)));
						corsi.add(elements.get(num));
						elements.get(num).add(cor1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 130));
						
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numStudenti = new JLabel("Numero di studenti: "+Integer.toString(stu));
							JLabel numMaterie = new JLabel("Numero di materie: "+Integer.toString(mat));
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numStudenti.setFont(new Font("Candara", Font.BOLD, 14));
							numStudenti.setForeground(new Color(245, 245, 245));
							numStudenti.setBounds(80,70,250,20);
							
							numMaterie.setFont(new Font("Candara", Font.BOLD, 14));
							numMaterie.setForeground(new Color(245, 245, 245));
							numMaterie.setBounds(80,95,250,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numStudenti);
							cor1.add(numMaterie);
							

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
			corsiP.add(Box.createRigidArea(new Dimension(0,10)));
			corsiP.add(riga);
			JLabel none=new JLabel("Ancora nesun corsi di studio presente nel sistema!");
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
		corsi.removeAll();
		
		ResultSet rset, rs;
		int count=0;
		int num=0;
		int stu=0, mat=0;

		try{
				//mando una querry per selezionare tutti i corsi di studio presenti nel sistema 
				rset = Database.Query("SELECT * FROM corso", Database.getConn(), true);
				
				
				ArrayList<JPanel> elements = new ArrayList<>();
				elements.add(new JPanel());
				corsi.add(elements.get(num));
				elements.get(num).setLayout(null);
				elements.get(num).setPreferredSize(new Dimension(300, 130));
				
				int abb = 20;
				int rd;
				
			while(rset.next()){
				
				/*mando una query per selezionare il numero di studenti del corso*/
				try{
					rs = Database.Query("select count(*) as num "
							+ "from studente "
							+ "where corso='"+rset.getString("codice")+"' ", Database.getConn(), true);
					if(rs.next()){
						stu = rs.getInt("num");
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				
				/*mando una query per selezionare il numero di materie del corso*/
				try{
					rs = Database.Query("select count(*) as num "
							+ "from materia "
							+ "where corso='"+rset.getString("codice")+"' ", Database.getConn(), true);
					
					if(rs.next()){
					mat = rs.getInt("num");
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				
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
						cor1.setBounds(abb, 0, 282, 130);
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
							JLabel numStudenti = new JLabel("Numero di studenti: "+Integer.toString(stu));
							JLabel numMaterie = new JLabel("Numero di materie: "+Integer.toString(mat));

							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numStudenti.setFont(new Font("Candara", Font.BOLD, 14));
							numStudenti.setForeground(new Color(245, 245, 245));
							numStudenti.setBounds(80,70,250,20);
							
							numMaterie.setFont(new Font("Candara", Font.BOLD, 14));
							numMaterie.setForeground(new Color(245, 245, 245));
							numMaterie.setBounds(80,95,250,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numStudenti);
							cor1.add(numMaterie);
						
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
						cor1.setBounds(abb, 0, 282, 130);
						abb=abb+302;
						
						corsi.add(Box.createRigidArea(new Dimension(0,20)));
						corsi.add(elements.get(num));
						elements.get(num).add(cor1);
						elements.get(num).setLayout(null);
						elements.get(num).setPreferredSize(new Dimension(300, 130));
						
						
						JLabel cori = new JLabel();

							if(rd==0) cori=new JLabel( new ImageIcon("image/corso.png"));
							if(rd==1) cori=new JLabel( new ImageIcon("image/corsoo.png"));
							if(rd==2) cori=new JLabel( new ImageIcon("image/corsor.png"));
							if(rd==3) cori=new JLabel( new ImageIcon("image/corsov.png"));
							
							cori.setBounds(-20 ,35, 90, 80);
							cor1.add(cori);
							
							JLabel codiceCorso = new JLabel(rset.getString("codice"));
							JLabel nomeCorso = new JLabel(rset.getString("nome"));
							JLabel numStudenti = new JLabel("Numero di studenti: "+Integer.toString(stu));
							JLabel numMaterie = new JLabel("Numero di materie: "+Integer.toString(mat));
							
							codiceCorso.setFont(new Font("Candara", Font.PLAIN, 25));
							codiceCorso.setForeground(new Color(254, 250, 251));
							codiceCorso.setBounds(80,10,200,30);
							
							nomeCorso.setFont(new Font("Candara", Font.BOLD, 16));
							nomeCorso.setForeground(new Color(245, 245, 245));
							nomeCorso.setBounds(80,45,250,20);
							
							numStudenti.setFont(new Font("Candara", Font.BOLD, 14));
							numStudenti.setForeground(new Color(245, 245, 245));
							numStudenti.setBounds(80,70,250,20);
							
							numMaterie.setFont(new Font("Candara", Font.BOLD, 14));
							numMaterie.setForeground(new Color(245, 245, 245));
							numMaterie.setBounds(80,95,250,20);
							
							cor1.add(codiceCorso);
							cor1.add(nomeCorso);
							cor1.add(numStudenti);
							cor1.add(numMaterie);
							

					}
				
				
			
				
				
			}	
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		

		corsi.updateUI();
	}
	
}
