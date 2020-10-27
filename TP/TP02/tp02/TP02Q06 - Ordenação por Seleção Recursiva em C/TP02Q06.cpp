#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


/* ================= (Inicio) Definições Struct StatusAlgoritmo ================= */
typedef struct StatusOrdenacao{
	int comp;
	int mov;
	double start;
	double end;
} StatusOrd;

StatusOrd* newStatusOrd(){ 
	StatusOrd* newSO = (StatusOrd*)malloc(sizeof(StatusOrd));

	newSO->comp = 0;
	newSO->mov = 0;

	return newSO;
} // end newStatusOrd()

void startClock(StatusOrd* status){ status->start = time(0);}
void endClock(StatusOrd* status){   status->end = time(0);}

/**
 * - Função que grava em um arquivo o tempo de execução do algoritmo de ordenação, movimentações e comparações.
 * @param status - Struct contendo os dados para serem armazenados.
 * @param fileName - Nome do arquivo.
 */
void recordTime(StatusOrd* status, char* fileName){
	FILE* f = fopen(fileName, "w");
	fprintf(f, "%s\t%lf\t%i\t%i", "699415", (status->end-status->start)/1000, status->mov, status->mov);
	fclose(f);
} // end recordTime()
/* ================= (FIM) Definições Struct StatusAlgoritmo ================= */


/* ===================== (Inicio) Definições Struct player ===================== */
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

/* ================= (Start) Funcoes Get ================= */
int getId(Jogador* jogador)                 {return jogador->id;}
int getAltura(Jogador* jogador)             {return jogador->altura;}
int getPeso(Jogador* jogador)               {return jogador->peso;}
int getAnoNascimento(Jogador* jogador)      {return jogador->anoNascimento;}
char* getNome(Jogador* jogador)             {return jogador->nome;}
char* getUniversidade(Jogador* jogador)     {return jogador->universidade;}
char* getCidadeNascimento(Jogador* jogador) {return jogador->cidadeNascimento;}
char* getEstadoNascimento(Jogador* jogador) {return jogador->estadoNascimento;}
/* ================= (End) Funcoes Get ================= */

/* ================= (Start) Funcoes Set ================= */
void setId(Jogador* jogador,               int value)   {jogador->id = value;}
void setAltura(Jogador* jogador,           int value)   {jogador->altura = value;}
void setPeso(Jogador* jogador,             int value)   {jogador->peso = value;}
void setAnoNascimento(Jogador* jogador,    int value)   {jogador->anoNascimento = value;}
void setNome(Jogador* jogador,             char* value) {strcpy(jogador->nome, value);}
void setUniversidade(Jogador* jogador,     char* value) {strcpy(jogador->universidade, value);}
void setCidadeNascimento(Jogador* jogador, char* value) {strcpy(jogador->cidadeNascimento, value);}
void setEstadoNascimento(Jogador* jogador, char* value) {strcpy(jogador->estadoNascimento, value);}
/* ================= (End) Funcoes Set ================= */

/**
 * - Função recebe Struct e impressa.
 * @param jogador - Struct a ser impressa.
 */
void imprimir(Jogador* jogador){
	printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
} // end imprimir()

/**
 * - Função recebe dois Structs e copia um para o outro.
 * @param copyTo - Struct para ser copiada.
 * @param copy - Struct a ser copiada.
 */
void clone(Jogador* copyTo, Jogador* copy){
	setId(copyTo, getId(copy));
	setAltura(copyTo, getAltura(copy));
	setPeso(copyTo, getPeso(copy));
	setAnoNascimento(copyTo, getAnoNascimento(copy));
	setNome(copyTo, getNome(copy));
	setUniversidade(copyTo, getUniversidade(copy));
	setCidadeNascimento(copyTo, getCidadeNascimento(copy));
	setEstadoNascimento(copyTo, getEstadoNascimento(copy));
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

	setId(				j, getIdFromLine(			   line));
	setAltura(			j, getAlturaFromLine(	       line, indexMarkers));
	setPeso(			j, getPesoFromLine(			   line, indexMarkers));
	setAnoNascimento(   j, getAnoNascimentoFromLine(   line, indexMarkers));
	setNome(            j, getNomeFromLine(			   line, indexMarkers));
	setUniversidade(    j, getUniversidadeFromLine(	   line, indexMarkers));
	setCidadeNascimento(j, getCidadeNascimentoFromLine(line, indexMarkers));
	setEstadoNascimento(j, getEstadoNascimentoFromLine(line, indexMarkers));

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
		clone(jogador, makeJogador(line));
	else
		clone(jogador, ler(idInput - 1));
	
	return jogador;
} // end ler

/* ================= (End) Funcoes Ler ================= */

/* ===================== (FIM) Definições Struct player ===================== */

/**
 * - Função recebe String e verifica se ela é igual a "FIM".
 * @param str - String a ser manipulada.
 * @return true ou false, caso str seja igual a "FIM".
 */
bool isFIM(char* str){
	return(strcmp(str, "FIM") == 0);
} // end isFIM()

/**
 * - Função que lê a priemira parte da entrada padrão e os armazena. 
 * @param player - Array de Struct a ser armazenado.
 * @return - Numero inteiro com a quantidade de entrada lidas.
 */
int getPrimeiraEntrada(Jogador** player){
	int idInt, n = 0;
	char* idInputStr = (char*)malloc(8 * sizeof(char));

	scanf("%s", idInputStr);

	// entrada de "objetos"
	while(!isFIM(idInputStr)){
		idInt = atoi(idInputStr);
		
		player[n] = ler(idInt);
		//imprimir(player[n]);
		n++;
		
		scanf("%s", idInputStr);
	} // end while

	free(idInputStr);
	return n;
} // end getPrimeiraEntrada()

/**
 * - Função que realiza a troca de elementos de dois Struct. 
 * @param player - array de Struc que sera feita a troca.
 * @param menor - index do array player qual sera feita a troca.
 * @param i - index do array player qual sera feita a troca.
 */
void swap(Jogador** player, int menor, int i){
	Jogador* temp = newJogador();

	clone(temp, player[i]);
	clone(player[i], player[menor]);
	clone(player[menor], temp);
} // end swap()

/**
 * - Laco interno de repeticao recursiva.
 * @param player - Array de Struct contendo os dados dos jogadores.
 * @param n - Quantidade de jogadores dentro de player
 * @param i - contador
 * @param menor - menor elemento da iteracao
 * @param status - struct contendo os status do algoritmo.
 */
int selecaoRecursiva_lacoInterno(Jogador** player, int n, int j, int menor, StatusOrd* status){
	int menor2 = menor;
	if(j < n){
		status->comp += 1;
		if(strcmp(player[j]->nome, player[menor]->nome) < 0){
			//printf("%s > %s  (%i)\n\n", player[j]->nome, player[menor]->nome, menor2);
			menor2 = selecaoRecursiva_lacoInterno(player, n, j+1, j, status);
		} else{
			//printf("%s !> %s  (%i)\n\n", player[j]->nome, player[menor]->nome, menor2);
			menor2 = selecaoRecursiva_lacoInterno(player, n, j+1, menor, status);
		} // end else
	} // end if
	return menor2;
} // end selecaoRecursiva_lacoInterno()

/**
 * - Laco externo de repeticao recursiva.
 * @param player - Array de Struct contendo os dados dos jogadores.
 * @param n - Quantidade de jogadores dentro de player
 * @param i - contador
 * @param status - struct contendo os status do algoritmo.
 */
void selecaoRecursiva_lacoExterno(Jogador** player, int n, int i, StatusOrd* status){
	int menor = i;
	if(i < (n-1)){
		menor = selecaoRecursiva_lacoInterno(player, n, i+1, menor, status);

		if(menor != i){
			status->mov += 3;
			swap(player, menor, i);
		} // end if

		selecaoRecursiva_lacoExterno(player, n, i+1, status);
	} // end if
} // end selecaoRecursiva_lacoExterno()


/**
 * - Inicializador de selecao recursiva.
 * @param player - Array de Struct contendo os dados dos jogadores.
 * @param n - Quantidade de jogadores dentro de player
 * @param status - struct contendo os status do algoritmo.
 */
void selecaoRecursiva(Jogador** player, int n, StatusOrd* status){
	selecaoRecursiva_lacoExterno(player, n, 0, status);
} // end selecaoRecursiva()

int main(void){
	int nPlayer;

	StatusOrd *status = newStatusOrd();
	Jogador *player[500];

	nPlayer = getPrimeiraEntrada(player);
	startClock(status);
	selecaoRecursiva(player, nPlayer, status);
	endClock(status);

	for(int i = 0; i < nPlayer; i++)
		imprimir(player[i]);

	recordTime(status, strdup("699415_selecaoRecursiva.txt"));
	return 0;
} // end main()








