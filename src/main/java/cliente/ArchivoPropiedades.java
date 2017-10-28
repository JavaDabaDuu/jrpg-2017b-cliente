package cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ArchivoPropiedades {

  public static void main(String[] args) {
    Properties prop = new Properties();
    try {          
      OutputStream output = new FileOutputStream("configCliente.properties");
      prop.setProperty("puerto", "55050");
      prop.store(output, null);
      output.close();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Error al generar archivo de propiedades.");
    }
  }
}
