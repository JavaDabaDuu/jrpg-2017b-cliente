package comandos;

import chat.MiChat;
import chat.VentanaContactos;
import juego.Pantalla;
import mensajeria.PaqueteMensaje;

/**
 * The Class Talk.
 */
public class Talk extends ComandosEscucha {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mensajeria.Comando#ejecutar()
	 */
	@Override
	public void ejecutar() {
		MiChat chat = null;
		String destino;
		getJuego().getCliente()
				.setPaqueteMensaje((PaqueteMensaje) getGson().fromJson(getCadenaLeida(), PaqueteMensaje.class));
		if (!(getJuego().getCliente().getPaqueteMensaje().getUserReceptor() == null)) {
			if (!(getJuego().getChatsActivos()
					.containsKey(getJuego().getCliente().getPaqueteMensaje().getUserEmisor()))) {
				chat = new MiChat(getJuego());
				chat.setTitle(getJuego().getCliente().getPaqueteMensaje().getUserEmisor());
				chat.setVisible(true);
				getJuego().getChatsActivos().put(getJuego().getCliente().getPaqueteMensaje().getUserEmisor(), chat);
			}
			destino = getJuego().getCliente().getPaqueteMensaje().getUserEmisor();
		} else {
			// ALL
			if (!getJuego().getChatsActivos().containsKey("Sala")) {
				chat = new MiChat(getJuego());
				chat.setTitle("Sala");
				chat.setVisible(true);
				getJuego().getChatsActivos().put("Sala", chat);
				if (Pantalla.getVentContac() != null) {
					VentanaContactos.getBotonMc().setEnabled(false);
				}
			}
			destino = "Sala";
		}

		if (getJuego().getChatsActivos().get(destino).getChat().getText()
				.equals("bigdaddy") == !getJuego().getCliente().getPaquetePersonaje().getFuerzaAumentada()) {
			getJuego().getCliente().getPaquetePersonaje().aumentarFuerza();
			getJuego().getCliente().getPaquetePersonaje().setFuerzaAumentada(true);
		} else {
			if (getJuego().getChatsActivos().get(destino).getChat().getText()
					.equals("tinydaddy") == !getJuego().getCliente().getPaquetePersonaje().getFuerzaReducida()) {
				getJuego().getCliente().getPaquetePersonaje().reducirFuerza();
				getJuego().getCliente().getPaquetePersonaje().setFuerzaReducida(true);
			} else {
				if (getJuego().getChatsActivos().get(destino).getChat().getText().equals("bigdaddy") == getJuego()
						.getCliente().getPaquetePersonaje().getFuerzaAumentada()) {
					getJuego().getCliente().getPaquetePersonaje().reducirFuerza();
					getJuego().getCliente().getPaquetePersonaje().setFuerzaAumentada(false);
				} else if (getJuego().getChatsActivos().get(destino).getChat().getText()
						.equals("tinydaddy") == getJuego().getCliente().getPaquetePersonaje().getFuerzaReducida()) {
					getJuego().getCliente().getPaquetePersonaje().aumentarFuerza();
					getJuego().getCliente().getPaquetePersonaje().setFuerzaReducida(false);
				} else {
					getJuego().getChatsActivos().get(destino).getChat()
							.append(getJuego().getCliente().getPaqueteMensaje().getUserEmisor() + ": "
									+ getJuego().getCliente().getPaqueteMensaje().getMensaje() + "\n");
					getJuego().getChatsActivos().get(destino).getTexto().grabFocus();
				}
			}
		}
	}
}
