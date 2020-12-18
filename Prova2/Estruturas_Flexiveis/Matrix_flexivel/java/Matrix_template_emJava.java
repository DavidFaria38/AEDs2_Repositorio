 
class Celula{
	public Celula dir, esq, sup, inf;
	public int elemento;
	
	Celula(int elemento){
		this(elemento, null, null, null, null);
	}
	
	Celula(){
		this(-1, null, null, null, null);
	}

	Celula(int elemento, Celula esq, Celula dir, Celula sup, Celula inf){
		this.dir = this.esq = this.sup = this.inf = null;
		this.elemento = elemento;
	}
} // end class Celula


class Matrix{
    public Celula inicio;
	public int linha, coluna;


    Matrix(int linha, int coluna){
		this.inicio = new Celula();
		this.linha = linha;
		this.coluna = coluna;

		popularMatrix();
	} // end ListaLinear()

	private void popularMatrix_lin(Celula i, int lin, int col){
		if(col < coluna-1){
			// verifica se exite elemento i.sup - caso true tmp recebe i.sup.dir
			Celula tmp = ((i.sup != null) && (col < (coluna-1))) ? i.sup.dir : null;
			
			// cria nova celula e i.dir aponta para mesma
			i.dir = new Celula(-1, i, null, tmp, null); 
			//caso tmp indiferente de null, faz com que o superior de i.dir o aponte
			tmp = (tmp != null) ? tmp.inf = i.dir : null;
			popularMatrix_lin(i.dir, lin, col+=1);
		} // end if
	} // end popularMatrix

	private void popularMatrix(Celula i, int lin, int col){
		// popula linha x de matrix
		popularMatrix_lin(i, lin, 0);

		if(lin < linha-1){
			// i.inf aponta para nova celula onde a mesma aponta para i.inf
			i.inf = new Celula(-1, null, null, i, null); 
			popularMatrix(i.inf, lin+=1, col);
		} // end if
	} // end popularMatrix
	
	/**
	 * - Metodo popula matrix com Celulas vazias
	 */
	private void popularMatrix(){
		popularMatrix(inicio, 0, 0);
	} // end popularMatrix

	/**
	 * - Metodo troca elemento de duas celula
	 * @param cell_1 - Celula_a
	 * @param cell_2 - Celula_b
	 */
	public void swappNode(Celula cell_1, Celula cell_2){
		int tmp = cell_1.elemento;
		cell_1.elemento = cell_2.elemento;
		cell_2.elemento = tmp;
	} // end swappNode()

	/**
	 * - Metodo retorna ponteiro de matrix na coordenada lin - col
	 * @param lin - linha matrix
	 * @param col - coluna matrix
	 * @return - Celula no
	 * @throws Exception - Excecao casolinha ou coluna nao sejam validas
	 */
	public Celula getNode(int lin, int col) throws Exception{
		Celula node = inicio;
		
		if((lin < 0 && lin >= linha) &&
			(col < 0 && col >= coluna)){
			throw new Exception("ERRO: linha ou coluna em matrix invalida");
		} // end if
		
		for(int j = 0; j < lin; j++, node = node.inf);
		for(int k = 0; k < col; k++, node = node.dir);

		return node;
	} // end getNode()
	

	private void mostrar_lin(Celula i, int col){
		// if(col < coluna){
		if(i != null){
			System.out.print(i.elemento + " ");
			mostrar_lin(i.dir, col+=1);
		} // end if
	} // end mostrar_lin()
	private void mostrar(Celula i){
		if(i != null){
			mostrar_lin(i, 0);
			System.out.print("\n");
			mostrar(i.inf);
		} // end if
	} // end mostrar
	
	/**
	 * - Mostar matrix
	 */
    public void mostrar(){
		mostrar(inicio);
	} // end mostrar()

	public boolean isQuadrada(){
		return (this.linha == this.coluna);
	} // end isQuadrada()

	/**
	 * - Metodo le entradas e as insere na matrix  
	 */
	public void inserirElementos_padrao(){
		String input = "";
		String inputSplit[];

		for(int i = 0; i < linha; i++){
			input = MyIO.readLine();
			inputSplit = input.split(" ");
		
			for(int j = 0; j < coluna; j++){
				inserir(i, j, Integer.parseInt(inputSplit[j]));
			} // end for

		} // end for
	} // end inserirElementos_padrao() 

	/**
	 * - Metodo retorna nova matrix com a soma de duas matrizes
	 * @param matrix - matrix para somar
	 * @return - nova matrix soma
	 * @throws Exception - caso this e matrix nao seja quadradas
	 */
	public Matrix soma(Matrix matrix) throws Exception{
		Matrix soma = new Matrix(linha, coluna);

		if((this.isQuadrada() == false) && (matrix.isQuadrada() == false)){
			System.out.println("ERRO: matrizes nao sao quadradas");
		} // end if

		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				soma.inserir(i, j, (this.getNode(i, j).elemento + matrix.getNode(i, j).elemento));
			} // end for
		} // end for
	
		return soma;
	} // end soma
	
	/**
	 * - Metodo retorna nova matrix com a multiplicacao de duas matrizes
	 * @param matrix - matrix para multiplicar
	 * @return - nova matrix multiplicada
	 * @throws Exception - caso this e matrix nao seja quadradas
	 */
	public Matrix multiplicacao(Matrix matrix) throws Exception{
		Matrix multiplicacao = new Matrix(linha, coluna);
		int i, j, k, sum = 0;

		if((this.isQuadrada() == false) && (matrix.isQuadrada() == false)){
			System.out.println("ERRO: matrizes nao sao quadradas");
		} // end if

		for (i = 0; i < linha; i++) {
			for (j = 0; j < linha; j++) {
				for (k = 0; k < linha; k++){
					// System.out.print(this.getNode(i, k).elemento + " * " + matrix.getNode(k, j).elemento + " = " + (this.getNode(i, k).elemento * matrix.getNode(k, j).elemento) + "\t");
					sum += (this.getNode(i, k).elemento * matrix.getNode(k, j).elemento);
				} // end for
				// System.out.print("\n");
				multiplicacao.inserir(i, j, sum);
				sum = 0;
			} // end for
		} // end for
	
		return multiplicacao;
	} // end soma

	/**
	 * - Metodo mostrar diagonal principal de matrix
	 * @throws Exception - Caso matrix nao for quadrada
	 */
	public void mostrar_DiagonalPrincipal() throws Exception{
		if(isQuadrada() == false){
			System.out.println("ERRO: matriz nao eh quadrada");
		} // end if

		for(int i = 0; i < linha; i++){
			System.out.print(getNode(i, i).elemento + " ");
		} // end for

		System.out.println("");
	} // end mostrarDiagonalPrincipal()
  
	/**
	 * - Metodo mostrar diagonal secundaria de matrix
	 * @throws Exception - Caso matrix nao for quadrada
	 */
	public void mostrar_DiagonalSecundaria() throws Exception{
		int i, j;
		
		if(isQuadrada() == false){
			System.out.println("ERRO: matriz nao eh quadrada");
		} // end if

		for(i = 0, j = linha-1; j >= 0; j--, i++){
			System.out.print(getNode(i, j).elemento + " ");
		} // end for

		System.out.println("");
	} // end mostrarDiagonalSecundaria()
	
	/**
	 * - Metodo insere elemeto de matriz
	 * @param lin - linha matriz
	 * @param col - coluna matriz
	 * @param elemento - elemento a ser inserido
	 * @return - elemento retirado
	 */
	public void inserir(int lin, int col, int elemento){
		try {
			Celula tmp = getNode(lin, col);
			tmp.elemento = elemento;
			tmp = null;
		} catch (Exception e) {
			System.out.println(e);
		} // end catch
	} // end inserir()

	/**
	 * - Metodo remove elemeto de matriz
	 * @param lin - linha matriz
	 * @param col - coluna matriz
	 * @return - elemento retirado
	 */
	public int remover(int lin, int col){
		int result = -1; 
		
		try {
			Celula tmp = getNode(lin, col);
			result = tmp.elemento; 
			tmp.elemento = -1;
		} catch (Exception e) {
			System.out.println(e);
		} // end catch

		return result;
	} // end remover()
} // end class Matrix()

public class Matrix_template_emJava{

	/**
	 * - Metodo para pegar a primeira parte da entrada e manipula a matriz.
	 */
	private static void getPrimeiraEntrada(){
		int loop, linha, coluna;

		loop = MyIO.readInt();
		while(loop > 0){	
			Matrix matrix_1, matrix_2, soma, multiplicacao;

			// entrada Matriz 1
			linha  = MyIO.readInt();
			coluna = MyIO.readInt();
			
			matrix_1 = new Matrix(linha, coluna);
			matrix_1.inserirElementos_padrao();
			
			
			// entrada Matriz 2
			linha  = MyIO.readInt();
			coluna = MyIO.readInt();
			
			matrix_2 = new Matrix(linha, coluna);
			matrix_2.inserirElementos_padrao();
			
			// soma matrizes
			try {
				// System.out.println("\n\ndiagonalPrincipal:");
				matrix_1.mostrar_DiagonalPrincipal();
				// System.out.println("\n\ndiagonalsecundaria:");
				matrix_1.mostrar_DiagonalSecundaria();
				// System.out.println("\nsoma:");
				soma = matrix_1.soma(matrix_2);
				soma.mostrar();
				// System.out.println("\n\nmultiplicacao:");
				multiplicacao = matrix_1.multiplicacao(matrix_2);
				multiplicacao.mostrar();
			} catch (Exception e) {
				System.out.println(e);
			} // end catch

			loop--;
		} // end while
	} // end getPrimeira Entrada()
	


	public static void main(String []arg){

		getPrimeiraEntrada();	
		
	} // end main()
}








