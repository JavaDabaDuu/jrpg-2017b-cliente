package comandos;

import estados.Estado;
import mensajeria.PaqueteNPC;

public class DesaparecerNPC extends ComandosEscucha {

  @Override
public void ejecutar() {
	  //Aca llega el npc que tiene que desaparecer
  PaqueteNPC paqueteNPC = (PaqueteNPC)
      getGson().fromJson(getCadenaLeida(), PaqueteNPC.class);
  getJuego().getNpcs().get(paqueteNPC.getId())
      .setEstado(Estado.getEstadoBatallaNPC());
   }
}
