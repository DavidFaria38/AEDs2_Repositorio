// TP01Q12.c
// isPalindromo recursivo

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
bool isPalindromo(char* str, int i, int j){
    bool resp = true;
    if(i < j){
        if(str[i] == str[j])
            resp = isPalindromo(str, i+1, j-1);
        else
            resp = false;        
    } // end if() -> parada recursiva
    return resp;
} // end is palindromo

/**
 * - Funcao para pegar novas entradas e chamar funcao para verificar se entrada é palindromo
 */
void getLines(){
    int entradaLen = 500;
    char* entrada = (char*)malloc(entradaLen * sizeof(char));
    scanf("%[^\n]*c", entrada);
    getchar();
    if(!isFIM(entrada)){
        (isPalindromo(entrada, 0, strlen(entrada) - 1)) ? printf("SIM\n") : printf("NAO\n");
        getLines();
    } // end if() 
} // end getLines()

int main(){
    getLines();
    return 0;    
} // end main()
