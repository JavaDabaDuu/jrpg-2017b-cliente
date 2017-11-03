
package mundo;

import estados.Estado;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Mundo.
 */
public class Mundo {

  /** The juego. */
  private Juego juego;

  /** The ancho. */
  private int ancho;

  /** The alto. */
  private int alto;

  /** The spawn X. */
  private int spawnX;

  /** The spawn Y. */
  private int spawnY;

  /** The x offset. */
  private int xOffset;

  /** The Constant X_OFFSET. */
  private static final int X_OFFSET = 30;

  /** The y offset. */
  private int yOffset;

  /** The Constant Y_OFFSET. */
  private static final int Y_OFFSET = 60;

  /** The iso. */
  private float[] iso = new float[2];

  /** The tiles. */
  private int[][] tiles;

  /** The tiles inv. */
  private int[][] tilesInv;

  /** The x minimo. */
  private int xMinimo;

  /** The x maximo. */
  private int xMaximo;

  /** The y minimo. */
  private int yMinimo;

  /** The y maximo. */
  private int yMaximo;

  /** The grafo de tiles no solidos. */
  private Grafo grafoDeTilesNoSolidos;

  /** The Constant MAPA1. */
  private static final int MAPA1 = 1;

  /** The Constant MAPA2. */
  private static final int MAPA2 = 2;

  /** The Constant MAPA3. */
  private static final int MAPA3 = 3;

  /** The Constant YOFFSET_MAPA. */
  private static final int YOFFSET_MAPA = 32;

  /** The Constant WIDTH_MAPA. */
  private static final int WIDTH_MAPA = 64;

  /** The Constant HEIGHT_MAPA. */
  private static final int HEIGHT_MAPA = 64;

  /** The Constant INDICE3. */
  private static final int INDICE3 = 3;

  /** The Constant CUATRO. */
  private static final int CUATRO = 4;

  /**
   * Instantiates a new mundo.
   *
   * @param juegoAux the juego
   * @param pathMap the path map
   * @param pathObstac the path obstac
   */
  public Mundo(final Juego juegoAux, final String pathMap,
  final String pathObstac) {
    this.juego = juegoAux;
    cargarMundo(pathMap, pathObstac);
    mundoAGrafo();
  }

  /**
   * Actualizar.
   */
  public void actualizar() {
  }

  /**
   * Graficar.
   *
   * @param g the g
   */
  public void graficar(final Graphics g) {
    xOffset = juego.getEstadoJuego().getPersonaje().getxOffset();
    yOffset = juego.getEstadoJuego().getPersonaje().getYOffset();

    xMinimo = (int) (juego.getCamara().getxOffset() - xOffset - X_OFFSET);
    xMaximo = xMinimo + juego.getAncho() + xOffset + X_OFFSET;
    yMinimo = (int) juego.getCamara().getyOffset() + yOffset - Y_OFFSET;
    yMaximo = yMinimo + juego.getAlto() + yOffset + Y_OFFSET;

    // Grafico el el tile base
    for (int i = 0; i < alto; i++) {
      for (int j = 0; j < ancho; j++) {
        iso = dosDaIso(j, i);
        if ((iso[0] >= xMinimo && iso[0] <= xMaximo)
        && (iso[1] >= yMinimo && iso[1] <= yMaximo)) {
          int map = juego.getPersonaje().getMapa();
          if (map == MAPA1) {
            Tile.getAubenor()[Tile.getAubenorBase()].graficar(g, (int) (iso[0]
                - juego.getCamara().getxOffset()),
                (int) (iso[1] - juego.getCamara().getyOffset() - YOFFSET_MAPA),
                WIDTH_MAPA, HEIGHT_MAPA);
          } else if (map == MAPA2) {
            Tile.getAris()[Tile.getArisBase()].graficar(g, (int) (iso[0]
                - juego.getCamara().getxOffset()),
                (int) (iso[1] - juego.getCamara().getyOffset() - YOFFSET_MAPA),
                WIDTH_MAPA, HEIGHT_MAPA);
          } else if (map == MAPA3) {
            Tile.getAubenor()[Tile.getAubenorBase()].graficar(g, (int) (iso[0]
                - juego.getCamara().getxOffset()),
                (int) (iso[1] - juego.getCamara().getyOffset() - YOFFSET_MAPA),
                WIDTH_MAPA, HEIGHT_MAPA);
          }
          if (!getTile(j, i).esSolido()) {
            getTile(j, i).graficar(g, (int) (iso[0]
                - juego.getCamara().getxOffset()),
                (int) (iso[1] - juego.getCamara().getyOffset() - YOFFSET_MAPA),
                WIDTH_MAPA, HEIGHT_MAPA);
          }
        }
      }
    }
  }

  /**
   * Graficar obstaculos.
   *
   * @param g the g
   */
  public void graficarObstaculos(final Graphics g) {
    Tile obst;
    for (int i = 0; i < alto; i++) {
      for (int j = 0; j < ancho; j++) {
        iso = dosDaIso(j, i);

        // Grafico al personaje
        if (Estado.getEstado() == juego.getEstadoJuego()) {
          if (Mundo.mouseATile(juego.getUbicacionPersonaje().getPosX(),
              juego.getUbicacionPersonaje().getPosY())[0] == j
                  && Mundo.mouseATile(juego.getUbicacionPersonaje().getPosX(),
                      juego.getUbicacionPersonaje().getPosY())[1] == i) {
            juego.getEstadoJuego().getPersonaje().graficar(g);
          }
        }

        // Grafico los obstaculos
        if ((iso[0] >= xMinimo && iso[0] <= xMaximo)
        && (iso[1] >= yMinimo && iso[1] <= yMaximo)
        && getTile(j, i).esSolido()) {
          obst = getTile(j, i);
          obst.graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
              (int) (iso[1] - juego.getCamara().getyOffset()
               - obst.getAlto() / 2),
               obst.getAncho(), obst.getAlto());
        }
      }
    }
  }

  /**
   * Gets the tile.
   *
   * @param x the x
   * @param y the y
   * @return the tile
   */
  public Tile getTile(final int x, final int y) {
    Tile t = Tile.getTiles()[tiles[x][y]];
    if (t == null) {
      int map = juego.getPersonaje().getMapa();
      if (map == MAPA1) {
        return Tile.getAubenor()[Tile.getAubenorBase()];
      } else if (map == MAPA2) {
        return Tile.getAris()[Tile.getArisBase()];
      } else if (map == MAPA3) {
        return Tile.getAubenor()[Tile.getAubenorBase()];
      }
    }
    return t;
  }

  /**
   * Cargar mundo.
   *
   * @param pathMapa the path mapa
   * @param pathObstaculos the path obstaculos
   */
  private void cargarMundo(final String pathMapa, final String pathObstaculos) {
    String archivo = Utilitarias.archivoAString(pathMapa);
    String[] tokens = archivo.split("\\s+");
    ancho = Utilitarias.parseInt(tokens[0]);
    alto = Utilitarias.parseInt(tokens[1]);
    spawnX = Utilitarias.parseInt(tokens[2]);
    spawnY = Utilitarias.parseInt(tokens[INDICE3]);

    tiles = new int[ancho][alto];
    tilesInv = new int[alto][ancho];

    for (int y = 0; y < alto; y++) {
      for (int x = 0; x < ancho; x++) {

        tiles[x][y] = Utilitarias.parseInt(tokens[(x + y * ancho + CUATRO)]);
        tilesInv[y][x] = tiles[x][y];
      }
    }
  }

  /**
   * Mundo A grafo.
   */
  private void mundoAGrafo() {

    // Creo una matriz de nodos
    Nodo[][] nodos = new Nodo[ancho][alto];
    int indice = 0;

    // Lleno la matriz con los nodos
    for (int y = 0; y < alto; y++) {
      for (int x = 0; x < ancho; x++) {
        nodos[y][x] = new Nodo(indice++, x, y);
      }
    }
    // Variables finales
    int xFinal = ancho;
    int yFinal = alto;
    // Uno cada nodo con sus adyacentes
    for (int x = 0; x < yFinal; x++) {
      for (int y = 0; y < xFinal; y++) {
        if (!Tile.getTiles()[tilesInv[x][y]].esSolido()) {
          // Si no es la ultima fila y el tile de abajo es no solido, lo uno
          if (y < yFinal - 1
          && !Tile.getTiles()[tilesInv[x][y + 1]].esSolido()) {
            nodos[x][y].agregarAdyacente(nodos[x][y + 1]);
            nodos[x][y + 1].agregarAdyacente(nodos[x][y]);
          }
          // Si no es la ultima columna
          if (x < xFinal - 1) {
            // Si el de arriba a la derecha no es un tile solido
            // Y ademas el de arriba ni el de la derecha lo son, lo uno
            // Tiene que ser a partir de la segunda fila
            if (y > 0 && !Tile.getTiles()[tilesInv[x + 1][y - 1]].esSolido()
                && !Tile.getTiles()[tilesInv[x + 1][y]].esSolido()
                  && !Tile.getTiles()[tilesInv[x][y - 1]].esSolido()) {
              nodos[x][y].agregarAdyacente(nodos[x + 1][y - 1]);
              nodos[x + 1][y - 1].agregarAdyacente(nodos[x][y]);
            }
            // Si el de la derecha no es un tile solido lo uno
            if (!Tile.getTiles()[tilesInv[x + 1][y]].esSolido()) {
              nodos[x][y].agregarAdyacente(nodos[x + 1][y]);
              nodos[x + 1][y].agregarAdyacente(nodos[x][y]);
            }
            // Si el de abajo a la derecha no es un tile solido
            // Y ademas el de abajo ni el de la derecha lo son, lo uno
            // Debe ser antes de la ultima fila
            if (y < yFinal - 1
            && !Tile.getTiles()[tilesInv[x + 1][y + 1]].esSolido()
                && !Tile.getTiles()[tilesInv[x + 1][y]].esSolido()
                && !Tile.getTiles()[tilesInv[x][y + 1]].esSolido()) {
              nodos[x][y].agregarAdyacente(nodos[x + 1][y + 1]);
              nodos[x + 1][y + 1].agregarAdyacente(nodos[x][y]);
            }
          }
        }
      }
    }
    // Creo un grafo para almacenar solo los tiles no solidos
    grafoDeTilesNoSolidos = new Grafo(ancho * alto);
    indice = 0;
    // Paso la matriz a un array
    for (int i = 0; i < ancho; i++) {
      for (int j = 0; j < alto; j++) {
        grafoDeTilesNoSolidos.agregarNodo(nodos[i][j]);
      }
    }
  }

  /**
   * Obtener grafo de tiles no solidos.
   *
   * @return the grafo
   */
  public Grafo obtenerGrafoDeTilesNoSolidos() {
    return grafoDeTilesNoSolidos;
  }

  /**
   * Obtener ancho.
   *
   * @return the int
   */
  public int obtenerAncho() {
    return ancho;
  }

  /**
   * Obtener alto.
   *
   * @return the int
   */
  public int obtenerAlto() {
    return alto;
  }

  /**
   * Iso A 2 D.
   *
   * @param x the x
   * @param y the y
   * @return the float[]
   */
  public static float[] isoA2D(final float x, final float y) {
    float[] dosD = new float[2];

    dosD[0] = (x / (Tile.ANCHO / 2) + y / (Tile.ALTO / 2)) / 2;
    dosD[1] = (y / (Tile.ALTO / 2) - (x / (Tile.ANCHO / 2))) / 2;

    return dosD;
  }

  /**
   * Dos da iso.
   *
   * @param x the x
   * @param y the y
   * @return the float[]
   */
  public static float[] dosDaIso(final float x, final float y) {
    float[] iso = new float[2];

    iso[0] = (x - y) * (Tile.ANCHO / 2);
    iso[1] = (x + y) * (Tile.ALTO / 2);

    return iso;
   }

  /**
   * Mouse A tile.
   *
   * @param x the x
   * @param y the y
   * @return the int[]
   */
  public static int[] mouseATile(final float x, final float y) {
    int[] tile = new int[2];

    tile[0] = (int) Math.floor((y / Tile.ALTO) + (x / Tile.ANCHO)) + 1;
    tile[1] = (int) Math.floor((-x / Tile.ANCHO) + (y / Tile.ALTO)) + 1;

    return tile;
  }
}
