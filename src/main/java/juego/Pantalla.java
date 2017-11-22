package juego;

import chat.VentanaContactos;
import cliente.Cliente;

import com.google.gson.Gson;

import estados.Estado;
import frames.MenuAsignarSkills;
import frames.MenuEscape;
import frames.MenuInventario;
import frames.MenuJugar;
import frames.MenuStats;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class Pantalla.
 */
public class Pantalla {

  /** The pantalla. */
  private JFrame pantalla;

  /** The canvas. */
  private Canvas canvas;

  /** The menu inventario. */
  // Menus
  private static MenuInventario menuInventario;

  /** The menu asignar. */
  private static MenuAsignarSkills menuAsignar;

  /** The menu stats. */
  private static MenuStats menuStats;

  /** The menu escp. */
  private static MenuEscape menuEscp;

  /** The vent contac. */
  private static VentanaContactos ventContac;

  /** The gson. */
  private final Gson gson = new Gson();

  /** The cliente. */
  //Ahora necesito tener el cliente acá
  //porque sino no lo ven los metodos que muestran los menus
  private Cliente cliente;

  /** The mostradores de menus. */
  //Nombre significativo
  private HashMap<Integer, Runnable> mostradoresDeMenus
      = new HashMap<Integer, Runnable>();

  /**
   * Instantiates a new pantalla.
   *
   * @param nombre the nombre
   * @param ancho the ancho
   * @param alto the alto
   * @param clienteAux the cliente
   */
  public Pantalla(final String nombre, final int ancho,
  final int alto, final Cliente clienteAux) {
    pantalla = new JFrame(nombre);
    pantalla.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/main/java/frames/IconoWome.png"));
    pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
        new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0, 0), "custom cursor"));

    pantalla.setSize(ancho, alto);
    pantalla.setResizable(false);
    pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    pantalla.addWindowListener(new WindowAdapter() {
      @Override
    public void windowClosing(final WindowEvent evt) {
        try {
          Paquete p = new Paquete();
          p.setComando(Comando.DESCONECTAR);
          p.setIp(clienteAux.getMiIp());
          clienteAux.getSalida().writeObject(gson.toJson(p));
          clienteAux.getEntrada().close();
          clienteAux.getSalida().close();
          clienteAux.getSocket().close();
          System.exit(0);
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Fallo al intentar cerrar la aplicación.");
            System.exit(1);
          }
        }
      });

    this.cliente = clienteAux;
    // Cargo mi hashmap de runnables con la tecla
    //y el metodo que abre el menu que abre esa tecla
    this.mostradoresDeMenus.put(KeyEvent.VK_I, () -> mostrarMenuInventario());
    this.mostradoresDeMenus.put(KeyEvent.VK_A, () ->
        mostrarMenuAsignarSkills());
    this.mostradoresDeMenus.put(KeyEvent.VK_S, () -> mostrarMenuStats());
    this.mostradoresDeMenus.put(KeyEvent.VK_ESCAPE, () -> mostrarMenuEscape());
    this.mostradoresDeMenus.put(KeyEvent.VK_C, () -> mostrarVentanaContactos());

    pantalla.addKeyListener(new KeyAdapter() {
      @Override
    public void keyReleased(final KeyEvent e) {
        if (mostradoresDeMenus.get(e.getKeyCode()) != null) {
          if (Estado.getEstado().esEstadoDeJuego()) {
            mostradoresDeMenus.get(e.getKeyCode()).run();
          }
        }
      }
    });

    pantalla.setLocationRelativeTo(null);
    pantalla.setVisible(false);

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(ancho, alto));
    canvas.setMaximumSize(new Dimension(ancho, alto));
    canvas.setMinimumSize(new Dimension(ancho, alto));
    canvas.setFocusable(false);

    pantalla.add(canvas);
    pantalla.pack();
  }

  /**
   * Mostrar menu inventario.
   */
  private void mostrarMenuInventario() {
    if (getMenuInventario() == null) {
      setMenuInventario(new MenuInventario(cliente));
      getMenuInventario().setVisible(true);
    }
  }

  /**
   * Mostrar menu asignar skills.
   */
  private void mostrarMenuAsignarSkills() {
    if (getMenuAsignar() == null) {
      setMenuAsignar(new MenuAsignarSkills(cliente));
      getMenuAsignar().setVisible(true);
    }
  }

  /**
   * Mostrar menu stats.
   */
  private void mostrarMenuStats() {
    if (getMenuStats() == null) {
      setMenuStats(new MenuStats(cliente));
      getMenuStats().setVisible(true);
    }
  }

  /**
   * Mostrar menu escape.
   */
  private void mostrarMenuEscape() {
    if (getMenuEscp() == null) {
      setMenuEscp(new MenuEscape(cliente));
      getMenuEscp().setVisible(true);
    }
  }

  /**
   * Mostrar ventana contactos.
   */
  private void mostrarVentanaContactos() {
    if (getVentContac() == null) {
      setVentContac(new VentanaContactos(cliente.getJuego()));
      getVentContac().setVisible(true);
    }
  }

  /**
   * Gets the canvas.
   *
   * @return the canvas
   */
  public Canvas getCanvas() {
    return canvas;
  }

  /**
   * Gets the frame.
   *
   * @return the frame
   */
  public JFrame getFrame() {
    return pantalla;
  }

  /**
   * Mostrar.
   */
  public void mostrar() {
    pantalla.setVisible(true);
  }

  /**
   * Center string.
   *
   * @param g the g
   * @param r the r
   * @param s the s
   */
  public static void centerString(final Graphics g,
  final Rectangle r, final String s) {
    FontRenderContext frc = new FontRenderContext(null, true, true);

    Rectangle2D r2D = g.getFont().getStringBounds(s, frc);
    int rWidth = (int) Math.round(r2D.getWidth());
    int rHeight = (int) Math.round(r2D.getHeight());
    int rX = (int) Math.round(r2D.getX());
    int rY = (int) Math.round(r2D.getY());

    int a = (r.width / 2) - (rWidth / 2) - rX;
    int b = (r.height / 2) - (rHeight / 2) - rY;

    g.drawString(s, r.x + a, r.y + b);
  }

/**
 * Gets the vent contac.
 *
 * @return the vent contac
 */
public static VentanaContactos getVentContac() {
  return ventContac;
}

/**
 * Sets the vent contac.
 *
 * @param ventContacAux the new vent contac
 */
public static void setVentContac(final VentanaContactos ventContacAux) {
  Pantalla.ventContac = ventContacAux;
}

/**
 * Gets the menu inventario.
 *
 * @return the menu inventario
 */
public static MenuInventario getMenuInventario() {
  return menuInventario;
}

/**
 * Sets the menu inventario.
 *
 * @param menuInventarioAux the new menu inventario
 */
public static void setMenuInventario(final MenuInventario menuInventarioAux) {
   Pantalla.menuInventario = menuInventarioAux;
}

/**
 * Gets the menu escp.
 *
 * @return the menu escp
 */
public static MenuEscape getMenuEscp() {
  return menuEscp;
}

/**
 * Sets the menu escp.
 *
 * @param menuEscpAux the new menu escp
 */
public static void setMenuEscp(final MenuEscape menuEscpAux) {
  Pantalla.menuEscp = menuEscpAux;
}

/**
 * Gets the menu asignar.
 *
 * @return the menu asignar
 */
public static MenuAsignarSkills getMenuAsignar() {
  return menuAsignar;
}

/**
 * Sets the menu asignar.
 *
 * @param menuAsignarAux the new menu asignar
 */
public static void setMenuAsignar(final MenuAsignarSkills menuAsignarAux) {
  Pantalla.menuAsignar = menuAsignarAux;
}

/**
 * Gets the menu stats.
 *
 * @return the menu stats
 */
public static MenuStats getMenuStats() {
  return menuStats;
}

/**
 * Sets the menu stats.
 *
 * @param menuStatsAux the new menu stats
 */
public static void setMenuStats(final MenuStats menuStatsAux) {
  Pantalla.menuStats = menuStatsAux;
}

}
