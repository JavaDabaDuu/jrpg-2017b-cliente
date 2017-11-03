package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;

/**
 * The Class FinalizarBatalla.
 */
public class FinalizarBatalla extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaqueteFinalizarBatalla paqueteFinalizarBatalla
        = (PaqueteFinalizarBatalla) getGson().fromJson(getCadenaLeida(),
        PaqueteFinalizarBatalla.class);
    getJuego().getPersonaje().setEstado(Estado.getEstadoJuego());
    Estado.setEstado(getJuego().getEstadoJuego());
  }

}
