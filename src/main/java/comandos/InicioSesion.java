package comandos;

import javax.swing.JOptionPane;

import mensajeria.Paquete;
import mensajeria.PaquetePersonaje;

/**
 * The Class InicioSesion.
 */
public class InicioSesion extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    Paquete paquete = (Paquete) getGson()
       .fromJson(getCadenaLeida(), Paquete.class);
    if (paquete.getMensaje().equals(Paquete.getMsjExito())) {

      // El usuario ya inicio sesi�n
      getCliente().getPaqueteUsuario().setInicioSesion(true);

      // Recibo el paquete personaje con los datos
      getCliente().setPaquetePersonaje(getGson().fromJson(
          getCadenaLeida(), PaquetePersonaje.class));

    } else {
      if (paquete.getMensaje().equals(Paquete.getMsjFracaso())) {
        JOptionPane.showMessageDialog(null, "Error al iniciar sesión."
                    + " Revise el usuario y la contraseña");

        // El usuario no pudo iniciar sesión
        getCliente().getPaqueteUsuario().setInicioSesion(false);
      }

    }
  }
}
