import java.util.Random;

class Exer3_Selecao{

	static int[] genRandomArray(int[] array){
		Random rand = new Random();
		rand.setSeed(0);
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt() % 1000;
//			MyIO.println(i + " : " + array[i]);			
		} // end for
		return array;
	} // end genRandArray()

	static int[] selecao(int[] array){
		int menor = 0, temp = 0;
		for(int i = 0; i < array.length - 1; i++){
			menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j])
					menor = j;
			} // end for

			temp = array[menor];
			array[menor] = array[i];
			array[i] = temp;
		} // end for
		return array;
	} // end selecao()

	static void printArray(int[] array){
/*		MyIO.println(" ");
		for(int i = 0; i < array.length; i++)
			MyIO.print(array[i] + " ");
		MyIO.println(" ");
*/
		int i = 0;
		i+=15;
	} // end printArray()

	public static void main(String []arg){
		int len = MyIO.readInt();
		int[] array = new int[len];
	
//		double start = System.currentTimeMillis(); // comecar antes da criacao random do array

		array = genRandomArray(array);
//		printArray(array);
		double start = System.currentTimeMillis();
	//	array = selecao(array);
//		printArray(array);
		for(int i = 0; i < 100; i++)
			if(array[i] > array[i+15])
				printArray(array);	
		System.out.printf("%f\n", (System.currentTimeMillis() - start)/ 1000);
	} // end main()
}
