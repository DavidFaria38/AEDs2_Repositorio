class RecordAlgoritmo{
	private int comp;
	private int mov;
	private double start;
	private double end;

/* ================= Construtores ================= */
	public RecordAlgoritmo(){
		mov = comp = 0;
	} // end RecordAlgoritmo()

/* ================= Metodos get ================= */
	public int getComp(){return this.comp;}
	public int getMov(){return this.mov;}
	
/* ================= Metodos set ================= */
	public void sumCmp(int value){this.comp += value;}
	public void sumMov(int value){this.mov += value;}

/* ================= Metodos time ================= */
	public void startCurrentTime(){this.start = System.currentTimeMillis(); } 
	public void endCurrentTime(){this.end = System.currentTimeMillis(); }
	
/* ================================================ */
	/**
	 * - Metodo que grava em um arquivo o tempo de execução do algoritmo de ordenação, movimentações e comparações.
	 * @param fileWrite - Nome do arquivo.
	 */
	public void recordTime(String fileWrite){
		Arq.openWrite(fileWrite);
		Arq.println("699415\t" + (end-start)/1000 + "\t" + this.comp + "\t" + this.mov);
		Arq.close();
	} // end recordTime()
} // end recordAlgoritmo

class Jogador{
	private int id;
	private int altura;
	private int peso;
	private int anoNascimento;
	private String nome;
	private String universidade;
	private String cidadeNascimento;
	private String estadoNascimento;

/* ================= Construtores ================= */
	public Jogador(){
		this.id     = -1;
		this.altura = -1;
		this.peso   = -1;
		this.anoNascimento = -1;
		this.nome = "";
		this.universidade = "";
		this.cidadeNascimento = "";
		this.estadoNascimento = "";
	} // end Jogador()

	public Jogador(int id, String nome, int altura, int peso, int anoNasc, String uni, String cidadeNasc, String estadoNasc){
		this.id     = id;
		this.altura = altura;
        this.peso   = peso;
        this.anoNascimento = anoNasc;
        this.nome = nome;
        this.universidade = uni;
        this.cidadeNascimento = cidadeNasc;
        this.estadoNascimento = estadoNasc;
	} // end Jogador()

/* ================= Metodos get ================= */
	public int getId(){return this.id;}
	public int getAltura(){return this.altura;}
	public int getPeso(){return this.peso;}
	public int getAnoNascimento(){return this.anoNascimento;}
	public String getNome(){return this.nome;}
	public String getUniversidade(){return this.universidade;}
	public String getCidadeNascimento(){return this.cidadeNascimento;}
	public String getEstadoNascimento(){return this.estadoNascimento;}

/* ================= Medotos set ================= */	
	public void setId(int id){this.id = id;}
    public void setAltura(int alt){this.altura = alt;}
    public void setPeso(int peso){this.peso = peso;}
    public void setAnoNascimento(int anoNasc){this.anoNascimento = anoNasc;}
    public void setNome(String nome){this.nome = nome;}
    public void setUniversidade(String uni){this.universidade = uni;}
    public void setCidadeNascimento(String cidadeNasc){this.cidadeNascimento = cidadeNasc;}
    public void setEstadoNascimento(String estadoNasc){this.estadoNascimento = estadoNasc;}

/* ================= Metodo clone ================= */
	/**
	  * - Clone dados do obj parametro para this.
	 */
	public Jogador clone(){
		Jogador tmp = new Jogador();
		tmp.id     = this.getId();
        tmp.altura = this.getAltura();
        tmp.peso   = this.getPeso();
        tmp.anoNascimento = this.getAnoNascimento();
        tmp.nome = this.getNome();
        tmp.universidade = this.getUniversidade();
        tmp.cidadeNascimento = this.getCidadeNascimento();
		tmp.estadoNascimento = this.getEstadoNascimento();
		return tmp;
	} // end clone()

/* ================= Metodo imprimir ================= */
	/**
	  * - Imprime todos elementos contidos no obejeto.
	  */
	public void imprimir(){
		System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this.id, this.nome, this.altura, this.peso, this.anoNascimento, this.universidade, this.cidadeNascimento, this.estadoNascimento);
	} // end imprimir()

/* ============== (Start) ler ============== */
	/**
	 * - Metodo que retorna um array com os index dos marcadores dos elementos de uma linha
	 * @param line - Linha a ser manipulada.
	 * @return Array com os index dos marcadores dos elementos.
	 */
	static int[] getVirgulas(String line){
		int[] indexVirg = new int[7];
		for(int i = 0; i < indexVirg.length; i++){
			if(i == 0)
				indexVirg[i] = line.indexOf(',');
			else
				indexVirg[i] = line.indexOf(',', indexVirg[i-1] + 1);
			//MyIO.print(indexVirg[i] + " ");
		} // end for		
		return indexVirg;
	} // end getVirgulas()

	/**
	 * - Metodo que retorna o id em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	public static int getIdFromLine(String fileLine){
		String strId = "";
		
		for(int i = 0; i < 4; i++){
			if(fileLine.charAt(i) != ',')
				strId += fileLine.charAt(i);
			else
				i = 4;
		} // end for
		return Integer.parseInt(strId); 
	} // end getIdFromLine()

	/**
	 * - Metodo que retorna o nome em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static String getNomeFromLine(String line, int[] indexMarker){
		int i = indexMarker[0] + 1;
		String str = "";
		while(i < indexMarker[1]){
			str += line.charAt(i);
			i++;
		} // end while
		
		if(str.equals(""))
			str += "nao informado";

		return str;
	} // end getIdFromLine()
	
	/**
	 * - Metodo que retorna o altura em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static int getAlturaFromLine(String line, int[] indexMarker){
		int i = indexMarker[1] + 1;
		String str = "";
		while(i < indexMarker[2]){
			str += line.charAt(i);
			i++;
		} // end while
		
		return Integer.parseInt(str);
   	} // end getIAlturaFromLine()

	/**
	 * - Metodo que retorna o peso em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static int getPesoFromLine(String line, int[] indexMarker){
		int i = indexMarker[2] + 1;
		String str = "";
		while(i < indexMarker[3]){
			str += line.charAt(i);
			i++;
		} // end while
		
		return Integer.parseInt(str);
   	} // end getIPesoFromLine()

	/**
	 * - Metodo que retorna o Ano de Nascimento em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static int getAnoNascimentoFromLine(String line, int[] indexMarker){
		int i = indexMarker[4] + 1;
		String str = "";
		while(i < indexMarker[5]){
			str += line.charAt(i);
			i++;
		} // end while
		
		return Integer.parseInt(str);
   	} // end getAnoNascimentoFromLine()

	/**
	 * - Metodo que retorna a Universidade em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static String getUniversidadeFromLine(String line, int[] indexMarker){
		int i = indexMarker[3] + 1; 
		String str = "";
		
		while(i < indexMarker[4]){
			str += line.charAt(i);
			i++;
		} // end while
		
		if(str.equals(""))
			str += "nao informado";
		
		return str;
   	} // end getUniversidadeFromLine()

	/**
	 * - Metodo que retorna a Cidade de Nascimento em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static String getCidadeNascimentoFromLine(String line, int[] indexMarker){
		int i = indexMarker[5] + 1;
		String str = "";

		while(i < indexMarker[6]){
			str += line.charAt(i);
			i++;
		} // end while
		
		if(str.equals(""))
			str += "nao informado";
		
		return str;
   	} // end getCidadeNascimentoFromLine()

	/**
	 * - Metodo que retorna o Estado de Nascimento em uma linha.
	 * @param line - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha 
	 * @return O elemento desejado
	 */
	static String getEstadoNascimentoFromLine(String line, int[] indexMarker){
		int i = indexMarker[6] + 1;
		String str = "";
		while(i < line.length()){
			str += line.charAt(i);
			i++;
		} // end while
		
		if(str.equals(""))
			str += "nao informado";
		
		return str ;
   	} // end getEstadoNascimentoFromLine()

	/**
	* - Metodo que procura em um arquivo o ID de um jogador e cria um objeto Jogador para o mesmo
	* @param idInput - Id do jogador
	* @param fileName - Diretorio do arquivo
	*/
	public void ler(int idInput){
		int idFile = 0;
		String fileLine = "", fileName = "/tmp/players.csv";
		boolean idFound = false;

        if(idInput != -1){
            Arq.openRead(fileName);
            Arq.readLine();

            while(idFound == false && Arq.hasNext()){
                fileLine = Arq.readLine();
        
                idFile = Jogador.getIdFromLine(fileLine); 
                if(idFile == idInput)
                    idFound = true;
            } // end while
            
            Arq.close();

            if(idFound == true)
                makeJogador(fileLine);
            else
                ler(idInput - 1);
        } // end if
                
	} // end ler()

/* ============== (End) ler ============== */
	/**
	 * - Metodo que seleciona cada elemento de uma String e os passa para um objeto Jogador
	 * @param fileLine
	 */
	void makeJogador(String fileLine){
		int[] indexMarker = getVirgulas(fileLine);
		
		this.setId(getIdFromLine(fileLine));
		this.setNome(getNomeFromLine(fileLine, indexMarker));
		this.setAltura(getAlturaFromLine(fileLine, indexMarker));
		this.setPeso(getPesoFromLine(fileLine, indexMarker));
		this.setAnoNascimento(getAnoNascimentoFromLine(fileLine, indexMarker));
		this.setUniversidade(getUniversidadeFromLine(fileLine, indexMarker));
		this.setCidadeNascimento(getCidadeNascimentoFromLine(fileLine, indexMarker));
		this.setEstadoNascimento(getEstadoNascimentoFromLine(fileLine, indexMarker));
	} // end makeJogador()
} // end Jogador
 

class Celula{
	public Celula prox;
	public Jogador elemento;
	
	Celula(Jogador player){
		this.prox = new Celula();
		this.elemento = player;
	}

	Celula(){
		this.prox = null;
		this.elemento = null;
	}
} // end class Celula


class ListaFlexivel{
    private Celula primeiro, ultimo;
    
    ListaFlexivel(){
		primeiro = new Celula();
		ultimo = primeiro;
	} // end ListaLinear()
	
	public int tamanho(){
		int tamanho = 0;
		for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
		return tamanho;
	} // end tamanho

	public void swappNode(Celula cell_1, Celula cell_2){
		Jogador tmp = cell_1.elemento.clone();
		cell_1.elemento = cell_2.elemento.clone();
		cell_2.elemento = tmp;
		tmp = null;
	} // end swappNode()

	public Celula getNode(int posicao){
		Celula node = null;
		int tam = tamanho();
		if((posicao < 0) && (posicao > tam)){
			System.out.println("ERRO: (getNode) Posicao invalida");
		} else if(posicao == 0){
			node = this.primeiro.prox;
		} else if(posicao == tam){
			node = this.ultimo;
		} else{
			Celula i = this.primeiro.prox;
			for(int j = 0; j < posicao; j++, i = i.prox); 
			node = i;
			i = null;
		} // end else

		return node;
	} // end getNode()  
    
    public void mostrar(){
        for(Celula i = primeiro.prox; i.prox != null; i = i.prox){
			i.elemento.imprimir();
        } // end for
    } // end mostrar()

    public void inserirInicio(Jogador player){
		Celula tmp = new Celula(player);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo){
			ultimo = tmp;
		} // end if
		tmp = null;
	} // end inserirInicio()

    public void inserirFim(Jogador player){
		ultimo.prox = new Celula(player);
		ultimo = ultimo.prox;
	} // end inserirFim()

    public void inserir(Jogador player, int posicao){
		int tamanho = tamanho();
		if((posicao < 0) || (posicao > tamanho)){
			System.out.printf("ERRO: (I*) Posicao invalida.");
		} else if(posicao == 0){
			inserirInicio(player);
		} else if(posicao == tamanho){
			inserirFim(player);
		} else{
			
			Celula i = primeiro;
			for(int j = 0; j < posicao; i = i.prox, j++);
			
			Celula tmp = new Celula(player);
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = null;
		} // end else
	} // end inserir()
	
	
    public Jogador removerInicio(){
		Jogador playerTmp = null;

		if(primeiro == ultimo){
			System.out.println("ERRO: (RI) Lista nao populada.");
		} else{
			Celula tmp = primeiro;
			primeiro = primeiro.prox;
			playerTmp = primeiro.elemento.clone();
			tmp.prox = null;
			tmp = null;
		} // end else
		
		return playerTmp;
	} // end removerInicio()
	
    public Jogador removerFim(){
		Jogador playerTmp = null;
		
		if(primeiro == ultimo){
			System.out.println("ERRO: (RF) Lista nao populada.");
		} else{
			Celula i;
			for(i = primeiro; i.prox != ultimo; i = i.prox);
			
			playerTmp = ultimo.elemento.clone();
			ultimo = i;
			i = ultimo.prox = null;
		} // end else
		
		return playerTmp;
	} // end removerFim()
	
    public Jogador remover(int posicao){
		Jogador playerTmp = null;
		int tamanho = tamanho();
		
		if((posicao < 0) || (posicao > tamanho)){
			System.out.printf("ERRO: (R*) Posicao invalida.");
		} else if(posicao == 0){
			playerTmp = removerInicio();
		} else if(posicao == tamanho){
			playerTmp = removerFim();
		} else{
			
			Celula i = primeiro;
			for(int j = 0; j < posicao; i = i.prox, j++);
			
			Celula tmp = i.prox;
			playerTmp = tmp.elemento.clone();
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		} // end else
		return playerTmp;
	} // end remover()

} // end class ListaFlexivel()

public class TP03Q11{
	/**
	 * - Metodo verifica se String é igual a "FIM".
	 * @param s
	 * @return true ou false caso String seja igual a "FIM"
	 */
	private static boolean isFIM(String s){
		return(s.equals("FIM"));
	} // end isFIM()

	/**
	 * Metodo retorna o codigo de comando de uma string.
	 * @param line - String a ser verificada
	 * @return valor inteiro correspondente ao codigo de comando
	 */
	private static int getComando(String line){
		int result = 0;
		String[] str = line.split("\\s+");

		switch (str[0]) {
			case "II":
				result = 1;
				break;
			case "IF":
				result = 3;
				break;
			case "I*":
				result = 5;
				break;
			case "RI":
				result = 2;
				break;
			case "RF":
				result = 4;
				break;
			case "R*":
				result = 6;
				break;
			default:
				break;
		} // end switch

		// System.out.println("codigo: " + line + " - " + str[0] + " > " + result);

		return result;
	} // end getComando()

	/**
	 * Metodo retorna o id de comando de uma string.
	 * @param line - String a ser verificada
	 * @param comando - codiigo de comando
	 * @return - valor inteiro correspondente ao id
	 */
	private static int getId(String line, int comando){
		int result = 0;
		String[] str = line.split("\\s+");

		if(comando == 1 || comando == 3){
			result = Integer.parseInt(str[1]);
		} else if(comando == 5){
			result = Integer.parseInt(str[2]);
		} //end else if

		// System.out.println("Id: " + str[1] + " (" + result + ")");

		return result;
	} // end getId()

	/**
	 * - Metodo retorna a posicao dentro da string
	 * @param line - String a ser verificada
	 * @param comando - codiigo de comando
	 * @return - valor inteiro correspondente a posicao
	 */
	private static int getPosicao(String line, int comando){
		int result = 0;
		String[] str = line.split("\\s+");

		if(comando >= 5){
			result = Integer.parseInt(str[1]);
		} // end if

		// System.out.println("Posicao: " + str[1] + " (" + result + ")");

		return result;
	} // end getId()

	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getPrimeiraEntrada(ListaFlexivel lista){
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while(!isFIM(input)){
			id = Integer.parseInt(input);	

			Jogador tmp = new Jogador();

			tmp.ler(id);
			lista.inserirFim(tmp);
			
			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()
	
	/**
	 * - Metodo para pegar a segunda parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getSegundaEntrada(ListaFlexivel lista){
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

			comando = getComando(input);
			id      = getId(input, comando);
			posicao = getPosicao(input, comando);

			switch (comando){
				case 1:
					tmp.ler(id);
					lista.inserirInicio(tmp);
					break;
				case 2:
					tmp = lista.removerInicio();
					System.out.println("(R) " + tmp.getNome());
					break;
				case 3:
					tmp.ler(id);
					lista.inserirFim(tmp);
					break;
				case 4:
					tmp = lista.removerFim();
					System.out.println("(R) " + tmp.getNome());
					break;
				case 5:
					tmp.ler(id);
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
			n--;
		} // end while
	} // end getPrimeira Entrada()

	private static void quicksort_recur(ListaFlexivel lista, int esq, int dir, RecordAlgoritmo record){
		int i = esq, j = dir;
		String pivoEstado = lista.getNode((esq+dir)/2).elemento.getEstadoNascimento();
		String pivoNome = lista.getNode((esq+dir)/2).elemento.getNome();
		record.sumMov(2);

		while(i <= j){
			while((lista.getNode(i).elemento.getEstadoNascimento().compareTo(pivoEstado) < 0) || 
				  ((lista.getNode(i).elemento.getEstadoNascimento().compareTo(pivoEstado) == 0) && 
				  (lista.getNode(i).elemento.getNome().compareTo(pivoNome) < 0)) ){ 
				// System.out.println("i: " + i);
				// System.out.println(lista.getNode(i).elemento.getEstadoNascimento() + " -- " + pivoEstado);
				// System.out.println(lista.getNode(i).elemento.getNome() + " -- " + pivoNome);
				record.sumCmp(3);
				i++;

			} // end while

			// System.out.println("======================\npassou i: "+i+" | j: "+j+"\n======================");

			while((lista.getNode(j).elemento.getEstadoNascimento().compareTo(pivoEstado) > 0) || 
				  ((lista.getNode(j).elemento.getEstadoNascimento().compareTo(pivoEstado) == 0) && 
				  (lista.getNode(j).elemento.getNome().compareTo(pivoNome) > 0)) ){
				// System.out.println("j: " + j);
				// System.out.println(lista.getNode(j).elemento.getEstadoNascimento() + " -- " + pivoEstado);
				// System.out.println(lista.getNode(j).elemento.getNome() + " -- " + pivoNome);
				record.sumCmp(3);
				j--;
			} // end while

			// System.out.println("======================\npassou j: "+j+" | i: "+i+"\n======================");

			if(i <= j){
				lista.swappNode(lista.getNode(i), lista.getNode(j));
				i++; j--;
			} // end if
		} // end while

		if(esq < j)
			quicksort_recur(lista, esq, j, record);
		if(i < dir)
			quicksort_recur(lista, i, dir, record);
	} // end quicksort_recur()

	/**
	 * - Metodo que ordena (quicksort) uma lista dupla, tendo como key o Estado de nascimento.
	 * @param lista - lista dupla.
	 * @param record - Armazenas os status do metodo.
	 */
	private static void quicksort(ListaFlexivel lista, RecordAlgoritmo record){
		quicksort_recur(lista, 0, lista.tamanho() - 1, record);
	} // end quicksort_Parcial()

	public static void main(String []arg){

		RecordAlgoritmo record = new RecordAlgoritmo();
		ListaFlexivel lista = new ListaFlexivel();
		
		getPrimeiraEntrada(lista);	
		
		record.startCurrentTime();
		quicksort(lista, record);
		record.endCurrentTime();

		lista.mostrar();
		record.recordTime("699415_quicksort2.txt");
	} // end main()
}








