/*
David de Sa Vieira de Faria - 699415
TT11 - unidade07a
*/
import java.util.Random;

public class Exercicios {
    
    
    public static void main(String []arg) {
        int rand = 0;
        ArvoreBinaria tree = new ArvoreBinaria();
        ArvoreBinaria tree2 = new ArvoreBinaria();

        for(int i = 1; i <= 7; i++){
            try {
                tree.inserir(i);
                tree2.inserir(i+1);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.print("-1 ");
            }   
        }
        System.out.print("\n");
        tree.showArvore();
        System.out.print("\n");
        
        /* Exercicio(1) - Slide 235 */
        System.out.println("Altura (arvore completa*): " + tree.getAltura());
        
        /* Exercicio(2) - Slide 236 */
        System.out.println("Soma elementos tree: " + tree.sumElementos());
        
        /* Exercicio(3) - Slide 237 */
        System.out.println("Soma elementos pares: " + tree.sumElementosPares());
        
        /* Exercicio(4) - Slide 238 */
        System.out.println("Trees iguais?: " + ArvoreBinaria.igual2(tree, tree2));
        
        /* Exercicio(5) - Slide 239 */
        System.out.println("Tree possui elemento divisivel por 11?: " + tree.div11());

    
    } // end main
    
} // end class Ecercicios