package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The Class PaqueteAtacar.
 */
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

  /** The id. */
  private int id;

  /** The id enemigo. */
  private int idEnemigo;

  /** The nueva salud personaje. */
  private int nuevaSaludPersonaje;

  /** The nueva energia personaje. */
  private int nuevaEnergiaPersonaje;

  /** The nueva salud enemigo. */
  private int nuevaSaludEnemigo;

  /** The nueva energia enemigo. */
  private int nuevaEnergiaEnemigo;

  /** The map personaje. */
  private HashMap<String, Number> mapPersonaje
      = new HashMap<String, Number>();

  /** The map enemigo. */
  private HashMap<String, Number> mapEnemigo
      = new HashMap<String, Number>();

  /**
   * Instantiates a new paquete atacar.
   *
   * @param idAux the id
   * @param idEnemigoAux the id enemigo
   * @param nuevaSalud the nueva salud
   * @param nuevaEnergia the nueva energia
   * @param nuevaSaludEnemigoAux the nueva salud enemigo
   * @param nuevaEnergiaEnemigoAux the nueva energia enemigo
   * @param nuevaDefensa the nueva defensa
   * @param nuevaDefensaEnemigo the nueva defensa enemigo
   * @param probEvitarDano the prob evitar dano
   * @param probEvitarDanoEnemgio the prob evitar dano enemgio
   */
  public PaqueteAtacar(final int idAux, final int idEnemigoAux,
  final int nuevaSalud, final int nuevaEnergia,
  final int nuevaSaludEnemigoAux, final int nuevaEnergiaEnemigoAux,
  final int nuevaDefensa, final int nuevaDefensaEnemigo,
  final double probEvitarDano, final double probEvitarDanoEnemgio) {
    setComando(Comando.ATACAR);
    this.id = idAux;
    this.idEnemigo = idEnemigoAux;
    this.nuevaSaludPersonaje = nuevaSalud;
    this.nuevaEnergiaPersonaje = nuevaEnergia;
    this.nuevaSaludEnemigo = nuevaSaludEnemigoAux;
    this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigoAux;
    mapPersonaje.put("salud", nuevaSalud);
    mapPersonaje.put("energia", nuevaEnergia);
    mapPersonaje.put("defensa", nuevaDefensa);
    mapPersonaje.put("probEvitarDanio", probEvitarDano);
    mapEnemigo.put("salud", nuevaSaludEnemigoAux);
    mapEnemigo.put("energia", nuevaEnergiaEnemigoAux);
    mapEnemigo.put("defensa", nuevaDefensaEnemigo);
    mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
  }

  /**
   * Instantiates a new paquete atacar.
   *
   * @param personaje the personaje
   * @param enemigo the enemigo
   * @param salud the salud
   * @param energia the energia
   * @param saludEnemigo the salud enemigo
   * @param defensa the defensa
   * @param defensaEnemigo the defensa enemigo
   * @param probabilidadEvitarDaño the probabilidad evitar daño
   */
  public PaqueteAtacar(final int personaje, final int enemigo,
  final int salud, final int energia, final int saludEnemigo,
  final int defensa, final int defensaEnemigo,
  final double probabilidadEvitarDaño) {
    setComando(Comando.ATACAR);
    this.id = personaje;
    this.idEnemigo = enemigo;
    this.nuevaSaludPersonaje = salud;
    this.nuevaEnergiaPersonaje = energia;
    this.nuevaSaludEnemigo = saludEnemigo;

    mapPersonaje.put("salud", salud);
    mapPersonaje.put("energia", energia);
    mapPersonaje.put("defensa", defensa);
    mapPersonaje.put("probEvitarDanio", probabilidadEvitarDaño);
    mapEnemigo.put("salud", saludEnemigo);
    mapEnemigo.put("defensa", defensaEnemigo);
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
   * Gets the nueva salud personaje.
   *
   * @return the nueva salud personaje
   */
  public int getNuevaSaludPersonaje() {
    return nuevaSaludPersonaje;
  }

  /**
   * Sets the nueva salud personaje.
   *
   * @param nuevaSaludPersonajeAux the new nueva salud personaje
   */
  public void setNuevaSaludPersonaje(final int nuevaSaludPersonajeAux) {
    this.nuevaSaludPersonaje = nuevaSaludPersonajeAux;
  }

  /**
   * Gets the nueva energia personaje.
   *
   * @return the nueva energia personaje
   */
  public int getNuevaEnergiaPersonaje() {
    return nuevaEnergiaPersonaje;
  }

  /**
   * Sets the nueva energia personaje.
   *
   * @param nuevaEnergiaPersonajeAux the new nueva energia personaje
   */
  public void setNuevaEnergiaPersonaje(final int nuevaEnergiaPersonajeAux) {
    this.nuevaEnergiaPersonaje = nuevaEnergiaPersonajeAux;
  }

  /**
   * Gets the nueva salud enemigo.
   *
   * @return the nueva salud enemigo
   */
  public int getNuevaSaludEnemigo() {
    return nuevaSaludEnemigo;
  }

  /**
   * Sets the nueva salud enemigo.
   *
   * @param nuevaSaludEnemigoAux the new nueva salud enemigo
   */
  public void setNuevaSaludEnemigo(final int nuevaSaludEnemigoAux) {
    this.nuevaSaludEnemigo = nuevaSaludEnemigoAux;
  }

  /**
   * Gets the nueva energia enemigo.
   *
   * @return the nueva energia enemigo
   */
  public int getNuevaEnergiaEnemigo() {
    return nuevaEnergiaEnemigo;
  }

  /**
   * Sets the nueva energia enemigo.
   *
   * @param nuevaEnergiaEnemigoAux the new nueva energia enemigo
   */
  public void setNuevaEnergiaEnemigo(final int nuevaEnergiaEnemigoAux) {
    this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigoAux;
  }

  /**
   * Gets the map personaje.
   *
   * @return the map personaje
   */
  public HashMap<String, Number> getMapPersonaje() {
    return mapPersonaje;
  }

  /**
   * Gets the map enemigo.
   *
   * @return the map enemigo
   */
  public HashMap<String, Number> getMapEnemigo() {
    return mapEnemigo;
  }
}
