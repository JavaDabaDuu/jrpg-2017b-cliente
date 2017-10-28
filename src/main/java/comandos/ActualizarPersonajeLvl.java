package comandos;

import frames.MenuStats;
import mensajeria.PaquetePersonaje;

public class ActualizarPersonajeLvl extends ComandosEscucha {
 
  private MenuStats menuStats;
    
  @Override
  public void ejecutar() {
    PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
        .fromJson(cadenaLeida, PaquetePersonaje.class);
    juego.getPersonajesConectados().remove(paquetePersonaje.getId());
    juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);
    
    if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
      juego.actualizarPersonaje();
      juego.getEstadoJuego().actualizarPersonaje();
      juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados()
          .get(paquetePersonaje.getId()));
    }

  }

}
