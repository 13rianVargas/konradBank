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
	
	JFrame konradBank;
	JPanel invisiblePanel;
	JPanel bodyLogin;
	JPanel bodyMenuPrincipal;
	JPanel bodyRetirar;
	JPanel bodyDepositar;
	JPanel bodyRecibo;
	JTextField txtField;
	JPasswordField pwdField;
	JButton btnIngresar;
	JButton btnCancelar;
	JButton btnRetirar;
	
	Color fondoPanel = Color.LIGHT_GRAY;//Fondo de todos los JPanel
	Color fondoFrame = Color.GRAY;//Fondo del JFrame
	
	//Constructor del JFrame
	public KonradBank(){
		
		konradBank = new JFrame();
		konradBank.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		konradBank.setTitle("Konrad Bank");
		konradBank.setSize(600,600);
		konradBank.setLocationRelativeTo(null);//Centra la ventana
		konradBank.setLayout(null);//Desactivar layout automático para usar setBounds()
		konradBank.setResizable(false);//No permite modificar el tamaño de la ventana
		konradBank.setBackground(Color.BLUE);//Color de la barra de la ventana
		konradBank.getContentPane().setBackground(fondoFrame);
		
		invisiblePanel = new JPanel();
		invisiblePanel.setFocusable(true);
		invisiblePanel.setVisible(true);
		
		Controlador objControlador = new Controlador();
		bodyLogin = bodyLogin();
		bodyRetirar = bodyRetirar();
		// <- Quita solo el * entre las barras para descomentar el bloque
		bodyMenuPrincipal = bodyMenuPrincipal();
		
		bodyDepositar = bodyDepositar();
		/*bodyRecibo = bodyRecibo();
		//*/
		
		konradBank.add(invisiblePanel);//Este JPanel permite que el autofocus no sea el primer campo de texto.
		konradBank.add(head());
		konradBank.add(line());
		konradBank.add(bodyLogin);

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
        bodyLogin.add(btnIngresar(100, 315, 400, 50, "Ingresar"));
        
    	return bodyLogin;
    }
    //*/bodyLogin
	
	//Método para crear txtField
	public JTextField txtField(int cordX, int cordY, int ancho, int alto, String mensaje) {
        //txtNumeroTarjeta
		JTextField 	txtField = new JTextField(mensaje);
        txtField.setFont(new Font("Arial", Font.PLAIN, 20));
        txtField.setForeground(Color.GRAY);
        txtField.setBounds(cordX, cordY, ancho, alto);
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
        //txtNumeroTarjeta
        pwdField = new JPasswordField(mensaje);
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
					konradBank.add(bodyMenuPrincipal);
					//konradBank.setVisible(true);//Por si toca "recargar"
				} else {
					Border border = BorderFactory.createLineBorder(Color.RED, 2);
					txtField.setBorder(border);
					pwdField.setBorder(border);
				}
            }
        });
        return btnIngresar;
	}
	//*/btnIngresar
	
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
	//*/bodyRetirar
	
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
		
		btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
                konradBank.remove(bodyRetirar);
                konradBank.add(bodyMenuPrincipal);
            }
            });
		return btnCancelar;
	}
	//*/btnCancelar
	
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
                konradBank.add(bodyRecibo);
            }
            });
		return btnRetirar;
	}
	//*/btnRetirar
	
	
	// Método para crear bodyDepositar
	public JPanel bodyDepositar() {
	    // - BODY - //
	    JPanel bodyDepositar = new JPanel();
	    bodyDepositar.setBounds(0, 150, 600, 450);
	    bodyDepositar.setBackground(fondoPanel);
	    bodyDepositar.setLayout(null);

	    // Mensaje
	    JLabel msn = new JLabel("¿Qué cantidad desea depositar?");
	    msn.setFont(new Font("Arial", Font.PLAIN, 20));
	    msn.setForeground(Color.BLACK);
	    msn.setBounds(170, 75, 450, 50);
	    bodyDepositar.add(msn);

	    // Campo de texto para ingresar cantidad a depositar
	    JTextField depositAmountField = txtField(100, 150, 400, 50, "Ingrese cantidad a depositar");
	    bodyDepositar.add(depositAmountField);

	    // Botón para confirmar depósito
	    JButton btnDepositar = new JButton("Depositar");
	    btnDepositar.setBounds(100, 225, 400, 50);
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
	            String amount = depositAmountField.getText();
	            
	            // Validación básica del monto ingresado (puedes hacer más validaciones según necesites)
	            if (amount.isEmpty()) {
	                JOptionPane.showMessageDialog(bodyDepositar, "Ingrese una cantidad válida para depositar", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	               //TODO controlador.depositar(amount);
	                
	                // Cambiar al panel de recibo después del depósito
	                konradBank.remove(bodyDepositar);
	                konradBank.add(bodyRecibo);
	                konradBank.revalidate();
	                konradBank.repaint();
	            }
	        }
	    });
	    bodyDepositar.add(btnDepositar);

	    // Botón para cancelar
	    JButton btnCancelarDeposito = new JButton("Cancelar");
	    btnCancelarDeposito.setBounds(100, 295, 400, 50);
	    btnCancelarDeposito.setBackground(Color.RED);
	    btnCancelarDeposito.setForeground(Color.WHITE);
	    btnCancelarDeposito.setFont(new Font("Arial", Font.BOLD, 16));
	    btnCancelarDeposito.setOpaque(true);
	    Border cancelBorder = BorderFactory.createLineBorder(Color.RED, 2);
	    btnCancelarDeposito.setBorder(cancelBorder);

	    btnCancelarDeposito.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Acción para cancelar depósito y regresar al menú principal
	            konradBank.remove(bodyDepositar);
	            konradBank.add(bodyMenuPrincipal);
	            konradBank.revalidate();
	            konradBank.repaint();
	        }
	    });
	    bodyDepositar.add(btnCancelarDeposito);

	    return bodyDepositar;
	}//*/btnCancelar
	
	
	
	
	// bodyMenuPrincipal
	public JPanel bodyMenuPrincipal() {
	    JPanel bodyMenuPrincipal = new JPanel();
	    

	    // Establecer el color de fondo
	    bodyMenuPrincipal.setBackground(Color.CYAN); 

	    // Etiqueta de bienvenida
	    JLabel lblBienvenido = new JLabel("Bienvenido/a " + "A su banco de confianza");
	    lblBienvenido.setFont(new Font("Arial", Font.BOLD, 24));
	    lblBienvenido.setBounds(100, 50, 400, 30);
	    bodyMenuPrincipal.add(lblBienvenido);

	    // Etiqueta de pregunta
	    JLabel lblPregunta = new JLabel("¿Qué desea hacer?");
	    lblPregunta.setFont(new Font("Arial", Font.PLAIN, 18));
	    lblPregunta.setBounds(150, 100, 200, 30);
	    bodyMenuPrincipal.add(lblPregunta);

	    // Botón de retirar
	    JButton btnRetirar = new JButton("Retirar");
	    btnRetirar.setBounds(150, 150, 200, 50);
	    btnRetirar.setBackground(Color.BLUE);
	    btnRetirar.setForeground(Color.WHITE);
	    btnRetirar.setFont(new Font("Arial", Font.BOLD, 18));
	    btnRetirar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Lógica para llevar a bodyRetirar
	            konradBank.remove(bodyMenuPrincipal);
	            konradBank.add(bodyRetirar()); // Método para crear bodyRetirar
	            konradBank.revalidate();
	            konradBank.repaint();
	        }
	    });
	    bodyMenuPrincipal.add(btnRetirar);

	    // Botón de depositar
	    JButton btnDepositar = new JButton("Depositar");
	    btnDepositar.setBounds(150, 220, 200, 50);
	    btnDepositar.setBackground(Color.BLUE);
	    btnDepositar.setForeground(Color.WHITE);
	    btnDepositar.setFont(new Font("Arial", Font.BOLD, 18));
	    btnDepositar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Lógica para llevar a bodyDepositar
	            konradBank.remove(bodyMenuPrincipal);
	            konradBank.add(bodyDepositar()); // Método para crear bodyDepositar
	            konradBank.revalidate();
	            konradBank.repaint();
	        }
	    });
	    bodyMenuPrincipal.add(btnDepositar);

	    // Botón de cancelar
	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.setBounds(150, 290, 200, 50);
	    btnCancelar.setBackground(Color.RED);
	    btnCancelar.setForeground(Color.WHITE);
	    btnCancelar.setFont(new Font("Arial", Font.BOLD, 18));
	    btnCancelar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Lógica para volver al inicio
	            konradBank.remove(bodyMenuPrincipal);
	            konradBank.add(bodyLogin()); // Método para crear bodyLogin
	            konradBank.revalidate();
	            konradBank.repaint();
	        }
	    });
	    bodyMenuPrincipal.add(btnCancelar);

	    return bodyMenuPrincipal;
	}

	

}
//class