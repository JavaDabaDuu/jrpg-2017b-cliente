package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.NonPlayableCharacter;
import mensajeria.PaqueteNPC;
import recursos.Recursos;

/**
 * The Class EstadoNPC.
 */
public class EstadoNPC {
  /**
  * Instantiates a new estado NPC.
  */
  private EstadoNPC() {
  }
  /**
  * The Constant ANCHOBARRA.
  */
    private static final int ANCHOBARRA = 122;

    /**
     * The Constant ALTOSALUD.
     */
    private static final int ALTOSALUD = 14;

    /**
     * The Constant ALTOMINIATURA.
     */
    private static final int ALTOMINIATURA = 64;

    /**
     * The Constant ANCHOMINIATURA.
     */
    private static final int ANCHOMINIATURA = 64;

    /** The Constant X_OFFSET. */
    private static final int X_OFFSET = 10;

    /** The Constant Y_OFFSET. */
    private static final int Y_OFFSET = 9;

    /** The Constant SIZE1. */
    private static final int SIZE1 = 10;

    /** The Constant X_BARRA_SALUD. */
    private static final int X_BARRA_SALUD = 80;

    /** The Constant Y_BARRA_SALUD. */
    private static final int Y_BARRA_SALUD = 26;

    /** The Constant X_SALUD. */
    private static final int X_SALUD = 132;

    /** The Constant Y_SALUD. */
    private static final int Y_SALUD = 37;

    /** The Constant X_NIVEL. */
    private static final int X_NIVEL = 59;

    /** The Constant Y_NIVEL. */
    private static final int Y_NIVEL = 70;

    /**
     * Dibujar estado de enemigo.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param enemigo
     *            the enemigo
     * @param miniaturaEnemigo
     *            the miniatura enemigo
     */
    public static void dibujarEstadoDeEnemigo(final Graphics g, final int x,
            final int y, final NonPlayableCharacter enemigo,
            final BufferedImage miniaturaEnemigo) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaEnemigo, x + X_OFFSET, y + Y_OFFSET,
            ANCHOMINIATURA, ALTOMINIATURA, null);

        if (enemigo.getSalud() == enemigo.getSalud()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (enemigo.getSalud() * ANCHOBARRA)
                    / enemigo.getSalud();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
        g.drawImage(Recursos.getBarraSalud(),
        x + X_BARRA_SALUD, y + Y_BARRA_SALUD,
            drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getSalud()) + " / "
                        + String.valueOf(enemigo.getSalud()),
                x + X_SALUD, y + Y_SALUD);

        g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNivel()),
        x + X_NIVEL, y + Y_NIVEL);

    }

    /**
     * Dibujar estado de enemigo.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param enemigo
     *            the enemigo
     * @param miniaturaEnemigo
     *            the miniatura enemigo
     */
    public static void dibujarEstadoDeEnemigo(final Graphics g, final int x,
            final int y, final PaqueteNPC enemigo,
            final BufferedImage miniaturaEnemigo) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaEnemigo, x
        + X_OFFSET, y + Y_OFFSET, ANCHOMINIATURA,
                ALTOMINIATURA, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
        g.drawImage(Recursos.getBarraSalud(), x
        + X_BARRA_SALUD, y + Y_BARRA_SALUD, drawBarra,
                ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getNpc().getSalud()) + " / "
                + String.valueOf(enemigo.getNpc().getSalud()),
                x + X_SALUD, y + Y_SALUD);
        g.setFont(new Font("Tahoma", Font.PLAIN, SIZE1));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNpc().getNivel()),
            x + X_NIVEL, y + Y_NIVEL);
    }
}
