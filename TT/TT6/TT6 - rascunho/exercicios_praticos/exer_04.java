class exer_04{
	
	/**
	  * - Recebe array de inteiros, e os ordena de modo hibrido, insercao e binaria.
	  * @param array - array de inteiros a ser manipulada 
	  */
	static void insercao_binaria(int[] array){
		int temp, j, k, esq, dir, meio = 0;
		for(int i = 1; i < array.length; i++){
			temp = array[i];
			j = i - 1;
			

			if(array[j] > array[i]){
				dir = i; esq = 0;
				meio = (dir + esq)/2;
				while(dir > esq){
					if(array[meio] > array[i])
						dir = meio;
					else if(array[meio] < array[i])
						esq = meio + 1;
						
					meio = (dir + esq)/2;
				} // end while
				
				// desloca valores entre meio e i, 1 index.
				for(k = i; k > meio; k--){
					array[k] = array[k - 1];
				} // end for
				array[meio] = temp;
			}

			for(int o = 0; o < array.length; o++)
				System.out.print(array[o] + " ");
			System.out.println("\n ");		
		} // end for

	} // end insercao_binaria()

	public static void main(String []arg){
		int[] array = {12,4,8,2,14,17,6,18,10,16,15,5,13,9,1,11,7,3};
		insercao_binaria(array);
	} // end main()
}
