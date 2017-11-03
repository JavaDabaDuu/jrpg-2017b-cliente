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

        g.drawImage(miniaturaEnemigo, x + 10, y + 9,
            ANCHOMINIATURA, ALTOMINIATURA, null);

        if (enemigo.getSalud() == enemigo.getSalud()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (enemigo.getSalud() * ANCHOBARRA)
                    / enemigo.getSalud();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.drawImage(Recursos.getBarraSalud(), x + 80, y + 26,
            drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getSalud()) + " / "
                        + String.valueOf(enemigo.getSalud()),
                x + 132, y + 37);

        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNivel()), x + 59, y + 70);

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

        g.drawImage(miniaturaEnemigo, x + 10, y + 9, ANCHOMINIATURA,
                ALTOMINIATURA, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.drawImage(Recursos.getBarraSalud(), x + 80, y + 26, drawBarra,
                ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getNpc().getSalud()) + " / "
                + String.valueOf(enemigo.getNpc().getSalud()),
                x + 132, y + 37);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNpc().getNivel()),
            x + 59, y + 70);
    }
}
