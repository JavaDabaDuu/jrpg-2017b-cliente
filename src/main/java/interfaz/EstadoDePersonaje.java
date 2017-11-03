
package interfaz;

import dominio.NonPlayableCharacter;
import dominio.Personaje;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class EstadoDePersonaje.
 */
public class EstadoDePersonaje {

  /** The Constant ANCHOBARRA. */
  private static final int ANCHOBARRA = 122;

  /** The Constant ALTOSALUD. */
  private static final int ALTOSALUD = 14;

  /** The Constant ALTOENERGIA. */
  private static final int ALTOENERGIA = 14;

  /** The Constant ALTOEXPERIENCIA. */
  private static final int ALTOEXPERIENCIA = 6;

  /** The Constant ALTOMINIATURA. */
  private static final int ALTOMINIATURA = 64;

  /** The Constant ANCHOMINIATURA. */
  private static final int ANCHOMINIATURA = 64;

  /** The Constant OFFSET_X. */
  private static final int OFFSET_X = 10;

  /** The Constant OFFSET_Y. */
  private static final int OFFSET_Y = 9;

  /** The Constant SIZE1. */
  private static final int SIZE1 = 10;

  /** The Constant SIZE2. */
  private static final int SIZE2 = 8;

  /** The Constant X_BARRA_SALUD. */
  private static final int X_BARRA_SALUD = 80;

  /** The Constant Y_BARRA_SALUD. */
  private static final int Y_BARRA_SALUD = 26;

  /** The Constant X_SALUD_TOPE. */
  private static final int X_SALUD_TOPE = 132;

  /** The Constant Y_SALUD_TOPE. */
  private static final int Y_SALUD_TOPE = 37;

  /** The Constant X_BARRA_ENERIGA. */
  private static final int X_BARRA_ENERIGA = 80;

  /** The Constant Y_BARRA_ENERGIA. */
  private static final int Y_BARRA_ENERGIA = 42;

  /** The Constant X_ENERGIA_TOPE. */
  private static final int X_ENERGIA_TOPE = 132;

  /** The Constant Y_ENERGIA_TOPE. */
  private static final int Y_ENERGIA_TOPE = 52;

  /** The Constant X_BARRA_EXPERIENCIA. */
  private static final int X_BARRA_EXPERIENCIA = 77;

  /** The Constant Y_BARRA_EXPERIENCIA. */
  private static final int Y_BARRA_EXPERIENCIA = 65;

  /** The Constant X_TABLA_NIVELES. */
  private static final int X_TABLA_NIVELES = 132;

  /** The Constant Y_TABLA_NIVELES. */
  private static final int Y_TABLA_NIVELES = 70;

  /** The Constant X_NIVEL. */
  private static final int X_NIVEL = 59;

  /** The Constant Y_NIVEL. */
  private static final int Y_NIVEL = 70;
  /**
   * Dibujar estado de personaje.
   *
   * @param g the g
   * @param x the x
   * @param y the y
   * @param personaje the personaje
   * @param miniaturaPersonaje the miniatura personaje
   */
  public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
  final int y, final Personaje personaje,
  final BufferedImage miniaturaPersonaje) {

    int drawBarra = 0;
    g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);
    g.drawImage(miniaturaPersonaje, x + OFFSET_X, y + OFFSET_Y,
        ANCHOMINIATURA, ALTOMINIATURA, null);

    if (personaje.getSalud() == personaje.getSaludTope()) {
      drawBarra = ANCHOBARRA;
    } else {
      drawBarra = (personaje.getSalud()
          * ANCHOBARRA) / personaje.getSaludTope();
    }

    g.setColor(Color.WHITE);
    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
    g.drawImage(Recursos.getBarraSalud(),
         x + X_BARRA_SALUD, y + Y_BARRA_SALUD, drawBarra, ALTOSALUD, null);
    g.drawString(String.valueOf(personaje.getSalud()) + " / " + String
        .valueOf(personaje.getSaludTope()), x + X_SALUD_TOPE, y + Y_SALUD_TOPE);

    if (personaje.getEnergia() == personaje.getEnergiaTope()) {
      drawBarra = ANCHOBARRA;
    } else {
      drawBarra = (personaje.getEnergia()
          * ANCHOBARRA) / personaje.getEnergiaTope();
    }

    g.drawImage(Recursos.getBarraEnergia(),
    x + X_BARRA_ENERIGA, y + Y_BARRA_ENERGIA, drawBarra,
         ALTOENERGIA, null);
    g.drawString(String.valueOf(personaje.getEnergia()) + " / " + String
        .valueOf(personaje.getEnergiaTope()),
        x + X_ENERGIA_TOPE, y + Y_ENERGIA_TOPE);

    if (personaje.getExperiencia()
    == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
      drawBarra = ANCHOBARRA;
    } else {
      drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje
          .getTablaDeNiveles()[personaje.getNivel() + 1];
    }

    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE2));
    g.drawImage(Recursos.getBarraExperiencia(),
    x + X_BARRA_EXPERIENCIA, y + Y_BARRA_EXPERIENCIA,
        drawBarra, ALTOEXPERIENCIA, null);
    g.drawString(String.valueOf(personaje.getExperiencia())
        + " / " + String
        .valueOf(Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]),
        x + X_TABLA_NIVELES, y + Y_TABLA_NIVELES);
    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
    g.setColor(Color.GREEN);
    g.drawString(String.valueOf(personaje.getNivel()),
    x + X_NIVEL, y + Y_NIVEL);


  }

  /**
   * Dibujar estado de personaje.
   *
   * @param g the g
   * @param x the x
   * @param y the y
   * @param personaje the personaje
   * @param miniaturaPersonaje the miniatura personaje
   */
  public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
  final int y, final PaquetePersonaje personaje,
  final BufferedImage miniaturaPersonaje) {

    int drawBarra = 0;

    g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

    g.drawImage(miniaturaPersonaje, x + OFFSET_X, y + OFFSET_Y,
        ANCHOMINIATURA, ALTOMINIATURA, null);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
    g.drawImage(Recursos.getBarraSalud(), x + X_BARRA_SALUD, y + Y_BARRA_SALUD,
        ANCHOBARRA, ALTOSALUD, null);
    g.drawString(String.valueOf(personaje.getSaludTope()) + " / " + String
         .valueOf(personaje.getSaludTope()),
         x + X_SALUD_TOPE, y + Y_SALUD_TOPE);

    g.drawImage(Recursos.getBarraEnergia(),
    x + X_BARRA_ENERIGA, y + Y_BARRA_ENERGIA,
        ANCHOBARRA, ALTOENERGIA, null);
    g.drawString(String.valueOf(personaje.getEnergiaTope()) + " / " + String
        .valueOf(personaje.getEnergiaTope()),
        x + X_ENERGIA_TOPE, y + Y_ENERGIA_TOPE);

    if (personaje.getExperiencia()
    == Personaje.getTablaDeNiveles()[personaje.getNivel() + 1]) {
      drawBarra = ANCHOBARRA;
    } else {
      drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje
          .getTablaDeNiveles()[personaje.getNivel() + 1];
    }

    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE2));
    g.drawImage(Recursos.getBarraExperiencia(),
    x + X_BARRA_EXPERIENCIA, y + Y_BARRA_EXPERIENCIA,
        drawBarra, ALTOEXPERIENCIA, null);
    g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String
        .valueOf(Personaje
        .getTablaDeNiveles()[personaje.getNivel() + 1]),
        x + X_TABLA_NIVELES, y + Y_TABLA_NIVELES);
    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
    g.setColor(Color.GREEN);
    g.drawString(String.valueOf(personaje.getNivel()),
    x + X_NIVEL, y + Y_NIVEL);
  }

  /**
   * Dibujar estado de personaje.
   *
   * @param g the g
   * @param x the x
   * @param y the y
   * @param enemigo the enemigo
   * @param miniaturaEnemigo the miniatura enemigo
   */
  public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
  final int y, final NonPlayableCharacter enemigo,
  final BufferedImage miniaturaEnemigo) {
    g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

    g.drawImage(miniaturaEnemigo, x + OFFSET_X, y + OFFSET_Y,
        ANCHOMINIATURA, ALTOMINIATURA, null);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
    g.drawImage(Recursos.getBarraSalud(), x + X_BARRA_SALUD, y + Y_BARRA_SALUD,
        ANCHOBARRA, ALTOSALUD, null);
    g.drawString(String.valueOf(enemigo.getSalud()) + " / " + String
        .valueOf(enemigo.getSalud()), x + X_SALUD_TOPE, y + Y_SALUD_TOPE);

    g.setFont(new Font("Tahoma", Font.PLAIN, SIZE2));
    g.setColor(Color.GREEN);
    g.drawString(String.valueOf(enemigo.getNivel()), x + X_NIVEL, y + Y_NIVEL);

  }
}
