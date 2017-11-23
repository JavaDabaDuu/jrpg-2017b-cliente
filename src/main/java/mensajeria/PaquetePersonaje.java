package mensajeria;

import dominio.Item;
import estados.Estado;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;
/**
 * The Class PaquetePersonaje.
 */
public class PaquetePersonaje extends Paquete implements Serializable,
Cloneable {

  /** The id. */
  private int id;

  /** The id mapa. */
  private int idMapa;

  /** The estado. */
  private int estado;

  /** The casta. */
  private String casta;

  /** The nombre. */
  private String nombre;

  /** The raza. */
  private String raza;

  /** The salud tope. */
  private int saludTope;

  /** The energia tope. */
  private int energiaTope;

  /** The fuerza. */
  private int fuerza;

  /** The destreza. */
  private int destreza;

  /** The inteligencia. */
  private int inteligencia;

  /** The nivel. */
  private int nivel = 1;
  
  private boolean invisible = false;
  
  private int idInventario;
  
  private int idMochila;
  
  /** Cantidad de veces que se ejecuto "bigdaddy"*/
  private int fuerzaAumentada;
  
  /**cantidad de veces que se uso "TinyDaddy"*/
  private int fuerzaDisminuida;
  
  private boolean [] npcsPeleados;
  
  private long [] peleaConNPC;

  public int getIdInventario() {
	return idInventario;
}

public void setIdInventario(int idInventario) {
	this.idInventario = idInventario;
}

public int getIdMochila() {
	return idMochila;
}

public void setIdMochila(int idMochila) {
	this.idMochila = idMochila;
}

/** The experiencia. */
  private int experiencia;

  /** The items. */
  private ArrayList<Item> items = new ArrayList<Item>();

  /** The puntos por nivel. */
  private int puntosPorNivel;

  /**
   * Instantiates a new paquete personaje.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public PaquetePersonaje() throws IOException {
    estado = Estado.getEstadoOffline();
    fuerzaAumentada = 0;
    fuerzaDisminuida = 0;
    npcsPeleados = new boolean [10];
    this.peleaConNPC = new long[10];
    
    for (int i = 0; i < npcsPeleados.length; i++) {
		npcsPeleados[i] = false;
		peleaConNPC[i]=0;
	}
  }

  /**
   * Gets the estado.
   *
   * @return the estado
   */
  public int getEstado() {
    return estado;
  }

  /**
   * Sets the estado.
   *
   * @param estadoAux the new estado
   */
  public void setEstado(final int estadoAux) {
    this.estado = estadoAux;
  }

  /**
   * Gets the mapa.
   *
   * @return the mapa
   */
  public int getMapa() {
    return idMapa;
  }

  /**
   * Sets the mapa.
   *
   * @param mapaAux the new mapa
   */
  public void setMapa(final int mapaAux) {
    idMapa = mapaAux;
  }

  /**
   * Gets the nivel.
   *
   * @return the nivel
   */
  public int getNivel() {
    return nivel;
  }

  /**
   * Sets the nivel.
   *
   * @param nivelAux the new nivel
   */
  public void setNivel(final int nivelAux) {
    this.nivel = nivelAux;
  }

  /**
   * Gets the experiencia.
   *
   * @return the experiencia
   */
  public int getExperiencia() {
    return experiencia;
  }

  /**
   * Sets the experiencia.
   *
   * @param experienciaAux the new experiencia
   */
  public void setExperiencia(final int experienciaAux) {
    this.experiencia = experienciaAux;
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
   * Gets the casta.
   *
   * @return the casta
   */
  public String getCasta() {
    return casta;
  }


  /**
   * Sets the casta.
   *
   * @param castaAux the new casta
   */
  public void setCasta(final String castaAux) {
    this.casta = castaAux;
  }

  /**
   * Gets the nombre.
   *
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }


  /**
   * Sets the nombre.
   *
   * @param nombreAux the new nombre
   */
  public void setNombre(final String nombreAux) {
    this.nombre = nombreAux;
  }

  /**
   * Gets the raza.
   *
   * @return the raza
   */
  public String getRaza() {
    return raza;
  }


  /**
   * Sets the raza.
   *
   * @param razaAux the new raza
   */
  public void setRaza(final String razaAux) {
    this.raza = razaAux;
  }

  /**
   * Gets the salud tope.
   *
   * @return the salud tope
   */
  public int getSaludTope() {
    return saludTope;
  }


  /**
   * Sets the salud tope.
   *
   * @param saludTopeAux the new salud tope
   */
  public void setSaludTope(final int saludTopeAux) {
    this.saludTope = saludTopeAux;
  }


  /**
   * Gets the energia tope.
   *
   * @return the energia tope
   */
  public int getEnergiaTope() {
    return energiaTope;
  }


  /**
   * Sets the energia tope.
   *
   * @param energiaTopeAux the new energia tope
   */
  public void setEnergiaTope(final int energiaTopeAux) {
    this.energiaTope = energiaTopeAux;
  }


  /**
   * Gets the fuerza.
   *
   * @return the fuerza
   */
  public int getFuerza() {
    return fuerza;
  }


  /**
   * Sets the fuerza.
   *
   * @param fuerzaAux the new fuerza
   */
  public void setFuerza(final int fuerzaAux) {
    this.fuerza = fuerzaAux;
  }


  /**
   * Gets the destreza.
   *
   * @return the destreza
   */
  public int getDestreza() {
    return destreza;
  }


  /**
   * Sets the destreza.
   *
   * @param destrezaAux the new destreza
   */
  public void setDestreza(final int destrezaAux) {
    this.destreza = destrezaAux;
  }

  /**
   * Gets the inteligencia.
   *
   * @return the inteligencia
   */
  public int getInteligencia() {
    return inteligencia;
  }


  /**
   * Sets the inteligencia.
   *
   * @param inteligenciaAux the new inteligencia
   */
  public void setInteligencia(final int inteligenciaAux) {
    this.inteligencia = inteligenciaAux;
  }

  /* (non-Javadoc)
   * @see mensajeria.Paquete#clone()
   */
  @Override
public Object clone() {
    Object obj = null;
    obj = super.clone();
    return obj;
  }

  /**
   * Anadir item.
   *
   * @param i the i
   */
  public final void anadirItem(final Item i) {
    items.add(i);
  }

  /**
   * Anadir item.
   *
   * @param idItem the id item
   */
  public void anadirItem(final int idItem) {
    try {
      items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Falló al añadir item");
    }
  }

  /**
   * Anadir item.
   *
   * @param idItem the id item
   * @param nombreAux the nombre
   * @param wearLocation the wear location
   * @param bonusSalud the bonus salud
   * @param bonusEnergia the bonus energia
   * @param bonusAtaque the bonus ataque
   * @param bonusDefensa the bonus defensa
   * @param bonusMagia the bonus magia
   * @param foto the foto
   * @param fotoEquipado the foto equipado
   */
  public final void anadirItem(final int idItem, final String nombreAux,
  final int wearLocation, final int bonusSalud, final int bonusEnergia,
  final int bonusAtaque, final int bonusDefensa, final int bonusMagia,
  final String foto, final String fotoEquipado) {
    try {
      items.add(new Item(idItem, nombreAux, wearLocation,
          bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
          bonusMagia, foto, fotoEquipado));
      useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Falló al añadir item");
    }
  }

  /**
   * Remover item.
   *
   * @param i the i
   */
  public final void removerItem(final Item i) {
    items.remove(i);
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public ArrayList<Item> getItems() {
    return new ArrayList<Item>(items);
  }

  /**
   * Sets the items.
   *
   * @param itemsAux the new items
   */
  public final void setItems(final ArrayList<Item> itemsAux) {
    this.items = itemsAux;
  }

  /**
   * Gets the item ID.
   *
   * @param indexAux the index
   * @return the item ID
   */
  public final int getItemID(final int indexAux) {
    return items.get(indexAux).getIdItem();
  }

  /**
   * Remover bonus.
   */
  public final void removerBonus() {
    //Intente usar un iterator y por alguna razón no andaba..
    int i = 0;
    while (i < items.size()) {
      sacarBonus(items.get(i).getBonusSalud(),
           items.get(i).getBonusEnergia(), items.get(i)
          .getBonusFuerza(), items.get(i).getBonusDestreza(),
          items.get(i).getBonusInteligencia());
      i++;
    }
  }

  /**
   * Sacar bonus.
   *
   * @param bonusSalud the bonus salud
   * @param bonusEnergia the bonus energia
   * @param bonusAtaque the bonus ataque
   * @param bonusDefensa the bonus defensa
   * @param bonusMagia the bonus magia
   */
  public final  void sacarBonus(final int bonusSalud, final int bonusEnergia,
  final int bonusAtaque, final int bonusDefensa, final int bonusMagia) {
    saludTope -= bonusSalud;
    energiaTope -= bonusEnergia;
    fuerza -= bonusAtaque;
    destreza -= bonusDefensa;
    inteligencia -= bonusMagia;
  }

  /**
   * Poner bonus.
   */
  public final void ponerBonus() {
    //Intente usar un iterator y por alguna razón no andaba..
    int i = 0;
    while (i < items.size()) {
      useBonus(items.get(i).getBonusSalud(),
          items.get(i).getBonusEnergia(), items.get(i)
          .getBonusFuerza(), items.get(i).getBonusDestreza(),
          items.get(i).getBonusInteligencia());
      i++;
    }
  }

  /**
   * Poner bonus.
   *
   * @param cantItems the cant items
   */
  public void ponerBonus(final int cantItems) {
    int i = 0;
    while (i < cantItems) {
      useBonus(items.get(i).getBonusSalud(),
        items.get(i).getBonusEnergia(), items.get(i)
        .getBonusFuerza(), items.get(i).getBonusDestreza(),
        items.get(i).getBonusInteligencia());
      i++;
    }
  }

  /**
   * Sets the atributos.
   *
   * @param salud the salud
   * @param energia the energia
   * @param ataque the ataque
   * @param defensa the defensa
   * @param inteligenciaAux the inteligencia
   */
  public void setAtributos(final int salud, final int energia, final int ataque,
  final int defensa, final int inteligenciaAux) {
    saludTope = salud;
    energiaTope = energia;
    fuerza = ataque;
    destreza = defensa;
    this.inteligencia = inteligenciaAux;
  }

  /**
   * Use bonus.
   *
   * @param bonusSalud the bonus salud
   * @param bonusEnergia the bonus energia
   * @param bonusAtaque the bonus ataque
   * @param bonusDefensa the bonus defensa
   * @param bonusMagia the bonus magia
   */
  public void useBonus(final int bonusSalud, final int bonusEnergia,
  final int bonusAtaque, final int bonusDefensa, final int bonusMagia) {
    saludTope += bonusSalud;
    energiaTope += bonusEnergia;
    fuerza += bonusAtaque;
    destreza += bonusDefensa;
    inteligencia += bonusMagia;
  }

  /**
   * Gets the cant items.
   *
   * @return the cant items
   */
  public int getCantItems() {
    return items.size();
  }

  /**
   * Gets the iterator.
   *
   * @return the iterator
   */
  public Iterator<Item> getIterator() {
    return items.iterator();
  }

  /**
   * Remover ultimo item.
   */
  public void removerUltimoItem() {
    items.remove(items.size() - 1);
  }

  /**
   * Nuevo item.
   *
   * @return true, if successful
   */
  public boolean nuevoItem() {
    return items.get(items.size() - 1).getNombre() == null;
  }

  /**
   * Sacar ultimo item.
   */
  public void sacarUltimoItem() {
    int i = items.size() - 1;
    if (i >= 0) {
      sacarBonus(items.get(i).getBonusSalud(),
          items.get(i).getBonusEnergia(), items.get(i)
          .getBonusFuerza(), items.get(i).getBonusDestreza(),
          items.get(i).getBonusInteligencia());
    }
  }

  /**
   * Poner ultimo item.
   */
  public void ponerUltimoItem() {
    int i = items.size() - 1;
    if (i >= 0) {
      useBonus(items.get(i).getBonusSalud(),
          items.get(i).getBonusEnergia(), items.get(i)
          .getBonusFuerza(), items.get(i).getBonusDestreza(),
          items.get(i).getBonusInteligencia());
    }
  }

  /**
   * Eliminar items.
   */
  public void eliminarItems() {
    items.removeAll(items);
  }

  /**
   * Actualizar trueque.
   *
   * @param itemsAux the items
   */
  public void actualizarTrueque(final ArrayList<Item> itemsAux) {
    this.items.removeAll(this.items);
    for (Item item : itemsAux) {
      this.items.add(item);
    }
  }

  /**
   * Actualizar puntos por nivel.
   */
  public void actualizarPuntosPorNivel() {
    this.puntosPorNivel += 3;
  }

  /**
   * Gets the puntos nivel.
   *
   * @return the puntos nivel
   */
  public int getPuntosNivel() {
    return this.puntosPorNivel;
  }

  /**
   * Sets the puntos nivel.
   *
   * @param puntos the new puntos nivel
   */
  public void setPuntosNivel(final int puntos) {
    this.puntosPorNivel = puntos;
  }

  /**
   * Actualizar atributos nivel.
   *
   * @param updates the updates
   */
  public void actualizarAtributosNivel(final HashMap<String, Number> updates) {
    this.saludTope += updates.get("salud").intValue();
    this.destreza += updates.get("destreza").intValue();
    this.fuerza += updates.get("fuerza").intValue();
    this.inteligencia += updates.get("inteligencia").intValue();
    this.energiaTope += updates.get("energia").intValue();
  }
/***
 * Devuelve si la fuerza ya fue aumentada o no
 * @return
 */

public int getFuerzaAumentada() {
	return fuerzaAumentada;
}

public void setFuerzaAumentada(int fuerzaAumentada) {
	this.fuerzaAumentada = fuerzaAumentada;
}

public int getFuerzaDisminuida() {
	return fuerzaDisminuida;
}

public void setFuerzaDisminuida(int fuerzaDisminuida) {
	this.fuerzaDisminuida = fuerzaDisminuida;
}

public boolean getInvisibilidad() {
	return this.invisible;
}

public void setInvisibilidad() {
    this.invisible = !(this.invisible);
}

public boolean getNpcsPeleados(int i) {
	
	//Con esto veo si ya pasaron mas de 10 segundos para volver a entrar en pelea
	if(npcsPeleados[i] && (System.currentTimeMillis() - peleaConNPC[i]) >= 10000)
		return false;
	else
		return npcsPeleados[i];
}

public void setNpcsPeleados(int i) {
	this.npcsPeleados[i] = true;
	
	//para saber en que momento entro en pelea con el npc
	this.peleaConNPC[i] = System.currentTimeMillis();
}


}
