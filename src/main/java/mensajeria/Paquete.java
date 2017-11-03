package mensajeria;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * The Class Paquete.
 */
public class Paquete implements Serializable, Cloneable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

/** The msj exito. */
private static String msjExito = "1";

  /** The msj fracaso. */
  private static String msjFracaso = "0";

  /** The mensaje. */
  private String mensaje;

  /** The ip. */
  private String ip;

  /** The comando. */
  private int comando;

  /**
   * Instantiates a new paquete.
   */
  public Paquete() {

  }

  /**
   * Instantiates a new paquete.
   *
   * @param mensajeAux the mensaje
   * @param nick the nick
   * @param ipAux the ip
   * @param comandoAux the comando
   */
  public Paquete(final String mensajeAux,
  final String nick, final String ipAux, final int comandoAux) {
    this.mensaje = mensajeAux;
    this.ip = ipAux;
    this.comando = comandoAux;
  }

  /**
   * Instantiates a new paquete.
   *
   * @param mensajeAux the mensaje
   * @param comandoAux the comando
   */
  public Paquete(final String mensajeAux, final int comandoAux) {
    this.mensaje = mensajeAux;
    this.comando = comandoAux;
  }

  /**
   * Instantiates a new paquete.
   *
   * @param comandoAux the comando
   */
  public Paquete(final int comandoAux) {
    this.comando = comandoAux;
  }

  /**
   * Sets the mensaje.
   *
   * @param mensajeAux the new mensaje
   */
  public void setMensaje(final String mensajeAux) {
    this.mensaje = mensajeAux;
  }

  /**
   * Sets the ip.
   *
   * @param ipAux the new ip
   */
  public void setIp(final String ipAux) {
    this.ip = ipAux;
  }

  /**
   * Sets the comando.
   *
   * @param comandoAux the new comando
   */
  public void setComando(final int comandoAux) {
    this.comando = comandoAux;
  }

  /**
   * Gets the mensaje.
   *
   * @return the mensaje
   */
  public String getMensaje() {
    return mensaje;
  }

  /**
   * Gets the ip.
   *
   * @return the ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * Gets the comando.
   *
   * @return the comando
   */
  public int getComando() {
    return comando;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#clone()
   */
  @Override
public Object clone() {
    Object obj = null;
    try {
      obj = super.clone();
    } catch (CloneNotSupportedException ex) {
      JOptionPane.showMessageDialog(null, "Error al clonar");
    }
    return obj;
  }

  /**
   * Gets the objeto.
   *
   * @param nombrePaquete the nombre paquete
   * @return the objeto
   * @throws InstantiationException the instantiation exception
   * @throws IllegalAccessException the illegal access exception
   * @throws ClassNotFoundException the class not found exception
   */
  public Comando getObjeto(final String nombrePaquete)
  throws InstantiationException, IllegalAccessException,
  ClassNotFoundException {
    Comando c;
    c = (Comando) Class.forName(nombrePaquete + "."
        + Comando.CLASSNAMES[comando]).newInstance();
    return c;
  }

  /**
   * Gets the objeto set.
   *
   * @param nombrePaquete the nombre paquete
   * @param accion the accion
   * @return the objeto set
   * @throws InstantiationException the instantiation exception
   * @throws IllegalAccessException the illegal access exception
   * @throws ClassNotFoundException the class not found exception
   */
  public static Comando getObjetoSet(
  final String nombrePaquete, final int accion)
  throws InstantiationException,
  IllegalAccessException, ClassNotFoundException {
    Comando c;
    c = (Comando) Class.forName(nombrePaquete + "."
        + Comando.CLASSNAMESBIS[accion]).newInstance();
    return c;
  }

/**
 * Gets the msj exito.
 *
 * @return the msj exito
 */
public static String getMsjExito() {
  return msjExito;
}

/**
 * Sets the msj exito.
 *
 * @param msjExitoAux the new msj exito
 */
public static void setMsjExito(final String msjExitoAux) {
  Paquete.msjExito = msjExitoAux;
}

/**
 * Gets the msj fracaso.
 *
 * @return the msj fracaso
 */
public static String getMsjFracaso() {
  return msjFracaso;
}

/**
 * Sets the msj fracaso.
 *
 * @param msjFracasoAux the new msj fracaso
 */
public static void setMsjFracaso(final String msjFracasoAux) {
  Paquete.msjFracaso = msjFracasoAux;
}
}
