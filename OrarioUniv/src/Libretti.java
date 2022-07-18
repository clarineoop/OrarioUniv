
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



@SuppressWarnings("serial")

/** Classe che gestisce il panello dei diversi libretti.
 * permette di scegliere il corso di studio e l'anno
  **/


public class Libretti extends JPanel {

	JPanel content1 = new JPanel();
	@SuppressWarnings("rawtypes")
	JComboBox combo = new JComboBox();

	JButton ok;
	JLabel t, t1, tt;
	String student;
	int flag = 0;
	
		
	
	@SuppressWarnings("unchecked")
	Libretti(){
		
		this.setLayout(null);
		this.add(content1);
        this.setBounds(0,0,943,572);
        
        content1.setLayout(null);
        content1.setBounds(230, 70, 500, 400);
        content1.setBackground(new Color(255, 255, 255));
        content1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, new Color(0, 0, 0, 40)));
        
        t=new JLabel("Scelta dello studente");
        t.setFont(new Font("Candara", Font.PLAIN, 35));
		t.setForeground(new Color(51, 51, 51));
		t.setBounds(65,120,400,40);	
			
		tt=new JLabel("LIBRETTI");
        tt.setFont(new Font("Candara", Font.PLAIN, 35));
		tt.setForeground(new Color(51, 51, 51));
		tt.setBounds(180,30,150,40);
		
		content1.add(t);
		content1.add(tt);
		
		ArrayList<String> matricole = new ArrayList<>();
		
		combo.setBounds(65, 165, 369, 50);
		combo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 0, 0, 64)));
		combo.setFont(new Font("Candara", Font.BOLD, 14));
		//combo.setBackground(new Color(70, 73, 96));
		//combo.setForeground(new Color(255,255,255));
		combo.setMaximumRowCount(10);

		
		
		ResultSet rs;
		
		try{
			rs = Database.Query("SELECT * FROM studente", Database.getConn(), true);
			
				while(rs.next()){
					flag=1;
					combo.addItem(rs.getString("matricola")+" "+rs.getString("cognome_studente")+" "+rs.getString("nome_studente"));
					matricole.add(rs.getString("matricola"));
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
		
		content1.add(ok);
    	
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(flag!=0){
					student = matricole.get(combo.getSelectedIndex());				
					libretto();
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

					JLabel lab= new JLabel("Nessun studente presente nel sistema");
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
		
	void libretto(){
		this.removeAll();
		
		this.add(new Libretto(student));
		
		this.updateUI();
	}
}
