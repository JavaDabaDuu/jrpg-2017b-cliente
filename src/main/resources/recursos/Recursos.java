package recursos;

import frames.MenuCarga;
import frames.MenuMapas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.imageio.ImageIO;

import mundo.Tile;

/**
 * The Class Recursos.
 */
public class Recursos {

  /** The elementos. */
  private static final int ELEMENTOS = 65;

  /** The anchobarra. */
  private static final int ANCHOBARRA = 345;

  /** Ancho del frame a obtener. */
  private static final int ANCHO = 256;

  /** Alto del frame a obtener. */
  private static final int ALTO = 256;

  /** The Constant TAMAÑOIMAGEN. */
  private static final int TAMAÑOIMAGEN = 4;

  // Inicio Personajes
  /** The personaje. */
  // Hash de imagenes para los personajes (humano, ogro, elfo)
  private static Map<String,
      LinkedList<BufferedImage[]>> personaje = new HashMap<>();

  /** The sprite humano. */
  private static SpriteSheet spriteHumano;

  /** The humano. */
  private static LinkedList<BufferedImage[]> humano = new LinkedList<>();

  /** The humano izq. */
  private static BufferedImage[] humanoIzq;

  /** The humano arriba izq. */
  private static BufferedImage[] humanoArribaIzq;

  /** The humano arriba. */
  private static BufferedImage[] humanoArriba;

  /** The humano arriba der. */
  private static BufferedImage[] humanoArribaDer;

  /** The humano der. */
  private static BufferedImage[] humanoDer;

  /** The humano abajo der. */
  private static BufferedImage[] humanoAbajoDer;

  /** The humano abajo. */
  private static BufferedImage[] humanoAbajo;

  /** The humano abajo izq. */
  private static BufferedImage[] humanoAbajoIzq;

  /** The sprite orco. */
  private static SpriteSheet spriteOrco;

  /** The orco. */
  private static LinkedList<BufferedImage[]> orco = new LinkedList<>();

  /** The orco izq. */
  private static BufferedImage[] orcoIzq;

  /** The orco arriba izq. */
  private static BufferedImage[] orcoArribaIzq;

  /** The orco arriba. */
  private static BufferedImage[] orcoArriba;

  /** The orco arriba der. */
  private static BufferedImage[] orcoArribaDer;

  /** The orco der. */
  private static BufferedImage[] orcoDer;

  /** The orco abajo der. */
  private static BufferedImage[] orcoAbajoDer;

  /** The orco abajo. */
  private static BufferedImage[] orcoAbajo;

  /** The orco abajo izq. */
  private static BufferedImage[] orcoAbajoIzq;

  /** The sprite elfo. */
  private static SpriteSheet spriteElfo;

  /** The elfo. */
  private static LinkedList<BufferedImage[]> elfo = new LinkedList<>();

  /** The elfo izq. */
  private static BufferedImage[] elfoIzq;

  /** The elfo arriba izq. */
  private static BufferedImage[] elfoArribaIzq;

  /** The elfo arriba. */
  private static BufferedImage[] elfoArriba;

  /** The elfo arriba der. */
  private static BufferedImage[] elfoArribaDer;

  /** The elfo der. */
  private static BufferedImage[] elfoDer;

  /** The elfo abajo der. */
  private static BufferedImage[] elfoAbajoDer;

  /** The elfo abajo. */
  private static BufferedImage[] elfoAbajo;

  /** The elfo abajo izq. */
  private static BufferedImage[] elfoAbajoIzq;

  /** The sprite minotauro. */
  private static SpriteSheet spriteMinotauro;

  /** The minotauro. */
  private static LinkedList<BufferedImage[]> minotauro = new LinkedList<>();

  /** The minotauro izq. */
  private static BufferedImage[] minotauroIzq;

  /** The minotauro arriba izq. */
  private static BufferedImage[] minotauroArribaIzq;

  /** The minotauro arriba. */
  private static BufferedImage[] minotauroArriba;

  /** The minotauro arriba der. */
  private static BufferedImage[] minotauroArribaDer;

  /** The minotauro der. */
  private static BufferedImage[] minotauroDer;

  /** The minotauro abajo der. */
  private static BufferedImage[] minotauroAbajoDer;

  /** The minotauro abajo. */
  private static BufferedImage[] minotauroAbajo;

  /** The minotauro abajo izq. */
  private static BufferedImage[] minotauroAbajoIzq;
  // Fin Personajes

  /** The trees. */
  // Entorno
  private static SpriteSheet trees;

  /** The cesped. */
  private static BufferedImage cesped;

  /** The roca. */
  private static BufferedImage roca;

  /** The background. */
  private static BufferedImage background;

  /** The marco. */
  private static BufferedImage marco;

  /** The boton menu. */
  private static BufferedImage botonMenu;

  /** The menu enemigo. */
  private static BufferedImage menuEnemigo;

  /** The green tree. */
  private static BufferedImage greenTree;

  /** The nieve piso 1. */
  private static BufferedImage nievePiso1;

  /** The ice block. */
  private static BufferedImage iceBlock;
  // Fin Entorno

  /** The barra spells. */
  // Batalla
  private static BufferedImage barraSpells;

  /** The estado personaje. */
  private static BufferedImage estadoPersonaje;

  /** The barra salud. */
  private static BufferedImage barraSalud;

  /** The barra energia. */
  private static BufferedImage barraEnergia;

  /** The barra experiencia. */
  private static BufferedImage barraExperiencia;

  /** The menu batalla. */
  private static BufferedImage menuBatalla;

  /** The menu batalla deshabilitado. */
  private static BufferedImage menuBatallaDeshabilitado;

  /** The no item. */
  private static BufferedImage noItem;

  /** The mochila. */
  private static BufferedImage mochila;

  /** The menu. */
  private static BufferedImage menu;

  /** The chat. */
  private static BufferedImage chat;

  /** The habilidades. */
  private static Map<String, BufferedImage> habilidades = new HashMap<>();
  // Fin Batalla

  /**
   * Cargar.
   *
   * @param menuCarga the menu carga
   * @throws NumberFormatException the number format exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  // Se cargan todos los recursos del juego una sola vez al inicio
  public static void cargar(final MenuCarga menuCarga)
      throws NumberFormatException, IOException {

    //ANCHO = 256;
    //ALTO = 256;
    // Items

    setNoItem(ImageIO.read(new File("recursos//noItem.png")));
    setMochila(ImageIO.read(new File("recursos//mochila.png")));
    setMenu(ImageIO.read(new File("recursos//menu.png")));
    setChat(ImageIO.read(new File("recursos//chat.png")));

    // Inicio humano
    spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));
    int elementosCargados = 0;
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    humanoIzq = new BufferedImage[TAMAÑOIMAGEN];
    humanoArribaIzq = new BufferedImage[TAMAÑOIMAGEN];
    humanoArriba = new BufferedImage[TAMAÑOIMAGEN];
    humanoArribaDer = new BufferedImage[TAMAÑOIMAGEN];
    humanoDer = new BufferedImage[TAMAÑOIMAGEN];
    humanoAbajoDer = new BufferedImage[TAMAÑOIMAGEN];
    humanoAbajo = new BufferedImage[TAMAÑOIMAGEN];
    humanoAbajoIzq = new BufferedImage[TAMAÑOIMAGEN];

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoIzq[i] = spriteHumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoArribaIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoArriba[i] = spriteHumano.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i,
          ALTO * 3, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i,
          ALTO * 5, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * 7,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    humano.add(humanoIzq);
    humano.add(humanoArribaIzq);
    humano.add(humanoArriba);
    humano.add(humanoArribaDer);
    humano.add(humanoDer);
    humano.add(humanoAbajoDer);
    humano.add(humanoAbajo);
    humano.add(humanoAbajoIzq);
    // Fin humano

    // Inicio Orco
    spriteOrco = new SpriteSheet(CargadorImagen.cargarImagen("/Orco.png"));

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    orcoIzq = new BufferedImage[TAMAÑOIMAGEN];
    orcoArribaIzq = new BufferedImage[TAMAÑOIMAGEN];
    orcoArriba = new BufferedImage[TAMAÑOIMAGEN];
    orcoArribaDer = new BufferedImage[TAMAÑOIMAGEN];
    orcoDer = new BufferedImage[TAMAÑOIMAGEN];
    orcoAbajoDer = new BufferedImage[TAMAÑOIMAGEN];
    orcoAbajo = new BufferedImage[TAMAÑOIMAGEN];
    orcoAbajoIzq = new BufferedImage[TAMAÑOIMAGEN];

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoIzq[i] = spriteOrco.getTile(ANCHO * i, 0, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoArribaIzq[i] = spriteOrco.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoArriba[i] = spriteOrco.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoArribaDer[i] = spriteOrco.getTile(ANCHO * i, ALTO * 3,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoDer[i] = spriteOrco.getTile(ANCHO * i, ALTO * 4,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoAbajoDer[i] = spriteOrco.getTile(ANCHO * i, ALTO * 5,
         ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoAbajo[i] = spriteOrco.getTile(ANCHO * i, ALTO * 6,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      orcoAbajoIzq[i] = spriteOrco.getTile(ANCHO * i, ALTO * 7,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    orco.add(orcoIzq);
    orco.add(orcoArribaIzq);
    orco.add(orcoArriba);
    orco.add(orcoArribaDer);
    orco.add(orcoDer);
    orco.add(orcoAbajoDer);
    orco.add(orcoAbajo);
    orco.add(orcoAbajoIzq);

    // Fin Orco

    // Inicio Elfo
    spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo2.png"));

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    elfoIzq = new BufferedImage[TAMAÑOIMAGEN];
    elfoArribaIzq = new BufferedImage[TAMAÑOIMAGEN];
    elfoArriba = new BufferedImage[TAMAÑOIMAGEN];
    elfoArribaDer = new BufferedImage[TAMAÑOIMAGEN];
    elfoDer = new BufferedImage[TAMAÑOIMAGEN];
    elfoAbajoDer = new BufferedImage[TAMAÑOIMAGEN];
    elfoAbajo = new BufferedImage[TAMAÑOIMAGEN];
    elfoAbajoIzq = new BufferedImage[TAMAÑOIMAGEN];

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 3,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 4,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 5,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * 6,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * 7,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    elfo.add(elfoIzq);
    elfo.add(elfoArribaIzq);
    elfo.add(elfoArriba);
    elfo.add(elfoArribaDer);
    elfo.add(elfoDer);
    elfo.add(elfoAbajoDer);
    elfo.add(elfoAbajo);
    elfo.add(elfoAbajoIzq);

    // Fin Elfo

    //Inicio Minotauro

    spriteMinotauro = new SpriteSheet(CargadorImagen
        .cargarImagen("/minotauro.png"));

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    minotauroIzq = new BufferedImage[TAMAÑOIMAGEN];
    minotauroArribaIzq = new BufferedImage[TAMAÑOIMAGEN];
    minotauroArriba = new BufferedImage[TAMAÑOIMAGEN];
    minotauroArribaDer = new BufferedImage[TAMAÑOIMAGEN];
    minotauroDer = new BufferedImage[TAMAÑOIMAGEN];
    minotauroAbajoDer = new BufferedImage[TAMAÑOIMAGEN];
    minotauroAbajo = new BufferedImage[TAMAÑOIMAGEN];
    minotauroAbajoIzq = new BufferedImage[TAMAÑOIMAGEN];

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroIzq[i] = spriteMinotauro.getTile(ANCHO * i, 0, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroArribaIzq[i] = spriteMinotauro.getTile(ANCHO * i,
          ALTO, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroArriba[i] = spriteMinotauro.getTile(ANCHO * i, ALTO * 2,
         ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroArribaDer[i] = spriteMinotauro.getTile(ANCHO * i,
          ALTO * 3, ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroDer[i] = spriteMinotauro.getTile(ANCHO * i, ALTO * 4,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroAbajoDer[i] = spriteMinotauro.getTile(ANCHO * i, ALTO * 5,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroAbajo[i] = spriteMinotauro.getTile(ANCHO * i, ALTO * 6,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    for (int i = 0; i < TAMAÑOIMAGEN; i++) {
      minotauroAbajoIzq[i] = spriteMinotauro.getTile(ANCHO * i, ALTO * 7,
          ANCHO, ALTO);
    }

    actualizarBarraDeCarga(++elementosCargados, menuCarga);


    minotauro.add(minotauroIzq);
    minotauro.add(minotauroArribaIzq);
    minotauro.add(minotauroArriba);
    minotauro.add(minotauroArribaDer);
    minotauro.add(minotauroDer);
    minotauro.add(minotauroAbajoDer);
    minotauro.add(minotauroAbajo);
    minotauro.add(minotauroAbajoIzq);

    //Fin Minotauro

    // Agrego los pj al hash
    getPersonaje().put("Humano", humano);
    getPersonaje().put("Orco", orco);
    getPersonaje().put("Elfo", elfo);
    getPersonaje().put("Minotauro", minotauro);

    // Inicio Entorno
    cesped = CargadorImagen.cargarImagen("/Cesped.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    roca = CargadorImagen.cargarImagen("/rock.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setBackground(CargadorImagen.cargarImagen("/background.jpg"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setMarco(CargadorImagen.cargarImagen("/marco.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setBotonMenu(CargadorImagen.cargarImagen("/botonMenu.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setMenuEnemigo(CargadorImagen.cargarImagen("/MenuEnemigo.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    greenTree = trees.getTile(0, 0, 42, 50);
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    nievePiso1 = CargadorImagen.cargarImagen("/nieve piso.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    iceBlock = CargadorImagen.cargarImagen("/nieve cubo.png");

    // Mapa
    if (MenuMapas.getNumberMap() == 1) {
      SpriteSheet mapaAubenor = new SpriteSheet(
          CargadorImagen.cargarImagen("/Aubenor.png"));
      Tile.setAubenor(new Tile[81]);
      boolean[][] solidezAubenor = {{true, true,
          false, true, false, true, true, true, true, true },
          {true, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true},
          {true, false, false, false, false, false, false, false, true, true},
          {false, false, false, false, false, false, false, false, true, true},
          {false, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true}};
      for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 10; x++) {
          Tile.getAubenor()[y * 10 + x + 1] = new Tile(
            mapaAubenor.getTile(x * 64, y * 64, 64, 64), y * 10 + x + 1,
            solidezAubenor[y][x], 64, 64);
        }
      }
    } else {
      SpriteSheet mapaAris = new SpriteSheet(
          CargadorImagen.cargarImagen("/Aris.png"));
      Tile.setAris(new Tile[81]);
      boolean[][] solidezAris = {{true, false, false, false, false,
          false, false, true, true, true },
          {false, false, false, false, false, false, false, false, true, true},
          {false, false, false, false, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true},
          {false, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true},
          {true, true, true, true, true, true, true, true, true, true}};
      for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 10; x++) {
          Tile.getAris()[y * 10 + x + 1] = new Tile(mapaAris.getTile(
           x * 64, y * 64, 64, 64), y * 10 + x + 1,
                  solidezAris[y][x], 64, 64);
        }
      }
    }

    // Fin Entorno

    // Inicio Batalla
    barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setBarraEnergia(CargadorImagen.cargarImagen("/BarraDeEnergia.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    setBarraExperiencia(CargadorImagen.cargarImagen("/BarraDeExperiencia.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Golpe Level",
        CargadorImagen.cargarImagen("/Golpe Level.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Ataque Bosque",
        CargadorImagen.cargarImagen("/Ataque Bosque.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Golpe Defensa",
        CargadorImagen.cargarImagen("/Golpe Defensa.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Mordisco de Vida",
        CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Incentivar",
        CargadorImagen.cargarImagen("/Incentivar.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Golpe Fatal",
        CargadorImagen.cargarImagen("/Golpe Fatal.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Ataque Doble",
        CargadorImagen.cargarImagen("/Ataque Doble.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Aumentar Defensa",
        CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Ignorar Defensa",
        CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Bola de Fuego",
        CargadorImagen.cargarImagen("/Bola de Fuego.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Curar Aliado",
        CargadorImagen.cargarImagen("/Curar Aliado.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Robar Energia y Salud", CargadorImagen.cargarImagen(
         "/Robar Energia y Salud.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Golpe Critico",
        CargadorImagen.cargarImagen("/Golpe Critico.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Aumentar Evasion",
        CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    getHabilidades().put("Ser Energizado",
        CargadorImagen.cargarImagen("/Ser Energizado.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    setMenuBatalla(CargadorImagen.cargarImagen("/MenuBatalla.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);

    setMenuBatallaDeshabilitado(CargadorImagen
        .cargarImagen("/MenuBatallaDeshabilitado.png"));
    actualizarBarraDeCarga(++elementosCargados, menuCarga);
    // Fin Batalla
  }

  /**
   * Actualizar barra de carga.
   *
   * @param elementosCargados the elementos cargados
   * @param menuCarga the menu carga
   */
  private static void actualizarBarraDeCarga(
  final int elementosCargados, final  MenuCarga menuCarga) {
    menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
  }

/**
 * Gets the estado personaje.
 *
 * @return the estado personaje
 */
public static BufferedImage getEstadoPersonaje() {
   return estadoPersonaje;
}

/**
 * Sets the estado personaje.
 *
 * @param estadoPersonajeAux the new estado personaje
 */
public static void setEstadoPersonaje(final BufferedImage estadoPersonajeAux) {
   Recursos.estadoPersonaje = estadoPersonajeAux;
}

/**
 * Gets the barra salud.
 *
 * @return the barra salud
 */
public static BufferedImage getBarraSalud() {
  return barraSalud;
}

/**
 * Sets the barra salud.
 *
 * @param barraSaludAux the new barra salud
 */
public static void setBarraSalud(final BufferedImage barraSaludAux) {
   Recursos.barraSalud = barraSaludAux;
}

/**
 * Gets the personaje.
 *
 * @return the personaje
 */
public static Map<String,
      LinkedList<BufferedImage[]>> getPersonaje() {
  return personaje;
}

/**
 * Sets the personaje.
 *
 * @param personajeAux the personaje aux
 */
public static void setPersonaje(final Map<String,
      LinkedList<BufferedImage[]>> personajeAux) {
  Recursos.personaje = personajeAux;
}

/**
 * Gets the background.
 *
 * @return the background
 */
public static BufferedImage getBackground() {
  return background;
}

/**
 * Sets the background.
 *
 * @param backgroundAux the new background
 */
public static void setBackground(final BufferedImage backgroundAux) {
  Recursos.background = backgroundAux;
}

/**
 * Gets the marco.
 *
 * @return the marco
 */
public static BufferedImage getMarco() {
  return marco;
}

/**
 * Sets the marco.
 *
 * @param marcoAux the new marco
 */
public static void setMarco(final BufferedImage marcoAux) {
  Recursos.marco = marcoAux;
}

/**
 * Gets the menu.
 *
 * @return the menu
 */
public static BufferedImage getMenu() {
  return menu;
}

/**
 * Sets the menu.
 *
 * @param menuAux the new menu
 */
public static void setMenu(final BufferedImage menuAux) {
  Recursos.menu = menuAux;
}

/**
 * Gets the mochila.
 *
 * @return the mochila
 */
public static BufferedImage getMochila() {
  return mochila;
}

/**
 * Sets the mochila.
 *
 * @param mochilaAux the new mochila
 */
public static void setMochila(final BufferedImage mochilaAux) {
  Recursos.mochila = mochilaAux;
}

/**
 * Gets the chat.
 *
 * @return the chat
 */
public static BufferedImage getChat() {
  return chat;
}

/**
 * Sets the chat.
 *
 * @param chatAux the new chat
 */
public static void setChat(final BufferedImage chatAux) {
  Recursos.chat = chatAux;
}

/**
 * Gets the barra energia.
 *
 * @return the barra energia
 */
public static BufferedImage getBarraEnergia() {
  return barraEnergia;
}

/**
 * Sets the barra energia.
 *
 * @param barraEnergiaAux the new barra energia
 */
public static void setBarraEnergia(final BufferedImage barraEnergiaAux) {
  Recursos.barraEnergia = barraEnergiaAux;
}

/**
 * Gets the barra experiencia.
 *
 * @return the barra experiencia
 */
public static BufferedImage getBarraExperiencia() {
  return barraExperiencia;
}

/**
 * Sets the barra experiencia.
 *
 * @param barraExperienciaAux the new barra experiencia
 */
public static void setBarraExperiencia(
final BufferedImage barraExperienciaAux) {
  Recursos.barraExperiencia = barraExperienciaAux;
}

/**
 * Gets the menu batalla.
 *
 * @return the menu batalla
 */
public static BufferedImage getMenuBatalla() {
  return menuBatalla;
}

/**
 * Sets the menu batalla.
 *
 * @param menuBatallaAux the new menu batalla
 */
public static void setMenuBatalla(final BufferedImage menuBatallaAux) {
  Recursos.menuBatalla = menuBatallaAux;
}

/**
 * Gets the menu batalla deshabilitado.
 *
 * @return the menu batalla deshabilitado
 */
public static BufferedImage getMenuBatallaDeshabilitado() {
  return menuBatallaDeshabilitado;
}

/**
 * Sets the menu batalla deshabilitado.
 *
 * @param menuBatallaDeshabilitadoAux the new menu batalla deshabilitado
 */
public static void setMenuBatallaDeshabilitado(
final BufferedImage menuBatallaDeshabilitadoAux) {
  Recursos.menuBatallaDeshabilitado = menuBatallaDeshabilitadoAux;
}

/**
 * Gets the habilidades.
 *
 * @return the habilidades
 */
public static Map<String, BufferedImage> getHabilidades() {
  return habilidades;
}

/**
 * Sets the habilidades.
 *
 * @param habilidadesAux the habilidades aux
 */
public static void setHabilidades(
final Map<String, BufferedImage> habilidadesAux) {
  Recursos.habilidades = habilidadesAux;
}

/**
 * Gets the menu enemigo.
 *
 * @return the menu enemigo
 */
public static BufferedImage getMenuEnemigo() {
  return menuEnemigo;
}

/**
 * Sets the menu enemigo.
 *
 * @param menuEnemigoAux the new menu enemigo
 */
public static void setMenuEnemigo(final BufferedImage menuEnemigoAux) {
  Recursos.menuEnemigo = menuEnemigoAux;
}

/**
 * Gets the boton menu.
 *
 * @return the boton menu
 */
public static BufferedImage getBotonMenu() {
  return botonMenu;
}

/**
 * Sets the boton menu.
 *
 * @param botonMenuAux the new boton menu
 */
public static void setBotonMenu(final BufferedImage botonMenuAux) {
  Recursos.botonMenu = botonMenuAux;
}

/**
 * Gets the no item.
 *
 * @return the no item
 */
public static BufferedImage getNoItem() {
  return noItem;
}

/**
 * Sets the no item.
 *
 * @param noItemAux the new no item
 */
public static void setNoItem(final BufferedImage noItemAux) {
  Recursos.noItem = noItemAux;
}

}
