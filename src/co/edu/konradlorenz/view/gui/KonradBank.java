package co.edu.konradlorenz.view.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class KonradBank extends JFrame {
	
	//Constructor
	public KonradBank(){
		JFrame kb = new JFrame();
		
		kb.setVisible(true);
		kb.setBounds(0,0,1280,720);
		kb.setLocationRelativeTo(null);//Centra la ventana
		kb.setTitle("Konrad Bank");
		kb.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana

	}
	//KonradBank
}
//class