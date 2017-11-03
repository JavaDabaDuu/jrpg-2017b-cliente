package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public class Tile {

  /** The tiles. */
  private static Tile[] tiles = new Tile[256];

  /** The aubenor. */
  private static Tile[] aubenor;

  /** The aris. */
  private static Tile[] aris;

  /** The aris base. */
  // es el piso de aubenor por defecto si queres llamarlo asi, es gris
  private static int arisBase = 3;

  /** The aubenor base. */
  private static int aubenorBase = 3;

  /** The Constant ANCHO. */
  public static final int ANCHO = 64;

  /** The Constant ALTO. */
  public static final int ALTO = 32;

  /** The textura. */
  private BufferedImage textura;

  /** The id. */
  private final int id;

  /** The es solido. */
  private boolean esSolido;


  /** The ancho. */
  private int ancho;

  /** The alto. */
  private int alto;


  /**
   * Instantiates a new tile.
   *
   * @param texturaAux the textura
   * @param idAux the id
   * @param esSolidoAux the es solido
   */
  public Tile(final BufferedImage texturaAux, final int idAux,
  final boolean esSolidoAux) {
    this.textura = texturaAux;
    this.id = idAux;
    getTiles()[idAux] = this;
    this.esSolido = esSolidoAux;
  }

  /**
   * Instantiates a new tile.
   *
   * @param texturaAux the textura
   * @param idAux the id
   * @param esSolidoAux the es solido
   * @param anchoAux the ancho
   * @param altoAux the alto
   */
  public Tile(final BufferedImage texturaAux, final int idAux,
  final boolean esSolidoAux, final int anchoAux, final int altoAux) {
    this.textura = texturaAux;
    this.id = idAux;
    getTiles()[idAux] = this;
    this.ancho = anchoAux;
    this.alto = altoAux;
    this.esSolido = esSolidoAux;
  }

  /**
   * Actualizar.
   */
  public void actualizar() {

  }

  /**
   * Graficar.
   *
   * @param g the g
   * @param x the x
   * @param y the y
   */
  public void graficar(final Graphics g, final int x, final int y) {
    g.drawImage(textura, x, y, ANCHO, ALTO, null);
  }

  /**
   * Graficar.
   *
   * @param g the g
   * @param x the x
   * @param y the y
   * @param width the width
   * @param height the height
   */
  public void graficar(final Graphics g, final int x, final int y,
  final int width, final int height) {
    g.drawImage(textura, x, y, width, height, null);
  }

  /**
   * Sets the solido.
   *
   * @param solidez the new solido
   */
  public void setSolido(final boolean solidez) {
    esSolido = solidez;
  }


  /**
   * Es solido.
   *
   * @return true, if successful
   */
  public boolean esSolido() {
    return esSolido;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
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
 * Gets the aubenor base.
 *
 * @return the aubenor base
 */
public static int getAubenorBase() {
  return aubenorBase;
}

/**
 * Sets the aubenor base.
 *
 * @param aubenorBaseAux the new aubenor base
 */
public static void setAubenorBase(final int aubenorBaseAux) {
  Tile.aubenorBase = aubenorBaseAux;
}

/**
 * Gets the aubenor.
 *
 * @return the aubenor
 */
public static Tile[] getAubenor() {
  return aubenor;
}

/**
 * Sets the aubenor.
 *
 * @param aubenorAux the new aubenor
 */
public static void setAubenor(final Tile[] aubenorAux) {
  Tile.aubenor = aubenorAux;
}

/**
 * Gets the aris.
 *
 * @return the aris
 */
public static Tile[] getAris() {
  return aris;
}

/**
 * Sets the aris.
 *
 * @param arisAux the new aris
 */
public static void setAris(final Tile[] arisAux) {
  Tile.aris = arisAux;
}

/**
 * Gets the aris base.
 *
 * @return the aris base
 */
public static int getArisBase() {
  return arisBase;
}

/**
 * Sets the aris base.
 *
 * @param arisBaseAux the new aris base
 */
public static void setArisBase(final int arisBaseAux) {
  Tile.arisBase = arisBaseAux;
}

/**
 * Gets the tiles.
 *
 * @return the tiles
 */
public static Tile[] getTiles() {
  return tiles;
}

/**
 * Sets the tiles.
 *
 * @param tilesAux the new tiles
 */
public static void setTiles(final Tile[] tilesAux) {
  Tile.tiles = tilesAux;
}


}
