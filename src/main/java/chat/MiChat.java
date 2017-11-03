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

  /**
   * Create the frame.
   *
   * @param juegoAux the juego
   */
  public MiChat(final Juego juegoAux) {
    this.juego = juegoAux;
    setTitle("Mi Chat");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    setResizable(false);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(10, 11, 414, 201);
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
          chat.append("Me: " + texto.getText() + "\n");

          juegoAux.getCliente().getPaqueteMensaje()
              .setUserEmisor(juegoAux.getPersonaje().getNombre());
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
    enviar.setBounds(334, 225, 81, 23);
    contentPane.add(enviar);

    texto.setBounds(10, 223, 314, 27);
    contentPane.add(texto);
    texto.setColumns(10);
    background.setBounds(-20, 0, 480, 283);
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
