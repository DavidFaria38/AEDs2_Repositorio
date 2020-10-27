class TP01Q13{
	/**
	 * - Verifica se String e' igual a "FIM"
	 *   @param String str - String a ser verificada
	 *   @return           - true, se for igual a "FIM"
	 *                       false, se for diferente de "FIM" 
	 */	
	static boolean isFIM(String str){
		return(str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I'  && str.charAt(2) == 'M');
	}
	
	/**
	 * - Metodo para fazer o ciframento de Cesar, mudando todos caracters +3 casas
	 *   @param String str - String a ser cifrada
	 *   @param int i      - Contador
	 *   @return           - Uma String cifrada
	 */
	static String cesarCifra(String str, int i){
		String cifra = "";
		if(i < str.length()){
			cifra += (char)(str.charAt(i) + 3); 
			cifra += cesarCifra(str, i+1);
		}
		return(cifra);
	}
	
	/**
	 * - Metodo para chamar metodo cifraCesar()
	 *   @param String str - String a ser manipulada por cifraCesar()
	 *   @return           - retorno de cifraCesar()
	 */
	static String callCesarCifra(String str){
		return(cesarCifra(str, 0));
	}
	
	/**
	 * - Metodo para pegar novas entradas e fazer o ciframento de Cesar, passando as casas de cada caracteres +3 casas. 
	 */
	static void getEntradas(){
		String str = MyIO.readLine();
	
		if(isFIM(str) == false){
			MyIO.println(callCesarCifra(str));		
			getEntradas();
		}
	}
	public static void main(String arg[]){
		int key = 3;
		getEntradas();
	}
}
