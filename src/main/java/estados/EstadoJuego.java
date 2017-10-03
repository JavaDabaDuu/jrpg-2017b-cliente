package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;
import mensajeria.PaqueteNPC;

public class EstadoJuego extends Estado {

	private Entidad entidadPersonaje;
	private PaquetePersonaje paquetePersonaje;
	private PaqueteNPC paqueteNPC;
	private Mundo mundo;
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<Integer, PaquetePersonaje> personajesConectados;
	private Map<Integer, PaqueteNPC> npcs;
	private Map<Integer, PaqueteMovimiento> ubicacionNpcs;
	private boolean haySolicitud;
	private int tipoSolicitud;

	private final Gson gson = new Gson();

	private BufferedImage miniaturaPersonaje;

	MenuInfoPersonaje menuEnemigo;

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt", "recursos/" + getMundo() + ".txt");
		paquetePersonaje = juego.getPersonaje();
		entidadPersonaje = new Entidad(juego, mundo, 64, 64, juego.getPersonaje().getNombre(), 0, 0,
				Recursos.personaje.get(juego.getPersonaje().getRaza()), 150);
		miniaturaPersonaje = Recursos.personaje.get(paquetePersonaje.getRaza()).get(5)[0];

		try {
			// Le envio al servidor que me conecte al mapa y mi posicion
			juego.getPersonaje().setComando(Comando.CONEXION);
			juego.getPersonaje().setEstado(Estado.estadoJuego);
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
			juego.getCliente().getSalida()
					.writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor al ingresar al mundo");
		}
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		entidadPersonaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		entidadPersonaje.graficar(g);
		graficarPersonajes(g);
		graficarNpc(g);
		mundo.graficarObstaculos(g);
		entidadPersonaje.graficarNombre(g);
		g.drawImage(Recursos.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
		EstadoDePersonaje.dibujarEstadoDePersonaje(g, 5, 5, paquetePersonaje, miniaturaPersonaje);
		g.drawImage(Recursos.mochila, 738, 545, 59, 52, null);
		g.drawImage(Recursos.menu, 3, 562, 102, 35, null);
		g.drawImage(Recursos.chat, 3, 524, 102, 35, null);
		if (haySolicitud)
			menuEnemigo.graficar(g, tipoSolicitud);

	}

	private void graficarNpc(Graphics g) {
		Integer i = 0;

		PaqueteNPC minotauro0 = new PaqueteNPC(0, "Minotauro0", "Minotauro", 5, -1, 97, 559);
		PaqueteMovimiento posicion0 = new PaqueteMovimiento(0, minotauro0.getPosX(), minotauro0.getPosY()); //
		PaqueteNPC minotauro1 = new PaqueteNPC(1, "Minotauro1", "Minotauro", 6, -1, -609, 1359);
		PaqueteMovimiento posicion1 = new PaqueteMovimiento(1, minotauro1.getPosX(), minotauro1.getPosY()); //
		PaqueteNPC minotauro2 = new PaqueteNPC(2, "Minotauro2", "Minotauro", 4, -1, -1055, 1631);
		PaqueteMovimiento posicion2 = new PaqueteMovimiento(2, minotauro2.getPosX(), minotauro2.getPosY()); //
		PaqueteNPC minotauro3 = new PaqueteNPC(3, "Minotauro3", "Minotauro", 7, -1, -1311, 1391);
		PaqueteMovimiento posicion3 = new PaqueteMovimiento(3, minotauro3.getPosX(), minotauro3.getPosY());
		PaqueteNPC minotauro4 = new PaqueteNPC(4, "Minotauro4", "Minotauro", 4, -1, -1601, 832);
		PaqueteMovimiento posicion4 = new PaqueteMovimiento(4, minotauro4.getPosX(), minotauro4.getPosY());
		PaqueteNPC minotauro5 = new PaqueteNPC(5, "Minotauro5", "Minotauro", 5, -1, -2079, 1167);
		PaqueteMovimiento posicion5 = new PaqueteMovimiento(5, minotauro5.getPosX(), minotauro5.getPosY());
		PaqueteNPC minotauro6 = new PaqueteNPC(6, "Minotauro6", "Minotauro", 4, -1, 1, 1791);
		PaqueteMovimiento posicion6 = new PaqueteMovimiento(6, minotauro6.getPosX(), minotauro6.getPosY());
		PaqueteNPC minotauro7 = new PaqueteNPC(7, "Minotauro7", "Minotauro", 6, -1, 800, 1041);
		PaqueteMovimiento posicion7 = new PaqueteMovimiento(7, minotauro7.getPosX(), minotauro7.getPosY());
		PaqueteNPC minotauro8 = new PaqueteNPC(8, "Minotauro8", "Minotauro", 5, -1, -545, 719);
		PaqueteMovimiento posicion8 = new PaqueteMovimiento(8, minotauro8.getPosX(), minotauro8.getPosY());
		PaqueteNPC minotauro9 = new PaqueteNPC(9, "Minotauro9", "Minotauro", 8, -1, -959, 1343); // POWER
																									// OVERWHELMING
		PaqueteMovimiento posicion9 = new PaqueteMovimiento(9, minotauro9.getPosX(), minotauro9.getPosY());

		PaqueteNPC minotauroTest = new PaqueteNPC(10, "MinotauroTest", "Minotauro", 2, -1, 400, 300);
		PaqueteMovimiento posicionTest = new PaqueteMovimiento(10, minotauroTest.getPosX(), minotauroTest.getPosY());

		Map<Integer, PaqueteNPC> npcs = new HashMap<Integer, PaqueteNPC>();
		Map<Integer, PaqueteMovimiento> ubicacionNpcs = new HashMap<Integer, PaqueteMovimiento>();

		npcs.put(i, minotauro0);
		ubicacionNpcs.put(i, posicion0);
		npcs.put(++i, minotauro1);
		ubicacionNpcs.put(i, posicion1);
		npcs.put(++i, minotauro2);
		ubicacionNpcs.put(i, posicion2);
		npcs.put(++i, minotauro3);
		ubicacionNpcs.put(i, posicion3);
		npcs.put(++i, minotauro4);
		ubicacionNpcs.put(i, posicion4);
		npcs.put(++i, minotauro5);
		ubicacionNpcs.put(i, posicion5);
		npcs.put(++i, minotauro6);
		ubicacionNpcs.put(i, posicion6);
		npcs.put(++i, minotauro7);
		ubicacionNpcs.put(i, posicion7);
		npcs.put(++i, minotauro8);
		ubicacionNpcs.put(i, posicion8);
		npcs.put(++i, minotauro9);
		ubicacionNpcs.put(i, posicion9);

		// A este hay que sacarlo despues, es para probar las batallas
		npcs.put(++i, minotauroTest);
		ubicacionNpcs.put(i, posicionTest);

		// juego.setNpcs(npcs);
		juego.setUbicacionNpcs(ubicacionNpcs);

		// npcs = juego.getNpcs();
		ubicacionNpcs = juego.getUbicacionNpcs();

		Iterator<Integer> itNpcs = npcs.keySet().iterator();
		int key;
		PaqueteMovimiento actual;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		while (itNpcs.hasNext()) {
			key = itNpcs.next();
			actual = ubicacionNpcs.get(key);
			Pantalla.centerString(g,
					new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32),
							(int) (actual.getPosY() - juego.getCamara().getyOffset() - 20), 0, 10),
					npcs.get(actual.getIdPersonaje()).getNombre());
			g.drawImage(
					Recursos.npcsMap.get(npcs.get(actual.getIdPersonaje()).getTipo()).get(actual.getDireccion())[actual
							.getFrame()],
					(int) (actual.getPosX() - juego.getCamara().getxOffset()),
					(int) (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
		}
		// g.drawImage(Recursos.megaCharizard.get(actual.getDireccion())[actual.getFrame()],
		// (int) (actual.getPosX() - juego.getCamara().getxOffset() ), (int)
		// (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
		// g.drawImage(Recursos.alien.get(actual.getDireccion())[actual.getFrame()],
		// (int) (actual.getPosX() - juego.getCamara().getxOffset() ), (int)
		// (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);

	}

	public void graficarPersonajes(Graphics g) {

		if (juego.getPersonajesConectados() != null) {
			personajesConectados = new HashMap(juego.getPersonajesConectados());
			ubicacionPersonajes = new HashMap(juego.getUbicacionPersonajes());
			Iterator<Integer> it = personajesConectados.keySet().iterator();
			int key;
			PaqueteMovimiento actual;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
			while (it.hasNext()) {
				key = it.next();
				actual = ubicacionPersonajes.get(key);
				if (actual != null && actual.getIdPersonaje() != juego.getPersonaje().getId()
						&& personajesConectados.get(actual.getIdPersonaje()).getEstado() == Estado.estadoJuego) {

					Pantalla.centerString(g,
							new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32),
									(int) (actual.getPosY() - juego.getCamara().getyOffset() - 20), 0, 10),
							personajesConectados.get(actual.getIdPersonaje()).getNombre());
					g.drawImage(
							Recursos.personaje.get(personajesConectados.get(actual.getIdPersonaje()).getRaza())
									.get(actual.getDireccion())[actual.getFrame()],
							(int) (actual.getPosX() - juego.getCamara().getxOffset()),
							(int) (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
				}
			}
		}
	}

	public Entidad getPersonaje() {
		return entidadPersonaje;
	}

	private String getMundo() {
		int mundo = juego.getPersonaje().getMapa();

		if (mundo == 1) {
			return "Aubenor";
		} else if (mundo == 2) {
			return "Aris";
		} else if (mundo == 3) {
			return "Eodrim";
		}

		return null;
	}

	public void setHaySolicitud(boolean b, PaquetePersonaje enemigo, int tipoSolicitud) {
		haySolicitud = b;
		// menu que mostrara al enemigo
		menuEnemigo = new MenuInfoPersonaje(300, 50, enemigo);
		this.tipoSolicitud = tipoSolicitud;
	}

	public boolean getHaySolicitud() {
		return haySolicitud;
	}

	public void actualizarPersonaje() {
		paquetePersonaje = juego.getPersonaje();
	}

	public MenuInfoPersonaje getMenuEnemigo() {
		return menuEnemigo;
	}

	public int getTipoSolicitud() {
		return tipoSolicitud;
	}

	@Override
	public boolean esEstadoDeJuego() {
		return true;
	}

}