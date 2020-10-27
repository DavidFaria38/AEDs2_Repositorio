/*
Palindromo em C
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool isFim(char entrada[])
{
    return (strlen(entrada) >= 3 && entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}

bool isPalindrome(char entrada[])
{
    bool palindrome = true;
    int i = 0;
    int j = strlen(entrada) - 1;

    for(i, j; i < j; i++, j--)
    {
        if(entrada[i] != entrada[j])
        {
            i = strlen(entrada);
            palindrome = false;
        }
    }
    return palindrome;
}

int main ()
{
    char entrada[1000];
    do
    {
        scanf("%[^\n]%*c", entrada);
        if(isFim(entrada) == false)
        {
            if(isPalindrome(entrada) == true)
            {
                printf("SIM\n");
            }
            else
            {
                printf("NAO\n");
            }
        }
    }while(isFim(entrada) == false);
}
