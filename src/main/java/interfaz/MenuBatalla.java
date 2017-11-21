
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

  /** The Constant SIZELEYENDA. */
  private static final int SIZELEYENDA = 15;

  /** The Constant WIDTH_TURNO. */
  private static final int WIDTH_TURNO = 20;

  /** The Constant Y_TURNO. */
  private static final int Y_TURNO = 5;

  /** The Constant INDICE3. */
  private static final int INDICE3 = 3;

  /** The Constant INDICE4. */
  private static final int INDICE4 = 4;

  /** The Constant INDICE5. */
  private static final int INDICE5 = 5;

  /** The Constant X1_RAZA. */
  //OFFSETS DE HABILIDADADES
  private static final int X1_RAZA = 95;

  /** The Constant Y1_RAZA. */
  private static final int Y1_RAZA = 94;

  /** The Constant X2_RAZA. */
  private static final int X2_RAZA = X1_RAZA;

  /** The Constant Y2_RAZA. */
  private static final int Y2_RAZA = 168;

  /** The Constant X1_CASTA. */
  private static final int X1_CASTA = 268;

  /** The Constant X2_CASTA. */
  private static final int X2_CASTA = X1_CASTA;

  /** The Constant Y1_CASTA. */
  private static final int Y1_CASTA = 94;

  /** The Constant Y2_CASTA. */
  private static final int Y2_CASTA = 168;

  /** The Constant X3_CASTA. */
  private static final int X3_CASTA = 442;

  /** The Constant Y3_CASTA. */
  private static final int Y3_CASTA = 94;

  /** The Constant X4_CASTA. */
  private static final int X4_CASTA = X3_CASTA;

  /** The Constant Y4_CASTA. */
  private static final int Y4_CASTA = 168;

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
         .getHabilidadesCasta()[1]), BOTONES[INDICE3][0], BOTONES[INDICE3][1],
         ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get("Ignorar Defensa"), BOTONES[INDICE4][0], BOTONES[0][1],
         ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades()
         .get("Ser Energizado"), BOTONES[INDICE5][0], BOTONES[INDICE5][1],
         ANCHOBOTON, ANCHOBOTON, null);

    // Dibujo las leyendas
    g.setFont(new Font("Book Antiqua", 1, SIZELEYENDA));
    g.drawString(personaje.getHabilidadesRaza()[0], X + X1_RAZA, Y + Y1_RAZA);
    g.drawString(personaje.getHabilidadesRaza()[1], X + X2_RAZA, Y + Y2_RAZA);
    g.drawString(personaje
        .getHabilidadesCasta()[0], X + X1_CASTA, Y + Y1_CASTA);
    g.drawString(personaje
        .getHabilidadesCasta()[1], X + X2_CASTA, Y + Y2_CASTA);
    g.drawString(personaje
        .getHabilidadesCasta()[2], X + X3_CASTA, Y + Y3_CASTA);
    g.drawString("Ser energizado", X + X4_CASTA, Y + Y4_CASTA);

    // Dibujo el turno de quien es
    g.setColor(Color.WHITE);
    if (habilitado) {
      Pantalla.centerString(g, new Rectangle(X, Y + Y_TURNO, Recursos
          .getMenuBatalla().getWidth(), WIDTH_TURNO), "Mi Turno");
    } else {
      Pantalla.centerString(g, new Rectangle(X, Y + Y_TURNO, Recursos
           .getMenuBatalla().getWidth(), WIDTH_TURNO), "Turno Rival");
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
