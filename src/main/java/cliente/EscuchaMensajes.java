package cliente;

import com.google.gson.Gson;
import comandos.ComandosEscucha;

import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.swing.JOptionPane;

import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaqueteNPC;
import mensajeria.PaquetePersonaje;

/**La clase EscuchaMensajes tiene como función
 * esuchar los mensajes que se enviaran
 * al servidor.
 */

public class EscuchaMensajes extends Thread {

  /** The juego. */
  private Juego juego;

  /** The cliente. */
  private Cliente cliente;

  /** The entrada. */
  private ObjectInputStream entrada;

  /** The gson. */
  private final Gson gson = new Gson();

  /**
   * Constructor de EsuchaMensaje.
   *
   * @param juegoAux juego del que se escucha el mensaje
   */

  public EscuchaMensajes(final Juego juegoAux) {
    this.juego = juegoAux;
    cliente = juegoAux.getCliente();
    entrada = cliente.getEntrada();
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {

    try {

      Paquete paquete;
      ComandosEscucha comand;
      juego.setPersonajesConectados(new HashMap<Integer, PaquetePersonaje>());
      juego.setUbicacionPersonajes(new HashMap<Integer, PaqueteMovimiento>());
      juego.setNpcs(new HashMap<Integer, PaqueteNPC>());

      while (true) {
        String objetoLeido = (String) entrada.readObject();

        paquete = gson.fromJson(objetoLeido, Paquete.class);
        comand = (ComandosEscucha) paquete.getObjeto(Comando.NOMBREPAQUETE);
        comand.setJuego(juego);
        comand.setCadena(objetoLeido);

        comand.ejecutar();

      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
    }
  }
  /**Pide la ubicacion de los personajes
* @return devuelve el mapa con la ubicacion de los personajes
*/

  /**Pide los personajes conectados
* @return devuelve el mapa con los personajes conectados
*/

}
