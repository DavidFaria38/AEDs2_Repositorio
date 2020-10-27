/*
Exercicio (1)
	Encontre o maior e menor valores em um array de inteiros e, em seguida, encontre a função de complexidade de tempo para sua solução.	
*/
// Faltando: fazer analize de complexidade do algoritmo


class Exer_01{

	static void findHigherLower(int[] array){
		int maior = array[0];
		int	menor = array[0];
		for(int i = 1; i < array.length; i++){
			if(maior < array[i])
				maior = array[i];
			else if(menor > array[i])
				menor = array[i];
		}
		System.out.println("Maior: " + maior + "\nMenor: " + menor);

	} // end findHigherLower()

	public static void main(String []arg){
		double start = System.currentTimeMillis();

		int[] array = {20,9,5,15,3,16,1,10,4,3,30,5,2,48,71,82};
		findHigherLower(array);

		System.out.printf("%.3f\n", (System.currentTimeMillis() - start));
	} // end main()
}


