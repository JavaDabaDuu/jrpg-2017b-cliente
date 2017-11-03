package mensajeria;

import dominio.Item;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The Class PaqueteComerciar.
 */
public class PaqueteComerciar extends Paquete implements Serializable,
Cloneable  {

  /** The id. */
  private int id;

  /** The id enemigo. */
  private int idEnemigo;

  /** The listo. */
  private int listo = 0;

  /** The items A dar. */
  private ArrayList<Item> itemsADar = new ArrayList<Item>();

  /** The items A obtener. */
  private ArrayList<Item> itemsAObtener = new ArrayList<Item>();

  /** The solicitud de comercio. */
  private boolean solicitudDeComercio;

  /**
   * Instantiates a new paquete comerciar.
   */
  public PaqueteComerciar() {
    setComando(Comando.COMERCIO);
    solicitudDeComercio = true;
  }

  /**
   * Checks if is solicitud de comercio.
   *
   * @return true, if is solicitud de comercio
   */
  public boolean isSolicitudDeComercio() {
    return solicitudDeComercio;
  }

  /**
   * Sets the solicitud de comercio.
   *
   * @param solicitudDeComercioAux the new solicitud de comercio
   */
  public void setSolicitudDeComercio(final boolean solicitudDeComercioAux) {
    this.solicitudDeComercio = solicitudDeComercioAux;
  }

  /**
   * Gets the items A dar.
   *
   * @return the items A dar
   */
  public ArrayList<Item> getItemsADar() {
    return itemsADar;
  }

  /**
   * Sets the items A dar.
   *
   * @param itemsADarAux the new items A dar
   */
  public void setItemsADar(final ArrayList<Item> itemsADarAux) {
    this.itemsADar = itemsADarAux;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param idAux the new id
   */
  public void setId(final int idAux) {
    this.id = idAux;
  }

  /**
   * Gets the id enemigo.
   *
   * @return the id enemigo
   */
  public int getIdEnemigo() {
    return idEnemigo;
  }

  /**
   * Sets the id enemigo.
   *
   * @param idEnemigoAux the new id enemigo
   */
  public void setIdEnemigo(final int idEnemigoAux) {
    this.idEnemigo = idEnemigoAux;
  }

  /**
   * Gets the listo.
   *
   * @return the listo
   */
  public int getListo() {
    return listo;
  }

  /**
   * Aumentar listo.
   */
  public void aumentarListo() {
    this.listo++;
  }

  /**
   * Disminuir listo.
   */
  public void disminuirListo() {
    this.listo--;
  }

  /**
   * Gets the items A obtener.
   *
   * @return the items A obtener
   */
  public ArrayList<Item> getItemsAObtener() {
    return itemsAObtener;
  }

  /**
   * Sets the items A obtener.
   *
   * @param itemsAObtenerAux the new items A obtener
   */
  public void setItemsAObtener(final ArrayList<Item> itemsAObtenerAux) {
    this.itemsAObtener = itemsAObtenerAux;
  }
}
