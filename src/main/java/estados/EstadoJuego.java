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

  /**
   * Instantiates a new estado juego.
   *
   * @param juego the juego
   */
  public EstadoJuego(final Juego juego) {
    super(juego);
    mundos.put(1, "Aubenor");
    mundos.put(2, "Aris");
    mundos.put(3, "Eodrim");
    mundo = new Mundo(juego, "recursos/" + getMundo()
        + ".txt", "recursos/" + getMundo() + ".txt");
    paquetePersonaje = juego.getPersonaje();
    entidadPersonaje = new Entidad(juego, mundo, 64, 64,
        juego.getPersonaje().getNombre(), 0, 0,
        Recursos.getPersonaje().get(juego.getPersonaje().getRaza()), 150);
    miniaturaPersonaje = Recursos.getPersonaje()
        .get(paquetePersonaje.getRaza()).get(5)[0];

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
    EstadoDePersonaje.dibujarEstadoDePersonaje(g, 5, 5,
        paquetePersonaje, miniaturaPersonaje);
    g.drawImage(Recursos.getMochila(), 738, 545, 59, 52, null);
    g.drawImage(Recursos.getMenu(), 3, 562, 102, 35, null);
    g.drawImage(Recursos.getChat(), 3, 524, 102, 35, null);
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
      g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
      while (it.hasNext()) {
        key = it.next();
        actual = ubicacionPersonajes.get(key);
        if (actual != null && actual.getIdPersonaje()
        != getJuego().getPersonaje().getId()
        && personajesConectados.get(actual.getIdPersonaje()).getEstado()
        == Estado.getEstadoJuego()) {

          Pantalla.centerString(g,
              new Rectangle((int) (actual.getPosX()
              - getJuego().getCamara().getxOffset() + 32),
              (int) (actual.getPosY() - getJuego().getCamara().getyOffset()
              - 20), 0, 10),
          personajesConectados.get(actual.getIdPersonaje()).getNombre());
          g.drawImage(
          Recursos.getPersonaje().get(personajesConectados
              .get(actual.getIdPersonaje()).getRaza())
              .get(actual.getDireccion())[actual.getFrame()],
              (int) (actual.getPosX() - getJuego().getCamara().getxOffset()),
              (int) (actual.getPosY() - getJuego().getCamara()
                  .getyOffset()), 64, 64, null);
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
    menuEnemigo = new MenuInfoPersonaje(300, 50, enemigo);
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
      g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));

      for (int i = 0; i < this.npcs.size(); i++) {
        g.drawImage(Recursos.getPersonaje().get("Minotauro")
            .get(6)[0], (int) (npcs.get(i).getPosX()
            - getJuego().getCamara().getxOffset()),
            (int) (npcs.get(i).getPosY()
            - getJuego().getCamara().getyOffset()), 64, 64, null);
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
