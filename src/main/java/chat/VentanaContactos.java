package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * The Class VentanaContactos.
 */
public class VentanaContactos extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** The modelo. */
  private DefaultListModel<String> modelo = new DefaultListModel<String>();

  /** The list. */
  private static JList<String> list = new JList<String>();

  /** The boton mc. */
  private static JButton botonMc;

  /** The background. */
  private JLabel background;

  /** Constant X_BORDER. */
  private static final int X_BOR = 5;

  /** Constant Y_BORDER. */
  private static final int Y_BOR = 5;

  /** Constant HEIGHT_BORDER. */
  private static final int HEIGHT_BOR = 5;

  /** Constant WIDTH_BORDER. */
  private static final int WIDTH_BOR = 5;

  /** Constant X_SCROLL .*/
  private static final int X_SCROLL = 10;

  /** Constant Y_SCROLL .*/
  private static final int Y_SCROLL = 11;

  /** Constant HEIGHT_SCROLL .*/
  private static final int HEIGHT_SCROLL = 299;

  /** Constant WIDTH_SCROLL .*/
  private static final int WIDTH_SCROLL = 188;

  /** Constant X_FONDO. */
  private static final int X_FONDO = -16;

  /** Constant Y_FONDO. */
  private static final int Y_FONDO = 0;

  /** Constant HEIGHT_FONDO. */
  private static final int HEIGHT_FONDO = 352;

  /** Constant WIDTH_FONDO. */
  private static final int WIDTH_FONDO = 254;

  /** Constant X_MC. */
  private static final int X_MC = 119;

  /** Constant Y_MC. */
  private static final int Y_MC = 208;

 /** Constant WIDTH_MC. */
  private static final int WIDTH_MC = 89;

  /** Constant HEIGHT_MC. */
  private static final int HEIGHT_MC = 23;

  /** Constant X_CONTACT. */
  private static final int X_CONTACT = 100;

  /** Constant Y_CONTACT. */
  private static final int Y_CONTACT = 100;

 /** Constant WIDTH_CONTACT. */
  private static final int WIDTH_CONTACT = 327;

  /** Constant HEIGHT_CONTACT. */
  private static final int HEIGHT_CONTACT = 273;

  /**
   * Create the frame.
   *
   * @param juego the juego
   */
  public VentanaContactos(final Juego juego) {
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(X_CONTACT, Y_CONTACT, HEIGHT_CONTACT, WIDTH_CONTACT);
    setLocationRelativeTo(null);
    setTitle("Usuarios");

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(X_SCROLL, Y_SCROLL, HEIGHT_SCROLL, WIDTH_SCROLL);
    contentPane.add(scrollPane);

    addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(final WindowEvent arg0) {
            Pantalla.setVentContac(null);
            dispose();
        }
        });

    botonMc = new JButton("Multichat");
    botonMc.setIcon(new ImageIcon("recursos//multichatButton.png"));
    botonMc.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (modelo.size() != 0) {
              if (!juego.getChatsActivos().containsKey("Sala")) {
                MiChat chat = new MiChat(juego);
                juego.getChatsActivos().put("Sala", chat);
                chat.setTitle("Sala");
                chat.setVisible(true);
                botonMc.setEnabled(false);
              }
            }
          }
        });
    botonMc.setBounds(X_MC, Y_MC, HEIGHT_MC, WIDTH_MC);
    contentPane.add(botonMc);

    // Cargo la lista de contactos
    actualizarLista(juego);
    // Pregunto si la ventana sala esta abierta y cancelo el boton multichat
    if (juego.getChatsActivos().containsKey("Sala")) {
      botonMc.setEnabled(false);
    } else {
      botonMc.setEnabled(true);
    }

    list.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(final MouseEvent arg0) {
            if (arg0.getClickCount() == 2) {
              if (list.getSelectedValue() != null) {
                if (!juego.getChatsActivos()
                .containsKey(list.getSelectedValue())) {
                  if (juego.getCliente() != null) {
                    MiChat chat = new MiChat(juego);
                    juego.getChatsActivos().put(list.getSelectedValue(), chat);
                    chat.setTitle(list.getSelectedValue());
                    chat.setVisible(true);
                  }
                }
              }
            }
          }
        });


    list.setModel(modelo);
    scrollPane.setViewportView(list);

    background = new JLabel(new ImageIcon("recursos//background.jpg"));
    background.setBounds(X_FONDO, Y_FONDO, HEIGHT_FONDO, WIDTH_FONDO);
    contentPane.add(background);
  }

  /**
   * Actualizar lista.
   *
   * @param juego the juego
   */
  private void actualizarLista(final Juego juego) {
    if (juego.getCliente() != null) {
      synchronized (juego.getCliente()) {
        modelo.removeAllElements();
        if (juego.getPersonajesConectados() != null) {
          for (Map.Entry<Integer,
          PaquetePersonaje> personaje : juego.getPersonajesConectados(
           ).entrySet()) {
            modelo.addElement(personaje.getValue().getNombre());
          }
          modelo.removeElement(juego.getPersonaje().getNombre());
          list.setModel(modelo);
        }
      }
    }
  }

  /**
   * Gets the list.
   *
   * @return the list
   */
  public static JList<String> getList() {
    return list;
  }

  /**
   * Gets the boton mc.
   *
   * @return the boton mc
   */
  public static JButton getBotonMc() {
    return botonMc;
  }
}
