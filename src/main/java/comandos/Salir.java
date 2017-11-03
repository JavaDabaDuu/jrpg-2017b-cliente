package comandos;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class Salir.
 */
public class Salir extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    try {
      getCliente().getPaqueteUsuario().setInicioSesion(false);
      getCliente().getSalida().writeObject(getGson()
          .toJson(new Paquete(Comando.DESCONECTAR), Paquete.class));
      getCliente().getSocket().close();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Error al salir");
    }
  }

}
