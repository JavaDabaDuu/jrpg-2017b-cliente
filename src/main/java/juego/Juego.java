package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.MiChat;
import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoBatallaNPC;
import estados.EstadoJuego;
import mensajeria.PaqueteDeNPCS;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaqueteNPC;
import mensajeria.PaquetePersonaje;

/**
 * The Class Juego.
 */
public class Juego implements Runnable {

  /** The pantalla. */
  private Pantalla pantalla;

  /** The nombre. */
  private final String nombre;

  /** The ancho. */
  private final int ancho;

  /** The alto. */
  private final int alto;

  /** The hilo. */
  private Thread hilo;

  /** The corriendo. */
  private boolean corriendo;

  // Estrategia para graficar mediante buffers
  // (Primero se "grafica" en el/los buffer/s y
  /** The bs. */
  // finalmente en el canvas)
  private BufferStrategy bs;

  /** The g. */
  private Graphics g;

  /** The estado juego. */
  // Estados
  private Estado estadoJuego;

  /** The estado batalla. */
  private Estado estadoBatalla;

  /** The estado batalla NPC. */
  private Estado estadoBatallaNPC;

  /** The handler mouse. */
  // HandlerMouse
  private HandlerMouse handlerMouse;

  /** The camara. */
  // Camara
  private Camara camara;

  /** The cliente. */
  // Conexion
  private Cliente cliente;

  /** The escucha mensajes. */
  private EscuchaMensajes escuchaMensajes;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The ubicacion personaje. */
  private PaqueteMovimiento ubicacionPersonaje;

  /** The ubicacion npc. */
  private PaqueteMovimiento ubicacionNpc;

  /** The personajes conectados. */
  private Map<Integer, PaquetePersonaje> personajesConectados;

  /** The ubicacion personajes. */
  private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;

  /** The npcs. */
  private HashMap<Integer, PaqueteNPC> npcs;

  /** The chats activos. */
  private Map<String, MiChat> chatsActivos = new HashMap<>();

  /** The paquete npc. */
  private PaqueteNPC paqueteNpc;

  /** The paquete de NPCS. */
  private PaqueteDeNPCS paqueteDeNPCS;

  /** The cargar recursos. */
  private CargarRecursos cargarRecursos;
  
  /** The noClipActivado. */
  private boolean noClipActivado = false;

  /** The Constant DIRECCION. */
  private static final int DIRECCION = 6;

  /** The Constant NUM_BUFFERS. */
  private static final int NUM_BUFFERS = 3;

  /** The Constant SIZE. */
  private static final int SIZE = 15;

  /** The Constant FPS. */
  private static final int FPS = 60;

  /** The Constant SEGUNDOS_EN_NANO. */
  private static final int SEGUNDOS_EN_NANO = 1_000_000_000;


  /**
   * Gets the paquete npc.
   *
   * @return the paquete npc
   */
  public PaqueteNPC getPaqueteNpc() {
    return paqueteNpc;
  }

  /**
  * Sets the paquete npc.
  *
  * @param paqueteNpcAux the new paquete npc
   */
  public void setPaqueteNpc(final PaqueteNPC paqueteNpcAux) {
    this.paqueteNpc = paqueteNpcAux;
  }

  /**
  * Instantiates a new juego.
  *
  * @param nombreAux the nombre
  * @param anchoAux the ancho
  * @param altoAux the alto
  * @param clienteAux the cliente
  * @param ppAux the pp
  */
  public Juego(final String nombreAux, final int anchoAux, final int altoAux,
  final Cliente clienteAux, final PaquetePersonaje ppAux) {
    this.nombre = nombreAux;
    this.alto = altoAux;
    this.ancho = anchoAux;
    this.cliente = clienteAux;
    this.paquetePersonaje = ppAux;
    this.paqueteDeNPCS = new PaqueteDeNPCS();

    // Inicializo la ubicacion del personaje
    ubicacionPersonaje = new PaqueteMovimiento();
    ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
    ubicacionPersonaje.setFrame(0);
    ubicacionPersonaje.setDireccion(DIRECCION);

    // Creo el escucha de mensajes
    escuchaMensajes = new EscuchaMensajes(this);
    escuchaMensajes.start();

    handlerMouse = new HandlerMouse();

    iniciar();

    cargarRecursos = new CargarRecursos(clienteAux);
    cargarRecursos.start();
  }

  /**
  * Iniciar.
  */
  public void iniciar() { // Carga lo necesario para iniciar el juego
    pantalla = new Pantalla(nombre, ancho, alto, cliente);
    pantalla.getCanvas().addMouseListener(handlerMouse);
    camara = new Camara(this, 0, 0);
    Personaje.cargarTablaNivel();
  }

  /**
   * Actualizar.
   */

  private void actualizar() { // Actualiza los objetos y sus posiciones

  if (Estado.getEstado() != null) {
    Estado.getEstado().actualizar();
   }
  }

  /**
  * Graficar.
  */
  private void graficar() { // Grafica los objetos y sus posiciones

    // COORDENADAS DEL PERSONAJE EN EL MAPA
    // System.out.println("X: " + ubicacionPersonaje.getPosX() + "Y: " +
    // ubicacionPersonaje.getPosY());

    bs = pantalla.getCanvas().getBufferStrategy();
    //Seteo una estrategia para el canvas en caso de que no tenga una
    if (bs == null) {
      pantalla.getCanvas().createBufferStrategy(NUM_BUFFERS);
      return;
    }

    g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

    g.clearRect(0, 0, ancho, alto); // Limpiamos la pantalla

    // Graficado de imagenes
    g.setFont(new Font("Book Antiqua", 1, SIZE));

    if (Estado.getEstado() != null) {
      Estado.getEstado().graficar(g);
    }

    // Fin de graficado de imagenes
    bs.show(); // Hace visible el próximo buffer disponible
    g.dispose();
  }

  /* (non-Javadoc)
  * @see java.lang.Runnable#run()
  */
  @Override
  public void run() { // Hilo principal del juego

    // Cantidad de nanosegundos en FPS deseados
    double tiempoPorActualizacion = SEGUNDOS_EN_NANO / FPS;
    double delta = 0;
    long ahora;
    long ultimoTiempo = System.nanoTime();
    long timer = 0; // Timer para mostrar fps cada un segundo

    // Cantidad de actualizaciones que se realizan realmente
    int actualizaciones = 0;

    while (corriendo) {
      ahora = System.nanoTime();

      // Calculo para determinar cuando realizar la actualizacion y el
      // graficado
      delta += (ahora - ultimoTiempo) / tiempoPorActualizacion;

      // Sumo el tiempo transcurrido hasta que se acumule 1 segundo y
      // mostrar los FPS
      timer += ahora - ultimoTiempo;

      ultimoTiempo = ahora; // Para las proximas corridas del bucle

      if (delta >= 1) {
        actualizar();
        graficar();
        actualizaciones++;
        delta--;
      }

      // Si paso 1 segundo muestro los FPS
      if (timer >= SEGUNDOS_EN_NANO) {
        pantalla.getFrame().setTitle(nombre + " | "
            + "FPS: " + actualizaciones);
        actualizaciones = 0;
        timer = 0;
      }
    }

    stop();
  }

  /**
  * Start.
   */
  public synchronized void start() { // Inicia el juego
    if (corriendo) {
      return;
     }

    estadoJuego = new EstadoJuego(this);
    Estado.setEstado(estadoJuego);
    pantalla.mostrar();
    corriendo = true;
    hilo = new Thread(this);
    hilo.start();
  }

  /**
   * Stop.
   */
  public synchronized void stop() { // Detiene el juego
    if (!corriendo) {
      return;
     }
     try {
       corriendo = false;
       hilo.join();
     } catch (InterruptedException e) {
       JOptionPane.showMessageDialog(null,
           "Fallo al intentar detener el juego.");
     }
  }

  /**
  * Gets the ancho.
  *
  * @return the ancho
  */
  public int getAncho() {
    return ancho;
   }

   /**
   * Gets the alto.
   *
   * @return the alto
   */
   public int getAlto() {
     return alto;
   }

  /**
  * Gets the handler mouse.
  *
  * @return the handler mouse
  */
  public HandlerMouse getHandlerMouse() {
    return handlerMouse;
  }

  /**
  * Gets the camara.
  *
  * @return the camara
  */
  public Camara getCamara() {
    return camara;
  }

  /**
  * Gets the estado juego.
  *
  * @return the estado juego
  */
  public EstadoJuego getEstadoJuego() {
    return (EstadoJuego) estadoJuego;
  }

  /**
  * Gets the estado batalla.
  *
  * @return the estado batalla
  */
  public EstadoBatalla getEstadoBatalla() {
    return (EstadoBatalla) estadoBatalla;
  }

  /**
  * Sets the estado batalla.
  *
  * @param estadoBatallaAux the new estado batalla
  */
  public void setEstadoBatalla(final EstadoBatalla estadoBatallaAux) {
    this.estadoBatalla = estadoBatallaAux;
  }

  /**
  * Gets the cliente.
  *
  * @return the cliente
  */
  public Cliente getCliente() {
    return cliente;
  }

  /**
  * Gets the escucha mensajes.
  *
  * @return the escucha mensajes
  */
  public EscuchaMensajes getEscuchaMensajes() {
    return escuchaMensajes;
  }

  /**
  * Gets the personaje.
  *
  * @return the personaje
  */
  public PaquetePersonaje getPersonaje() {
    return paquetePersonaje;
  }

  /**
  * Gets the ubicacion personaje.
  * @return the ubicacion personaje
  */
  public PaqueteMovimiento getUbicacionPersonaje() {
    return ubicacionPersonaje;
  }

  /**
  * Gets the ubicacion npc.
  *
  * @return the ubicacion npc
  */
  public PaqueteMovimiento getUbicacionNpc() {
    return ubicacionNpc;
  }

  /**
  * Sets the personaje.
  *
  * @param paquetePersonajeAux the new personaje
  */
  public void setPersonaje(final PaquetePersonaje paquetePersonajeAux) {
    this.paquetePersonaje = paquetePersonajeAux;
  }

  /**
  * Actualizar personaje.
  */
  public void actualizarPersonaje() {
    paquetePersonaje = (PaquetePersonaje) (personajesConectados
        .get(paquetePersonaje.getId()).clone());
  }

  /**
  * Gets the personajes conectados.
  *
  * @return the personajes conectados
  */
  public Map<Integer, PaquetePersonaje> getPersonajesConectados() {
    return personajesConectados;
  }

  /**
  * Sets the personajes conectados.
  *
  * @param map the map
  */
  public void setPersonajesConectados(
  final Map<Integer, PaquetePersonaje> map) {
    this.personajesConectados = map;
  }

  /**
  * Gets the ubicacion personajes.
  *
  * @return the ubicacion personajes
  */
  public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
    return ubicacionPersonajes;
  }

  /**
  * Sets the ubicacion personajes.
  *
  * @param ubicacionPersonajesAux the ubicacion personajes
  */
  public void setUbicacionPersonajes(
  final Map<Integer, PaqueteMovimiento> ubicacionPersonajesAux) {
    this.ubicacionPersonajes = ubicacionPersonajesAux;
  }

  /**
  * Gets the chats activos.
  *
  * @return the chats activos
  */
  public Map<String, MiChat> getChatsActivos() {
    return chatsActivos;
  }

  /**
  * Gets the npcs.
  *
  * @return the npcs
  */
  public HashMap<Integer, PaqueteNPC> getNpcs() {
    return npcs;
  }

  /**
  * Actualizar paquete npc.
  */
  public void actualizarPaqueteNpc() {
  paqueteNpc = (PaqueteNPC) (npcs.get(paqueteNpc.getId()).clone());
  }

  /**
  * Sets the npcs.
  *
  * @param npcs2 the npcs 2
  */
  public void setNpcs(final HashMap<Integer, PaqueteNPC> npcs2) {
    this.npcs = npcs2;
  }

  /**
  * Gets the paquete de NPCS.
  *
  * @return the paquete de NPCS
  */
  public PaqueteDeNPCS getPaqueteDeNPCS() {
    return paqueteDeNPCS;
  }

  /**
  * Sets the paquete de NPCS.
  *
  * @param paqueteDeNPCSAux the new paquete de NPCS
  */
  public void setPaqueteDeNPCS(final PaqueteDeNPCS paqueteDeNPCSAux) {
    this.paqueteDeNPCS = paqueteDeNPCSAux;
  }

  /**
  * Gets the estado batalla NPC.
  *
  * @return the estado batalla NPC
  */
  public Estado getEstadoBatallaNPC() {
    return estadoBatallaNPC;
  }

  /**
  * Sets the estado batalla NPC.
  *
  * @param estadoBatallaNPCAux the new estado batalla NPC
  */
  public void setEstadoBatallaNPC(final EstadoBatallaNPC estadoBatallaNPCAux) {
    this.estadoBatallaNPC = estadoBatallaNPCAux;
  }

  /**
  * Actualizar enemigo.
  */
  public void actualizarEnemigo() {
    this.paqueteNpc = (PaqueteNPC) (npcs.get(paqueteNpc.getId()).clone());
  }
  
  /**
   * Activar noclip.
   */
  public void activarNoClip() {
	  this.noClipActivado = true;
  }
  
  /**
   * Desactivar noclip.
   */
  public void desactivarNoClip() {
	  this.noClipActivado = false;
  }
  
  /**
   * Devuelve si esta o no activo el cheat noclip
   */
  public boolean estaNoClipActivado() {
	  return this.noClipActivado;
  }
}
