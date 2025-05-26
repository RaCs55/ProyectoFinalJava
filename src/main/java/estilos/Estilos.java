package estilos;

import com.formdev.flatlaf.FlatLightLaf;
import util.GestionErrores;


import javax.swing.UIManager;


public class Estilos {

    public static void aplicarEstilos() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Table.showVerticalLines", true);
        } catch (Exception e) {
            GestionErrores.mostrarError(GestionErrores.TipoError.OPERACION_NO_COMPLETADA, "No se ha podido cargar los estilos", null);
        }
    }
}