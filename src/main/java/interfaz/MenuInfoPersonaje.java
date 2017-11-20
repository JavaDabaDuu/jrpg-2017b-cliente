
package interfaz;

import dominio.Personaje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;

import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class MenuInfoPersonaje.
 */
public class MenuInfoPersonaje {

  /** The Constant anchoPersonaje. */
  private static final int ANCHOPERSONAJE = 128;

  /** The Constant menu. */
  private static final BufferedImage MENU = Recursos.getMenuEnemigo();

  /** The Constant menuBatallar. */
  public static final int MENUBATALLAR = 0;

  /** The Constant menuInformacion. */
  public static final int MENUINFORMACION = 1;

  /** The Constant menuSubirNivel. */
  public static final int MENUSUBIRNIVEL = 2;

  /** The Constant menuGanarBatalla. */
  public static final int MENUGANARBATALLA = 3;

  /** The Constant menuPerderBatalla. */
  public static final int MENUPERDERBATALLA = 4;

  /** The Constant menuGanarItem. */
  public static final int MENUGANARITEM = 5;

  /** The Constant menuComerciar. */
  public static final int MENUCOMERCIAR = 6;

  /** The Constant leyendaBoton. */
  private static final String[] LEYENDABOTON = {"Batallar", "Volver",
    "Aceptar", "Aceptar", "Aceptar", "Aceptar", "Comerciar"};

  /** The x. */
  private int x;

  /** The y. */
  private int y;

  /** The personaje. */
  private PaquetePersonaje personaje;

  /** The Constant SIZE1. */
  private static final int SIZE1 = 20;

  /** The Constant SIZE2. */
  private static final int SIZE2 = 14;

  /** The Constant SIZE3. */
  private static final int SIZE3 = 18;

  /** The Constant SIZE4. */
  private static final int SIZE4 = 62;

  /** The Constant IMAGEN_6. */
  private static final int IMAGEN_6 = 6;

  /** The Constant OFFSET_Y. */
  private static final int OFFSET_Y =  70;

  /** The Constant Y_OFFSET. */
  private static final int Y_OFFSET = 325;

  /** The Constant WIDTH. */
  private static final int WIDTH = 128;

  /** The Constant HEIGHT. */
  private static final int HEIGHT = 128;

  /** The Constant OFFSET_Y_RECTANGULO. */
  private static final int OFFSET_Y_RECTANGULO = 15;

  /** The Constant X_BOTTON_MENU. */
  private static final int X_BOTTON_MENU = 50;

  /** The Constant Y_BOTTON_MENU. */
  private static final int Y_BOTTON_MENU = 380;

  /** The Constant WIDTH_BOTTON_MENU. */
  private static final int WIDTH_BOTTON_MENU = 200;

  /** The Constant HEIGHT_BOTTON_MENU. */
  private static final int HEIGHT_BOTTON_MENU = 25;

  /** The Constant Y_RECTAGULO_1. */
  private static final int Y_RECTAGULO_1 = 200;

  /** The Constant Y_RECTAGULO_2. */
  private static final int Y_RECTAGULO_2 = 250;

  /** The Constant Y_RECTAGULO_3. */
  private static final int Y_RECTAGULO_3 = 270;

  /** The Constant Y_RECTAGULO_4. */
  private static final int Y_RECTAGULO_4 = 290;

  /** The Constant Y_RECTAGULO_5. */
  private static final int Y_RECTAGULO_5 = 310;

  /** The Constant Y_RECTAGULO_6. */
  private static final int Y_RECTAGULO_6 = 230;

  /** The Constant Y_RECTAGULO_7. */
  private static final int Y_RECTAGULO_7 = 330;

  /** The Constant Y_RECTAGULO_8. */
  private static final int Y_RECTAGULO_8 = 240;
  /**
   * Instantiates a new menu info personaje.
   *
   * @param xAux the x
   * @param yAux the y
   * @param personajeAux the personaje
   */
  public MenuInfoPersonaje(final int xAux, final int yAux,
  final PaquetePersonaje personajeAux) {
    this.x = xAux;
    this.y = yAux;
    this.personaje = personajeAux;
  }

  /**
   * Graficar.
   *
   * @param g the g
   * @param tipoMenu the tipo menu
   */
  public void graficar(final Graphics g, final int tipoMenu) {

    // dibujo el menu
    g.drawImage(MENU, x, y, null);

    // dibujo el personaje
    g.drawImage(Recursos.getPersonaje().get(personaje.getRaza())
        .get(IMAGEN_6)[0], x + MENU.getWidth() / 2
        - ANCHOPERSONAJE / 2, y + OFFSET_Y, WIDTH, HEIGHT, null);

    // muestro el nombre
    g.setColor(Color.WHITE);
    g.setFont(new Font("Book Antiqua", 1, SIZE1));
    Pantalla.centerString(g, new Rectangle(x, y + OFFSET_Y_RECTANGULO,
        MENU.getWidth(), 0), personaje.getNombre());
    // Grafico la leyenda segun el tipo de menu
    switch (tipoMenu) {
      case MENUBATALLAR:
        graficarMenuInformacion(g);
        break;
      case MENUINFORMACION:
        graficarMenuInformacion(g);
        break;
      case MENUSUBIRNIVEL:
        graficarMenuSubirNivel(g);
        break;
      case MENUGANARBATALLA:
        graficarMenuGanarBatalla(g);
        break;
      case MENUPERDERBATALLA:
        graficarMenuPerderBatalla(g);
        break;
      case MENUGANARITEM:
        graficarMenuItem(g);
        break;
      case MENUCOMERCIAR:
        graficarMenuComerciar(g);
        break;
    }


    // muestro los botones
    g.setFont(new Font("Book Antiqua", 1, SIZE1));
    g.drawImage(Recursos.getBotonMenu(), x
    + X_BOTTON_MENU, y + Y_BOTTON_MENU, WIDTH_BOTTON_MENU,
    HEIGHT_BOTTON_MENU, null);
    g.setColor(Color.WHITE);
    Pantalla.centerString(g,
       new Rectangle(x + X_BOTTON_MENU,
       y + Y_BOTTON_MENU, WIDTH_BOTTON_MENU,
       HEIGHT_BOTTON_MENU), LEYENDABOTON[tipoMenu]);
  }

  /**
   * Graficar menu perder batalla.
   *
   * @param g the g
   */
  private void graficarMenuPerderBatalla(final Graphics g) {

    // Informo que perdio la batalla
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_1,
        MENU.getWidth(), 0), "¡Has sido derrotado!");
    g.setFont(new Font("Book Antiqua", 0, SIZE2));
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_2, MENU.getWidth(), 0),
        "¡No te rindas! Sigue luchando");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_3, MENU.getWidth(), 0),
        "contra los demás personajes");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_4, MENU.getWidth(), 0),
        "para aumentar tu nivel y");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_5, MENU.getWidth(), 0),
        "mejorar tus atributos.");
  }

  /**
   * Graficar menu ganar batalla.
   *
   * @param g the g
   */
  private void graficarMenuGanarBatalla(final Graphics g) {

    // Informo que gano la batalla
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_1,
        MENU.getWidth(), 0), "¡Has derrotado");
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_6,
        MENU.getWidth(), 0), "a tu enemigo!");

    g.setFont(new Font("Book Antiqua", 0, SIZE2));
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_3, MENU.getWidth(), 0),
        "¡Felicitaciones! Has derrotado");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_4, MENU.getWidth(), 0),
        "a tu oponente, sigue así");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_5, MENU.getWidth(), 0),
        "para lograr subir de nivel");
    Pantalla.centerString(g,
        new Rectangle(x, y + Y_RECTAGULO_7, MENU.getWidth(), 0),
        "y mejorar tus atributos.");
  }

  /**
   * Graficar menu subir nivel.
   *
   * @param g the g
   */
  private void graficarMenuSubirNivel(final Graphics g) {

    // Informo que subio de nivel
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_1,
        MENU.getWidth(), 0), "¡Has subido de nivel!");
    g.setFont(new Font("Book Antiqua", 0, SIZE3));
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_8,
        MENU.getWidth(), 0), "¡Felicitaciones!");
    Pantalla.centerString(g, new Rectangle(x, y + Y_RECTAGULO_3,
        MENU.getWidth(), 0), "Nuevo Nivel");
    g.setFont(new Font("Book Antiqua", 1, SIZE4));
    Pantalla.centerString(g,
         new Rectangle(x, y + Y_OFFSET, MENU.getWidth(), 0),
         String.valueOf(personaje.getNivel()));
  }


  /**
   * Graficar menu informacion.
   *
   * @param g the g
   */
  public void graficarMenuInformacion(final Graphics g) {

    // muestro los nombres de los atributos
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + 200, MENU.getWidth(), 0),
        personaje.getRaza());
    g.drawString("Casta: ", x + 30, y + 260);
    g.drawString("Nivel: ", x + 30, y + 290);
    g.drawString("Experiencia: ", x + 30, y + 320);

    // muestro los atributos
    g.setFont(new Font("Book Antiqua", 0, 20));
    g.drawString(personaje.getCasta(), x + 100, y + 260);
    g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
    g.drawString(personaje.getExperiencia() + " / " + Personaje
        .getTablaDeNiveles()[personaje.getNivel() + 1], x + 150, y + 320);

  }

  /**
   * Graficar menu item.
   *
   * @param g the g
   */
  private void graficarMenuItem(final Graphics g) {

    // Informo que subio de nivel
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + 200,
        MENU.getWidth(), 0), "¡Aca iria algo!");

    g.setFont(new Font("Book Antiqua", 0, 18));
    Pantalla.centerString(g, new Rectangle(x, y + 240,
        MENU.getWidth(), 0), "¡Aca otra cosa!");
    Pantalla.centerString(g, new Rectangle(x, y + 270,
        MENU.getWidth(), 0), "Nuevo Nivel");
    g.setFont(new Font("Book Antiqua", 1, 62));
    Pantalla.centerString(g,
        new Rectangle(x, y + 325, MENU.getWidth(), 0),
        String.valueOf(personaje.getNivel()));
  }

  /**
   * Graficar menu comerciar.
   *
   * @param g the g
   */
  private void graficarMenuComerciar(final Graphics g) {

    // muestro los nombres de los atributos
    g.setColor(Color.BLACK);
    Pantalla.centerString(g, new Rectangle(x, y + 200,
        MENU.getWidth(), 0), personaje.getRaza());
    g.drawString("Casta: ", x + 30, y + 260);
    g.drawString("Nivel: ", x + 30, y + 290);
    g.drawString("Experiencia: ", x + 30, y + 320);

    // muestro los atributos
    g.setFont(new Font("Book Antiqua", 0, 20));
    g.drawString(personaje.getCasta(), x + 100, y + 260);
    g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
    g.drawString(personaje.getExperiencia() + " / " + Personaje
        .getTablaDeNiveles()[personaje.getNivel() + 1], x + 150, y + 320);
  }

  /**
   * Click en boton.
   *
   * @param mouseX the mouse X
   * @param mouseY the mouse Y
   * @return true, if successful
   */
  public boolean clickEnBoton(final int mouseX, final int mouseY) {
    return (mouseX >= x + 50 && mouseX <= x + 250
    && mouseY >= y + 380 && mouseY <= y + 405);
  }

  /**
   * Click en cerrar.
   *
   * @param mouseX the mouse X
   * @param mouseY the mouse Y
   * @return true, if successful
   */
  public boolean clickEnCerrar(final int mouseX, final int mouseY) {
    return (mouseX >= x + MENU.getWidth() - 24 && mouseX <= x + MENU
        .getWidth() + 4 && mouseY >= y + 12 && mouseY <= y + 36);
  }

  /**
   * Click en menu.
   *
   * @param mouseX the mouse X
   * @param mouseY the mouse Y
   * @return true, if successful
   */
  public boolean clickEnMenu(final int mouseX, final int mouseY) {
    return (mouseX >= x && mouseX <= x + MENU
        .getWidth() && mouseY >= y  && mouseY <= y + MENU.getHeight());
  }
}
