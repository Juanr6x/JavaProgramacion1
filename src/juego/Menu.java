package juego;


import entorno.Herramientas;

import javax.swing.ImageIcon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import entorno.InterfaceJuego; 
public class Menu extends JPanel {
    private Image fondo;
    private ImageIcon boton1, boton2,boton3;
    private Configuracion.Dificultad dif;
    private InterfaceJuego juego;
    private Configuracion config = new Configuracion(false,dif.FACIL) ;
    public Menu() {
        // Carga el fondo
        fondo =  Herramientas.cargarImagen("imagenes/fondomenu1.png");
       
        // Carga las imágenes de los botones
        ImageIcon boton1 = new ImageIcon("imagenes/btnjugar.png");
        ImageIcon boton2 = new ImageIcon("boton2.png");
 //       ImageIcon boton3 = new ImageIcon("boton2.png");
        // Crea los botones
        JButton boton1Btn = new JButton(boton1);
        JButton boton2Btn = new JButton(boton2);
//        JButton boton3Btn = new JButton(boton2);
        // Ajusta el tamaño de los botones
        Dimension buttonSize = new Dimension(150, 50);
        boton1Btn.setPreferredSize(buttonSize);
        boton2Btn.setPreferredSize(buttonSize);
        boton1Btn.setText("JUGAR");
        boton2Btn.setText("CONFIGURACION");
        
        JFrame frame = new JFrame("Sonidos");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JCheckBox checkBox = new JCheckBox("No", false); // Valor predeterminado: No
        checkBox.setVisible(false);
       

        // Establece un layout de caja vertical;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        // Añade ActionListener a los botones
        boton1Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	juego = new Juego(config);
            	
            	 // Cerrar la ventana actual
                frame.dispose();
            }
        });

        boton2Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 checkBox.setVisible(!checkBox.isVisible());
            	 boton2Btn.setVisible(false);
            	 
            }
        });
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    config.setSonido(true);
                } else {
                	config.setSonido(false);
                }
            }
        });
        // Establece un layout GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Establece la alineación al centro
        gbc.anchor = GridBagConstraints.CENTER;

        // Añade el primer botón
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(boton1Btn, gbc);

        // Añade el segundo botón
        gbc.gridy = 1;
        add(boton2Btn, gbc);
        gbc.gridy = 2;
        add(checkBox,gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public enum Dificultad {
        FACIL,
        MEDIO,
        DIFICIL
    }
}
