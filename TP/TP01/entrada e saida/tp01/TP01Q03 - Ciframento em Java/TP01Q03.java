class TP01Q03{
	
	/**
	 * - Metodo para verificar se String é igual a fim.
	 *   @param String str - String a ser verificada
	 *   @return           - true ou false, caso str for igual a sim ou nao
	 */	
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' );
	} // end isFIM() 
	
	/**
	 * - Metodo para fazer pegar cada char de uma String e pular n casas (Ciframento de Cesar).
	 *   @param String str - String a ser manipulada
	 *   @param int key    - quantidade n casas a serem puladas
	 *   @return           - String ja cifrada
	 */
	static String cifraCesar(String str, int key){
		String strCifrado = "";
		for(int i = 0; i < str.length(); i++){
			strCifrado += (char)(str.charAt(i) + 3);
		} // end for()
		return strCifrado;
	} // end cifraCesar()

	/**
	 * - Metodo para entrada de novas entradas, e chamar as funcoes que fazem o ciframento.
	 *   @param int key - quantidade n casas a serem puladas
	 */
	static void getLines(int key){
		String entrada = MyIO.readLine();
		while(!isFIM(entrada)){
			MyIO.println(cifraCesar(entrada, key));
			
			entrada = MyIO.readLine();
		} // end while()
	} // end getLines()

	public static void main(String []arg){
		int key = 3;
		getLines(key);
	} // end main()
}
