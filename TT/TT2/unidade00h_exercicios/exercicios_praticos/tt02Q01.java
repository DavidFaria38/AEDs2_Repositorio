// Faça um método recursivo que receba dois números inteiros e retorne a multiplicação do primeiro pelo segundo fazendo somas

class tt02Q01{
    
    /**
     * - Metodo que faz a multiplicacao de dois elementos
     * @param num1 - elemento 1
     * @param num2 - elemento 2
     * @return     - a multiplicacao entre os dois elementos
     */
    static int multiplica(int num1, int num2){
        int resp = 0;
        if(num2 > 0)
            resp = num1 + multiplica(num1, num2 - 1);
        return resp;
    } // end multiplica()

    public static void main(String []arg){
        int num1 = MyIO.readInt();
        int num2 = MyIO.readInt();
        MyIO.println(multiplica(num1, num2));
    } // end main()
}
