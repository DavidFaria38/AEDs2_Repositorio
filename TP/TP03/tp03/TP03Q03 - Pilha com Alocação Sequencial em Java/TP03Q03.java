class PilhaLinear{
    private Jogador[] array;
    private int tamanho;
    
    PilhaLinear(int len){
        this.array = new Jogador[len];
        this.tamanho = 0;
    } // end ListaLinear()
    
    PilhaLinear(){
        this(0);
    } // end ListaLinear()
    
    public void mostrar(){
        for(int i = 0; i < this.tamanho; i++){
            System.out.print("[" + i + "]");
            array[i].imprimir();
            System.out.println("");
        } // end for
    } // end mostrar()

    public void inserir(Jogador player) throws Exception {
        if(this.tamanho >= array.length)
            throw new Exception("ERRO: Pilha esta cheia.");
        else{
            array[this.tamanho] = player.clone();
            this.tamanho += 1;
        } // end else
    } // end inserir ()
    
    public Jogador remover() throws Exception{
        Jogador tmp = null;

		// System.out.print("=== tamanho: " + this.tamanho + " ===");
        if(this.tamanho < 0)
		throw new Exception("ERRO: Pilha esta vazia.");
        else{
			tmp = this.array[this.tamanho - 1];
            this.array[this.tamanho - 1] = null;
            this.tamanho = this.tamanho - 1;
        } // end else
		
        return tmp;
    } // end remover()

} // end class PilhaLinear()

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

public class TP03Q03{
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

		if(str[0].charAt(0) == 'I'){
			result = 1;
		} else if(str[0].charAt(0) == 'R'){
			result = 2;
		} //end else
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
		} else{
			result = 0;
		}// end else

		return result;
	} // end getId()


	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos jogadores.
	 * @param player - Array de objeto
	 * @return Valor inteiro representando a quantidade de registros realizados.
	 */
	private static void getPrimeiraEntrada(PilhaLinear pilha){
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while(!isFIM(input)){
			id = Integer.parseInt(input);	

			Jogador tmp = new Jogador();

			tmp.ler(id);
			// tmp.imprimir();
			try {
				pilha.inserir(tmp);
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
	private static void getSegundaEntrada(PilhaLinear pilha){
		int id, comando, n;
		String input = "";
		/* diagrama de codigos para comando: */ 
		// (I) Inserir = 1 
		// (R) Remover = 2 
		
		n = Integer.parseInt(MyIO.readLine());
		while(n > 0){
			input = MyIO.readLine();

			Jogador tmp = new Jogador();

			comando = getComando(input);
			id      = getId(input, comando);

			try {
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
			} catch (Exception e) {
				System.out.println(e);
			} // end catch

			n--;
		} // end while
	} // end getPrimeira Entrada()
	

	public static void main(String []arg){

		PilhaLinear pilha = new PilhaLinear(500);
		
		getPrimeiraEntrada(pilha);	
		getSegundaEntrada(pilha);


		pilha.mostrar();
	} // end main()
}








