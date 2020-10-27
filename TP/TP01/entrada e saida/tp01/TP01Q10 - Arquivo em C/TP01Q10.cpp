
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

/**
  * - Le n numeros reais e os armazena em uma arquivo
  * @param fileName - Nome do aquivo a ser armazenado
  */
void read_and_WriteFile(char* fileName){
	int n, i;
	double temp;
	FILE* writeFile = fopen(fileName, "w");

	scanf("%i", &n);
	for(i = 0; i < n; i++){
		scanf("%lf", &temp);
		fprintf(writeFile, "%0.3lf\n", temp);
	} // end for

	fclose(writeFile);
} // end read_and_WriteFile()


/**
  * - Cria uma copia invertida dos elementos do arquivo orignal.
  * @param originFile_Name - Nome do arquivo a ser feita a copia
  * @param copyFile_Name   - Nome do arquivo que sera a copia
  */
void readInverted(char* originFile_Name){
	char temp;
	double doubleTemp;
	int i = 0;
	bool loop = true;
	FILE* originFile = fopen(originFile_Name, "r");

	fseek(originFile, 0, SEEK_END);
	
	// Inicializa procurando pela ultima instancia de \n no arquivo	
	do{
		i++;
		fseek(originFile, -i, SEEK_END);
        fscanf(originFile, "%c", &temp);       
		//printf("%c | %i\n", temp, i);
    }while(temp != '\n');

	while(loop == true){
		do{
			i++;
			fseek(originFile, -i, SEEK_END);
			fscanf(originFile, "%c", &temp);
		}while(temp != '\n' && ftell(originFile) != 1);
		
		if(ftell(originFile) == 1){
			loop = false;
			fseek(originFile, -i, SEEK_END);
		} // end if
		
		fscanf(originFile, "%lf", &doubleTemp);
		printf("%g\n", doubleTemp);

	} // end while
	
	fclose(originFile);
} // end invertFile()

int main(void){
	char* fileName = "original.txt";
	
	read_and_WriteFile(fileName);
	readInverted(fileName);
		
	return 0;
}
