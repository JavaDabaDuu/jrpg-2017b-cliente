package mensajeria;
import java.io.Serializable;
import java.util.ArrayList;
import mensajeria.Paquete;
import mensajeria.PaqueteNPC;

public class PaqueteDeNPCS extends Paquete implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PaqueteNPC> npcs;
	
	public PaqueteDeNPCS(){

	}

	public PaqueteDeNPCS(ArrayList<PaqueteNPC> npcs){
		this.npcs = npcs;
	}

	public ArrayList<PaqueteNPC> getNpcs(){
		return npcs;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
	
}
