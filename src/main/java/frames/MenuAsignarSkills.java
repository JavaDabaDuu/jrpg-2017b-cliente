package frames;

import cliente.Cliente;

import com.google.gson.Gson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego.Pantalla;
import mensajeria.Comando;


/**
 * The Class MenuAsignarSkills.
 */
public class MenuAsignarSkills extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** Constant PUNTOS_INICIALES. */
  private static final int PUNTOS_INICIALES = 10;

  /** Constant FUERZA_INICIAL. */
  private static final int FUERZA_INICIAL = 0;

  /** Constant DESTREZA_INICIAL. */
  private static final int DESTREZA_INICIAL = 0;

  /** Constant INTELIGENCIA_INICIAL. */
  private static final int INTELIGENCIA_INICIAL = 0;

  /** Constant X_BORDER. */
  private static final int X_BOR = 5;

  /** Constant Y_BORDER. */
  private static final int Y_BOR = 5;

  /** Constant HEIGHT_BORDER. */
  private static final int HEIGHT_BOR = 5;

  /** Constant WIDTH_BORDER. */
  private static final int WIDTH_BOR = 5;

  /** Constant X_DEFAULT. */
  private static final int X_DEFAULT = 100;

  /** Constant Y_DEFAULT. */
  private static final int Y_DEFAULT = 100;

 /** Constant WIDTH_DEFAULT. */
  private static final int WIDTH_DEFAULT = 450;

  /** Constant HEIGHT_EXIT. */
  private static final int HEIGHT_DEFAULT = 300;

  /** Constant X_ASIGNAR. */
  private static final int X_ASIGNAR = 100;

  /** Constant Y_ASIGNAR. */
  private static final int Y_ASIGNAR = 100;

  /** Constant HEIGHT_ASIGNAR. */
  private static final int HEIGHT_ASIGNAR = 298;

  /** Constant WIDTH_ASIGNAR. */
  private static final int WIDTH_ASIGNAR = 294;

  /** Constant X_FUERZA. */
  private static final int X_FUERZA = 50;

  /** Constant Y_FUERZA. */
  private static final int Y_FUERZA = 101;

  /** Constant HEIGHT_FUERZA. */
  private static final int HEIGHT_FUERZA = 56;

  /** Constant WIDTH_FUERZA. */
  private static final int WIDTH_FUERZA = 16;

  /** Constant X_SKILL. */
  private static final int X_SKILL = 50;

  /** Constant Y_SKILL. */
  private static final int Y_SKILL = 159;

  /** Constant HEIGHT_SKILL. */
  private static final int HEIGHT_SKILL = 56;

  /** Constant WIDTH_SKILL. */
  private static final int WIDTH_SKILL = 16;

  /** The puntos asignar inicial. */
  private int puntosAsignarInicial = PUNTOS_INICIALES;

  /** The puntos fuerza inicial. */
  private int puntosFuerzaInicial = FUERZA_INICIAL;

  /** The puntos destreza inicial. */
  private int puntosDestrezaInicial = DESTREZA_INICIAL;

  /** The puntos inteligencia inicial. */
  private int puntosInteligenciaInicial = INTELIGENCIA_INICIAL;

  /** Constant X_BRAIN. */
  private static final int X_BRAIN = 50;

  /** Constant Y_BRAIN. */
  private static final int Y_BRAIN = 217;

  /** Constant HEIGHT_BRAIN. */
  private static final int HEIGHT_BRAIN = 56;

  /** Constant WIDTH_BRAIN. */
  private static final int WIDTH_BRAIN = 16;

  /** Constant X_PUNTOS. */
  private static final int X_PUNTOS = 39;

  /** Constant Y_PUNTOS. */
  private static final int Y_PUNTOS = 41;

  /** Constant HEIGHT_PUNTOS. */
  private static final int HEIGHT_PUNTOS = 83;

  /** Constant WIDTH_PUNTOS. */
  private static final int WIDTH_PUNTOS = 26;

  /** Constant X_CANTIDADPUNTOS. */
  private static final int X_CPT = 12;

  /** Constant Y_CANTIDADPUNTOS. */
  private static final int Y_CPT = 13;

  /** Constant HEIGHT_CANTIDADPUNTOS. */
  private static final int HEIGHT_CPT = 177;

  /** Constant WIDTH_CANTIDADPUNTOS. */
  private static final int WIDTH_CPT = 29;

  /** Constant X_PUNTOSPARAINTELIGENCIA. */
  private static final int X_CINT = 39;

  /** Constant Y_PUNTOSPARAINTELIGENCIA. */
  private static final int Y_CINT = 188;

  /** Constant HEIGHT_PUNTOSPARAINTELIGENCIA. */
  private static final int HEIGHT_CINT = 83;

  /** Constant WIDTH_PUNTOSPARAINTELIGENCIA. */
  private static final int WIDTH_CINT = 16;


  /** The puntos asignar. */
  private int puntosAsignar = puntosAsignarInicial;

  /** The puntos fuerza. */
  private int puntosFuerza = puntosFuerzaInicial;

  /** The puntos destreza. */
  private int puntosDestreza = puntosDestrezaInicial;

  /** The puntos inteligencia. */
  private int puntosInteligencia = puntosInteligenciaInicial;

  /** Constant X_CANTIDAD_DESTREZA. */
  private static final int X_CSKI = 50;

  /** Constant Y_CANTIDAD_DESTREZA. */
  private static final int Y_CSKI = 130;

  /** Constant HEIGHT_CANTIDAD_DESTREZA. */
  private static final int HEIGHT_CSKI = 56;

  /** Constant WIDTH_CANTIDAD_DESTREZA. */
  private static final int WIDTH_CSKI = 16;

  /** Constant X_CANTIDAD_FUERZA. */
  private static final int X_CFRZ = 50;

  /** Constant Y_CANTIDAD_FUERZA. */
  private static final int Y_CFRZ = 72;

  /** Constant HEIGHT_CANTIDAD_FUERZA. */
  private static final int HEIGHT_CFRZ = 56;

  /** Constant WIDTH_CANTIDAD_FUERZA. */
  private static final int WIDTH_CFRZ = 16;

  /** Constant X_CONFIRM. */
  private static final int X_CONFIR = 176;

  /** Constant Y_CONFIRM. */
  private static final int Y_CONFIR = 112;

  /** Constant HEIGHT_CONFIRM. */
  private static final int HEIGHT_CONFIR = 97;

  /** Constant WIDTH_CONFIRM. */
  private static final int WIDTH_CONFIR = 25;

  /** Constant X_CANCEL. */
  private static final int X_CNL = 176;

  /** Constant Y_CANCEL. */
  private static final int Y_CNL = 146;

  /** Constant HEIGHT_CANCEL. */
  private static final int HEIGHT_CNL = 97;

  /** Constant WIDTH_CANCEL. */
  private static final int WIDTH_CNL = 25;

  /** Constant MULTIPLICA PUNTOS INICIALES POR 3. */
  private static final int MULTIPLICADOR_3 = 3;

  /** Constant X_RESET. */
  private static final int X_RESET = 176;

  /** Constant Y_RESET. */
  private static final int Y_RESET = 210;

  /** Constant HEIGHT_RESET. */
  private static final int HEIGHT_RESET = 97;

  /** Constant WIDTH_RESET. */
  private static final int WIDTH_RESET = 25;

  /** Constant PUNTOS_INTELIGENCIA. */
  private static final int PTS_INTELIGENCIA = 200;

  /** Constant PUNTOS_DESTREZA. */
  private static final int PTS_DESTREZA = 200;

  /** Constant PUNTOS_FUERZA. */
  private static final int PTS_FUERZA = 200;

  /** Constant X_MINUS. */
  private static final int X_MIN = 12;

  /** Constant Y_MINUS. */
  private static final int Y_MIN = 92;

  /** Constant HEIGHT_MINUS. */
  private static final int HEIGHT_MIN = 34;

  /** Constant WIDTH_MINUS. */
  private static final int WIDTH_MIN = 25;

  /** Constant X_MINUS1. */
  private static final int X_MIN1 = 12;

  /** Constant Y_MINUS1. */
  private static final int Y_MIN1 = 159;

  /** Constant HEIGHT_MINUS1. */
  private static final int HEIGHT_MIN1 = 34;

  /** Constant WIDTH_MINUS1. */
  private static final int WIDTH_MIN1 = 25;

  /** Constant X_MINUS2. */
  private static final int X_MIN2 = 12;

  /** Constant Y_MINUS2. */
  private static final int Y_MIN2 = 159;

  /** Constant HEIGHT_MINUS2. */
  private static final int HEIGHT_MIN2 = 34;

  /** Constant WIDTH_MINUS2. */
  private static final int WIDTH_MIN2 = 25;

  /** Constant X_MORE. */
  private static final int X_MORE = 118;

  /** Constant Y_MORE. */
  private static final int Y_MORE = 92;

  /** Constant HEIGHT_MORE. */
  private static final int HEIGHT_MORE = 34;

  /** Constant WIDTH_MORE. */
  private static final int WIDTH_MORE = 25;

  /** Constant X_MORE1. */
  private static final int X_MORE1 = 118;

  /** Constant Y_MORE1. */
  private static final int Y_MORE1 = 159;

  /** Constant HEIGHT_MORE1. */
  private static final int HEIGHT_MORE1 = 34;

  /** Constant WIDTH_MORE1. */
  private static final int WIDTH_MORE1 = 25;

  /** Constant X_MORE2. */
  private static final int X_MORE2 = 118;

  /** Constant Y_MORE2. */
  private static final int Y_MORE2 = 217;

  /** Constant HEIGHT_MORE2. */
  private static final int HEIGHT_MORE2 = 34;

  /** Constant WIDTH_MORE2. */
  private static final int WIDTH_MORE2 = 25;

  /** Constant HEIGHT_IMAGE. */
  private static final int HEIGHT_IMAGE = 298;

  /** Constant WIDTH_IMAGE. */
  private static final int WIDTH_IMAGE = 294;


  /** The gson. */
  private final Gson gson = new Gson();

  /**
   * Create the frame.
   *
   * @param cliente the cliente
   */

  public MenuAsignarSkills(final Cliente cliente) {
    puntosAsignarInicial = cliente.getPaquetePersonaje().getPuntosNivel();
    //puntosAsignarInicial = 3;
    puntosFuerzaInicial = cliente.getPaquetePersonaje().getFuerza();
    puntosDestrezaInicial = cliente.getPaquetePersonaje().getDestreza();
    puntosInteligenciaInicial = cliente.getPaquetePersonaje().getInteligencia();
    puntosAsignar = puntosAsignarInicial;
    puntosFuerza = puntosFuerzaInicial;
    puntosDestreza = puntosDestrezaInicial;
    puntosInteligencia = puntosInteligenciaInicial;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(X_DEFAULT, Y_DEFAULT, HEIGHT_DEFAULT, WIDTH_DEFAULT);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
    setTitle("Asignar");
    setBounds(X_ASIGNAR, Y_ASIGNAR, HEIGHT_ASIGNAR, WIDTH_ASIGNAR);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
    setLocationRelativeTo(null);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent arg0) {
        Pantalla.setMenuAsignar(null);
        dispose();
      }
    });

    final JLabel labelFuerza = new JLabel("");
    labelFuerza.setForeground(Color.WHITE);
    labelFuerza.setHorizontalAlignment(SwingConstants.CENTER);
    labelFuerza.setBounds(X_FUERZA, Y_FUERZA, HEIGHT_FUERZA, WIDTH_FUERZA);
    labelFuerza.setText(String.valueOf(puntosFuerzaInicial));
    contentPane.add(labelFuerza);

    final JLabel labelDestreza = new JLabel("");
    labelDestreza.setForeground(Color.WHITE);
    labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
    labelDestreza.setBounds(X_SKILL, Y_SKILL, HEIGHT_SKILL, WIDTH_SKILL);
    labelDestreza.setText(String.valueOf(puntosDestrezaInicial));
    contentPane.add(labelDestreza);

    final JLabel labelInteligencia = new JLabel("");
    labelInteligencia.setForeground(Color.WHITE);
    labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
    labelInteligencia.setBounds(X_BRAIN, Y_BRAIN, HEIGHT_BRAIN, WIDTH_BRAIN);
    labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));
    contentPane.add(labelInteligencia);

    final JLabel labelPuntos = new JLabel("");
    labelPuntos.setForeground(Color.WHITE);
    labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
    labelPuntos.setBounds(X_PUNTOS, Y_PUNTOS, HEIGHT_PUNTOS, WIDTH_PUNTOS);
    labelPuntos.setText(String.valueOf(puntosAsignarInicial));
    contentPane.add(labelPuntos);

    final JLabel lblCantidadDePuntos =
        new JLabel("Cantidad de Puntos a Asignar");
    lblCantidadDePuntos.setForeground(Color.WHITE);
    lblCantidadDePuntos.setBounds(X_CPT, Y_CPT, HEIGHT_CPT, WIDTH_CPT);
    contentPane.add(lblCantidadDePuntos);

    final JLabel lblInteligencia = new JLabel("Inteligencia");
    lblInteligencia.setForeground(Color.WHITE);
    lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
    lblInteligencia.setBounds(X_CINT, Y_CINT, HEIGHT_CINT, WIDTH_CINT);
    contentPane.add(lblInteligencia);

    JLabel lblDestreza = new JLabel("Destreza");
    lblDestreza.setForeground(Color.WHITE);
    lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
    lblDestreza.setBounds(X_CSKI, Y_CSKI, HEIGHT_CSKI, WIDTH_CSKI);
    contentPane.add(lblDestreza);

    final JLabel lblFuerza = new JLabel("Fuerza");
    lblFuerza.setForeground(Color.WHITE);
    lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
    lblFuerza.setBounds(X_CFRZ, Y_CFRZ, HEIGHT_CFRZ, WIDTH_CFRZ);
    contentPane.add(lblFuerza);

    final JButton buttonConfirm = new JButton("Confirmar");
    ImageIcon iconoConfirm =
        new ImageIcon("recursos//botonConfirmar.png");
    buttonConfirm.setIcon(iconoConfirm);
    buttonConfirm.setEnabled(false);
    buttonConfirm.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        puntosAsignarInicial = puntosAsignar;
        int bonusF = puntosFuerza - puntosFuerzaInicial;
        int bonusD = puntosDestreza - puntosDestrezaInicial;
        int bonusI = puntosInteligencia - puntosInteligenciaInicial;
        cliente.getPaquetePersonaje().useBonus(0, 0, bonusF, bonusD, bonusI);
        cliente.getPaquetePersonaje().removerBonus();
        cliente.getPaquetePersonaje()
            .setPuntosNivel(Integer.valueOf(labelPuntos.getText()));
        cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARPERSONAJELV);
        try {
          cliente.getSalida().writeObject(gson
              .toJson(cliente.getPaquetePersonaje()));
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(null, "Error al actualizar stats");

        }
        JOptionPane.showMessageDialog(null,
            "Se han actualizado tus atributos.");
        dispose();
      }
    });
    buttonConfirm.setBounds(X_CONFIR, Y_CONFIR, HEIGHT_CONFIR, WIDTH_CONFIR);
    contentPane.add(buttonConfirm);

    final JButton buttonCancel = new JButton("Cancelar");
    ImageIcon iconoC = new ImageIcon("recursos//botonCancelar.png");
    buttonCancel.setIcon(iconoC);
    buttonCancel.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent arg0) {
            Pantalla.setMenuAsignar(null);
            dispose();
          }
        });
    buttonCancel.setBounds(X_CNL, Y_CNL, HEIGHT_CNL, WIDTH_CNL);
    contentPane.add(buttonCancel);

    final JButton buttonReset = new JButton("Resetear");
    ImageIcon iconoReset =
        new ImageIcon("recursos//botonResetear.png");
    buttonReset.setIcon(iconoReset);
    buttonReset.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
        puntosAsignarInicial =
            (cliente.getPaquetePersonaje().getNivel() - 1) * MULTIPLICADOR_3;
        int energia = cliente.getPaquetePersonaje().getEnergiaTope();
        int salud = cliente.getPaquetePersonaje().getSaludTope();
        cliente.getPaquetePersonaje().setAtributos(salud, energia, 15, 10, 10);
        cliente.getPaquetePersonaje().setPuntosNivel(puntosAsignarInicial);
        cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARPERSONAJELV);
        try {
          cliente.getSalida()
              .writeObject(gson.toJson(cliente.getPaquetePersonaje()));
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(null, "Error al resetear stats");

        }
        JOptionPane.showMessageDialog(null,
            "Se han reseteado tus atributos.");
        dispose();
      }
      });
    buttonReset.setBounds(X_RESET, Y_RESET, HEIGHT_RESET, WIDTH_RESET);
    contentPane.add(buttonReset);

    final JButton buttonMinus = new JButton("");
    final JButton buttonMinus1 = new JButton("");
    final JButton buttonMinus2 = new JButton("");
    final JButton buttonMore = new JButton("");
    final JButton buttonMore1 = new JButton("");
    final JButton buttonMore2 = new JButton("");
    buttonMinus.setEnabled(false);
    buttonMinus1.setEnabled(false);
    buttonMinus2.setEnabled(false);

    ImageIcon icono1 = new ImageIcon("recursos//botonMenoss.png");
    buttonMinus.setIcon(icono1);
    buttonMinus.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosFuerza > puntosFuerzaInicial) {
              puntosFuerza--;
              if (puntosAsignar == 0) {
                if (puntosInteligencia != PTS_INTELIGENCIA) {
                  buttonMore2.setEnabled(true);
                }
                if (puntosDestreza != PTS_DESTREZA) {
                  buttonMore1.setEnabled(true);
                }
              } else {
                buttonMore.setEnabled(true);
                buttonMore1.setEnabled(true);
                buttonMore2.setEnabled(true);
              }
            puntosAsignar++;
            if (puntosAsignar == puntosAsignarInicial) {
                buttonConfirm.setEnabled(false);
              }
            labelPuntos.setText(String.valueOf(puntosAsignar));
            labelFuerza.setText(String.valueOf(puntosFuerza));
            if (puntosFuerza == puntosFuerzaInicial) {
                buttonMinus.setEnabled(false);
                buttonMore.setEnabled(true);
            } else if (puntosFuerza >= puntosFuerzaInicial) {
                buttonMore.setEnabled(true);
              }
          }
          }
      });
    buttonMinus.setBounds(X_MIN, Y_MIN, HEIGHT_MIN, WIDTH_MIN);
    contentPane.add(buttonMinus);

    buttonMinus1.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosDestreza > puntosDestrezaInicial) {
              puntosDestreza--;
            if (puntosAsignar == 0) {
                if (puntosInteligencia != PTS_INTELIGENCIA) {
                  buttonMore2.setEnabled(true);
                }
              if (puntosFuerza != PTS_FUERZA) {
                buttonMore.setEnabled(true);
              }
            } else {
              buttonMore.setEnabled(true);
              buttonMore1.setEnabled(true);
              buttonMore2.setEnabled(true);
            }
            puntosAsignar++;
            if (puntosAsignar == puntosAsignarInicial) {
                buttonConfirm.setEnabled(false);
              }
            labelPuntos.setText(String.valueOf(puntosAsignar));
            labelDestreza.setText(String.valueOf(puntosDestreza));
            if (puntosDestreza == puntosDestrezaInicial) {
                buttonMinus1.setEnabled(false);
                buttonMore1.setEnabled(true);
              } else if (puntosDestreza >= puntosDestrezaInicial) {
                buttonMore1.setEnabled(true);
              }
          }
          }
      });
    buttonMinus1.setIcon(icono1);
    buttonMinus1.setBounds(X_MIN1, Y_MIN1, HEIGHT_MIN1, WIDTH_MIN1);
    contentPane.add(buttonMinus1);

    buttonMinus2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
          if (puntosInteligencia > puntosInteligenciaInicial) {
              puntosInteligencia--;
              if (puntosAsignar == 0) {
                if (puntosFuerza != PTS_FUERZA) {
                  buttonMore.setEnabled(true);
                }
                if (puntosDestreza != PTS_DESTREZA) {
                  buttonMore1.setEnabled(true);
                }
              } else {
                buttonMore.setEnabled(true);
                buttonMore1.setEnabled(true);
                buttonMore2.setEnabled(true);
              }
            puntosAsignar++;
            if (puntosAsignar == puntosAsignarInicial) {
              buttonConfirm.setEnabled(false);
            }
            labelPuntos.setText(String.valueOf(puntosAsignar));
            labelInteligencia.setText(String.valueOf(puntosInteligencia));
            if (puntosInteligencia == puntosInteligenciaInicial) {
                buttonMinus2.setEnabled(false);
                buttonMore2.setEnabled(true);
              } else if (puntosInteligencia >= puntosInteligenciaInicial) {
                buttonMore2.setEnabled(true);
              }
            }
        }
    });
    buttonMinus2.setIcon(icono1);
    buttonMinus2.setBounds(X_MIN2, Y_MIN2, HEIGHT_MIN2, WIDTH_MIN2);
    contentPane.add(buttonMinus2);

    buttonMore.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosAsignar != 0 && !labelFuerza.getText().equals("200")) {
              puntosFuerza++;
              puntosAsignar--;
              buttonConfirm.setEnabled(true);
              labelPuntos.setText(String.valueOf(puntosAsignar));
              labelFuerza.setText(String.valueOf(puntosFuerza));
              buttonMinus.setEnabled(true);
              if (puntosAsignar == 0) {
                buttonMore.setEnabled(false);
                buttonMore1.setEnabled(false);
                buttonMore2.setEnabled(false);
              }
            }
            if (puntosAsignar == 0 || labelFuerza.getText().equals("200")) {
              buttonMore.setEnabled(false);
            }
          }
      });
    ImageIcon icono2 = new ImageIcon("recursos//botonMass.png");
    buttonMore.setIcon(icono2);
    buttonMore.setBounds(X_MORE, Y_MORE, HEIGHT_MORE, WIDTH_MORE);
    contentPane.add(buttonMore);


    buttonMore1.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosAsignar != 0 && !labelDestreza.getText().equals("200")) {
              puntosDestreza++;
              puntosAsignar--;
              buttonConfirm.setEnabled(true);
              labelPuntos.setText(String.valueOf(puntosAsignar));
              labelDestreza.setText(String.valueOf(puntosDestreza));
              buttonMinus1.setEnabled(true);
              if (puntosAsignar == 0) {
                buttonMore.setEnabled(false);
                buttonMore1.setEnabled(false);
                buttonMore2.setEnabled(false);
              }
              if (puntosAsignar == 0 || labelDestreza.getText().equals("200")) {
                buttonMore1.setEnabled(false);
              }
            }
          }
      });
    buttonMore1.setIcon(icono2);
    buttonMore1.setBounds(X_MORE1, Y_MORE1, HEIGHT_MORE1, WIDTH_MORE1);
    contentPane.add(buttonMore1);

    buttonMore2.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosAsignar != 0
            && !labelInteligencia.getText().equals("200")) {
              puntosInteligencia++;
              puntosAsignar--;
              buttonConfirm.setEnabled(true);
              labelPuntos.setText(String.valueOf(puntosAsignar));
              labelInteligencia.setText(String.valueOf(puntosInteligencia));
              buttonMinus2.setEnabled(true);
              if (puntosAsignar == 0) {
                buttonMore.setEnabled(false);
                buttonMore1.setEnabled(false);
                buttonMore2.setEnabled(false);
              }
            if (puntosAsignar == 0 || labelInteligencia.getText()
            .equals("200")) {
              buttonMore2.setEnabled(false);
            }
          }
        }
      });
    buttonMore2.setIcon(icono2);
    buttonMore2.setBounds(X_MORE2, Y_MORE2, HEIGHT_MORE2, WIDTH_MORE2);
    contentPane.add(buttonMore2);

    final JLabel imageLabel = new JLabel(new ImageIcon("recursos//background.jpg"));
    imageLabel.setBounds(0, 0, HEIGHT_IMAGE, WIDTH_IMAGE);
    imageLabel.setVisible(true);
    contentPane.add(imageLabel);
  }
}
