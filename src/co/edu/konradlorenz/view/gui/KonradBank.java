package co.edu.konradlorenz.view.gui;

import javax.swing.*;
import javax.swing.border.Border;

import co.edu.konradlorenz.controller.Controlador;
import co.edu.konradlorenz.model.Cajero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

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
	JButton btnMenuDepositar;
	JButton btnMenuRetirar;
	JButton btnDepositar;
	JButton btnRetirar;
	JButton btnCancelar;
	JButton btnCerrarSesion;
	
	//Colores
	Color fondoPanel = Color.WHITE;//Fondo de todos los JPanel
	Color fondoFrame = Color.RED;//Fondo del JFrame
	
	//Acción cuando se da enter en el login
	ActionListener enterLogin = new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            
            String numeroTarjeta = txtField.getText();
            String pin = new String(pwdField.getPassword());
            
			boolean validacion = controlador.validarCredenciales(numeroTarjeta, pin);
			if(validacion) {
				konradBank.remove(bodyLogin);//Elimina panel actual
				konradBank.add(bodyMenuPrincipal());//Agrega nuevo panel
				konradBank.revalidate();//Recargar
				konradBank.repaint();//Recargar
			} else {
				//Inicializo los bordes
				Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
				Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 2);
				
				//Inicializo colores para el botón
				Color redColor = Color.RED;
				Color blueColor = Color.BLUE;
				
				//Agrego los colores y bordes
				btnIngresar.setBorder(redBorder);
				btnIngresar.setBackground(redColor);
				txtField.setBorder(redBorder);
				pwdField.setBorder(redBorder);
				
				
				//Contador para alternar bordes
				final int[] contador = {0};
				
				//Alternador de bordes
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
		            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
		                Border bordeActual = (contador[0] % 2 == 0) ? redBorder : blueBorder; //Op ternario
		                Color colorActual = (contador[0] % 2 == 0) ? redColor : blueColor; //Op ternario x2
		                txtField.setBorder(bordeActual);
		                pwdField.setBorder(bordeActual);
		                btnIngresar.setBorder(bordeActual);
		                btnIngresar.setBackground(colorActual);
		                
		                contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
		        });
				
				timer.start();
			}
        }
    };
    //enterLogin
	
    //Acción cuando se de enter a Retirar
    ActionListener enterRetirar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String monto = txtField.getText();
			String tipoTransaccion = "retirado";
			
			boolean retiro = controlador.retirarMonto(monto);
			
			if(retiro) {
				konradBank.remove(bodyLogin);
				konradBank.add(bodyRecibo(tipoTransaccion, monto));
				konradBank.revalidate();
				konradBank.repaint();
			}else {
				//Inicializo los bordes
				Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
				Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 2);
				
				//Inicializo colores para el botón
				Color redColor = Color.RED;
				Color blueColor = Color.BLUE;
				
				//Agrego los colores y bordes
				btnIngresar.setBorder(redBorder);
				btnIngresar.setBackground(redColor);
				txtField.setBorder(redBorder);
				pwdField.setBorder(redBorder);
				//Contador para alternar bordes
				final int[] contador = {0};
				
				//Alternador de bordes
				Timer timer = new Timer(150, event -> { // Cambia cada 150 ms
		            if (contador[0] < 6) { // Se repetirá 3 veces, 3 rojas y 3 azules = 6
		                Border bordeActual = (contador[0] % 2 == 0) ? redBorder : blueBorder; //Op ternario
		                Color colorActual = (contador[0] % 2 == 0) ? redColor : blueColor; //Op ternario x2
		                txtField.setBorder(bordeActual);
		                pwdField.setBorder(bordeActual);
		                btnIngresar.setBorder(bordeActual);
		                btnIngresar.setBackground(colorActual);
		                
		                contador[0]++;
		            } else {
		                ((Timer) event.getSource()).stop(); //Detiene el Timer
		            }
		        });
				
				timer.start();
			}
		}
	};
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // VENTANAS // -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Constructor del JFrame
	public KonradBank(){

		controlador.datosDePrueba();
	
		konradBank.setDefaultCloseOperation(EXIT_ON_CLOSE);//Terminar la ejecución si se cierra la ventana
		konradBank.setTitle("[ Cajero Automático ]");
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
		JLabel lbllblMsn = new JLabel("Bienvenido(a) al cajero automático KonradBank");
		lbllblMsn.setFont(new Font("Arial", Font.ITALIC, 20));
		lbllblMsn.setForeground(Color.BLACK);
		lbllblMsn.setBounds(0, 25, 600, 50);//x,y,ancho,altura
		lbllblMsn.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
		
		bodyLogin.add(lbllblMsn);
		
		
		
		bodyLogin.add(txtField(100, 115, 400, 50, "Ingrese su tarjeta"));
		bodyLogin.add(pwdField(100, 215, 400, 50, "Ingrese su PIN"));
		bodyLogin.add(btnIngresar(100, 315, 400, 50, "Ingresar"));
		
		return bodyLogin;
	}
	//*/bodyLogin
	
	// Método para crear bodyMenuPrincipal
	public JPanel bodyMenuPrincipal() {
		
		bodyMenuPrincipal = new JPanel();
	    bodyMenuPrincipal.setBounds(0, 150, 600, 450);//x,y,ancho,altura
	    bodyMenuPrincipal.setBackground(Color.WHITE); 

		    JLabel lblBienvenido = new JLabel("Bienvenido(a) " + controlador.clienteSeleccionado.getNombre());
		    lblBienvenido.setFont(new Font("Arial", Font.BOLD, 24));
		    lblBienvenido.setBounds(0, 25, 600, 50);
		    lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
		    bodyMenuPrincipal.add(lblBienvenido);
	    
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(3) + 1; //Número entre 1 y 3
	
	        JLabel lblRandom;
	        
	        //Selecciona un Label Random
	        switch (numeroAleatorio) {
	            case 1:
	                lblRandom = new JLabel("El banco #1 de los estudiantes de la Konrad");
	                break;
	            case 2:
	                lblRandom = new JLabel("9 de cada 10 estudiantes prefieren KonradBank");
	                break;
	            case 3:
	                lblRandom = new JLabel("K de KonradBank");
	                break;
	            default:
	                lblRandom = new JLabel("Fundación Universitaria Konrad Lorenz"); //Por si las moscas
	                break;
	        }
	        //switch
	
	        lblRandom.setFont(new Font("Arial", Font.ITALIC, 18));
	        lblRandom.setBounds(0, 75, 600, 50);
	        lblRandom.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
		    
		    bodyMenuPrincipal.add(lblRandom);
		    
		    JLabel lblPregunta = new JLabel("¿Qué desea hacer?");
		    lblPregunta.setFont(new Font("Arial", Font.PLAIN, 20));
		    lblPregunta.setBounds(0, 125, 600, 50);
		    lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
		    bodyMenuPrincipal.add(lblPregunta);

		    bodyMenuPrincipal.setLayout(null);
	    
	    btnMenuDepositar = btnMenuDepositar(200, 195, 200, 50, "Depositar");
	    bodyMenuPrincipal.add(btnMenuDepositar);
	    
	    btnMenuRetirar = btnMenuRetirar(200, 270, 200, 50, "Retirar");
	    bodyMenuPrincipal.add(btnMenuRetirar);
	    
	    btnCancelar = btnCerrarSesion(200, 345, 200, 50, "Cerrar Sesión");
	    bodyMenuPrincipal.add(btnCancelar);
	    
	    return bodyMenuPrincipal;
	}
	//*/bodyMenuPrincipal
	
	// Método para crear bodyDepositar
	public JPanel bodyDepositar() {
		
		bodyDepositar = new JPanel();
	    bodyDepositar.setBounds(0, 150, 600, 450);
	    bodyDepositar.setBackground(fondoPanel);
	    bodyDepositar.setLayout(null);

		    JLabel lblMsn = new JLabel("¿Qué cantidad desea depositar?");
		    lblMsn.setFont(new Font("Arial", Font.PLAIN, 20));
		    lblMsn.setForeground(Color.BLACK);
		    lblMsn.setBounds(170, 75, 450, 50);
		    bodyDepositar.add(lblMsn);

		    txtField = txtField(100, 150, 400, 50, "Ingrese cantidad a depositar");
		    bodyDepositar.add(txtField);
		    
		    btnDepositar = btnDepositar(100, 225, 400, 50, "Depositar");
		    bodyDepositar.add(btnDepositar);
		    
		    btnCancelar = btnCancelar(100, 295, 400, 50, "Cancelar", Color.RED, Color.RED);
		    bodyDepositar.add(btnCancelar);

	    return bodyDepositar;
	}
	//*/bodyDepositar
	
	//Método para crear bodyRetirar
	public JPanel bodyRetirar() {

		bodyRetirar = new JPanel();
		bodyRetirar.setBounds(0, 150, 600, 450);
		bodyRetirar.setBackground(fondoPanel);
		bodyRetirar.setLayout(null);
		
				//Mensaje
				JLabel lblMsn = new JLabel("¿Qué cantidad desea retirar?");
				lblMsn.setFont(new Font("Arial", Font.PLAIN, 20));
				lblMsn.setForeground(Color.BLACK);
				lblMsn.setBounds(170, 75, 450, 50);
				bodyRetirar.add(lblMsn);
				
				txtField = txtField(100,150,400,50,"Ingrese cantidad a retirar");
				bodyRetirar.add(txtField);
				
				btnRetirar = btnRetirar(100, 225, 400, 50, "Retirar");
				bodyRetirar.add(btnRetirar);
			    
			    btnCancelar = btnCancelar(100, 295, 400, 50, "Cancelar", Color.RED, Color.RED);
			    bodyRetirar.add(btnCancelar);
				
		return bodyRetirar;
	}
	//*/bodyRetirar
	
	//Método para crear bodyRecibo
	public JPanel bodyRecibo(String tipoTransaccion, String monto) {

		bodyRecibo = new JPanel();
		bodyRecibo.setBounds(0, 150, 600, 450);
		bodyRecibo.setBackground(fondoPanel);
		bodyRecibo.setLayout(null);
		
		//Mensaje
		Cajero cajero = new Cajero(); // Creamos una instancia de Cajero
        String fechaHora = cajero.getActualTime(); // Obtenemos la fecha y hora actuales
        
       
    
        JLabel lblMsn = new JLabel("Resumen de Transacción");
        lblMsn.setFont(new Font("Arial", Font.PLAIN, 30));
        lblMsn.setForeground(Color.BLACK);
        lblMsn.setBounds(0, 50, 600, 50);
        lblMsn.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
        bodyRecibo.add(lblMsn);

        // Fecha y hora
        JLabel lblFechaHora = new JLabel("Fecha y Hora: " + fechaHora);
        lblFechaHora.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFechaHora.setForeground(Color.BLACK);
        lblFechaHora.setBounds(0, 120, 600, 50);
        lblFechaHora.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
        bodyRecibo.add(lblFechaHora);

        // Monto retirado/depositado
        JLabel lblMonto = new JLabel("Monto " + tipoTransaccion.toLowerCase() + ": $" + monto);
        lblMonto.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMonto.setForeground(Color.BLACK);
        lblMonto.setBounds(0, 170, 600, 50);
        lblMonto.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
        bodyRecibo.add(lblMonto);
        
        // Monto total
        JLabel lblTotal = new JLabel("Saldo actual de la cuenta : $" + String.format("%.2f", controlador.cuentaSeleccionada.getSaldo()));
        lblTotal.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setBounds(0, 220, 600, 50);
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
        bodyRecibo.add(lblTotal);
        
	    btnCancelar = btnCancelar(25, 345, 250, 50, "Realizar otra transacción", Color.BLUE, Color.BLUE);
	    bodyRecibo.add(btnCancelar);
        
	    btnCancelar = btnCerrarSesion(325, 345, 250, 50, "Finalizar transacción");
	    bodyRecibo.add(btnCancelar);
        
        
        return bodyRecibo;
	}
	//*/bodyRecibo
	
	  // -- // -- // -- // -- // -- // -- //
	 // -- // -- // DECORATIVOS -- // -- //
	// -- // -- // -- // -- // -- // -- //
	
	//Método para crear head
	public JPanel head() {
    	// - HEAD - //
        JPanel head = new JPanel();
        head.setLayout(null);//Desactivar layout automático para usar setBounds()	   
        head.setBounds(0, 0, 600, 100);//x,y,ancho,altura
        head.setBackground(Color.CYAN);
        head.setOpaque(true);//false transparente
	        
	        //Title
	        JLabel lblTitle = new JLabel("KONRAD BANK");
	        lblTitle.setFont(new Font("Arial", Font.BOLD, 40));//fuente, negrilla, tamaño
	        lblTitle.setForeground(Color.BLACK);//color letra
	        lblTitle.setBounds(0, 0, 600, 100);//x,y,ancho,altura
	        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
	        lblTitle.setBackground(Color.WHITE);
	        lblTitle.setOpaque(true);//false transparente

	        head.add(lblTitle);
	        
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
        txtField.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
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
        
        txtField.addActionListener(enterLogin);
        
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
        pwdField.setHorizontalAlignment(SwingConstants.CENTER);//Centrar Horizontalmente
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
        
        pwdField.addActionListener(enterLogin);
        
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

        btnIngresar.addActionListener(enterLogin);
        
        return btnIngresar;
	}
	//*/btnIngresar
	
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
				konradBank.remove(bodyMenuPrincipal);//Elimina panel actual
				konradBank.add(bodyDepositar());//Agrega nuevo panel
                konradBank.revalidate(); //Recarga el contenedor
                konradBank.repaint(); //Vuelve a pintar el contenedor
            }
            });
		return btnMenuDepositar;
	}
	//*/btnMenuDepositar
	
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
	
		btnMenuRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
				konradBank.remove(bodyMenuPrincipal);//Elimina panel actual
				konradBank.add(bodyRetirar());//Agrega nuevo panel
                konradBank.revalidate(); //Recarga el contenedor
                konradBank.repaint(); //Vuelve a pintar el contenedor
            }
            });
		return btnMenuRetirar;
	}
	//*/btnMenuRetirar
	
	//Método para crear btnDepositar
	public JButton btnDepositar(int cordX, int cordY, int ancho, int alto, String mensaje) {
	    JButton btnDepositar = new JButton(mensaje);
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
	            String montoTransaccion = txtField.getText();
	            boolean validacionMontoD = controlador.depositarMonto(montoTransaccion);

	            if (validacionMontoD) {
	                // El monto es válido, se procede con el cambio de panel
	            	String tipoTransaccion = "Depositado";
	                konradBank.remove(bodyDepositar);
	                konradBank.add(bodyRecibo(tipoTransaccion, montoTransaccion)); // Agrega nuevo panel
	                konradBank.revalidate(); //Recarga el contenedor
	                konradBank.repaint(); //Vuelve a pintar el contenedor
	            } else {
	                // Monto no válido, se muestra la animación de bordes
	                Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
	                Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 2);
	                Color redColor = Color.RED;
	                Color blueColor = Color.BLUE;

	                // Aplicamos el borde y el color inicial
	                btnIngresar.setBorder(redBorder);
	                btnIngresar.setBackground(redColor);
	                txtField.setBorder(redBorder);
	                pwdField.setBorder(redBorder);

	                // Contador para alternar bordes
	                final int[] contador = {0};

	                // Alternador de bordes
	                Timer timer = new Timer(150, event -> {
	                    if (contador[0] < 6) {
	                        Border bordeActual = (contador[0] % 2 == 0) ? redBorder : blueBorder;
	                        Color colorActual = (contador[0] % 2 == 0) ? redColor : blueColor;
	                        txtField.setBorder(bordeActual);
	                        pwdField.setBorder(bordeActual);
	                        btnIngresar.setBorder(bordeActual);
	                        btnIngresar.setBackground(colorActual);

	                        contador[0]++;
	                    } else {
	                        ((Timer) event.getSource()).stop(); // Detiene el Timer
	                    }
	                });
	                
	                timer.start();
	            }
	        }
	    });

	    return btnDepositar;
	}
	//*/btnDepositar
	
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
	            //konradBank.add(bodyRecibo()); //TODO: Descomentar cuando esté listo el método.
                konradBank.revalidate(); //Recarga el contenedor
                konradBank.repaint(); //Vuelve a pintar el contenedor
				
            }
            });

		btnIngresar.addActionListener(enterRetirar);
            

		return btnRetirar;
	}
	//*/btnRetirar

	//Método para crear btnCancelar
	public JButton btnCancelar(int cordX, int cordY, int ancho, int alto, String mensaje, Color color, Color borde) {
		btnCancelar = new JButton(mensaje);
		btnCancelar.setBounds(cordX, cordY, ancho, alto);
		btnCancelar.setBackground(color);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(borde, 2);
		btnCancelar.setBorder(border);
		
		btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
            	// Verifica que bodyDepositar y bodyRetirar no sean nulos antes de intentar usarlos
            	// isAncestorOf verifica si un componente está contenido dentro de otro
                if (bodyDepositar != null && konradBank.isAncestorOf(bodyDepositar)) {
                    konradBank.remove(bodyDepositar);
                } else if (bodyRetirar != null && konradBank.isAncestorOf(bodyRetirar)) {
                    konradBank.remove(bodyRetirar);
                } else if (bodyRecibo != null && konradBank.isAncestorOf(bodyRecibo)) {
                	konradBank.remove(bodyRecibo);
                }
				
                konradBank.add(bodyMenuPrincipal);
                konradBank.revalidate(); //Recarga el contenedor
                konradBank.repaint(); //Vuelve a pintar el contenedor
            }
        });
		return btnCancelar;
	}
	//*/btnCancelar
	
	//Método para crear btnCerrarSesion
	public JButton btnCerrarSesion(int cordX, int cordY, int ancho, int alto, String mensaje) {
		btnCerrarSesion = new JButton(mensaje);
		btnCerrarSesion.setBounds(cordX, cordY, ancho, alto);
		btnCerrarSesion.setBackground(Color.RED);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 16));
		btnCerrarSesion.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		btnCerrarSesion.setBorder(border);
		
		btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se presiona el botón
                
            	// Verifica que bodyDepositar y bodyRetirar no sean nulos antes de intentar usarlos
            	// isAncestorOf verifica si un componente está contenido dentro de otro
            	if (bodyMenuPrincipal != null && konradBank.isAncestorOf(bodyMenuPrincipal)) {
            		konradBank.remove(bodyMenuPrincipal);
                } else if (bodyRecibo != null && konradBank.isAncestorOf(bodyRecibo)) {
                	konradBank.remove(bodyRecibo);
                }
            	
            	controlador.clienteSeleccionado = null;
            	controlador.cuentaSeleccionada = null;
	            konradBank.add(bodyLogin());
                konradBank.revalidate(); //Recarga el contenedor
                konradBank.repaint(); //Vuelve a pintar el contenedor
                
            }
            });
		return btnCerrarSesion;
	}
	//*/btnCerrarSesion
	
}
//class