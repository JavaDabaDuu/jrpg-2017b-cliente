package inventario;

import dominio.Item;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class Celda.
 */
public class Celda extends JPanel {

  /** The item. */
  private BufferedImage item;

  /** The paquete personaje. */
  private PaquetePersonaje paquetePersonaje;

  /** The label. */
  private JLabel label;

  /** The it. */
  private Item it;


  /**
   * Instantiates a new celda.
   *
   * @param itemAux the item
   * @param paquetePersonajeAux the paquete personaje
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public Celda(final Item itemAux,
  final PaquetePersonaje paquetePersonajeAux) throws IOException {
    this.item = itemAux.getFoto();
    it = itemAux;
    this.paquetePersonaje = paquetePersonajeAux;
    label = new JLabel(new ImageIcon(
        this.item.getScaledInstance(49, 49, Image.SCALE_DEFAULT)));
    actionListenersYLabel(itemAux);
  }

  /**
   * Instantiates a new celda.
   */
  public Celda() {
    label = new JLabel(new ImageIcon(Recursos.getNoItem()
        .getScaledInstance(49, 49, Image.SCALE_DEFAULT)));
    add(label);
  }

  /**
   * Action listeners Y label.
   *
   * @param itemAux the item
   */
  private void actionListenersYLabel(final Item itemAux) {
    StringBuilder s = new StringBuilder();
    s.append("<html>" + itemAux.getNombre() + "<br>");

    if (itemAux.getBonusSalud() != 0) {
      s.append("+" + itemAux.getBonusSalud() + " Salud " + "<br>");
    }
    if (itemAux.getBonusEnergia() != 0) {
      s.append("+" + itemAux.getBonusEnergia() + " Energia " + "<br>");
    }
    if (itemAux.getBonusFuerza() != 0) {
      s.append("+" + itemAux.getBonusFuerza() + " Fuerza " + "<br>");
    }
    if (itemAux.getBonusDestreza() != 0) {
      s.append("+" + itemAux.getBonusDestreza() + " Destreza " + "<br>");
    }
    if (itemAux.getBonusInteligencia() != 0) {
      s.append("+" + itemAux.getBonusInteligencia() + " Inteligencia");
    }
    s.append("</html>");
    label.setToolTipText(s.toString());
    label.addMouseListener(mouseListener);
    addMouseListener(mouseListener);

    add(label);
    this.validate();
    this.repaint();

  }


  /**
   * Reset label.
   */
  protected void resetLabel() {
    label.setIcon(new ImageIcon(Recursos.getNoItem()
        .getScaledInstance(49, 49, Image.SCALE_DEFAULT)));
    label.setToolTipText(null);
    paquetePersonaje.removerItem(it);
    label.removeMouseListener(mouseListener);
    removeMouseListener(mouseListener);
  }

  /* (non-Javadoc)
   * @see javax.swing.JComponent#getPreferredSize()
   */
  @Override
public Dimension getPreferredSize() {
    return new Dimension(60, 60);
  }

  /**
   * Gets the label.
   *
   * @return the label
   */
  public JLabel getLabel() {
    return label;
  }

  /** The mouse listener. */
  private MouseListener mouseListener = new MouseAdapter() {
    public void mouseClicked(final MouseEvent e) {
      Object[] options = {"Tirar", "Cancelar"};
      if (e.getClickCount() == 2) {
        int answer = JOptionPane.showOptionDialog(getParent(),
            "¿Qué desea hacer?", "Item: "
            + it.getNombre(), JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        //Tirar
        if (answer == 0) {
         paquetePersonaje.sacarBonus(it.getBonusSalud(), it.getBonusEnergia(),
         it.getBonusFuerza(), it.getBonusDestreza(), it.getBonusInteligencia());
         resetLabel();
        }
      }
    }
  };
}
