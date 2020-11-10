public class ListaLinear{
    private Jogador[] array;
    private int tamanho;
 
    /* ============ (Inicio) Construtores ============  */
    
    ListaLinear(int len){
        this.array = new Jogador[len];
        this.tamanho = 0;
    } // end ListaLinear()
    
    ListaLinear(){
        this(0);
    } // end ListaLinear()
    
    /* ============= (Fim) Construtores ============== */
    
    public void sub(){
        this.tamanho--;
        System.out.println(tamanho);
    }


    public void mostrar(){
        for(int i = 0; i < this.tamanho; i++){
            array[i].imprimir();
            System.out.println("");
        } // end for
    } // end mostrar()

    /* =============================================== */
    /* =============== (Inicio) Inserir ============== */
    /* =============================================== */

    public void inserirInicio(Jogador player) throws Exception {
        if(this.tamanho >= array.length)
            throw new Exception("ERRO: lista esta cheia.");
        else{
            
            for(int i = this.tamanho; i > 0; i--)
                array[i] = array[i-1]; 

            array[0] = player.clone();
            this.tamanho += 1;
        } // end else
    } // end inserirInicio ()

    public void inserir(Jogador player, int posicao) throws Exception {
        if(this.tamanho >= this.array.length)
            throw new Exception("ERRO: lista esta cheia.");
        else if((posicao >= this.tamanho) && (posicao < 0))
            throw new Exception("ERRO: posicao invalida.");
        else{

            for(int i = this.tamanho; i < posicao; i--)
                array[i] = array[i-1];
            
            array[posicao] = player.clone();
            this.tamanho += 1; 
        } // end else
    } // end inserir ()

    public void inserirFim(Jogador player) throws Exception {
        if(this.tamanho >= array.length)
            throw new Exception("ERRO: lista esta cheia.");
        else{
            array[this.tamanho] = player.clone();
            this.tamanho += 1;
        } // end else
    } // end inserirFim ()

    /* ============================================= */
    /* =============== (Fim) Inserir =============== */
    /* ============================================= */


    /* ============================================= */
    /* ============= (Inicio) Remover ============== */
    /* ============================================= */
    
    public Jogador removerInicio() throws Exception {
        Jogador tmp = null;

        if(this.tamanho < 0)
            throw new Exception("ERRO: Lista esta vazia.");
        
        if(this.tamanho >= 0){
            int i = 0;
            for(i = this.tamanho; i > 0; i--)
                System.out.println("" + i);
            //     array[i]  = array[i+1];
            // tmp = this.array[0];
            // this.array[0] = null;
        } 
        return tmp;
    } // end removerInicio()

    public Jogador remover(int posicao) throws Exception{
        return null;
    } // end remover()
    
    public Jogador removerFim(){
        Jogador tmp = null;

        if(this.tamanho < 0)
            // throw new Exception("ERRO: Lista esta vazia.");
            System.out.println("ERRO: Lista esta vazia.");
        else{
            tmp = this.array[this.tamanho - 1];
            System.out.println("array[x]: " + this.array[this.tamanho - 1].getNome() + " | tamanho: " + tamanho);
            this.array[this.tamanho - 1] = null;
            this.tamanho = this.tamanho - 1;
            System.out.println("tamanho verificacao: " + tamanho);
        } // end else

        return tmp;
    } // end removerFim()
    
    /* ============================================= */
    /* =============== (Fim) Remover =============== */
    /* ============================================= */

} // end class ListaLinear()