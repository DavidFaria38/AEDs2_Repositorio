/**
 * - Class para gravar valores de movimentações e comparações.
 */
class RecordAlgoritmo{
	private int cmp;
	private int mov;
	private double start;
	private double end;
	private String fileName;

/* ================= Construtores ================= */
	public RecordAlgoritmo(String fileName){
		mov = cmp = 0;
		this.fileName = fileName;
	} // end RecordAlgoritmo()
	public RecordAlgoritmo(){
		this("Status_Algoritmo.txt");
	} // end RecordAlgoritmo()

/* ================= Metodos get ================= */
	public int getComp(){return this.cmp;}
	public int getMov(){return this.mov;}
	
/* ================= Metodos set ================= */
	public void sumCmp(int value){this.cmp += value;}
	public void sumMov(int value){this.mov += value;}

/* ================= Metodos time ================= */
	public void startRecordingTime(){this.start = System.currentTimeMillis(); } 
	public void endRecordingTime(){this.end = System.currentTimeMillis(); }
	
/* ================================================ */
	/**
	 * - Metodo que grava em um arquivo o tempo de execução do algoritmo de ordenação, movimentações e comparações.
	 */
	public void makeFile(){
		Arq.openWrite(fileName);
		// Arq.println("699415\t" + (end-start)/1000 + "\t" + this.cmp + "\t" + this.mov);
		Arq.println("699415\t" + (end-start)/1000 + "\t" + this.cmp);
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
 

class No{
	public No dir;
	public No esq;
	public Jogador elemento;
	
	No(Jogador player){
		this.dir = this.esq = null;
		this.elemento = player;
	}

	No(){
		this(new Jogador());
	}
} // end class No


class ArvoreBinaria{
    private No raiz;
    
    ArvoreBinaria(){
		raiz = null;
	} // end ArvoreBinaria()
	

	public void caminharCentral(){
		caminharCentral(raiz);
	} // end caminharCentral()
	public void caminharCentral(No i){
		if(i != null){
			caminharCentral(i.esq);
			System.out.println(i.elemento.getNome());
			caminharCentral(i.dir);
		} // end if
	} // end caminharCentral()


	// retorna tamanho da arvore
	public int tamanho(){
		return tamanho(raiz);
	} // end tamanho()
	private int tamanho(No i){
		int tamanho = 0;
		if(i == null){
			tamanho = 0;
		} else{
			tamanho = tamanho(i.esq) + 1 + tamanho(i.dir);
		} // end else
		
		return tamanho;
	} // end tamanho()
    
    

	public void inserir(Jogador player, RecordAlgoritmo record){
		raiz = inserir(player, raiz, record);
	} // end inserir()

	private No inserir(Jogador player, No i, RecordAlgoritmo record){
		if(i == null){
			i = new No(player);
		} else if(i.elemento.getNome().compareTo(player.getNome()) > 0){ 
			i.esq = inserir(player, i.esq, record);
		} else if(i.elemento.getNome().compareTo(player.getNome()) < 0){
			i.dir = inserir(player, i.dir, record);
		} else{
			System.out.println("ERRO: insercao.");
		} // end else

		record.sumCmp(2);
		return i;
	} // end inserir()
  

} // end class ArvoreBinaria()


public class TP04Q05{

	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos jogadores.
	 * @param tree - Estrutura de arvore
	 */
	private static void getPrimeiraEntrada(ArvoreBinaria tree, RecordAlgoritmo record){
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while(!input.equals("FIM")){
			record.sumCmp(1);

			id = Integer.parseInt(input);	

			Jogador tmp = new Jogador();

			tmp.ler(id);
			tree.inserir(tmp, record);
			
			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()
	
	/**
	 * - Metodo para pegar a segunda parte da entrada, realiza o registo dos jogadores.
	 * @param tree - Estrutura arvore binaria.
	 * @param record - Armazena comparacoes e tempo de execucao do algoritmo.
	 */
	private static void getSegundaEntrada(){
		String input = "";

		input = MyIO.readLine();
		while(!input.equals("FIM")){
			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()
	

	public static void main(String []arg){
		RecordAlgoritmo record = new RecordAlgoritmo("699415_treesort.txt");
		ArvoreBinaria tree = new ArvoreBinaria();
		
		record.startRecordingTime();
		getPrimeiraEntrada(tree, record);	
		// getSegundaEntrada(); // para finalizar (desnecessariamente) de pegar a segunda entrada
		tree.caminharCentral(); 
		record.endRecordingTime();

		record.makeFile();
		
	} // end main()
}








