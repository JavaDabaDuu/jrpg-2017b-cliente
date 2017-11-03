package comandos;

import mensajeria.PaqueteAtacar;

/**
 * The Class Atacar.
 */
public class Atacar extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaqueteAtacar paqueteAtacar = (PaqueteAtacar)
        getGson().fromJson(getCadenaLeida(), PaqueteAtacar.class);
    getJuego().getEstadoBatalla().getEnemigo()
        .actualizarAtributos(paqueteAtacar.getMapPersonaje());
    getJuego().getEstadoBatalla().getPersonaje()
        .actualizarAtributos(paqueteAtacar.getMapEnemigo());
    getJuego().getEstadoBatalla().setMiTurno(true);

  }

}
