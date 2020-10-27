// TP01Q15 - Recursivo

class TP01Q15{
    
    static boolean isFIM(String str){
        return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    } // end isFIM()
    
    
    static boolean charIsVogal(char c){
        return(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' ||c == 'A' ||c == 'E' ||c == 'I' ||c == 'O' ||c == 'U');
    } // end charIsVogal()
    static boolean charIsConsoante(char c){
        return(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && !charIsVogal(c));
    } // end charIsConsoante()
    static boolean charIsInteiro(char c){
        return(c >= '0' && c <= '9');
    } // end charIsInteiro()
//    static boolean charIsReal(char c){} // end charIsReal()

    
    static boolean isVogal(String str, int i){
        boolean resp = true;
        if(i < str.length()){
            if(charIsVogal(str.charAt(i)))
                resp = isVogal(str, i+1);
            else
                resp = false;
        } // end if()
        return resp;
    } // end isVogal()
    
    static boolean isConsoante(String str, int  i){
        boolean resp = true;
        if(i < str.length()){
            if(charIsConsoante(str.charAt(i)))
                resp = isConsoante(str, i+1);
            else
                resp = false;
        } // end if()
        return resp;
    } // end isConsoante()
    
    static boolean isInteiro(String str, int i){
        boolean resp = true;
        if(i < str.length()){
            if(charIsInteiro(str.charAt(i)))
                resp = isInteiro(str, i+1);
           else
                resp = false;
        } // end if()
        return resp;
    } // end isInteiro
    
    static boolean isReal(String str, int i, int nPontos){
        boolean resp = true;
        if(i < str.length()){
            if(charIsInteiro(str.charAt(i)))
                resp = isReal(str, i+1, nPontos);
            else{
                if(nPontos < 1 && (str.charAt(i) == ',' || str.charAt(i) == '.'))
                    resp = isReal(str, i+1, nPontos+1);
                else
                    resp = false;
            } // end else
        } // end if()
        return resp;
    } // end isReal()

    
    // Chamadores com iniciadores das funcoes recursivas
    static boolean isVogal(String str){
        return(isVogal(str, 0));
    } // end isVogal()
    static boolean isConsoante(String str){
        return(isConsoante(str, 0));
    } // end isConsoante()
    static boolean isInteiro(String str){
        return(isInteiro(str, 0));
    }  // end isInteiro()
    static boolean isReal(String str){
        return(isReal(str, 0, 0));
    } // end isReal()

    static void getLines(){
        String entrada = MyIO.readLine();
        String x1 = "", x2 = "", x3 = "", x4 = "";
        if(!isFIM(entrada)){
            x1 += (isVogal(entrada))     ? "SIM" : "NAO";
            x2 += (isConsoante(entrada)) ? "SIM" : "NAO";
            x3 += (isInteiro(entrada))   ? "SIM" : "NAO";
            x4 += (isReal(entrada))      ? "SIM" : "NAO";
            MyIO.println(x1 + " " + x2 + " " + x3 + " " + x4);
            getLines();
        } // end if()
    } // end getLines()

    public static void main(String []arg){
        getLines();
    } // end main()
}
