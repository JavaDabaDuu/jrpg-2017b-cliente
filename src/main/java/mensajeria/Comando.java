package mensajeria;

import com.google.gson.Gson;

/**
 * The Class Comando.
 */
public abstract class Comando {

  /** The Constant NOMBREPAQUETE. */
  // Nombre del paquete donde se encuentran las clases con las responsabilidades
  public static final String NOMBREPAQUETE = "comandos";

  /** The Constant CLASSNAMES. */
  public static final String[] CLASSNAMES = {"Conexion", "CrearPersonaje",
   "Desconectar", "InicioSesion", "MostrarMapas", "Movimiento", "Registro",
   "Salir", "Batalla", "Atacar", "FinalizarBatalla", "ActualizarPersonaje",
   "ActualizarPersonajeLvl", "ActualizarInventario", "Comercio",
   "ActualizarComercio", "Trueque", "ActualizarTrueque", "Talk",
   "ActualizarPtsLvl", "ActualizarNPC", "SetearNPC", "BatallaNPC",
   "FinalizarBatallaNPC"};

  /** The Constant CLASSNAMESBIS. */
  public static final String[] CLASSNAMESBIS = {"Conexion", "CrearPersonaje",
    "Desconectar", "InicioSesionSet", "MostrarMapas", "Movimiento",
    "RegistroSet", "SalirSet", "Batalla", "Atacar", "FinalizarBatalla",
    "ActualizarPersonaje", "ActualizarPersonajeLvl", "ActualizarInventario",
    "Comercio", "ActualizarComercio", "Trueque", "ActualizarTrueque", "Talk",
    "ActualizarPtsLvl", "ActualizarNPC", "SetearNPC", "BatallaNPC",
    "FinalizarBatallaNPC" };

  /** The Constant CONEXION. */
  public static final int CONEXION = 0;

  /** The Constant CREACIONPJ. */
  public static final int CREACIONPJ = 1;

  /** The Constant DESCONECTAR. */
  public static final int DESCONECTAR = 2;

  /** The Constant INICIOSESION. */
  public static final int INICIOSESION = 3;

  /** The Constant MOSTRARMAPAS. */
  public static final int MOSTRARMAPAS = 4;

  /** The Constant MOVIMIENTO. */
  public static final int MOVIMIENTO = 5;

  /** The Constant REGISTRO. */
  public static final int REGISTRO = 6;

  /** The Constant SALIR. */
  public static final int SALIR = 7;

  /** The Constant BATALLA. */
  public static final int BATALLA = 8;

  /** The Constant ATACAR. */
  public static final int ATACAR = 9;

  /** The Constant FINALIZARBATALLA. */
  public static final int FINALIZARBATALLA = 10;

  /** The Constant ACTUALIZARPERSONAJE. */
  public static final int ACTUALIZARPERSONAJE = 11;

  /** The Constant ACTUALIZARPERSONAJELV. */
  public static final int ACTUALIZARPERSONAJELV = 12;

  /** The Constant ACTUALIZARINVENTARIO. */
  public static final int ACTUALIZARINVENTARIO = 13;

  /** The Constant COMERCIO. */
  public static final int COMERCIO = 14;

  /** The Constant ACTUALIZARCOMERCIO. */
  public static final int ACTUALIZARCOMERCIO = 15;

  /** The Constant TRUEQUE. */
  public static final int TRUEQUE = 16;

  /** The Constant ACTUALIZARTRUEQUE. */
  public static final int ACTUALIZARTRUEQUE = 17;

  /** The Constant TALK. */
  public static final int TALK = 18;

  /** The Constant ACTUALIZARPTOSLVL. */
  public static final int ACTUALIZARPTOSLVL = 19;

  /** The Constant ACTUALIZARNPC. */
  public static final int ACTUALIZARNPC = 20;

  /** The Constant SETEARNPC. */
  public static final int SETEARNPC = 21;

  /** The Constant BATALLANPC. */
  public static final int BATALLANPC = 22;

  /** The Constant FINALIZARBATALLANPC. */
  public static final int FINALIZARBATALLANPC = 23;

  /** The gson. */
  private final Gson gson = new Gson();

  /** The cadena leida. */
  private String cadenaLeida;

  /**
   * Sets the cadena.
   *
   * @param cadenaLeidaAux the new cadena
   */
  public void setCadena(final String cadenaLeidaAux) {
    this.setCadenaLeida(cadenaLeidaAux);
  }

  /**
   * Ejecutar.
   */
  public abstract void ejecutar();

/**
 * Gets the cadena leida.
 *
 * @return the cadena leida
 */
public String getCadenaLeida() {
  return cadenaLeida;
}

/**
 * Sets the cadena leida.
 *
 * @param cadenaLeidaAux the new cadena leida
 */
public void setCadenaLeida(final String cadenaLeidaAux) {
  this.cadenaLeida = cadenaLeidaAux;
}

/**
 * Gets the gson.
 *
 * @return the gson
 */
public Gson getGson() {
  return gson;
}
}
