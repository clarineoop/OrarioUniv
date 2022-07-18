
import java.awt.*;
import java.awt.event.*;
import java.util.*;
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


public class ListEsamiAdmin extends JScrollPane {
	
	JPanel content = new JPanel();
	JPanel title = new JPanel();
	JPanel esamiP = new JPanel();
	JPanel esami = new JPanel();
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
	
	JLabel titolo;
	JLabel titolo1 = new JLabel("Elenco esami");
	JLabel agg = new JLabel("Aggiungere");
	JLabel agg1 = new JLabel("Aggiungi un nuovo esame");
	JLabel modif = new JLabel("Modificare/Cancellare");
	JLabel modif1 = new JLabel("Modifica o cancella un esame");
	
	JLabel materiaAdd = new JLabel("Materia:");
	JLabel aulaAdd = new JLabel("Aula:");
	JLabel inizioAdd = new JLabel("Inizio:");
	JLabel fineAdd = new JLabel("Fine:");
	JLabel dataAdd = new JLabel("Data:");
	
	JLabel dataModif1 = new JLabel("Data:");
	JLabel aulaModif1 = new JLabel("Aula:");
	JLabel inizioModif1 = new JLabel("Inizio:");
	JLabel materiaModif = new JLabel("Materia:");
	JLabel aulaModif2 = new JLabel("Aula:");
	JLabel inizioModif2 = new JLabel("Inizio:");
	JLabel fineModif = new JLabel("Fine:");
	JLabel dataModif2 = new JLabel("Data:");
	
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
	JComboBox ggFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox mmFAdd = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aaFAdd = new JComboBox();

	@SuppressWarnings("rawtypes")
	JComboBox ggFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox mmFModif1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aaFModif1 = new JComboBox();
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
	@SuppressWarnings("rawtypes")
	JComboBox ggFModif2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox mmFModif2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox aaFModif2 = new JComboBox();
	
	JButton okAdd = new JButton();
	
	JButton okModif = new JButton();
	JButton okCancel = new JButton();
	
	
	@SuppressWarnings("unchecked")
	ListEsamiAdmin(int anno, String codiceCorente){
		
		titolo = new JLabel("Calendario degli Esami: "+codiceCorente+" Anno "+anno);
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(esamiP);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(edit);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		esamiP.setLayout(new BorderLayout());
		esamiP.setBackground(null);
		esamiP.add(title, BorderLayout.NORTH);
		esamiP.add(esami, BorderLayout.CENTER);

		
		esami.setLayout(new BoxLayout(esami, BoxLayout.PAGE_AXIS));

		
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
		
		ggFAdd.setBounds(145, 230, 60, 30);
		ggFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ggFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		mmFAdd.setBounds(210, 230, 60, 30);
		mmFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		mmFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		aaFAdd.setBounds(275, 230, 120, 30);
		aaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aaFAdd.setFont(new Font("Candara", Font.BOLD, 14));
		
		
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
		
		
		dataModif1.setFont(new Font("Candara", Font.PLAIN, 16));
		dataModif1.setForeground(new Color( 51, 51, 51));
		dataModif1.setBounds(30, 70, 130, 30);
		
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
		
		dataModif2.setFont(new Font("Candara", Font.PLAIN, 16));
		dataModif2.setForeground(new Color( 51, 51, 51));
		dataModif2.setBounds(30, 390, 130, 30);
		
		ggFModif1.setBounds(145, 70, 60, 30);
		ggFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ggFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		mmFModif1.setBounds(210, 70, 60, 30);
		mmFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		mmFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
		aaFModif1.setBounds(275, 70, 120, 30);
		aaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aaFModif1.setFont(new Font("Candara", Font.BOLD, 14));
		
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
		
		ggFModif2.setBounds(145, 390, 60, 30);
		ggFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		ggFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		mmFModif2.setBounds(210, 390, 60, 30);
		mmFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		mmFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		aaFModif2.setBounds(275, 390, 120, 30);
		aaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
		aaFModif2.setFont(new Font("Candara", Font.BOLD, 14));
		
		okModif.setBounds(345,430,50,30);
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
		aggPanel.add(ggFAdd);
		aggPanel.add(mmFAdd);
		aggPanel.add(aaFAdd);
		aggPanel.add(okAdd);
		
		
		modifPanel.add(modif);
		modifPanel.add(modif1);
		modifPanel.add(dataModif1);
		modifPanel.add(aulaModif1);
		modifPanel.add(inizioModif1);
		modifPanel.add(materiaModif);
		modifPanel.add(aulaModif2);
		modifPanel.add(inizioModif2);
		modifPanel.add(fineModif);
		modifPanel.add(dataModif2);
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
		modifPanel.add(ggFModif1);
		modifPanel.add(mmFModif1);
		modifPanel.add(aaFModif1);
		modifPanel.add(ggFModif2);
		modifPanel.add(mmFModif2);
		modifPanel.add(aaFModif2);
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
			
			/*ggFAdd*/
				for(int i=1; i<10; i++){
					ggFAdd.addItem("0"+i);
				}
				for(int i=10; i<32; i++){
					ggFAdd.addItem(i);
				}

			/*mmFAdd*/
				for(int i=1; i<10; i++){
					mmFAdd.addItem("0"+i);
				}
				for(int i=10; i<13; i++){
					mmFAdd.addItem(i);
				}
				
			/*aaFAdd*/
				
				Calendar c = Calendar.getInstance();
				 int year = c.get(Calendar.YEAR);
				 year--;
				for(int i=0; i<2; i++){
					year++;
					aaFAdd.addItem(year);
				}
			
			/*ggFModif1*/
				for(int i=1; i<10; i++){
					ggFModif1.addItem("0"+i);
				}
				for(int i=10; i<32; i++){
					ggFModif1.addItem(i);
				}

			/*mmFModif1*/
				for(int i=1; i<10; i++){
					mmFModif1.addItem("0"+i);
				}
				for(int i=10; i<13; i++){
					mmFModif1.addItem(i);
				}
				
			/*aaFModif1*/

				 year = c.get(Calendar.YEAR);
				 year--;
				 
				for(int i=0; i<2; i++){
					year++;
					aaFModif1.addItem(year);
				}
				
			/*ggFModif2*/
				for(int i=1; i<10; i++){
					ggFModif2.addItem("0"+i);
				}
				for(int i=10; i<32; i++){
					ggFModif2.addItem(i);
				}

			/*mmFModif2*/
				for(int i=1; i<10; i++){
					mmFModif2.addItem("0"+i);
				}
				for(int i=10; i<13; i++){
					mmFModif2.addItem(i);
				}
				
			/*aaFModif2*/
				 year = c.get(Calendar.YEAR);
				 year--;
				 
				for(int i=0; i<2; i++){
					year++;
					aaFModif2.addItem(year);
				}
				
				
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
		
		/**definizione di error1**/
		error1.setBounds(190, 430, 300, 30);
		error1.setLayout(null);
		error1.setBackground(null);
		JLabel i=new JLabel(); 

			i=new JLabel( new ImageIcon("image/error.png"));
			i.setBounds(0,5,20,20);
			error1.add(i);

		JLabel te= new JLabel("Esame non esistente");
		te.setFont(new Font("Candara", Font.BOLD, 14));
		te.setForeground(new Color(240, 98, 146));
		te.setBounds(22,10,200,20);
		error1.add(te);
		modifPanel.add(error1);
		error1.setVisible(false);

		/**definizione di errorAtt**/
		errorAtt.setBounds(190, 430, 300, 30);
		errorAtt.setLayout(null);
		errorAtt.setBackground(null);
		JLabel i1=new JLabel(); 

			i1=new JLabel( new ImageIcon("image/error.png"));
			i1.setBounds(0,5,20,20);
			errorAtt.add(i1);

		JLabel te1= new JLabel("Esame già esistente");
		te1.setFont(new Font("Candara", Font.BOLD, 14));
		te1.setForeground(new Color(240, 98, 146));
		te1.setBounds(22,10,200,20);
		errorAtt.add(te1);
		modifPanel.add(errorAtt);
		errorAtt.setVisible(false);

		/**definizione di success1**/
		success1.setBounds(110, 430, 230, 30);
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
		errorVuoto2.setBounds(83, 430, 370, 30);
		errorVuoto2.setLayout(null);
		errorVuoto2.setBackground(null);
		JLabel i4=new JLabel(); 

			i4=new JLabel( new ImageIcon("image/warning.png"));
			i4.setBounds(0,5,20,20);
			errorVuoto2.add(i4);

		JLabel t4= new JLabel("Nessun elemento presente nel sistema");
		t4.setFont(new Font("Candara", Font.BOLD, 14));
		t4.setForeground(new Color(216, 150, 54));
		t4.setBounds(22,11,290,20);
		errorVuoto2.add(t4);
		modifPanel.add(errorVuoto2);
		errorVuoto2.setVisible(false);
		
		
		/** aggiungimento esame**/
		
		okAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addEsame(codiceCorente, anno);
			}
			
			
		});
		
		/**Gestione modifica materia**/
		
		okModif.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editEsame(codiceCorente, anno);
			}
			
			
		});
		
		/**Gestione cancellazione materia**/
		
		okCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelEsame(codiceCorente, anno);
			}
			
			
		});
		
		/**Gestione della lista delle esami esistenti**/
		
		esami.setBackground(null);
		
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

	
	void addEsame(String c, int a){
		
		if( materiaFAdd.getItemCount() == 0){
			
			success.setVisible(false);
			errorVuoto1.setVisible(true);
			materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));

		}
		else{
			
			if(aulaFAdd.getItemCount() == 0){
				
				materiaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
				success.setVisible(false);
				errorVuoto1.setVisible(true);
			}
			else{

					int x=-1;
					
					ResultSet rs;
					try {
						/* Eseguo una query specificando il codice */
						rs = Database.Query("SELECT e.* FROM esame e WHERE e.ora_inizio = '"+iniziohFAdd.getSelectedItem()+":"+iniziomFAdd.getSelectedItem()+"' and aula = '"+aulaFAdd.getSelectedItem()+"' and data = '"+aaFAdd.getSelectedItem()+"-"+mmFAdd.getSelectedItem()+"-"+ggFAdd.getSelectedItem()+"'", Database.getConn(), true);
						
						if(!rs.next()){//se nessun risultato
							
							try {  
								Database.Query("insert into esame(data, ora_inizio, ora_fine, aula, materia) values('"+aaFAdd.getSelectedItem()+"-"+mmFAdd.getSelectedItem()+"-"+ggFAdd.getSelectedItem()+"', '"+iniziohFAdd.getSelectedItem()+":"+iniziomFAdd.getSelectedItem()+"', '"+finehFAdd.getSelectedItem()+":"+finemFAdd.getSelectedItem()+"', '"+aulaFAdd.getSelectedItem()+"', '"+materiaFAdd.getSelectedItem()+"');", Database.getConn(), true);
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
						aulaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						ggFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						mmFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						aaFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						iniziohFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						iniziomFAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
						success.setVisible(false);
						errorVuoto1.setVisible(false);
						error.setVisible(true);
					}
					if(x == 1){
						aulaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						ggFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						mmFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						aaFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						iniziohFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						iniziomFAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						
						error.setVisible(false);
						errorVuoto1.setVisible(false);
						success.setVisible(true);
						update(c, a);
						
					}
					
				}
			}
	}
		
	
	@SuppressWarnings("unused")
	void editEsame(String c, int a){
		
		if(aulaFModif1.getItemCount() == 0){
			
			aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
			success1.setVisible(false);
			errorVuoto2.setVisible(true);
		}
			else{
				if(materiaFModif.getItemCount() == 0){
					materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
					aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
					success1.setVisible(false);
					errorVuoto2.setVisible(true);
				}
				else{
					if(materiaFModif.getItemCount() == 0){
						aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216, 150, 54)));
						aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						materiaFModif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
						success1.setVisible(false);
						errorVuoto2.setVisible(true);
					}
					else{
						
						int x=-1;
						
						ResultSet rs;
						ResultSet rs1;
						try {
							/* Eseguo una query */
							rs = Database.Query("SELECT e.* FROM esame e WHERE e.ora_inizio = '"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"' and aula = '"+aulaFModif1.getSelectedItem()+"' and data = '"+aaFModif1.getSelectedItem()+"-"+mmFModif1.getSelectedItem()+"-"+ggFModif1.getSelectedItem()+"'", Database.getConn(), true);
							
							if(!rs.next()){//se nessun risultato	
								x = 0;					
							}
							else{ //se risultato
								
								String gga= String.valueOf(ggFModif1.getSelectedItem());
								String mma= String.valueOf(mmFModif1.getSelectedItem());
								String aaa= String.valueOf(aaFModif1.getSelectedItem());
								String aulaa= String.valueOf(aulaFModif1.getSelectedItem());
								String inizioha= String.valueOf(iniziohFModif1.getSelectedItem());
								String inizioma= String.valueOf(iniziomFModif1.getSelectedItem());
								
								String ggn= String.valueOf(ggFModif2.getSelectedItem());
								String mmn= String.valueOf(mmFModif2.getSelectedItem());
								String aan= String.valueOf(aaFModif2.getSelectedItem());
								String aulan= String.valueOf(aulaFModif2.getSelectedItem());
								String iniziohn= String.valueOf(iniziohFModif2.getSelectedItem());
								String iniziomn= String.valueOf(iniziomFModif2.getSelectedItem());						
								
								
								if( ( (gga.compareTo(ggn))!= 0 ) || ( (mma.compareTo(mmn))!= 0 ) || ( (aaa.compareTo(aan))!= 0 ) || ( (inizioha.compareTo(iniziohn))!= 0 ) || ( (inizioma.compareTo(iniziomn))!= 0 ) || ( (aulaa.compareTo(aulan))!= 0 ) ){
								
									
									try{
										rs = Database.Query("SELECT e.* FROM esame e WHERE e.ora_inizio = '"+iniziohFModif2.getSelectedItem()+":"+iniziomFModif2.getSelectedItem()+"' and aula = '"+aulaFModif2.getSelectedItem()+"' and data = '"+aaFModif2.getSelectedItem()+"-"+mmFModif2.getSelectedItem()+"-"+ggFModif2.getSelectedItem()+"'", Database.getConn(), true);
										
										if(!rs.next()){//se nessun risultato
											
											try { 
												
												Database.Query("update esame "
														+ "set ora_fine='"+finehFModif.getSelectedItem()+":"+finemFModif.getSelectedItem()+"', materia='"+materiaFModif.getSelectedItem()+"', data='"+aaFModif2.getSelectedItem()+"-"+mmFModif2.getSelectedItem()+"-"+ggFModif2.getSelectedItem()+"', ora_inizio='"+iniziohFModif2.getSelectedItem()+":"+iniziomFModif2.getSelectedItem()+"', aula='"+aulaFModif2.getSelectedItem()+"'"
														+ "WHERE data='"+aaFModif1.getSelectedItem()+"-"+mmFModif1.getSelectedItem()+"-"+ggFModif1.getSelectedItem()+"'"
														+ "and aula='"+aulaFModif1.getSelectedItem()+"'"
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
										
										Database.Query("update esame "
												+ "set ora_fine='"+finehFModif.getSelectedItem()+":"+finemFModif.getSelectedItem()+"', materia='"+materiaFModif.getSelectedItem()+"'"
												+ "WHERE data='"+aaFModif1.getSelectedItem()+"-"+mmFModif1.getSelectedItem()+"-"+ggFModif1.getSelectedItem()+"'"
												+ "and aula='"+aulaFModif1.getSelectedItem()+"'"
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
							ggFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							mmFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							aaFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							success1.setVisible(false);
							errorVuoto1.setVisible(false);
							error1.setVisible(true);
							errorAtt.setVisible(false);
						}
						if(x == 1){
							
						
							aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							ggFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							mmFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							aaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							success1.setVisible(true);
							errorVuoto1.setVisible(false);
							errorAtt.setVisible(false);
							update(c, a);
							

						}
						if(x == 2){
							
							aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							ggFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							mmFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							aaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziohFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							iniziomFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
							
							
							aulaFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							ggFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							mmFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							aaFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziohFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							iniziomFModif2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
							success1.setVisible(false);
							errorVuoto1.setVisible(false);
							errorAtt.setVisible(true);
							error1.setVisible(false);
							
						}
					}

					}
				}
		

 }


	void update(String c, int a){
		
		esami.removeAll();

		ResultSet rset;
		int count=0;
		int num=0;

		try{
				//mando una querry per selezionare tutti gli esami con corso e anno specificati
				rset = Database.Query("select e.*, m.nome from esame e, materia m where m.corso='"+c+"' and m.anno_corso="+a+" and m.codice=e.materia order by e.data", Database.getConn(), true);
				
				
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
							JLabel aula = new JLabel("Aula "+rset.getString("aula"));
							
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
	
	void cancelEsame(String c, int a){
		
			
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
				rs = Database.Query("SELECT e.* FROM esame e WHERE e.ora_inizio = '"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"' and aula = '"+aulaFModif1.getSelectedItem()+"' and data = '"+aaFModif1.getSelectedItem()+"-"+mmFModif1.getSelectedItem()+"-"+ggFModif1.getSelectedItem()+"'", Database.getConn(), true);
				
				if(rs.next()){//se risultato
					
					try {
						Database.Query("delete from esame where esame.data='"+aaFModif1.getSelectedItem()+"-"+mmFModif1.getSelectedItem()+"-"+ggFModif1.getSelectedItem()+"' and esame.aula='"+aulaFModif1.getSelectedItem()+"' and esame.ora_inizio='"+iniziohFModif1.getSelectedItem()+":"+iniziomFModif1.getSelectedItem()+"'", Database.getConn(), true);
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
				ggFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				mmFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				aaFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				iniziohFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				iniziomFModif1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 98, 146)));
				
				aulaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				ggFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				mmFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aaFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziohFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				iniziomFModif2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				
				success1.setVisible(false);
				errorVuoto1.setVisible(false);
				error1.setVisible(true);
			}
			if(x == 1){
				aulaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				ggFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				mmFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
				aaFModif1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0, 64)));
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
