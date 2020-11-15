#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


/* ================= (Inicio) Definições Struct StatusAlgoritmo ================= */
typedef struct StatusOrdenacao{
	int comp;
	int mov;
	clock_t start;
	clock_t end;
} StatusOrd;

StatusOrd* newStatusOrd(){ 
	StatusOrd* newSO = (StatusOrd*)malloc(sizeof(StatusOrd));

	newSO->comp = 0;
	newSO->mov = 0;

	return newSO;
} // end newStatusOrd()

void startClock(StatusOrd* status){ status->start = clock();}
void endClock(StatusOrd* status){   status->end = clock();}

/**
 * - Função que grava em um arquivo o tempo de execução do algoritmo de ordenação, movimentações e comparações.
 * @param status - Struct contendo os dados para serem armazenados.
 * @param fileName - Nome do arquivo.
 */
double recordTime(StatusOrd* status, char* fileName){
	FILE* f = fopen(fileName, "w");
	double runTime = (double)(status->end - status->start)/CLOCKS_PER_SEC;
	fprintf(f, "%s\t%lf\t%i\t%i", "699415", runTime, status->comp, status->mov);
	fclose(f);
	return runTime;
} // end recordTime()
/* ================= (FIM) Definições Struct StatusAlgoritmo ================= */

/* ============================================================================= */
/* ===================== (Inicio) Definições Struct player ===================== */
/* ============================================================================= */

typedef struct Player {
	int id;
	int altura;
	int peso;
	int anoNascimento;
	char* nome;
	char* universidade;
	char* cidadeNascimento;
	char* estadoNascimento;
} Jogador; 

/* ================= (Start) Construtores ================= */
Jogador* newJogador(){
	Jogador* newJ = (Jogador*)malloc(sizeof(Jogador));

	newJ->nome             = (char*)malloc(80  * sizeof(char));
	newJ->universidade     = (char*)malloc(100 * sizeof(char));
	newJ->cidadeNascimento = (char*)malloc(100 * sizeof(char));
	newJ->estadoNascimento = (char*)malloc(100 * sizeof(char));

	newJ->id = -1;
	newJ->altura = -1;
	newJ->peso = -1;
	newJ->anoNascimento = -1;

	return newJ;
} // end newJogador()

Jogador* newJogadorContent(int id, char* nome, int alt, int peso, char* uni, int anoNasc, char* cidadeNasc, char* estadoNasc){
	Jogador* newJ = (Jogador*)malloc(sizeof(Jogador));

	newJ->nome             = (char*)malloc(80  * sizeof(char));
	newJ->universidade     = (char*)malloc(100 * sizeof(char));
	newJ->cidadeNascimento = (char*)malloc(100 * sizeof(char));
	newJ->estadoNascimento = (char*)malloc(100 * sizeof(char));

	newJ->id = id;
    newJ->altura = alt;
    newJ->peso = peso;
    newJ->anoNascimento = anoNasc;
    strcpy(newJ->nome, nome);
    strcpy(newJ->universidade, uni);
    strcpy(newJ->cidadeNascimento, cidadeNasc);
    strcpy(newJ->estadoNascimento, estadoNasc);
    return newJ;
} // end newJogadorContent()
/* ================= (End) Construtores ================= */


/**
 * - Função recebe Struct e impressa.
 * @param jogador - Struct a ser impressa.
 */
void imprimir(Jogador* jogador){
	printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
} // end imprimir()

/**
 * - Função cria nova instacia (clona) um jogador.
 * @param copy - Struct a ser copiada.
 * @return - Nova instacia de copy
 */
Jogador* clone(Jogador* copy){
	Jogador* tmp = newJogador();

	tmp->id = copy->id;
	tmp->altura = copy->altura;
	tmp->peso = copy->peso;
	tmp->anoNascimento = copy->anoNascimento;
	strcpy(tmp->nome, copy->nome);
	strcpy(tmp->universidade, copy->universidade);
	strcpy(tmp->cidadeNascimento, copy->cidadeNascimento);
	strcpy(tmp->estadoNascimento, copy->estadoNascimento);

	return tmp;
} // end clone

/* ================= (Start) Funcoes Ler ================= */

/**
 * - Função percorre por linha a procura de marcadores de cada elemento (virgulas).
 * @param line - Linha ser procurada.
 * @param indexMarkers - Array de inteiro com o index de cada marcador.
 */
void getVirgulas(char* line, int* indexMarkers){
	int i, count = 0;
	for(i = 1; i < strlen(line); i++)
		if(line[i] == ','){
			indexMarkers[count] = i;
			count++;
		} // end if
} // end getVirgulas()

int getIdFromLine(char* line){
	int i, count = 0;
	char temp;
	char* valueStr = (char*)malloc(4 * sizeof(char));
	for(i = 0; i < 4; i++){
		if(line[i] != ','){
			valueStr[count] = line[i];
			count++;	
		} else
			i = 4;
	} // end for
	return atoi(valueStr);
} // end getIdFromLine()
int getAlturaFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[1];
	int maior = indexMarker[2];
	char* valueStr = (char*)malloc(5 * sizeof(char));
	for(i = menor + 1; i < maior; i++){
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getAlturaLine()
int getPesoFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[2];
	int maior = indexMarker[3];
	char* valueStr = (char*)malloc(5 * sizeof(char));
	for(i = menor + 1; i < maior; i++){
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getPesoLine()
int getAnoNascimentoFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[4];
	int maior = indexMarker[5];
	char* valueStr = (char*)malloc(5 * sizeof(char));
	for(i = menor + 1; i < maior; i++){
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getAnoNascimentoLine()
char* getNomeFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[0];
	int maior = indexMarker[1];
	char* valueStr = (char*)malloc(80 * sizeof(char));
	for(i = menor + 1; i < maior; i++){
		//if(line[i] != '*'){  // remove os * da string
			valueStr[count] = line[i];
			count++;
		//} // end if
	} // end for
	return valueStr;
} // end getNomeLine()
char* getUniversidadeFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[3];
	int maior = indexMarker[4];
	char* valueStr = (char*)malloc(100 * sizeof(char));
	if((menor + 1) != maior){
		for(i = menor + 1; i < maior; i++){
			valueStr[count] = line[i];
			count++;
		} // end for
	} else
		strcpy(valueStr, "nao informado");
	return valueStr;
} // end getUniversidadeLine()
char* getCidadeNascimentoFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[5];
	int maior = indexMarker[6];
	char* valueStr = (char*)malloc(100 * sizeof(char));
	if((menor + 1) != maior){
		for(i = menor + 1; i < maior; i++){
		    valueStr[count] = line[i];
            count++;
        } // end for
    } else
         strcpy(valueStr, "nao informado");
	
	return valueStr;
} // end getCidadeNascimentoLine()
char* getEstadoNascimentoFromLine(char* line, int* indexMarker){
	int i, count = 0;
	int menor = indexMarker[6];
	int maior = strlen(line); 
	char* valueStr = (char*)malloc(100 * sizeof(char));
	
	for(i = menor + 1; i < maior; i++){
		if(line[i] != '\n' && line[i] != '\r'){	
			valueStr[count] = line[i];
			count++;
		} // end if
	} // end for

	if(strcmp(valueStr, "") == 0)
		strcpy(valueStr, "nao informado");

	return valueStr;
} // end getEstadoNascimentoLine()

/**
 * - Função recebe char* line que transforma linha em valores para Struct.
 * @param line - Linha a ser transformada.
 * @return Struct dos elementos da linha. 
 */
Jogador* makeJogador(char* line){
	int* indexMarkers = (int*)malloc(7*sizeof(int));
	getVirgulas(line, indexMarkers);
	Jogador* j = newJogador();

	j->id = getIdFromLine(line);
	j->altura = getAlturaFromLine(line, indexMarkers);
	j->peso = getPesoFromLine(line, indexMarkers);
	j->anoNascimento = getAnoNascimentoFromLine(line, indexMarkers);
	strcpy(j->nome, getNomeFromLine(line, indexMarkers));
	strcpy(j->universidade, getUniversidadeFromLine(line, indexMarkers));
	strcpy(j->cidadeNascimento, getCidadeNascimentoFromLine(line, indexMarkers));
	strcpy(j->estadoNascimento, getEstadoNascimentoFromLine(line, indexMarkers));

	return j;	
} // end makeJogador()

/**
 * - Função recebe inteiro idInput e percorre arquivo a procura do mesmo.
 * @param idInput - ID do elemento a ser procurado.
 * @return Struct com elementos da id procurado. 
 */
Jogador* ler(int idInput){
	char* file = strdup("/tmp/players.csv");
	int len = 300;
	bool idFound = false;
	char* line; // = (char*)malloc(len * sizeof(char));
	FILE* fr = fopen(file, "r");
	
	Jogador* jogador = newJogador();
	
	while(!idFound && !feof(fr)){
		line = (char*)malloc(len * sizeof(char));
		
		fgets(line, len, fr);	
		if(line != NULL && idInput == getIdFromLine(line)){
			idFound = true;	
		//	printf("%s", line);
		} // end if
	} // end while

	if(idFound == true)
		jogador = clone(makeJogador(line));
	else
		jogador = clone(ler(idInput - 1));
	
	return jogador;
} // end ler

/* ================= (End) Funcoes Ler ================= */


/* ========================================================================== */
/* ===================== (FIM) Definições Struct player ===================== */
/* ========================================================================== */

typedef struct CelulaDupla{
	Jogador* elemento;
	struct CelulaDupla* prox;
	struct CelulaDupla* ant;
} Celula;

Celula* newCelula(Jogador* player){
	Celula* nova = (Celula*)malloc(sizeof(Celula));
	nova->elemento = clone(player);
	nova->prox = nova->ant = NULL;
	return nova;
} // end newCelula()


typedef struct ListaDinamicaDE{
	Celula* primeiro;
	Celula* ultimo;
} Lista;

Lista newLista(){
	Lista nova;
	nova.primeiro = newCelula(newJogador());
	nova.ultimo   = nova.primeiro;
	return nova;
} // end newLista()

/**
 * - Função que realiza a troca de elementos em uma lista dupla.
 * @param celula1 - celula1 troca elemeto com celula2
 * @param celula2 - celula2 troca elemeto com celula1
 */
void swapCelula(Celula* celula1, Celula* celula2){
	Jogador* tmp = clone(celula1->elemento);
	celula1->elemento = clone(celula2->elemento);
	celula2->elemento = clone(tmp);
	tmp = NULL;
	free(tmp);
} // end swap()

/**
 * Funcao que mostra na tela os jogadores na lista
 * @param lista - lista dupla
 */
void mostrarLista(Lista* lista){
	for(Celula* i = lista->primeiro->prox; i != NULL ; i = i->prox){
		imprimir(i->elemento);
	} // end for
} // end mostrarLista()

/**
 * - Funcao que retorna o tamanho (inteiro) de uma lista dupla.
 * 
 * @param lista - lista dupla
 * @return int - tamanho da lista
 */
int tamanho(Lista* lista){
	int tam = 0;
	for(Celula* i = lista->primeiro->prox; i != lista->ultimo; i = i->prox, tam++);
	return tam+1;
} // end tamanho()

/**
 * @brief Get the Celula At Position object
 * 
 * @param lista 
 * @param pos 
 * @return Celula* 
 */
Celula* getCelulaAtPosition(Lista* lista, int pos){
	Celula* result;
	int tam = tamanho(lista);
	// printf("estrou getCelulaAtPosiotion pos: %i  tam: %i\n\n", pos, tam);
	
	if((pos < 0) && (pos > tam)){
		printf("ERRO: Posicao [%i] invalida em lista com tamanho [%i]\n", pos, tam);
	} else if(pos == 0){
		result = lista->primeiro->prox;
	} else if(pos == tam-1){
		result = lista->ultimo;
	} else{
		Celula* i = lista->primeiro->prox;
		for(int j = 0; j < pos; j++, i = i->prox);
		result = i;
		i = NULL;
		free(i);
	} // end else

	return result;
} // end getCelulaAtPosition()

void inserirInicio(Lista* lista, Jogador* player){
	Celula* tmp = newCelula(player);

	tmp->ant = lista->primeiro;
	tmp->prox = lista->primeiro->prox;
	lista->primeiro->prox = tmp;
	if(lista->primeiro == lista->ultimo){
		lista->ultimo = tmp;
	} else{
		tmp->prox->ant = tmp;
	} // end else
	tmp = NULL;
} // end inserirInicio()
void inserirFim(Lista* lista, Jogador* player){
	lista->ultimo->prox = newCelula(player);
	lista->ultimo->prox->ant = lista->ultimo;
	lista->ultimo = lista->ultimo->prox;
} // end inserirFim()
void inserir(Lista* lista, Jogador* player, int posicao){
	int tam = tamanho(lista);
	if((posicao < 0) && (posicao > tam)){
		printf("ERRO: Posicao invalida\n");
	} else if(posicao == 0){
		inserirInicio(lista, player);
	} else if(posicao == tam){
		inserirFim(lista, player);
	} else{
		Celula* tmp = newCelula(player);
		Celula* i = lista->primeiro->prox;
		for(int j = 0; j < posicao; j++, i = i->prox)

		tmp->ant = i;
		tmp->prox = i->prox;
		tmp->ant->prox = tmp->prox->ant = tmp;
		tmp = i = NULL;
	} // end else
} // end inserir()

Jogador* RemoverInicio(Lista* lista){
	Jogador* playerTmp;
	if(lista->primeiro == lista->ultimo){
		printf("ERRO: (RI) Lista nao esta populada\n");
	} else{
		Celula* celTmp = lista->primeiro->prox;
		playerTmp = celTmp->elemento;
		lista->primeiro->prox = celTmp->prox;
		celTmp->prox->ant = celTmp->ant;
		celTmp = celTmp->ant = celTmp->prox = NULL;
	} // end else
	return playerTmp;
} // end RemoverInicio()
Jogador* RemoverFim(Lista* lista){
	Jogador* playerTmp;
	if(lista->primeiro == lista->ultimo){
		printf("ERRO: (RF) Lista nao esta populada\n");
	} else{
		Celula* celTmp = lista->ultimo;
		playerTmp = celTmp->elemento;
		lista->ultimo = celTmp->ant;
		lista->ultimo->prox = celTmp = celTmp->ant = NULL;
	} //end else
	return playerTmp;
} // end RemoverFim()
Jogador* Remover(Lista* lista, int posicao){
	Jogador* playerTmp;
	int tam = tamanho(lista);
	if((posicao < 0) && (posicao > tam)){
		printf("ERRO: (R*) Posicao invalida\n");
	} else if(posicao == 0){
		RemoverInicio(lista);
	} else if(posicao == tam){
		RemoverFim(lista);
	} else{
		Celula* i = lista->primeiro->prox;
		
		for(int j = 0; j < posicao; i = i->prox);

		playerTmp = i->elemento;
		i->prox->ant = i->ant;
		i->ant->prox = i->prox;
		i = i->prox = i->ant = NULL;
	} // end else
	return playerTmp;
} // end Remover()
/* ========================================================================== */
/* ==================== (INICIO) Definições Struct player =================== */
/* ========================================================================== */


/**
 * - Função recebe String e verifica se ela é igual a "FIM".
 * @param str - String a ser manipulada.
 * @return true ou false, caso str seja igual a "FIM".
 */
bool isFIM(char* str){
	return(strcmp(str, "FIM") == 0);
} // end isFIM()

/**
 * - Função que lê a priemira parte da entrada padrão. 
 * @param fila - fila linear.
 */
void getPrimeiraEntrada(Lista* lista){
	int idInt;
	char* idInputStr = (char*)malloc(8 * sizeof(char));

	scanf("%s", idInputStr);

	while(!isFIM(idInputStr)){
		idInt = atoi(idInputStr);
		
		// printf("%i \n", idInt);
		inserirFim(lista, ler(idInt));

		scanf("%s", idInputStr);
	} // end while
	free(idInputStr);
} // end getPrimeiraEntrada()

/**
 * - Função realiza ordenação de players tendo como chave primaria o Estado de nascimento do jogador
 * @param lista - Lista contendo jogadores.
 * @param esq - Limitador do algoritmo
 * @param dir - Limitador do algoritmo
 * @param status - Struct usada para armazenar comparações e movimentações
 */
void quicksortRecursao(Lista* lista, int esq, int dir, StatusOrd *status){
	int i = esq, j = dir;
	char* pivoEstado = strdup(getCelulaAtPosition(lista, ((esq+dir)/2))->elemento->estadoNascimento);
	char* pivoNome = strdup(getCelulaAtPosition(lista, ((esq+dir)/2))->elemento->nome);
	status->mov+=2;

	while(i <= j){
		while((strcmp(getCelulaAtPosition(lista, i)->elemento->estadoNascimento, pivoEstado) < 0 )|| 
			 (strcmp(getCelulaAtPosition(lista, i)->elemento->estadoNascimento, pivoEstado) == 0  && 
			  strcmp(getCelulaAtPosition(lista, i)->elemento->nome, pivoNome) < 0)){
			// printf("i: %i\n", i);
			// printf("Nome: %s\n", getCelulaAtPosition(lista, i)->elemento->nome);
			// printf("%s - %s\n", getCelulaAtPosition(lista, i)->elemento->estadoNascimento, pivoEstado);
			// printf("(%s - %s)\n\n", getCelulaAtPosition(lista, i+1)->elemento->estadoNascimento, pivoEstado);
			status->comp += 3;
			i++;
		}
		while((strcmp(getCelulaAtPosition(lista, j)->elemento->estadoNascimento, pivoEstado) > 0) || 
			 (strcmp(getCelulaAtPosition(lista, j)->elemento->estadoNascimento, pivoEstado) == 0  && 
			  strcmp(getCelulaAtPosition(lista, j)->elemento->nome, pivoNome) > 0)){
			// printf("j: %i\n", j);
			// printf("Nome: %s\n", getCelulaAtPosition(lista, j)->elemento->nome);
			// printf("%s - %s\n", getCelulaAtPosition(lista, j)->elemento->estadoNascimento, pivoEstado);
			// printf("(%s - %s)\n\n", getCelulaAtPosition(lista, j-1)->elemento->estadoNascimento, pivoEstado);
			status->comp += 3;
			j--;
		}

		if(i <= j){
			swapCelula(getCelulaAtPosition(lista, i), getCelulaAtPosition(lista, j));
			// status->mov+=3;
			i++, j--;
		} // end if
	} // end while

	if(esq < j)
		quicksortRecursao(lista, esq, j, status);

	if(i < dir)
		quicksortRecursao(lista, i, dir, status);

} // end quicksortRecursao()

/**
 * - Função realiza ordenação de players tendo como chave primaria o Estado de nascimento do jogador
 * @param lista - lista dupla contendo os jogadores.
 * @param status - Struct usada para armazenar comparações e movimentações
 */
void quicksort(Lista* lista, StatusOrd *status){
	quicksortRecursao(lista, 0, tamanho(lista) - 1, status);
} // end quicksort()

int main(void){
	StatusOrd *status = newStatusOrd();
	Lista listaDupla = newLista();
	Lista* lista = &listaDupla;

	getPrimeiraEntrada(lista);


	startClock(status);
	quicksort(lista, status);
	endClock(status);

	mostrarLista(lista);

	recordTime(status, strdup("699415_quicksort2.txt"));
	return 0;
} // end main()








