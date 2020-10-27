// Leia 10 números inteiros, selecione o maior e imprima seu valor na tela.


class tt02Q03{
    
    public static void main(String []arg){
        int [] numInt = new int[10];
        int maior;
        
        for(int i = 0; i < 10; i++)
            numInt[i] = MyIO.readInt();

        maior = numInt[0];

        for(int i = 1; i < 10; i++)
            if(maior < numInt[i])
                maior = numInt[i];

        MyIO.println("Maior = " + maior);
    } // end main()
}
