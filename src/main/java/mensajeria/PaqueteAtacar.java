package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

  private int id;
  private int idEnemigo;
  private int nuevaSaludPersonaje;
  private int nuevaEnergiaPersonaje;
  private int nuevaSaludEnemigo;
  private int nuevaEnergiaEnemigo;
  private HashMap<String,Number> mapPersonaje = new HashMap<String,Number>();
  private HashMap<String,Number> mapEnemigo = new HashMap<String,Number>();

  public PaqueteAtacar(int id, int idEnemigo, int nuevaSalud, int nuevaEnergia,
      int nuevaSaludEnemigo, int nuevaEnergiaEnemigo, int nuevaDefensa, int nuevaDefensaEnemigo,
          double probEvitarDano, double probEvitarDanoEnemgio) {
    setComando(Comando.ATACAR);
    this.id = id;
    this.idEnemigo = idEnemigo;
    this.nuevaSaludPersonaje = nuevaSalud;
    this.nuevaEnergiaPersonaje = nuevaEnergia;
    this.nuevaSaludEnemigo = nuevaSaludEnemigo;
    this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
    mapPersonaje.put("salud", nuevaSalud);
    mapPersonaje.put("energia", nuevaEnergia);
    mapPersonaje.put("defensa", nuevaDefensa);
    mapPersonaje.put("probEvitarDanio", probEvitarDano);
    mapEnemigo.put("salud", nuevaSaludEnemigo);
    mapEnemigo.put("energia", nuevaEnergiaEnemigo);
    mapEnemigo.put("defensa", nuevaDefensaEnemigo);
    mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
  }

  public PaqueteAtacar(int personaje, int enemigo, int salud, int energia, int saludEnemigo,
      int defensa, int defensaEnemigo, double probabilidadEvitarDaño) {
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdEnemigo() {
    return idEnemigo;
  }

  public void setIdEnemigo(int idEnemigo) {
    this.idEnemigo = idEnemigo;
  }

  public int getNuevaSaludPersonaje() {
    return nuevaSaludPersonaje;
  }
  
  public void setNuevaSaludPersonaje(int nuevaSaludPersonaje) {
    this.nuevaSaludPersonaje = nuevaSaludPersonaje;
  }

  public int getNuevaEnergiaPersonaje() {
    return nuevaEnergiaPersonaje;
  }

  public void setNuevaEnergiaPersonaje(int nuevaEnergiaPersonaje) {
    this.nuevaEnergiaPersonaje = nuevaEnergiaPersonaje;
  }

  public int getNuevaSaludEnemigo() {
    return nuevaSaludEnemigo;
  }

  public void setNuevaSaludEnemigo(int nuevaSaludEnemigo) {
    this.nuevaSaludEnemigo = nuevaSaludEnemigo;
  }

  public int getNuevaEnergiaEnemigo() {
    return nuevaEnergiaEnemigo;
  }

  public void setNuevaEnergiaEnemigo(int nuevaEnergiaEnemigo) {
    this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
  }

  public HashMap<String, Number> getMapPersonaje() {
    return mapPersonaje;
  }

  public HashMap<String, Number> getMapEnemigo() {
    return mapEnemigo;
  }
}
