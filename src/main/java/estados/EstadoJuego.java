
package estados;

import com.google.gson.Gson;

import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoPersonaje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteDeNPCS;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaqueteNPC;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoJuego.
 */
public class EstadoJuego extends Estado {

  /** The entidad personaje. */
  private Entidad entidadPersonaje;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The paquete NPC. */
  private PaqueteNPC paqueteNPC;

  /** The mundo. */
  private Mundo mundo;

  /** The ubicacion personajes. */
  private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;

  /** The personajes conectados. */
  private Map<Integer, PaquetePersonaje> personajesConectados;

  /** The npcs. */
  private HashMap<Integer, PaqueteNPC> npcs;

  /** The ubicacion npcs. */
  private Map<Integer, PaqueteMovimiento> ubicacionNpcs;

  /** The mundos. */
  private HashMap<Integer, String> mundos = new HashMap<Integer, String>();

  /** The hay solicitud. */
  private boolean haySolicitud;

  /** The tipo solicitud. */
  private int tipoSolicitud;

  /** The gson. */
  private final Gson gson = new Gson();

  /** The miniatura personaje. */
  private BufferedImage miniaturaPersonaje;

  /** The menu enemigo. */
  private MenuInfoPersonaje menuEnemigo;

  /** The Constant MUNDO_1. */
  private static final int MUNDO_1 = 1;

  /** The Constant MUNDO_2. */
  private static final int MUNDO_2 = 2;

  /** The Constant MUNDO_3. */
  private static final int MUNDO_3 = 3;

  /** The Constant ANCHO_AUX. */
  private static final int ANCHO_AUX = 64;

  /** The Constant ALTO_AUX. */
  private static final int ALTO_AUX = 64;

  /** The Constant VEL_ANIMACION_AUX. */
  private static final int VEL_ANIMACION_AUX = 150;

  /** The Constant X_ESTADO_PERSONAJE. */
  private static final int X_ESTADO_PERSONAJE = 5;

  /** The Constant Y_ESTADO_PERSONAJE. */
  private static final int Y_ESTADO_PERSONAJE = 5;

  /** The Constant PERSONAJE. */
  private static final int PERSONAJE = 5;

  /** The Constant WIDTH_MOCHILA. */
  private static final int WIDTH_MOCHILA = 59;

  /** The Constant HEIGHT_MOCHILA. */
  private static final int HEIGHT_MOCHILA = 52;

  /** The Constant X_MOCHILA. */
  private static final int X_MOCHILA = 738;

  /** The Constant Y_MOCHILA. */
  private static final int Y_MOCHILA = 545;

  /** The Constant WIDTH_MENU. */
  private static final int WIDTH_MENU = 102;

  /** The Constant HEIGHT_MENU. */
  private static final int HEIGHT_MENU = 35;

  /** The Constant X_MENU. */
  private static final int X_MENU = 3;

  /** The Constant Y_MENU. */
  private static final int Y_MENU = 562;

  /** The Constant X_CHAT. */
  private static final int X_CHAT = 3;

  /** The Constant Y_CHAT. */
  private static final int Y_CHAT = 524;

  /** The Constant WIDTH_CHAT. */
  private static final int WIDTH_CHAT = 102;

  /** The Constant HEIGHT_CHAT. */
  private static final int HEIGHT_CHAT = 35;

  /** The Constant SIZE. */
  private static final int SIZE = 15;

  /** The Constant WIDTH_CONECTADOS. */
  private static final int WIDTH_CONECTADOS = 64;

  /** The Constant HEIGHT_CONECTADOS. */
  private static final int HEIGHT_CONECTADOS = 64;

  /** The Constant WIDTH_MINOTAURO. */
  private static final int WIDTH_MINOTAURO = 64;

  /** The Constant HEIGHT_MINOTAURO. */
  private static final int HEIGHT_MINOTAURO = 64;

  /** The Constant X_OFFSET. */
  private static final int X_OFFSET = 32;

  /** The Constant Y_OFFSET. */
  private static final int Y_OFFSET = 20;

  /** The Constant WIDTH_RECTANGULO. */
  private static final int WIDTH_RECTANGULO = 0;

  /** The Constant HEIGHT_RECTANGULO. */
  private static final int HEIGHT_RECTANGULO = 10;

  /** The Constant X_MENU_ENEMIGO. */
  private static final int X_MENU_ENEMIGO = 300;

  /** The Constant Y_MENU_ENEMIGO. */
  private static final int Y_MENU_ENEMIGO = 50;

  /** The Constant IMAGEN_6. */
  private static final int IMAGEN_6 = 6;


  /**
   * Instantiates a new estado juego.
   *
   * @param juego the juego
   */
  public EstadoJuego(final Juego juego) {
    super(juego);
    mundos.put(MUNDO_1, "Aubenor");
    mundos.put(MUNDO_2, "Aris");
    mundos.put(MUNDO_3, "Eodrim");
    mundo = new Mundo(juego, "recursos/" + getMundo()
        + ".txt", "recursos/" + getMundo() + ".txt");
    paquetePersonaje = juego.getPersonaje();
    entidadPersonaje = new Entidad(juego, mundo, ANCHO_AUX, ALTO_AUX,
        juego.getPersonaje().getNombre(), 0, 0,
        Recursos.getPersonaje().get(juego.getPersonaje().getRaza()),
        VEL_ANIMACION_AUX);
    miniaturaPersonaje = Recursos.getPersonaje()
        .get(paquetePersonaje.getRaza()).get(PERSONAJE)[0];

    try {
      // Le envio al servidor que me conecte al mapa y mi posicion
      juego.getPersonaje().setComando(Comando.CONEXION);
      juego.getPersonaje().setEstado(Estado.getEstadoJuego());
      juego.getCliente().getSalida().writeObject(
          gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
      juego.getCliente().getSalida().writeObject(
          gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
      juego.getPaqueteDeNPCS().setComando(Comando.SETEARNPC);
      juego.getCliente().getSalida().writeObject(
          gson.toJson(juego.getPaqueteDeNPCS(), PaqueteDeNPCS.class));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null,
          "Fallo la conexión con el servidor al ingresar al mundo");
    }
  }

  /* (non-Javadoc)
   * @see estados.Estado#actualizar()
   */
  @Override
public void actualizar() {
    mundo.actualizar();
    entidadPersonaje.actualizar();
  }

  /* (non-Javadoc)
   * @see estados.Estado#graficar(java.awt.Graphics)
   */
  @Override
public void graficar(final Graphics g) {
    g.drawImage(Recursos.getBackground(), 0, 0,
        getJuego().getAncho(), getJuego().getAlto(), null);
    mundo.graficar(g);
    entidadPersonaje.graficar(g);
    graficarPersonajes(g);
    graficarNPC(g);
    mundo.graficarObstaculos(g);
    entidadPersonaje.graficarNombre(g);
    g.drawImage(Recursos.getMarco(), 0, 0,
        getJuego().getAncho(), getJuego().getAlto(), null);
    EstadoDePersonaje.dibujarEstadoDePersonaje(
    g, X_ESTADO_PERSONAJE, Y_ESTADO_PERSONAJE,
        paquetePersonaje, miniaturaPersonaje);
    g.drawImage(Recursos.getMochila(),
    X_MOCHILA, Y_MOCHILA, WIDTH_MOCHILA, HEIGHT_MOCHILA, null);
    g.drawImage(Recursos.getMenu(),
    X_MENU, Y_MENU, WIDTH_MENU, HEIGHT_MENU, null);
    g.drawImage(Recursos.getChat(),
    X_CHAT, Y_CHAT, WIDTH_CHAT, HEIGHT_CHAT, null);
    if (haySolicitud) {
      menuEnemigo.graficar(g, tipoSolicitud);
    }

  }

  /**
   * Graficar personajes.
   *
   * @param g the g
   */
  public void graficarPersonajes(final Graphics g) {
    if (getJuego().getPersonajesConectados() != null) {
      personajesConectados = new HashMap(getJuego().getPersonajesConectados());
      ubicacionPersonajes = new HashMap(getJuego().getUbicacionPersonajes());

      Iterator<Integer> it = personajesConectados.keySet().iterator();
      int key;
      
      PaqueteMovimiento actual;
      
      g.setColor(Color.WHITE);
      g.setFont(new Font("Book Antiqua", Font.PLAIN, SIZE));
      while (it.hasNext()) {
        key = it.next();
        actual = ubicacionPersonajes.get(key);
        
        boolean soyInvisible = paquetePersonaje.getInvisibilidad();
        //boolean soyInvisible = personajesConectados.get(juego.getPersonaje().getId()).esInvisible();
        boolean actualVisible= !personajesConectados.get(actual.getIdPersonaje()).getInvisibilidad();
        
        if (actual != null && actual.getIdPersonaje()
        != getJuego().getPersonaje().getId()
        && personajesConectados.get(actual.getIdPersonaje()).getEstado()
        == Estado.getEstadoJuego() 
        && (soyInvisible || actualVisible) ) {

          Pantalla.centerString(g,
              new Rectangle((int) (actual.getPosX()
              - getJuego().getCamara().getxOffset() + X_OFFSET),
              (int) (actual.getPosY() - getJuego().getCamara().getyOffset()
              - Y_OFFSET), WIDTH_RECTANGULO, HEIGHT_RECTANGULO),
          personajesConectados.get(actual.getIdPersonaje()).getNombre());
          g.drawImage(
          Recursos.getPersonaje().get(personajesConectados
              .get(actual.getIdPersonaje()).getRaza())
              .get(actual.getDireccion())[actual.getFrame()],
              (int) (actual.getPosX() - getJuego().getCamara().getxOffset()),
              (int) (actual.getPosY() - getJuego().getCamara()
                  .getyOffset()), WIDTH_CONECTADOS, HEIGHT_CONECTADOS, null);
        }
      }
    }
  }

  /**
   * Gets the personaje.
   *
   * @return the personaje
   */
  public Entidad getPersonaje() {
    return entidadPersonaje;
  }

  /**
   * Gets the mundo.
   *
   * @return the mundo
   */
  private String getMundo() {
    // mundo = juego.getPersonaje().getMapa()
    return this.mundos.get(getJuego().getPersonaje().getMapa());
  }


  /**
   * Sets the hay solicitud.
   *
   * @param b the b
   * @param enemigo the enemigo
   * @param tipoSolicitudAux the tipo solicitud
   */
  public void setHaySolicitud(
  final boolean b, final PaquetePersonaje enemigo, final int tipoSolicitudAux) {
    haySolicitud = b;
    // menu que mostrara al enemigo
    menuEnemigo = new MenuInfoPersonaje(
    X_MENU_ENEMIGO, Y_MENU_ENEMIGO, enemigo);
    this.tipoSolicitud = tipoSolicitudAux;
  }

  /**
   * Gets the hay solicitud.
   *
   * @return the hay solicitud
   */
  public boolean getHaySolicitud() {
    return haySolicitud;
  }

  /**
   * Actualizar personaje.
   */
  public void actualizarPersonaje() {
    paquetePersonaje = getJuego().getPersonaje();
  }

  /**
   * Gets the menu enemigo.
   *
   * @return the menu enemigo
   */
  public MenuInfoPersonaje getMenuEnemigo() {
    return menuEnemigo;
  }

  /**
   * Gets the tipo solicitud.
   *
   * @return the tipo solicitud
   */
  public int getTipoSolicitud() {
    return tipoSolicitud;
  }

  /* (non-Javadoc)
   * @see estados.Estado#esEstadoDeJuego()
   */
  @Override
public boolean esEstadoDeJuego() {
    return true;
}

  /**
   * Graficar NPC.
   *
   * @param g the g
   */
  private void graficarNPC(final Graphics g) {
	  
    if (getJuego().getNpcs() != null) {
      npcs = new HashMap<Integer, PaqueteNPC>();
      npcs = getJuego().getNpcs();
      g.setColor(Color.WHITE);
      g.setFont(new Font("Book Antiqua", Font.PLAIN, SIZE));

      for (int i = 0; i < this.npcs.size(); i++) {
    	  if(npcs.get(i).getEstado() == getEstadoJuego()){
        g.drawImage(Recursos.getPersonaje().get("Minotauro")
            .get(IMAGEN_6)[0], (int) (npcs.get(i).getPosX()
            - getJuego().getCamara().getxOffset()),
            (int) (npcs.get(i).getPosY()
            - getJuego().getCamara().getyOffset()),
            WIDTH_MINOTAURO, HEIGHT_MINOTAURO, null);
    	  }
    }
    }
  }

  /**
   * Actualizar npc.
   */
  public void actualizarNpc() {
    paqueteNPC = getJuego().getPaqueteNpc();
  }
}
