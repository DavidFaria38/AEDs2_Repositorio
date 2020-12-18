#include <stdlib.h>
#include <stdio.h>

void f (int val, int& ref) {
    val ++; ref++;
}

int main () {
    int i = 1, j = 1;
    f(i, j);
   printf("%i -- %i", i, j);
   return 0;
}
