class tt2Q04{

	public static void higherLowerNum(int[] array){
	    int higher, lower, temp = array[0];
        higher = temp;
        lower  = temp;        
        for(int i = 1; i < array.length; i++){
            if(higher < temp)
                higher = temp;
            if(lower > temp)
                lower = temp;
            temp = array[i];
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
