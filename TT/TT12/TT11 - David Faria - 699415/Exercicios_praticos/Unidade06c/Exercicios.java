/*
David de Sa Vieira de Faria - 699415
TT10 - unidade06b
*/


public class Exercicios {
    
    
    public static void main(String []arg) {
        Fila fila = new Fila();

        int i, j;
        for(i = 0 , j = 1; i < 10; i++, j*=2) fila.inserir(j);
        // fila.inserir(1); fila.inserir(2); fila.inserir(5); fila.inserir(9); 
            
        System.out.println("");
        fila.mostrar();
        System.out.println("");
        
        
        /* Exercicio - Slide 27 */
        try{
            System.out.println("Maior elemento: \t" + fila.getMaior());
        } catch(Exception e){
            System.out.println("Maior elemento: \t" + e);
        } // end catch
        

        /* Exercicio - Slide 29 */
        System.out.println("Terceiro elemento: \t" + fila.getThirdElement());
        

        /* Exercicio - Slide 31 */
        System.out.println("Soma dos elementos: \t" + fila.getSum());
        

        /* Exercicio - Slide 33 */
        // fila.inverter();
        // fila.mostrar();
        

        /* Exercicio - Slide 34 */
        System.out.println("Contar elementos %2=0 && %5=0: \t" + fila.countElements());
        

        /* Exercicio - Slide 38 */
        Fila newFila = new Fila();
        Pilha pilha = new Pilha();
        for(i = 0 , j = 1; i < 10; i++, j*=2) pilha.inserir(j);
        
        System.out.println("\nelementos Pilha: \t");
        pilha.mostrar();
        
        System.out.println("\nelementos Pilha -> Fila: \t");
        newFila = fila.fromPilhaInvertida_to_Fila(pilha.getTopo());
        newFila.mostrar();
        

        /* Exercicio - Slide 39 */
        FilaSemCabeca filaSemCabeca = new FilaSemCabeca();
        for(i = 0 , j = 1; i < 10; i++, j*=2) filaSemCabeca.inserir(j);
        System.out.println("\nElementos FilaSemCabeca: \t");
        filaSemCabeca.mostrar();
        

        /* Exercicio - Slide 40 */
        PilhaComCabeca pilhaComCabeca = new PilhaComCabeca();
        for(i = 0 , j = 1; i < 10; i++, j*=2) pilhaComCabeca.inserir(j);
        try{
            System.out.println("\nElementos PilhaComCabeca: \t");
            pilhaComCabeca.mostrar();
        } catch(Exception e){
            System.out.println("\nElementos PilhaComCabeca: \t" + e);
        } // end catch
        
    
    } // end main
    
} // end class Ecercicios