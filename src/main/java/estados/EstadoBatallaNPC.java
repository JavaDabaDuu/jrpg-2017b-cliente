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
      .get("Minotauro").get(5)[0];
    miniaturaPersonaje = Recursos.getPersonaje()
      .get(personaje.getNombreRaza()).get(5)[0];

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
  getJuego().getCamara().setxOffset(-350);
  getJuego().getCamara().setyOffset(150);

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

           if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 3) {
             if (personaje.puedeAtacar()) {
               seRealizoAccion = true;
               personaje.habilidadCasta1(enemigo);
             }
             haySpellSeleccionada = true;
              }

              if (menuBatalla.getBotonClickeado(posMouse[0],
              posMouse[1]) == 4) {
                if (personaje.puedeAtacar()) {
                  seRealizoAccion = true;
                  personaje.habilidadCasta2(enemigo);
                }
                haySpellSeleccionada = true;
                }

                if (menuBatalla.getBotonClickeado(posMouse[0],
                posMouse[1]) == 5) {
                  if (personaje.puedeAtacar()) {
                    seRealizoAccion = true;
                    personaje.habilidadCasta3(enemigo);
                  }
                  haySpellSeleccionada = true;
                  }

                  if (menuBatalla.getBotonClickeado(posMouse[0],
                  posMouse[1]) == 6) {
                    seRealizoAccion = true;
                    personaje.serEnergizado(10);
                    haySpellSeleccionada = true;
                  }
                }
                if (haySpellSeleccionada && seRealizoAccion) {
                  if (!enemigo.estaVivo()) {
                    getJuego().getEstadoJuego().setHaySolicitud(true,
                        getJuego().getPersonaje(), MenuInfoPersonaje
                            .MENUGANARBATALLA);
                    if (personaje.ganarExperiencia(enemigo.getNivel() * 40)) {
                    getJuego().getPersonaje().setNivel(personaje.getNivel());
                    getJuego().getEstadoJuego().setHaySolicitud(true,
                        getJuego().getPersonaje(),
                        MenuInfoPersonaje.MENUSUBIRNIVEL);
                    }
                    paqueteFinalizarBatalla.setGanadorBatalla(getJuego()
                        .getPersonaje().getId());
                    finalizarBatalla();
                    Estado.setEstado(getJuego().getEstadoJuego());

                    } else {
                    enemigo.atacar(personaje);
                    if (!personaje.estaVivo()) {
                      getJuego().getEstadoJuego().setHaySolicitud(true,
                          getJuego().getPersonaje(), MenuInfoPersonaje
                          .MENUPERDERBATALLA);
                       getJuego().getPersonaje()
                           .setEstado(Estado.getEstadoJuego());

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
      .getRaza()).get(3)[0], 0, 175, 256, 256, null);
  gAux.drawImage(Recursos.getPersonaje().get("Minotauro")
      .get(7)[0], 550, 75, 256, 256, null);
  mundo.graficarObstaculos(gAux);
  menuBatalla.graficar(gAux);

  gAux.setColor(Color.GREEN);

  EstadoDePersonaje.dibujarEstadoDePersonaje(gAux, 25, 5,
      personaje, miniaturaPersonaje);
  EstadoDePersonaje.dibujarEstadoDePersonaje(gAux, 550, 5,
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
    JOptionPane.showMessageDialog(null,
        "Fallo la conexion con el servidor.");
  }
}

  /**
  * Finalizar batalla.
   */
private void finalizarBatalla() {
  try {
    paqueteFinalizarBatalla.setComando(Comando.FINALIZARBATALLANPC);
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
    paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);

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
