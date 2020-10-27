// Faça um método recursivo que receba um array de caracteres e retorne um valor booleano indicando se esse é um palíndromo

class tt02Q03{
    
    static boolean isPalindromo(char[] arrayChar, int i, int j){
        boolean resp = true;
        if(i < j){
            if(arrayChar[i] != arrayChar[j])
                resp = false;
        }
        return resp;
    } // end isPalindromo()

    static boolean isPalindromo(char[] arrayChar){
        return isPalindromo(arrayChar, 0, arrayChar.length - 1);
    } // end isPalindromo()


    static void getChars(char[] arrayChar, int i){
        if(i < arrayChar.length){
            arrayChar[i] = MyIO.readChar();
            MyIO.pause();
            getChars(arrayChar, i+1);
        }
    } // end getChars()
    
    static void getChars(char[] arrayChar){
        getChars(arrayChar, 0);
    } // end getChars()


    public static void main(String []arg){
        int len = MyIO.readInt();
        char[] arrayChar = new char[len];

        getChars(arrayChar);
        MyIO.println(isPalindromo(arrayChar));
    } // end main()
}
