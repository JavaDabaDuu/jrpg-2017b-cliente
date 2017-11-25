
package estados;

import com.google.gson.Gson;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import dominio.Personaje;
import interfaz.EstadoDePersonaje;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatalla.
 */
public class EstadoBatalla extends Estado {

  /** The mundo. */
  private Mundo mundo;

  /** The personaje. */
  private Personaje personaje;

  /** The enemigo. */
  private Personaje enemigo;

  /** The pos mouse. */
  private int[] posMouse;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The paquete enemigo. */
  private PaquetePersonaje paqueteEnemigo;

  /** The paquete atacar. */
  private PaqueteAtacar paqueteAtacar;

  /** The paquete finalizar batalla. */
  private PaqueteFinalizarBatalla paqueteFinalizarBatalla;

  /** The mi turno. */
  private boolean miTurno;

  /** The hay spell seleccionada. */
  private boolean haySpellSeleccionada;

  /** The se realizo accion. */
  private boolean seRealizoAccion;

  /** The gson. */
  private Gson gson = new Gson();

  /** The miniatura personaje. */
  private BufferedImage miniaturaPersonaje;

  /** The miniatura enemigo. */
  private BufferedImage miniaturaEnemigo;

  /** The menu batalla. */
  private MenuBatalla menuBatalla;

  /** The nivel personaje. */
  private int nivelPersonaje;

  /** The nivel enemigo. */
  private int nivelEnemigo;

  /** The Constant UNO. */
  private static final int UNO = 1;

  /** The Constant DOS. */
  private static final int DOS = 2;

  /** The Constant TRES. */
  private static final int TRES = 3;

  /** The Constant CUATRO. */
  private static final int CUATRO = 4;

  /** The Constant CINCO. */
  private static final int CINCO = 5;

  /** The Constant SEIS. */
  private static final int SEIS = 6;

  /** The Constant XOFFSET. */
  private static final int XOFFSET = -350;

  /** The Constant YOFFSET. */
  private static final int YOFFSET = 150;

  /** The Constant PERSONAJE. */
  private static final int PERSONAJE = 5;

  /** The Constant VALOR. */
  private static final int VALOR = 10;

  /** The Constant EXPERIENCIA. */
  private static final int EXPERIENCIA = 40;

  /** The Constant WIDTH. */
  private static final int WIDTH = 256;

  /** The Constant HEIGHT. */
  private static final int HEIGHT = 256;

  /** The Constant X_PERSONAJE. */
  private static final int X_PERSONAJE = 0;

  /** The Constant Y_PERSONAJE. */
  private static final int Y_PERSONAJE = 170;

  /** The Constant X_ENEMIGO. */
  private static final int X_ENEMIGO = 550;

  /** The Constant Y_ENEMIGO. */
  private static final int Y_ENEMIGO = 75;

  /** The Constant IMAGEN_1. */
  private static final int IMAGEN_1 = 3;

  /** The Constant IMAGEN_2. */
  private static final int IMAGEN_2 = 7;

  /** The Constant X_ESTADO_PERSONAJE. */
  private static final int X_ESTADO_PERSONAJE = 25;

  /** The Constant Y_ESTADO_PERSONAJE. */
  private static final int Y_ESTADO_PERSONAJE = 5;

  /** The Constant X_ESTADO_ENEMIGO. */
  private static final int X_ESTADO_ENEMIGO = 550;

  /** The Constant Y_ESTADO_ENEMIGO. */
  private static final int Y_ESTADO_ENEMIGO = 5;

 private static final int ENERGIA_MINIMA = 10;

  /**
   * Instantiates a new estado batalla.
   *
   * @param juegoAux the juego
   * @param paqueteBatallaAux the paquete batalla
   */
  public EstadoBatalla(final Juego juegoAux,
      final PaqueteBatalla paqueteBatallaAux) {
    super(juegoAux);
    mundo = new Mundo(juegoAux, "recursos/mundoBatalla.txt",
        "recursos/mundoBatallaCapaDos.txt");
    miTurno = paqueteBatallaAux.isMiTurno();

    paquetePersonaje = juegoAux.getPersonajesConectados()
        .get(paqueteBatallaAux.getId());
    paqueteEnemigo = juegoAux.getPersonajesConectados()
        .get(paqueteBatallaAux.getIdEnemigo());

    crearPersonajes();
    menuBatalla = new MenuBatalla(miTurno, personaje);

    miniaturaEnemigo = Recursos.getPersonaje()
        .get(enemigo.getNombreRaza()).get(PERSONAJE)[0];
    miniaturaPersonaje = Recursos.getPersonaje()
        .get(personaje.getNombreRaza()).get(PERSONAJE)[0];

    paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
    paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
    paqueteFinalizarBatalla.setIdEnemigo(enemigo.getIdPersonaje());

    // por defecto batalla perdida
    juegoAux.getEstadoJuego().setHaySolicitud(true,
        juegoAux.getPersonaje(), MenuInfoPersonaje.MENUPERDERBATALLA);

    // limpio la accion del mouse
    juegoAux.getHandlerMouse().setNuevoClick(false);

  }

  /* (non-Javadoc)
   * @see estados.Estado#actualizar()
   */
  @Override
public void actualizar() {
    getJuego().getCamara().setxOffset(-XOFFSET);
    getJuego().getCamara().setyOffset(YOFFSET);

    seRealizoAccion = false;
    haySpellSeleccionada = false;

    if (miTurno) {
      if (getJuego().getHandlerMouse().getNuevoClick()) {
        posMouse = getJuego().getHandlerMouse().getPosMouse();

        if (menuBatalla.clickEnMenu(posMouse[0], posMouse[1])) {
          if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == UNO) {
            if (personaje.puedeAtacar()) {
              seRealizoAccion = true;
              if( enemigo.modoDiosActivado() == false || (enemigo.modoDiosActivado() && personaje.modoDiosActivado()) ){
                  personaje.habilidadRaza1(enemigo);
              } else if(personaje.getEnergia() >= ENERGIA_MINIMA ) {
            	  personaje.reducirEnergia(ENERGIA_MINIMA);
              }
            }
            haySpellSeleccionada = true;
          }

          if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == DOS) {
            if (personaje.puedeAtacar()) {
              seRealizoAccion = true;
              if( enemigo.modoDiosActivado() == false || (enemigo.modoDiosActivado() && personaje.modoDiosActivado()) ){
                  personaje.habilidadRaza2(enemigo);
              } else if(personaje.getEnergia() >= ENERGIA_MINIMA ) {
            	  personaje.reducirEnergia(ENERGIA_MINIMA);
              }
            }
            haySpellSeleccionada = true;
          }

          if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == TRES) {
            if (personaje.puedeAtacar()) {
              seRealizoAccion = true;
              if( enemigo.modoDiosActivado() == false || (enemigo.modoDiosActivado() && personaje.modoDiosActivado()) ){
                  personaje.habilidadCasta1(enemigo);
              } else if(personaje.getEnergia() >= ENERGIA_MINIMA ) {
            	  personaje.reducirEnergia(ENERGIA_MINIMA);
              }
            }
            haySpellSeleccionada = true;
          }

          if (menuBatalla.getBotonClickeado(
          posMouse[0], posMouse[1]) == CUATRO) {
            if (personaje.puedeAtacar()) {
              seRealizoAccion = true;
              if( enemigo.modoDiosActivado() == false || (enemigo.modoDiosActivado() && personaje.modoDiosActivado()) ){
                  personaje.habilidadCasta2(enemigo);
              } else if(personaje.getEnergia() >= ENERGIA_MINIMA ) {
            	  personaje.reducirEnergia(ENERGIA_MINIMA);
              }
            }
            haySpellSeleccionada = true;
          }

          if (menuBatalla.getBotonClickeado(
          posMouse[0], posMouse[1]) == CINCO) {
            if (personaje.puedeAtacar()) {
              seRealizoAccion = true;
              if( enemigo.modoDiosActivado() == false || (enemigo.modoDiosActivado() && personaje.modoDiosActivado()) ){
                  personaje.habilidadCasta3(enemigo);
              } else if(personaje.getEnergia() >= ENERGIA_MINIMA ) {
            	  personaje.reducirEnergia(ENERGIA_MINIMA);
              }
            }
            haySpellSeleccionada = true;
          }

          if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == SEIS) {
            seRealizoAccion = true;
            personaje.serEnergizado(VALOR);
            haySpellSeleccionada = true;
          }
        }

        if (haySpellSeleccionada && seRealizoAccion) {
          if (!enemigo.estaVivo()) {
          getJuego().getEstadoJuego().setHaySolicitud(true,
          getJuego().getPersonaje(),
                MenuInfoPersonaje.MENUGANARBATALLA);
            if (personaje.ganarExperiencia(enemigo.getNivel() * EXPERIENCIA)) {
              getJuego().getPersonaje().setNivel(personaje.getNivel());
              getJuego().getEstadoJuego()
                  .setHaySolicitud(true, getJuego().getPersonaje(),
                  MenuInfoPersonaje.MENUSUBIRNIVEL);
            }
            paqueteFinalizarBatalla.setGanadorBatalla(getJuego()
                .getPersonaje().getId());
            finalizarBatalla();
            Estado.setEstado(getJuego().getEstadoJuego());
          } else {
            paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(),
                paqueteEnemigo.getId(), personaje.getSalud(),
                personaje.getEnergia(), enemigo.getSalud(),
                    enemigo.getEnergia(),
            personaje.getDefensa(), enemigo.getDefensa(),
            personaje.getCasta().getProbabilidadEvitarDanio(),
            enemigo.getCasta().getProbabilidadEvitarDanio());
            enviarAtaque(paqueteAtacar);
            miTurno = false;
            menuBatalla.setHabilitado(false);
          }
        } else if (haySpellSeleccionada && !seRealizoAccion) {
          JOptionPane.showMessageDialog(null,
              "No posees la energía suficiente para realizar esta habilidad.");
        }

        getJuego().getHandlerMouse().setNuevoClick(false);
      }
    }
  }

  /* (non-Javadoc)
   * @see estados.Estado#graficar(java.awt.Graphics)
   */
  @Override
public void graficar(final Graphics gAux) {
    gAux.setColor(Color.BLACK);
    gAux.fillRect(0, 0, getJuego().getAncho(), getJuego().getAlto());
    mundo.graficar(gAux);

    gAux.drawImage(Recursos.getPersonaje().get(paquetePersonaje.getRaza())
        .get(IMAGEN_1)[0], X_PERSONAJE, Y_PERSONAJE, WIDTH, HEIGHT, null);
    gAux.drawImage(Recursos.getPersonaje().get(paqueteEnemigo.getRaza())
        .get(IMAGEN_2)[0], X_ENEMIGO, Y_ENEMIGO, WIDTH, HEIGHT, null);

    mundo.graficarObstaculos(gAux);
    menuBatalla.graficar(gAux);

    gAux.setColor(Color.GREEN);

    EstadoDePersonaje.dibujarEstadoDePersonaje(
    gAux, X_ESTADO_PERSONAJE, Y_ESTADO_PERSONAJE,
        personaje, miniaturaPersonaje);
    EstadoDePersonaje.dibujarEstadoDePersonaje(
    gAux, X_ESTADO_ENEMIGO, Y_ESTADO_ENEMIGO,
        enemigo, miniaturaEnemigo);

  }

  /**
   * Crear personajes.
   */
  private void crearPersonajes() {
    String nombre = paquetePersonaje.getNombre();
    int salud = paquetePersonaje.getSaludTope();
    int energia = paquetePersonaje.getEnergiaTope();
    int fuerza = paquetePersonaje.getFuerza();
    int destreza = paquetePersonaje.getDestreza();
    int inteligencia = paquetePersonaje.getInteligencia();
    int experiencia = paquetePersonaje.getExperiencia();
    int nivel = paquetePersonaje.getNivel();
    int id = paquetePersonaje.getId();

    // Guardo el nivel con el que empieza el Personaje la batalla
    this.nivelPersonaje = nivel;

    Casta casta = null;
    try {
      casta = (Casta) Class.forName("dominio" + "."
          + paquetePersonaje.getCasta()).newInstance();
          personaje = (Personaje) Class.forName("dominio" + "."
          + paquetePersonaje.getRaza())
          .getConstructor(String.class, Integer.TYPE, Integer.TYPE,
          Integer.TYPE, Integer.TYPE, Integer.TYPE,
          Casta.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)
          .newInstance(nombre, salud, energia, fuerza, destreza, inteligencia,
          casta, experiencia, nivel, id);
          if(paquetePersonaje.modoDiosActivado()) {
        	  personaje.activarModoDios();
          }
    } catch (InstantiationException | IllegalAccessException
       | ClassNotFoundException | IllegalArgumentException
       | InvocationTargetException | NoSuchMethodException
           | SecurityException e) {
      JOptionPane.showMessageDialog(null, "Error al crear la batalla");
    }

    nombre = paqueteEnemigo.getNombre();
    salud = paqueteEnemigo.getSaludTope();
    energia = paqueteEnemigo.getEnergiaTope();
    fuerza = paqueteEnemigo.getFuerza();
    destreza = paqueteEnemigo.getDestreza();
    inteligencia = paqueteEnemigo.getInteligencia();
    experiencia = paqueteEnemigo.getExperiencia();
    nivel = paqueteEnemigo.getNivel();
    id = paqueteEnemigo.getId();

    // Guardo el nivel con el que empezo la batalla el Enemigo
    this.nivelEnemigo = nivel;

    casta = null;
    if (paqueteEnemigo.getCasta().equals("Guerrero")) {
      casta = new Guerrero();
    } else if (paqueteEnemigo.getCasta().equals("Hechicero")) {
      casta = new Hechicero();
    } else if (paqueteEnemigo.getCasta().equals("Asesino")) {
      casta = new Asesino();
    }
    if (paqueteEnemigo.getRaza().equals("Humano")) {
      enemigo = new Humano(nombre, salud, energia, fuerza,
          destreza, inteligencia, casta, experiencia, nivel, id);
    } else if (paqueteEnemigo.getRaza().equals("Orco")) {
      enemigo = new Orco(nombre, salud, energia, fuerza, destreza, inteligencia,
        casta, experiencia, nivel, id);
    } else if (paqueteEnemigo.getRaza().equals("Elfo")) {
      enemigo = new Elfo(nombre, salud, energia, fuerza, destreza, inteligencia,
        casta, experiencia, nivel, id);
    }
    if(paqueteEnemigo.modoDiosActivado()) {
    	enemigo.activarModoDios();
    }
  }

  /**
   * Enviar ataque.
   *
   * @param paqueteAtacarAux the paquete atacar
   */
  public void enviarAtaque(final PaqueteAtacar paqueteAtacarAux) {
    try {
      getJuego().getCliente().getSalida()
          .writeObject(gson.toJson(paqueteAtacarAux));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Fallo la conexion con el servidor.");
    }
  }

  /**
   * Finalizar batalla.
   */
  private void finalizarBatalla() {
    try {
      getJuego().getCliente().getSalida()
          .writeObject(gson.toJson(paqueteFinalizarBatalla));
      paquetePersonaje.setSaludTope(personaje.getSaludTope());
      paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
      paquetePersonaje.setNivel(personaje.getNivel());
      paquetePersonaje.setExperiencia(personaje.getExperiencia());
      paquetePersonaje.setDestreza(personaje.getDestreza());
      paquetePersonaje.setFuerza(personaje.getFuerza());
      paquetePersonaje.setInteligencia(personaje.getInteligencia());
      paquetePersonaje.removerBonus();

      paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
      paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
      paqueteEnemigo.setNivel(enemigo.getNivel());
      paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
      paqueteEnemigo.setDestreza(enemigo.getDestreza());
      paqueteEnemigo.setFuerza(enemigo.getFuerza());
      paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
      paqueteEnemigo.removerBonus();

      /**
      * Comparo si subierio alguno de nivel para asignarle los 3 puntos
      * correspondientes
      */
      if (paquetePersonaje.getNivel() > this.nivelPersonaje) {
        paquetePersonaje.actualizarPuntosPorNivel();
      } else if (paqueteEnemigo.getNivel() > this.nivelEnemigo) {
        paqueteEnemigo.actualizarPuntosPorNivel();
      }
      /**
       * fin comparacion
       */
      paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
      paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);

      getJuego().getCliente().getSalida()
         .writeObject(gson.toJson(paquetePersonaje));
      getJuego().getCliente().getSalida()
          .writeObject(gson.toJson(paqueteEnemigo));

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor");
    }
  }

  /**
   * Gets the paquete personaje.
   *
   * @return the paquete personaje
   */
  public PaquetePersonaje getPaquetePersonaje() {
    return paquetePersonaje;
  }

  /**
   * Gets the paquete enemigo.
   *
   * @return the paquete enemigo
   */
  public PaquetePersonaje getPaqueteEnemigo() {
    return paqueteEnemigo;
  }

  /**
   * Sets the mi turno.
   *
   * @param bAux the new mi turno
   */
  public void setMiTurno(final boolean bAux) {
    miTurno = bAux;
    menuBatalla.setHabilitado(bAux);
    getJuego().getHandlerMouse().setNuevoClick(false);
  }

  /**
   * Gets the personaje.
   *
   * @return the personaje
   */
  public Personaje getPersonaje() {
    return personaje;
  }

  /**
   * Gets the enemigo.
   *
   * @return the enemigo
   */
  public Personaje getEnemigo() {
    return enemigo;
  }

  /* (non-Javadoc)
   * @see estados.Estado#esEstadoDeJuego()
   */
  @Override
public boolean esEstadoDeJuego() {
    return false;
  }
}
