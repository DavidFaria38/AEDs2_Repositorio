class jao{
	
	static boolean recur(String str, int i, int j){
		boolean resp = true;
		if(i < j){
			if(str.charAt(i) == str.charAt(j))
				recur(str, i++,j--)
			else
				resp = false;
		}
		return resp;
	} 

	static boolean recur(String str){
		return(recur(str, 0, str.length() - 1));
	}

	static void getLines(){
		String str = MyIO.readLine();
//		if(!isfim){
			recur(str);
			
			getLines();
//		}
	}

	public static void main(String []arg){
		getilines();
	}
}
