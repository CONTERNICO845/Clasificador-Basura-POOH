import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {
        setTitle("Login");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JPanel cuadroLogin = new JPanel(new GridLayout(1, 2));
        cuadroLogin.setPreferredSize(new Dimension(1000, 450));

        cuadroLogin.add(new PanelIzquierdo());
        cuadroLogin.add(new PanelDerecho());

        add(cuadroLogin, new GridBagConstraints());
        getContentPane().setBackground(new Color(255, 255, 255));
    }

    // --- PANEL IZQUIERDO ---
    class PanelIzquierdo extends JPanel {
        public PanelIzquierdo() {
            setBackground(new Color(255, 0, 0));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 8, 8, 8); 
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Para que los campos se vean uniformes
            gbc.gridx = 0; 

            JLabel label = new JLabel("POOOH");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 24));
	    gbc.gridy = 0;
	    add(label, gbc);

	    JLabel labelInformacion = new JLabel("Esto es una APP acerca del resiclaje sobre una calificaion de basura te dice en que parte va y coas asi anananana");
            labelInformacion.setForeground(Color.WHITE);
            gbc.gridy = 1;
            add(labelInformacion, gbc);

        }
    }

    // --- PANEL DERECHO ---
    class PanelDerecho extends JPanel {
        public PanelDerecho() {
            setBackground(new Color(70, 70, 70)); 
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 8, 8, 8); 
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Para que los campos se vean uniformes
            gbc.gridx = 0; 

            // Título
            JLabel labelSesion = new JLabel("Inicia Sesión", SwingConstants.CENTER);
            labelSesion.setForeground(Color.WHITE);
            labelSesion.setFont(new Font("Arial", Font.BOLD, 18));
            gbc.gridy = 0;
            add(labelSesion, gbc);

            // Correo
            JLabel labelcorreo = new JLabel("Correo:");
            labelcorreo.setForeground(Color.WHITE);
            gbc.gridy = 1;
            add(labelcorreo, gbc);

            JTextField txtCorreo = new JTextField(15);
            gbc.gridy = 2; // Fila distinta para que no tape al label
            add(txtCorreo, gbc);

            // Contraseña
            JLabel labelPass = new JLabel("Contraseña:");
            labelPass.setForeground(Color.WHITE);
            gbc.gridy = 3;
            add(labelPass, gbc);

            JPasswordField txtPass = new JPasswordField(15); // Mejor usar JPasswordField
            gbc.gridy = 4;
            add(txtPass, gbc);

            // Botón
            JButton btn = new JButton("Entrar");
            gbc.gridy = 5;
            gbc.insets = new Insets(20, 8, 8, 8); // Espacio extra arriba del botón
            add(btn, gbc);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
