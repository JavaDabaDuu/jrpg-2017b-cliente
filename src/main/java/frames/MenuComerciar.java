package frames;

import cliente.Cliente;
import com.google.gson.Gson;

import dominio.Item;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mensajeria.Comando;

/**
 * The Class MenuComerciar.
 */
public class MenuComerciar extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** The mis items. */
  private DefaultListModel<String> misItems = new DefaultListModel<String>();

  /** The dar. */
  private DefaultListModel<String> dar = new DefaultListModel<String>();

  /** The obtener. */
  private DefaultListModel<String> obtener = new DefaultListModel<String>();

  /** The cant listos. */
  private int cantListos = 0;

  /** The cant listo. */
  private JLabel cantListo;

  /** The item 1. */
  private Item item1;

  /** The count. */
  private int count = 0;

  /** The gson. */
  private final Gson gson = new Gson();

  /** The size items. */
  private int sizeItems;

  /** The chckbx listo. */
  private JCheckBox chckbxListo;

  /** The leyenda. */
  private JLabel leyenda;

  /** Constant X_MENU. */
  private static final int X_MENU = 100;

  /** Constant Y_MENU. */
  private static final int Y_MENU = 100;

  /** Constant HEIGHT_MENU. */
  private static final int HEIGHT_MENU = 610;

  /** Constant WIDTH_MENU. */
  private static final int WIDTH_MENU = 363;

  /** Constant X_BORDER. */
  private static final int X_BOR = 5;

  /** Constant Y_BORDER. */
  private static final int Y_BOR = 5;

  /** Constant HEIGHT_BORDER. */
  private static final int HEIGHT_BOR = 5;

  /** Constant WIDTH_BORDER. */
  private static final int WIDTH_BOR = 5;

  /** Constant X_CANCEL. */
  private static final int X_CANCEL = 276;

  /** Constant Y_CANCEL. */
  private static final int Y_CANCEL = 245;

  /** Constant HEIGHT_CANCEL. */
  private static final int HEIGHT_CANCEL = 97;

  /** Constant WIDTH_CANCEL. */
  private static final int WIDTH_CANCEL = 25;

  /** Constant X_ITEM. */
  private static final int X_ITEM = 12;

  /** Constant Y_ITEM. */
  private static final int Y_ITEM = 42;

  /** Constant HEIGHT_ITEM. */
  private static final int HEIGHT_ITEM = 157;

  /** Constant WIDTH_ITEM. */
  private static final int WIDTH_ITEM = 162;

  /** Constant X_ADAR. */
  private static final int X_ADAR = 244;

  /** Constant Y_ADAR. */
  private static final int Y_ADAR = 42;

  /** Constant HEIGHT_ADAR. */
  private static final int HEIGHT_ADAR = 157;

  /** Constant WIDTH_ADAR. */
  private static final int WIDTH_ADAR = 162;

  /** Constant X_OBTEN. */
  private static final int X_OBTEN = 428;

  /** Constant Y_OBTEN. */
  private static final int Y_OBTEN = 42;

  /** Constant HEIGHT_OBTEN. */
  private static final int HEIGHT_OBTEN = 157;

  /** Constant WIDTH_OBTEN. */
  private static final int WIDTH_OBTEN = 162;

  /** Constant X_ITEM1. */
  private static final int X_ITEM1 = 12;

  /** Constant Y_ITEM1. */
  private static final int Y_ITEM1 = 13;

  /** Constant HEIGHT_ITEM1. */
  private static final int HEIGHT_ITEM1 = 157;

  /** Constant WIDTH_ITEM1. */
  private static final int WIDTH_ITEM1 = 16;

  /** Constant X_INTER. */
  private static final int X_INTER = 244;

  /** Constant Y_INTER. */
  private static final int Y_INTER = 13;

  /** Constant HEIGHT_INTER. */
  private static final int HEIGHT_INTER = 157;

  /** Constant WIDTH_INTER. */
  private static final int WIDTH_INTER = 16;

  /** Constant X_IOBTEN. */
  private static final int X_IOBTEN = 428;

  /** Constant Y_IOBTEN. */
  private static final int Y_IOBTEN = 13;

  /** Constant HEIGHT_IOBTEN. */
  private static final int HEIGHT_IOBTEN = 157;

  /** Constant WIDTH_IOBTEN. */
  private static final int WIDTH_IOBTEN = 16;

  /** Constant X_SALUD. */
  private static final int X_SALUD = 12;

  /** Constant Y_SALUD. */
  private static final int Y_SALUD = 217;

  /** Constant HEIGHT_SALUD. */
  private static final int HEIGHT_SALUD = 56;

  /** Constant WIDTH_SALUD. */
  private static final int WIDTH_SALUD = 16;

  /** Constant X_ENER. */
  private static final int X_ENER = 12;

  /** Constant Y_ENER. */
  private static final int Y_ENER = 240;

  /** Constant HEIGHT_ENER. */
  private static final int HEIGHT_ENER = 56;

  /** Constant WIDTH_ENER. */
  private static final int WIDTH_ENER = 16;

  /** Constant X_FUERZA. */
  private static final int X_FUERZA = 113;

  /** Constant Y_FUERZA. */
  private static final int Y_FUERZA = 217;

  /** Constant HEIGHT_FUERZA. */
  private static final int HEIGHT_FUERZA = 56;

  /** Constant WIDTH_FUERZA. */
  private static final int WIDTH_FUERZA = 16;

  /** Constant X_DESTREZA. */
  private static final int X_DESTREZA = 113;

  /** Constant Y_DESTREZA. */
  private static final int Y_DESTREZA = 240;

  /** Constant HEIGHT_DESTREZA. */
  private static final int HEIGHT_DESTREZA = 56;

  /** Constant WIDTH_DESTREZA. */
  private static final int WIDTH_DESTREZA = 16;

  /** Constant X_BRAIN. */
  private static final int X_BRAIN = 12;

  /** Constant Y_BRAIN. */
  private static final int Y_BRAIN = 263;

  /** Constant HEIGHT_BRAIN. */
  private static final int HEIGHT_BRAIN = 71;

  /** Constant WIDTH_BRAIN. */
  private static final int WIDTH_BRAIN = 16;

  /** Constant X_SALUDE. */
  private static final int X_SALUDE = 387;

  /** Constant Y_SALUDE. */
  private static final int Y_SALUDE = 217;

  /** Constant HEIGHT_SALUDE. */
  private static final int HEIGHT_SALUDE = 56;

  /** Constant WIDTH_SALUDE. */
  private static final int WIDTH_SALUDE = 16;

  /** Constant X_ENERE. */
  private static final int X_ENERE = 387;

  /** Constant Y_ENERE. */
  private static final int Y_ENERE = 240;

  /** Constant HEIGHT_ENERE. */
  private static final int HEIGHT_ENERE = 56;

  /** Constant WIDTH_ENERE. */
  private static final int WIDTH_ENERE = 16;

  /** Constant X_FUERZAE. */
  private static final int X_FUERZAE = 497;

  /** Constant Y_FUERZAE. */
  private static final int Y_FUERZAE = 217;

  /** Constant HEIGHT_FUERZAE. */
  private static final int HEIGHT_FUERZAE = 56;

  /** Constant WIDTH_FUERZAE. */
  private static final int WIDTH_FUERZAE = 16;

  /** Constant X_DESTREZAE. */
  private static final int X_DESTREZAE = 497;

  /** Constant Y_DESTREZAE. */
  private static final int Y_DESTREZAE = 240;

  /** Constant HEIGHT_DESTREZAE. */
  private static final int HEIGHT_DESTREZAE = 56;

  /** Constant WIDTH_DESTREZAE. */
  private static final int WIDTH_DESTREZAE = 16;

  /** Constant X_ITEME. */
  private static final int X_ITEME = 387;

  /** Constant Y_ITEME. */
  private static final int Y_ITEME = 263;

  /** Constant HEIGHT_ITEME. */
  private static final int HEIGHT_ITEME = 71;

  /** Constant WIDTH_ITEME. */
  private static final int WIDTH_ITEME = 16;

  /** Constant X_LISTO. */
  private static final int X_LISTO = 276;

  /** Constant Y_LISTO. */
  private static final int Y_LISTO = 279;

  /** Constant HEIGHT_LISTO. */
  private static final int HEIGHT_LISTO = 56;

  /** Constant WIDTH_LISTO. */
  private static final int WIDTH_LISTO = 16;

  /** Constant X_BONUSS. */
  private static final int X_BONUSS = 51;

  /** Constant Y_BONUSS. */
  private static final int Y_BONUSS = 217;

  /** Constant HEIGHT_BONUSS. */
  private static final int HEIGHT_BONUSS = 56;

  /** Constant WIDTH_BONUSS. */
  private static final int WIDTH_BONUSS = 16;

  /** Constant X_BONUSE. */
  private static final int X_BONUSE = 51;

  /** Constant Y_BONUSE. */
  private static final int Y_BONUSE = 240;

  /** Constant HEIGHT_BONUSE. */
  private static final int HEIGHT_BONUSE = 56;

  /** Constant WIDTH_BONUSE. */
  private static final int WIDTH_BONUSE = 16;

  /** Constant X_BONUSF. */
  private static final int X_BONUSF = 176;

  /** Constant Y_BONUSF. */
  private static final int Y_BONUSF = 217;

  /** Constant HEIGHT_BONUSF. */
  private static final int HEIGHT_BONUSF = 56;

  /** Constant WIDTH_BONUSF. */
  private static final int WIDTH_BONUSF = 16;

  /** Constant X_BONUSD. */
  private static final int X_BONUSD = 176;

  /** Constant Y_BONUSD. */
  private static final int Y_BONUSD = 240;

  /** Constant HEIGHT_BONUSD. */
  private static final int HEIGHT_BONUSD = 56;

  /** Constant WIDTH_BONUSD. */
  private static final int WIDTH_BONUSD = 16;

  /** Constant X_BONUSI. */
  private static final int X_BONUSI = 51;

  /** Constant Y_BONUSI. */
  private static final int Y_BONUSI = 263;

  /** Constant HEIGHT_BONUSI. */
  private static final int HEIGHT_BONUSI = 56;

  /** Constant WIDTH_BONUSI. */
  private static final int WIDTH_BONUSI = 16;

  /** Constant X_SALUDE2. */
  private static final int X_SALUDE2 = 428;

  /** Constant Y_SALUDE2. */
  private static final int Y_SALUDE2 = 217;

  /** Constant HEIGHT_SALUDE2. */
  private static final int HEIGHT_SALUDE2 = 56;

  /** Constant WIDTH_SALUDE2. */
  private static final int WIDTH_SALUDE2 = 16;

  /** Constant X_ENERE2. */
  private static final int X_ENERE2 = 428;

  /** Constant Y_ENERE2. */
  private static final int Y_ENERE2 = 240;

  /** Constant HEIGHT_ENERE2. */
  private static final int HEIGHT_ENERE2 = 56;

  /** Constant WIDTH_ENERE2. */
  private static final int WIDTH_ENERE2 = 16;

  /** Constant X_FUERZAE2. */
  private static final int X_FUERZAE2 = 536;

  /** Constant Y_FUERZAE2. */
  private static final int Y_FUERZAE2 = 217;

  /** Constant HEIGHT_FUERZAE2. */
  private static final int HEIGHT_FUERZAE2 = 56;

  /** Constant WIDTH_FUERZAE2. */
  private static final int WIDTH_FUERZAE2 = 16;

  /** Constant X_DESTREZAE2. */
  private static final int X_DESTREZAE2 = 536;

  /** Constant Y_DESTREZAE2. */
  private static final int Y_DESTREZAE2 = 240;

  /** Constant HEIGHT_DESTREZAE2. */
  private static final int HEIGHT_DESTREZAE2 = 56;

  /** Constant WIDTH_DESTREZAE2. */
  private static final int WIDTH_DESTREZAE2 = 16;

  /** Constant X_INTE2. */
  private static final int X_INTE2 = 428;

  /** Constant Y_INTE2. */
  private static final int Y_INTE2 = 263;

  /** Constant HEIGHT_INTE2. */
  private static final int HEIGHT_INTE2 = 56;

  /** Constant WIDTH_INTE2. */
  private static final int WIDTH_INTE2 = 16;

  /** Constant X_LEYEN. */
  private static final int X_LEYEN = 12;

  /** Constant Y_LEYEN. */
  private static final int Y_LEYEN = 299;

  /** Constant HEIGHT_LEYEN. */
  private static final int HEIGHT_LEYEN = 282;

  /** Constant WIDTH_LEYEN. */
  private static final int WIDTH_LEYEN = 16;

  /** Constant VALOR_9. */
  private static final int VALOR_9 = 9;

  /** Constant X_AGREGAR. */
  private static final int X_AGREGAR = 181;

  /** Constant Y_AGREGAR. */
  private static final int Y_AGREGAR = 93;

  /** Constant HEIGHT_AGREGAR. */
  private static final int HEIGHT_AGREGAR = 51;

  /** Constant WIDTH_AGREGAR. */
  private static final int WIDTH_AGREGAR = 25;

  /** Constant X_SACAR. */
  private static final int X_SACAR = 181;

  /** Constant Y_SACAR. */
  private static final int Y_SACAR = 131;

  /** Constant HEIGHT_SACAR. */
  private static final int HEIGHT_SACAR = 51;

  /** Constant WIDTH_SACAR. */
  private static final int WIDTH_SACAR = 25;

  /** Constant X_CLISTO. */
  private static final int X_CLISTO = 317;

  /** Constant Y_CLISTO. */
  private static final int Y_CLISTO = 278;

  /** Constant HEIGHT_CLISTO. */
  private static final int HEIGHT_CLISTO = 56;

  /** Constant WIDTH_CLISTO. */
  private static final int WIDTH_CLISTO = 16;

  /** Constant X_CHCLIST. */
  private static final int X_CHCLIST = 289;

  /** Constant Y_CHCLIST. */
  private static final int Y_CHCLIST = 213;

  /** Constant HEIGHT_CHCLIST. */
  private static final int HEIGHT_CHCLIST = 71;

  /** Constant WIDTH_CHCLIST. */
  private static final int WIDTH_CHCLIST = 25;

  /** Constant X_FONDO. */
  private static final int X_FONDO = -12;

  /** Constant Y_FONDO. */
  private static final int Y_FONDO = 0;

  /** Constant HEIGHT_FONDO. */
  private static final int HEIGHT_FONDO = 628;

  /** Constant WIDTH_FONDO. */
  private static final int WIDTH_FONDO = 336;

  /**
   * Create the frame.
   *
   * @param cliente the cliente
   */
  public MenuComerciar(final Cliente cliente) {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setBounds(X_MENU, Y_MENU, HEIGHT_MENU, WIDTH_MENU);
    this.setLocationRelativeTo(null);
    this.setTitle("Comercio");

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(final WindowEvent e) {
          cliente.setM1(null);
        dispose();
      }
      });

    BufferedImage imagenFondo = null;
    try {
      imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

    }

    final JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setIcon(new ImageIcon("recursos//volver.png"));
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
          cliente.setM1(null);
          dispose();
        }
      });
    btnCancelar.setBounds(X_CANCEL, Y_CANCEL, HEIGHT_CANCEL, WIDTH_CANCEL);
    contentPane.add(btnCancelar);

    final JList<String> listMisItems = new JList<String>();
    listMisItems.setBounds(X_ITEM, Y_ITEM, HEIGHT_ITEM, WIDTH_ITEM);
    contentPane.add(listMisItems);

    final JList<String> listADar = new JList<String>();
    listADar.setBounds(X_ADAR, Y_ADAR, HEIGHT_ADAR, WIDTH_ADAR);
    contentPane.add(listADar);

    final JList<String> listAObtener = new JList<String>();
    listAObtener.setBounds(X_OBTEN, Y_OBTEN, HEIGHT_OBTEN, WIDTH_OBTEN);
    contentPane.add(listAObtener);

    final JLabel lblMisItems = new JLabel("Mis Items");
    lblMisItems.setForeground(Color.WHITE);
    lblMisItems.setHorizontalAlignment(SwingConstants.CENTER);
    lblMisItems.setBounds(X_ITEM1, Y_ITEM1, HEIGHT_ITEM1, WIDTH_ITEM1);
    contentPane.add(lblMisItems);

    final JLabel lblItemsAIntercambiar = new JLabel("Items a Dar");
    lblItemsAIntercambiar.setForeground(Color.WHITE);
    lblItemsAIntercambiar.setHorizontalAlignment(SwingConstants.CENTER);
    lblItemsAIntercambiar.setBounds(X_INTER, Y_INTER,
    HEIGHT_INTER, WIDTH_INTER);
    contentPane.add(lblItemsAIntercambiar);

    final JLabel lblItemsAObtener = new JLabel("Items a Obtener");
    lblItemsAObtener.setForeground(Color.WHITE);
    lblItemsAObtener.setHorizontalAlignment(SwingConstants.CENTER);
    lblItemsAObtener.setBounds(X_IOBTEN, Y_IOBTEN, HEIGHT_IOBTEN, WIDTH_IOBTEN);
    contentPane.add(lblItemsAObtener);

    final JLabel lblSalud = new JLabel("Salud");
    lblSalud.setForeground(Color.WHITE);
    lblSalud.setBounds(X_SALUD, Y_SALUD, HEIGHT_SALUD, WIDTH_SALUD);
    contentPane.add(lblSalud);

    final JLabel lblEnerga = new JLabel("Energía");
    lblEnerga.setForeground(Color.WHITE);
    lblEnerga.setBounds(X_ENER, Y_ENER, HEIGHT_ENER, WIDTH_ENER);
    contentPane.add(lblEnerga);

    final JLabel lblFuerza = new JLabel("Fuerza");
    lblFuerza.setForeground(Color.WHITE);
    lblFuerza.setBounds(X_FUERZA, Y_FUERZA, HEIGHT_FUERZA, WIDTH_FUERZA);
    contentPane.add(lblFuerza);

    final JLabel lblDestreza = new JLabel("Destreza");
    lblDestreza.setForeground(Color.WHITE);
    lblDestreza.setBounds(X_DESTREZA, Y_DESTREZA, HEIGHT_DESTREZA,
     WIDTH_DESTREZA);
    contentPane.add(lblDestreza);

    final JLabel lblInteligencia = new JLabel("Inteligencia");
    lblInteligencia.setForeground(Color.WHITE);
    lblInteligencia.setBounds(X_BRAIN, Y_BRAIN, HEIGHT_BRAIN, WIDTH_BRAIN);
    contentPane.add(lblInteligencia);

    final JLabel lblSaludEnemy = new JLabel("Salud");
    lblSaludEnemy.setForeground(Color.WHITE);
    lblSaludEnemy.setBounds(X_SALUDE, Y_SALUDE, HEIGHT_SALUDE, WIDTH_SALUDE);
    contentPane.add(lblSaludEnemy);

    final JLabel lblEnergiaEnemy = new JLabel("Energía");
    lblEnergiaEnemy.setForeground(Color.WHITE);
    lblEnergiaEnemy.setBounds(X_ENERE, Y_ENERE, HEIGHT_ENERE, WIDTH_ENERE);
    contentPane.add(lblEnergiaEnemy);

    final JLabel lblFzaEnemy = new JLabel("Fuerza");
    lblFzaEnemy.setForeground(Color.WHITE);
    lblFzaEnemy.setBounds(X_FUERZAE, Y_FUERZAE, HEIGHT_FUERZAE, WIDTH_FUERZAE);
    contentPane.add(lblFzaEnemy);

    final JLabel lblDesEnemy = new JLabel("Destreza");
    lblDesEnemy.setForeground(Color.WHITE);
    lblDesEnemy.setBounds(X_DESTREZAE, Y_DESTREZAE, HEIGHT_DESTREZAE,
    WIDTH_DESTREZAE);
    contentPane.add(lblDesEnemy);

    final JLabel lblIntEnemy = new JLabel("Inteligencia");
    lblIntEnemy.setForeground(Color.WHITE);
    lblIntEnemy.setBounds(X_ITEME, Y_ITEME, HEIGHT_ITEME, WIDTH_ITEME);
    contentPane.add(lblIntEnemy);

    final JLabel lblListo = new JLabel("Listo");
    lblListo.setForeground(Color.WHITE);
    lblListo.setBounds(X_LISTO, Y_LISTO, HEIGHT_LISTO, WIDTH_LISTO);
    contentPane.add(lblListo);

    final JLabel  bonusSalud = new JLabel("");
    bonusSalud.setForeground(Color.WHITE);
    bonusSalud.setHorizontalAlignment(SwingConstants.RIGHT);
    bonusSalud.setBounds(X_BONUSS, Y_BONUSS, HEIGHT_BONUSS, WIDTH_BONUSS);
    contentPane.add(bonusSalud);

    final JLabel bonusEnergia = new JLabel("");
    bonusEnergia.setForeground(Color.WHITE);
    bonusEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
    bonusEnergia.setBounds(X_BONUSE, Y_BONUSE, HEIGHT_BONUSE, WIDTH_BONUSE);
    contentPane.add(bonusEnergia);

    final JLabel bonusFuerza = new JLabel("");
    bonusFuerza.setForeground(Color.WHITE);
    bonusFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
    bonusFuerza.setBounds(X_BONUSF, Y_BONUSF, HEIGHT_BONUSF, WIDTH_BONUSF);
    contentPane.add(bonusFuerza);

    final JLabel bonusDes = new JLabel("");
    bonusDes.setForeground(Color.WHITE);
    bonusDes.setHorizontalAlignment(SwingConstants.RIGHT);
    bonusDes.setBounds(X_BONUSD, Y_BONUSD, HEIGHT_BONUSD, WIDTH_BONUSD);
    contentPane.add(bonusDes);

    final JLabel bonusInt = new JLabel("");
    bonusInt.setForeground(Color.WHITE);
    bonusInt.setHorizontalAlignment(SwingConstants.RIGHT);
    bonusInt.setBounds(X_BONUSI, Y_BONUSI, HEIGHT_BONUSI, WIDTH_BONUSI);
    contentPane.add(bonusInt);

    final JLabel saludEnemy = new JLabel("");
    saludEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
    saludEnemy.setForeground(Color.WHITE);
    saludEnemy.setBounds(X_SALUDE2, Y_SALUDE2, HEIGHT_SALUDE2, WIDTH_SALUDE2);
    contentPane.add(saludEnemy);

    final JLabel energyEnemy = new JLabel("");
    energyEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
    energyEnemy.setForeground(Color.WHITE);
    energyEnemy.setBounds(X_ENERE2, Y_ENERE2, HEIGHT_ENERE2, WIDTH_ENERE2);
    contentPane.add(energyEnemy);

    final JLabel fzaEnemy = new JLabel("");
    fzaEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
    fzaEnemy.setForeground(Color.WHITE);
    fzaEnemy.setBounds(X_FUERZAE2, Y_FUERZAE2, HEIGHT_FUERZAE2, WIDTH_FUERZAE2);
    contentPane.add(fzaEnemy);

    final JLabel desEnemy = new JLabel("");
    desEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
    desEnemy.setForeground(Color.WHITE);
    desEnemy.setBounds(X_DESTREZAE2, Y_DESTREZAE2, HEIGHT_DESTREZAE2,
    WIDTH_DESTREZAE2);
    contentPane.add(desEnemy);

    final JLabel intEnemy = new JLabel("");
    intEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
    intEnemy.setForeground(Color.WHITE);
    intEnemy.setBounds(X_INTE2, Y_INTE2, HEIGHT_INTE2, WIDTH_INTE2);
    contentPane.add(intEnemy);

    chckbxListo = new JCheckBox("Listo");
    chckbxListo.setForeground(Color.WHITE);
    chckbxListo.setBackground(Color.BLACK);
    // Arranca deshabilitada
    chckbxListo.setEnabled(false);

    leyenda = new JLabel("Recuerda que la máxima cantidad de items es 9");
    leyenda.setForeground(Color.WHITE);
    leyenda.setBounds(X_LEYEN, Y_LEYEN, HEIGHT_LEYEN, WIDTH_LEYEN);
    contentPane.add(leyenda);
    leyenda.setVisible(false);

    final JButton btnAgregar = new JButton("-->");
    btnAgregar.setIcon(new ImageIcon("recursos//flechaDer.png"));
    btnAgregar.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent arg0) {
            if (listMisItems.getSelectedValue() != null) {
              dar.addElement(listMisItems.getSelectedValue());
              if (obtener.size() != 0) {
                if (sizeItems - dar.size() + obtener.size() <= VALOR_9) {
                  chckbxListo.setEnabled(true);
                  leyenda.setVisible(false);
                }
              }
              // Pongo el primer item y pregunto si es igual al seleccionado
              // Entonces mientras que sean distinto lo busca
              // Cuando sea igual sale del while y lo agrega en la lista
              item1 = cliente.getPaquetePersonaje().getItems().get(count);
              while (!item1.getNombre().equals(listMisItems.
                     getSelectedValue())) {
                count++;
                item1 = cliente.getPaquetePersonaje().getItems().get(count);
              }
              count = 0;
              cliente.getPaqueteComercio().getItemsADar().add(item1);
              misItems.removeElement(listMisItems.getSelectedValue());
              cliente.getPaqueteComercio().
              setComando(Comando.ACTUALIZARCOMERCIO);
              try {
                cliente.getSalida().writeObject(gson.toJson(cliente.
                getPaqueteComercio()));
              } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "No se pudo actualizar comercio");
              }
              if (misItems.size() == 0) {
                bonusSalud.setText("");
                bonusEnergia.setText("");
                bonusFuerza.setText("");
                bonusDes.setText("");
                bonusInt.setText("");
              }
            }
      }
    });
    btnAgregar.setBounds(X_AGREGAR, Y_AGREGAR, HEIGHT_AGREGAR, WIDTH_AGREGAR);
    contentPane.add(btnAgregar);

    final JButton btnSacar = new JButton("<--");
    btnSacar.setIcon(new ImageIcon("recursos//flechaIzq.png"));
    btnSacar.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent arg0) {
            if (listADar.getSelectedValue() != null) {
              misItems.addElement(listADar.getSelectedValue());
              for (Item item : cliente.getPaquetePersonaje().getItems()) {
                if (item.getNombre().equals(listADar.getSelectedValue())) {
                  cliente.getPaqueteComercio().getItemsADar().remove(item);
                }
              }
              dar.removeElement(listADar.getSelectedValue());
              // Si saque el item y la lista no tiene nada deshabilito el check
              if (dar.size() == 0) {
                chckbxListo.setEnabled(false);
              }
              // Si los items en total es mayor a 9 no puedo comerciar
              if (sizeItems - dar.size() + obtener.size() > VALOR_9) {
                chckbxListo.setEnabled(false);
                leyenda.setVisible(true);
              }
              cliente.getPaqueteComercio().setComando(Comando.
              ACTUALIZARCOMERCIO);
              try {
                cliente.getSalida().writeObject(gson.toJson(cliente.
                getPaqueteComercio()));
              } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "No se pudo actualizar comercio");
              }
              // Cuando paso un item d ofertar a no ofertado muestro el que movi
              int i = misItems.size();
              if (i >= 1) {
              for (Item item : cliente.getPaquetePersonaje().getItems()) {
                if (misItems.getElementAt(i - 1).equals(item.getNombre())) {
                  bonusSalud.setText("+ " + item.getBonusSalud());
                  bonusEnergia.setText("+ " + item.getBonusEnergia());
                  bonusFuerza.setText("+ " + item.getBonusFuerza());
                  bonusDes.setText("+ " + item.getBonusDestreza());
                  bonusInt.setText("+ " + item.getBonusInteligencia());
                }
              }
            }
          }
      }
    });
    btnSacar.setBounds(X_SACAR, Y_SACAR, HEIGHT_SACAR, WIDTH_SACAR);
    contentPane.add(btnSacar);

    // List Listener para cargar stats del item mio clickeado
    listMisItems.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(final MouseEvent arg0) {
            if (arg0.getClickCount() == 1) {
              if (listMisItems.getSelectedValue() != null) {
                for (Item item : cliente.getPaquetePersonaje().getItems()) {
                  if (listMisItems.getSelectedValue().
                      equals(item.getNombre())) {
                    bonusSalud.setText("+ " + item.getBonusSalud());
                    bonusEnergia.setText("+ " + item.getBonusEnergia());
                    bonusFuerza.setText("+ " + item.getBonusFuerza());
                    bonusDes.setText("+ " + item.getBonusDestreza());
                    bonusInt.setText("+ " + item.getBonusInteligencia());
                  }
                }
              }
            }
          }
    });

    // List Listener para cargar stats del item del enemigo clickeado
    listAObtener.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(final MouseEvent arg0) {
            if (arg0.getClickCount() == 1) {
              if (obtener.size() != 0) {
                //change la variable del for each a la lista q
                //va a venir del otro pj
                for (Item item : cliente.getPaqueteComercio().
                     getItemsAObtener()) {
                  if (listAObtener.getSelectedValue().
                      equals(item.getNombre())) {
                    saludEnemy.setText("+ " + item.getBonusSalud());
                    energyEnemy.setText("+ " + item.getBonusEnergia());
                    fzaEnemy.setText("+ " + item.getBonusFuerza());
                    desEnemy.setText("+ " + item.getBonusDestreza());
                    intEnemy.setText("+ " + item.getBonusInteligencia());
                  }
                }
              }
            }
          }
      });

    //CARGO MIS ITEMS
    for (Item item : cliente.getPaquetePersonaje().getItems()) {
      misItems.addElement(item.getNombre());
    }

    // Seteo la cantidad de mis items en mi mochila
    sizeItems = misItems.size();

    //Seteo de JList
    listMisItems.setModel(misItems);
    listADar.setModel(dar);
    listAObtener.setModel(obtener);

    cantListo = new JLabel("0/2");
    cantListo.setHorizontalAlignment(SwingConstants.RIGHT);
    cantListo.setForeground(Color.WHITE);
    cantListo.setBounds(X_CLISTO, Y_CLISTO, HEIGHT_CLISTO, WIDTH_CLISTO);
    contentPane.add(cantListo);

    chckbxListo.addItemListener(new ItemListener() {
        public void itemStateChanged(final ItemEvent arg0) {
          if (chckbxListo.isSelected()) {
            // Si ya la persona con la que voy a comerciar esta en LISTO
            if (cantListos == 1) {
              cantListos++;
              // Primero actualizo el label de cant Listos
              cantListo.setText(cantListos + "/2");
              // Le envio al otro que toque listo y esta 2/2 listo para trueque
              cliente.getPaqueteComercio().aumentarListo();
              cliente.getPaqueteComercio().
              setComando(Comando.ACTUALIZARCOMERCIO);
              try {
                cliente.getSalida().writeObject(gson.
                toJson(cliente.getPaqueteComercio()));
              } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "No se pudo actualizar comercio");
              }
              ////////
              // Ahora le digo que haga el trueque
              cliente.getPaqueteComercio().setComando(Comando.TRUEQUE);
              // Le informo al otro que vamos a hacer el trueque
              try {
                cliente.getSalida().writeObject(gson.
                toJson(cliente.getPaqueteComercio()));
              } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "No se pudo actualizar comercio");
              }
            JOptionPane.showMessageDialog(cliente.getM1(),
            "Se ha realizado con exito el comercio");
            dispose();
            } else {
              // Si todavía LISTO = 0, le informo al otro
              cantListos++;
              // Deshabilito los botones para que no pueda agregar nada
              btnAgregar.setEnabled(false);
              btnSacar.setEnabled(false);
              cliente.getPaqueteComercio().aumentarListo();
              cliente.getPaqueteComercio().
              setComando(Comando.ACTUALIZARCOMERCIO);
              //Tambien le tiene que avisar el LISTO al otro jugador
              try {
                cliente.getSalida().writeObject(gson.
                toJson(cliente.getPaqueteComercio()));
              } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                "No se pudo actualizar comercio");
              }
              cantListo.setText(cantListos + "/2");
            }
            } else {
              // Si habia clickeado LISTO, pero lo desclickie entonces le digo
              // que disminuya en el otro cliente
              if (cantListos != 2) {
                // Si no tenia nada en la lista no tengo que disminuir la cant
                // de listos
                cantListos--;
                cliente.getPaqueteComercio().disminuirListo();
                btnAgregar.setEnabled(true);
                btnSacar.setEnabled(true);
                cliente.getPaqueteComercio().
                setComando(Comando.ACTUALIZARCOMERCIO);
                //Tambien le tiene que avisar el NO LISTO al otro jugador
                try {
                  cliente.getSalida().writeObject(gson.
                  toJson(cliente.getPaqueteComercio()));
                } catch (IOException e) {
                  JOptionPane.showMessageDialog(null,
                  "No se pudo actualizar comercio");
                }
              cantListo.setText(cantListos + "/2");
            }
          }
        }
      });
    chckbxListo.setHorizontalAlignment(SwingConstants.CENTER);
    chckbxListo.setBounds(X_CHCLIST, Y_CHCLIST, HEIGHT_CHCLIST, WIDTH_CHCLIST);
    contentPane.add(chckbxListo);

    final JLabel background = new JLabel(new ImageIcon(imagenFondo
         .getScaledInstance(610, 416, Image.SCALE_DEFAULT)));
    background.setBounds(X_FONDO, Y_FONDO, HEIGHT_FONDO, WIDTH_FONDO);
    contentPane.add(background);
  }

  /**
   * Gets the cant listos.
   *
   * @return the cant listos
   */
  public int getCantListos() {
    return cantListos;
  }

  /**
   * Sets the cant listos.
   *
   * @param cantList the new cant listos
   */
  public void setCantListos(final int cantList) {
    this.cantListos = cantList;
  }

  /**
   * Gets the cant listo.
   *
   * @return the cant listo
   */
  public JLabel getCantListo() {
    return cantListo;
  }

  /**
   * Sets the obtener.
   *
   * @param obten the new obtener
   */
  public void setObtener(final DefaultListModel<String> obten) {
    this.obtener = obten;
  }

  /**
   * Gets the obtener.
   *
   * @return the obtener
   */
  public DefaultListModel<String> getObtener() {
    return obtener;
  }

  /**
   * Gets the dar.
   *
   * @return the dar
   */
  public DefaultListModel<String> getDar() {
    return dar;
  }

  /**
   * Gets the size items.
   *
   * @return the size items
   */
  public int getSizeItems() {
    return sizeItems;
  }

  /**
   * Gets the chckbx listo.
   *
   * @return the chckbx listo
   */
  public JCheckBox getChckbxListo() {
    return chckbxListo;
  }

  /**
   * Gets the leyenda.
   *
   * @return the leyenda
   */
  public JLabel getLeyenda() {
    return leyenda;
  }
}
