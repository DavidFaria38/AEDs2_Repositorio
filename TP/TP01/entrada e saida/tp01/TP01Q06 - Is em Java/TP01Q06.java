class TP01Q06{
	/**
	 * - Metodo que verifica se String e' igual a "FIM".
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false caso str seja igual a FIM
	 */
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	}
	
	/**
	 * - Metodo que verifica se char c e' uma uma vogal.
	 *   @param char c - caractere a ser verificado
	 *   @return       - true ou false caso c seja vogal
	 */
	static boolean charIsVogal(char c){
		return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
	} // end charIsVogal()

	/**
	 * - Metodo que verifica se char c e' uma consoante.
	 *   @param char c - caractere a ser verificado
	 *   @return       - true ou false caso c seja consoante
	 */	
	static boolean charIsCons(char c){
		return((charIsVogal(c) == false) && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')));
        } // end charIsCons()
	
	/**
	 * - Metodo que verifica se char c e' um numero inteiro.
	 *   @param char c - caractere a ser verificado
	 *   @return       - true ou false caso c seja inteiro ou nao
	 */
	static boolean charIsInt(char c){
		return(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9');
	} // end charIsInt()
	
	/**
	 * - Metodo que verifica se char c e' uma virgula ou ponto.
	 *   @param char c - caractere a ser verificado
	 *   @return       - true ou false caso c for uma virgula ou ponto
	 */
	static boolean charIsDotComma(char c){
		return(c == ',' || c == '.');
	} // end charIsDouble()

	/**
	 * - Metodo que verifica se String e' composta somente de vogais.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false caso String for composta de vogais ou nao
	 */
	static boolean isVogal(String str){
		boolean resp = false;
		int nVogal = 0;
		for(int i = 0; i < str.length(); i++){
			if(charIsVogal(str.charAt(i)) == true)
				nVogal++;
			else
				i = str.length();
		} // end for()
		if(nVogal == str.length())
			resp = true;
		return resp;
	} // end isVogal()

	/**
	 * - Metodo que verifica se String e' composta somente por consoantes.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou falso caso String for composta somente por consoantes ou nao
	 */
	static boolean isConsoante(String str){
		boolean resp = false;
		int nCons = 0;
		for(int i = 0; i < str.length(); i++){
			if(charIsCons(str.charAt(i)) == true)
				nCons++;
			else
				i = str.length();
		} // end for()
		if(nCons == str.length())
			resp = true;
		return resp;	
	} // end isConsoante()

	/**
	 * - Metodo que verifica se String é composta somente por numeros inteiros.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false caso String for composta somente por inteiros ou nao
	 */
	static boolean isInt(String str){
		boolean resp = false;
		int nInt = 0;
		for(int i = 0; i < str.length(); i++){
			if(charIsInt(str.charAt(i)) == true)
				nInt++;
			else
				i = str.length();
		} // end for()
		if(nInt == str.length())
			resp = true;
		return resp;
	} // end isInt()
	
	/**
	 * - Metodo para verificar se String é composta somente por numeros reais.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false caso String for composta por numeros reais
	 */
	static boolean isDouble(String str){
		boolean resp   = false;
		int nDouble    = 0;
		int nDotComma = 0;
		for(int i = 0; i < str.length(); i++){
			if(charIsInt(str.charAt(i)) == true)
				nDouble++;
			else if((charIsDotComma(str.charAt(i)) == true) && nDotComma < 1){
				nDouble++; nDotComma++;
			}else
				i = str.length();
		} // end for()
		if(nDouble == str.length())
			resp = true;
		return resp;
	} // end isDouble()

	/**
	 * - Metodo que pega novas entradas e chama funcoes para vericar se tal entrada é vogal, consoante, int ou double.
	 */
	static void getLines(){
		String entrada = MyIO.readLine();
		String X1 = "", X2 = "", X3 = "", X4 = "";
		if(isFIM(entrada) == false){
			X1 += (isVogal(entrada)     == true) ? "SIM" : "NAO";
			X2 += (isConsoante(entrada) == true) ? "SIM" : "NAO";
			X3 += (isInt(entrada)       == true) ? "SIM" : "NAO";
			X4 += (isDouble(entrada)    == true) ? "SIM" : "NAO";

			MyIO.println(X1 + " " + X2 + " " + X3 + " " + X4);
			getLines();
		}
	} // end getLines()
	public static void main(String[] arg){
		getLines();

	} // end main()
}
