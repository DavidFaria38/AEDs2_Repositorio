public class PilhaComCabeca{
    private Celula topo;

    public PilhaComCabeca(){ 
        topo = new Celula();
        topo.prox = null;
    } // end Pilha()
    
    public void inserir(int value){
        Celula tmp = new Celula(value);
        tmp.prox = topo.prox;
        topo.prox = tmp;
        tmp = null;
    } // end inserir()

    public int remover() throws Exception{
        if(topo.prox == null) throw new Exception("Erro!");
        int elemento = topo.prox.elemento;
        Celula tmp = topo.prox;
        topo = topo.prox.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    } // end remover()

    public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		} // end for
		System.out.println("] ");
	} // end mostrar()
} // end class PilhaComCabeca