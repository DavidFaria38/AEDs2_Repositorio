public class Pilha{
    private Celula topo;

    public Pilha(){ 
        topo = null;
    } // end Pilha()
    
    public void inserir(int value){
        Celula tmp = new Celula(value);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    } // end inserir()

    public int getElemento(){
        return topo.elemento;
    } // end getElemento
    public Celula getTopo(){
        return topo;
    } // end getElemento

    public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	} // end mostrar()
} // end class Pilha