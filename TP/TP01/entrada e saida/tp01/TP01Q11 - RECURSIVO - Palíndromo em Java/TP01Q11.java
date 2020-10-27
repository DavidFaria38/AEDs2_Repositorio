class TP01Q11{
	/** isFIM() - metodo para verificar se String recebida e' igual a "FIM"
	 *  @param String st - String a ser verificada
	 *  @return          - true, se str igual FIM
	 *                     false, se str direferente de FIM
	 */
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	}
	/** isPalindromo() - metodo que verifica se string e' palindromo
	 *  @param String str - String a ser manipulada
	 *  @param int i      - Contador 
	 *  @return           - true, se str for palindromo
	 *                      false, se str nao for palindromo         
	 */
	static boolean isPalindromo(String str, int i, int j){
		boolean resp = true;
		if(i < j){
			if(str.charAt(i) == str.charAt(j))
				resp = isPalindromo(str, i+1, j-1);
			else
				resp = false;
		}
		return(resp);
	}
	
	/** isPalindromo() - chama metodo isPalindromo(String, int, int), inicia metodo recursivo
	 *  @param String str - String a ser manipulada
	 *  @return           - valor boleano resultado de isPalindromo()
	 */
	static boolean isPalindromo(String str){
		return(isPalindromo(str, 0, str.length() - 1));
	}

	/** getLines() - pega novas entradas e chama metodo para verificacao de palindromos 
	 */
	static void getLines(){
		String str = MyIO.readLine();
		if(isFIM(str) == false){
			if(isPalindromo(str) == true) 
				MyIO.println("SIM");      
			else
				MyIO.println("NAO");
			getLines();                       
		}
	}

	public static void main(String arg[]){
		getLines();
	}
}
