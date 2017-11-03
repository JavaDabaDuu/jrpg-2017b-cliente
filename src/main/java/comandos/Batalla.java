package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import mensajeria.PaqueteBatalla;

/**
 * The Class Batalla.
 */
public class Batalla extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {

    PaqueteBatalla paqueteBatalla = (PaqueteBatalla) getGson()
        .fromJson(getCadenaLeida(), PaqueteBatalla.class);
    getJuego().getPersonaje().setEstado(Estado.getEstadoBatalla());
    Estado.setEstado(null);
    getJuego().setEstadoBatalla(new EstadoBatalla(getJuego(), paqueteBatalla));
    Estado.setEstado(getJuego().getEstadoBatalla());

  }

}
