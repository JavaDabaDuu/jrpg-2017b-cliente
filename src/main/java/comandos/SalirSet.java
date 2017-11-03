package comandos;

import mensajeria.Comando;

/**
 * The Class SalirSet.
 */
public class SalirSet extends ComandosCliente {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    getCliente().getPaqueteUsuario().setIp(getCliente().getMiIp());
    getCliente().getPaqueteUsuario().setComando(Comando.SALIR);
  }

}
