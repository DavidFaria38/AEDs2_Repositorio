// Leia 3 números inteiros, selecione o menor e o maior e imprima os seus respectivos valores na tela.


class tt02Q02{
    
    public static void main(String []arg){
        int [] numInt = new int[3];
        int maior, menor;
        
        for(int i = 0; i < 3; i++)
            numInt[i] = MyIO.readInt();

        maior = numInt[0];
        menor = numInt[0];

        for(int i = 1; i < 3; i++){
            if(maior < numInt[i])
                maior = numInt[i];
            if(menor > numInt[i])
                menor = numInt[i];
        }

        MyIO.println("Maior = " + maior);
        MyIO.println("Menor = " + menor);
    } // end main()
}
