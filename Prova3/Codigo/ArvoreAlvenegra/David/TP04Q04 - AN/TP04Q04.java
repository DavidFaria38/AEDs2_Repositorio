/**
 * - Class para gravar valores de movimentações e comparações.
 */
class RecordAlgoritmo {
	private int cmp;
	private int mov;
	private double start;
	private double end;
	private String fileName;

	/* ================= Construtores ================= */
	public RecordAlgoritmo(String fileName) {
		mov = cmp = 0;
		this.fileName = fileName;
	} // end RecordAlgoritmo()

	public RecordAlgoritmo() {
		this("Status_Algoritmo.txt");
	} // end RecordAlgoritmo()

	/* ================= Metodos get ================= */
	public int getComp() {
		return this.cmp;
	}

	public int getMov() {
		return this.mov;
	}

	/* ================= Metodos set ================= */
	public void sumCmp(int value) {
		this.cmp += value;
	}

	public void sumMov(int value) {
		this.mov += value;
	}

	/* ================= Metodos time ================= */
	public void startRecordingTime() {
		this.start = System.currentTimeMillis();
	}

	public void endRecordingTime() {
		this.end = System.currentTimeMillis();
	}

	/* ================================================ */
	/**
	 * - Metodo que grava em um arquivo o tempo de execução do algoritmo de
	 * ordenação, movimentações e comparações.
	 */
	public void makeFile() {
		Arq.openWrite(fileName);
		// Arq.println("699415\t" + (end-start)/1000 + "\t" + this.cmp + "\t" +
		// this.mov);
		Arq.println("699415\t" + (end - start) / 1000 + "\t" + this.cmp);
		Arq.close();
	} // end recordTime()
} // end recordAlgoritmo

class Jogador {
	private int id;
	private int altura;
	private int peso;
	private int anoNascimento;
	private String nome;
	private String universidade;
	private String cidadeNascimento;
	private String estadoNascimento;

	/* ================= Construtores ================= */
	public Jogador() {
		this.id = -1;
		this.altura = -1;
		this.peso = -1;
		this.anoNascimento = -1;
		this.nome = "";
		this.universidade = "";
		this.cidadeNascimento = "";
		this.estadoNascimento = "";
	} // end Jogador()

	public Jogador(int id, String nome, int altura, int peso, int anoNasc, String uni, String cidadeNasc,
			String estadoNasc) {
		this.id = id;
		this.altura = altura;
		this.peso = peso;
		this.anoNascimento = anoNasc;
		this.nome = nome;
		this.universidade = uni;
		this.cidadeNascimento = cidadeNasc;
		this.estadoNascimento = estadoNasc;
	} // end Jogador()

	/* ================= Metodos get ================= */
	public int getId() {
		return this.id;
	}

	public int getAltura() {
		return this.altura;
	}

	public int getPeso() {
		return this.peso;
	}

	public int getAnoNascimento() {
		return this.anoNascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public String getUniversidade() {
		return this.universidade;
	}

	public String getCidadeNascimento() {
		return this.cidadeNascimento;
	}

	public String getEstadoNascimento() {
		return this.estadoNascimento;
	}

	/* ================= Medotos set ================= */
	public void setId(int id) {
		this.id = id;
	}

	public void setAltura(int alt) {
		this.altura = alt;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setAnoNascimento(int anoNasc) {
		this.anoNascimento = anoNasc;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUniversidade(String uni) {
		this.universidade = uni;
	}

	public void setCidadeNascimento(String cidadeNasc) {
		this.cidadeNascimento = cidadeNasc;
	}

	public void setEstadoNascimento(String estadoNasc) {
		this.estadoNascimento = estadoNasc;
	}

	/* ================= Metodo clone ================= */
	/**
	 * - Clone dados do obj parametro para this.
	 */
	public Jogador clone() {
		Jogador tmp = new Jogador();
		tmp.id = this.getId();
		tmp.altura = this.getAltura();
		tmp.peso = this.getPeso();
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
	public void imprimir() {
		System.out.print(" ## " + this.nome + " ## " + this.altura + " ## " + this.peso + " ## " + this.anoNascimento
				+ " ## " + this.universidade + " ## " + this.cidadeNascimento + " ## " + this.estadoNascimento + " ##");
	} // end imprimir()

	/* ============== (Start) ler ============== */
	/**
	 * - Metodo que retorna um array com os index dos marcadores dos elementos de
	 * uma linha
	 * 
	 * @param line - Linha a ser manipulada.
	 * @return Array com os index dos marcadores dos elementos.
	 */
	static int[] getVirgulas(String line) {
		int[] indexVirg = new int[7];
		for (int i = 0; i < indexVirg.length; i++) {
			if (i == 0)
				indexVirg[i] = line.indexOf(',');
			else
				indexVirg[i] = line.indexOf(',', indexVirg[i - 1] + 1);
			// MyIO.print(indexVirg[i] + " ");
		} // end for
		return indexVirg;
	} // end getVirgulas()

	/**
	 * - Metodo que retorna o id em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	public static int getIdFromLine(String fileLine) {
		String strId = "";

		for (int i = 0; i < 4; i++) {
			if (fileLine.charAt(i) != ',')
				strId += fileLine.charAt(i);
			else
				i = 4;
		} // end for
		return Integer.parseInt(strId);
	} // end getIdFromLine()

	/**
	 * - Metodo que retorna o nome em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static String getNomeFromLine(String line, int[] indexMarker) {
		int i = indexMarker[0] + 1;
		String str = "";
		while (i < indexMarker[1]) {
			str += line.charAt(i);
			i++;
		} // end while

		if (str.equals(""))
			str += "nao informado";

		return str;
	} // end getIdFromLine()

	/**
	 * - Metodo que retorna o altura em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static int getAlturaFromLine(String line, int[] indexMarker) {
		int i = indexMarker[1] + 1;
		String str = "";
		while (i < indexMarker[2]) {
			str += line.charAt(i);
			i++;
		} // end while

		return Integer.parseInt(str);
	} // end getIAlturaFromLine()

	/**
	 * - Metodo que retorna o peso em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static int getPesoFromLine(String line, int[] indexMarker) {
		int i = indexMarker[2] + 1;
		String str = "";
		while (i < indexMarker[3]) {
			str += line.charAt(i);
			i++;
		} // end while

		return Integer.parseInt(str);
	} // end getIPesoFromLine()

	/**
	 * - Metodo que retorna o Ano de Nascimento em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static int getAnoNascimentoFromLine(String line, int[] indexMarker) {
		int i = indexMarker[4] + 1;
		String str = "";
		while (i < indexMarker[5]) {
			str += line.charAt(i);
			i++;
		} // end while

		return Integer.parseInt(str);
	} // end getAnoNascimentoFromLine()

	/**
	 * - Metodo que retorna a Universidade em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static String getUniversidadeFromLine(String line, int[] indexMarker) {
		int i = indexMarker[3] + 1;
		String str = "";

		while (i < indexMarker[4]) {
			str += line.charAt(i);
			i++;
		} // end while

		if (str.equals(""))
			str += "nao informado";

		return str;
	} // end getUniversidadeFromLine()

	/**
	 * - Metodo que retorna a Cidade de Nascimento em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static String getCidadeNascimentoFromLine(String line, int[] indexMarker) {
		int i = indexMarker[5] + 1;
		String str = "";

		while (i < indexMarker[6]) {
			str += line.charAt(i);
			i++;
		} // end while

		if (str.equals(""))
			str += "nao informado";

		return str;
	} // end getCidadeNascimentoFromLine()

	/**
	 * - Metodo que retorna o Estado de Nascimento em uma linha.
	 * 
	 * @param line        - Linha a ser pego o elemento desejado.
	 * @param indexMarker - Index dos marcadores dos elementos da linha
	 * @return O elemento desejado
	 */
	static String getEstadoNascimentoFromLine(String line, int[] indexMarker) {
		int i = indexMarker[6] + 1;
		String str = "";
		while (i < line.length()) {
			str += line.charAt(i);
			i++;
		} // end while

		if (str.equals(""))
			str += "nao informado";

		return str;
	} // end getEstadoNascimentoFromLine()

	/**
	 * - Metodo que procura em um arquivo o ID de um jogador e cria um objeto
	 * Jogador para o mesmo
	 * 
	 * @param idInput  - Id do jogador
	 * @param fileName - Diretorio do arquivo
	 */
	public void ler(int idInput) {
		int idFile = 0;
		String fileLine = "", fileName = "/tmp/players.csv";
		boolean idFound = false;

		if (idInput != -1) {
			Arq.openRead(fileName);
			Arq.readLine();

			while (idFound == false && Arq.hasNext()) {
				fileLine = Arq.readLine();

				idFile = Jogador.getIdFromLine(fileLine);
				if (idFile == idInput)
					idFound = true;
			} // end while

			Arq.close();

			if (idFound == true)
				makeJogador(fileLine);
			else
				ler(idInput - 1);
		} // end if

	} // end ler()

	/* ============== (End) ler ============== */
	/**
	 * - Metodo que seleciona cada elemento de uma String e os passa para um objeto
	 * Jogador
	 * 
	 * @param fileLine
	 */
	void makeJogador(String fileLine) {
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

class No {
	public No esq, dir;
	public Jogador elemento;
	public boolean cor;

	public No() {
		this(new Jogador());
	}

	public No(Jogador elemento) {
		this(elemento, false, null, null);
	}

	public No(Jogador elemento, boolean cor) {
		this(elemento, cor, null, null);
	}

	public No(Jogador elemento, boolean cor, No esq, No dir) {
		this.cor = cor;
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
} // end class No

class Arvore {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public Arvore() {
		raiz = null;
	}


	public void pesquisar_showPath(String player, RecordAlgoritmo record){
		System.out.print(player + " raiz ");
		pesquisar_showPath(player, raiz, record);

	} // end pesquisar()
	private void pesquisar_showPath(String player, No i, RecordAlgoritmo record){		
		if(i == null){
			System.out.print("NAO\n");
		} else if(i.elemento.getNome().compareTo(player) == 0){	// player igual a elemento tree
			System.out.print("SIM\n");
		} else if(i.elemento.getNome().compareTo(player) > 0){	// player menor que elemento tree
			System.out.print("esq ");
			pesquisar_showPath(player, i.esq, record);
		} else {				 								// player maior que elemento tree
			System.out.print("dir ");
			pesquisar_showPath(player, i.dir, record);
		} // end else

		record.sumCmp(2);
	} // end pesquisar()


	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param elemento Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Jogador elemento, RecordAlgoritmo record) throws Exception {

		// Se a arvore estiver vazia
		if (raiz == null) {
			raiz = new No(elemento, false);

		// Senao, se a arvore tiver um elemento
		} else if (raiz.esq == null && raiz.dir == null) {
			// if (raiz.elemento > elemento) 
			if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0) 
				raiz.esq = new No(elemento, true);
			else 
				raiz.dir = new No(elemento, true);
			
			record.sumCmp(1);
			
		// Senao, se a arvore tiver dois elementos (raiz e dir)
		} else if (raiz.esq == null) {

			// if (raiz.elemento > elemento) {
			if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0) {
				raiz.esq = new No(elemento);
			// } else if (raiz.dir.elemento > elemento) {
			} else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome()) > 0) {
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = raiz.dir.elemento;
				raiz.dir.elemento = elemento;
			} // end else
			raiz.esq.cor = raiz.dir.cor = false;
			
			record.sumCmp(2);
			// Senao, se a arvore tiver dois elementos (raiz e esq)
		} else if (raiz.dir == null) {
			
			// if (raiz.elemento < elemento) {
			if (raiz.elemento.getNome().compareTo(elemento.getNome()) < 0) {
					raiz.dir = new No(elemento);
			// } else if (raiz.esq.elemento < elemento) {
			} else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome()) < 0) {
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = raiz.esq.elemento;
				raiz.esq.elemento = elemento;
			} // end else
			raiz.esq.cor = raiz.dir.cor = false;

			record.sumCmp(2);
		// Senao, a arvore tem tres ou mais elementos
		} else {
			inserir(elemento, null, null, null, raiz, record);
		} // end else

		raiz.cor = false;
	} // end inserir()

	private void balancear(No bisavo, No avo, No pai, No i, RecordAlgoritmo record) {

		// Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
		if (pai.cor == true) {

			// 4 tipos de reequilibrios e acoplamento
			// if (pai.elemento > avo.elemento) { // rotacao a esquerda ou direita-esquerda
			if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) { 
				// if (i.elemento > pai.elemento) 
				if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) 
					avo = rotacaoEsq(avo);
				else 
					avo = rotacaoDirEsq(avo);
				
				record.sumCmp(1);
			} else { // rotacao a direita ou esquerda-direita
				// if (i.elemento < pai.elemento) 
				if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) 
					avo = rotacaoDir(avo);
				else 
					avo = rotacaoEsqDir(avo);
				
				record.sumCmp(1);
			} // end else
			record.sumCmp(1);

			if (bisavo == null) {
				raiz = avo;
			} else {
				// if (avo.elemento < bisavo.elemento) 
				if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) 
					bisavo.esq = avo;
				else 
					bisavo.dir = avo;

				record.sumCmp(1);
			} // end else

			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		} // end if
	} // end balancear()

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param elemento Elemento a ser inserido.
	 * @param avo      No em analise.
	 * @param pai      No em analise.
	 * @param i        No em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserir(Jogador elemento, No bisavo, No avo, No pai, No i, RecordAlgoritmo record) throws Exception {
		if (i == null) {
			// if (elemento < pai.elemento)
			if (elemento.getNome().compareTo(pai.elemento.getNome()) < 0)
				i = pai.esq = new No(elemento, true);
			else 
				i = pai.dir = new No(elemento, true);
			
			record.sumCmp(1);

			if (pai.cor == true) 
				balancear(bisavo, avo, pai, i, record);
	
		} else{
			// Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
			if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				if (i == raiz) 
					i.cor = false;
				else if (pai.cor == true) 
					balancear(bisavo, avo, pai, i, record);
			} // end if
			// if (elemento < i.elemento) {
			if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
				inserir(elemento, avo, pai, i, i.esq, record);
			// } else if (elemento > i.elemento) {
			} else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
				inserir(elemento, avo, pai, i, i.dir, record);
			} else {
				throw new Exception("Erro inserrir (elemento repetido)");
			} // end else

			record.sumCmp(2);
		} // end else
	} // end inserir()

	private No rotacaoDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;

		return noEsq;
	} // end rotacaoDir()

	private No rotacaoEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	} // end rotacaoEsq()

	private No rotacaoDirEsq(No no) {
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	} // end rotacaoDirEsq()

	private No rotacaoEsqDir(No no) {
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
	} // end rotacaoEsqDir()
} // end class Arvore()

public class TP04Q04 {

	/**
	 * - Metodo para pegar a primeira parte da entrada, realiza o registo dos
	 * jogadores.
	 * 
	 * @param tree - Estrutura de arvore
	 */
	private static void getPrimeiraEntrada(Arvore tree, RecordAlgoritmo record) {
		int id = 0;
		String input = "";

		input = MyIO.readLine();
		while (!input.equals("FIM")) {
			record.sumCmp(1);

			id = Integer.parseInt(input);

			Jogador tmp = new Jogador();

			try {
				tmp.ler(id);
				tree.inserir(tmp, record);		
			} catch (Exception e) {
				System.out.println(e);
			} // end catch

			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()

	/**
	 * - Metodo para pegar a segunda parte da entrada, realiza o registo dos
	 * jogadores.
	 * 
	 * @param tree   - Estrutura arvore binaria.
	 * @param record - Armazena comparacoes e tempo de execucao do algoritmo.
	 */
	private static void getSegundaEntrada(Arvore tree, RecordAlgoritmo record) {
		String input = "";

		input = MyIO.readLine();
		while (!input.equals("FIM")) {
			record.sumCmp(1);

			tree.pesquisar_showPath(input, record);

			input = MyIO.readLine();
		} // end while
	} // end getPrimeira Entrada()

	public static void main(String[] arg) {
		RecordAlgoritmo record = new RecordAlgoritmo("699415_avinegra.txt");
		Arvore tree = new Arvore();

		record.startRecordingTime();
		getPrimeiraEntrada(tree, record);
		getSegundaEntrada(tree, record);
		record.endRecordingTime();

		record.makeFile();

	} // end main()
}
