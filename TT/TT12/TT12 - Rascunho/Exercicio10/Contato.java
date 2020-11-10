/**
 * Contato
 */
public class Contato { 
	private String nome;
	private String email;
	private int    telefone;
	private int    cpf;

	public Contato(){
		nome = email = "";
		cpf = telefone = -1;
	} // end Contato()
	
	public Contato(String nomeVal, String emailVal, int telefoneVal, int cpfVal){
		nome = nomeVal; 
		email = emailVal;
		telefone = telefoneVal;
		cpf = cpfVal;
	} // end Contato()
	
	public Contato(Contato contat){
		nome = contat.getNome(); 
		email = contat.getEmail();
		telefone = contat.getTelefone();
		cpf = contat.getCpf();
	} // end Contato()

	public String getNome(){return nome;}
	public String getEmail(){return email;}
	public int getTelefone(){return telefone;}
	public int getCpf(){return cpf;}

	public void SetNome(String value){ this.nome = value;}
	public void SetEmail(String value){ this.email = value;}
	public void SetTelefone(int value){ this.telefone = value;}
	public void SetCpf(int value){ this.cpf = value;}
} // end class Celula