package interfaz;

import dominio.Personaje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Rectangle;

import juego.Pantalla;
import recursos.Recursos;

/**
 * The Class MenuBatalla.
 */
public class MenuBatalla {

  /** The Constant x. */
  private static final int X = 100;

  /** The Constant y. */
  private static final int Y = 380;

  /** The Constant anchoBoton. */
  private static final int ANCHOBOTON = 40;

  /** The Constant botones. */
  private static final int[][] BOTONES = {{X + 48, Y + 72}, {X + 48, Y + 146},
  {X + 221, Y + 72}, {X + 221, Y + 146}, {X + 394, Y + 72},
  {X + 394, Y + 146}};

  /** The habilitado. */
  private boolean habilitado;

  /** The personaje. */
  private Personaje personaje;

  /**
   * Instantiates a new menu batalla.
   *
   * @param habilitadoAux the habilitado
   * @param personajeAux the personaje
   */
  public MenuBatalla(final boolean habilitadoAux,
  final Personaje personajeAux) {
    this.habilitado = habilitadoAux;
    this.personaje = personajeAux;
  }

  /**
   * Graficar.
   *
   * @param g the g
   */
  public void graficar(final Graphics g) {

    if (habilitado) {
      g.drawImage(Recursos.getMenuBatalla(), X, Y, null);
    } else {
      g.drawImage(Recursos.getMenuBatallaDeshabilitado(), X, Y, null);
    }
    // Dibujo los boones
    g.drawImage(Recursos.getHabilidades().get(personaje
        .getHabilidadesRaza()[0]), BOTONES[0][0], BOTONES[0][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje
        .getHabilidadesRaza()[1]), BOTONES[1][0], BOTONES[1][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje
        .getHabilidadesCasta()[0]), BOTONES[2][0], BOTONES[2][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje
         .getHabilidadesCasta()[1]), BOTONES[3][0], BOTONES[3][1],
         ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje
         .getHabilidadesCasta()[2]), BOTONES[4][0], BOTONES[4][1],
         ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades()
         .get("Ser Energizado"), BOTONES[5][0], BOTONES[5][1],
         ANCHOBOTON, ANCHOBOTON, null);

    // Dibujo las leyendas
    g.setFont(new Font("Book Antiqua", 1, 14));
    g.drawString(personaje.getHabilidadesRaza()[0], X + 95, Y + 94);
    g.drawString(personaje.getHabilidadesRaza()[1], X + 95, Y + 168);
    g.drawString(personaje.getHabilidadesCasta()[0], X + 268, Y + 94);
    g.drawString(personaje.getHabilidadesCasta()[1], X + 268, Y + 168);
    g.drawString(personaje.getHabilidadesCasta()[2], X + 442, Y + 94);
    g.drawString("Ser energizado", X + 442, Y + 168);

    // Dibujo el turno de quien es
    g.setColor(Color.WHITE);
    if (habilitado) {
      Pantalla.centerString(g, new Rectangle(X, Y + 5, Recursos
          .getMenuBatalla().getWidth(), 20), "Mi Turno");
    } else {
      Pantalla.centerString(g, new Rectangle(X, Y + 5, Recursos
           .getMenuBatalla().getWidth(), 20), "Turno Rival");
    }
  }

  /**
   * Gets the boton clickeado.
   *
   * @param mouseX the mouse X
   * @param mouseY the mouse Y
   * @return the boton clickeado
   */
  public int getBotonClickeado(final int mouseX, final int mouseY) {
    if (!habilitado) {
      return 0;
    }
    for (int i = 0; i < BOTONES.length; i++) {
      if (mouseX >= BOTONES[i][0] && mouseX <= BOTONES[i][0] + ANCHOBOTON
          && mouseY >= BOTONES[i][1] && mouseY <= BOTONES[i][1] + ANCHOBOTON) {
        return i + 1;
      }
    }
    return 0;
  }

  /**
   * Click en menu.
   *
   * @param mouseX the mouse X
   * @param mouseY the mouse Y
   * @return true, if successful
   */
  public boolean clickEnMenu(final int mouseX, final int mouseY) {
    if (mouseX >= X && mouseX <= X + Recursos.getMenuBatalla()
    .getWidth() && mouseY >= Y && mouseY <= Y
    + Recursos.getMenuBatalla().getHeight()) {
      return habilitado;
    }
    return false;
  }

  /**
   * Sets the habilitado.
   *
   * @param b the new habilitado
   */
  public void setHabilitado(final boolean b) {
    habilitado = b;
  }
}
