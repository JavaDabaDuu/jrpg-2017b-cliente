package comandos;

import frames.MenuComerciar;
import java.io.IOException;

import javax.swing.JOptionPane;

import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;

/**
 * The Class Comercio.
 */
public class Comercio extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaqueteComerciar paqueteComerciar;
    paqueteComerciar = getGson()
    .fromJson(getCadenaLeida(), PaqueteComerciar.class);
    // Cuando recibo el paquete de comercio
    //actualizado intercambio user/ destino
    paqueteComerciar.setIdEnemigo(paqueteComerciar.getId());
    paqueteComerciar.setId(getJuego().getCliente()
        .getPaquetePersonaje().getId());

    if (paqueteComerciar.isSolicitudDeComercio()) {
      if (getJuego().getCliente().getM1() != null) {
        paqueteComerciar.setMensaje(Paquete.getMsjFracaso());
      } else {
        getJuego().getCliente().setPaqueteComercio(paqueteComerciar);
        getJuego().getCliente()
            .setM1(new MenuComerciar(getJuego().getCliente()));
        getJuego().getCliente().getM1().setVisible(true);
        paqueteComerciar.setMensaje(Paquete.getMsjExito());
      }
      paqueteComerciar.setSolicitudDeComercio(false);
      try {
        getJuego().getCliente().getSalida()
            .writeObject(getGson().toJson(paqueteComerciar));
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null,
            "No se envio la solicitud de comercio");
      }

    } else {
      if (paqueteComerciar.getMensaje().equals(Paquete.getMsjFracaso())) {
        JOptionPane.showMessageDialog(null, "Ya esta comerciando");
      } else {
        if (getJuego().getCliente().getM1() == null) {
          getJuego().getCliente().setPaqueteComercio(paqueteComerciar);
          getJuego().getCliente()
              .setM1(new MenuComerciar(getJuego().getCliente()));
          getJuego().getCliente().getM1().setVisible(true);
        }
      }
    }

  }

}
