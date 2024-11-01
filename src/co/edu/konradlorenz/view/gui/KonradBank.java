package co.edu.konradlorenz.view.gui;

import javax.swing.*;
import javax.swing.border.Border;

import co.edu.konradlorenz.controller.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("serial")
public class KonradBank extends JFrame {
	
	Controlador controlador = new Controlador();
	
	//Ventanas
	JFrame konradBank = new JFrame();
	
	//Paneles
	JPanel invisiblePanel = new JPanel(); //Este JPanel permite que el autofocus no sea el primer campo de texto.
	JPanel bodyLogin;
	JPanel bodyMenuPrincipal;
	JPanel bodyDepositar;
	JPanel bodyRetirar;
	JPanel bodyRecibo;
	
	//Decorativos
	JPanel head = head();
	JPanel line = line();
	
	//Campos de texto
	JTextField txtField;
	JPasswordField pwdField;
	
	//Botones
	JButton btnIngresar;
	JButton btnMenuRetirar;
	JButton btnMenuDepositar;
	JButton btnRetirar;
	JButton btnDepositar;
	JButton btnCancelar;
	
	//Colores
	Color fondoPanel = Color.WHITE;//Fondo de todos los JPanel
	Color fondoFrame = Color.WHITE;//Fondo del JFrame
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Constructor del JFrame
	public KonradBank(){

		controlador.datosDePrueba();
	
		konradBank.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		konradBank.setTitle("Konrad Bank");
		konradBank.setSize(600,600);
		konradBank.setLocationRelativeTo(null);//Centra la ventana
		konradBank.setLayout(null);//Desactivar layout automático para usar setBounds()
		konradBank.setResizable(false);//No permite modificar el tamaño de la ventana
		konradBank.setBackground(Color.BLUE);//Color de la barra de la ventana
		konradBank.getContentPane().setBackground(fondoFrame);
		
		
		invisiblePanel.setFocusable(true);
		invisiblePanel.setVisible(true);
		
		bodyLogin = bodyLogin();
		
		konradBank.add(invisiblePanel);//Autofocus.
		konradBank.add(head);
		konradBank.add(line);
		konradBank.add(bodyLogin);

		konradBank.setVisible(true);//"Cargar página" guiño guiño.
		
	}
	//KonradBank
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // PANELES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Método para crear bodyLogin
	public JPanel bodyLogin() {
		// - BODY - //
		bodyLogin = new JPanel();
		bodyLogin.setBounds(0, 150, 600, 450);//x,y,ancho,altura
		bodyLogin.setBackground(fondoPanel);
		bodyLogin.setLayout(null);//Desactivar layout automático para usar setBounds()   
		
		//Mensaje
		JLabel msn = new JLabel("Bienvenido/a al cajero automático");
		msn.setFont(new Font("Arial", Font.PLAIN, 20));
		msn.setForeground(Color.BLACK);
		msn.setBounds(150, 25, 450, 50);//x,y,ancho,altura
		
		bodyLogin.add(msn);
		
		
		
		bodyLogin.add(txtField(100, 115, 400, 50, "Ingrese número de tarjeta"));
		bodyLogin.add(pwdField(100, 215, 400, 50, "Ingrese su PIN"));
		bodyLogin.add(btnIngresar(100, 315, 400, 50, "Ingresar"));
		
		return bodyLogin;
	}
	//*/bodyLogin
	
	// Método para crear bodyMenuPrincipal
	public JPanel bodyMenuPrincipal() {
		
		bodyMenuPrincipal = new JPanel();
	    bodyMenuPrincipal.setBounds(0, 150, 600, 600);//x,y,ancho,altura
	    bodyMenuPrincipal.setBackground(Color.white); 

		    JLabel lblBienvenido = new JLabel("Bienvenido/a. ");
		    lblBienvenido.setFont(new Font("Arial", Font.BOLD, 24));
		    lblBienvenido.setBounds(220, 20, 600, 30);
		    bodyMenuPrincipal.add(lblBienvenido);
		    
		    JLabel lblBienvenido2 = new JLabel("el banco #1 de los estudiantes de la konrad");
		    lblBienvenido2.setFont(new Font("Arial", Font.ITALIC, 24));
		    lblBienvenido2.setBounds(55, 55, 600, 30);
		    bodyMenuPrincipal.add(lblBienvenido2);
		    
		    
		    JLabel lblPregunta = new JLabel("¿Qué desea hacer?");
		    lblPregunta.setFont(new Font("Arial", Font.PLAIN, 18));
		    lblPregunta.setBounds(220, 100, 200, 30);
		    bodyMenuPrincipal.add(lblPregunta);

		    bodyMenuPrincipal.setLayout(null);
	    btnMenuRetirar = btnRetirar(200, 220, 200, 50, "Retirar");
	    bodyMenuPrincipal.add(btnMenuRetirar);
	    
	    btnMenuDepositar = btnDepositar(200, 150, 200, 50, "Depositar");
	    bodyMenuPrincipal.add(btnMenuDepositar);
	    
	    btnCancelar = btnCancelar(200, 290, 200, 50, "Cancelar");
	    bodyMenuPrincipal.add(btnCancelar);
	    
	    
	    


 // Método para crear bodyLogin


	    return bodyMenuPrincipal;
	}
	//*///bodyMenuPrincipal
	
	// Método para crear bodyDepositar
	public JPanel bodyDepositar() {
		
	    // - BODY - //
		JPanel bodyDepositar = new JPanel();
		
	    bodyDepositar.setBounds(0, 150, 600, 450);
	    bodyDepositar.setBackground(fondoPanel);
	    bodyDepositar.setLayout(null);

	    JLabel msn = new JLabel("¿Qué cantidad desea depositar?");
	    msn.setFont(new Font("Arial", Font.PLAIN, 20));
	    msn.setForeground(Color.BLACK);
	    msn.setBounds(170, 75, 450, 50);
	    bodyDepositar.add(msn);

	    txtField = txtField(100, 150, 400, 50, "Ingrese cantidad a depositar");
	    bodyDepositar.add(txtField);
	    
	    btnCancelar = btnCancelar(100, 295, 400, 50, "Cancelar");
	    bodyDepositar.add(btnCancelar);
	    
	    btnDepositar = btnDepositar(100, 225, 400, 50, "Depositar");
	    bodyDepositar.add(btnDepositar);

	    return bodyDepositar;
	}
	//*///bodyDepositar
	
	//Método para crear bodyRetirar
	public JPanel bodyRetirar() {
		//-BODY-//
		JPanel bodyRetirar = new JPanel();
		bodyRetirar.setBounds(0, 150, 600, 450);
		bodyRetirar.setBackground(fondoPanel);
		bodyRetirar.setLayout(null);
		
				//Mensaje
				JLabel msn = new JLabel("¿Qué cantidad desea retirar?");
				msn.setFont(new Font("Arial", Font.PLAIN, 20));
				msn.setForeground(Color.BLACK);
				msn.setBounds(170, 75, 450, 50);
				bodyRetirar.add(msn);
				
				bodyRetirar.add(txtField(100,150,400,50,"Ingrese cantidad a retirar"));
				bodyRetirar.add(btnRetirar(100, 225, 400, 50, "Retirar"));
				bodyRetirar.add(btnCancelar(100, 295, 400, 50, "Cancelar"));
				
		return bodyRetirar;
	}
	//*///bodyRetirar
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // DECORATIVOS -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Método para crear head
	public JPanel head() {
    	// - HEAD - //
        JPanel head = new JPanel();
        head.setBounds(0, 0, 600, 100);//x,y,ancho,altura
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
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- CAMPOS DE TEXTO - // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Método para crear txtField
	public JTextField txtField(int cordX, int cordY, int ancho, int alto, String mensaje) {
        
		txtField = new JTextField(mensaje);
        txtField.setFont(new Font("Arial", Font.PLAIN, 20));
        txtField.setForeground(Color.GRAY);
        txtField.setBounds(cordX, cordY, ancho, alto);//x,y,ancho,altura
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2); //Borde de línea azul de 2 píxeles
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
		
        pwdField = new JPasswordField(mensaje);
        pwdField.setFont(new Font("Arial", Font.ITALIC, 20));
        pwdField.setForeground(Color.GRAY);
        pwdField.setBounds(cordX, cordY, ancho, alto);//x,y,ancho,altura
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
                	pwdField.setEchoChar('•');//Mostrar puntos
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
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // BOTONES  // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Método para crear btnIngresar
	public JButton btnIngresar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnIngresar = new JButton(mensaje);
		btnIngresar.setBounds(cordX, cordY, ancho, alto);
		btnIngresar.setBackground(Color.BLUE);
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Arial", Font.BOLD, 16));
		btnIngresar.setOpaque(true);//No transparente
        //button.setBorderPainted(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2); // Borde de línea azul de 2 píxeles
        btnIngresar.setBorder(border);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
                String numeroTarjeta = txtField.getText();
                String pin = new String(pwdField.getPassword());
                
				boolean validacion = controlador.validarCredenciales(numeroTarjeta, pin);
				
				if(validacion) {
					konradBank.remove(bodyLogin);
					konradBank.add(bodyMenuPrincipal());
					//"Recargar"
					konradBank.revalidate();
					konradBank.repaint();
				} else {
					Border border = BorderFactory.createLineBorder(Color.RED, 2);
					txtField.setBorder(border);
					pwdField.setBorder(border);
				}
            }
        });
        return btnIngresar;
	}
	//*///btnIngresar
	
	//Método para crear btnMenuRetirar
	public JButton btnMenuRetirar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnMenuRetirar = new JButton(mensaje);
		btnMenuRetirar.setBounds(cordX, cordY, ancho, alto);
		btnMenuRetirar.setBackground(Color.BLUE);
		btnMenuRetirar.setForeground(Color.WHITE);
		btnMenuRetirar.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuRetirar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		btnMenuRetirar.setBorder(border);
		
		bodyRetirar.revalidate();
		bodyRetirar.repaint();
		btnMenuRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
            	konradBank.remove(bodyMenuPrincipal);
	            konradBank.add(bodyRetirar());
            }
            });
		return btnMenuRetirar;
	}
	//*///btnMenuRetirar
	
	//Método para crear btnMenuDepositar
	//*///btnMenuRetirar
	
	//Método para crear btnMenuDepositar
	public JButton btnMenuDepositar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnMenuDepositar = new JButton(mensaje);
		btnMenuDepositar.setBounds(cordX, cordY, ancho, alto);
		btnMenuDepositar.setBackground(Color.BLUE);
		btnMenuDepositar.setForeground(Color.WHITE);
		btnMenuDepositar.setFont(new Font("Arial", Font.BOLD, 16));
		btnMenuDepositar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		btnMenuDepositar.setBorder(border);
		
		btnMenuDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
            	konradBank.remove(bodyMenuPrincipal);
	            konradBank.add(bodyDepositar());
            }
            });
		return btnMenuDepositar;
	}
	//*///btnMenuDepositar
	
	//Método para crear btnRetirar
	//*///btnMenuDepositar
	
	//Método para crear btnRetirar
	public JButton btnRetirar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnRetirar = new JButton(mensaje);
		btnRetirar.setBounds(cordX, cordY, ancho, alto);
		btnRetirar.setBackground(Color.BLUE);
		btnRetirar.setForeground(Color.WHITE);
		btnRetirar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRetirar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		btnRetirar.setBorder(border);
		
		btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
                konradBank.remove(bodyRetirar);
                //konradBank.add(bodyRecibo);//TODO: Descomentar cuando esté listo el método.
            }
            });
		return btnRetirar;
	}
	//*///btnRetirar
	
	//Método para crear btnDepositar
	//*///btnRetirar

	//Método para crear btnDepositar
	public JButton btnDepositar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnDepositar = new JButton(mensaje);
		btnDepositar.setBounds(cordX, cordY, ancho, alto);
	    btnDepositar.setBackground(Color.BLUE);
	    btnDepositar.setForeground(Color.WHITE);
	    btnDepositar.setFont(new Font("Arial", Font.BOLD, 16));
	    btnDepositar.setOpaque(true);
	    Border border = BorderFactory.createLineBorder(Color.BLUE, 2); // Borde de línea azul de 2 píxeles
	    btnDepositar.setBorder(border);

	    btnDepositar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Acción para el botón de depósito
	            String amount = txtField.getText();
	            
	            // Validación básica del monto ingresado (puedes hacer más validaciones según necesites)
	            if (amount.isEmpty()) {
	                JOptionPane.showMessageDialog(bodyDepositar, "Ingrese una cantidad válida para depositar", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	               //TODO controlador.depositar(amount);
	                
	                // Cambiar al panel de recibo después del depósito
	                konradBank.remove(bodyDepositar);
	                //konradBank.add(bodyRecibo); //TODO: Descomentar cuando esté listo el método.
	                //konradBank.revalidate();
	                //konradBank.repaint();
	            }
	        }
	    });
		return btnDepositar;
	}
	//*///btnDepositar
	
	//Método para crear btnCancelar
	//*///btnDepositar

	//Método para crear btnCancelar
	public JButton btnCancelar(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnCancelar = new JButton(mensaje);
		btnCancelar.setBounds(cordX, cordY, ancho, alto);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		btnCancelar.setBorder(border);
		
		btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
            	konradBank.remove(bodyDepositar);
            	konradBank.remove(bodyRetirar);
	            konradBank.add(bodyMenuPrincipal());
                
            }
            });
		return btnCancelar;
	}
	//*///btnCancelar
	
}
//class