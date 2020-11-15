#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>


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
	// printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
	printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
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




/* =========================================================================== */
/* ===================== (Inicio) Definições ListaLinear ===================== */
/* =========================================================================== */

typedef struct ListaLinear {
	Jogador** array;
	int tamanho;
	int limite;
} Lista;

/**
 * Construtor
 * 
 * @param limite 
 * @return Lista 
 */
Lista newLista(int limite){
	Lista lista;

	lista.array = (Jogador**)malloc(limite * sizeof(Jogador));
	lista.tamanho = 0;
	lista.limite = limite;

	for(int i = 0; i < limite; i++)
		lista.array[i] = newJogador();

	return lista;
} // end lista

/**
 * Funcao que insere um jogador de uma lista, no inicio do mesmo.
 * 
 * @param lista 
 * @param player 
 */
void inserirInicio(Lista* lista, Jogador* player){
	if(lista->tamanho >= lista->limite){
		printf("ERRO: lista esta totalmente populada.");
	} else{
		for(int i = lista->tamanho; i > 0; i--){
			lista->array[i] = lista->array[i-1];
		} // end for

		lista->array[0] = clone(player);
		lista->tamanho++;
	} // end else
} // end inserirInicio()
/**
 * Funcao que insere um jogador de uma lista, no final do mesmo.
 * 
 * @param lista 
 * @param player 
 */
void inserirFim(Lista* lista, Jogador* player){
	if(lista->tamanho >= lista->limite){
		printf("ERRO: lista esta totalmente populada.");
	} else{
		lista->array[lista->tamanho] = clone(player);
		lista->tamanho++;
	} // end else
} // end inserirFim()
/**
 * Funcao que insere um jogador de uma lista, na posicao X.
 * 
 * @param lista 
 * @param player 
 * @param posicao 
 */
void inserir(Lista* lista, Jogador* player, int posicao){
	if(lista->tamanho >= lista->limite){
		printf("ERRO: lista esta totalmente populada.");
	} else if(((posicao >= lista->limite) && (posicao < 0)) || (posicao > lista->tamanho)){
		printf("ERRO: posicao na lista invalida.");
	} else{
		for(int i = lista->tamanho; i > posicao; i--){
			lista->array[i] = lista->array[i-1];
		} // end for

		lista->array[posicao] = clone(player);
		lista->tamanho++;
	} //end else
} // end inserir(->

/**
 * Funcao que remove um jogador de uma lista, no inicio da mesma, e o retorna.
 * 
 * @param lista 
 * @return Jogador* 
 */
Jogador* removerInicio(Lista* lista){
	Jogador* removed = NULL;
	if(lista->tamanho <= 0){
		printf("ERRO: Lista nao esta populada.");
	} else{
		removed = lista->array[0];
		for(int i = 0; i < lista->tamanho; i++){
			lista->array[i] = lista->array[i+1];
		} // end for
		lista->tamanho--;
	} // end else

	return removed;
} // end removerInicio()
/**
 * Funcao que remove um jogador de uma lista, no final da mesma, e o retorna.
 * 
 * @param lista 
 * @return Jogador* 
 */
Jogador* removerFim(Lista* lista){
	Jogador* removed = NULL;
	if(lista->tamanho <= 0){
		printf("ERRO: Lista nao esta populada.");
	} else{
		removed = lista->array[lista->tamanho - 1];
		lista->array[lista->tamanho - 1] = NULL;
		lista->tamanho--;
	} // end else

	return removed;
} // end removerFim()
/**
 * Funcao que remove um jogador de uma lista, na posicao X, e o retorna.
 * 
 * @param lista 
 * @param posicao 
 * @return Jogador* 
 */
Jogador* remover(Lista* lista, int posicao){
	Jogador* removed = NULL;
	if((posicao < 0) && (posicao > lista->tamanho)){
		printf("ERRO: posicao na lista invalida.");
	} else{
		removed = lista->array[posicao];
		for(int i = posicao; i < lista->tamanho; i++){
			lista->array[i] = lista->array[i+1];
		} // end for
		lista->tamanho--;
	} // end else

	return removed;
} // end remover()

/**
 * Funcao que mostra na tela os jogadores na lista
 * 
 * @param lista 
 */
void mostrarLista(Lista* lista){
	for(int i = 0; i < lista->tamanho; i++){
		printf("[%i] ", i); 
		imprimir(lista->array[i]);
	} // end for
} // end mostrarLista()

/* =========================================================================== */
/* ======================= (FIM) Definições ListaLinear ====================== */
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
 * - Função que realiza a troca de elementos de dois Struct. 
 * @param player - array de Struc que sera feita a troca.
 * @param menor - index do array player qual sera feita a troca.
 * @param i - index do array player qual sera feita a troca.
 */
void swap(Jogador** player, int menor, int i){
	Jogador* temp = newJogador();

	temp = clone(player[i]);
	player[i] = clone(player[menor]);
	player[menor] = clone(temp);
} // end swap()

/**
 * Metodo retorna o codigo de comando de uma string.
 * 
 * @param line 
 * @return int 
 */
int getCodigo(char* line){
	int result = 0;
	char strCodigo[3];
	strCodigo[0] = line[0];
	strCodigo[1] = line[1];

	if(strcmp(strCodigo, "II") == 0){
		result = 1;
	} else if(strcmp(strCodigo, "IF") == 0){
		result = 2;
	} else if(strcmp(strCodigo, "I*") == 0){
		result = 3;
	} else if(strcmp(strCodigo, "RI") == 0){
		result = 4;
	} else if(strcmp(strCodigo, "RF") == 0){
		result = 5;
	} else if(strcmp(strCodigo, "R*") == 0){
		result = 6;
	} // end else if

	// printf("Codigo: %s - %s (%i)\n", line, strCodigo, result);

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
	if(codigo >= 1 && codigo <= 3){
		char* strLine = (char*)malloc(25 * sizeof(char));
		char* strId;

		strcpy(strLine, line);

		if(codigo != 3){
			strId = strtok(strLine, " ");
			strId = strtok('\0' , " ");

			result = atoi(strId);
		} else{
			strId = strtok(strLine, " ");
			strId = strtok(NULL , " ");
			strId = strtok(NULL , " ");

			result = atoi(strId);
		} // end else

		free(strLine);
	} // end else

	return result;
} // end getIdentidade()

/**
 * Metodo retorna um numero inteiro de uma string
 * 
 * @param codigo 
 * @param line 
 * @return int - posicao
 */
int getPosicao(int codigo, char* line){
	int result = 0;
	
	if(codigo == 3 || codigo == 6){
		char* strLine = (char*)malloc(40 * sizeof(char));
		char* strPosicao;

		strcpy(strLine, line);

		strPosicao = strtok(strLine, " ");
		strPosicao = strtok(NULL , " ");

		result = atoi(strPosicao);
		
	} // end else

	return result;
} // end getIdentidade()

/**
 * Metodo que manipula e efetua as acoes na lista.
 * 
 * @param lista - lista a ser manipulada
 * @param codigo - codigo de comando
 * @param id - id a ser inserido
 * @param posicao - posicao da lista a ser inserida/removida
 */
void manipularLista(Lista* lista, int codigo, int id, int posicao){
	Jogador* tmp = NULL;

	switch (codigo){
	case 1:
		inserirInicio(lista, ler(id));
		break;
	case 2:
		inserirFim(lista, ler(id));
		break;
	case 3:
		inserir(lista, ler(id), posicao);
		break;
	case 4:
		tmp = removerInicio(lista);
		printf("(R) %s\n", tmp->nome);
		tmp = NULL;	
		break;
	case 5:
		tmp = removerFim(lista);
		printf("(R) %s\n", tmp->nome);
		tmp = NULL;	
		break;
	case 6:
		tmp = remover(lista, posicao);
		printf("(R) %s\n", tmp->nome);
		tmp = NULL;	
		break;
	
	default:
		break;
	} // end switch

} // end manipularLista()

/**
 * - Função que lê a priemira parte da entrada padrão. 
 * @param lista - lista linear.
 */
void getPrimeiraEntrada(Lista* lista){
	int idInt;
	char* idInputStr = (char*)malloc(8 * sizeof(char));

	scanf("%s", idInputStr);

	while(!isFIM(idInputStr)){
		idInt = atoi(idInputStr);
		
		inserirFim(lista, ler(idInt));

		// printf("%s\n", lista.array[lista.tamanho - 1]->nome);
		
		scanf("%s", idInputStr);
	} // end while

	free(idInputStr);
} // end getPrimeiraEntrada()

/**
 * - Função que lê a segunda parte da entrada padrão. 
 * @param lista - lista linear.
 */
void getSegundaEntrada(Lista* lista){
	int loop, id, posicao;
	int codigo = 0;
	char* inputStr = (char*)malloc(25 * sizeof(char));
	/* diagrama de codigos para comando: */ 
	// (II) InserirInicio = 1 
	// (IF) InserirFim = 2 
	// (I*) Inserir = 3 
	// (RI) RemoverInicio = 4 
	// (RF) RemoverFim = 5 
	// (R*) Remover = 6 

	scanf("%i", &loop);

	while(loop >= 0){
		// getchar();
		fgets(inputStr, 25, stdin);
		// scanf("%[^\n]", inputStr);
		codigo = getCodigo(inputStr);
		id = getIdentidade(codigo, inputStr);
		posicao = getPosicao(codigo, inputStr);

		manipularLista(lista, codigo, id, posicao);
		
		loop--;
	} // end while

	free(inputStr);
} // end getSegundaEntrada()


int main(void){
	Lista listaLinear = newLista(500);
	Lista *lista = &listaLinear;

	getPrimeiraEntrada(lista);	
	getSegundaEntrada(lista);

	mostrarLista(lista);

	return 0;
} // end main()








