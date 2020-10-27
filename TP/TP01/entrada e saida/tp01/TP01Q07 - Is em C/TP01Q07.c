// is.c

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/**
 * - Funcao para verificar se string e' igual a FIM
 * @param str - string a ser manipulada
 * @return    - true ou false, caso string seja igual a FIM, ou nao 
 */
bool isFIM(char* str){
    return(strlen(str) >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
} // end isFIM()

/**
 * - Funcao para verificar se caractere e' uma vogal
 * @param c - caractere a ser verificado
 * @return  - true ou false, caso caractere seja vogal, ou nao
 */
bool charIsVogal(char c){
    return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
} // end chaIsVogal()

/**
 * - Funcao para verifica se caractere é uma consoante.
 * @param c - caractere a ser verificado
 * @return  - true ou false, caso caractere seja consoante, ou nao
 */
bool charIsCons(char c){
    return(isalpha(c) && !charIsVogal(c));
} // end charIsCons()


/**
 * - Funcao para verificar se array de caracteres e' composta por vogais.
 * @param str - array de char a ser verificada
 * @return    - true ou false, caso array seja composta por vogais, ou nao
 */
bool isVogal(char* str){
    bool resp = true;
    for(int i = 0; i < strlen(str); i++){
        if(!charIsVogal(str[i])){
            resp = false;
            i = strlen(str);
        } // end if()
    } // end for()
    return resp;
} // end isVogal()

/**
 * - Funcao para verificar se array de char e' composta por consoantes.
 * @param str - array de char a ser verificada
 * @return    - true ou false, caso array seja composta por consoante, ou nao
 */
bool isConsoante(char* str){
    bool resp = true;
    for(int i = 0; i < strlen(str); i++)
        if(!charIsCons(str[i])){
            resp = false;
            i = strlen(str);
        } // end if()
    return resp;
} // end isConsoante()

/**
 * - Funcao para verificar se array de caracteres e' composta por valores inteiros.
 * @param str - array de char a ser verificada
 * @return    - true ou false, caso array seja composta por inteiros, ou nao
 */
bool isInteiro(char* str){
    bool resp = true;
    for(int i = 0; i < strlen(str); i++)
        if(!isdigit(str[i])){
            resp = false;
            i = strlen(str);
        } // end if()
    return resp;
} // end isInteira()

/**
 * - Funcao para verificar se array de caracteres e' composta por valores reais.
 * @param str - array de char a ser verificada
 * @return    - true ou false, caso array seja composta por reais, ou nao
 */
bool isReal(char* str){
    bool resp = true;
    int nPontos = 0;
    for(int i = 0; i < strlen(str); i++)
        if(!isdigit(str[i]))
                if((str[i] == '.' || str[i] == ',') && nPontos < 1)
                    nPontos++;
                else{
                    resp = false;
                    i = strlen(str);
                 }
    return resp;
} // end isReal()

/**
 * - Funcao que pega entradas em formato de string e mostra na tela se essa entrada e' composta somente de vogais, consoantes, valoeres inteiros e valores reais.
 */
void getLines(){
    int sizeofEntrada = 500;
    char* entrada = (char*)malloc(sizeofEntrada * sizeof(char));
    char* vogal     = (char*)malloc(4 * sizeof(char));
    char* consoante = (char*)malloc(4 * sizeof(char));
    char* inteiro   = (char*)malloc(4 * sizeof(char));
    char* real      = (char*)malloc(4 * sizeof(char));    

    scanf("%[^\n]*c", entrada);
    while(!isFIM(entrada)){
        (isVogal(entrada))     ? strcpy(vogal, "SIM")     : strcpy(vogal, "NAO");
        (isConsoante(entrada)) ? strcpy(consoante, "SIM") : strcpy(consoante, "NAO");
        (isInteiro(entrada))   ? strcpy(inteiro, "SIM")   : strcpy(inteiro, "NAO");
        (isReal(entrada))      ? strcpy(real, "SIM")      : strcpy(real, "NAO");
        
        printf("%s %s %s %s\n", vogal, consoante, inteiro, real);
        getchar();
        scanf("%[^\n]*c", entrada);
    } // end while()
} // end getLines()

int main(void){ 
    getLines();    
    return 0;
} // end main()
