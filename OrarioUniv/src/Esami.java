
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



@SuppressWarnings("serial")

/** Classe che gestisce il panello dei diversi calendari d'esame.
 * permette di scegliere il corso di studio e l'anno
  **/


public class Esami extends JPanel {

	JPanel content1 = new JPanel();
	@SuppressWarnings("rawtypes")
	JComboBox combo = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox combo1 = new JComboBox();
	JButton ok, ok1, prec;
	JLabel t, t1, tt;
	String codiceCorso;
	int flag = 0;
	int anno;
	
		
	
	@SuppressWarnings("unchecked")
	Esami(){
		
		this.setLayout(null);
		this.add(content1);
        this.setBounds(0,0,943,572);
        
        content1.setLayout(null);
        content1.setBounds(230, 70, 500, 400);
        content1.setBackground(new Color(255, 255, 255));
        content1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, new Color(0, 0, 0, 40)));
        
        t=new JLabel("Scelta del corso di studio");
        t.setFont(new Font("Candara", Font.PLAIN, 35));
		t.setForeground(new Color(51, 51, 51));
		t.setBounds(65,120,400,40);	
		
		 t1=new JLabel("Scelta dell'anno di corso");
	        t1.setFont(new Font("Candara", Font.PLAIN, 35));
			t1.setForeground(new Color(51, 51, 51));
			t1.setBounds(65,120,400,40);	
			
		tt=new JLabel("ESAMI");
        tt.setFont(new Font("Candara", Font.PLAIN, 35));
		tt.setForeground(new Color(51, 51, 51));
		tt.setBounds(200,30,100,40);
		
		content1.add(t);
		content1.add(tt);
		
		ArrayList<String> codici = new ArrayList<>();
		

		combo.setBounds(65, 165, 369, 50);
		combo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0, 64)));
		combo.setFont(new Font("Candara", Font.BOLD, 14));
		//combo.setBackground(new Color(70, 73, 96));
		//combo.setForeground(new Color(255,255,255));
		combo.setMaximumRowCount(6);
		

		combo1.setBounds(65, 165, 369, 50);
		combo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0, 64)));
		combo1.setFont(new Font("Candara", Font.BOLD, 14));
		//combo.setBackground(new Color(70, 73, 96));
		//combo.setForeground(new Color(255,255,255));
		combo1.setMaximumRowCount(6);

		
		
		ResultSet rs;
		
		try{
			rs = Database.Query("SELECT * FROM corso", Database.getConn(), true);
			
				while(rs.next()){
					flag=1;
					combo.addItem(rs.getString("nome"));
					codici.add(rs.getString("codice"));
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
		content1.add(combo);
		
		ok = new JButton();
		ok.setBounds(383,223,50,30);
		ok.setBackground(new Color(70, 73, 96));
		ok.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ok.setLayout(null);
		JLabel se;

			se=new JLabel( new ImageIcon("image/next.png"));
			se.setBounds(16,5,20,20);
			ok.add(se);

		
		ok1 = new JButton();
		ok1.setBounds(383,223,50,30);
		ok1.setBackground(new Color(70, 73, 96));
		ok1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ok1.setLayout(null);
		JLabel se1;

			se1=new JLabel( new ImageIcon("image/next.png"));
			se1.setBounds(16,5,20,20);
			ok1.add(se1);

		
		prec = new JButton();
		prec.setBounds(65,223,50,30);
		prec.setBackground(new Color(70, 73, 96));
		prec.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		prec.setLayout(null);
		JLabel se2;

			se2=new JLabel( new ImageIcon("image/prec.png"));
			se2.setBounds(16,5,20,20);
			prec.add(se2);

		
		content1.add(ok);
    	
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(flag!=0){
					codiceCorso = codici.get(combo.getSelectedIndex());
					gotoAnno();
				}
				else{
					/**definizione di error**/
					
					JPanel error = new JPanel();
					error.setBounds(65, 203, 300, 30);
					error.setLayout(null);
					error.setBackground(null);
					JLabel s = new JLabel();

						s=new JLabel( new ImageIcon("image/error.png"));
						s.setBounds(0,5,20,20);
						error.add(s);

					JLabel lab= new JLabel("Nessun Corso di Studio presente nel sistema");
					lab.setFont(new Font("Candara", Font.BOLD, 14));
					lab.setForeground(new Color(240, 98, 146));
					lab.setBounds(22,10,300,20);
					error.add(lab);
					content1.add(error);
					error.setVisible(true);
					content1.updateUI();
				}
			}
			
		});
    	
    	
	}
	
	@SuppressWarnings("unchecked")
	void gotoAnno(){
		content1.removeAll();
		content1.updateUI();
		
		int num_anni=0;
		ResultSet rs;
		try{
			rs = Database.Query("SELECT num_anni FROM corso c WHERE c.codice='"+codiceCorso+"'", Database.getConn(), true);
			
			while(rs.next()){
				num_anni=rs.getInt("num_anni");
			}
			
			int count=1;
			while(count <= num_anni){
				combo1.addItem("Anno "+count);
				count++;
			}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		

		
		content1.add(t1);
		content1.add(tt);
		content1.add(combo1);
		content1.add(ok1);
		content1.add(prec);
		content1.updateUI();
		
		prec.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				prec();
			}
			
		});
		
		ok1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				anno = (combo1.getSelectedIndex()) + 1;				
				listMaterie();
				
			}
			
		});
		
	}

	void prec(){
		this.removeAll();
    	
		this.add(new Esami());
		
		this.updateUI();
	}
	
	void listMaterie(){
		this.removeAll();
		
		this.add(new ListEsamiAdmin(anno, codiceCorso));
		
		this.updateUI();
	}
}
