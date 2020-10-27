

class TP01Q14{
    /**
     * - Metodo verifica se String e` 0
     * @param str - String a ser verificado
     * @return    - true ou false, dependendo se str for igual a FIM
     */
    static boolean isFIM(String str){
        return(str.length() >= 1 && str.charAt(0) == '0');
    } // end isFIM()

    /**
     * - Metodo armezana os primeiros valores booleanos em um array 
     * @param str - String a ser manipulada
     * @param operandos - array a ser armazenados os valores boleanos
     * @param i         - posicao inicial
     * @param j         - contador para array / setar em 0
     */
    static void getOperandos(String str, int[] operandos, int i, int j){
        if(!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') && j < operandos.length){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                operandos[j] = (int)(str.charAt(i) - 48);
                getOperandos(str, operandos, i+1, j+1);
            }else
                getOperandos(str, operandos, i+1, j);
        } // end if
    } // end getOperandos()

    /**
     * - Metodo que formata String, removendo espacos e virgulas
     * @param str - String a ser manipulada
     * @return    - nova String com valores trocados
     */
    static String formatString(String str, int[] operandos, int i){
        String newStr = "";
        if(i < str.length()){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                newStr += operandos[(int)(str.charAt(i) - 65)];
                newStr += formatString(str, operandos, i+1);
            }else if(str.charAt(i) == 'n'){
                newStr += str.charAt(i);
                newStr += formatString(str, operandos, i+3);
            }else if(str.charAt(i) == 'a'){
                newStr += str.charAt(i);
                newStr += formatString(str, operandos, i+3);
            }else if(str.charAt(i) == 'o'){
                newStr += str.charAt(i);
                newStr += formatString(str, operandos, i+2);
            }else if(str.charAt(i) != ' ' && str.charAt(i) != ','){
                newStr += str.charAt(i);
                newStr += formatString(str, operandos, i+1); 
            }else
                newStr += formatString(str, operandos, i+1); 
        } // end if
        return newStr;
    } // end formatString()

    /**
     * - Metodo que formata String, removendo espacos e virgulas
     * @param str - String a ser manipulada
     * @return    - nova String com valores trocados
     */
    static String formatString(String str){
        String newStr = "";
        int nOperandos = str.charAt(0) - 48;
        int[] operandos = new int[nOperandos];
        getOperandos(str, operandos, 1, 0);
        newStr = formatString(str, operandos, (nOperandos*2)+2);     
        return newStr;
    } // end formatString()

    
    /**
     * - Metodo que retorna o index da ultima instacia do caractere '(''
     * @param str      - String a ser manipulada
     * @param lastPara - ultima instancia do caractere '('
     * @param i        - contador recursivo
     * @return    - nova String com valores trocados
     */
    static int indexLastPara(String str, int lastPara, int i){
        int temp = lastPara;
        if(i < str.length()){
            if(str.charAt(i) == '(')
                temp = indexLastPara(str, i, i+1);
            else
                temp = indexLastPara(str, lastPara, i+1);
        } // end if
        return temp;
    } // end indexLastPara()

    /**
     * - Metodo que recebe um caractere '0' ou '1' e retorna seu valor booleano
     * @param c - caractere
     * @return    - Valor booleano
     */
    static boolean cToBool(char c){
        boolean resp = false;
        if(c == '1')
            resp = true;
         return resp;
    } // end cToBool()

    /**
     * - Metodo do operador not
     * @param str - String a ser manipulada
     * @param i   - index da ultima instancia de '('
     * @return    - resultado da comparacao com o operador not 
     */
    static int notOperador(String str, int i){
        int result = 0;
        boolean A = cToBool(str.charAt(i+1));
        if(!A)
            result = 1;
        return result;
    } // end notOperador()
    
    /**
     * - Metodo do operador and
     * @param str - String a ser manipulada
     * @param i   - index da ultima instancia de '('
     * @return    - resultado da comparacao com o operador and 
     */
    static int andOperador(String str, int i){
        int result = 0, count = 0, j;
        boolean[] operandos = new boolean[10];
        for(j = 0; j < 5; j++){
            if(str.charAt(i+j+1) != ')'){
                operandos[j] = cToBool(str.charAt(i+j+1));
                count++;
            }else
                j=5;
        }// end else

        if (count == 2)
            result = (operandos[0] && operandos[1] == true) ? 1 : 0;
        else if(count == 3)
            result = (operandos[0] && operandos[1] && operandos[2] == true) ? 1 : 0;
        else if(count == 4)
            result = (operandos[0] && operandos[1] && operandos[2] && operandos[3] == true) ? 1 : 0;
        else if(count == 5)
            result = (operandos[0] && operandos[1] && operandos[2] && operandos[3] && operandos[4] == true) ? 1 : 0;
        return result;
    } // end andOperador()

    /**
     * - Metodo do operador or
     * @param str - String a ser manipulada
     * @param i   - index da ultima instancia de '('
     * @return    - resultado da comparacao com o operador or 
     */
    static int orOperador(String str, int i){
        int result = 0, count = 0, j;
        boolean[] operandos = new boolean[10];
        for(j = 0; j < 5; j++){
            if(str.charAt(i+j+1) != ')'){
                operandos[j] = cToBool(str.charAt(i+j+1));
                count++;
            }else
                j=5;
        }// end else

        if (count == 2)
            result = (operandos[0] || operandos[1] == true) ? 1 : 0;
        else if(count == 3)
            result = (operandos[0] || operandos[1] || operandos[2] == true) ? 1 : 0;
        else if(count == 4)
            result = (operandos[0] || operandos[1] || operandos[2] || operandos[3] == true) ? 1 : 0;
        else if(count == 5)
            result = (operandos[0] || operandos[1] || operandos[2] || operandos[3] || operandos[4] == true) ? 1 : 0;
        return result;
    } // end orOperador()

    /**
     * - Metodo que faz as operacoes da algebra booleana em uma String
     * @param str             - String a ser manipulada
     * @param indexLastPara   - index do ultima '('
     * @param i               - contador recursivo
     * @return                - String com uma operacao feita 
     */
    static String doOperacaoBool(String str, int indexLastPara, int i){
        String newStr = "";
        char operador;
        if(i < str.length()){
            if(i+1 == indexLastPara){
                operador = str.charAt(i);
                switch (operador) {
                    case 'n':
                        newStr += notOperador(str, indexLastPara);
                        for(; str.charAt(i) != ')'; i++){}
                        newStr += doOperacaoBool(str, indexLastPara, i+1);
                        break;
                    case 'a':
                        newStr += andOperador(str, indexLastPara);
                        for(; str.charAt(i) != ')'; i++){}
                        newStr += doOperacaoBool(str, indexLastPara, i+1);
                        break;
                    case 'o':
                        newStr += orOperador(str, indexLastPara);
                        for(; str.charAt(i) != ')'; i++){}
                        newStr += doOperacaoBool(str, indexLastPara, i+1);
                        break;
                
                    default:
                } // end switch
            }else{
                newStr += str.charAt(i);
                newStr += doOperacaoBool(str, indexLastPara, i+1);
            }
        } // end if
        return newStr;
    } // end doOperacaoBool()

    /**
     * - Metodo retorna index da ultima intancia do caractere '('
     * @param str - String a ser manipulada
     * @return    - index da ultima intancia do caractere '('
     */
    static int indexLastPara(String str){
        return indexLastPara(str, 0, 0);
    } // end indexLastPara()

    /**
     * - Metodo que chama outros metodos para fazer a operacao booleana
     * @param str - String a ser manipulada
     * @return    - String com uma operacaos feitas
     */
    static String loopOperacaoBool(String str){
        String result = str;
        int indexLastPara = 0;
        if(str.length() > 1){
            indexLastPara = indexLastPara(str);
            result = doOperacaoBool(str, indexLastPara, 0);
            //MyIO.println(result);
            result = loopOperacaoBool(result);
        } // end if
        return result;
    } // end loopOperacaoBool()
    
    /**
     * - Metodo que recebe entrada e realiza a chamada dos metodos para realizar as contas boleanas
     */
    static void getLines(){
        String input = MyIO.readLine();
        if(!isFIM(input)){
            input = formatString(input);
            input = loopOperacaoBool(input);
            MyIO.println(input);
            getLines();
        } // end if
    } // end getLines()
    public static void main(String [] arg){
        getLines();

    } // end main()
}