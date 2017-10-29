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

public class Pantalla {

  private JFrame pantalla;
  private Canvas canvas;

  // Menus
  public static MenuInventario menuInventario;
  public static MenuAsignarSkills menuAsignar;
  public static MenuStats menuStats;
  public static MenuEscape menuEscp;
  public static VentanaContactos ventContac;
  private final Gson gson = new Gson();
  //Ahora necesito tener el cliente acá porque sino no lo ven los metodos que muestran los menus
  private Cliente cliente;
  //Nombre significativo
  private HashMap<Integer, Runnable> mostradoresDeMenus = new HashMap<Integer, Runnable>(); 

  public Pantalla(final String NOMBRE, final int ANCHO, final int ALTO, final Cliente cliente) {
    pantalla = new JFrame(NOMBRE);
    pantalla.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/main/java/frames/IconoWome.png"));
    pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
        new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
            new Point(0,0),"custom cursor"));

    pantalla.setSize(ANCHO, ALTO);
    pantalla.setResizable(false);
    pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    pantalla.addWindowListener(new WindowAdapter() {
      @Override
    public void windowClosing(WindowEvent evt) {
        try {
          Paquete p = new Paquete();
          p.setComando(Comando.DESCONECTAR);
          p.setIp(cliente.getMiIp());
          cliente.getSalida().writeObject(gson.toJson(p));
          cliente.getEntrada().close();
          cliente.getSalida().close();
          cliente.getSocket().close();
          System.exit(0);
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al intentar cerrar la aplicación.");
            System.exit(1);
          }
        }
      });

    this.cliente = cliente;
    // Cargo mi hashmap de runnables con la tecla y el metodo que abre el menu que abre esa tecla
    this.mostradoresDeMenus.put(KeyEvent.VK_I, () -> mostrarMenuInventario());
    this.mostradoresDeMenus.put(KeyEvent.VK_A, () -> mostrarMenuAsignarSkills());
    this.mostradoresDeMenus.put(KeyEvent.VK_S, () -> mostrarMenuStats());
    this.mostradoresDeMenus.put(KeyEvent.VK_ESCAPE, () -> mostrarMenuEscape());
    this.mostradoresDeMenus.put(KeyEvent.VK_C, () -> mostrarVentanaContactos());
    
    pantalla.addKeyListener(new KeyAdapter() {
      @Override
    public void keyReleased(KeyEvent e) {
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
    canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
    canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
    canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
    canvas.setFocusable(false);

    pantalla.add(canvas);
    pantalla.pack();
  }

  private void mostrarMenuInventario() {
    if (menuInventario == null) {
      menuInventario = new MenuInventario(cliente);
      menuInventario.setVisible(true);
    }
  }

  private void mostrarMenuAsignarSkills() {
    if (menuAsignar == null) {
      menuAsignar = new MenuAsignarSkills(cliente);
      menuAsignar.setVisible(true);
    } 
  }

  private void mostrarMenuStats() {
    if (menuStats == null) {
      menuStats = new MenuStats(cliente);
      menuStats.setVisible(true);
    }
  }

  private void mostrarMenuEscape() {
    if (menuEscp == null) {
      menuEscp = new MenuEscape(cliente);
      menuEscp.setVisible(true);
    }
  }

  private void mostrarVentanaContactos() {
    if (ventContac == null) {
      ventContac = new VentanaContactos(cliente.getJuego());
      ventContac.setVisible(true);
    }
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public JFrame getFrame() {
    return pantalla;
  }

  public void mostrar() {
    pantalla.setVisible(true);
  }

  public static void centerString(Graphics g, Rectangle r, String s) {
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

  // Dejo esto acá por las dudas
  /*
  pantalla.addKeyListener(new KeyAdapter() {
    @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_I) {
      if(Estado.getEstado().esEstadoDeJuego()) {
        if (menuInventario == null) {
          menuInventario = new MenuInventario(cliente);
            menuInventario.setVisible(true);
          }
        }
      } else if (e.getKeyCode() == KeyEvent.VK_A) {
      if(Estado.getEstado().esEstadoDeJuego()) {
        if (menuAsignar == null) {
          menuAsignar = new MenuAsignarSkills(cliente);
          menuAsignar.setVisible(true);
         }
      } 
      } else if (e.getKeyCode() == KeyEvent.VK_S) {
        if(Estado.getEstado().esEstadoDeJuego()) {
          if (menuStats == null) {
            menuStats = new MenuStats(cliente);
            menuStats.setVisible(true);
          }
        }
      } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        if(Estado.getEstado().esEstadoDeJuego()) {
          if (menuEscp == null) {
            menuEscp = new MenuEscape(cliente);
            menuEscp.setVisible(true);
          }
        }
      } else if (e.getKeyCode() == KeyEvent.VK_C) {
        if(Estado.getEstado().esEstadoDeJuego()) {
          if (ventContac == null) {
            ventContac = new VentanaContactos(cliente.getJuego());
            ventContac.setVisible(true);
            }
          }
        }
      }
    });
  */
}