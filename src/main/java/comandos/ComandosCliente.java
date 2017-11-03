package comandos;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class ComandosCliente.
 */
public abstract class ComandosCliente extends Comando {

  /** The cliente. */
  private Cliente cliente;

  /**
   * Sets the cliente.
   *
   * @param clienteAux the new cliente
   */
  public void setCliente(final Cliente clienteAux) {
    this.cliente = clienteAux;
  }

/**
 * Gets the cliente.
 *
 * @return the cliente
 */
public Cliente getCliente() {
  return cliente;
}

}
