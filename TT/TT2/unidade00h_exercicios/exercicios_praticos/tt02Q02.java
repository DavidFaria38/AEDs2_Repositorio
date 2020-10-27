// Faça um método recursivo que receba um array de números inteiros e um número inteiro n indicando o tamanho do array e retorne o maior elemento

class tt02Q02{
        
    static int maiorElemento(int[] array, int i, int temp){
        int maior = 0;
        if(i >= 0){
            if(temp < array[i])
                maior = maiorElemento(array, i-1, array[i]);
            else
                maior = maiorElemento(array, i-1, temp);
        }else
            maior = temp;
        
        return maior;
    } // end maiorElemento()

    static int maiorElemento(int[] array, int i){
        return maiorElemento(array, i-2, array[i-1]);
    } // end maiorElemento()

    static void getElemArray(int[] array, int i){
        if(i < array.length){
            array[i] = MyIO.readInt();
            getElemArray(array, i+1);
        } // end if
    } // end getElemArray()

    static void getElemArray(int[] array){
        getElemArray(array, 0);
    } // end getElemArray()


    public static void main(String []arg){
        int len = MyIO.readInt();
        int [] array = new int[len];
        
        getElemArray(array);
        MyIO.println(maiorElemento(array, len));        
    } // end main()
}
