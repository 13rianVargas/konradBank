package co.edu.konradlorenz.view.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("serial")
public class KonradBank extends JFrame {
	
	JFrame konradBank = new JFrame();
	
	Color fondoPanel = Color.LIGHT_GRAY;//Fondo de todos los JPanel
	Color fondoFrame = Color.GRAY;//Fondo del JFrame
	
	//Constructor
	public KonradBank(){
		
		konradBank.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		konradBank.setTitle("Konrad Bank");
		konradBank.setSize(600,600);
		konradBank.setLocationRelativeTo(null);//Centra la ventana
		konradBank.setLayout(null);//Desactivar layout automático para usar setBounds()
		konradBank.setResizable(false);//No permite modificar el tamaño de la ventana
		konradBank.setBackground(Color.BLUE);//Color de la barra de la ventana
		konradBank.getContentPane().setBackground(fondoFrame);
		
		JPanel bodyLogin = bodyLogin();
		JPanel bodyMenuPrincipal;
		JPanel bodyRetirar;
		JPanel bodyDepositar;
		JPanel bodyRecibo;

		
		konradBank.add(head());
		konradBank.add(line());
		konradBank.add(bodyLogin);
		
		//konradBank.remove(head);

		konradBank.setVisible(true);//"Recargar página" guiño guiño.
		
	}
	//KonradBank
	
	//Método para crear head
	public JPanel head() {
    	// - HEAD - //
        JPanel head = new JPanel();
        head.setBounds(0, 0, 600, 100); //x,y,ancho,altura
        head.setBackground(fondoPanel);
        head.setLayout(null);//Desactivar layout automático para usar setBounds()	   
	        
	        //Title
	        JLabel title = new JLabel("KONRAD BANK");
	        title.setFont(new Font("Arial", Font.BOLD, 40));//fuente, negrilla, tamaño
	        title.setForeground(Color.BLACK);//color letra
	        title.setBounds(150, 0, 450, 100);//x,y,ancho,altura
	        //title.setOpaque(false);

	        head.add(title);
	        
	        
    	return head;
    }
    //*/head
	
	//Método para crear line
	public JPanel line() {
    	// - LINE - //
        JPanel line = new JPanel();
        line.setBounds(0, 100, 600, 50);
        line.setBackground(Color.BLUE);
        line.setLayout(null);//Desactivar layout automático para usar setBounds()   
	        
    	return line;
    }
    //*/line
	
	//Método para crear bodyLogin
	public JPanel bodyLogin() {
    	// - BODY - //
        JPanel bodyLogin = new JPanel();
        bodyLogin.setBounds(0, 150, 600, 450);
        bodyLogin.setBackground(fondoPanel);
        bodyLogin.setLayout(null);//Desactivar layout automático para usar setBounds()   
	    
	        //Mensaje
	        JLabel msn = new JLabel("Bienvenido/a al cajero automático");
	        msn.setFont(new Font("Arial", Font.PLAIN, 20));
	        msn.setForeground(Color.BLACK);
	        msn.setBounds(150, 25, 450, 50);
	
	        bodyLogin.add(msn);
        


        bodyLogin.add(txtField(100, 115, 400, 50, "Ingrese número de tarjeta"));
        bodyLogin.add(pwdField(100, 215, 400, 50, "Ingrese su PIN"));
        bodyLogin.add(button(100, 315, 400, 50, "Ingresar"));
        
    	return bodyLogin;
    }
    //*/bodyLogin
	
	//Método para crear txtField
	public JTextField txtField(int cordX, int cordY, int ancho, int alto, String mensaje) {
        //txtNumeroTarjeta
        JTextField txtField = new JTextField(mensaje);
        txtField.setFont(new Font("Arial", Font.PLAIN, 20));
        txtField.setForeground(Color.GRAY);
        txtField.setBounds(cordX, cordY, ancho, alto);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2); // Borde de línea azul de 2 píxeles
        txtField.setBorder(border);

        //Añadir FocusListener para gestionar el placeholder
        txtField.addFocusListener(new FocusListener() {
        	
            @Override
            public void focusGained(FocusEvent e) {
                if (txtField.getText().equals(mensaje)) {
                	txtField.setText("");
                	txtField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
                if (txtField.getText().isEmpty()) {
                	txtField.setForeground(Color.GRAY);
                	txtField.setText(mensaje);
                }
            }
        });
        return txtField;
	}
	//*/txtField
	
	//Método para crear pwdField
	public JPasswordField pwdField(int cordX, int cordY, int ancho, int alto, String mensaje) {
        //txtNumeroTarjeta
        JPasswordField pwdField = new JPasswordField(mensaje);
        pwdField.setFont(new Font("Arial", Font.ITALIC, 20));
        pwdField.setForeground(Color.GRAY);
        pwdField.setBounds(cordX, cordY, ancho, alto);
        pwdField.setText(mensaje);
        pwdField.setEchoChar((char) 0);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        pwdField.setBorder(border);
        

        pwdField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(pwdField.getPassword()).equals(mensaje)) {
                	pwdField.setText("");
                	pwdField.setForeground(Color.BLACK);
                	pwdField.setEchoChar('•');//Muestra puntos
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                //Si el campo de texto está vacío al perder el foco, restaurar el placeholder
                if (pwdField.getPassword().length == 0) {
                    pwdField.setForeground(Color.GRAY);
                    pwdField.setText(mensaje);//Restaurar el texto placeholder
                    pwdField.setEchoChar((char) 0);//No mostrar puntos
                }
            }
        });
        return pwdField;
	}
	//*/pwdField
	
	//Método para crear button
	public JButton button(int cordX, int cordY, int ancho, int alto, String mensaje) {
        JButton button = new JButton(mensaje);
        button.setBounds(cordX, cordY, ancho, alto);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setOpaque(true);//No transparente
        //button.setBorderPainted(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2); // Borde de línea azul de 2 píxeles
        button.setBorder(border);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                System.out.println("Intentando iniciar sesión...");
                
                //TODO: Verificar credenciales
            }
        });
        return button;
	}
	//*/button
}
//class