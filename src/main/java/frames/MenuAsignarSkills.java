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

  /** The puntos asignar inicial. */
  private int puntosAsignarInicial = 10;

  /** The puntos fuerza inicial. */
  private int puntosFuerzaInicial = 0;

  /** The puntos destreza inicial. */
  private int puntosDestrezaInicial = 0;

  /** The puntos inteligencia inicial. */
  private int puntosInteligenciaInicial = 0;

  /** The puntos asignar. */
  private int puntosAsignar = puntosAsignarInicial;

  /** The puntos fuerza. */
  private int puntosFuerza = puntosFuerzaInicial;

  /** The puntos destreza. */
  private int puntosDestreza = puntosDestrezaInicial;

  /** The puntos inteligencia. */
  private int puntosInteligencia = puntosInteligenciaInicial;

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
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
    setTitle("Asignar");
    setBounds(100, 100, 298, 294);
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
    labelFuerza.setBounds(50, 101, 56, 16);
    labelFuerza.setText(String.valueOf(puntosFuerzaInicial));
    contentPane.add(labelFuerza);

    final JLabel labelDestreza = new JLabel("");
    labelDestreza.setForeground(Color.WHITE);
    labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
    labelDestreza.setBounds(50, 159, 56, 16);
    labelDestreza.setText(String.valueOf(puntosDestrezaInicial));
    contentPane.add(labelDestreza);

    final JLabel labelInteligencia = new JLabel("");
    labelInteligencia.setForeground(Color.WHITE);
    labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
    labelInteligencia.setBounds(50, 217, 56, 16);
    labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));
    contentPane.add(labelInteligencia);

    final JLabel labelPuntos = new JLabel("");
    labelPuntos.setForeground(Color.WHITE);
    labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
    labelPuntos.setBounds(39, 41, 83, 26);
    labelPuntos.setText(String.valueOf(puntosAsignarInicial));
    contentPane.add(labelPuntos);

    final JLabel lblCantidadDePuntos =
        new JLabel("Cantidad de Puntos a Asignar");
    lblCantidadDePuntos.setForeground(Color.WHITE);
    lblCantidadDePuntos.setBounds(12, 13, 177, 29);
    contentPane.add(lblCantidadDePuntos);

    final JLabel lblInteligencia = new JLabel("Inteligencia");
    lblInteligencia.setForeground(Color.WHITE);
    lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
    lblInteligencia.setBounds(39, 188, 83, 16);
    contentPane.add(lblInteligencia);

    JLabel lblDestreza = new JLabel("Destreza");
    lblDestreza.setForeground(Color.WHITE);
    lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
    lblDestreza.setBounds(50, 130, 56, 16);
    contentPane.add(lblDestreza);

    final JLabel lblFuerza = new JLabel("Fuerza");
    lblFuerza.setForeground(Color.WHITE);
    lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
    lblFuerza.setBounds(50, 72, 56, 16);
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
    buttonConfirm.setBounds(176, 112, 97, 25);
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
    buttonCancel.setBounds(176, 146, 97, 25);
    contentPane.add(buttonCancel);

    final JButton buttonReset = new JButton("Resetear");
    ImageIcon iconoReset =
        new ImageIcon("recursos//botonResetear.png");
    buttonReset.setIcon(iconoReset);
    buttonReset.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
        puntosAsignarInicial =
            (cliente.getPaquetePersonaje().getNivel() - 1) * 3;
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
    buttonReset.setBounds(176, 210, 97, 25);
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
                if (puntosInteligencia != 200) {
                  buttonMore2.setEnabled(true);
                }
                if (puntosDestreza != 200) {
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
    buttonMinus.setBounds(12, 92, 34, 25);
    contentPane.add(buttonMinus);

    buttonMinus1.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (puntosDestreza > puntosDestrezaInicial) {
              puntosDestreza--;
            if (puntosAsignar == 0) {
                if (puntosInteligencia != 200) {
                  buttonMore2.setEnabled(true);
                }
              if (puntosFuerza != 200) {
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
    buttonMinus1.setBounds(12, 159, 34, 25);
    contentPane.add(buttonMinus1);

    buttonMinus2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
          if (puntosInteligencia > puntosInteligenciaInicial) {
              puntosInteligencia--;
              if (puntosAsignar == 0) {
                if (puntosFuerza != 200) {
                  buttonMore.setEnabled(true);
                }
                if (puntosDestreza != 200) {
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
    buttonMinus2.setBounds(12, 217, 34, 25);
    contentPane.add(buttonMinus2);

    buttonMore.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
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
    ImageIcon icono_2 = new ImageIcon("recursos//botonMass.png");
    buttonMore.setIcon(icono_2);
    buttonMore.setBounds(118, 92, 34, 25);
    contentPane.add(buttonMore);


    buttonMore1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
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
    buttonMore1.setIcon(icono_2);
    buttonMore1.setBounds(118, 159, 34, 25);
    contentPane.add(buttonMore1);

    buttonMore2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (puntosAsignar != 0 && !labelInteligencia.getText().equals("200")) {
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
            if (puntosAsignar == 0 || labelInteligencia.getText().equals("200")) {
              buttonMore2.setEnabled(false);
            }
          }
        }
      });
    buttonMore2.setIcon(icono_2);
    buttonMore2.setBounds(118, 217, 34, 25);
    contentPane.add(buttonMore2);
    
    final JLabel imageLabel = new JLabel(new ImageIcon("recursos//background.jpg")); 
    imageLabel.setBounds(0, 0, 298, 294);
    imageLabel.setVisible(true);
    contentPane.add(imageLabel);
  }
}
