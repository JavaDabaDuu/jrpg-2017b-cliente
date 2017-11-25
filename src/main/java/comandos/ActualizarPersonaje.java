
package comandos;

import mensajeria.PaquetePersonaje;

/**
 * The Class ActualizarPersonaje.
 */
public class ActualizarPersonaje extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaquetePersonaje paquetePersonaje = (PaquetePersonaje) getGson()
        .fromJson(getCadenaLeida(), PaquetePersonaje.class);

    getJuego().getPersonajesConectados().remove(paquetePersonaje.getId());
    getJuego().getPersonajesConectados()
        .put(paquetePersonaje.getId(), paquetePersonaje);

    if (getJuego().getPersonaje().getId() == paquetePersonaje.getId()) {
      getJuego().actualizarPersonaje();
      getJuego().getEstadoJuego().actualizarPersonaje();
      getJuego().getCliente().actualizarItems(paquetePersonaje);
      getJuego().getCliente()
          .actualizarPersonaje(getJuego().getPersonajesConectados()
          .get(paquetePersonaje.getId()));
    }
  }

}

