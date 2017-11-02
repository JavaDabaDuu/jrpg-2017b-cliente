package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatallaNPC;

public class FinalizarBatallaNPC extends ComandosEscucha{
 /**
  * Termina la batalla con un NPC
  */
	@Override
	public void ejecutar() {
		 PaqueteFinalizarBatallaNPC paqueteFinalizarBatalla
	        = (PaqueteFinalizarBatallaNPC) gson.fromJson(cadenaLeida, PaqueteFinalizarBatallaNPC.class);
	        juego.getPersonaje().setEstado(Estado.estadoJuego);
	        juego.getNpcs().get(paqueteFinalizarBatalla.getIdEnemigo())
	                .setEstado(Estado.estadoJuego);
	        juego.actualizarEnemigo();
	        Estado.setEstado(juego.getEstadoJuego());
	}

}
