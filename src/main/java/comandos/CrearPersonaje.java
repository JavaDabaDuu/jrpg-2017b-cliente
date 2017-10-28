package comandos;

import mensajeria.PaquetePersonaje;

public class CrearPersonaje extends ComandosCliente {

  @Override
  public void ejecutar() {
    cliente.setPaquetePersonaje((PaquetePersonaje) gson
         .fromJson(cadenaLeida, PaquetePersonaje.class)); 
    cliente.getPaqueteUsuario().setInicioSesion(true);
  }

}
