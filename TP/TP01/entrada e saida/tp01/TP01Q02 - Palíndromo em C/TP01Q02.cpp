// TP01Q02.c

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * - Funcao para verificar se string e' igual a FIM e retornar true.
 * @param str - string a ser verificada
 * @return    - true ou false, caso str for igual a FIM, ou nao
 */
bool isFIM(char* str){
        return(strlen(str) >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
    } // end isFIM()

/**
 * - Funcao para verificar se string e' parindromo.
 * @param str - string a ser verificada
 * @return    - true ou false, caso str for palindromo ou nao
 */
bool isPalindromo(char* str){
        bool resp = true;
        int i = 0;
        int j = strlen(str) - 1;
        for(;i <= j; i++,j--){
            if(str[i] != str[j]){
                resp = false;
                i = j;
            } // end if()
        } // end for()
        return resp;
    } // end isPalindromo()

/**
 * - Funcao para pegar novas entradas e chamar funcao para verificar se entrada é palindromo
 */
void getLines(){
    int entradaLen = 500;
    char* entrada = (char*)malloc(entradaLen * sizeof(char));
    scanf("%[^\n]*c", entrada);
    while(!isFIM(entrada)){
        if(isPalindromo(entrada))
            printf("SIM\n");
        else
            printf("NAO\n");
	getchar();
        scanf("%[^\n]*c", entrada);
    }
} // end getLines()

int main(){
    getLines();
    return 0;    
} // end main()
