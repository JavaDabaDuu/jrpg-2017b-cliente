
package frames;

import cliente.Cliente;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

/**
 * The Class MenuCreacionPj.
 */
public class MenuCreacionPj extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** The nombre. */
  private JTextField nombre;

  /** The destreza. */
  private JLabel destreza;

  /** The fuerza. */
  private JLabel fuerza;

  /** The inteligencia. */
  private JLabel inteligencia;

  /** The salud. */
  private JLabel salud;

  /** The energia. */
  private JLabel energia;

  /** The cbx casta. */
  private JComboBox<String> cbxCasta;

  /** The cbx raza. */
  private JComboBox<String> cbxRaza;

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

  /** Constant HEIGHT_DEFAULT. */
  private static final int HEIGHT_DEFAULT = 300;

  /** Constant WIDTH_PANE. */
  private static final int WIDTH_PANE = 444;

  /** Constant HEIGHT_PANE. */
  private static final int HEIGHT_PANE = 271;

  /** Constant X_FUERZA. */
  private static final int X_FUERZA = 33;

  /** Constant Y_FUERZA. */
  private static final int Y_FUERZA = 100;

  /** Constant HEIGHT_FUERZA. */
  private static final int HEIGHT_FUERZA = 46;

  /** Constant WIDTH_FUERZA. */
  private static final int WIDTH_FUERZA = 14;

  /** Constant X_FUERZA1. */
  private static final int X_FUERZA1 = 110;

  /** Constant Y_FUERZA1. */
  private static final int Y_FUERZA1 = 102;

  /** Constant HEIGHT_FUERZA1. */
  private static final int HEIGHT_FUERZA1 = 22;

  /** Constant WIDTH_FUERZA1. */
  private static final int WIDTH_FUERZA1 = 14;

  /** Constant  VALOR_13. */
  private static final int  VALOR_13 = 13;

  /** Constant  VALOR_15. */
  private static final int  VALOR_15 = 15;

  /** Constant X_RAZA. */
  private static final int X_RAZA = 32;

  /** Constant Y_RAZA. */
  private static final int Y_RAZA = 48;

  /** Constant HEIGHT_RAZA. */
  private static final int HEIGHT_RAZA = 76;

  /** Constant WIDTH_RAZA. */
  private static final int WIDTH_RAZA = 20;

  /** Constant HEIGHT_FONDO. */
  private static final int HEIGHT_FONDO = 444;

  /** Constant WIDTH_FONDO. */
  private static final int WIDTH_FONDO = 271;

  /** Constant X_CASTA. */
  private static final int X_CASTA = 161;

  /** Constant Y_CASTA. */
  private static final int Y_CASTA = 48;

  /** Constant HEIGHT_CASTA. */
  private static final int HEIGHT_CASTA = 76;

  /** Constant WIDTH_CASTA. */
  private static final int WIDTH_CASTA = 20;

  /** Constant X_CASTA1. */
  private static final int X_CASTA1 = 161;

  /** Constant Y_CASTA1. */
  private static final int Y_CASTA1 = 23;

  /** Constant HEIGHT_CASTA1. */
  private static final int HEIGHT_CASTA1 = 46;

  /** Constant WIDTH_CASTA1. */
  private static final int WIDTH_CASTA1 = 14;

  /** Constant X_DEFAULT1. */
  private static final int X_DEFAULT1 = 33;

  /** Constant Y_DEFAULT1. */
  private static final int Y_DEFAULT1 = 23;

 /** Constant WIDTH_DEFAULT1. */
  private static final int WIDTH_DEFAULT1 = 46;

  /** Constant HEIGHT_DEFAULT1. */
  private static final int HEIGHT_DEFAULT1 = 14;

  /** Constant X_BACEPT. */
  private static final int X_BACEPT = 230;

  /** Constant Y_BACEPT. */
  private static final int Y_BACEPT = 174;

  /** Constant HEIGHT_BACEPT. */
  private static final int HEIGHT_BACEPT = 153;

  /** Constant WIDTH_BACEPT. */
  private static final int WIDTH_BACEPT = 23;

  /** Constant X_LACEPT. */
  private static final int X_LACEPT = 280;

  /** Constant Y_LACEPT. */
  private static final int Y_LACEPT = 173;

  /** Constant HEIGHT_LACEPT. */
  private static final int HEIGHT_LACEPT = 50;

  /** Constant WIDTH_LACEPT. */
  private static final int WIDTH_LACEPT = 24;

  /** Constant VALOR_10. */
  private static final int VALOR_10 = 10;

  /** Constant X_NOM. */
  private static final int X_NOM = 277;

  /** Constant Y_NOM. */
  private static final int Y_NOM = 122;

  /** Constant HEIGHT_NOM. */
  private static final int HEIGHT_NOM = 122;

  /** Constant WIDTH_NOM. */
  private static final int WIDTH_NOM = 20;

  /**
   * Instantiates a new menu creacion pj.
   *
   * @param cliente the cliente
   * @param personaje the personaje
   * @param gson the gson
   */
  public MenuCreacionPj(final Cliente cliente,
      final PaquetePersonaje personaje, final Gson gson) {
    setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/main/java/frames/IconoWome.png"));
    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
        new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
        new Point(0, 0), "custom cursor"));

    final String[] vecSalud = {"55", "50", "60"};
    final String[] vecEnergia = {"55", "60", "50"};
    final String[] vecFuerza = {"15", "10", "10"};
    final String[] vecDestreza = {"10", "10", "15"};
    final String[] vecInteligencia = {"10", "15", "10"};

    // En caso de cerrar
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
            personaje.setNombre(nombre.getText());
            if (nombre.getText().equals("")) {
            personaje.setNombre("nameless");
            personaje.setRaza((String) cbxRaza
                 .getSelectedItem());
            personaje.setSaludTope(Integer
                .parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
            personaje.setEnergiaTope(Integer
                .parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
            personaje.setCasta((String) cbxCasta.getSelectedItem());
            personaje.setFuerza(Integer
                .parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
            personaje.setDestreza(Integer
                .parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
            personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta
                .getSelectedIndex()]));
            synchronized (cliente) {
              cliente.notify();
              }
            dispose();
          }
        }
    });

    setTitle("WOME - Crear personaje");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);
    setBounds(X_DEFAULT, Y_DEFAULT, HEIGHT_DEFAULT, WIDTH_DEFAULT);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setLocationRelativeTo(null);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, HEIGHT_PANE, WIDTH_PANE);
    contentPane.add(layeredPane);

    JLabel lblNewLabelFuerza = new JLabel("Fuerza");
    lblNewLabelFuerza.setBounds(X_FUERZA, Y_FUERZA, HEIGHT_FUERZA,
    WIDTH_FUERZA);
    layeredPane.add(lblNewLabelFuerza, new Integer(1));
    lblNewLabelFuerza.setForeground(Color.WHITE);
    lblNewLabelFuerza.setFont(new Font("Tahoma", Font.PLAIN, VALOR_13));

    fuerza = new JLabel("15");
    fuerza.setBounds(X_FUERZA1, Y_FUERZA1, HEIGHT_FUERZA1, WIDTH_FUERZA1);
    layeredPane.add(fuerza, new Integer(1));
    fuerza.setForeground(Color.GREEN);

    JLabel lblDestreza = new JLabel("Destreza");
    lblDestreza.setBounds(33, 126, 60, 14);
    layeredPane.add(lblDestreza, new Integer(1));
    lblDestreza.setForeground(Color.WHITE);
    lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, VALOR_13));

    destreza = new JLabel("10");
    destreza.setBounds(110, 127, 22, 14);
    layeredPane.add(destreza, new Integer(1));
    destreza.setForeground(Color.GREEN);

    JLabel lblInteligencia = new JLabel("Inteligencia");
    lblInteligencia.setBounds(33, 151, 66, 22);
    layeredPane.add(lblInteligencia, new Integer(1));
    lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, VALOR_13));
    lblInteligencia.setForeground(Color.WHITE);

    inteligencia = new JLabel("10");
    inteligencia.setBounds(110, 156, 22, 14);
    layeredPane.add(inteligencia, new Integer(1));
    inteligencia.setForeground(Color.GREEN);

    JLabel lblSalud = new JLabel("Salud");
    lblSalud.setBounds(33, 183, 46, 14);
    layeredPane.add(lblSalud, new Integer(1));
    lblSalud.setFont(new Font("Tahoma", Font.PLAIN, VALOR_13));
    lblSalud.setForeground(Color.WHITE);

    salud = new JLabel("55");
    salud.setBounds(110, 183, 22, 14);
    layeredPane.add(salud, new Integer(1));
    salud.setForeground(Color.GREEN);

    JLabel lblEnergia = new JLabel("Energia");
    lblEnergia.setBounds(33, 204, 46, 20);
    layeredPane.add(lblEnergia, new Integer(1));
    lblEnergia.setForeground(Color.WHITE);
    lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, VALOR_13));

    energia = new JLabel("55");
    energia.setBounds(110, 208, 22, 14);
    layeredPane.add(energia, new Integer(1));
    energia.setForeground(Color.GREEN);

    JLabel lblNewLabelNombre = new JLabel("Nombre");
    lblNewLabelNombre.setBounds(207, 125, 60, 14);
    layeredPane.add(lblNewLabelNombre, new Integer(1));
    lblNewLabelNombre.setForeground(Color.WHITE);
    lblNewLabelNombre.setFont(new Font("Tahoma", Font.PLAIN, VALOR_15));

    nombre = new JTextField();
    nombre.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent arg0) {
        crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
             vecFuerza, vecDestreza, vecInteligencia);
      }
    });
    nombre.setBounds(X_NOM, Y_NOM, HEIGHT_NOM, WIDTH_NOM);
    layeredPane.add(nombre, new Integer(1));
    nombre.setColumns(VALOR_10);

    JLabel lblAceptar = new JLabel("Aceptar");
    lblAceptar.setBounds(X_LACEPT, Y_LACEPT, HEIGHT_LACEPT, WIDTH_LACEPT);
    layeredPane.add(lblAceptar, new Integer(2));
    lblAceptar.setForeground(Color.WHITE);
    lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, VALOR_15));

    // En caso de apretar el boton aceptar
    JButton btnAceptar = new JButton("Aceptar");
    btnAceptar.setBounds(X_BACEPT, Y_BACEPT, HEIGHT_BACEPT,
    WIDTH_BACEPT);
    layeredPane.add(btnAceptar, new Integer(1));
    btnAceptar.setFocusable(false);
    btnAceptar.setIcon(new ImageIcon(MenuCreacionPj
        .class.getResource("/frames/BotonMenu.png")));

    btnAceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
          crearPj(cliente, personaje, gson, vecSalud, vecEnergia, vecFuerza,
              vecDestreza, vecInteligencia);
        }


      });

    JLabel lblNewLabel = new JLabel("Raza");
    lblNewLabel.setBounds(X_DEFAULT1, Y_DEFAULT1, HEIGHT_DEFAULT1,
    WIDTH_DEFAULT1);
    layeredPane.add(lblNewLabel, new Integer(1));
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, VALOR_15));

    JLabel lblCasta = new JLabel("Casta");
    lblCasta.setBounds(X_CASTA1, Y_CASTA1, HEIGHT_CASTA1, WIDTH_CASTA1);
    layeredPane.add(lblCasta, new Integer(1));
    lblCasta.setForeground(Color.WHITE);
    lblCasta.setFont(new Font("Tahoma", Font.PLAIN, VALOR_15));

    cbxCasta = new JComboBox<>();
    cbxCasta.setBounds(X_CASTA, Y_CASTA, HEIGHT_CASTA, WIDTH_CASTA);
    layeredPane.add(cbxCasta, new Integer(1));
    cbxCasta.addActionListener(new ActionListener() {
        @Override
       public void actionPerformed(final ActionEvent e) {
            fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
            destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
            inteligencia.setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
          }
        });
    cbxCasta.addItem("Guerrero");
    cbxCasta.addItem("Hechicero");
    cbxCasta.addItem("Asesino");

    cbxRaza = new JComboBox<>();
    cbxRaza.setBounds(X_RAZA, Y_RAZA, HEIGHT_RAZA, WIDTH_RAZA);
    layeredPane.add(cbxRaza, new Integer(1));
    cbxRaza.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
            energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
          }
        });
    cbxRaza.addItem("Humano");
    cbxRaza.addItem("Elfo");
    cbxRaza.addItem("Orco");

    JLabel lblBackground = new JLabel("");
    lblBackground.setBounds(0, 0, HEIGHT_FONDO, WIDTH_FONDO);
    layeredPane.add(lblBackground, new Integer(0));
    lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class
        .getResource("/frames/menuBackground.jpg")));
  }

  /**
   * Crear pj.
   *
   * @param cliente the cliente
   * @param personaje the personaje
   * @param gson the gson
   * @param vecSalud the vec salud
   * @param vecEnergia the vec energia
   * @param vecFuerza the vec fuerza
   * @param vecDestreza the vec destreza
   * @param vecInteligencia the vec inteligencia
   */
  protected void crearPj(final Cliente cliente,
      final PaquetePersonaje personaje,
      final Gson gson, final String[] vecSalud,
      final String[] vecEnergia, final String[] vecFuerza,
      final String[] vecDestreza,
      final String[] vecInteligencia) {

    personaje.setNombre(nombre.getText());
    if (nombre.getText().equals("")) {
      personaje.setNombre("nameless");
      personaje.setRaza((String) cbxRaza.getSelectedItem());
      personaje.setSaludTope(Integer.
      parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
      personaje.setEnergiaTope(Integer.
      parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
      personaje.setCasta((String) cbxCasta.getSelectedItem());
      personaje.setFuerza(Integer.
      parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
      personaje.setDestreza(Integer.
      parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
      personaje.setInteligencia(Integer.
      parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
      try {
        // Le envio los datos al servidor
        cliente.getPaquetePersonaje().setComando(Comando.CREACIONPJ);
        cliente.getSalida().writeObject(gson.
        toJson(cliente.getPaquetePersonaje()));
        dispose();
      } catch (JsonSyntaxException | IOException esd) {
        JOptionPane.showMessageDialog(null, "Error al crear personaje");

      }
    }
  }
}

