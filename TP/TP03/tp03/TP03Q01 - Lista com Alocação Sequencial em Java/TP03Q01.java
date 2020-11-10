
public class TP03Q01{
	/**
	 * - Metodo verifica se String é igual a "FIM".
	 * @param s
	 * @return true ou false caso String seja igual a "FIM"
	 */
	private static boolean isFIM(String s){
		return(s.equals("FIM"));
	} // end isFIM()

	/**
	 * - Metodo que imprime todos objetos dentro do array.
	 * @param player - Array de objetos.
	 * @param n - Tamanho do array.
	 */
	private static void printPlayers(Jogador[] player, int n){
		for(int i = 0; i < n; i++){
			System.out.print("[" + i + "]");
			player[i].imprimir();
			System.out.print("\n"); 
		} // end for
	} // end printPlayers()

	private static int getComando(String[] str){
		int result = 0;

		if(str[0].charAt(0) == 'I'){
			if(str[0].charAt(1) == 'I')
				result = 1;
			else if(str[0].charAt(1) == 'F')
				result = 3;
			else
				result = 5;
		} else if(str[0].charAt(0) == 'R'){
			if(str[0].charAt(1) == 'I')
				result = 2;
			else if(str[0].charAt(1) == 'F')
				result = 4;
			else
				result = 6;
		} //end else
		return result;
	} // end getComando()

	private static int getId(String[] str, int comando){
		int result = 0;

		if(comando == 1 || comando == 3){
			result = Integer.parseInt(str[1]);
		} else if(comando == 5){
			result = Integer.parseInt(str[2]);
		} else{
			result = 0;
		}// end else

		return result;
	} // end getId()

	private static int getPosicao(String[] str, int comando){
		int result = 0;

		if(comando >= 5){
			result = Integer.parseInt(str[1]);
		} // end if

		return result;
	} // end getId()


	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getPrimeiraEntrada(ListaLinear lista){
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while(!isFIM(input)){
			id = Integer.parseInt(input);	

			Jogador tmp = new Jogador();

			tmp.ler(id);
			// tmp.imprimir();
			try {
				lista.inserirFim(tmp);
			} catch (Exception e) {
				System.out.println("erro: " + e);
			} // end catch
			
			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()
	
	/**
	 * - Metodo para pegar a segunda parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getSegundaEntrada(ListaLinear lista){
		int id, comando, posicao, n;
		String input = "";
		/* diagrama de codigos para comando: */ 
		// (II) InserirInicio = 1 
		// (RI) RemoverInicio = 2 
		// (IF) InserirFim = 3 
		// (RF) RemoverFim = 4 
		// (I*) Inserir = 5 
		// (R*) Remover = 6 

		n = Integer.parseInt(MyIO.readLine());
		while(n > 0){
			input = MyIO.readLine();

			Jogador tmp = new Jogador();
			String[] inputList = input.split("\\s+");

			comando = getComando(inputList);
			id      = getId(inputList, comando);
			posicao = getPosicao(inputList, comando);

			System.out.println("comando: " + comando);

			tmp.ler(id);
			// tmp.imprimir();

			try {
				switch (comando){
					case 1:
						lista.inserirInicio(tmp);
						break;
					case 2:
						tmp = lista.removerInicio();
						System.out.println("(R) " + tmp.getNome());
						break;
					case 3:
						lista.inserirFim(tmp);
						break;
					case 4:
						tmp = lista.removerFim();
						System.out.println("(R) " + tmp.getNome());
						break;
					case 5:
						lista.inserir(tmp, posicao);
						break;
					case 6:
						tmp = lista.remover(posicao);
						System.out.println("(R) " + tmp.getNome());
						break;
					default:
						System.out.println("ERRO: comando invalido");
						break;
				} // end switch
				lista.inserirFim(tmp);
			} catch (Exception e) {
				System.out.println(e);
			} // end catch

			n--;
		} // end while
	} // end getPrimeira Entrada()
	

	public static void main(String []arg){

		ListaLinear lista = new ListaLinear(100);
		// Jogador tmp = new Jogador();
		
		getPrimeiraEntrada(lista);	
		getSegundaEntrada(lista);

		// tmp = lista.removerFim();
		// System.out.println("(R) " + tmp.getNome());
		// tmp = lista.removerFim();
		// System.out.println("(R) " + tmp.getNome());
		// tmp = lista.removerFim();
		// System.out.println("(R) " + tmp.getNome());

		// lista.sub();
		// lista.sub();
		// lista.sub();

		lista.mostrar();
	} // end main()
}



/* Problema:
	Variavel tamnho em classe ListaLinear.
	eh feito o update da variavel mas nao eh mantido
 */







