/* Faltando: 
 * 	
 */
class TP01Q05{
	/**
     * - Metodo verifica se String e` 0
     * @param str - String a ser verificado
     * @return    - true ou false, dependendo se str for igual a FIM
     */
    static boolean isFIM(String str){
        return(str.length() >= 1 && str.charAt(0) == '0');
    } // end isFIM()

    /**
     * - Metodo para trocar variaveis boleanas por seus devidos valores
     * @param str - String a ser manipulada
     * @return    - nova String com valores trocados
     */
    static String replaceOperando(String str){
        String newStr = "";
        int i, j;
        int qtnOperando = (int)(str.charAt(0) - 48);
        int[] operando = new int[qtnOperando];
        
        // leitura dos valores "boleanos" da String
        j = 1;
        for(i = 0; i < qtnOperando; i++){
            operando[i] = (int)(str.charAt(j) - 48);
            j++;
        } // end for
        
        // troca alpha => valor "boleano" 
        j = 0;
        for(i = qtnOperando + 1; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                j = (int)(str.charAt(i) - 65);
                newStr += operando[j];
            }else
                newStr += str.charAt(i);
        } // end for
        return newStr;
    } // end replaceOperando()

    /**
     * - Metodo para formatar String, remover espacos e virgulas
     * @param str - String a ser manipulada
     * @return    - nova String com valores trocados
     */
    static String removeSpaceAndComma(String str){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'n'){
                newStr += str.charAt(i); 
                i += 2;                    
            }
            else if(str.charAt(i) == 'o'){
                newStr += str.charAt(i);
                i += 1;
            }
            else if(str.charAt(i) != ' ' && str.charAt(i) != ','){
                newStr += str.charAt(i);
            }
        } // end if
        return newStr;
    } // end removeSpaceAndComma()

    /**
     * - Metodo que chama replaceOperando() e formatEntrada()
     * @param str - String a ser manipulada
     * @return    - nova String com valores trocados
     */
    static String formatEntrada(String str){
        return replaceOperando(removeSpaceAndComma(str));
    } // end formatEntrada()

    /**
     * - Metodo retorna o index do ultimo parentesis em uma string
     * @param str - String a ser manipulada
     * @return    - index do ultimo parentesis 
     */
    static int getLastPara(String str){
        int lastPara = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                lastPara = i;
        } // end for
        return lastPara;
    } // end getLastPara()
    
    /**
     * - Metodo retorna valor boleano de um caractere, '0' = false, '1' = true
     * @param c - caractere a ser verificado
     * @return  - valor boleano
     */
    static boolean cToBool(char c){
        boolean resp = false;
        if(c == '1')
            resp = true;
        return resp; 
    } // end cToBool()

    /**
     * - Metodo do operador AND 
     * @param str - String a ser manipulada
     * @return    - nova String com valores alterados
     */
    static String andOperador(int indexPara, String str){
        String newStr = "";
        char result;
        boolean[] operandos = new boolean[5];
        int index = 0;
        
        // armazena os operandos
        for(int i = indexPara + 1; i < str.length(); i++){
            if(str.charAt(i) != ')'){
                operandos[index] = cToBool(str.charAt(i));
                index++;
            }else
                i = str.length();
        } // end for

        // comparacao de operandos
        if(index == 3){
            if(operandos[0] && operandos[1] && operandos[2])
                result = '1';
            else
                result = '0';
        }else{
            if(operandos[0] && operandos[1])
                result = '1';
            else
                result = '0';
        } // end else

        // substituicao       
        for(int i = 0; i < str.length(); i++){
            if(i != indexPara - 1)
                newStr += str.charAt(i);
            else{
                newStr += result;
                i += (index + 3) - 1;  // qtn de operandos + 3 char "a","(",")"
            } // end else
        } // end for()    
        return newStr;
    } // end andOperador()

    /**
     * - Metodo do operador NOT 
     * @param str - String a ser manipulada
     * @return    - nova String com valores alterados
     */
    static String notOperador(int indexPara, String str){
        String newStr = "";
        char result;
        
        if(str.charAt(indexPara + 1) == '0')
            result = '1';
        else
            result = '0';

        // substituicao       
        for(int i = 0; i < str.length(); i++){
            if(i != indexPara - 1)
                newStr += str.charAt(i);
            else{
                newStr += result;
                i += 3;     // pula operando + 3 chars, "n","(",")"
            } // end else
        } // end for()    
        return newStr;
    } // end notOperador()

    /**
     * - Metodo do operador OR 
     * @param str - String a ser manipulada
     * @return    - nova String com valores alterados
     */
    static String orOperador(int indexPara, String str){
        String newStr = "";
        char result = '0';
        boolean[] operandos = new boolean[5];
        int index = 0;
        
        // armazena os operandos
        for(int i = indexPara + 1; i < str.length(); i++){
            if(str.charAt(i) != ')'){
                operandos[index] = cToBool(str.charAt(i));
                index++;
            }else
                i = str.length();
        } // end for
        
        // comparacao de operandos
        for(int i = 0; i < index; i++){
            if(operandos[i] == true)
                result = '1';
        } // end for

        // substituicao       
        for(int i = 0; i < str.length(); i++){
            if(i != indexPara - 1)
                newStr += str.charAt(i);
            else{
                newStr += result;
                i += (index + 3) - 1;     // qtn de operandos + 3 char "o","(",")"
            } // end else
        } // end for()    
        return newStr;
    } // end orOperador()

    /**
     * - Metodo que seleciona qual operador sera usado 
     * @param str - String a ser manipulada
     * @return    - nova String com valores alterados
     */
    static String selectOperador(String str){
        String newStr = "";
        int lastPara = getLastPara(str);
        char operador = str.charAt(lastPara - 1);
        
        switch(operador){
            case 'a':
                newStr = andOperador(lastPara, str);
                break;
            case 'n':
                newStr = notOperador(lastPara, str);
                break;
            case 'o':
                newStr = orOperador(lastPara, str);
                break;
        } // end switch()

        return newStr;
    } // end selectOperador()

    /**
     * - Metodo que recebe entrada e realiza a chamada dos metodos para realizar as contas boleanas
     */
    static void algebraBoolean(){
        String entrada = MyIO.readLine();
        
        while(!isFIM(entrada)){
            entrada = formatEntrada(entrada);
            
            while(entrada.length() != 1){
                entrada = selectOperador(entrada);
            } // end while
            MyIO.println(entrada);
            entrada = MyIO.readLine();
        } // end while
    } // end algebraBoolean()

	public static void main(String[] arg){
		algebraBoolean();
	} // end main()
}
