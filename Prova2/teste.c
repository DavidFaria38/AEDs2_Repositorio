#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>


struct NoLista {
    int elemento;
    struct NoLista *proximo;
};

struct NoLista * inserirInicio(struct NoLista *inicio, int num, int *erro){
    struct NoLista *novo;
    *erro = 0;
    novo = (struct NoLista*) malloc(sizeof(struct NoLista));
    if (novo == NULL){
        *erro = 1;
        return inicio;
    } else {
        novo->elemento=num;
        //_____________________________/* (1) */
        return novo;
    }
}

int main(int argc, char const *argv[])
{
    int x = 5, y = 3;
    y = soma(&x, &y);
    printf("soma: %i\n", (x+y));

    return 0;
}
