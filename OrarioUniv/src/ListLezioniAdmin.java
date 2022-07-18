
import java.awt.*;
import java.awt.event.*;
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


public class ListLezioniAdmin extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel lezioniP = new JPanel();
	JPanel lezioni = new JPanel();
	JPanel edit = new JPanel();
	JPanel aggPanel = new JPanel();
	JPanel modifPanel = new JPanel();
	JPanel success = new JPanel();
	JPanel error = new JPanel();
	JPanel success1 = new JPanel();
	JPanel errorAtt = new JPanel();
	JPanel error1 = new JPanel();
	JPanel errorVuoto1 = new JPanel();
	JPanel errorVuoto2 = new JPanel();
	JPanel errorOra1 = new JPanel();
	JPanel errorOra2 = new JPanel();
	
	JLabel titolo;
	JLabel titolo1 = new JLabel("Elenco esami");
	JLabel agg = new JLabel("Aggiungere");
	JLabel agg1 = new JLabel("Aggiungi una nuova Lezione");
	JLabel modif = new JLabel("Modificare/Cancellare");
	JLabel modif1 = new JLabel("Modifica o cancella una Lezione");
	
	JLabel materiaAdd = new JLabel("Materia:");
	JLabel aulaAdd = new JLabel("Aula:");
	JLabel inizioAdd = new JLabel("Inizio:");
	JLabel fineAdd = new JLabel("Fine:");
	JLabel dataAdd = new JLabel("Giorno:");
	
	JLabel giornoModif1 = new JLabel("Giorno:");
	JLabel aulaModif1 = new JLabel("Aula:");
	JLabel inizioModif1 = new JLabel("Inizio:");
	JLabel materiaModif = new JLabel("Materia:");
	JLabel aulaModif2 = new JLabel("Aula:");
	JLabel inizioModif2 = new JLabel("Inizio:");
	JLabel fineModif = new JLabel("Fine:");
	
	@SuppressWarnings("rawtypes")
	JComboBox materiaFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aulaFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziohFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziomFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox finehFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox finemFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox giornoFAdd = new JComboBox();

	@SuppressWarnings("rawtypes")
	JComboBox giornoFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aulaFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziohFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziomFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox materiaFModif = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aulaFModif2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziohFModif2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox iniziomFModif2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox finehFModif = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox finemFModif = new JComboBox();
	
	JButton okAdd = new JButton();
	
	JButton okModif = new JButton();
	JButton okCancel = new JButton();
	
	
	@SuppressWarnings("unchecked")
	ListLezioniAdmin(int anno, String codiceCorente){
		
		titolo = new JLabel("Orario delle Lezioni: "+codiceCorente+" Anno "+anno);
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(lezioniP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(edit);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		lezioniP.setLayout(new BorderLayout());
		lezioniP.setBackground(null);
		lezioniP.add(title, BorderLayout.NORTH);
		lezioniP.add(lezioni, BorderLayout.CENTER);

		
		lezioni.setLayout(new BoxLayout(lezioni, BoxLayout.PAGE_AXIS));

		
		edit.setLayout(new BoxLayout(edit, BoxLayout.LINE_AXIS));
		edit.setBackground(null);
		edit.setPreferredSize(new Dimension(426, 470));

		title.setLayout(null);
		titolo.setBounds(20,25, 450, 30);
		//titolo1.setBounds(260,30, 100, 25);

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
		materiaAdd.setBounds(30, 70, 100, 30);
		
		aulaAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		aulaAdd.setForeground(new Color( 51, 51, 51));
		aulaAdd.setBounds(30, 110, 130, 30);
		
		inizioAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		inizioAdd.setForeground(new Color( 51, 51, 51));
		inizioAdd.setBounds(30, 150, 130, 30);
		
		fineAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		fineAdd.setForeground(new Color( 51, 51, 51));
		fineAdd.setBounds(30, 190, 130, 30);
		
		dataAdd.setFont(new Font("Candara", Font.PLAIN, 16));
		dataAdd.setForeground(new Color( 51, 51, 51));
		dataAdd.setBounds(30, 230, 130, 30);
		
		
		materiaFAdd.setBounds(145, 70, 250, 30);
		materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		materiaFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		aulaFAdd.setBounds(145, 110, 250, 30);
		aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aulaFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziohFAdd.setBounds(145, 150, 120, 30);
		iniziohFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziohFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziomFAdd.setBounds(275, 150, 120, 30);
		iniziomFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziomFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		finehFAdd.setBounds(145, 190, 120, 30);
		finehFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		finehFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		finemFAdd.setBounds(275, 190, 120, 30);
		finemFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		finemFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		giornoFAdd.setBounds(145, 230, 250, 30);
		giornoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		giornoFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		okAdd.setBounds(345,270,50,30);
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
		
		
		giornoModif1.setFont(new Font("Candara", Font.PLAIN, 16));
		giornoModif1.setForeground(new Color( 51, 51, 51));
		giornoModif1.setBounds(30, 70, 130, 30);
		
		aulaModif1.setFont(new Font("Candara", Font.PLAIN, 16));
		aulaModif1.setForeground(new Color( 51, 51, 51));
		aulaModif1.setBounds(30, 110, 130, 30);
		
		inizioModif1.setFont(new Font("Candara", Font.PLAIN, 16));
		inizioModif1.setForeground(new Color( 51, 51, 51));
		inizioModif1.setBounds(30, 150, 50, 30);
		
		materiaModif.setFont(new Font("Candara", Font.PLAIN, 16));
		materiaModif.setForeground(new Color( 51, 51, 51));
		materiaModif.setBounds(30, 230, 130, 30);
		
		aulaModif2.setFont(new Font("Candara", Font.PLAIN, 16));
		aulaModif2.setForeground(new Color( 51, 51, 51));
		aulaModif2.setBounds(30, 270, 130, 30);
		
		inizioModif2.setFont(new Font("Candara", Font.PLAIN, 16));
		inizioModif2.setForeground(new Color( 51, 51, 51));
		inizioModif2.setBounds(30, 310, 130, 30);
		
		fineModif.setFont(new Font("Candara", Font.PLAIN, 16));
		fineModif.setForeground(new Color( 51, 51, 51));
		fineModif.setBounds(30, 350, 130, 30);
		
		giornoFModif1.setBounds(145, 70, 250, 30);
		giornoFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		giornoFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		aulaFModif1.setBounds(145, 110, 250, 30);
		aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aulaFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziohFModif1.setBounds(145, 150, 120, 30);
		iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziohFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziomFModif1.setBounds(275, 150, 120, 30);
		iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziomFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		materiaFModif.setBounds(145, 230, 250, 30);
		materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		materiaFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		aulaFModif2.setBounds(145, 270, 250, 30);
		aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aulaFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziohFModif2.setBounds(145, 310, 120, 30);
		iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziohFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		iniziomFModif2.setBounds(275, 310, 120, 30);
		iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		iniziomFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		finehFModif.setBounds(145, 350, 120, 30);
		finehFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		finehFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		finemFModif.setBounds(275, 350, 120, 30);
		finemFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		finemFModif.setFont(new Font("Candara", Font.BOLD, 14));
		
		okModif.setBounds(345, 390,50,30);
		okModif.setBackground(new Color(70, 73, 96));
		okModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		okModif.setLayout(null);
		JLabel se1;

			se1=new JLabel( new ImageIcon("image/editw.png"));
			se1.setBounds(16,5,20,20);
			okModif.add(se1);

		
		okCancel.setBounds(345,190,50,30);
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
		aggPanel.add(aulaAdd);
		aggPanel.add(inizioAdd);
		aggPanel.add(fineAdd);
		aggPanel.add(dataAdd);
		aggPanel.add(materiaFAdd);
		aggPanel.add(aulaFAdd);
		aggPanel.add(iniziohFAdd);
		aggPanel.add(finehFAdd);
		aggPanel.add(iniziomFAdd);
		aggPanel.add(finemFAdd);
		aggPanel.add(giornoFAdd);
		aggPanel.add(okAdd);
		
		
		modifPanel.add(modif);
		modifPanel.add(modif1);
		modifPanel.add(giornoModif1);
		modifPanel.add(aulaModif1);
		modifPanel.add(inizioModif1);
		modifPanel.add(materiaModif);
		modifPanel.add(aulaModif2);
		modifPanel.add(inizioModif2);
		modifPanel.add(fineModif);
		modifPanel.add(aulaFModif1);
		modifPanel.add(iniziohFModif1);
		modifPanel.add(iniziomFModif1);
		modifPanel.add(okCancel);
		modifPanel.add(materiaFModif);
		modifPanel.add(aulaFModif2);
		modifPanel.add(iniziohFModif2);
		modifPanel.add(finehFModif);
		modifPanel.add(iniziomFModif2);
		modifPanel.add(finemFModif);
		modifPanel.add(giornoFModif1);
		modifPanel.add(okModif);

		
		edit.setBackground(null);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		edit.add(aggPanel);
		edit.add(Box.createRigidArea(new Dimension(50,0)));
		edit.add(modifPanel);
		edit.add(Box.createRigidArea(new Dimension(20,0)));
		
		/**definizione del contenuto dei diversi ComboBox**/
			ResultSet rs;
			/*materiaFAdd*/
				try{
					//mando una querry per selezionare tutte le materie con materia e anno specificati
					rs = Database.Query("SELECT * FROM materia m where m.corso='"+codiceCorente+"' and m.anno_corso='"+anno+"'", Database.getConn(), true);
					
					while(rs.next()){
						materiaFAdd.addItem(rs.getString("codice"));
					}
					
				}catch (SQLException ex) {
					// A
					ex.printStackTrace();
				}
				
			/*aulaFAdd*/
				try{
					//mando una querry per selezionare tutte le aule
					rs = Database.Query("SELECT * FROM aula", Database.getConn(), true);
					
					while(rs.next()){
						aulaFAdd.addItem(rs.getString("nome_aula"));
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			/*iniziohFAdd*/
				for(int i=0; i<10; i++){
					iniziohFAdd.addItem("0"+i);
				}
				for(int i=10; i<24; i++){
					iniziohFAdd.addItem(i);
				}
				
			/*iniziomFAdd*/
				for(int i=0; i<10; i++){
					iniziomFAdd.addItem("0"+i);
				}
				for(int i=10; i<60; i++){
					iniziomFAdd.addItem(i);
				}
				
			/*finehFAdd*/
				for(int i=0; i<10; i++){
					finehFAdd.addItem("0"+i);
				}
				for(int i=10; i<24; i++){
					finehFAdd.addItem(i);
				}
				
			/*finemFAdd*/
				for(int i=0; i<10; i++){
					finemFAdd.addItem("0"+i);
				}
				for(int i=10; i<60; i++){
					finemFAdd.addItem(i);
				}
			
			/*giornoFAdd*/
				
					giornoFAdd.addItem("lunedì");
					giornoFAdd.addItem("martedì");
					giornoFAdd.addItem("mercoledì");
					giornoFAdd.addItem("giovedì");
					giornoFAdd.addItem("venerdì");
				
			/*giornoFModif1*/
					
					giornoFModif1.addItem("lunedì");
					giornoFModif1.addItem("martedì");
					giornoFModif1.addItem("mercoledì");
					giornoFModif1.addItem("giovedì");
					giornoFModif1.addItem("venerdì");


				
			/*iniziohFModif1*/
				for(int i=0; i<10; i++){
					iniziohFModif1.addItem("0"+i);
				}
				for(int i=10; i<24; i++){
					iniziohFModif1.addItem(i);
				}
				
			/*iniziomFModif1*/
				for(int i=0; i<10; i++){
					iniziomFModif1.addItem("0"+i);
				}
				for(int i=10; i<60; i++){
					iniziomFModif1.addItem(i);
				}
				
			/*iniziohFModif2*/
				for(int i=0; i<10; i++){
					iniziohFModif2.addItem("0"+i);
				}
				for(int i=10; i<24; i++){
					iniziohFModif2.addItem(i);
				}
				
			/*iniziomFModif2*/
				for(int i=0; i<10; i++){
					iniziomFModif2.addItem("0"+i);
				}
				for(int i=10; i<60; i++){
					iniziomFModif2.addItem(i);
				}
				
			/*finehFModif*/
				for(int i=0; i<10; i++){
					finehFModif.addItem("0"+i);
				}
				for(int i=10; i<24; i++){
					finehFModif.addItem(i);
				}
				
			/*finemFModif*/
				for(int i=0; i<10; i++){
					finemFModif.addItem("0"+i);
				}
				for(int i=10; i<60; i++){
					finemFModif.addItem(i);
				}

				
			/*materiaFModif*/
				try{
					//mando una querry per selezionare tutte le materie con materia e anno specificati
					rs = Database.Query("SELECT * FROM materia m where m.corso='"+codiceCorente+"' and m.anno_corso='"+anno+"'", Database.getConn(), true);
					
					while(rs.next()){
						materiaFModif.addItem(rs.getString("codice"));
					}
					
				}catch (SQLException ex) {
					// A
					ex.printStackTrace();
				}
				
			/*aulaFModif1*/
				try{
					//mando una querry per selezionare tutte le aule
					rs = Database.Query("SELECT * FROM aula", Database.getConn(), true);
					
					while(rs.next()){
						aulaFModif1.addItem(rs.getString("nome_aula"));
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			/*aulaFModif2*/
				try{
					//mando una querry per selezionare tutte le aule
					rs = Database.Query("SELECT * FROM aula", Database.getConn(), true);
					
					while(rs.next()){
						aulaFModif2.addItem(rs.getString("nome_aula"));
					}
					
				}catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				/**definizione di error**/
				error.setBounds(140, 270, 300, 30);
				error.setLayout(null);
				error.setBackground(null);
				JLabel s=new JLabel(); 

					s=new JLabel( new ImageIcon("image/error.png"));
					s.setBounds(0,5,20,20);
					error.add(s);

				JLabel t= new JLabel("Aula occupata a l'ora indicata");
				t.setFont(new Font("Candara", Font.BOLD, 14));
				t.setForeground(new Color(240, 98, 146));
				t.setBounds(22,10,200,20);
				error.add(t);
				aggPanel.add(error);
				error.setVisible(false);
						
				
		/**definizione di success**/
		success.setBounds(110, 270, 230, 30);
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
		errorVuoto1.setBounds(83, 270, 370, 30);
		errorVuoto1.setLayout(null);
		errorVuoto1.setBackground(null);
		JLabel s3=new JLabel(); 

			s3=new JLabel( new ImageIcon("image/warning.png"));
			s3.setBounds(0,5,20,20);
			errorVuoto1.add(s3);

		JLabel t3= new JLabel("Nessun elemento presente nel sistema");
		t3.setFont(new Font("Candara", Font.BOLD, 14));
		t3.setForeground(new Color(216, 150, 54));
		t3.setBounds(22,11,290,20);
		errorVuoto1.add(t3);
		aggPanel.add(errorVuoto1);
		errorVuoto1.setVisible(false);
		
		/**definizione di errorOra1**/
		errorOra1.setBounds(83, 270, 370, 30);
		errorOra1.setLayout(null);
		errorOra1.setBackground(null);
		JLabel s4=new JLabel(); 

			s4=new JLabel( new ImageIcon("image/warning.png"));
			s4.setBounds(0,5,20,20);
			errorOra1.add(s4);

		JLabel t4= new JLabel("Ora inizio maggiore o uguale a ora fine");
		t4.setFont(new Font("Candara", Font.BOLD, 14));
		t4.setForeground(new Color(216, 150, 54));
		t4.setBounds(22,11,290,20);
		errorOra1.add(t4);
		aggPanel.add(errorOra1);
		errorOra1.setVisible(false);
	
		/**definizione di errorOra2**/
		errorOra2.setBounds(83, 390, 370, 30);
		errorOra2.setLayout(null);
		errorOra2.setBackground(null);
		JLabel s5=new JLabel(); 

			s5=new JLabel( new ImageIcon("image/warning.png"));
			s5.setBounds(0,5,20,20);
			errorOra2.add(s5);

		JLabel t5= new JLabel("Ora inizio maggiore o uguale a ora fine");
		t5.setFont(new Font("Candara", Font.BOLD, 14));
		t5.setForeground(new Color(216, 150, 54));
		t5.setBounds(22,11,290,20);
		errorOra2.add(t5);
		modifPanel.add(errorOra2);
		errorOra2.setVisible(false);
		
		/**definizione di error1**/
		error1.setBounds(190, 390, 300, 30);
		error1.setLayout(null);
		error1.setBackground(null);
		JLabel i=new JLabel(); 

			i=new JLabel( new ImageIcon("image/error.png"));
			i.setBounds(0,5,20,20);
			error1.add(i);

		JLabel te= new JLabel("Lezione non esistente");
		te.setFont(new Font("Candara", Font.BOLD, 14));
		te.setForeground(new Color(240, 98, 146));
		te.setBounds(22,10,200,20);
		error1.add(te);
		modifPanel.add(error1);
		error1.setVisible(false);

		/**definizione di errorAtt**/
		errorAtt.setBounds(190, 390, 300, 30);
		errorAtt.setLayout(null);
		errorAtt.setBackground(null);
		JLabel i1=new JLabel(); 

			i1=new JLabel( new ImageIcon("image/error.png"));
			i1.setBounds(0,5,20,20);
			errorAtt.add(i1);

		JLabel te1= new JLabel("Lezione già esistente");
		te1.setFont(new Font("Candara", Font.BOLD, 14));
		te1.setForeground(new Color(240, 98, 146));
		te1.setBounds(22,10,200,20);
		errorAtt.add(te1);
		modifPanel.add(errorAtt);
		errorAtt.setVisible(false);

		/**definizione di success1**/
		success1.setBounds(110, 390, 230, 30);
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
			
		/**definizione di errorVuoto2**/
		errorVuoto2.setBounds(83, 390, 370, 30);
		errorVuoto2.setLayout(null);
		errorVuoto2.setBackground(null);
		JLabel i4=new JLabel(); 

			i4=new JLabel( new ImageIcon("image/warning.png"));
			i4.setBounds(0,5,20,20);
			errorVuoto2.add(i4);

		JLabel t6= new JLabel("Nessun elemento presente nel sistema");
		t6.setFont(new Font("Candara", Font.BOLD, 14));
		t6.setForeground(new Color(216, 150, 54));
		t6.setBounds(22,11,290,20);
		errorVuoto2.add(t6);
		modifPanel.add(errorVuoto2);
		errorVuoto2.setVisible(false);
		
		
		/** aggiungimento lezione**/
		
		okAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addLezione(codiceCorente, anno);
			}
			
			
		});
		
		/**Gestione modifica lezione**/
		
		okModif.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editLezione(codiceCorente, anno);
			}
			
			
		});
		
		/**Gestione cancellazione lezione**/
		
		okCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelLezione(codiceCorente, anno);
			}
			
			
		});
		
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

	
	void addLezione(String c, int a){
		
		if( materiaFAdd.getItemCount() == 0){
			
			success.setVisible(false);
			errorVuoto1.setVisible(true);
			materiaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
			aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));

		}
		else{
			
			if(aulaFAdd.getItemCount() == 0){
				
				materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aulaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
				success.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{
				if(Integer.valueOf(iniziohFAdd.getSelectedIndex())>= Integer.valueOf(finehFAdd.getSelectedIndex())){
					materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					iniziohFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					iniziomFAdd.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(216, 150, 54)));
					finehFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					finemFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					
					success.setVisible(false);
					errorOra1.setVisible(true);
				}
				else{
					int x=-1;
					
					ResultSet rs;
					try {
						/* Eseguo una query specificando il codice */
						rs = Database.Query("SELECT l.* FROM lezione l WHERE l.ora_inizio = '"+iniziohFAdd.getSelectedItem()+":"+iniziomFAdd.getSelectedItem()+"' and l.aula = '"+aulaFAdd.getSelectedItem()+"' and l.giorno = "+(giornoFAdd.getSelectedIndex()+1)+"", Database.getConn(), true);
						
						if(!rs.next()){//se nessun risultato
							
							try {  
								Database.Query("insert into lezione(giorno, ora_inizio, ora_fine, aula, materia, corso, anno_corso) values("+(giornoFAdd.getSelectedIndex()+1)+", '"+iniziohFAdd.getSelectedItem()+":"+iniziomFAdd.getSelectedItem()+"', '"+finehFAdd.getSelectedItem()+":"+finemFAdd.getSelectedItem()+"', '"+aulaFAdd.getSelectedItem()+"', '"+materiaFAdd.getSelectedItem()+"', '"+c+"', "+a+");", Database.getConn(), true);
								x = 1;
							} 
								catch (Exception e) { 
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
						
						finehFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						finemFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						
						aulaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						giornoFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						iniziohFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						iniziomFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						success.setVisible(false);
						errorVuoto1.setVisible(false);
						error.setVisible(true);
					}
					if(x == 1){
						aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						giornoFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						iniziohFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						iniziomFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						finehFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						finemFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						
						
						error.setVisible(false);
						errorVuoto1.setVisible(false);
						errorOra1.setVisible(false);
						success.setVisible(true);
						update(c, a);
						
					}
					
				}
			}
		}
	}
		
	
	@SuppressWarnings("unused")
	void editLezione(String c, int a){
		
		if(aulaFModif1.getItemCount() == 0){
			
			aulaFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
			materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
			iniziohFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
			iniziomFModif2.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(0, 0, 0, 64)));
			iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
			iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(0, 0, 0, 64)));
			finehFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
			finemFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
			success1.setVisible(false);
			errorVuoto2.setVisible(true);
		}
			else{
				if(materiaFModif.getItemCount() == 0){
					materiaFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					iniziohFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
					iniziomFModif2.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(0, 0, 0, 64)));
					iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
					iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(0, 0, 0, 64)));
					finehFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
					finemFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0, 64)));
					success1.setVisible(false);
					errorVuoto2.setVisible(true);
				}

					else{
			
			if(aulaFModif2.getItemCount() == 0){
				
				materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aulaFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
				iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, new Color(0, 0, 0, 64)));
				iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, new Color(0, 0, 0, 64)));
				finehFModif.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, new Color(0, 0, 0, 64)));
				finemFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				success.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{
				if(Integer.valueOf(iniziohFModif2.getSelectedIndex())>= Integer.valueOf(finehFModif.getSelectedIndex())){
					materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,  new Color(0, 0, 0, 64)));
					iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,  new Color(0, 0, 0, 64)));
					
					iniziohFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					iniziomFModif2.setBorder(BorderFactory.createMatteBorder(2, 2,2, 2, new Color(216, 150, 54)));
					finehFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					finemFModif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(216, 150, 54)));
					
					success.setVisible(false);
					errorOra2.setVisible(true);
				}
				else{
						
						int x=-1;
						
						ResultSet rs;
						ResultSet rs1;
						try {
							/* Eseguo una query */
							rs = Database.Query("SELECT l.* FROM lezione l WHERE l.ora_inizio = '"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"' and l.aula = '"+aulaFModif1.getSelectedItem()+"' and l.giorno = "+(giornoFModif1.getSelectedIndex()+1)+"", Database.getConn(), true);
							
							if(!rs.next()){//se nessun risultato	
								x = 0;					
							}
							else{ //se risultato
								
								String giornoa= String.valueOf(giornoFModif1.getSelectedItem());
								String aulaa= String.valueOf(aulaFModif1.getSelectedItem());
								String inizioha= String.valueOf(iniziohFModif1.getSelectedItem());
								String inizioma= String.valueOf(iniziomFModif1.getSelectedItem());
								
								String aulan= String.valueOf(aulaFModif2.getSelectedItem());
								String iniziohn= String.valueOf(iniziohFModif2.getSelectedItem());
								String iniziomn= String.valueOf(iniziomFModif2.getSelectedItem());						
								
								
								if( ( ( (inizioha.compareTo(iniziohn))!= 0 ) || ( (inizioma.compareTo(iniziomn))!= 0 ) || ( (aulaa.compareTo(aulan))!= 0 ) )){
								
									
									try{
										rs = Database.Query("SELECT l.* FROM lezione l WHERE l.ora_inizio = '"+iniziohFModif2.getSelectedItem()+":"+iniziomFModif2.getSelectedItem()+"' and l.aula = '"+aulaFModif2.getSelectedItem()+"' and l.giorno = "+(giornoFModif1.getSelectedIndex()+1)+"", Database.getConn(), true);
										
										if(!rs.next()){//se nessun risultato
											
											try { 
												
												Database.Query("update lezione "
														+ "set ora_fine='"+finehFModif.getSelectedItem()+":"+finemFModif.getSelectedItem()+"', materia='"+materiaFModif.getSelectedItem()+"', ora_inizio='"+iniziohFModif2.getSelectedItem()+":"+iniziomFModif2.getSelectedItem()+"', aula='"+aulaFModif2.getSelectedItem()+"' "
														+ "WHERE giorno="+(giornoFModif1.getSelectedIndex()+1)+" "
														+ "and aula='"+aulaFModif1.getSelectedItem()+"' "
														+ "and ora_inizio='"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"'", Database.getConn(), true);
												x = 1;
											} 
												catch (Exception e) { 
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
										
										Database.Query("update lezione "
												+ "set ora_fine='"+finehFModif.getSelectedItem()+":"+finemFModif.getSelectedItem()+"', materia='"+materiaFModif.getSelectedItem()+"' "
												+ "WHERE giorno="+(giornoFModif1.getSelectedIndex()+1)+" "
												+ "and aula='"+aulaFModif1.getSelectedItem()+"' "
												+ "and ora_inizio='"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"'", Database.getConn(), true);
										x = 1;
									} 
										catch (Exception e) { 
										}
								}
								
							}
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
						if(x == 0){
							aulaFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							giornoFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finehFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finemFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							
							success1.setVisible(false);
							errorVuoto1.setVisible(false);
							errorOra2.setVisible(false);
							error1.setVisible(true);
							errorAtt.setVisible(false);
						}
						if(x == 1){
							
						
							aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							giornoFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finehFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finemFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							success1.setVisible(true);
							errorVuoto1.setVisible(false);
							errorOra2.setVisible(false);
							errorAtt.setVisible(false);
							error1.setVisible(false);
							
							update(c, a);
							

						}
						if(x == 2){
							
							aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							giornoFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finehFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							finemFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							aulaFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziohFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziomFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							success1.setVisible(false);
							errorVuoto1.setVisible(false);
							errorOra2.setVisible(false);
							errorAtt.setVisible(true);
							error1.setVisible(false);
							
						}
					}

					}
				}
			}

 }


	void update(String c, int a){
		
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
					+ "and l.corso='"+c+"' "
					+ "and l.anno_corso="+a+"", Database.getConn(), true);
			
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
					+ "and l.corso='"+c+"' "
					+ "and l.anno_corso="+a+"", Database.getConn(), true);
			
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
					+ "and l.corso='"+c+"' "
					+ "and l.anno_corso="+a+"", Database.getConn(), true);
			
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
					+ "and l.corso='"+c+"' "
					+ "and l.anno_corso="+a+"", Database.getConn(), true);
			
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
					+ "and l.corso='"+c+"' "
					+ "and l.anno_corso="+a+"", Database.getConn(), true);
			
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
	
	void cancelLezione(String c, int a){
		
			
		if(aulaFModif1.getItemCount() == 0){
			
			aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			success1.setVisible(false);
			errorVuoto2.setVisible(true);
		}
		else{

			int x=-1;
			
			ResultSet rs;
			try {
				/* Eseguo una query specificando il codice */
				rs = Database.Query("SELECT l.* FROM lezione l WHERE l.ora_inizio = '"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"' and l.aula = '"+aulaFModif1.getSelectedItem()+"' and l.giorno = "+(giornoFModif1.getSelectedIndex()+1)+"", Database.getConn(), true);
				
				if(rs.next()){//se risultato
					
					try {
						Database.Query("delete from lezione where lezione.giorno='"+(giornoFModif1.getSelectedIndex()+1)+"' and lezione.aula='"+aulaFModif1.getSelectedItem()+"' and lezione.ora_inizio='"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"'", Database.getConn(), true);
						x = 1;
					}
						catch (Exception e) { 
						}
						
						
				}
				else{ //se nessun risultato
					x = 0;
				}
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			if(x == 0){
				aulaFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				giornoFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));;
				iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				
				aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				giornoFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorVuoto1.setVisible(false);
				error1.setVisible(true);
			}
			if(x == 1){
				aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				giornoFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				error1.setVisible(false);
				errorVuoto1.setVisible(false);
				success1.setVisible(true);
				update(c, a);
				
			}

		}
		
	}
}
