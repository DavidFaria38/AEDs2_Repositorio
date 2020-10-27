/*
David de Sa Vieira de Faria - 699415
TT10 - unidade06b
*/


public class Exercicios {
    
    
    public static void main(String []arg) {
        ListaDupla listaDupla = new ListaDupla();
        Lista listaSimples = new Lista();

        int i, j;
        for(i = 0 , j = 1; i < 11; i++, j*=2) listaDupla.inserirInicio(j);
        for(i = 0 , j = 1; i < 11; i++, j*=2) listaSimples.inserirInicio(j);
            
        System.out.print("Lista dupla:\t");
        listaDupla.mostrar();
        System.out.print("Lista simples:\t");
        listaSimples.mostrar();
        System.out.println("");
        
        
        /* Exercicio - Slide 32 */
        System.out.print("Lista dupla   - invertida:\t");
        listaDupla.inverterListaDupla();
        listaDupla.mostrar();
        
        /* Exercicio - Slide 34 */
        System.out.print("Lista simples - invertida:\t");
        listaSimples.inverterListaSimples();
        listaSimples.mostrar();

    } // end main
    
} // end class Ecercicios