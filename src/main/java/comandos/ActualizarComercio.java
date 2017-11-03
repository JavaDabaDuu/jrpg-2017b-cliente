package comandos;

import dominio.Item;
import javax.swing.JOptionPane;

import mensajeria.PaqueteComerciar;

/**
 * The Class ActualizarComercio.
 */
public class ActualizarComercio extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    int sizeMisItems = getJuego().getCliente().getM1().getSizeItems();
    int sizeADar = getJuego().getCliente().getM1().getDar().size();
    int sizeAObtener;
    int cuentaSize;
    PaqueteComerciar paqueteComerciar;
    paqueteComerciar = getGson()
        .fromJson(getCadenaLeida(), PaqueteComerciar.class);
    sizeAObtener = paqueteComerciar.getItemsADar().size();
    cuentaSize = sizeMisItems - sizeADar + sizeAObtener;
    if (sizeADar != 0) {
      if (cuentaSize <= 9) {
        getJuego().getCliente().getM1().getChckbxListo().setEnabled(true);
        getJuego().getCliente().getM1().getLeyenda().setVisible(false);
      } else if (cuentaSize > 9) {
        getJuego().getCliente().getM1().getChckbxListo().setEnabled(false);
        getJuego().getCliente().getM1().getLeyenda().setVisible(true);
      }
    }
    if (sizeAObtener == 0) {
      getJuego().getCliente().getM1().getChckbxListo().setEnabled(false);
      getJuego().getCliente().getM1().getLeyenda().setVisible(true);
    }
    if (getJuego().getCliente().getPaqueteComercio().getListo()
    == paqueteComerciar.getListo()) {
      //actualizar la lista
      getJuego().getCliente().getM1().getObtener().removeAllElements();
      for (Item item : paqueteComerciar.getItemsADar()) {
        getJuego().getCliente().getM1().getObtener().addElement(
            item.getNombre());
      }
      getJuego().getCliente().getPaqueteComercio()
          .setItemsAObtener(paqueteComerciar.getItemsADar());
    } else {
      // se modifico el listo
      // me fijo si puso listo o lo saco
      if (getJuego().getCliente().getPaqueteComercio().getListo()
      < paqueteComerciar.getListo()) {
        getJuego().getCliente().getPaqueteComercio().aumentarListo();
      } else {
        getJuego().getCliente().getPaqueteComercio().disminuirListo();
      }
      // modifico la cant de listos en el jframe y tambien el lbl
      getJuego().getCliente().getM1()
          .setCantListos(paqueteComerciar.getListo());
      getJuego().getCliente().getM1().getCantListo()
          .setText(String.valueOf(getJuego().getCliente()
          .getM1().getCantListos()) + "/2");
      if (getJuego().getCliente().getM1().getCantListos() == 2) {
        JOptionPane.showMessageDialog(getJuego().getCliente()
            .getM1(), "Se ha realizado con exito el comercio");
        getJuego().getCliente().getM1().dispose();
      }
    }
  }

}
