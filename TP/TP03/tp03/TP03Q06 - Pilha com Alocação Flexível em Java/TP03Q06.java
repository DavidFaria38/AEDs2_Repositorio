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
		System.out.print(" ## " + this.nome + " ## " + this.altura + " ## " + this.peso + " ## " + this.anoNascimento + " ## " + this.universidade + " ## " + this.cidadeNascimento + " ## " + this.estadoNascimento + " ##");
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


class PilhaFlexivel{
    private Celula topo;
    
    PilhaFlexivel(){
		topo = new Celula();
	} // end pilhaLinear()
	
	public int tamanho(){
		int tamanho = 0;
		for(Celula i = topo; i != null; i = i.prox, tamanho++);
		return tamanho;
	} // end tamanho
    
    public void mostrar(){
		int j = 0;
		for(Celula i = topo; i != null; i = i.prox, j++);
		mostrar(topo, j-1);
    } // end mostrar()
    public void mostrar(Celula i, int count){
		if(i.elemento != null){
			mostrar(i.prox, count-=1);
			System.out.printf("[" + count + "]");
			i.elemento.imprimir();
			System.out.println("");
		} // end if
	} // end mostrar()


    public void inserir(Jogador player){
		Celula tmp = new Celula(player);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	} // end inserirFim()
	
    public Jogador remover(){
		Jogador playerTmp = null;

		if(topo == null){
			System.out.println("ERRO: (R) pilha nao populada.");
		} else{
			playerTmp = topo.elemento.clone();
			Celula tmp = topo;
			topo = topo.prox;
			tmp.prox = null;
			tmp = null;
		} // end else
		
		return playerTmp;
	} // end removerInicio()

} // end class PilhaFlexivel()


public class TP03Q06{
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
			case "I":
				result = 1;
				break;
			case "R":
				result = 2;
				break;
			default:
				break;
		} // end switch

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

		if(comando == 1){
			result = Integer.parseInt(str[1]);
		} // end if

		return result;
	} // end getId()

	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getPrimeiraEntrada(PilhaFlexivel pilha){
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while(!isFIM(input)){
			id = Integer.parseInt(input);	

			Jogador tmp = new Jogador();

			tmp.ler(id);
			pilha.inserir(tmp);
			
			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()
	
	/**
	 * - Metodo para pegar a segunda parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getSegundaEntrada(PilhaFlexivel pilha){
		int id, comando, posicao, n;
		String input = "";
		/* diagrama de codigos para comando: */ 
		// (I) InserirInicio = 1 
		// (R) RemoverInicio = 2 

		
		n = Integer.parseInt(MyIO.readLine());
		while(n > 0){
			input = MyIO.readLine();

			Jogador tmp = new Jogador();

			comando = getComando(input);
			id      = getId(input, comando);

			switch (comando){
				case 1:
					tmp.ler(id);
					pilha.inserir(tmp);
					break;
				case 2:
					tmp = pilha.remover();
					System.out.println("(R) " + tmp.getNome());
					break;
				default:
					System.out.println("ERRO: comando invalido");
					break;
			} // end switch
			n--;
		} // end while
	} // end getPrimeira Entrada()
	

	public static void main(String []arg){

		PilhaFlexivel pilha = new PilhaFlexivel();
		
		getPrimeiraEntrada(pilha);	
		getSegundaEntrada(pilha);

		pilha.mostrar();
	} // end main()
}








