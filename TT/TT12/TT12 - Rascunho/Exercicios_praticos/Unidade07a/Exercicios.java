/*
David de Sa Vieira de Faria - 699415
TT11 - unidade07a
*/
import java.util.Random;

public class Exercicios {

    public static void treeSort(int[] array){
        ArvoreBinaria tree = new ArvoreBinaria();
        
        for(int i = 0; i < array.length; i++){
            try{
                tree.inserir(array[i]);
            } catch(Exception e){}
        } // end inserir

        tree.showArvore();
    } // end treeSort()

    public static No toArvoreBinaria(ListaSimples lS, ListaDupla lD){
        ArvoreBinaria tmp = new ArvoreBinaria(); 
		return tmp.toArvoreBinaria(lS.getPrimeiro().prox, lD.getPrimeiro().prox);
	} // end toArvoreBinaria()
    
    public static void main(String []arg) {
        int consVar = 7;

        int[] array = new int[consVar];
        ArvoreBinaria tree = new ArvoreBinaria();
        ArvoreBinaria tree2 = new ArvoreBinaria();

        ListaSimples listaSimples = new ListaSimples();
        ListaDupla   listaDupla   = new ListaDupla();
        ArvoreBinaria fromListaToTree = new ArvoreBinaria();

        for(int i = 1; i <= consVar; i++){
            try {
                listaSimples.inserirFim((int)(Math.random() * 50));
                listaDupla.inserirFim((int)(Math.random() * 50));
                array[i-1] = (int)(Math.random() * 50);
                tree.inserir(i);
                tree2.inserir(i+1);
            } catch (Exception e) {}   
        } // end for

        try {
            listaSimples.removerFim();
            listaSimples.removerFim();
        } catch (Exception e) {}

        System.out.print("\nTree1:  ");
        tree.showArvore();
        System.out.print("Tree2:  ");
        tree2.showArvore();
        System.out.print("\nListaS: ");
        listaSimples.mostrar();
        System.out.print("ListaD: ");
        listaDupla.mostrar();
        System.out.print("\n\n");
        
        /* Exercicio(1) - Slide 235 */
        System.out.println("Altura tree1 (arvore completa*): \t" + tree.getAltura());
        
        /* Exercicio(2) - Slide 236 */
        System.out.println("Soma elementos (tree1): \t\t" + tree.sumElementos());
        
        /* Exercicio(3) - Slide 237 */
        System.out.println("Soma elementos pares (tree1): \t\t" + tree.sumElementosPares());
        
        /* Exercicio(4) - Slide 238 */
        System.out.println("Tree1 e Tree2 iguais?: \t\t\t" + ArvoreBinaria.igual2(tree, tree2));
        
        /* Exercicio(5) - Slide 239 */
        System.out.println("Tree1 tem elemento divisivel por 11?: \t" + tree.div11());
        
        /* Exercicio(6) - Slide 240 */
        System.out.print("\nRand Array : \t");
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        System.out.print("\nTreesort: \t");
        treeSort(array);
        
        /* Exercicio(7) - Slide 241 */
        fromListaToTree.changeRaizTo(toArvoreBinaria(listaSimples, listaDupla));
        System.out.print("\nFrom Listas to Arvore Binaria: \t");
        fromListaToTree.showArvore();
        
        
        
        
        
        /* Exercicio(10) - Slide 444 */



    } // end main
    
    
} // end class Ecercicios