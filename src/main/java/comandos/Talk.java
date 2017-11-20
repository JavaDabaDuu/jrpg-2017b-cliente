package comandos;

import chat.MiChat;
import chat.VentanaContactos;
import juego.Pantalla;
import mensajeria.PaqueteMensaje;
import mensajeria.PaquetePersonaje;

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

        String mensaje = getJuego().getCliente().getPaqueteMensaje().getMensaje();
		
		if (mensaje.equals("bigdaddy")) {
			
			int nuevaFuerza = getJuego().getPersonajesConectados().get(getJuego().getCliente().
					getPaqueteMensaje().getIdEmisor()).getFuerza()*2;
			
			PaquetePersonaje personajeEmisor = getJuego().getPersonajesConectados().get(getJuego().getCliente(
					).getPaqueteMensaje().getIdEmisor());
		
			personajeEmisor.setFuerza(nuevaFuerza);			
			personajeEmisor.setFuerzaAumentada(personajeEmisor.getFuerzaAumentada()+1);
			
		}else if (mensaje.equals("tinydaddy")) {
					
		  int nuevaFuerza = getJuego().getPersonajesConectados().get(getJuego().getCliente().
		      getPaqueteMensaje().getIdEmisor()).getFuerza()/2;
					
		  PaquetePersonaje personajeEmisor = getJuego().getPersonajesConectados().get(getJuego().getCliente(
		      ).getPaqueteMensaje().getIdEmisor());
				
		  personajeEmisor.setFuerza(nuevaFuerza);			
		  personajeEmisor.setFuerzaAumentada(personajeEmisor.getFuerzaDisminuida()+1);
					
		} else if (mensaje.equals("invisible")) {
							
		    PaquetePersonaje personajeEmisor = getJuego().getPersonajesConectados().get(getJuego().getCliente(
			  ).getPaqueteMensaje().getIdEmisor());
							
			personajeEmisor.setInvisibilidad();
							
		}  else {
					getJuego().getChatsActivos().get(destino).getChat()
							.append(getJuego().getCliente().getPaqueteMensaje().getUserEmisor() + ": "
									+ getJuego().getCliente().getPaqueteMensaje().getMensaje() + "\n");
					getJuego().getChatsActivos().get(destino).getTexto().grabFocus();
		}
		
	}
 }
