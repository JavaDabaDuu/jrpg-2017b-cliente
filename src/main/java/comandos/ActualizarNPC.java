package comandos;

import mensajeria.PaqueteNPC;

public class ActualizarNPC extends ComandosEscucha{

	@Override
	 public void ejecutar() {
	  PaqueteNPC paqueteNpc = (PaqueteNPC) gson.fromJson(cadenaLeida, PaqueteNPC.class);

	  juego.getNpcs().remove(paqueteNpc.getId());
	  juego.getNpcs().add(paqueteNpc);
	  
	  if (juego.getPaqueteNpc().getId() == paqueteNpc.getId()) {
	   juego.actualizarPaqueteNpc();
	   juego.getEstadoJuego().actualizarNpc();
	   juego.getCliente().actualizarNPC(juego.getNpcs().get(paqueteNpc.getId()));
	  
	 }
	}	
}
