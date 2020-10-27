class tt2Q01{

	public static boolean isNumHere(int[] array, int n, int find){
		boolean resp = false;
		
		for(int i = 0; i < n; i++){
			if(array[i] == find){
				resp = true;
				i = n;
			} // end if()
		} // end for()
		return resp;
	} // end isNumHere()

	public static void main(String []arg){
		int n = MyIO.readInt();
		int toFind;
		int[] array = new int[n];

		for(int i = 0; i < n; i++){
			array[i] = MyIO.readInt();
		}
		toFind = MyIO.readInt();

		MyIO.println(isNumHere(array, n, toFind));
	}
}
