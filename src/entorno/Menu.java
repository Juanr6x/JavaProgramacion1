package entorno;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import entorno.InterfaceJuego; 
public class Menu extends JPanel {
    private Image fondo;
    private ImageIcon boton1, boton2;
    private JButton boton1Btn, boton2Btn;
    private InterfaceJuego juego; 
    public Menu() {
        // Carga el fondo
        fondo = new ImageIcon("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\fondomenu1.png").getImage();

        // Carga las imágenes de los botones
        boton1 = new ImageIcon("C:\\JavaProgramacion1\\\\ProyectoBaseTP\\\\src\\\\Imagenes\\btnjugar.png");
        boton2 = new ImageIcon("boton2.png");

        // Crea los botones
        boton1Btn = new JButton(boton1);
        boton2Btn = new JButton(boton2);

        // Ajusta el tamaño de los botones
        Dimension buttonSize = new Dimension(150, 50);
        boton1Btn.setPreferredSize(buttonSize);
        boton2Btn.setPreferredSize(buttonSize);

        // Establece un layout de caja vertical
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        // Añade ActionListener a los botones
        boton1Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Botón 1 presionado");
            	
            }
        });

        boton2Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 2 presionado");
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Menu panel = new Menu();
        frame.add(panel);

        frame.setVisible(true);
    }
}
