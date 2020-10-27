// Considerando que o array estara em ordem crescente, fazer um metodo para encontrar um numero.
 
class tt2Q03{

	public static void higherLowerNum(int[] array){
	    int higher, lower;
        higher = array[0];
        lower  = array[0];
        for(int i = 1; i < array.length; i++){
            if(higher < array[i]){
                higher = array[i];
            }
            if(lower > array[i]){
                lower = array[i];
            }
        }
        MyIO.println("Maior = " + higher + "\nMenor = " + lower);
	} // higherLowerNum()

	public static void main(String []arg){
		int n = MyIO.readInt();
		int[] array = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = MyIO.readInt();
        higherLowerNum(array);		
	} // end main()
}
