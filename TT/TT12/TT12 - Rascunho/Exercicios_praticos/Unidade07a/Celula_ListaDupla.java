/**
 * Celula Dupla (lista dupla dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula_ListaDupla {
	public int elemento;
	public Celula_ListaDupla ant;
	public Celula_ListaDupla prox;

	/**
	 * Construtor da classe.
	 */
	public Celula_ListaDupla() {
		this(0);
	}


	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula_ListaDupla(int elemento) {
		this.elemento = elemento;
		this.ant = this.prox = null;
	}
}
