//Codigo hecho por el God Giovanni Sandoval

import java.awt.*;
import javax.swing.*;

class MyPay extends PayChartPanel{

    double[] values;
    public static final Color[] colors = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED};
    
    public MyPay(double[] values){
        super(values, colors);
        this.setPreferredSize(new Dimension(500, 500));
    }
}

class MyPayInfo extends PayChartInfo{

    public MyPayInfo(double[] values){
        super(values, MyPay.colors);
    }
}

class MyPodium extends Podium{

    public MyPodium(){

    }
}

public class Statistics extends JPanel {

    JPanel rightPanel;
    JPanel leftPanel;

    public Statistics(){
        this.setLayout(new GridLayout(1, 2));

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); 

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        //Por el momento no los pide de la base de datos
        double[] values = {40, 30, 20, 15};

        MyPay myGraphic = new MyPay(values);
        MyPayInfo myInfo = new MyPayInfo(values);
        MyPodium myPodium = new MyPodium();
        
        leftPanel.add(myGraphic);
        leftPanel.add(myInfo, BorderLayout.CENTER);

        //Agrega la parte de la derecha
        rightPanel.add(myPodium);

        this.add(leftPanel);
        this.add(rightPanel);
    }
    public static void main(String[] args) {
        Statistics window = new Statistics();
        window.setVisible(true);
    }
}
