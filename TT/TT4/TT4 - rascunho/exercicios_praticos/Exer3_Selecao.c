#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void randArray(int* array, int len){
	srand(time(0));
	for(int i = 0; i < len; i++){
		array[i] = (rand() % 1000);
	} // end for
} // end randArray()

void array_crescente(int* array, int len){
	for(int i = 0; i < len; i++){
		array[i] = i;
	} // end for
} // end randArray_crescente()

void array_decrescente(int* array, int len){
	int j = len;
	for(int i = 0; i < len; i++, j--)
		array[i] = j;
} // end array_decrescente()

void selecao(int* array, int len){
	int menor, i, j, temp;
	for(i = 0; i < len - 1; i++){
		menor = i;
		for(j = (i+1); j < len; j++){
			if(array[menor] > array[j])
				menor = j;
		} // end for
		if(menor != i){
			temp = array[i];
			array[i] = array[menor];
			array[menor] = temp;
		} // end if
	} // end for
} // end selecao()

void printArray(int* array, int len){
	printf("\n");
	for(int i = 0; i < len; i++)
		printf("%i ", array[i]);
	printf("\n");
} // end printArray()

void getOption(int option, int* array, int len){
	switch(option){
		case 0:
			randArray(array, len);
			break;
        case 1:
            array_crescente(array, len);
            break;
        case 2:
            array_decrescente(array, len);
            break;
    } // end switch
} // end getOption()

int main(void){
	int i = 0, len;
	int* array;
	double start, end;

	int option;
	scanf("%i", &option);
	while(i != 33){
		scanf("%i", &len);
		array = (int*)malloc(len * sizeof(int));
		
		getOption(option, array, len);	
			
		start = clock();
		selecao(array, len);
		end = clock();			
		
		printf("%.3f\n", (end - start)/CLOCKS_PER_SEC);
		i++;
	} // end while
	return 0;
} // end main()
