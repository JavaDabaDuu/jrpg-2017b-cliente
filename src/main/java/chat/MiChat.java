package chat;

import com.google.gson.Gson;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.text.DefaultCaret;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * The Class MiChat.
 */
public class MiChat extends JFrame {

  /** The content pane. */
  private JPanel contentPane;

  /** The texto. */
  private JTextField texto;

  /** The chat. */
  private JTextArea chat;

  /** The juego. */
  private Juego juego;

  /** The gson. */
  private final Gson gson = new Gson();

  /** The background. */
  private final JLabel background
      = new JLabel(new ImageIcon("recursos//background.jpg"));

  /** The caret. */
  private DefaultCaret caret;

  /** Constant X_CHAT. */
  private static final int X_CHAT = 100;

  /** Constant Y_CHAT. */
  private static final int Y_CHAT = 100;

 /** Constant WIDTH_CHAT. */
  private static final int WIDTH_CHAT = 450;

  /** Constant HEIGHT_CHAT. */
  private static final int HEIGHT_CHAT = 300;

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
  private static final int HEIGHT_SCROLL = 414;

  /** Constant WIDTH_SCROLL .*/
  private static final int WIDTH_SCROLL = 201;

  /** Constant X_ENVIAR .*/
  private static final int X_ENVIAR = 334;

  /** Constant Y_ENVIAR.*/
  private static final int Y_ENVIAR = 225;

  /** Constant HEIGHT_ENVIAR.*/
  private static final int HEIGHT_ENVIAR = 81;

  /** Constant WIDTH_ENVIAR.*/
  private static final int WIDTH_ENVIAR = 23;

  /** Constant X_TEXTO .*/
  private static final int X_TEXTO = 10;

  /** Constant Y_TEXTO.*/
  private static final int Y_TEXTO = 223;

  /** Constant HEIGHT_TEXTO.*/
  private static final int HEIGHT_TEXTO = 314;

  /** Constant WIDTH_TEXTO.*/
  private static final int WIDTH_TEXTO = 27;

  /** Constant COLUMNA_TEXTO. */
  private static final int COLUMNA_TEXTO = 10;

  /** Constant X_FONDO. */
  private static final int X_FONDO = -20;

  /** Constant Y_FONDO. */
  private static final int Y_FONDO = 0;

  /** Constant HEIGHT_FONDO. */
  private static final int HEIGHT_FONDO = 480;

  /** Constant WIDTH_FONDO. */
  private static final int WIDTH_FONDO = 283;

  /**
   * Create the frame.
   *
   * @param juegoAux the juego
   */
  public MiChat(final Juego juegoAux) {
    this.juego = juegoAux;
    setTitle("Mi Chat");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(X_CHAT, Y_CHAT, WIDTH_CHAT, HEIGHT_CHAT);
    setResizable(false);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(X_BOR, Y_BOR, HEIGHT_BOR, WIDTH_BOR));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(X_SCROLL, Y_SCROLL, HEIGHT_SCROLL, WIDTH_SCROLL);
    contentPane.add(scrollPane);

    chat = new JTextArea();
    chat.setEditable(false);
    scrollPane.setViewportView(chat);
    caret = (DefaultCaret) chat.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    texto = new JTextField();
    this.addWindowListener(new WindowAdapter() {
      public void windowOpened(final WindowEvent e) {
        texto.requestFocus();
        }

      @Override
      public void windowClosing(final WindowEvent e) {
          if (getTitle() == "Sala") {
              if (Pantalla.getVentContac() != null) {
            VentanaContactos.getBotonMc().setEnabled(true);
            }
            }
          juegoAux.getChatsActivos().remove(getTitle());
          }
      });

    //SI TOCO ENTER
    texto.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        if (!texto.getText().equals("")) {
          // Cheat noclip
          if (texto.getText().equals("noclip")) {
            juego.activarNoClip();
          }
          if (texto.getText().equals("siclip")) {
            juego.desactivarNoClip();
          }
          
          if (texto.getText().equals("run")) {
        	  juego.running();
          }
          if (texto.getText().equals("walk")) {
        	  juego.walking();
          }
          if(texto.getText().equals("bigdaddy")) {
        	  juego.getPersonaje().bigdaddyON();
          }
          if(texto.getText().equals("tinydaddy")) {
        	  juego.getPersonaje().tinydaddyON();
          }
          if(texto.getText().equals("bigdaddyoff")) {
        	  juego.getPersonaje().bigdaddyOFF();
          }
          if(texto.getText().equals("tinydaddyoff")) {
        	  juego.getPersonaje().tinydaddyOFF();
          }
          if(texto.getText().equals("invisible")) {
        	  juego.getPersonaje().setInvisibilidad();
          }
          if(texto.getText().equals("invisibleoff")) {
        	  juego.getPersonaje().invisibilidadOFF();
          }
          
          chat.append("Me: " + texto.getText() + "\n");

          juegoAux.getCliente().getPaqueteMensaje()
              .setUserEmisor(juegoAux.getPersonaje().getNombre());
          
        //Seteo el id de la persona que escribe el mensaje
          juegoAux.getCliente().getPaqueteMensaje()
          .setIdEmisor(juegoAux.getPersonaje().getId());
          
          juegoAux.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
          juegoAux.getCliente().getPaqueteMensaje().setMensaje(texto.getText());

          // MANDO EL COMANDO PARA QUE ENVIE EL MSJ
          juegoAux.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
          // El user receptor en espacio indica que es para todos
          if (getTitle() == "Sala") {
                juegoAux.getCliente().getPaqueteMensaje().setUserReceptor(null);
          }

          try {
              juegoAux.getCliente().getSalida().writeObject(
                  gson.toJson(juegoAux.getCliente().getPaqueteMensaje()));
              } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Error al enviar mensaje");
              }
          texto.setText("");
          }
        texto.requestFocus();
        }
      });

    //SI TOCO ENVIAR
    JButton enviar = new JButton("ENVIAR");
    enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
    enviar.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            if (!texto.getText().equals("")) {
              // Cheat noclip
              if (texto.getText().equals("noclip")) {
                juego.activarNoClip();
              }
              if (texto.getText().equals("siclip")) {
                juego.desactivarNoClip();
              }
              
              if (texto.getText().equals("run")) {
            	  juego.running();
              }
              if (texto.getText().equals("walk")) {
            	  juego.walking();
              }
              if(texto.getText().equals("bigdaddy")) {
            	  juego.getPersonaje().bigdaddyON();
              }
              if(texto.getText().equals("tinydaddy")) {
            	  juego.getPersonaje().tinydaddyON();
              }          
              if(texto.getText().equals("bigdaddyoff")) {
            	  juego.getPersonaje().bigdaddyOFF();
              }
              if(texto.getText().equals("tinydaddyoff")) {
            	  juego.getPersonaje().tinydaddyOFF();
              }
              if(texto.getText().equals("invisible")) {
            	  juego.getPersonaje().setInvisibilidad();
              }
              if(texto.getText().equals("invisibleOFF")) {
            	  juego.getPersonaje().invisibilidadOFF();
              }
              
            chat.append("Me: " + texto.getText() + "\n");

            juegoAux.getCliente().getPaqueteMensaje()
                .setUserEmisor(juegoAux.getPersonaje().getNombre());
            juegoAux.getCliente().getPaqueteMensaje()
                .setUserReceptor(getTitle());
            juegoAux.getCliente().getPaqueteMensaje()
                .setMensaje(texto.getText());

            // MANDO EL COMANDO PARA QUE ENVIE EL MSJ
            juegoAux.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
            // El user receptor en espacio indica que es para todos
            if (getTitle() == "Sala") {
                juegoAux.getCliente().getPaqueteMensaje().setUserReceptor(null);
              }

            try {
                juegoAux.getCliente().getSalida().writeObject(
                    gson.toJson(juegoAux.getCliente().getPaqueteMensaje()));
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Error al enviar mensaje");

              }
            texto.setText("");
            }
            texto.requestFocus();
          }
    });
    enviar.setBounds(X_ENVIAR, Y_ENVIAR, HEIGHT_ENVIAR, WIDTH_ENVIAR);
    contentPane.add(enviar);

    texto.setBounds(X_TEXTO, Y_TEXTO, HEIGHT_TEXTO, WIDTH_TEXTO);
    contentPane.add(texto);
    texto.setColumns(COLUMNA_TEXTO);
    background.setBounds(X_FONDO, Y_FONDO, HEIGHT_FONDO, WIDTH_FONDO);
    contentPane.add(background);
  }

  /**
   * Gets the chat.
   *
   * @return the chat
   */
  public JTextArea getChat() {
    return chat;
  }

  /**
   * Gets the texto.
   *
   * @return the texto
   */
  public JTextField getTexto() {
    return texto;
  }
}
