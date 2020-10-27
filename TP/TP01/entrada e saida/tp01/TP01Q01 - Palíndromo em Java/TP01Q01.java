class TP01Q01{
	
	/**
	 * - Metodo verifica se String é igual a FIM.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false, caso str seja FIM ou nao.
	 */
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' );
	} //end isFIM()
	
	/**
	 * - Metodo que verifica se String é um palindromo.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false, caso str seja um palindromo ou nao
	 */
	static boolean isPalindromo(String str){
		boolean resp = true;
		int i = 0;
	       	int j = str.length() - 1;
		for(; i < j; i++, j--){
			if(str.charAt(i) != str.charAt(j)){
				resp = false;
				i = str.length();
			} // end if()
		} // end for()
		return resp;
	} // end isPalindromo()

	/**
	 * - Metodo le novas entradas e armazena como String, chama suas funcoes para verificar se é um palindromo.
	 *   Saida "SIM" caso entrada seja palindromo.
	 *   Saida "NAO" caso entrada nao seja palindromo.
	 */
	static void getLines(){
		String entrada = MyIO.readLine();
		while(!isFIM(entrada)){
			if(isPalindromo(entrada) == true)
				MyIO.println("SIM");
			else
				MyIO.println("NAO");
			entrada = MyIO.readLine();
		} // end while()
	} // end getLines

	public static void main(String []arg){
		getLines();
	} // end main()
}
