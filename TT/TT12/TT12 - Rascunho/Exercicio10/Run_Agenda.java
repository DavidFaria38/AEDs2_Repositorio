
public class Run_Agenda {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato = new Contato("favid", "email.com", 600, 121);
        Contato contato2 = new Contato("mavid", "email.com", 606, 122);
        Contato contato3 = new Contato("cavid", "email.com", 602, 123);
        // Contato contato = new Contato();
        
        agenda.inserir(contato); 
        agenda.inserir(contato2); 
        agenda.inserir(contato3); 
        
    } // end main()
}
