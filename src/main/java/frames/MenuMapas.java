package frames;

import cliente.Cliente;
import java.awt.Color;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import mensajeria.Comando;

/**
 * The Class MenuMapas.
 */
public class MenuMapas extends JFrame {

  /** The number map. */
  private static int numberMap = 0;

  /** The content pane. */
  private JPanel contentPane;

  /**
   * Instantiates a new menu mapas.
   *
   * @param cliente the cliente
   */
  public MenuMapas(final Cliente cliente) {
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          synchronized (cliente) {
            cliente.getPaquetePersonaje().setMapa(1);
            setNumberMap(1);
            cliente.notify();
            }
            dispose();
          }
      }
    });
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/main/java/frames/IconoWome.png"));
    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
         new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
         .getImage(), new Point(0, 0), "custom cursor"));

    setTitle("Elegir Mapa");
    setBounds(100, 100, 450, 300);

    // En caso de cerrar
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

    // Panel
    setTitle("WOME - Elegir Mapa");
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setLocationRelativeTo(null);
    setResizable(false);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 444, 271);
    contentPane.add(layeredPane);

    // Mapa Aris
    JLabel lblAris = new JLabel("Aris");
    lblAris.setBounds(204, 129, 32, 23);
    layeredPane.add(lblAris, new Integer(2));
    lblAris.setForeground(Color.WHITE);
    lblAris.setFont(new Font("Tahoma", Font.PLAIN, 15));

    // Mapa Aubenor
    JLabel lblAubenor = new JLabel("Aubenor");
    lblAubenor.setBounds(191, 72, 66, 23);
    layeredPane.add(lblAubenor, new Integer(2));
    lblAubenor.setForeground(Color.WHITE);
    lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, 15));

    // Mapa Eodrim
    JLabel lblEodrim = new JLabel("Eodrim");
    lblEodrim.setBounds(198, 192, 53, 23);
    layeredPane.add(lblEodrim, new Integer(2));
    lblEodrim.setForeground(Color.WHITE);
    lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, 15));

    JButton btnAubenor = new JButton("");
    btnAubenor.setBounds(148, 72, 143, 23);
    layeredPane.add(btnAubenor, new Integer(1));
    btnAubenor.setFocusable(false);
    btnAubenor.setIcon(new ImageIcon(
        MenuMapas.class.getResource("/frames/BotonMenu.png")));

    JButton btnEodrim = new JButton("");
    btnEodrim.setBounds(148, 192, 143, 23);
    layeredPane.add(btnEodrim, new Integer(1));
    btnEodrim.setFocusable(false);
    btnEodrim.setEnabled(false);
    btnEodrim.setIcon(new ImageIcon(
        MenuMapas.class.getResource("/frames/BotonMenu.png")));
    btnEodrim.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
          synchronized (cliente) {
            cliente.getPaquetePersonaje().setMapa(3);
            cliente.notify();
          }
        dispose();
      }
    });

    btnEodrim.setEnabled(false);

    JButton btnAris = new JButton("");
    btnAris.setBounds(148, 130, 143, 23);
    layeredPane.add(btnAris, new Integer(1));
    btnAris.setFocusable(false);
    btnAris.setIcon(new ImageIcon(
        MenuMapas.class.getResource("/frames/BotonMenu.png")));
    btnAris.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
          synchronized (cliente) {
            cliente.getPaquetePersonaje().setMapa(2);
            setNumberMap(2);
            cliente.notify();
          }
        dispose();
      }
    });

    btnAris.setEnabled(true);

    JLabel lblBackground = new JLabel("");
    lblBackground.setBounds(0, 0, 444, 271);
    layeredPane.add(lblBackground, new Integer(0));
    lblBackground.setIcon(new ImageIcon(
        MenuMapas.class.getResource("/frames/menuBackground.jpg")));
    btnAubenor.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
          synchronized (cliente) {
            cliente.getPaquetePersonaje().setMapa(1);
            setNumberMap(1);
            cliente.notify();
          }
        dispose();
      }
    });
  }

/**
 * Gets the number map.
 *
 * @return the number map
 */
public static int getNumberMap() {
  return numberMap;
}

/**
 * Sets the number map.
 *
 * @param numberMapAux the new number map
 */
public static void setNumberMap(final int numberMapAux) {
  MenuMapas.numberMap = numberMapAux;
}
}

