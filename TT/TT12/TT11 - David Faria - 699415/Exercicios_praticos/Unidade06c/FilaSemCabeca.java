public class FilaSemCabeca {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma fila sem elementos (sem no cabeca).
	 */
	public FilaSemCabeca() {
		primeiro = new Celula();
		ultimo = primeiro;
	} // end FilaSemCabeca()

	/**
	 * Insere elemento na fila (politica FIFO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
        ultimo.elemento = x;
		ultimo.prox = new Celula();
		ultimo = ultimo.prox;
	} // end inserir()

	/**
	 * Remove elemento da fila (politica FIFO).
	 * @return Elemento removido.
	 * @trhows Exception Se a fila nao tiver elementos.
	 */
	public int remover() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover!");
		} // end if
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    } // end remover()

    /**
	 * Mostra os elementos separados por espacos.
	 */
    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro; i.prox != null; i = i.prox){
            System.out.print(i.elemento + " ");
        } // end for
        System.out.print("]\n");
    } // end mostrar_v2()
} // end class FilaSemCabeca