package recursos;

import java.awt.image.BufferedImage;

/**
 * The Class SpriteSheet.
 */
public class SpriteSheet {

  /** The sprite. */
  private BufferedImage sprite;

  /**
   * Instantiates a new sprite sheet.
   *
   * @param spriteAux the sprite
   */
  public SpriteSheet(final BufferedImage spriteAux) {
    this.sprite = spriteAux;
  }

  /**
   * Gets the tile.
   *
   * @param xAux the x
   * @param yAux the y
   * @param anchoAux the ancho
   * @param altoAux the alto
   * @return the tile
   */
  public BufferedImage getTile(
  final int xAux, final int yAux, final int anchoAux, final int altoAux) {
    return sprite.getSubimage(xAux, yAux, anchoAux, altoAux);
  }
}
