package comandos;

import frames.MenuStats;
import mensajeria.PaquetePersonaje;

/**
 * The Class ActualizarPersonajeLvl.
 */
public class ActualizarPersonajeLvl extends ComandosEscucha {

  /** The menu stats. */
  private MenuStats menuStats;

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
      getJuego().getCliente()
         .actualizarPersonaje(getJuego().getPersonajesConectados()
          .get(paquetePersonaje.getId()));
    }

  }

}
