package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class App {
    private JFrame loginFrame;
    private JFrame privateAccessFrame;
    private JTextField userField;
    private JPasswordField passwordField;
    private Random random;

    public static void main(String[] args) {
        App app = new App();
        app.crearVentanaLogin();
    }

    public App() {
        random = new Random();
    }
    private void crearVentanaLogin() {
        loginFrame = new JFrame("Login - Área restringida - Ucrania");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(450, 640);
        loginFrame.getContentPane().setBackground(Color.GRAY);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.GRAY);

        ImageIcon imagen = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/EJERCITO.png");
        JLabel imagenLabel = new JLabel(imagen);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentro.setBackground(Color.GRAY);

        JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelUsuario.setBackground(Color.GRAY);
        JLabel userLabel = new JLabel("Usuario:");
        userField = new JTextField(10); // Corregir: asignar valor a la variable de instancia
        panelUsuario.add(userLabel);
        panelUsuario.add(userField);

        JPanel panelContraseña = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelContraseña.setBackground(Color.GRAY);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(10); // Corregir: asignar valor a la variable de instancia
        panelContraseña.add(passwordLabel);
        panelContraseña.add(passwordField);

        panelCentro.add(panelUsuario);
        panelCentro.add(panelContraseña);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.GRAY);
        JButton loginButton = new JButton("Iniciar sesión");
        panelInferior.add(loginButton);

        // Agrega la acción del botón de inicio de sesión
        ActionListener loginActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("ucrania") && password.equals("ucrania")) {
                    loginFrame.dispose();
                    crearVentanaAccesoPrivado();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos, por favor, ingresa bien el usuario o la contraseña o alertaremos a las autoridades.");
                }
            }
        };

        loginButton.addActionListener(loginActionListener);

        // Agrega la acción al presionar la tecla "Enter" en los campos de usuario y contraseña
        KeyListener enterKeyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginActionListener.actionPerformed(null);
                }
            }
        };

        userField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);

        JLabel advertenciaLabel = new JLabel("USALO BAJO TU\n PROPIA RESPONSABILIDAD");
        advertenciaLabel.setForeground(Color.RED);
        advertenciaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        advertenciaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panelPrincipal.add(imagenLabel, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        panelPrincipal.add(advertenciaLabel, BorderLayout.PAGE_END);

        loginFrame.add(panelPrincipal);
        loginFrame.setVisible(true);
    }







    private void crearVentanaAccesoPrivado() {
        privateAccessFrame = new JFrame("Área de acceso privado - Ucrania - Administración");
        privateAccessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        privateAccessFrame.setSize(500, 390);
        privateAccessFrame.setLayout(new BorderLayout());
        privateAccessFrame.getContentPane().setBackground(Color.GRAY);



        JLabel welcomeLabel = new JLabel("Bienvenido al panel de administración del ejercito de Ucrania");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        JPanel panelBotones = new JPanel(new GridLayout(2, 2));
        ImageIcon iconoDESTRUIR = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/destruir.png");
        JButton botonCerrar = new JButton("BOTON DEL PANICO - DESTRUIR TODO EL MUNDO", iconoDESTRUIR);
        botonCerrar.setBackground(Color.red);
        botonCerrar.setForeground(Color.WHITE);

        ImageIcon iconoRUSIA = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/rusiaflag.png");
        ImageIcon iconoUSA = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/usaflag.png");
        ImageIcon iconoCHINA = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/chinaflag.png");
        ImageIcon iconoESPANA = new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/espanaflag.png");

        JButton boton1 = new JButton("Enviar misil a Rusia", iconoRUSIA);
        JButton boton2 = new JButton("Enviar misil a EE.UU", iconoUSA);
        JButton boton3 = new JButton("Enviar misil a China", iconoCHINA);
        JButton boton4 = new JButton("Enviar misil a España", iconoESPANA);

        boton1.setBackground(Color.WHITE);
        boton1.setForeground(Color.RED);
        boton2.setBackground(Color.WHITE);
        boton2.setForeground(Color.RED);
        boton3.setBackground(Color.WHITE);
        boton3.setForeground(Color.RED);
        boton4.setBackground(Color.WHITE);
        boton4.setForeground(Color.RED);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("Rusia");
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("EE.UU");
            }
        });

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("China");
            }
        });

        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaMapa("España");
            }
        });

        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);

        privateAccessFrame.add(welcomeLabel, BorderLayout.NORTH);
        privateAccessFrame.add(panelBotones, BorderLayout.CENTER);
        privateAccessFrame.add(botonCerrar, BorderLayout.SOUTH);

        privateAccessFrame.setVisible(true);
    }

    private void abrirVentanaMapa(String pais) {
        JFrame mapaFrame = new JFrame("Mapa de " + pais);
        mapaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mapaFrame.setSize(600, 400);
        mapaFrame.setLayout(new BorderLayout());

        JLabel mapaLabel = new JLabel(new ImageIcon("/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/" + pais.toLowerCase() + ".png"));

        mapaFrame.add(mapaLabel, BorderLayout.CENTER);

        JPanel panelCampos = new JPanel(new FlowLayout());
        JLabel longitudLabel = new JLabel("Longitud:");
        JTextField longitudField = new JTextField(10);
        JLabel latitudLabel = new JLabel("Latitud:");
        JTextField latitudField = new JTextField(10);
        JButton enviarAtaqueButton = new JButton("Enviar ataque");

        mapaLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                double latitud = generarCoordenadaAleatoria();
                double longitud = generarCoordenadaAleatoria();
                latitudField.setText(String.valueOf(latitud));
                longitudField.setText(String.valueOf(longitud));

                JOptionPane.showMessageDialog(mapaFrame,
                        "Enviando misil a " + pais + " Longitud: " + longitud + " Latitud: " + latitud);

                // Muestra una ventana con el gif del misil lanzado
                JFrame gifFrame = new JFrame("Camara de la Estacion de Cohetes");
                gifFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gifFrame.setSize(400, 400);

                int randomRocket = random.nextInt(4) + 1;
                String gifPath = "/home/INFORMATICA/alu10198545/IdeaProjects/Graficas-Swing/src/main/java/org/example/banderas/cohete" + randomRocket + ".gif";
                JLabel gifLabel = new JLabel(new ImageIcon(gifPath));
                gifFrame.add(gifLabel);
                gifFrame.setVisible(true);
                // Cierra la ventana del gif después de 10 segundos
                Timer timer = new Timer(7000, new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        gifFrame.dispose();
                        if (randomRocket == 4) {
                            int choice = JOptionPane.showOptionDialog(mapaFrame,
                                    "El misil ha explotado y no ha llegado a su destino. ¿Desea lanzar otro misil?",
                                    "Error de lanzamiento", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.ERROR_MESSAGE, null, null, null);
                            if (choice == JOptionPane.YES_OPTION) {
                                // Vuelve a lanzar otro misil
                                enviarAtaqueButton.doClick();

                            } else {
                                privateAccessFrame.dispose();
                            }
                        }

                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        enviarAtaqueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String longitud = longitudField.getText();
                String latitud = latitudField.getText();
                JOptionPane.showMessageDialog(mapaFrame, "Enviando misil a " + pais + ". Longitud: " + longitud + " Latitud: " + latitud);

            }
        });

        panelCampos.add(longitudLabel);
        panelCampos.add(longitudField);
        panelCampos.add(latitudLabel);
        panelCampos.add(latitudField);
        panelCampos.add(enviarAtaqueButton);


        mapaFrame.add(panelCampos, BorderLayout.SOUTH);

        mapaFrame.setVisible(true);
    }
    private double generarCoordenadaAleatoria() {
        double min = -90.0;
        double max = 90.0;
        return min + Math.random() * (max - min);
    }
}