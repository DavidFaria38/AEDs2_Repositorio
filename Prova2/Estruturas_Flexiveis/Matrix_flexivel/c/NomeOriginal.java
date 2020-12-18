import java.time.temporal.TemporalUnit;

class Celula{
	public Celula prox;
	public int elemento;

	Celula(int elemento){
		this.prox = new Celula();
		this.elemento = elemento;
	}

	Celula(){
		this.prox = null;
		this.elemento = -1;
	}
} // end class Celula


class Fila{
    private Celula inicio;
    private Celula fim;

    Fila(){
		inicio = new Celula();
		fim = inicio;
	} // end pilhaLinear()

	public int tamanhoFila(){
		int tamanho = 0;
		for(Celula i = inicio.prox; i != this.fim; i = i.prox, tamanho++);
		return tamanho;
	} // end tamanho

	public void mostrar(Celula i){
		if(i != fim.prox){
			System.out.print(i.elemento + " ");
			mostrar(i.prox);
		}
	}
	public void mostrar(){
		mostrar(inicio.prox);
	}



	public void enfileirar(int x){ // corrigido
		fim.prox = new Celula(x);
		fim = fim.prox;
		System.out.println("Elemento: " + fim.elemento);

	}
	public int desenfileirar(){
		int elemento = -1;
		if(inicio == fim){
			System.out.println("ERRO:");
		} else{
			Celula tmp = new Celula();
			tmp = inicio.prox;
			inicio.prox = inicio.prox.prox;
			elemento = tmp.elemento;
			tmp.prox = null;
			tmp = null;
		}
		return elemento;
	}

	/* questao 9 prova 2 */
    public void inserirPilha(int x){
		enfileirar(x);          // insere elementos normalmente
	} // end inserirPilha()

    public int removerPilha(){
		Fila tmp = new Fila();           // cria-se nova fila tmp
		int tamanhoFila = tamanhoFila(); // retorna o tamanho da fila
		int ultimoFila = -1;             // variavel de retorna da funcao/metodo

		// percorre fila
		// parada acontece 1 elemento antes do fim da fila
		for(int i = 0; i < tamanhoFila-1; i++){ 
			int elementoTmp = desenfileirar();  // remove elemento da fila atual
			tmp.inserirPilha(elementoTmp);		// e o insere em nova fila (tmp)
		}

		ultimoFila = desenfileirar();  // remove ultimo elemento da fila atual

		this.inicio = tmp.inicio;      // fila atual recebe elementos de fila tmp
		this.fim = tmp.fim;

		return ultimoFila;             // retorna elemento da "pilha"
	} // end removerPilha()



// questao 10 prova 2
public void separar(Fila f1, Fila f2) throws Exception{
	if(inicio == fim){               // verifico se fila atual esta populada
		throw new Exception("ERRO"); // if true, retorno um erro
	} 	

	Celula tmpOrigin = this.inicio.prox;   // cria Celula temporaria
	
	while(tmpOrigin != this.fim.prox){     // percorro fila com tmpOrigin ate o final da mesma
		
		// Erro no codigo*
		// ao invez de f1 receber impares recebe ele recebe pares
		// e o mesmo acontece com f2
		if(tmpOrigin.elemento % 2 == 0){ // se elemento de celula tmp igual a par, o copia para f1
			f1.fim.prox = new Celula(tmpOrigin.elemento);
			f1.fim = f1.fim.prox;
		} else{                          // se nao o copia para f2
			f2.fim.prox = new Celula(tmpOrigin.elemento);
			f2.fim = f2.fim.prox;
		}

		tmpOrigin = tmpOrigin.prox;      // anda com celula tmp
	}
} // end separar()


} // end class Fila()


public class NomeOriginal{



	public static void main(String []arg){

		Fila filaOriginal = new Fila();
		Fila f1 = new Fila();
		Fila f2 = new Fila();
		
		filaOriginal.enfileirar(1);
		filaOriginal.enfileirar(2);
		filaOriginal.enfileirar(3);
		filaOriginal.enfileirar(4);
		filaOriginal.enfileirar(5);
		filaOriginal.enfileirar(6);

		filaOriginal.mostrar();
		System.out.println("\n\n");
		try {
			filaOriginal.separar(f1,f2);
			
			f1.mostrar();
			System.out.println("\n\n");
			f2.mostrar();
			System.out.println("\n\n");
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
		}

	} // end main()
}








