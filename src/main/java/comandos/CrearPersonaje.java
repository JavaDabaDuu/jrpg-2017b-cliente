package comandos;

import mensajeria.PaquetePersonaje;

/**
 * The Class CrearPersonaje.
 */
public class CrearPersonaje extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    getCliente().setPaquetePersonaje((PaquetePersonaje) getGson()
         .fromJson(getCadenaLeida(), PaquetePersonaje.class));
    getCliente().getPaqueteUsuario().setInicioSesion(true);
  }

}
