#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


/* ================= (Inicio) Definições Struct StatusAlgoritmo ================= */
typedef struct StatusOrdenacao{
	char* fileName;
	int comp;
	int mov;
	clock_t start;
	clock_t end;
} StatusOrd;

/**
 * - Funcao para armazenamento das comparacaoes e runtime do algortimo.
 * @param fileName - Nome do arquivo
 */
StatusOrd* newStatusOrd(char* fileName){ 
	StatusOrd* newSO = (StatusOrd*)malloc(sizeof(StatusOrd));

	newSO->fileName = fileName;
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
double makeFile(StatusOrd* status){
	FILE* f = fopen(status->fileName, "w");
	double runTime = (double)(status->end - status->start)/CLOCKS_PER_SEC;
	fprintf(f, "%s\t%lf\t%i", "699415", runTime, status->comp);
	fclose(f);
	return runTime;
} // end makeFile()
/* ================= (FIM) Definições Struct StatusAlgoritmo ================= */



/* ============================================================================= */
/* ===================== (Inicio) Definições Struct player ===================== */
/* ============================================================================= */

typedef struct Player
{
	int id;
	int altura;
	int peso;
	int anoNascimento;
	char *nome;
	char *universidade;
	char *cidadeNascimento;
	char *estadoNascimento;
} Jogador;

/* ================= (Start) Construtores ================= */
Jogador *newJogador()
{
	Jogador *newJ = (Jogador *)malloc(sizeof(Jogador));

	newJ->nome = (char *)malloc(80 * sizeof(char));
	newJ->universidade = (char *)malloc(100 * sizeof(char));
	newJ->cidadeNascimento = (char *)malloc(100 * sizeof(char));
	newJ->estadoNascimento = (char *)malloc(100 * sizeof(char));

	newJ->id = -1;
	newJ->altura = -1;
	newJ->peso = -1;
	newJ->anoNascimento = -1;

	return newJ;
} // end newJogador()

Jogador *newJogadorContent(int id, char *nome, int alt, int peso, char *uni, int anoNasc, char *cidadeNasc, char *estadoNasc)
{
	Jogador *newJ = (Jogador *)malloc(sizeof(Jogador));

	newJ->nome = (char *)malloc(80 * sizeof(char));
	newJ->universidade = (char *)malloc(100 * sizeof(char));
	newJ->cidadeNascimento = (char *)malloc(100 * sizeof(char));
	newJ->estadoNascimento = (char *)malloc(100 * sizeof(char));

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
void imprimir(Jogador *jogador)
{
	// printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
	printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
} // end imprimir()

/**
 * - Função cria nova instacia (clona) um jogador.
 * @param copy - Struct a ser copiada.
 * @return - Nova instacia de copy
 */
Jogador *clone(Jogador *copy)
{
	Jogador *tmp = newJogador();

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
void getVirgulas(char *line, int *indexMarkers)
{
	int i, count = 0;
	for (i = 1; i < strlen(line); i++)
		if (line[i] == ',')
		{
			indexMarkers[count] = i;
			count++;
		} // end if
} // end getVirgulas()

int getIdFromLine(char *line)
{
	int i, count = 0;
	char temp;
	char *valueStr = (char *)malloc(4 * sizeof(char));
	for (i = 0; i < 4; i++)
	{
		if (line[i] != ',')
		{
			valueStr[count] = line[i];
			count++;
		}
		else
			i = 4;
	} // end for
	return atoi(valueStr);
} // end getIdFromLine()
int getAlturaFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[1];
	int maior = indexMarker[2];
	char *valueStr = (char *)malloc(5 * sizeof(char));
	for (i = menor + 1; i < maior; i++)
	{
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getAlturaLine()
int getPesoFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[2];
	int maior = indexMarker[3];
	char *valueStr = (char *)malloc(5 * sizeof(char));
	for (i = menor + 1; i < maior; i++)
	{
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getPesoLine()
int getAnoNascimentoFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[4];
	int maior = indexMarker[5];
	char *valueStr = (char *)malloc(5 * sizeof(char));
	for (i = menor + 1; i < maior; i++)
	{
		valueStr[count] = line[i];
		count++;
	} // end for
	return atoi(valueStr);
} // end getAnoNascimentoLine()
char *getNomeFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[0];
	int maior = indexMarker[1];
	char *valueStr = (char *)malloc(80 * sizeof(char));
	for (i = menor + 1; i < maior; i++)
	{
		//if(line[i] != '*'){  // remove os * da string
		valueStr[count] = line[i];
		count++;
		//} // end if
	} // end for
	return valueStr;
} // end getNomeLine()
char *getUniversidadeFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[3];
	int maior = indexMarker[4];
	char *valueStr = (char *)malloc(100 * sizeof(char));
	if ((menor + 1) != maior)
	{
		for (i = menor + 1; i < maior; i++)
		{
			valueStr[count] = line[i];
			count++;
		} // end for
	}
	else
		strcpy(valueStr, "nao informado");
	return valueStr;
} // end getUniversidadeLine()
char *getCidadeNascimentoFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[5];
	int maior = indexMarker[6];
	char *valueStr = (char *)malloc(100 * sizeof(char));
	if ((menor + 1) != maior)
	{
		for (i = menor + 1; i < maior; i++)
		{
			valueStr[count] = line[i];
			count++;
		} // end for
	}
	else
		strcpy(valueStr, "nao informado");

	return valueStr;
} // end getCidadeNascimentoLine()
char *getEstadoNascimentoFromLine(char *line, int *indexMarker)
{
	int i, count = 0;
	int menor = indexMarker[6];
	int maior = strlen(line);
	char *valueStr = (char *)malloc(100 * sizeof(char));

	for (i = menor + 1; i < maior; i++)
	{
		if (line[i] != '\n' && line[i] != '\r')
		{
			valueStr[count] = line[i];
			count++;
		} // end if
	}	  // end for

	if (strcmp(valueStr, "") == 0)
		strcpy(valueStr, "nao informado");

	return valueStr;
} // end getEstadoNascimentoLine()

/**
 * - Função recebe char* line que transforma linha em valores para Struct.
 * @param line - Linha a ser transformada.
 * @return Struct dos elementos da linha. 
 */
Jogador *makeJogador(char *line)
{
	int *indexMarkers = (int *)malloc(7 * sizeof(int));
	getVirgulas(line, indexMarkers);
	Jogador *j = newJogador();

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
Jogador *ler(int idInput)
{
	char *file = strdup("/tmp/players.csv");
	int len = 300;
	bool idFound = false;
	char *line; // = (char*)malloc(len * sizeof(char));
	FILE *fr = fopen(file, "r");

	Jogador *jogador = newJogador();

	while (!idFound && !feof(fr))
	{
		line = (char *)malloc(len * sizeof(char));

		fgets(line, len, fr);
		if (line != NULL && idInput == getIdFromLine(line))
		{
			idFound = true;
			//	printf("%s", line);
		} // end if
	}	  // end while

	if (idFound == true)
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
/* ======================== (Inicio) Definições Lista ======================== */
/* =========================================================================== */

typedef struct Celula
{
	Jogador* elemento;		 // Elemento inserido na celula.
	struct Celula *prox;     // Aponta a celula prox.
} Celula;

typedef struct Lista
{
	Celula *primeiro;
	Celula *ultimo;
} Lista;

Celula *novaCelula()
{
	Celula *nova = (Celula *)malloc(sizeof(Celula));
	nova->elemento = NULL;
	nova->prox = NULL;
	return nova;
}

Celula *novaCelulaContent(Jogador* elemento)
{
	Celula *nova = (Celula *)malloc(sizeof(Celula));
	nova->elemento = clone(elemento);
	nova->prox = NULL;
	return nova;
}

/**
 * Cria uma lista sem elementos (somente no cabeca).
 */
Lista *newLista()
{
	Lista *lista = (Lista *)malloc(sizeof(Lista));
	lista->primeiro = novaCelula(-1);
	lista->ultimo = lista->primeiro;
}

bool pesquisar_list(Lista* list, char* elemento, StatusOrd* record){
	// printf("========== start Pesquisar_list ==========\n");
	bool result = false;
	Celula* i = list->primeiro;
	if(list->primeiro != list->ultimo){
		for(; (i != list->ultimo) && (result != true); i = i->prox)
		{
			// printf("cmp(%s, %s) = %i\n", i->elemento->nome, elemento, strcmp(i->elemento->nome, elemento));
			if(strcmp(i->elemento->nome, elemento) == 0)
			{
				result = true; 
			} // end if
			record->comp += 1;
		} // end for
	} // end if
	// printf("=========== end Pesquisar_list ===========\n");
	return result;
}

void showLista(Lista* list){
	if(list->primeiro != list->ultimo){
		for(Celula* i = list->primeiro; i != list->ultimo; i = i->prox){
			printf("%s ", i->elemento->nome);
		} // end for
		printf("\n\n");
	} // end if
} // end showLista()

/**
 * Insere um elemento na primeira posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirInicio_lista(Lista* lista, Jogador* x)
{
	Celula *tmp = novaCelula(x);
	tmp->prox = lista->primeiro->prox;
	lista->primeiro->prox = tmp;
	if (lista->primeiro == lista->ultimo)
	{
		lista->ultimo = tmp;
	}
	tmp = NULL;
}

/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim_lista(Lista* lista, Jogador* x)
{
	// lista->ultimo->prox = novaCelula(x);
	// lista->ultimo = lista->ultimo->prox;

	lista->ultimo->elemento = clone(x);
	lista->ultimo->prox = novaCelula();
	lista->ultimo = lista->ultimo->prox;
}

/**
 * Remove um elemento da primeira posicao da lista.
 * @return resp int elemento a ser removido.
 * @throws Exception Se a lista nao contiver elementos.
 */
Jogador* removerInicio_lista(Lista* lista)
{
	Jogador* resp = NULL;
	if (lista->primeiro == lista->ultimo)
	{
		printf("Erro ao remover!\n");
	} else{
		Celula *tmp = lista->primeiro;
		lista->primeiro = lista->primeiro->prox;
		resp = lista->primeiro->elemento;
		tmp->prox = NULL;
		free(tmp);
		tmp = NULL;
	}
	return resp;
}

/**
 * Remove um elemento da ultima posicao da lista.
 * @return resp int elemento a ser removido.
 */
Jogador* removerFim_Lista(Lista* lista)
{
	Jogador* resp = NULL;
	if (lista->primeiro == lista->ultimo)
	{
		printf("Erro ao remover!\n");
	} else{

		// Caminhar ate a penultima celula:
		Celula *i;
		for (i = lista->primeiro; i->prox != lista->ultimo; i = i->prox);

		resp = lista->ultimo->elemento;
		lista->ultimo = i;
		free(lista->ultimo->prox);
		i = lista->ultimo->prox = NULL;
	}
	return resp;
}

/* =========================================================================== */
/* ========================== (FIM) Definições Lista ========================= */
/* =========================================================================== */

/* =========================================================================== */
/* ========================= (INICIO) Definições HASH ======================== */
/* =========================================================================== */

typedef struct HashStruct
{
	Lista **tabela;
	int hashLen;
} Hash;

Hash *newHash(int len)
{
	Hash *tmp = (Hash *)malloc(sizeof(Hash));

	tmp->tabela = (Lista **)malloc(len * sizeof(Lista));
	tmp->hashLen = len;

	for (int i = 0; i < tmp->hashLen; i++)
	{
		tmp->tabela[i] = newLista();
	}

	return tmp;
}

int h(int elemento, int hashLen)
{
	return (elemento % hashLen);
} // end h()

void inserir_hash(Hash *hash, Jogador *elemento)
{
	if (elemento != NULL)
	{
		int pos = h(elemento->altura, hash->hashLen);

		inserirFim_lista(hash->tabela[pos], elemento);
	}	  // end if
} // end inserir()

bool pesquisar_hash(Hash* hash, char* elemento, StatusOrd* record){
	bool result = false;
	for(int i = 0; (i < hash->hashLen) && (result != true); i++)
	{
		// printf("\nantes pesquisar_list(): \ti: %i\n", i);
		if(pesquisar_list(hash->tabela[i], elemento, record) == true)
		{
			// printf("antes pesquisar_list(): \t%s - %s\n\n", hash->tabela[i]->primeiro->elemento->nome, elemento);
			result = true;
			// i = hash->hashLen;
		} // end if
	} // end for

	return result;
} // end pesquisar_hash()

void showHash(Hash* hash){
	for(int i = 0; (i < hash->hashLen); i++)
	{
		printf("Hash[%i]\n", i);
		showLista(hash->tabela[i]);
	} // end for
}

/* =========================================================================== */
/* ========================== (FIM) Definições HASH ========================== */
/* =========================================================================== */

/**
 * - Função recebe String e verifica se ela é igual a "FIM".
 * @param str - String a ser manipulada.
 * @return true ou false, caso str seja igual a "FIM".
 */
bool isFIM(char *str)
{
	return (strcmp(str, "FIM") == 0);
} // end isFIM()

/**
 * - Função que lê a priemira parte da entrada padrão. 
 * @param lista - lista linear.
 */
void getPrimeiraEntrada(Hash* hash)
{
	int idInt;
	char *idInputStr = (char *)malloc(8 * sizeof(char));

	scanf("%s", idInputStr);

	while (!isFIM(idInputStr))
	{
		idInt = atoi(idInputStr);

		inserir_hash(hash, ler(idInt));

		scanf("%s", idInputStr);
	} // end while

	free(idInputStr);
} // end getPrimeiraEntrada()

/**
 * - Função que lê a segunda parte da entrada padrão. 
 * @param lista - lista linear.
 */
void getSegundaEntrada(Hash* hash, StatusOrd* record)
{
	int loop, id, posicao;
	bool search;
	char *inputStr = (char *)malloc(40 * sizeof(char));


	getchar();
	scanf("%[^\n]", inputStr);
	// fgets(inputStr, 40, stdin);

	while (!isFIM(inputStr))
	{
		search = pesquisar_hash(hash, inputStr, record);

		if(search == true){
			printf("%s SIM\n", inputStr);
		} else
		{
			printf("%s NAO\n", inputStr);
		}
		
		getchar();
		scanf("%[^\n]", inputStr);
		// fgets(inputStr, 40, stdin);
		loop--;
	} // end while

	free(inputStr);
} // end getSegundaEntrada()

int main(void)
{
	StatusOrd* record = newStatusOrd("699415_hashIndireta.txt");
	Hash *hash = newHash(21);

	startClock(record);
	getPrimeiraEntrada(hash);
	getSegundaEntrada(hash, record);
	endClock(record);

	// showHash(hash);
	makeFile(record);

	return 0;
} // end main()