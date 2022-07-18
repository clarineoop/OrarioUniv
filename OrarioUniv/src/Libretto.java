
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.plaf.basic.*;

@SuppressWarnings("serial")

/** Classe che gestisce L'AdminPanel.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del logout da parte dell'amministratore.
 */


public class Libretto extends JScrollPane{
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel librettoP = new JPanel();
	JPanel libretto = new JPanel();
	JPanel edit = new JPanel();
	JPanel aggPanel = new JPanel();
	JPanel modifPanel = new JPanel();
	JPanel success = new JPanel();
	JPanel error30 = new JPanel();
	JPanel error = new JPanel();
	JPanel errorInt = new JPanel();
	JPanel success1 = new JPanel();
	JPanel errorAtt = new JPanel();
	JPanel error31 = new JPanel();
	JPanel errorInt1 = new JPanel();
	JPanel errorVuoto1 = new JPanel();
	JPanel errorVuotoC = new JPanel();
	JPanel errorVuotoC2 = new JPanel();
	JPanel errorVuoto2 = new JPanel();
	
	
	JLabel titolo = new JLabel("Libretto");
	JLabel titolo1 = new JLabel("Libretto dello studente");
	JLabel agg = new JLabel("Aggiungere");
	JLabel agg1 = new JLabel("Aggiungi un nuovo voto d'esame");
	JLabel modif = new JLabel("Modificare/Cancellare");
	JLabel modif1 = new JLabel("Modifica o cancella un voto d'esame");
	
	JLabel materiaAdd = new JLabel("Materia:");
	JLabel votoAdd = new JLabel("Voto:");
	
	
	JLabel materiaModif = new JLabel("Materia:");
	JLabel votoModif = new JLabel("Voto:");
	
	@SuppressWarnings("rawtypes")
	JComboBox materiaFAdd = new JComboBox();
	JTextField votoFAdd = new JTextField();
	
	@SuppressWarnings("rawtypes")
	JComboBox materiaFModif = new JComboBox();
	JTextField votoFModif = new JTextField();
	
	JButton okAdd = new JButton();
	
	JButton okModif = new JButton();
	JButton okCancel = new JButton();
	
	ArrayList<String> codici = new ArrayList<>();
	
	
	@SuppressWarnings("unchecked")
	Libretto(String matricola){
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(librettoP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(edit);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		librettoP.setLayout(new BorderLayout());
		librettoP.setBackground(null);
		librettoP.add(title, BorderLayout.NORTH);
		librettoP.add(libretto, BorderLayout.CENTER);

		
		libretto.setLayout(new BoxLayout(libretto, BoxLayout.PAGE_AXIS));

		
		edit.setLayout(new BoxLayout(edit, BoxLayout.LINE_AXIS));
		edit.setBackground(null);
		edit.setPreferredSize(new Dimension(426, 250));

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
		
		materiaAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		materiaAdd.setForeground(new Color( 51, 51, 51));
		materiaAdd.setBounds(30, 100, 100, 30);
		
		votoAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		votoAdd.setForeground(new Color( 51, 51, 51));
		votoAdd.setBounds(30, 140, 130, 30);
		
		materiaFAdd.setBounds(145, 100, 250, 30);
		materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		materiaFAdd.setFont(new Font("Candara", Font.BOLD, 14));

		votoFAdd.setBounds(145, 140, 250, 30);
		votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		votoFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		okAdd.setBounds(345,180,50,30);
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
		
		materiaModif.setFont(new Font("Candara", Font.PLAIN, 16));
		materiaModif.setForeground(new Color( 51, 51, 51));
		materiaModif.setBounds(30, 70, 130, 30);
		
		votoModif.setFont(new Font("Candara", Font.PLAIN, 16));
		votoModif.setForeground(new Color( 51, 51, 51));
		votoModif.setBounds(30, 150, 50, 30);
		
		materiaFModif.setBounds(145, 70, 250, 30);
		materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		materiaFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		votoFModif.setBounds(145, 150, 250, 30);
		votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		votoFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		okModif.setBounds(345,190,50,30);
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
		aggPanel.add(materiaAdd);
		aggPanel.add(votoAdd);
		aggPanel.add(materiaFAdd);
		aggPanel.add(votoFAdd);
		aggPanel.add(okAdd);
		
		
		modifPanel.add(modif);
		modifPanel.add(modif1);
		modifPanel.add(materiaModif);
		modifPanel.add(votoModif);
		modifPanel.add(materiaFModif);
		modifPanel.add(okCancel);
		modifPanel.add(votoFModif);
		modifPanel.add(okModif);


		
		edit.setBackground(null);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		edit.add(aggPanel);
		edit.add(Box.createRigidArea(new Dimension(50,0)));
		edit.add(modifPanel);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		
		/**contenuto dei JComboBox materia**/
		
		ResultSet ru;
		
		try{
			ru = Database.Query("SELECT * FROM materia m, studente s "
					+ "where s.matricola = "+matricola+" "
					+ "and m.corso = s.corso ", Database.getConn(), true);
			
				while(ru.next()){
					materiaFAdd.addItem(ru.getString("m.nome"));
					materiaFModif.addItem(ru.getString("m.nome"));
					codici.add(ru.getString("m.codice"));
				}
			
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	
		
		/**definizione di success**/
		success.setBounds(110, 180, 230, 30);
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
		errorVuoto1.setBounds(125, 180, 300, 30);
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
		
		/**definizione di errorInt**/
		errorInt.setBounds(150, 180, 300, 30);
		errorInt.setLayout(null);
		errorInt.setBackground(null);
		JLabel ima=new JLabel(); 

			ima=new JLabel( new ImageIcon("image/warning.png"));
			ima.setBounds(0,5,20,20);
			errorInt.add(ima);

		JLabel te3i= new JLabel("Digitare un valore numerico");
		te3i.setFont(new Font("Candara", Font.BOLD, 14));
		te3i.setForeground(new Color(216, 150, 54));
		te3i.setBounds(22,11,290,20);
		errorInt.add(te3i);
		aggPanel.add(errorInt);
		errorInt.setVisible(false);
		
		/**definizione di error**/
		error.setBounds(198, 180, 145, 30);
		error.setLayout(null);
		error.setBackground(null);
		JLabel i1e=new JLabel(); 

			i1e=new JLabel( new ImageIcon("image/error.png"));
			i1e.setBounds(0,5,20,20);
			error.add(i1e);

		JLabel tee= new JLabel("Voto già esistente");
		tee.setFont(new Font("Candara", Font.BOLD, 14));
		tee.setForeground(new Color(240, 98, 146));
		tee.setBounds(22,10,130,20);
		error.add(tee);
		aggPanel.add(error);
		error.setVisible(false);

		/**definizione di error30**/
		error30.setBounds(60, 180, 300, 30);
		error30.setLayout(null);
		error30.setBackground(null);
		JLabel i30=new JLabel(); 

			i30=new JLabel( new ImageIcon("image/warning.png"));
			i30.setBounds(0,5,20,20);
			error30.add(i30);

		JLabel te30= new JLabel("Il Valore deve essere minore o uguale a 30");
		te30.setFont(new Font("Candara", Font.BOLD, 14));
		te30.setForeground(new Color(216, 150, 54));
		te30.setBounds(22,10,280,20);
		error30.add(te30);
		aggPanel.add(error30);
		error30.setVisible(false);

		
		/**definizione di errorVuotoC**/
		errorVuotoC.setBounds(87, 180, 300, 30);
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
		errorVuotoC2.setBounds(85, 190, 300, 30);
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
		errorAtt.setBounds(198, 190, 145, 30);
		errorAtt.setLayout(null);
		errorAtt.setBackground(null);
		JLabel i1=new JLabel(); 

			i1=new JLabel( new ImageIcon("image/error.png"));
			i1.setBounds(0,5,20,20);
			errorAtt.add(i1);

		JLabel te1= new JLabel("Voto non esistente");
		te1.setFont(new Font("Candara", Font.BOLD, 14));
		te1.setForeground(new Color(240, 98, 146));
		te1.setBounds(22,10,130,20);
		errorAtt.add(te1);
		modifPanel.add(errorAtt);
		errorAtt.setVisible(false);
		
		/**definizione di error31**/
		error31.setBounds(60, 190, 300, 30);
		error31.setLayout(null);
		error31.setBackground(null);
		JLabel i31=new JLabel(); 

			i31=new JLabel( new ImageIcon("image/warning.png"));
			i31.setBounds(0,5,20,20);
			error31.add(i31);

		JLabel te31= new JLabel("Il Valore deve essere minore o uguale a 30");
		te31.setFont(new Font("Candara", Font.BOLD, 14));
		te31.setForeground(new Color(216, 150, 54));
		te31.setBounds(22,10,280,20);
		error31.add(te31);
		modifPanel.add(error31);
		error31.setVisible(false);

		
		/**definizione di success1**/
		success1.setBounds(115, 190, 230, 30);
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
		errorInt1.setBounds(150, 190, 300, 30);
		errorInt1.setLayout(null);
		errorInt1.setBackground(null);
		JLabel i3=new JLabel(); 

			i3=new JLabel( new ImageIcon("image/warning.png"));
			i3.setBounds(0,5,20,20);
			errorInt1.add(i3);

		JLabel te3= new JLabel("Digitare un valore numerico");
		te3.setFont(new Font("Candara", Font.BOLD, 14));
		te3.setForeground(new Color(216, 150, 54));
		te3.setBounds(22,11,290,20);
		errorInt1.add(te3);
		modifPanel.add(errorInt1);
		errorInt1.setVisible(false);
		
		/**definizione di errorVuoto2**/
		errorVuoto2.setBounds(125, 190, 300, 30);
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
		
		
		/**Gestione aggiungimento Voto**/
		
		okAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addVoto(matricola);
			}
			
			
		});
		
		/**Gestione modifica corso**/
		
		okModif.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editVoto(matricola);
			}
			
			
		});
		
		/**Gestione cancellazione corso**/
		
		okCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteVoto(matricola);
			}
			
			
		});
		
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
					+ "where v.studente = "+Integer.valueOf(matricola)+" ", Database.getConn(), true);
			
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
				
				ResultSet r;
				try{
					
					r = Database.Query("select m.nome from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"' ", Database.getConn(), true);
					if(r.next()){
						materia = r.getString("nome");
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
		
		if(flag != 0){
					
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
	

	
	void addVoto(String matricola){
		
		if( materiaFAdd.getItemCount() == 0){
			
			success.setVisible(false);
			errorVuotoC.setVisible(true);
			errorInt.setVisible(false);
			error.setVisible(false);
			error30.setVisible(false);
			errorVuoto1.setVisible(false);
			materiaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
			votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
		}
		else{
			
			if(votoFAdd.getText().isEmpty()){
				
				votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				success.setVisible(false);
				errorVuotoC.setVisible(false);
				errorInt.setVisible(false);
				error.setVisible(false);
				error30.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{
					int x=-1;
					@SuppressWarnings("unused")
					ResultSet rs, r;
					
					try{
						
						rs=Database.Query("select * from voto "
								+ "where materia = '"+codici.get(materiaFAdd.getSelectedIndex())+"' "
								+ "and studente = "+Integer.valueOf(matricola)+" ", Database.getConn(), true);
						if(rs.next()){
							x=0;
						}
						else{
						
						try{
							double v = Double.parseDouble(votoFAdd.getText());
							
							if(v>30){
								x=2;
							}
							
							else{
								r=Database.Query("INSERT INTO voto(voto, materia, studente) "
										+ "VALUES ("+v+", '"+codici.get(materiaFAdd.getSelectedIndex())+"', "+Integer.valueOf(matricola)+")", Database.getConn(), true);
								x = 1;
							}
							
						}catch(Exception e){
							votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
							materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							success.setVisible(false);
							errorVuotoC.setVisible(false);
							errorInt.setVisible(true);
							error.setVisible(false);
							error30.setVisible(false);
							errorVuoto1.setVisible(false);
						}
						
						}	
					}catch (SQLException e) {
						
					}
					
					if(x == 1){
						votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(true);
						errorVuotoC.setVisible(false);
						errorInt.setVisible(false);
						error.setVisible(false);
						errorVuoto1.setVisible(false);
						error30.setVisible(false);
						votoFAdd.setText("");
						aggPanel.updateUI();
						update(matricola);
					}
					if(x == 0){
						materiaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(false);
						errorVuotoC.setVisible(false);
						errorInt.setVisible(false);
						errorVuoto1.setVisible(false);
						error30.setVisible(false);
						error.setVisible(true);
					}
					if(x == 2){
						votoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
						materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success.setVisible(false);
						errorVuotoC.setVisible(false);
						errorInt.setVisible(false);
						errorVuoto1.setVisible(false);
						error.setVisible(false);
						error30.setVisible(true);
					}
				}
			}
		}
			

	void update(String matricola){
		
		libretto.removeAll();

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
					+ "where v.studente = "+Integer.valueOf(matricola)+" ", Database.getConn(), true);
			
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
				
				ResultSet r;
				try{
					
					r = Database.Query("select m.nome from materia m "
							+ "where m.codice = '"+rset.getString("materia")+"' ", Database.getConn(), true);
					if(r.next()){
						materia = r.getString("nome");
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
		
		if(flag != 0){
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

	
	
	void editVoto(String matricola){
		
		if( materiaFModif.getItemCount() == 0){
			
			materiaFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
			votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorVuoto2.setVisible(false);
			errorVuotoC2.setVisible(true);
			error31.setVisible(false);
			errorAtt.setVisible(false);
		}
		else{
			
			if(votoFModif.getText().isEmpty()){
				
				votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorInt1.setVisible(false);
				errorVuoto2.setVisible(true);
				errorVuotoC2.setVisible(false);
				error31.setVisible(false);
				errorAtt.setVisible(false);
				
			}
			else{						
						int x=-1;

						
						ResultSet rs;
						try {
							
							
						
							/* Eseguo una query specificando il codice attuale */
							rs = Database.Query("SELECT * FROM voto "
									+ "WHERE studente= "+Integer.parseInt(matricola)+" "
											+ "and materia = '"+codici.get(materiaFModif.getSelectedIndex())+"' ", Database.getConn(), true);
							
							if(!rs.next()){//se nessun risultato	
								x = 0;					
							}
							else{	 
								
								try{
								double v = Double.parseDouble(votoFModif.getText());
								
								
								if(v>30){
									x=2;
								}
								
								else{
									Database.Query("UPDATE voto SET materia='"+codici.get(materiaFModif.getSelectedIndex())+"', voto= "+v+", studente="+Integer.valueOf(matricola)+" "
											+ " WHERE materia='"+codici.get(materiaFModif.getSelectedIndex())+"' ", Database.getConn(), true);
									x = 1;
									
								}
								}catch(Exception e){
									
									votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
									materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
									success1.setVisible(false);
									errorVuotoC2.setVisible(false);
									errorInt1.setVisible(true);
									errorAtt.setVisible(false);
									error31.setVisible(false);
									errorVuoto2.setVisible(false);
									
								}
							}
									
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
						if(x == 0){
							materiaFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							success1.setVisible(false);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorVuotoC2.setVisible(false);
							error31.setVisible(false);
							errorAtt.setVisible(true);
						}
						if(x == 1){
							votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							votoFModif.setText(null);
							
							success1.setVisible(true);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorVuotoC2.setVisible(false);
							errorAtt.setVisible(false);
							error31.setVisible(false);
							modifPanel.updateUI();
							update(matricola);

						}
						if(x == 2){
							votoFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
							materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							success1.setVisible(false);
							errorInt1.setVisible(false);
							errorVuoto2.setVisible(false);
							errorVuotoC2.setVisible(false);
							error31.setVisible(false);
							errorAtt.setVisible(false);
							error31.setVisible(true);
						}

					}

					}
	}
		
	
	void deleteVoto(String matricola){
		
		
		if( materiaFModif.getItemCount() == 0){
			
			materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			
			success1.setVisible(false);
			errorInt1.setVisible(false);
			errorVuoto2.setVisible(false);
			error31.setVisible(false);
			errorVuotoC2.setVisible(true);
			errorAtt.setVisible(false);
		}
		else{
			int x=-1;
			
			ResultSet rs;
			try {
				
				/* Eseguo una query specificando i dati del voto da cancellare*/
				rs = Database.Query("SELECT * FROM voto "
						+ "WHERE studente= "+Integer.parseInt(matricola)+" "
								+ "and materia = '"+codici.get(materiaFModif.getSelectedIndex())+"' ", Database.getConn(), true);
				
				if(!rs.next()){//se nessun risultato	
					x = 0;					
				}
				else{ //se risultato
					Database.Query("delete from voto "
							+ "where materia='"+codici.get(materiaFModif.getSelectedIndex())+"' ", Database.getConn(), true);
					
					materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					
					votoFModif.setText("");
					
					success1.setVisible(true);
					errorInt1.setVisible(false);
					errorVuoto2.setVisible(false);
					error31.setVisible(false);
					errorVuotoC2.setVisible(false);
					errorAtt.setVisible(false);
					modifPanel.updateUI();
					update(matricola);
					
				}
				
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
			if(x==0){
				materiaFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				votoFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorInt1.setVisible(false);
				errorVuoto2.setVisible(false);
				error31.setVisible(false);
				errorVuotoC2.setVisible(false);
				errorAtt.setVisible(true);
	
			}
		
	}
}
	
}
