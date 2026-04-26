//Codigo hecho por el God Giovanni Sandoval

import java.awt.*;
import javax.swing.*;

class MyPay extends PayChartPanel{

    double[] values;
    private static final Color[] colors = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED};
    
    public MyPay(double[] values){
        super(values, colors);
    }
}

public class Statistics extends JPanel {

    public Statistics(){
        this.setLayout(new BorderLayout());

        double[] values = {40, 30, 20, 15}; //Ejemplo

        MyPay myGraphic = new MyPay(values);
        this.add(myGraphic, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        JFrame ventanaDePrueba = new JFrame("Test de Estadísticas - God Giovanni");
        ventanaDePrueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaDePrueba.setSize(600, 600);
        
        // Creamos nuestro panel y lo metemos en la ventana
        Statistics panelEstadisticas = new Statistics();
        ventanaDePrueba.add(panelEstadisticas);
        
        // Centramos la ventana en la pantalla y la hacemos visible
        ventanaDePrueba.setLocationRelativeTo(null);
        ventanaDePrueba.setVisible(true);
    }
}
