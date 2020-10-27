// Faça um método recursivo que receba um array de caracteres e retorne um número inteiro indicando a quantidade de vogais do mesmo

class tt02Q04{
    
    static boolean isVogal(char c){
        return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    } // end isVogal()

    static int countVogais(char[] array, int i){
        int counter = 0;
        if(i < array.length){
            if(isVogal(array[i])){
                counter++;
                counter += countVogais(array, i+1);
            }else
                counter += countVogais(array, i+1);
        } // end if
        return counter;
    } // end countVogais()

    static int countVogais(char[] array){
        return countVogais(array, 0);
    } // end countVogais()



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



    public static void main (String []arg){
        int len = MyIO.readInt();
        char[] array = new char[len];

        getChars(array);
        MyIO.println(countVogais(array));        
    } // end main()
}
