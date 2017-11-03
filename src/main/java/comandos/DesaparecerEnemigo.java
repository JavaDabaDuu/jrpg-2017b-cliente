package comandos;

import estados.Estado;
import mensajeria.PaqueteNPC;

public class DesaparecerEnemigo extends ComandosEscucha {
	
	 @Override
	 public void ejecutar() {
	 PaqueteNPC paqueteNPC = (PaqueteNPC) 
	 	getGson().fromJson(getCadenaLeida(), PaqueteNPC.class);
	 	getJuego().getNpcs().get(paqueteNPC.getId()).setEstado(Estado.getEstadoBatallaNPC());
	 }
	 
	 
}
