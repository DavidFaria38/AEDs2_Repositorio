public class Fila {
	private Celula primeiro;
	private Celula ultimo;

	/**
	 * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
	 */
	public Fila() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

    public int getElemento(){
        return this.primeiro.elemento;
    } // end getElemento
    public Celula getPrimeiroProx(){
        return primeiro.prox;
    } // end getElemento

	/**
	 * Insere elemento na fila (politica FIFO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove elemento da fila (politica FIFO).
	 * @return Elemento removido.
	 * @trhows Exception Se a fila nao tiver elementos.
	 */
	public int remover() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover!");
		}

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
	} // end remover()


	/**
	 * Mostra os elementos separados por espacos.
	 */
    public void mostrar(){
        System.out.print("[ ");
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(" " + i.elemento);
        } // end for
        System.out.print(" ]\n");
    } // end mostrar_v2()


    /**
	 * Mostra o maior elemento.
	 */
    public int getMaior() throws Exception{
        int elemento = -1;
        if(primeiro == ultimo){
            throw new Exception("Erro: primeiro igual ao ultimo");
        } else{
            elemento = primeiro.prox.elemento;
            for(Celula i = primeiro.prox.prox; i != null; i = i.prox){
                if(elemento < i.elemento)
                    elemento = i.elemento;
            } // end for
        } // end else
        return elemento;
    } // end getMaior()
    

    /**
	 * Mostra o terceiro elemento, supondo que o memso existe.
	 */
    public int getThirdElement(){
        return(primeiro.prox.prox.prox.elemento);
    } // end getThirdElement()
    
    
    /**
	 * Retorna a soma dos elemetos da fila.
	 */
    public int getSum(){
        int soma = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            soma += i.elemento;
        } // end for
        return soma;
    } // end getSum()
    
    /**
	 * Inverte a fila.
	 */
    void inverter () {
        Celula fim = ultimo;
        while (primeiro != fim){
            System.out.println("entrou while");
            Celula nova = new Celula (primeiro.prox.elemento);
            nova.prox = fim.prox;
            fim.prox = nova;
            Celula tmp = primeiro.prox;
            primeiro.prox = tmp.prox;
            nova = tmp = tmp.prox = null;
            if (ultimo == fim) 
                ultimo = ultimo.prox;
        } // end while
        fim = null;
    } // end inverter()


    /**
	 * Retorna a quantidade de aparicoes de elementos pares e divisiveis por 5.
	 */
    public int countElements(){
        return countElements(primeiro);
    } // end getSum()

    public int countElements(Celula i){
        int count = 0;
        if(i != null){
            if((i.elemento % 2 == 0) || (i.elemento % 5 == 0)){
                count += countElements(i.prox);
                count++;
            } else{
                count += countElements(i.prox);
            } // end else
        } // end if
        return count;
    } // end countElements()

    /**
     * Retonar nova fila com os valores invertidos de uma pilha
     */
    public Fila fromPilhaInvertida_to_Fila(Celula topo){
        int n = 0, j = 0;
        Fila newFila = new Fila();
        
        for(Celula i = topo; i != null; i = i.prox)
            n++;

        int []tmp = new int[n];
        
        for(Celula i = topo; i != null; i = i.prox, j++){
            tmp[j] = i.elemento;
        } // end for
        
        for(int i = n-1; i >= 0; i--){
            newFila.inserir(tmp[i]);
        } // end for

        tmp = null;
        return newFila;
    } // end fromPilhaInvertida_to_Fila()
} // end class fila