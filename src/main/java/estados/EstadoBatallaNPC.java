
package estados;

import com.google.gson.Gson;

import dominio.Casta;
import dominio.NonPlayableCharacter;
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
import mensajeria.PaqueteBatallaNPC;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaqueteNPC;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatallaNPC.
 */
public class EstadoBatallaNPC extends Estado {

  /** The mundo. */
  private Mundo mundo;

  /** The personaje. */
  private Personaje personaje;

  /** The enemigo. */
  private NonPlayableCharacter enemigo;

  /** The pos mouse. */
  private int[] posMouse;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The paquete enemigo. */
  private PaqueteNPC paqueteEnemigo;

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

  /** The Constant MINOTAURO. */
  private static final int MINOTAURO = 5;

  /** The Constant PERSONAJE. */
  private static final int PERSONAJE = 5;

  /** The Constant XOFFSET. */
  private static final int XOFFSET = -350;

  /** The Constant YOFFSET. */
  private static final int YOFFSET = 150;

  /** The Constant TRES. */
  private static final int TRES = 3;

  /** The Constant CUATRO. */
  private static final int CUATRO = 4;

  /** The Constant CINCO. */
  private static final int CINCO = 5;

  /** The Constant SEIS. */
  private static final int SEIS = 6;

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

  /**
   * Instantiates a new estado batalla NPC.
   * *
   * * @param juego the juego
   * * @param paqueteBatalla the paquete batalla
   */
  public EstadoBatallaNPC(final Juego juego,
  final PaqueteBatallaNPC paqueteBatalla) {
    super(juego);
    mundo = new Mundo(juego, "recursos/mundoBatalla.txt",
    "recursos/mundoBatallaCapaDos.txt");

    miTurno = paqueteBatalla.isMiTurno();

    paquetePersonaje = juego.getPersonajesConectados()
      .get(paqueteBatalla.getId());
    paqueteEnemigo = juego.getNpcs().get(paqueteBatalla.getIdEnemigo());
    enemigo = paqueteEnemigo.getNpc();

    crearPersonajes();

    menuBatalla = new MenuBatalla(miTurno, personaje);

    miniaturaEnemigo = Recursos.getPersonaje()
      .get("Minotauro").get(MINOTAURO)[0];
    miniaturaPersonaje = Recursos.getPersonaje()
      .get(personaje.getNombreRaza()).get(PERSONAJE)[0];

    paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
    paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
    paqueteFinalizarBatalla.setIdEnemigo(paqueteEnemigo.getId());

    juego.getEstadoJuego().setHaySolicitud(true,
      juego.getPersonaje(), MenuInfoPersonaje.MENUPERDERBATALLA);

    juego.getHandlerMouse().setNuevoClick(false);

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
        if (menuBatalla.getBotonClickeado(posMouse[0],
          posMouse[1]) == 1) {
          if (personaje.puedeAtacar()) {
            seRealizoAccion = true;
            personaje.habilidadRaza1(enemigo);
          }
          haySpellSeleccionada = true;
          }
        if (menuBatalla.getBotonClickeado(posMouse[0],
        posMouse[1]) == 2) {
          if (personaje.puedeAtacar()) {
            seRealizoAccion = true;
            personaje.habilidadRaza2(enemigo);
           }
           haySpellSeleccionada = true;
           }

           if (menuBatalla.getBotonClickeado(
           posMouse[0], posMouse[1]) == TRES) {
             if (personaje.puedeAtacar()) {
               seRealizoAccion = true;
               personaje.habilidadCasta1(enemigo);
             }
             haySpellSeleccionada = true;
              }

              if (menuBatalla.getBotonClickeado(posMouse[0],
              posMouse[1]) == CUATRO) {
                if (personaje.puedeAtacar()) {
                  seRealizoAccion = true;
                  personaje.habilidadCasta2(enemigo);
                }
                haySpellSeleccionada = true;
                }

                if (menuBatalla.getBotonClickeado(posMouse[0],
                posMouse[1]) == CINCO) {
                  if (personaje.puedeAtacar()) {
                    seRealizoAccion = true;
                    personaje.habilidadCasta3(enemigo);
                  }
                  haySpellSeleccionada = true;
                  }

                  if (menuBatalla.getBotonClickeado(posMouse[0],
                  posMouse[1]) == SEIS) {
                    seRealizoAccion = true;
                    personaje.serEnergizado(VALOR);
                    haySpellSeleccionada = true;
                  }
                }
                if (haySpellSeleccionada && seRealizoAccion) {
                  if (!enemigo.estaVivo()) {
                    getJuego().getEstadoJuego().setHaySolicitud(true,
                        getJuego().getPersonaje(), MenuInfoPersonaje
                            .MENUGANARBATALLA);
                    if (personaje.ganarExperiencia(
                    enemigo.getNivel() * EXPERIENCIA)) {
                    getJuego().getPersonaje().setNivel(personaje.getNivel());
                    getJuego().getEstadoJuego().setHaySolicitud(true,
                        getJuego().getPersonaje(),
                        MenuInfoPersonaje.MENUSUBIRNIVEL);
                    }
                    paqueteFinalizarBatalla.setGanadorBatalla(getJuego()
                        .getPersonaje().getId());
                    finalizarBatalla();
                    Estado.setEstado(getJuego().getEstadoJuego());
                    paqueteEnemigo.setEstado(getEstadoBatallaNPC());

                    } else {
                    if(personaje.modoDiosActivado() == false) {
                        enemigo.atacar(personaje);
                    }                    
                    if (!personaje.estaVivo()) {
                      getJuego().getEstadoJuego().setHaySolicitud(true,
                          getJuego().getPersonaje(), MenuInfoPersonaje
                          .MENUPERDERBATALLA);
                       getJuego().getPersonaje()
                           .setEstado(Estado.getEstadoJuego());

                       getJuego().getNpcs().get(this.getPaqueteEnemigo().
                    		   getId()).setEstado(Estado.getEstadoJuego());
                       paqueteFinalizarBatalla.setGanadorBatalla(this
                           .getPaqueteEnemigo().getId());
                       finalizarBatalla();
                       Estado.setEstado(getJuego().getEstadoJuego());
                       }
                       miTurno = true;
                     }
                   } else if (haySpellSeleccionada
                   && !seRealizoAccion) {
                      JOptionPane.showMessageDialog(null,
                         "No posees la energía suficiente "
                         + "para realizar esta habilidad.");
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
  gAux.fillRect(0, 0, getJuego()
    .getAncho(), getJuego().getAlto());
  mundo.graficar(gAux);
  gAux.drawImage(Recursos.getPersonaje().get(paquetePersonaje
      .getRaza()).get(IMAGEN_1)[0], X_PERSONAJE,
      Y_PERSONAJE, WIDTH, HEIGHT, null);
  gAux.drawImage(Recursos.getPersonaje().get("Minotauro")
      .get(IMAGEN_2)[0], X_ESTADO_ENEMIGO,
      Y_ESTADO_ENEMIGO, WIDTH, HEIGHT, null);
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
  int magia = paquetePersonaje.getInteligencia();
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
        + paquetePersonaje.getRaza()).getConstructor(String.class, Integer.TYPE,
        Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE,
        Casta.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)
        .newInstance(nombre, salud, energia, fuerza, destreza, magia, casta,
        experiencia, nivel, id);
    if( paquetePersonaje.modoDiosActivado() ) {
    	personaje.activarModoDios();
    }
   } catch (InstantiationException | IllegalAccessException
   | ClassNotFoundException | IllegalArgumentException
   | InvocationTargetException | NoSuchMethodException | SecurityException e) {
     JOptionPane.showMessageDialog(null, "Error al crear la batalla");
   }

  nombre = paqueteEnemigo.getNombre();
  salud = paqueteEnemigo.getNpc().getSalud();
  fuerza = paqueteEnemigo.getNpc().getFuerza();
  magia = paqueteEnemigo.getNpc().getMagia();
  nivel = paqueteEnemigo.getNpc().getNivel();
  id = paqueteEnemigo.getId();
  
  enemigo = new NonPlayableCharacter(nombre, nivel, paqueteEnemigo.getDificultad());
  }

  /**
  * Finalizar batalla.
   */
private void finalizarBatalla() {
  try {
    paqueteFinalizarBatalla.setComando(Comando.FINALIZARBATALLA);
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

    /**
    * Comparo solo si subio el jugador de nivel para asignarle los 3
    * puntos correspondientes
    */
    if (paquetePersonaje.getNivel() > this.nivelPersonaje) {
      paquetePersonaje.actualizarPuntosPorNivel();
    }

  /**
  * fin comparacion
  */

    paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
    paqueteEnemigo.setComando(Comando.ACTUALIZARNPC);

    getJuego().getCliente().getSalida()
       .writeObject(gson.toJson(paquetePersonaje));
    
    getJuego().getCliente().getSalida()
        .writeObject(gson.toJson(paqueteEnemigo));

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null,
          "Fallo la conexión con el servidor");
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
public PaqueteNPC getPaqueteEnemigo() {
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
public NonPlayableCharacter getEnemigo() {
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
