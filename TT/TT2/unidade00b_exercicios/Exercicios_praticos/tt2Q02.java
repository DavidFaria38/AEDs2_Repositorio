// Considerando que o array estara em ordem crescente, fazer um metodo para encontrar um numero.
 
class tt2Q02{

	public static boolean isNumHere(int[] array, int find){
		boolean resp = false;
		int i;
		if(array[array.length/2] < find){
			for(i = array.length/2; i < array.length; i++){
				if(array[i] == find){ 
					resp = true;
				}
	               }
		}
		else if(array[array.length/2] > find){
			for(i = 0; i < array.length/2; i++){
				if(array[i] == find){
					resp = true; 
				}
			}
		}
		else{
			resp = true;
		}	

		return resp;
	}

	public static void main(String []arg){
		int n = MyIO.readInt();		// Tamanho da array e quant. de num a serem procurados
		int toFind;
		int[] array = new int[n];

		for(int i = 0; i < n; i++){
			array[i] = MyIO.readInt();
		}

		toFind = MyIO.readInt();
		
		MyIO.println(isNumHere(array, toFind));
	}
}
