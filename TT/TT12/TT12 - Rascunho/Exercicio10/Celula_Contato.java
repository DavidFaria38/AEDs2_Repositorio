
/**
 * Celula_Contato
 */
public class Celula_Contato { 
	public Contato contato;
	public Celula_Contato prox;
    
    public Celula_Contato(){
        contato = new Contato();
        prox = null;
    } // end Celula_Contato()

    public Celula_Contato(Contato contat){
        contato = new Contato(contat);
        prox = null;
    } // end Celula_Contato()

} // end class Celula_Contato