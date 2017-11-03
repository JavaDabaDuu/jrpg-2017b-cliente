package cliente;

import com.google.gson.Gson;

import comandos.ComandosCliente;
import frames.MenuCarga;
import frames.MenuComerciar;
import frames.MenuJugar;
import frames.MenuMapas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

import juego.Juego;

import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteMensaje;
import mensajeria.PaqueteNPC;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

/**La clase Cliente tiene como función
 * ejecutar el cliente.
 */
public class Cliente extends Thread {

  /** The cliente. */
  private Socket cliente;

  /** The mi ip. */
  private String miIp;

  /** The entrada. */
  private ObjectInputStream entrada;

  /** The salida. */
  private ObjectOutputStream salida;

  /** The gson. */
  // Objeto gson
  private final Gson gson = new Gson();

  /** The paquete usuario. */
  // Paquete usuario y paquete personaje
  private PaqueteUsuario paqueteUsuario;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The paquete comercio. */
  private PaqueteComerciar paqueteComercio;

  /** The paquete mensaje. */
  private PaqueteMensaje paqueteMensaje = new PaqueteMensaje();

  /** The paquete NPC. */
  private PaqueteNPC paqueteNPC;

  /** The accion. */
  // Acciones que realiza el usuario
  private int accion;

  /** The m 1. */
  //MENU COMERCIAR
  private MenuComerciar m1;

  /** The propiedades. */
  // Archivo de propiedades
  private Properties propiedades;

  /** The ip. */
  // Ip y puerto
  private String ip;

  /** The puerto. */
  private int puerto;

  /** The Constant ANCHO_JUEGO. */
  private static final int ANCHO_JUEGO = 800;

  /** The Constant ALTO_JUEGO. */
  private static final int ALTO_JUEGO = 600;


  /**
   * Pide la accion.
   *
   * @return Devuelve la accion
   */

  public int getAccion() {
    return accion;
  }

  /**
   * Setea la accion.
   *
   * @param accionAux accion a setear
   */

  public void setAccion(final int accionAux) {
    this.accion = accionAux;
  }

  /** The wome. */
  private Juego wome;

  /** The menu carga. */
  private MenuCarga menuCarga;

  /**
   * Constructor del Cliente.
   */
  public Cliente() {

    try {
      obtenerPuerto();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null,
          "Error al abrir puerto. Revise archivo de propiedades.");
      System.exit(1);
    }

    ip = JOptionPane.showInputDialog(
        "Ingrese IP del servidor: (default localhost)");
    if (ip == null) {
      ip = "localhost";
    }
    try {
      cliente = new Socket(ip, puerto);
      miIp = cliente.getInetAddress().getHostAddress();
      entrada = new ObjectInputStream(cliente.getInputStream());
      salida = new ObjectOutputStream(cliente.getOutputStream());
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Fallo al iniciar la aplicación. "
          + "Revise la conexión con el servidor.");
      System.exit(1);
    }
  }

  /**
   * Obtener puerto.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void obtenerPuerto() throws IOException {
    propiedades = new Properties();
    InputStream input = new FileInputStream("configCliente.properties");
    propiedades.load(input);
    puerto = Integer.parseInt(propiedades.getProperty("puerto"));
    input.close();
  }

  /**
   * Instantiates a new cliente.
   *
   * @param ipAux the ip
   * @param puertoAux the puerto
   */
  public Cliente(final String ipAux, final int puertoAux) {
    try {
      cliente = new Socket(ipAux, puertoAux);
      miIp = cliente.getInetAddress().getHostAddress();
      entrada = new ObjectInputStream(cliente.getInputStream());
      salida = new ObjectOutputStream(cliente.getOutputStream());
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Fallo al iniciar la aplicación. "
          + "Revise la conexión con el servidor.");
      System.exit(1);
    }
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {
    synchronized (this) {
      try {
        ComandosCliente comand;
        // Creo el paquete que le voy a enviar al servidor
        paqueteUsuario = new PaqueteUsuario();
        MenuJugar menuJugar = null;
        while (!paqueteUsuario.isInicioSesion()) {

          // Muestro el menú principal
          if (menuJugar == null) {
            menuJugar = new MenuJugar(this);
            menuJugar.setVisible(true);

            // Creo los paquetes que le voy a enviar al servidor
            paqueteUsuario = new PaqueteUsuario();
            paquetePersonaje = new PaquetePersonaje();

            // Espero a que el usuario seleccione alguna accion
            wait();

            comand = (ComandosCliente) Paquete
                .getObjetoSet(Comando.NOMBREPAQUETE, getAccion());
            comand.setCadena(null);
            comand.setCliente(this);
            comand.ejecutar();

            // Le envio el paquete al servidor
            salida.writeObject(gson.toJson(paqueteUsuario));
          }
          // Recibo el paquete desde el servidor
          String cadenaLeida = (String) entrada.readObject();
          Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);

          comand = (ComandosCliente) paquete.getObjeto(Comando.NOMBREPAQUETE);
          comand.setCadena(cadenaLeida);
          comand.setCliente(this);
          comand.ejecutar();
        }


        // Creo un paquete con el comando mostrar mapas
        paquetePersonaje.setComando(Comando.MOSTRARMAPAS);

        // Abro el menu de eleccion del mapa
        MenuMapas menuElegirMapa = new MenuMapas(this);
        menuElegirMapa.setVisible(true);

        // Espero a que el usuario elija el mapa
        wait();

        //Si clickeo en la Cruz al Seleccionar mapas
        if (paquetePersonaje.getMapa() == 0) {
          paquetePersonaje.setComando(Comando.DESCONECTAR);
          salida.writeObject(gson.toJson(paquetePersonaje));
        } else {
          // Establezco el mapa en el paquete personaje
          paquetePersonaje.setIp(miIp);

          // Le envio el paquete con el mapa seleccionado
          salida.writeObject(gson.toJson(paquetePersonaje));

          // Instancio el juego y cargo los recursos
          wome = new Juego("World Of the Middle Earth", ANCHO_JUEGO,
              ALTO_JUEGO, this, paquetePersonaje);

          // Muestro el menu de carga
          menuCarga = new MenuCarga(this);
          menuCarga.setVisible(true);


          // Espero que se carguen todos los recursos
          wait();

          // Inicio el juego
          wome.start();

          // Finalizo el menu de carga
          menuCarga.dispose();
        }
      } catch (IOException | InterruptedException | ClassNotFoundException
      | InstantiationException | IllegalAccessException e) {
        JOptionPane.showMessageDialog(null,
            "Fallo la conexión con el servidor durante el inicio de sesión.");
        System.exit(1);
      }
    }

  }

  /**
   * Pide el cliente.
   * @return Devuelve el cliente.
   *
   */

  public Socket getSocket() {
    return cliente;
  }

 /**
  * Setea el cliente.
  *
  * @param clienteAux cliente a setear
  */

  public void setSocket(final Socket clienteAux) {
    this.cliente = clienteAux;
  }

 /**
  * Pide la ip.
  *
  * @return Devuelve la ip
  */

  public String getMiIp() {
    return miIp;
  }

 /**
  * Setea la ip.
  *
  * @param miIpAux ip a setear
  */

  public void setMiIp(final String miIpAux) {
    this.miIp = miIpAux;
  }

 /**
  * Pide la entrada.
  *
  * @return Devuelve la entrada
  */

  public ObjectInputStream getEntrada() {
    return entrada;
  }

  /**
   * Setea la entrada.
   *
   * @param entradaAux entrada a setear
   */

  public void setEntrada(final ObjectInputStream entradaAux) {
    this.entrada = entradaAux;
  }

 /**
  * Pide la salida.
  *
  * @return Devuelve la salida
  */

  public ObjectOutputStream getSalida() {
    return salida;
  }

 /**
  * Setea la salida.
  *
  * @param salidaAux salida a setear
  */

  public void setSalida(final ObjectOutputStream salidaAux) {
    this.salida = salidaAux;
  }

 /**
  * Pide el paquete usuario.
  *
  * @return Devuelve el paquete usuario
  */

  public PaqueteUsuario getPaqueteUsuario() {
    return paqueteUsuario;
  }

 /**
  * Pide el paquete personaje.
  *
  * @return Devuelve el paquete personaje
  */

  public PaquetePersonaje getPaquetePersonaje() {
    return paquetePersonaje;
  }

 /**
  * Pide el juego.
  *
  * @return Devuelve el juego
  */

  public Juego getJuego() {
    return wome;
  }

 /**
  * Pide el menu de carga.
  *
  * @return Devuelve el menu de carga
  */

  public MenuCarga getMenuCarga() {
    return menuCarga;
  }

  /**
   * Actualizar items.
   *
   * @param paqueteActualizadoAux the paquete actualizado
   */
  public void actualizarItems(final PaquetePersonaje paqueteActualizadoAux) {
    if (paquetePersonaje.getCantItems() != 0
    && paquetePersonaje.getCantItems()
        != paqueteActualizadoAux.getCantItems()) {
      paquetePersonaje.anadirItem(paqueteActualizadoAux.getItems()
          .get(paqueteActualizadoAux.getItems().size() - 1));
    }
  }

  /**
   * Gets the ip.
   *
   * @return the ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * Actualizar personaje.
   *
   * @param ppAux the p P
   */
  public void actualizarPersonaje(final PaquetePersonaje ppAux) {
    paquetePersonaje = ppAux;
  }

  /**
   * Gets the wome.
   *
   * @return the wome
   */
  public Juego getWome() {
    return wome;
  }

  /**
   * Sets the wome.
   *
   * @param womeAux the new wome
   */
  public void setWome(final Juego womeAux) {
    this.wome = womeAux;
  }

  /**
   * Gets the puerto.
   *
   * @return the puerto
   */
  public int getPuerto() {
    return puerto;
  }

  /**
   * Sets the paquete usuario.
   *
   * @param paqueteUsuarioAux the new paquete usuario
   */
  public void setPaqueteUsuario(final PaqueteUsuario paqueteUsuarioAux) {
    this.paqueteUsuario = paqueteUsuarioAux;
  }

  /**
   * Sets the paquete personaje.
   *
   * @param paquetePersonajeAux the new paquete personaje
   */
  public void setPaquetePersonaje(final PaquetePersonaje paquetePersonajeAux) {
    this.paquetePersonaje = paquetePersonajeAux;
  }

  /**
   * Sets the ip.
   *
   * @param ipAux the new ip
   */
  public void setIp(final String ipAux) {
    this.ip = ipAux;
  }

  /**
   * Sets the menu carga.
   *
   * @param menuCargaAux the new menu carga
   */
  public void setMenuCarga(final MenuCarga menuCargaAux) {
    this.menuCarga = menuCargaAux;
  }

  /**
   * Gets the m1.
   *
   * @return the m1
   */
  public MenuComerciar getM1() {
    return m1;
  }

  /**
   * Sets the m1.
   *
   * @param m1Aux the new m1
   */
  public void setM1(final MenuComerciar m1Aux) {
    this.m1 = m1Aux;
  }

  /**
   * Gets the paquete comercio.
   *
   * @return the paquete comercio
   */
  public PaqueteComerciar getPaqueteComercio() {
    return paqueteComercio;
  }

  /**
   * Sets the paquete comercio.
   *
   * @param paqueteComercioAux the new paquete comercio
   */
  public void setPaqueteComercio(final PaqueteComerciar paqueteComercioAux) {
    this.paqueteComercio = paqueteComercioAux;
  }

  /**
   * Gets the paquete mensaje.
   *
   * @return the paquete mensaje
   */
  public PaqueteMensaje getPaqueteMensaje() {
    return paqueteMensaje;
  }

  /**
   * Sets the paquete mensaje.
   *
   * @param paqueteMensajeAux the new paquete mensaje
   */
  public void setPaqueteMensaje(final PaqueteMensaje paqueteMensajeAux) {
    this.paqueteMensaje = paqueteMensajeAux;
  }

  /**
   * Actualizar NPC.
   *
   * @param paquetenpcAux the paquetenpc
   */
  public void actualizarNPC(final PaqueteNPC paquetenpcAux) {
    this.paqueteNPC = paquetenpcAux;
  }
}
