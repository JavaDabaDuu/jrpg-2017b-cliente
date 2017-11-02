package comandos;

import mensajeria.PaqueteDeNPCS;

public class SetearNPC extends ComandosEscucha {

  @Override
  public void ejecutar() {
    PaqueteDeNPCS paquete = (PaqueteDeNPCS)gson
        .fromJson(cadenaLeida,  PaqueteDeNPCS.class);
    juego.setNpcs(paquete.getNpcs());
   
  }

}
