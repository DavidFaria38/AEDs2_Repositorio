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
/* ===================== (Inicio) Definições filaCircular ===================== */
/* =========================================================================== */

typedef struct FilaCircular {
	Jogador** array;
	int tamanho;
	int primeiro;
	int ultimo;
} Fila;

/**
 * Construtor
 * 
 * @param limite 
 * @return fila 
 */
Fila newFila(int len){
	Fila fila;

	fila.array = (Jogador**)malloc((len + 1) * sizeof(Jogador));
	fila.primeiro = fila.ultimo = 0;
	fila.tamanho = len + 1;

	// for(int i = 0; i < len; i++)
	// 	fila.array[i] = newJogador();

	return fila;
} // end fila


/**
 * Funcao que mostra na tela os jogadores na fila
 * 
 * @param fila 
 */
void mostrarFila(Fila* fila){
	int j = 0;
	for(int i = fila->primeiro; i != (fila->ultimo % fila->tamanho); i = (i+1) % fila->tamanho){
		printf("[%i] ", j); 
		imprimir(fila->array[i]);

		j++;
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
	for(int i = fila->primeiro; i != (fila->ultimo) % fila->tamanho; i = (i+1) % fila->tamanho){
		soma += fila->array[i]->altura;
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
	Jogador* tmp = NULL;
	if(fila->tamanho <= 0){
		printf("ERRO: fila nao esta populada.");
	} else{
		tmp = fila->array[fila->primeiro];
		fila->primeiro = (fila->primeiro + 1) % fila->tamanho;
	} // end else

	return tmp;
} // end remover()

/**
 * Funcao que insere um jogador de uma fila.
 * 
 * @param fila 
 * @param player 
 */
void inserir(Fila* fila, Jogador* player){
	if(((fila->ultimo + 1) % fila->tamanho) == fila->primeiro){
		remover(fila);
		inserir(fila, player);
	} else{
		fila->array[fila->ultimo] = clone(player);
		fila->ultimo = (fila->ultimo + 1) % fila->tamanho;

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
	Jogador* tmp = NULL;

	switch (codigo){
	case 1:
		inserir(fila, ler(id));
		break;
	case 2:
		tmp = remover(fila);
		printf("(R) %s\n", tmp->nome);
		tmp = NULL;	
		break;
	
	default:
		break;
	} // end switch

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
		
		inserir(fila, ler(idInt));
		// printf("%s\n", fila.array[fila.tamanho - 1]->nome);
		
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

	while(loop >= 0){
		fgets(inputStr, 25, stdin);

		codigo = getCodigo(inputStr);
		id = getIdentidade(codigo, inputStr);

		// printf("antes manipular\n");
		manipularFila(fila, codigo, id);
		// printf("depois manipular\n");
		
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








