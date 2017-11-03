package comandos;

import mensajeria.Comando;

/**
 * The Class InicioSesionSet.
 */
public class InicioSesionSet extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    getCliente().getPaqueteUsuario().setComando(Comando.INICIOSESION);
  }

}
