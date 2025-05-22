package estilos;

import com.formdev.flatlaf.FlatLightLaf;


import javax.swing.UIManager;


public class Estilos {

    public static void aplicarEstilos() {
        try {

            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Table.showVerticalLines", true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}