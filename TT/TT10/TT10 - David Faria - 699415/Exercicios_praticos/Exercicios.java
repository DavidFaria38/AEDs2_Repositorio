/*
David de Sa Vieira de Faria - 699415
TT10 - unidade06b
*/

class Celula{
    public int elemento;
    public Celula prox;

    public Celula(){ this(0);}
   
    public Celula(int value){
        this.elemento = value;
        this.prox = null;
    } // end celula()
} // end class Celula


class Pilha{
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

    // public int remover() throws Exception{
    public int remover(){
        // if(topo == null) throw new Exception("Erro!");
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    } // end remover()

    public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	} // end mostrar()

    /**
     * - Exercicios resolvido 1 
     * @return - soma
     */
    public int getSoma(){
        int soma = 0;
        for (Celula i = topo; i != null; i = i.prox) {
			soma += i.elemento;
        } // end for
        return soma;
    } // end getSoma()

    /**
     * - Exercicio(1)
     */
    public int getSoma_Recursiva(){
        return getSoma_Recursiva(topo);
    } // end getSoma_Recursiva()

    public int getSoma_Recursiva(Celula i){
        int soma = 0;
        if(i != null){
            soma += i.elemento;
            soma += getSoma_Recursiva(i.prox);
        } // end if
        return soma;
    } // end getSoma_Recursiva()


    /**
     * - Exercicios(2) 
     * @return - maior
     */
    public int getMaior(){
        int maior = 0;
        for (Celula i = topo; (i != null) && (maior < i.elemento); i = i.prox) {
			maior = i.elemento;
        } // end for
        return maior;
    } // end getSoma()


    /**
     * - Exercicio(3)
     */
    public int getMaior_Recursiva(){
        return getMaior_Recursiva(topo, 0);
    } // end getMaior_Recursiva()

    public int getMaior_Recursiva(Celula i, int maior){
        if(i != null){
            if(maior > i.elemento)
                maior = getMaior_Recursiva(i.prox, maior);
            else
                maior = getMaior_Recursiva(i.prox, i.elemento);
        } // end if
        return maior;
    } // end getMaior_Recursiva()


    /**
     * - Exercicio(4)
     */
    public void showPilha_remove_Recursiva(){
        System.out.print("[ ");
        showPilha_remove_Recursiva(topo);
        System.out.print("]\n");
    } // end showPilha_remove_Recursiva()

    public void showPilha_remove_Recursiva(Celula topo){
        if(topo != null){
            System.out.print(topo.elemento + " ");
            showPilha_remove_Recursiva(topo.prox);
        } // end if
    } // end showPilha_remove_Recursiva()


    /**
     * - Exercicio(5)
     */
    public void showPilha_inserir_Recursiva(){
        System.out.print("[ ");
        showPilha_inserir_Recursiva(topo);
        System.out.print("]\n");
    } // end showPilha_inserir_Recursiva()

    public void showPilha_inserir_Recursiva(Celula topo){
        if(topo != null){
            showPilha_inserir_Recursiva(topo.prox);
            System.out.print(topo.elemento + " ");
        } // end if
    } // end showPilha_inserir_Recursiva()
    

    /**
     * - Exercicio(6)
     */
    public void showPilha_inserir() {
        int n = 0, j = 0;
        
        for(Celula i = topo; i != null; i = i.prox)
            n++;

        int []tmp = new int[n];
        
        for(Celula i = topo; i != null; i = i.prox, j++){
            tmp[j] = i.elemento;
        } // end for
        
        System.out.print("[ ");
        for(int i = n-1; i >= 0; i--){
            System.out.print(tmp[i] +" ");
        } // end for
        System.out.print("] \n");
    } // end showPilha_inserir()
} // end class Pilha

public class Exercicios {

    public static void main(String []arg) {
        Pilha pilha = new Pilha();
        int i, j;
        for(i = 0 , j = 1; i < 10; i++, j*=2)
            pilha.inserir(j);
            
        System.out.println("");
        pilha.mostrar();
        System.out.println("");
        
        // System.out.println(pilha.remover() + " - " + pilha.remover());
        
        /* Exercicio Resolvido (1) */
        System.out.println("Soma            : " + pilha.getSoma());
        
        /* Exercicio (1) */
        System.out.println("Soma Recur      : " + pilha.getSoma_Recursiva());
        
        /* Exercicio (2) */
        System.out.println("Maior           : " + pilha.getMaior());
        
        /* Exercicio (3) */
        System.out.println("Maior_recursivo : " + pilha.getMaior_Recursiva());

        /* Exercicio (4) */
        System.out.print("Show_remover_recursivo : ");
        pilha.showPilha_remove_Recursiva();
        
        /* Exercicio (5) */
        System.out.print("Show_inserir_recursivo : ");
        pilha.showPilha_inserir_Recursiva();
        
        /* Exercicio (6) */
        System.out.print("Show_inserir           : ");
        pilha.showPilha_inserir();
    
    } // end main
    
}