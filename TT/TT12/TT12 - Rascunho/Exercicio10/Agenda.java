
public class Agenda {
	private No_Contato raiz; 

	public Agenda(){
		raiz = new No_Contato('M');
		raiz.esq = new No_Contato('F');
		raiz.dir = new No_Contato('T');
		raiz.esq.esq = new No_Contato('C');
	} // end Agenda()


	public No_Contato pesquisarLetra(char c){
		return pesquisarLetra(raiz, c);
	} // end pesquisarLetra()
	public No_Contato pesquisarLetra(No_Contato i, char c){
		No_Contato result = null;;
		if(i != null){
			if(c == i.letra){
				result = i;
			} else if(c < i.letra){
				result = pesquisarLetra(i.esq, c);
			} else if(c > i.letra){
				result = pesquisarLetra(i.dir, c);
			}
		} // end if 

		return result;
	} // end pesquisarLetra()


	public void inserir(Contato contato){
		char letraInicial = contato.getNome().toUpperCase().charAt(0);
		No_Contato letraNo = pesquisarLetra(letraInicial);


		if(letraNo == null){
			System.out.println("ERRO.Inserir: letra nao encontrada.");
		} else{
			letraNo.inserirFila(contato);
		} // end else
	} // end inserir()
	
	public void remover(String nome){
		char letraInicial = nome.toUpperCase().charAt(0);
		No_Contato letraNo = pesquisarLetra(letraInicial);
		
		if(letraNo == null){
			System.out.println("ERRO.Remover: letra nao encontrada.");
		} else{
			letraNo.removerContatoWithName(nome);
		} // end else
	} // end remover()

	public boolean pesquisar(String nome){
		boolean resp = false;
		char letraInicial = nome.toUpperCase().charAt(0);
		No_Contato letraNo = pesquisarLetra(letraInicial);

		if(letraNo == null){
			System.out.println("ERRO.pesquisar: letra nao encontrada.");
		} else{
			resp = letraNo.boolSearch(nome);
		} // end else

		return resp;
	} // end pesquisar()


	public boolean pesquisarCpf(No_Contato i, int cpf){
		boolean resp = false;
		boolean resp1 = false;
		boolean resp2 = false;
		if(i != null){
			resp = i.boolSearch(cpf);
			if(resp == false){
				resp1 = pesquisarCpf(i.esq, cpf);
				resp2 = pesquisarCpf(i.dir, cpf);
				resp = resp1 || resp2;
			} // end if
		} // end if 

		return resp;
	} // end pesquisarCpf()


	public boolean pesquisar(int cpf){
		return pesquisarCpf(raiz, cpf);
	} // end pesquisar()
	
	
	


}