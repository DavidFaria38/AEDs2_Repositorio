class RunArvore{

	public static void main(String arg[]){ 
		ArvoreTrie tree = new ArvoreTrie();

		String[] input = {"amo", "amor", "amora", "amores", "amori", "amar", "buy", "bull", "sell", "sapo", "stop", "stock"};
		int i = 0;
		do{
			tree.inserir(input[i]);
			i++;
		} while(i < input.length);

		tree.mostrar();

		//System.out.println("julio: " + tree.pesquisar("julio"));
		//System.out.println("pedro: " + tree.pesquisar("pedro"));			
		//System.out.println("david: " + tree.pesquisar("david"));
		//System.out.println("daniel: " + tree.pesquisar("daniel"));
		
		//System.out.println("rem julio: " + tree.remover("julio"));		
		// System.out.println("rem david: " + tree.remover("david"));
		//System.out.println("rem julio: " + tree.remover("julio"));
		
		// tree.mostrar();
		
		//System.out.println("rem david: " + tree.remover("david"));
		//System.out.println("rem arminda: " + tree.pesquisar("arminda"));
	}
}
