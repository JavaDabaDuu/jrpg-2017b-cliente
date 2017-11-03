package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatallaNPC;

/**
 * The Class FinalizarBatallaNPC.
 */
public class FinalizarBatallaNPC extends ComandosEscucha {

 /**
  * Termina la batalla con un NPC.
  */
  @Override
public void ejecutar() {
    PaqueteFinalizarBatallaNPC paqueteFinalizarBatalla
        = (PaqueteFinalizarBatallaNPC) getGson().fromJson(getCadenaLeida(),
        PaqueteFinalizarBatallaNPC.class);
    getJuego().getPersonaje().setEstado(Estado.getEstadoJuego());
    getJuego().getNpcs().get(paqueteFinalizarBatalla.getIdEnemigo())
        .setEstado(Estado.getEstadoJuego());
    getJuego().actualizarEnemigo();
    Estado.setEstado(getJuego().getEstadoJuego());
  }
}
