package comandos;

import estados.Estado;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatallaNPC;

public class BatallaNPC extends ComandosEscucha{
	/**
	 * Comienza la batalla con un NPC
	 */
	@Override
    public void ejecutar() { 
        PaqueteBatallaNPC paqueteBatalla = (PaqueteBatallaNPC) gson
        		.fromJson(cadenaLeida, PaqueteBatallaNPC.class);
        		
        juego.getPersonaje().setEstado(Estado.estadoBatallaNPC);
        Estado.setEstado(null);
        juego.getNpcs().get(paqueteBatalla.getIdEnemigo())
                .setEstado(Estado.estadoBatallaNPC);
        juego.setEstadoBatallaNPC(new EstadoBatallaNPC(juego, paqueteBatalla));
        Estado.setEstado(juego.getEstadoBatallaNPC());
    }
}
