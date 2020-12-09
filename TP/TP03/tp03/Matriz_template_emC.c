#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/* ========================================================== */
/* ================= (INICIO) CelulaMatrix ================== */
/* ========================================================== */

typedef struct CelulaMatrix{
    struct CelulaMatrix* dir;
    struct CelulaMatrix* esq;
    struct CelulaMatrix* sup;
    struct CelulaMatrix* inf;
    int elemento;
} Celula;

/**
 * @brief newCelula_WITH_DIRECTION
 * 
 * @param elemento 
 * @param esq 
 * @param dir 
 * @param sup 
 * @param inf 
 * @return Celula 
 */
Celula* newCelula_WD(int elemento, Celula* esq, Celula* dir, Celula* sup, Celula* inf){
    Celula* cell = (Celula*)malloc(sizeof(Celula));
    cell->esq = esq; 
    cell->dir = dir; 
    cell->sup = sup; 
    cell->inf = inf;
    cell->elemento = elemento; 
    return cell;
}

/**
 * @brief newCelula_NO_DIRECTION
 * 
 * @param elemento 
 * @return Celula 
 */
Celula* newCelula_ND(int elemento){
    return newCelula_WD(elemento, NULL, NULL, NULL, NULL);
}
/**
 * @brief newCelula_EMPTY_NO_DIRECTION
 * 
 * @return Celula 
 */
Celula* newCelula_empty_ND(){
    return newCelula_WD(-1, NULL, NULL, NULL, NULL);
}

/* ========================================================== */
/* =================== (FIM) CelulaMatrix =================== */
/* ========================================================== */




/* ========================================================== */
/* ================ (INICIO) MatrixFlexivel ================= */
/* ========================================================== */

Celula* inicio;
int linha, coluna;


/**
 * @brief Popular matrix com elemento invalido.
 * 
 * @param matrix 
 * @param i 
 * @param lin 
 * @param col 
 */
void popularMatrix_lin(Celula* i, int lin, int col){
    if(col < coluna - 1){
        // verifica se exite elemento i.sup - caso true tmp recebe i.sup.dir
        Celula* tmp = ((i->sup != NULL) && (col < (coluna-1))) ? i->sup->dir : NULL;

        // cria nova celula e i.dir aponta para mesma
        i->dir = newCelula_WD(-1, i, NULL, tmp, NULL);
        //caso tmp indiferente de null, faz com que o superior de i.dir o aponte
        tmp = (tmp != NULL) ? tmp->inf = i->dir : NULL;
        popularMatrix_lin(i->dir, lin, col+=1);
    } // end if
} // end popularMatrix()

void popularMatrix(Celula* i, int lin, int col){
    // popula linha x de matrix
    popularMatrix_lin(i, lin, 0);

    if(lin < (linha - 1)){
        i->inf = newCelula_WD(-1, NULL, NULL, i, NULL);
        popularMatrix(i->inf, lin+=1, col);
    } // end if
} // end popularMatrix()

/**
 * @brief - gera uma instacia de matriz
 * 
 * @param lin - linha matriz
 * @param col - colunas matriz
 */
void newMatrix(int lin, int col){
    inicio = newCelula_empty_ND();

    linha  = lin;
    coluna = col;

    popularMatrix(inicio, 0, 0);
} // end newMatrix()


void mostrar_lin(Celula* i, int col){
    if(i != NULL){
        printf("%i ", i->elemento);
        mostrar_lin(i->dir, col+=1);
    } // end if
} // end mostrarMatrix()
void mostrar(Celula* i){
    if(i != NULL){
        mostrar_lin(i, 0);
        printf("\n");
        mostrar(i->inf);
    } // end if
} // end mostrarMatrix()
void mostrarMatrix(){
    mostrar(inicio);
} // end mostrarMatrix()


Celula* getNode(int lin, int col){
    Celula* node = NULL;

    if((lin < 0 && lin >= linha) &&
       (col < 0 && col >= coluna)){
        printf("ERRO: getNode() - Linha ou coluna invalidas\n");
    } else{
        node = inicio;
        for(int i = 0; i < lin; i++, node = node->inf);
        for(int j = 0; j < col; j++, node = node->dir);
    } // end else

    return node;
} // end getNode()

/**
 * @brief - inserir elemento em matriz
 * 
 * @param lin - linha a ser inserido
 * @param col - coluna a ser inserido
 * @param elemento - elemento a ser inserido
 */
void inserir(int lin, int col, int elemento){
    Celula* tmp = getNode(lin, col);
    if(tmp != NULL){
        tmp->elemento = elemento;
        tmp = NULL;
    } // end else
} // end inserir()

/**
 * @brief - remove elemento de matriz.
 * 
 * @param lin - linha a ser removido
 * @param col - coluna a ser removido
 * @return - valor inteiro do elemento removido
 */
int remover(int lin, int col){
    int result = -1;
    Celula* tmp = getNode(lin, col);
    
    if(tmp != NULL){
        result = tmp->elemento;
        tmp->elemento = -1;
        tmp = NULL;
    } // end else
    return result;
} // end remover()

/* ========================================================== */
/* ================== (FIM) MatrixFlexivel ================== */
/* ========================================================== */






int main(void){
    int lin = 3;
    int col = 3;
    int elem = 0;

    newMatrix(lin, col);

    for(int i = 0; i < lin; i++){
        for(int j = 0; j < col; j++, elem++){
            inserir(i, j, elem);
        }
    }
    mostrarMatrix();

    return 0;
} // end main()