
package frames;

import cliente.Cliente;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import mensajeria.Comando;

/**
 * The Class MenuCarga.
 */
public class MenuCarga extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** The barra cargando. */
  private JLabel barraCargando;

  /** Constant X_TITLE. */
  private static final int X_TITLE = 100;

  /** Constant Y_TITLE. */
  private static final int Y_TITLE = 100;

  /** Constant HEIGHT_TITLE. */
  private static final int HEIGHT_TITLE = 450;

  /** Constant WIDTH_TITLE. */
  private static final int WIDTH_TITLE = 300;

  /** Constant X_BORDER. */
  private static final int X_BOR = 5;

  /** Constant Y_BORDER. */
  private static final int Y_BOR = 5;

  /** Constant HEIGHT_BORDER. */
  private static final int HEIGHT_BOR = 5;

  /** Constant WIDTH_BORDER. */
  private static final int WIDTH_BOR = 5;

  /** Constant X_LOADING. */
  private static final int X_LOADIN = 52;

  /** Constant Y_LOADING. */
  private static final int Y_LOADIN = 160;

  /** Constant HEIGHT_LOADING. */
  private static final int HEIGHT_LOADIN = 0;

  /** Constant WIDTH_LOAD. */
  private static final int WIDTH_LOADIN = 27;

  /** Constant X_LOAD. */
  private static final int X_LOAD = 47;

  /** Constant Y_LOAD. */
  private static final int Y_LOAD = 154;

  /** Constant HEIGHT_LOAD. */
  private static final int HEIGHT_LOAD = 355;

  /** Constant WIDTH_LOAD. */
  private static final int WIDTH_LOAD = 40;

  /** Constant X_LOGO. */
  private static final int X_LOGO = 109;

  /** Constant Y_LOGO. */
  private static final int Y_LOGO = 39;

  /** Constant HEIGHT_LOGO. */
  private static final int HEIGHT_LOGO = 216;

  /** Constant WIDTH_LOGO. */
  private static final int WIDTH_LOGO = 90;

  /** Constant HEIGHT_FONDO. */
  private static final int HEIGHT_FONDO = 444;

  /** Constant WIDTH_FONDO. */
  private static final int WIDTH_FONDO = 271;

  /** Constant LOADING_BAR. */
  private static final int LOADING_BAR = 27;

  /**
   * Instantiates a new menu carga.
   *
   * @param cliente the cliente
   */
  public MenuCarga(final Cliente cliente) {
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/main/java/frames/IconoWome.png"));
    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
        new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
        new Point(0, 0), "custom cursor"));

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    // En caso de cerrar la ventana
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(final WindowEvent e) {
          synchronized (cliente) {
              cliente.setAccion(Comando.SALIR);
              cliente.notify();
            }
          dispose();
        }
      });

    // Propiedades de la ventana
    setTitle("WOME - World Of the Middle Earth");
    setBounds(X_TITLE, Y_TITLE, HEIGHT_TITLE, WIDTH_TITLE);
    setLocationRelativeTo(null);
    setResizable(false);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    barraCargando = new JLabel("");
    barraCargando.setIcon(
        new ImageIcon(MenuCarga.class.getResource("/frames/Barra.png")));
    barraCargando.setBounds(X_LOADIN, Y_LOADIN, HEIGHT_LOADIN, WIDTH_LOADIN);
    contentPane.add(barraCargando);

    JLabel lblBarraCarga = new JLabel("");
    lblBarraCarga.setIcon(
        new ImageIcon(MenuCarga.class.getResource("/frames/BarraCarga.png")));
    lblBarraCarga.setBounds(X_LOAD, Y_LOAD, HEIGHT_LOAD, WIDTH_LOAD);
    contentPane.add(lblBarraCarga);

    JLabel lblLogo = new JLabel("");
    lblLogo.setIcon(
        new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
    lblLogo.setBounds(X_LOGO, Y_LOGO, HEIGHT_LOGO, WIDTH_LOGO);
    contentPane.add(lblLogo);

    JLabel lblBackground = new JLabel("");
    lblBackground.setBounds(0, 0, HEIGHT_FONDO, WIDTH_FONDO);
    contentPane.add(lblBackground);
    lblBackground.setIcon(new ImageIcon(MenuCarga.class
        .getResource("/frames/menuBackground.jpg")));
  }

  /**
   * Sets the barra cargando.
   *
   * @param ancho the new barra cargando
   */
  public void setBarraCargando(final int ancho) {
    barraCargando.setSize(ancho, LOADING_BAR);
  }
}



