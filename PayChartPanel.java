//Codigo hecho por el God Giovanni Sandoval

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

abstract class PayChartPanel extends JPanel{

    //Constantes
    private static final String[] names = {"Organica", "Inorganica", "Papel", "Dificil reciclaje"};

    //Variable para los valores de cada parte
    private double[] values;
    private Color[] colors;

    public PayChartPanel(double[] values, Color[] colors){
        this.values = values;
        this.colors = colors;
    }

    @Override
    protected void paintComponent(Graphics g){
        double startAngle;
        double arcAngle;
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle2D area = new Rectangle2D.Double(10, 10, 500, 500);

        double total = 0;
        double currentValue = 0;

        for(int i = 0; i < names.length; i++){
            total += values[i];
        }
        
        for(int i = 0; i < names.length; i++){
            startAngle = (currentValue * 360 / total);
            arcAngle = (values[i] * 360 / total);

            g2d.setColor(colors[i]);
            g2d.fillArc((int) area.getX(), (int) area.getY(), (int) area.getWidth(), (int) area.getHeight(), (int) startAngle, (int) arcAngle);
            currentValue += values[i];
        }
    }
}