package comandos;

import frames.MenuCreacionPj;

import javax.swing.JOptionPane;

import mensajeria.Paquete;

/**
 * The Class Registro.
 */
public class Registro extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    synchronized (this) {
      Paquete paquete = (Paquete) getGson()
          .fromJson(getCadenaLeida(), Paquete.class);
      if (paquete.getMensaje().equals(Paquete.getMsjExito())) {

        // Abro el menu para la creaci�n del personaje
        MenuCreacionPj menuCreacionPJ =
            new MenuCreacionPj(getCliente(), getCliente()
            .getPaquetePersonaje(), getGson());
        menuCreacionPJ.setVisible(true);

        // Espero a que el usuario cree el personaje
        // Recibo el paquete personaje con los datos (la id incluida)
        // Indico que el usuario ya inicio sesion
      } else {
        if (paquete.getMensaje().equals(Paquete.getMsjFracaso())) {
          JOptionPane.showMessageDialog(null, "No se pudo registrar.");
        }
        // El usuario no pudo iniciar sesión
        getCliente().getPaqueteUsuario().setInicioSesion(false);
      }
    }
  }

}
