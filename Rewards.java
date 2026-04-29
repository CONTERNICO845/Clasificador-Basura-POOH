import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rewards extends JPanel implements ActionListener {

    // Constantes para los valores de puntos y créditos
    private static final int PUNTOS_AGREGAR = 50;
    private static final int PUNTOS_CANJEAR = 30;

    private static final int CREDITOS_VERDE = 10;
    private static final int CREDITOS_AMARILLO = 5;
    private static final int CREDITOS_ROJO = 2;

    // Constante para el tamaño de la imagen en los botones
    private static final int TAMANO_IMAGEN = 250;

    private int puntos;
    private int nivel;
    private int creditosSiiau;

    private JLabel labelEstado;
    private JButton btnAgregar;
    private JButton btnRojo, btnAmarillo, btnVerde;

    public Rewards() {
        puntos = 0;
        nivel = 1;
        creditosSiiau = 0;

        setLayout(new BorderLayout());

        // Estado arriba
        labelEstado = new JLabel("Puntos: " + puntos + " | Nivel: " + nivel + " | Créditos SIIAU: " + creditosSiiau, SwingConstants.CENTER);
        add(labelEstado, BorderLayout.NORTH);

        // Botón para agregar puntos
        btnAgregar = new JButton("Agregar " + PUNTOS_AGREGAR + " puntos");
        btnAgregar.addActionListener(this);
        add(btnAgregar, BorderLayout.SOUTH);

        // Panel central con los tres cuadros
        JPanel panelCuadros = new JPanel(new GridLayout(1, 3, 20, 0));
        panelCuadros.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Botón rojo con imagen Homildander
        btnRojo = crearBoton("Canjear", Color.RED, "imagenes/botorewards/fiesta-salchichas_2.jpg");
        btnAmarillo = crearBoton("Canjear", Color.YELLOW, null);
        btnVerde = crearBoton("Canjear", Color.GREEN, null);

        panelCuadros.add(btnRojo);
        panelCuadros.add(btnAmarillo);
        panelCuadros.add(btnVerde);

        add(panelCuadros, BorderLayout.CENTER);

        setSize(500, 300);
    }

    private JButton crearBoton(String texto, Color color, String rutaImagen) {
        JButton boton = new JButton(texto);

        if (rutaImagen != null) {
            ImageIcon icono = new ImageIcon(rutaImagen);
            // Escalar la imagen al tamaño definido en la constante
            Image img = icono.getImage().getScaledInstance(TAMANO_IMAGEN, TAMANO_IMAGEN, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(img));

            // Texto debajo de la imagen
            boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        }

        boton.setBackground(color);
        boton.setOpaque(true);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(this);
        return boton;
    }

    private void verificarNivel() {
        if (puntos >= nivel * 100) {
            nivel++;
            JOptionPane.showMessageDialog(this,
                "¡Felicidades! Has alcanzado el nivel " + nivel);
        }
    }

    private void actualizarEstado() {
        labelEstado.setText("Puntos: " + puntos + " | Nivel: " + nivel + " | Créditos SIIAU: " + creditosSiiau);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            puntos += PUNTOS_AGREGAR;
            verificarNivel();
        } else if (e.getSource() == btnRojo) {
            if (puntos >= PUNTOS_CANJEAR) {
                puntos -= PUNTOS_CANJEAR;
                creditosSiiau += CREDITOS_ROJO;
                JOptionPane.showMessageDialog(this, "Hot dog con salchicha doble (♥ω♥*) ");
            } else {
                JOptionPane.showMessageDialog(this, "Te faltan " + (PUNTOS_CANJEAR - puntos) + " puntos para canjear.");
            }
        } else if (e.getSource() == btnAmarillo) {
            if (puntos >= PUNTOS_CANJEAR) {
                puntos -= PUNTOS_CANJEAR;
                creditosSiiau += CREDITOS_AMARILLO;
                JOptionPane.showMessageDialog(this, "Canjeaste en el botón amarillo. Recibiste " + CREDITOS_AMARILLO + " créditos.");
            } else {
                JOptionPane.showMessageDialog(this, "Te faltan " + (PUNTOS_CANJEAR - puntos) + " puntos para canjear.");
            }
        } else if (e.getSource() == btnVerde) {
            if (puntos >= PUNTOS_CANJEAR) {
                puntos -= PUNTOS_CANJEAR;
                creditosSiiau += CREDITOS_VERDE;
                JOptionPane.showMessageDialog(this, "Canjeaste en el botón verde. Recibiste " + CREDITOS_VERDE + " créditos.");
            } else {
                JOptionPane.showMessageDialog(this, "Te faltan " + (PUNTOS_CANJEAR - puntos) + " puntos para canjear.");
            }
        }
        actualizarEstado();
    }

    // Método main para probar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rewards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Rewards());
        frame.setVisible(true);
    }
}