#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>


/* =========================================================================== */
/* ===================== (Inicio) Definições filaCircular ===================== */
/* =========================================================================== */

typedef struct CelulaCircular {
	Jogador* elemento;
	struct CelulaCircular* prox;
} Celula;

Celula* newCelula(Jogador* player){
	Celula* nova = (Celula*)malloc(sizeof(Celula));
	nova->elemento = player;
	nova->prox = NULL;
	return nova;
} // end newCelula()

Celula* newCelula_empty(){
	Celula* nova = (Celula*)malloc(sizeof(Celula));
	nova->elemento = NULL;
	nova->prox = NULL;
	return nova;
} // end newCelula()

typedef struct FilaCircular {
	Celula* primeiro;
	Celula* ultimo;
	int length;
	int lenMax;
} Fila;

/**
 * Construtor
 * 
 * @param limite 
 * @return fila 
 */
Fila newFila(int lenMax){
	Fila fila;

	fila.primeiro = newCelula_empty();
	fila.ultimo = fila.primeiro;
	fila.ultimo->prox = fila.primeiro; 
	fila.lenMax = lenMax;
	fila.length = 0 ;

	return fila;
} // end fila


/**
 * Funcao que mostra na tela os jogadores na fila
 * 
 * @param fila 
 */
void mostrarFila(Fila* fila){
	int j = 0;
	for(Celula* i = fila->primeiro->prox; i != fila->ultimo->prox; i = i->prox, j++){
		printf("[%i] ", j); 
		imprimir(i->elemento);
	} // end for
} // end mostrarFila()

/**
 * Funcao que mostra na tela a media das alturas do jogadores da fila
 * 
 * @param fila 
 */
void mostrarMediaAltura(Fila* fila){
	double soma = 0;
	int j = 0;
	for(Celula* i = fila->primeiro->prox; i != fila->primeiro; i = i->prox){
		soma += i->elemento->altura;
		j++;
	} // end for
	printf("%.0f\n", soma/j);
} // end mostrarMediaAltura()


/**
 * Funcao que remove um jogador de uma fila, e o retorna.
 * 
 * @param fila 
 * @return Jogador* 
 */
Jogador* remover(Fila* fila){
	Jogador* tmp;
	if(fila->primeiro->prox == fila->ultimo){
		printf("ERRO: fila nao esta populada.\n");
	} else if((fila->length <= 0) && (fila->length >= fila->lenMax)){
		printf("ERRO: Tamanho fila, invalido.\n");
	} else{
		Celula* i = fila->primeiro->prox;
		tmp = i->elemento;
		fila->primeiro->prox = fila->primeiro->prox->prox;
		// fila->ultimo->prox = fila->primeiro;
		fila->length--;

		i = NULL;
		// free(i);
	}// end else

	return tmp;
} // end remover()

/**
 * Funcao que insere um jogador de uma fila.
 * 
 * @param fila 
 * @param player 
 */
void inserir(Fila* fila, Jogador* player){
	if(fila->length >= fila->lenMax){
		remover(fila);
		inserir(fila, player);
	} else{		
		fila->ultimo->prox = newCelula(player);
		fila->ultimo = fila->ultimo->prox;
		fila->ultimo->prox = fila->primeiro;
		fila->length++;

		mostrarMediaAltura(fila); 
	} // end else
} // end inserir()


/* =========================================================================== */
/* ======================= (FIM) Definições filaCircular ====================== */
/* =========================================================================== */


/**
 * - Função recebe String e verifica se ela é igual a "FIM".
 * @param str - String a ser manipulada.
 * @return true ou false, caso str seja igual a "FIM".
 */
bool isFIM(char* str){
	return(strcmp(str, "FIM") == 0);
} // end isFIM()

/**
 * Metodo retorna o codigo de comando de uma string.
 * 
 * @param line 
 * @return int 
 */
int getCodigo(char* line){
	int result = 0;
	char strCodigo[2];
	strCodigo[0] = line[0];

	if(strcmp(strCodigo, "I") == 0){
		result = 1;
	} else if(strcmp(strCodigo, "R") == 0){
		result = 2;
	} // end else if

	// printf("Codigo: (%s) (%i)\n", line, result);

	return result;
} // end getCodigo()

/**
 * Metodo retorna a ID de uma string.
 * 
 * @param codigo 
 * @param line 
 * @return int 
 */
int getIdentidade(int codigo, char* line){
	int result = 0;
	if(codigo == 1){
		char* strLine = (char*)malloc(25 * sizeof(char));
		char* strId;

		strcpy(strLine, line);

		strId = strtok(strLine, " ");
		strId = strtok('\0' , " ");

		result = atoi(strId);

		free(strLine);
	} // end else

	return result;
} // end getIdentidade()


/**
 * Metodo que manipula e efetua as acoes na fila.
 * 
 * @param fila - fila a ser manipulada
 * @param codigo - codigo de comando
 * @param id - id a ser inserido
 * @param posicao - posicao da fila a ser inserida/removida
 */
void manipularFila(Fila* fila, int codigo, int id){
	Jogador* tmp;

	switch (codigo){
	case 1:
		inserir(fila, ler(id));
		break;
	case 2:
		tmp = remover(fila);
		if(tmp != NULL)
			printf("(R) %s\n", tmp->nome);
		tmp = NULL;	
		break;
	
	default:
		break;
	} // end switch
	// free(tmp);
} // end manipularfila()

/**
 * - Função que lê a priemira parte da entrada padrão. 
 * @param fila - fila linear.
 */
void getPrimeiraEntrada(Fila* fila){
	int idInt;
	char* idInputStr = (char*)malloc(8 * sizeof(char));

	scanf("%s", idInputStr);

	while(!isFIM(idInputStr)){
		idInt = atoi(idInputStr);
		
		// printf("%i ", idInt);
		inserir(fila, ler(idInt));

		scanf("%s", idInputStr);
	} // end while

	free(idInputStr);
} // end getPrimeiraEntrada()

/**
 * - Função que lê a segunda parte da entrada padrão. 
 * @param fila - fila linear.
 */
void getSegundaEntrada(Fila* fila){
	int loop, id;
	int codigo = 0;
	char* inputStr = (char*)malloc(25 * sizeof(char));
	/* diagrama de codigos para comando: */ 
	// (I) Inserir = 1
	// (R) Remover = 2 

	getchar();
	scanf("%i", &loop);
	getchar();

	while(loop >= 0){
		fgets(inputStr, 25, stdin);

		codigo = getCodigo(inputStr);
		id = getIdentidade(codigo, inputStr);
		
		// printf("%i ", id);
		manipularFila(fila, codigo, id);

		loop--;
	} // end while

	free(inputStr);
} // end getSegundaEntrada()


int main(void){
	Fila filaCircular = newFila(5);
	Fila *fila = &filaCircular;

	getPrimeiraEntrada(fila);	
	getSegundaEntrada(fila);

	mostrarFila(fila);

	return 0;
} // end main()








