#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct noAB{
	int num;
	struct noAB *direita;
	struct noAB *esquerda;
} noArvoreBinaria;

void paranaue(noArvoreBinaria *no, int qtnNo)
{

	noArvoreBinaria *basta;
	int i = 0;
	int j = 1;
	bool flag = false;

	basta = (noArvoreBinaria *)malloc(qtnNo * sizeof(noArvoreBinaria));
	basta[0] = *no;

	while (j > i)
	{
		*no = basta[i++];
		if (!flag){
			printf("%u", no->num), flag = true;
		} else{
			printf(" %u", no->num);
		} // end e;se

		if (no->esquerda)
			basta[j++] = *no->esquerda;

		if (no->direita)
			basta[j++] = *no->direita;
	}
	free(basta);
} // end paranaue()

noArvoreBinaria *push(noArvoreBinaria *no, int num){
	if (no == false){
		no = (noArvoreBinaria *)malloc(sizeof(noArvoreBinaria));
		no->num = num;
		no->esquerda = no->direita = NULL;
	} else if (no->num > num){
		no->esquerda = push(no->esquerda, num);
	} else { 
		no->direita = push(no->direita, num);
	} // end else
	return no;
} // end push()

void main(void){

	int i, num, qtsNum, quantidadeCaso, caso, qtnNo;

	scanf("%u", &quantidadeCaso);

	caso = 0;
	while (quantidadeCaso--){

		scanf("%u", &qtsNum);

		qtnNo = 0;
		noArvoreBinaria *no = NULL;
		for (i = 0; i < qtsNum; ++i){
			scanf("%u", &num);
			no = push(no, num);
			++qtnNo;
		} // end for

		printf("Case %u:\n", ++caso);

		paranaue(no, qtnNo);
		printf("\n\n");
	} // end whie
} // end main



