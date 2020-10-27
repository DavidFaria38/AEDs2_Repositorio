/*
Exercício (12):
    Apresente um código, defina duas operações relevantes e 
    apresente a função e a complexidade para as operações 
    escolhidas no pior e melhor caso.

*/

public class Exer_12 {
    
    static void quadrado(int a, int[] array){
        int temp;
        for(int i = 1; i < a; i++)
            for(int j = 0; j < a; j++){
                if(j == array[0]){
                    temp = array[0];
                    temp++;
                    array[0] = temp;
                } // end if
            } // end for
    } // end quadrado()

    public static void main(String []arg){
        int[] array = new int[1];
        int a = 11;

        quadrado(a, array);

        System.out.println(array[0]);
    } // end main()
}
