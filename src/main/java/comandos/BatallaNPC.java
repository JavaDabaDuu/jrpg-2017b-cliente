package comandos;

import estados.Estado;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatallaNPC;

/**
 * The Class BatallaNPC.
 */
public class BatallaNPC extends ComandosEscucha {

    /**
     * Comienza la batalla con un NPC.
    */
  @Override
public void ejecutar() {
    PaqueteBatallaNPC paqueteBatalla = (PaqueteBatallaNPC) getGson()
        .fromJson(getCadenaLeida(), PaqueteBatallaNPC.class);

    getJuego().getPersonaje().setEstado(Estado.getEstadoBatallaNPC());
    Estado.setEstado(null);
    getJuego().getNpcs().get(paqueteBatalla.getIdEnemigo())
        .setEstado(Estado.getEstadoBatallaNPC());
    getJuego().setEstadoBatallaNPC(
        new EstadoBatallaNPC(getJuego(), paqueteBatalla));
    Estado.setEstado(getJuego().getEstadoBatallaNPC());
  }
}
