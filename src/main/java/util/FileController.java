package util;

import controlador.ProductoController;
import modelo.Producto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileController {

    public String elegirRuta() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("archivos txt, csv", "txt", "csv");
        jFileChooser.addChoosableFileFilter(filter);
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int r = jFileChooser.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            return jFileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    public ArrayList<String[]> cargarDatos(String ruta ) {

        BufferedReader br;
        ArrayList<String[]> lista = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(ruta));
            String leer = "";
            while((leer = br.readLine()) != null) {
                String[] datos = leer.split(",");
                lista.add(datos);
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lista;
    }
}
