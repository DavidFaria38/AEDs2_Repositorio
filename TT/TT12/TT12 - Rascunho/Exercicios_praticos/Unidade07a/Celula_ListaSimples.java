/**
 * Celula_ListaSimples (pilha, lista e fila dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula_ListaSimples{
	public int elemento; // Elemento inserido na celula.
	public Celula_ListaSimples prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula_ListaSimples() {
		this(0);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula_ListaSimples(int elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}
