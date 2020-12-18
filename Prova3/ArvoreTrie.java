class Celula{
	char elemento; 
	boolean isFolha;
	Celula[] tabela;

	Celula(char elemento, boolean isFolha){
		this.elemento = elemento;
		this.isFolha = isFolha;
		this.tabela = new Celula[91]; // Tabela ASCII uppercase comeca em 65 termina em 90
		for(int i = 0; i < this.tabela.length; i++){
			this.tabela[i] = null;
		} // end for
	}
	Celula(){
		this('\0', false);
	}
}

public class ArvoreTrie{
	Celula raiz;
	
	ArvoreTrie(){
		this.raiz = new Celula();
	}
	
    
    /**
     * - Metodo verifica se celula.tabela possui outros filhos.
     * @param cell - Celula a ser verificada
     */
	public boolean pesquisar_tabela_celula(Celula cell){
		boolean result = false;
        int count = 0;
        System.out.println("\n========================\nChar cell: " + cell.elemento + "\n============================");
        for(int i  = 65; i < 91; i++){
    		if(cell.tabela[i] != null){ 
    		    if(count != 0){
                    result = true;
                    System.out.println("result = true boy");
                } // end if
                count++;
                System.out.println("cell " + (cell.tabela[i] != null) + " " +(char)i);
    		} // end if
        } // end for    
        
        System.out.println("pesquisarTabela: " + result); 
		return result;
	} // end pesquisar_char_celula()


	public void inserir(String elemento){
		// System.out.println("noop: " + elemento);
		System.out.println("");
		inserir(raiz, 0, elemento.toUpperCase());
	} // end inserir()

	private void inserir(Celula cell, int i, String elemento){
		if(/*(cell.isFolha == false) && */(i < elemento.length())){
			
			char charAtual = elemento.charAt(i);
		
			if(cell.tabela[charAtual] != null){
				inserir(cell.tabela[charAtual], i+1, elemento);
			} else{
				boolean isFolha = (i == elemento.length() - 1) ? true : false;
				System.out.println("char: " + charAtual + "\tisFolha: " + isFolha);
				cell.tabela[charAtual] = new Celula(charAtual, isFolha);
				inserir(cell.tabela[charAtual], i+1, elemento);
			} // end else
		} // end if
	} // end inserir()

	public boolean remover(String elemento){
	    return remover(raiz, 0, "", elemento.toUpperCase());
	} // end remover()
    
    private boolean remover(Celula cell, int i, String str, String elemento){
	    boolean result = false;
		
		if((cell.isFolha == false)){
			
			boolean jaEntrou = false;
			for(int j = 65; (j < 91) && (result == false); j++){
				if(cell.tabela[j] != null){
					if((jaEntrou == false) && (cell != raiz)){
						str += cell.elemento;
						jaEntrou = true;
					} // end if
					
					result = pesquisar(cell.tabela[j], str, elemento);
				    
                    System.out.println("apapgou: "+ cell.elemento + "\t" + result + "\t" + pesquisar_tabela_celula(cell));
                    if((result == true) && (pesquisar_tabela_celula(cell) == false)){
						
                        System.out.println("apapgou: true");
						for(int k = 65; k < 91; k++){
							cell.tabela[k] = null;
						}
                    } // end if
                } // end if
			} // end for
		} else {
			str += cell.elemento;
			// System.out.println("pesquisar: cmp(" + str + ", " + elemento + ") = " + (elemento.compareTo(str)));
			result = (elemento.compareTo(str) == 0) ? true : false;
		} // end else

		return result;	
	}
	
	public boolean pesquisar(String elemento){
		return pesquisar(raiz, "", elemento.toUpperCase());
	} // end pesquisar()
	private boolean pesquisar(Celula cell, String str, String elemento){
		boolean result = false;
		
		if((cell.isFolha == false)){
			
			boolean jaEntrou = false;
			for(int i = 65; (i < 91) && (result == false); i++){
				if(cell.tabela[i] != null){
					if((jaEntrou == false) && (cell != raiz)){
						str += cell.elemento;
						jaEntrou = true;
					} // end if
					result = pesquisar(cell.tabela[i], str, elemento);
				} // end if
			} // end for
		} else {
			str += cell.elemento;
			// System.out.println("pesquisar: cmp(" + str + ", " + elemento + ") = " + (elemento.compareTo(str)));
			result = (elemento.compareTo(str) == 0) ? true : false;
		} // end else

		return result;
	} // end pesquisar()


	private boolean hasFilhoMoreThanOneFilho(Celula cell){
		boolean result = false;
		int nFilhos = 0;

		for(int i = 65; (i < 91) && (result == false); i++){
			if(cell.tabela[i] != null){
				if((nFilhos <= 1)){
					result = true;
					// System.out.print(" filho true ");
				} // end if
			} // end if
		} // end for


		return result;
	} // end pesquisar()
	

	public void mostrar(){
        System.out.println("\n================================");
		mostrar(raiz, "");
        System.out.println("================================\n");
	} // end mostrar()
	private void mostrar(Celula cell, String str){
		boolean jaEntrou = false;
		int countFolha = 0;
		if(hasFilhoMoreThanOneFilho(cell)){
			
			for(int i = 65; i < 91; i++){ // pocura dentro de uma tabela hash todas as letrar maiusculas
				if(cell.tabela[i] != null){ // caso exista uma celula dentro da tabela hash
					if(jaEntrou == false){ 
						str += cell.elemento;
						jaEntrou = true;
					} // end if
					if((cell.isFolha == true) && (countFolha == 0)){
						System.out.println(str);
						countFolha++;
					}
					
					mostrar(cell.tabela[i], str);
				} // end if
			} // end for
		} else{
			str += cell.elemento;
			System.out.println(str);
		} // end else
	} // end mostrar()


} // end class ArvoreTrie


