
/**
 * No_Contato
 */
public class No_Contato {
	public Celula_Contato primeiro;
	public Celula_Contato ultimo;
	public No_Contato esq;
	public No_Contato dir;
    public char letra;
    
    public No_Contato() {
        primeiro = ultimo = null;
        esq = dir = null;
        letra = '\0';
    } // end No_Contato()
    
    public No_Contato(char c) {
        primeiro = ultimo = null;
        esq = dir = null;
        letra = c;
    } // end No_Contato()

    /**
     * Metodo que realiza a insercao de um contato em uma fila.
     * @param contat - Obejeto Contato a ser inserido.
     */
    public void inserirFila(Contato contat){
        if(primeiro == null){
            primeiro = new Celula_Contato();
            primeiro.prox = new Celula_Contato(contat);
            ultimo = primeiro.prox;
        } else{
            Celula_Contato i = primeiro.prox;
            for(; i.prox != null; i = i.prox);
            i.prox = new Celula_Contato(contat);
            ultimo = i.prox;
        } // end else
    } // end inserirFila()

    /**
     * Metodo realiza a pesquisa em uma lista, tendo sua key um nome
     * @param nome - nome a ser usado como key da pesquisa
     * @return - retorno da referencia da Celula_Contato ou null
     */
    public Celula_Contato searchForNome(String nome){
        return searchForNome(primeiro, nome);
    } // end searchForNome()

    public Celula_Contato searchForNome(Celula_Contato i, String nome){
        Celula_Contato resp = null;
        if(i.prox != null){
            if(i.prox.contato.getNome().equals(nome)){
                resp = i;
            } else{
                resp = searchForNome(i.prox, nome);
            } // end else
        } // end if
        return resp;
    } // end searchForNome()

    /**
     * Metodo para remover a primeiro referencia de um contato com nome igual ao parametro nome.
     * @param nome
     */
    public void removerContatoWithName(String nome){
        Celula_Contato noNome = searchForNome(nome);
        
        if(noNome == null){
            System.out.println("EROO: Nome nao encontrado.");
        } else{
            Celula_Contato tmp = noNome.prox;
            noNome = noNome.prox.prox;
            tmp.prox = null;
            tmp = null;
        } // end else
    } // end removerContatoWithName()


    /**
     * Metodo realiza a pesquisa em uma lista, tendo sua key um nome
     * @param nome - nome a ser usado como key da pesquisa
     * @return - retorno da referencia da Celula_Contato ou null
     */
    public boolean boolSearch(String nome){
        return boolSearch(primeiro, nome);
    } // end searchForNome()

    private boolean boolSearch(Celula_Contato i, String nome){
        boolean resp = false;
        if(i.prox != null){
            if(i.prox.contato.getNome().equals(nome)){
                resp = true;
            } else{
                resp = boolSearch(i.prox, nome);
            } // end else
        } // end if
        return resp;
    } // end searchForNome()

    /**
     * Metodo realiza a pesquisa em uma lista, tendo sua key um nome
     * @param nome - nome a ser usado como key da pesquisa
     * @return - retorno da referencia da Celula_Contato ou null
     */
    public boolean boolSearch(int cpf){
        return boolSearch(primeiro, cpf);
    } // end searchForNome()

    private boolean boolSearch(Celula_Contato i, int cpf){
        boolean resp = false;
        if(i != null){
            if(i.contato.getCpf() == cpf){
                resp = true;
            } else{
                resp = boolSearch(i.prox, cpf);
            } // end else
        } // end if
        return resp;
    } // end searchForNome()
} // end class No_Contato
