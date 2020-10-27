/*
David de Sa Vieira de Faria - 699415
TT10 - unidade06b
*/


public class Exercicios {
    
    
    public static void main(String []arg) {
        Lista lista = new Lista();

        int i, j;
        for(i = 0 , j = 1; i < 10; i++, j*=2) lista.inserirInicio(j);
            
        System.out.println("");
        lista.mostrar();
        System.out.println("");
        
        
        /* Exercicio - Slide 55 */
        try{
            System.out.println("Removido segundo elemento da lista: " + lista.removeSecondValid());     
            lista.mostrar();
        } catch(Exception e){
            System.out.println(e);     
        } // end catch
    } // end main
    
} // end class Ecercicios