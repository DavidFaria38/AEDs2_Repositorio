/*Problema!! strlen() le os bytes de um array, palavras com acentos sao contadas como tendo 2 caracteres*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>

/** isFIM() - verifica se string contem "FIM"
 *  @param char *str - array de caracteres
 *  @return          - true, se array contem "FIM"
 *                     false, se array nao contem "FIM"
 */
bool isFIM(char *str){
	return(str[strlen(str)] >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}

/** isPalindromo() - verifica se array de caracteres e' um palindromo
 *  @param char *str - array de caracteres
 *  @param int i     - contador (comeca no index 0 da array)
 *  @param int j     - contador (comeca no index strlen(str))
 *  @return          - true, se for palindromo
 *                     false, se nao for palindromo
 */
bool isPalindromo(char *str, int i, int j){
	bool resp = true;
	if(i < j){
		if(str[i] == str[j]){
			printf("%c(%i) == %c(%i)\n", str[i], i, str[j], j);
			resp = isPalindromo(str, i+1, j-1);
		}else{
			resp = false;
			printf("%c(%i) != %c(%i)\n", str[i], i, str[j], j);
		}
    }
	return resp;
}

/** callIsPalindromo() - chama a funcao recursiva isPalindromo()
 *  @param char *str   - array de caracteres
 *  @return            - resultado de isPalindromo()
 */
bool callIsPalindromo(char *str){
	//printf("%s = %i\n", str, (int)strlen(str));
	bool resp = isPalindromo(str, 0, strlen(str) - 2);
    return resp;
}

/** getLines() - pega nova entrada e chama isPalindromo()
 */
void getLines(){
	char str[1000];
	//fgets(str, 1000, stdin);
  scanf("%[^\n]s", str);
	if(isFIM(str) == false){                         // verifica e sai do loop se str == "FIM"
		//printf("%d \n", callIsPalindromo(str));   
		if(callIsPalindromo(str) == 1)
			printf("SIM\n");
		else
			printf("NAO\n");
		getLines();                              // nova entrada
	}
}
	
int main(void){
	setlocale(LC_ALL, "");
	//printf("Olá Mùndô!!\n");
	getLines();
	//char *str = "omissíssimo";
	//printf("strlen = %d\n", strlen(str));
	//for(int i = 0; i < strlen(str); i++)
//		printf("%c(%i) ", str[i], i);
	return 0;
}
