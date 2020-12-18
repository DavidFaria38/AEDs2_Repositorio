#include <stdlib.h>
#include <stdio.h>

void troca(double *x, double *y){
          double aux = *x;
          *x = *y;
          *y = aux;
}

int main(){
          double x = 7.0;
          double y = 5.0;
          troca(&x, &y);
          printf("X: %lf Y: %lf", x, y);
}
