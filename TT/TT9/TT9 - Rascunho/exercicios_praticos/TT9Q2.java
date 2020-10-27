class Deque{

	private int dir, esq;
	private int[] cards;
	
	// construtor
	public Deque(int[] card){
		cards = card;
		dir = cards.length - 1;
		esq = 0;
	} // end Cards()

	
	public void inserirDir(int novoElemento){
		try{
			cards[dir + 1] = novoElemento;
			dir++;
		} catch(ArrayIndexOutOfBoundsException e){
			if((dir + 1) == cards.length)
				System.out.println("Erro: OverFlow");
		} // end catch
	} // end inserirDir()
	
	public void inserirEsq(int novoElemento){
		try{
			cards[esq - 1] = novoElemento;
			esq--;	
		} catch(ArrayIndexOutOfBoundsException e){
			if(esq == 0)
				System.out.println("Erro: OverFlow");
		}
	} // end inserirEsq()
	
	public void removerDir(){
		try{
			if(dir >= esq){
				cards[dir] = -1;
				dir -= 1;
			} else{
				System.out.println("Erro: UnderFlow");
			} // end else
		} catch(ArrayIndexOutOfBoundsException e){
			if(dir == esq)
				System.out.println("Erro: UnderFlow");
		}
	} // end removerDir()
	
	public void removerEsq(){
		try{
			if(dir >= esq){
				cards[esq] = -1;
				esq += 1;	
			} else{
				System.out.println("Erro: UnderFlow");
			} // end else
		} catch(ArrayIndexOutOfBoundsException e){
			if(dir == esq)
				System.out.println("Erro: UnderFlow");
		}
	} // end removerEsq()

	public void print(){
		for(int i = esq; i <= dir; i++)
			System.out.print(cards[i] + " ");
		System.out.println("");
	} // end print()
} // end Deque

class TT9Q2{

	public static void main(String []arg){
		int option, value;
		int[] array = {10, 15, 77, 65, 12, 0, 8, 16};
		
		Deque card = new Deque(array);
		
		card.print();
		do{
			option = MyIO.readInt();

			switch(option){
				case 0:						// exit
					break;
				case 1:						// removerEsq
					card.removerEsq();
					break;
				case 2:						// removerDir
					card.removerDir();	
					break;
				case 4:						// inserirEsq
					value = MyIO.readInt();
					card.inserirEsq(value);	
					break;
				case 5:						// inserirDir
					value = MyIO.readInt();
					card.inserirDir(value);
					break;
				case 3:						// print
					card.print();
					break;
				default:					// Error
					System.out.println("ERRO: Opcao invalida.");
					break;
			} // end switch
		}while(option != 0);
			
	} // end main()
}
